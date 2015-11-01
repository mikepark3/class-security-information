import java.security.*;
import java.security.spec.*;
import javax.crypto.*;
import javax.crypto.spec.*;
import javax.xml.bind.DatatypeConverter;

public class AES_hw{
	public static void main(String[] args) throws Exception {
		try{
			//To create an AES key, we have to instantiate a KeyGenerator for AES.
			//Since we do not initialize the KeyGenerator, a system-provided source of randomness and a default keysize will be used to create the AES key:
			KeyGenerator keygen = KeyGenerator.getInstance("AES");
			SecretKey aesKey = keygen.generateKey();

			// Get base64 encoded version of the key for print
			String encodedKey = DatatypeConverter.printBase64Binary(aesKey.getEncoded());

			// Create the cipher object for AES in ECB mode and PKCS5 padding
			Cipher aesCipher;
			aesCipher = Cipher.getInstance("AES/ECB/PKCS5Padding");

			//We use the generated aesKey from above to initialize the Cipher object for encryption:
			// Initialize the cipher for encryption
			aesCipher.init(Cipher.ENCRYPT_MODE, aesKey);

			// Our cleartext
			byte[] cleartext = "This is an AES homework".getBytes();

			// Encrypt the cleartext
			byte[] ciphertext = aesCipher.doFinal(cleartext);

			/* Send the ciphertext */

			// Initialize the same cipher for decryption
			aesCipher.init(Cipher.DECRYPT_MODE, aesKey);

			// Decrypt the ciphertext
			byte[] cleartext1 = aesCipher.doFinal(ciphertext);

			// Print results
			System.out.println("original plain text : " + new String(cleartext));
			System.out.println("chiper text : " + new String(ciphertext));
			System.out.println("decryption plain text : " + new String(cleartext1));
			System.out.println("encoded secret key : " + encodedKey);
		}
		catch(Exception e){
			System.out.println(e);
		}
	}
}
