"""Credential fixtures are assembled at runtime and are not real secrets."""
import unittest
from publish_source import sanitize_text, remaining_credentials


class SourcePublicationControls(unittest.TestCase):
    def test_google_key_redacted(self):
        key = "AIza" + "x" * 35
        result, counts = sanitize_text('String value = "' + key + '";')
        self.assertNotIn(key, result)
        self.assertEqual(counts["google-api-key"], 1)
        self.assertFalse(remaining_credentials(result))

    def test_base64_encoded_key_redacted(self):
        import base64
        key = "AIza" + "y" * 35
        encoded = base64.b64encode(key.encode()).decode()
        self.assertIn("base64-encoded-credential", remaining_credentials(encoded))
        result, counts = sanitize_text('String encodedValue = "' + encoded + '";')
        self.assertNotIn(encoded, result)
        self.assertEqual(counts["base64-encoded-credential"], 1)
        self.assertFalse(remaining_credentials(result))

    def test_named_xml_setting_redacted(self):
        result, counts = sanitize_text('<string name="client_secret">synthetic-value</string>')
        self.assertIn('name="client_secret"', result)
        self.assertNotIn("synthetic-value", result)
        self.assertIn("REDACTED_CLIENT_CONFIGURATION", result)

    def test_private_key_block_redacted(self):
        marker = "-----BEGIN " + "PRIVATE KEY-----"
        end = "-----END " + "PRIVATE KEY-----"
        result, counts = sanitize_text(marker + "\n" + "A" * 80 + "\n" + end)
        self.assertEqual(counts["private-key"], 1)
        self.assertNotIn("A" * 80, result)

    def test_assignment_redacted(self):
        result, counts = sanitize_text('    private final String apiKey = "synthetic-config-value";')
        self.assertNotIn("synthetic-config-value", result)
        self.assertEqual(counts["named-java-configuration"], 1)

    def test_to_string_label_is_not_an_assignment(self):
        source = 'return "AutoValue{refreshToken=" + this.refreshToken + ", expiresIn=" + this.expiresIn + "}";'
        result, counts = sanitize_text(source)
        self.assertEqual(result, source)
        self.assertFalse(counts)

    def test_private_artifact_link_omitted(self):
        url = "https://drive.google.com/file/d/" + "synthetic-id" + "/view"
        result, counts = sanitize_text('[private artifact](' + url + ')')
        self.assertNotIn(url, result)
        self.assertIn("private artifact", result)
        self.assertEqual(counts["private-drive-link"], 1)


if __name__ == "__main__":
    unittest.main()
