import java.security.*;
import java.security.spec.*;
import javax.crypto.*;
import javax.crypto.spec.*;
import java.io.*;
import java.nio.file.*;

public class AES_enc{
	/**
	* Makes a cipher text file from plain text file.
	*
	* @param  args[1]  plain text file name
	* @param  args[2]  key value of AES
	*/
	public static void main(String[] args) throws Exception {
		try{
			// Read a plain text file as a byte array
			byte[] cleartext = Files.readAllBytes(Paths.get(args[0]));

			// Create an AES key
			SecretKey aesKey = new SecretKeySpec(args[1].getBytes(), "AES");

			// Create the cipher object for AES in ECB mode and PKCS5 padding
			Cipher aesCipher;
			aesCipher = Cipher.getInstance("AES/ECB/PKCS5Padding");

			// Initialize the cipher for encryption
			aesCipher.init(Cipher.ENCRYPT_MODE, aesKey);

			// Encrypt the cleartext
			byte[] ciphertext = aesCipher.doFinal(cleartext);

			// Write a cipherText file
			FileOutputStream out = new FileOutputStream("cipherText");
			out.write(ciphertext);
			out.close();
		}
		catch(Exception e){
			System.out.println(e);
		}
	}
}
