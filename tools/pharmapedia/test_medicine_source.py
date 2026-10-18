"""No real medicine data or backend credentials are used by these tests."""
from pathlib import Path
import sys
import tempfile
import unittest
from unittest.mock import patch

from locate_medicine_data import inspect_source, main


class MedicineSourceControls(unittest.TestCase):
    def test_unrecognized_input_rejected(self):
        with tempfile.TemporaryDirectory() as temp:
            source = Path(temp) / "fixture.xapk"
            source.write_bytes(b"synthetic archive fixture, not medicine records")
            with self.assertRaises(ValueError):
                inspect_source(source)

    def test_existing_evidence_not_overwritten(self):
        with tempfile.TemporaryDirectory() as temp:
            evidence = Path(temp) / "existing.json"
            evidence.write_text("preserve this file")
            argv = ["locate_medicine_data.py", "--input", str(Path(temp) / "unused.xapk"),
                    "--evidence", str(evidence)]
            with patch.object(sys, "argv", argv), patch("locate_medicine_data.inspect_source", return_value={}):
                with self.assertRaises(FileExistsError):
                    main()
            self.assertEqual(evidence.read_text(), "preserve this file")
            self.assertFalse(list(Path(temp).glob("*.db")))


if __name__ == "__main__":
    unittest.main()
