"""Safety controls using synthetic archives/text only; no real app data needed."""
import io
from pathlib import Path
import stat
import tempfile
import unittest
import zipfile

from lxml import html
from recover_xapk import check_archive, safe_relative, spreadsheet_safe, render_viewer, recover


class PackageControls(unittest.TestCase):
    def test_safe_paths(self):
        self.assertEqual(safe_relative("res/drawable/icon.png"), Path("res/drawable/icon.png"))
        for name in ("../escape", "/absolute", "a/../../escape", "a\\escape", "C:/escape", "x\0y"):
            with self.subTest(name=name), self.assertRaises(ValueError):
                safe_relative(name)

    def test_valid_zip_crc(self):
        buf = io.BytesIO()
        with zipfile.ZipFile(buf, "w") as archive:
            archive.writestr("folder/file.txt", "synthetic fixture")
        with zipfile.ZipFile(io.BytesIO(buf.getvalue())) as archive:
            check_archive(archive)

    def test_traversal_zip_rejected(self):
        buf = io.BytesIO()
        with zipfile.ZipFile(buf, "w") as archive:
            archive.writestr("../escape.txt", "fixture")
        with zipfile.ZipFile(io.BytesIO(buf.getvalue())) as archive:
            with self.assertRaises(ValueError):
                check_archive(archive)

    def test_symlink_zip_rejected(self):
        info = zipfile.ZipInfo("link")
        info.create_system = 3
        info.external_attr = (stat.S_IFLNK | 0o777) << 16
        buf = io.BytesIO()
        with zipfile.ZipFile(buf, "w") as archive:
            archive.writestr(info, "../outside")
        with zipfile.ZipFile(io.BytesIO(buf.getvalue())) as archive:
            with self.assertRaises(ValueError):
                check_archive(archive)

    def test_oversized_member_rejected_before_read(self):
        info = zipfile.ZipInfo("large.bin")
        info.file_size = 129 * 1024 * 1024
        class HeaderOnlyArchive:
            def infolist(self):
                return [info]
        with self.assertRaises(ValueError):
            check_archive(HeaderOnlyArchive())

    def test_spreadsheet_formula_escaping(self):
        for text in ("=1+1", "+1", "-1", "@sum(A1)", "  =1", "\ttext"):
            self.assertEqual(spreadsheet_safe(text), "'" + text)
        for text in ("ordinary text", "", "دوائی", "docId"):
            self.assertEqual(spreadsheet_safe(text), text)

    def test_offline_viewer_escapes_untrusted_resource_text(self):
        with tempfile.TemporaryDirectory() as temp:
            root = Path(temp)
            render_viewer(root, {"apk_components": [], "java_approximations": 0},
                          [("fixture", "</td><script>alert(1)</script>")], [])
            text = (root / "index.html").read_text()
            tree = html.fromstring(text)
            self.assertEqual(len(tree.xpath("//script")), 1)  # Only the authored local search.
            self.assertIn("&lt;script&gt;alert(1)&lt;/script&gt;", text)
            self.assertFalse(tree.xpath('//*[@src and starts-with(@src,"http")]'))

    def test_wrong_input_hash_fails_without_creating_output(self):
        with tempfile.TemporaryDirectory() as temp:
            source = Path(temp) / "wrong.xapk"
            source.write_bytes(b"not the supplied app")
            output = Path(temp) / "returned"
            with self.assertRaises(ValueError):
                recover(source, output, Path("unused-cli"))
            self.assertFalse(output.exists())


if __name__ == "__main__":
    unittest.main()
