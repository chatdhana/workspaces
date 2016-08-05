package cryptography;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;

import javax.crypto.Cipher;
import javax.crypto.CipherOutputStream;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;

public class FileCrypt {

	public static void main(String[] args) throws IOException {
		
		if(args.length==1) {
			System.out.println(args[0]);
		}
		
		
		SecretKey key;
		try {
			key = KeyGenerator.getInstance("Blowfish").generateKey();

			new FileCrypt().encrypt(findFile(
					"C:/Documents and Settings/dgovindan/Desktop",
					"account.txt"),
					findFile("C:/Documents and Settings/dgovindan/Desktop",
							"account.sh"), key);
			
			new FileCrypt().decrypt(findFile(
					"C:/Documents and Settings/dgovindan/Desktop",
					"account.sh"),
					findFile("C:/Documents and Settings/dgovindan/Desktop",
							"account_2.txt"), key);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}

	}

	private static File findFile(String filePath, String fileName)
			throws IOException {
		File file = new File(filePath + "/" + fileName);
		if (!file.exists()) {
			file.createNewFile();
		}
		return file;
	}

	private void encrypt(File fileIN, File fileOUT, Key key) throws IOException {
		System.out.println("File encryption started...");
		FileInputStream in = null;
		CipherOutputStream out = null;
		try {
			Cipher encry = Cipher.getInstance("Blowfish/ECB/PKCS5Padding");
			encry.init(Cipher.ENCRYPT_MODE, key);
			in = new FileInputStream(fileIN);
			out = new CipherOutputStream(new FileOutputStream(fileOUT), encry);
			int i;
			byte[] b = new byte[1024];
			while ((i = in.read(b)) != -1) {
				out.write(b, 0, i);
			}
			System.out.println("File encryption Completed.");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (NoSuchPaddingException e) {
			e.printStackTrace();
		} catch (InvalidKeyException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (in != null)
				in.close();
			if (out != null)
				out.close();
		}
	}
	private void encrypt(File fileIN, Key key) throws IOException {
		
		String inFile=fileIN.getName();
		String outFile="Encrypted_"+inFile;
		System.out.println("File encryption started...");
		System.out.println("Input File (to be encrypted): "+inFile);
		System.out.println("Output File (encrypted): "+outFile);
		
		new File("Encrypted_"+fileIN.getName());
		FileInputStream in = null;
		CipherOutputStream out = null;
		try {
			Cipher encry = Cipher.getInstance("Blowfish/ECB/PKCS5Padding");
			encry.init(Cipher.ENCRYPT_MODE, key);
			in = new FileInputStream(fileIN);
			out = new CipherOutputStream(new FileOutputStream(new File(outFile)), encry);
			int i;
			byte[] b = new byte[1024];
			while ((i = in.read(b)) != -1) {
				out.write(b, 0, i);
			}
			System.out.println("File encryption Completed.");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (NoSuchPaddingException e) {
			e.printStackTrace();
		} catch (InvalidKeyException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (in != null)
				in.close();
			if (out != null)
				out.close();
		}
	}

	private void decrypt(File fileIN, File fileOUT, Key key) throws IOException {
		System.out.println("File decryption started...");
		FileInputStream in = null;
		CipherOutputStream out = null;
		try {
			Cipher decry = Cipher.getInstance("Blowfish/ECB/PKCS5Padding");
			decry.init(Cipher.DECRYPT_MODE, key);
			in = new FileInputStream(fileIN);
			out = new CipherOutputStream(new FileOutputStream(fileOUT), decry);
			int i;
			byte[] b = new byte[1024];
			while ((i = in.read(b)) != -1) {
				out.write(b, 0, i);
			}
			System.out.println("File decryption completed.");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (NoSuchPaddingException e) {
			e.printStackTrace();
		} catch (InvalidKeyException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (in != null)
				in.close();
			if (out != null)
				out.close();
		}
	}

}
