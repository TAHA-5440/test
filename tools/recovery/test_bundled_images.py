"""Synthetic fixtures only: no user images, app binaries, or recovered keys."""
import ctypes
import io
from pathlib import Path
import shutil
import struct
import tempfile
import unittest
import zlib

from PIL import Image
from recover_bundled_images import AssetDecoder, BUILD_TAG, compile_decoder


class BundledImageControls(unittest.TestCase):
    @classmethod
    def setUpClass(cls):
        if shutil.which("cc") is None:
            raise unittest.SkipTest("C compiler unavailable")
        cls.directory = tempfile.TemporaryDirectory()
        library = Path(cls.directory.name) / "own_fixture_codec.so"
        compile_decoder(library)
        cls.decoder = AssetDecoder(library, bytes(range(32)))
        buffer = io.BytesIO()
        Image.new("RGB", (12, 9), (20, 80, 140)).save(buffer, format="PNG")
        cls.png = buffer.getvalue()

    @classmethod
    def tearDownClass(cls):
        cls.directory.cleanup()

    def wrap(self, data, compressed=False, declared_length=None):
        a, b = 0x12345678, 0x24681357
        kind = 0x64787064 if compressed else 0x64787073
        header = struct.pack("<4I", a, b, a ^ kind, b ^ BUILD_TAG)
        payload = data
        if compressed:
            compressor = zlib.compressobj(wbits=-15)
            payload = compressor.compress(data) + compressor.flush()
            header += struct.pack("<I", len(data) if declared_length is None else declared_length)
        encrypted = self.decoder.xor(payload, struct.pack("<III", BUILD_TAG, a, b))
        return header + encrypted

    def test_plain_png_preserved(self):
        result, protected, dimensions = self.decoder.decode(self.png)
        self.assertEqual(result, self.png)
        self.assertFalse(protected)
        self.assertEqual(dimensions, (12, 9))

    def test_wrapped_png_preserved(self):
        result, protected, dimensions = self.decoder.decode(self.wrap(self.png))
        self.assertEqual(result, self.png)
        self.assertTrue(protected)
        self.assertEqual(dimensions, (12, 9))

    def test_compressed_wrapper_preserved(self):
        result, protected, dimensions = self.decoder.decode(self.wrap(self.png, compressed=True))
        self.assertEqual(result, self.png)
        self.assertTrue(protected)
        self.assertEqual(dimensions, (12, 9))

    def test_wrong_size_rejected(self):
        with self.assertRaises(ValueError):
            self.decoder.decode(self.wrap(self.png, compressed=True, declared_length=len(self.png) + 1))

    def test_wrong_tag_rejected(self):
        wrapped = bytearray(self.wrap(self.png))
        wrapped[12] ^= 1
        with self.assertRaises(ValueError):
            self.decoder.decode(bytes(wrapped))

    def test_corrupted_png_not_delivered(self):
        damaged = bytearray(self.png)
        damaged[20] ^= 1  # Corrupt IHDR data without changing its stored CRC.
        with self.assertRaises((ValueError, OSError, SyntaxError)):
            self.decoder.decode(self.wrap(bytes(damaged)))


if __name__ == "__main__":
    unittest.main()
