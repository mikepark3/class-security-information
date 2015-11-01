import java.security.*;
import java.security.spec.*;
import javax.crypto.*;
import javax.crypto.spec.*;
import java.io.*;
import java.nio.file.*;

public class AES_dec{
        /**
        * Makes a plain text file from cipher text file.
        *
        * @param  args[1]  cipher text file name
        * @param  args[2]  key value of AES
        */

	public static void main(String[] args) throws Exception {
		try{
			// Read a cipher text file as a byte array 
                        byte[] ciphertext = Files.readAllBytes(Paths.get(args[0]));

                        // Create an AES key
                        SecretKey aesKey = new SecretKeySpec(args[1].getBytes(), "AES");

                        // Create the cipher object for AES in ECB mode and PKCS5 padding
                        Cipher aesCipher;
                        aesCipher = Cipher.getInstance("AES/ECB/PKCS5Padding");

			// Initialize the cipher for decryption
			aesCipher.init(Cipher.DECRYPT_MODE, aesKey);

			// Decrypt the ciphertext
			byte[] cleartext = aesCipher.doFinal(ciphertext);

			// Write a plain text file
                        PrintWriter out = new PrintWriter("plainText1");
                        out.print(new String(cleartext));
                        out.close();

		}
		catch(Exception e){
			System.out.println(e);
		}
	}
}
