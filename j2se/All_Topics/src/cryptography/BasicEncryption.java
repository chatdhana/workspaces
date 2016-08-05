package cryptography;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;

import sun.misc.BASE64Decoder;

public class BasicEncryption {

	public static void main(String[] args) {
		Key key;
		try {
			key = KeyGenerator.getInstance("DES").generateKey();
			new BasicEncryption()
					.encrypt(
							"C:/Documents and Settings/dgovindan/Desktop/Plain1.txt",
							"C:/Documents and Settings/dgovindan/Desktop/Plain1_Encrypted.txt",
							key);

			new BasicEncryption()
					.decrypt(
							"C:/Documents and Settings/dgovindan/Desktop/Plain1_Encrypted.txt",
							"C:/Documents and Settings/dgovindan/Desktop/Plain1_Decrypted.txt",
							key);

		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}

	}

	public static void main2(String[] args) {
		try {

			// To encrypt
			Cipher encry = Cipher.getInstance("DES");
			Key key = KeyGenerator.getInstance("DES").generateKey();
			encry.init(Cipher.ENCRYPT_MODE, key);
			byte[] cipherText = encry.doFinal("This is a plain text!"
					.getBytes());
			System.out.println("cipherText:" + new String(cipherText));

			// To Decrypt
			Cipher decry = Cipher.getInstance("DES");
			encry.init(Cipher.DECRYPT_MODE, key);
			byte[] plainText = encry.doFinal(cipherText);
			System.out.println("plainText:" + new String(plainText));

		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (NoSuchPaddingException e) {
			e.printStackTrace();
		} catch (InvalidKeyException e) {
			e.printStackTrace();
		} catch (IllegalBlockSizeException e) {
			e.printStackTrace();
		} catch (BadPaddingException e) {
			e.printStackTrace();
		}

	}

	private void encrypt(String fileNameIN, String fileNameOUT, Key key) {
		try {
			Cipher encry = Cipher.getInstance("DES");
			encry.init(Cipher.ENCRYPT_MODE, key);
			byte[] cipherText = encry.doFinal(readFile2(fileNameIN));
			writedFile(cipherText, fileNameOUT);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (NoSuchPaddingException e) {
			e.printStackTrace();
		} catch (InvalidKeyException e) {
			e.printStackTrace();
		} catch (IllegalBlockSizeException e) {
			e.printStackTrace();
		} catch (BadPaddingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void decrypt(String fileNameIN, String fileNameOUT, Key key) {
		try {
			Cipher encry = Cipher.getInstance("DES");
			encry.init(Cipher.DECRYPT_MODE, key);
			byte[] plainText = encry.doFinal(readFile2(fileNameIN));
			writedFile(plainText, fileNameOUT);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (NoSuchPaddingException e) {
			e.printStackTrace();
		} catch (InvalidKeyException e) {
			e.printStackTrace();
		} catch (IllegalBlockSizeException e) {
			e.printStackTrace();
		} catch (BadPaddingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public byte[] readFile(String fileName) throws IOException {
		File file = new File(fileName);
		StringBuilder fileCont = new StringBuilder();
		FileInputStream in = null;
		try {
			in = new FileInputStream(file);
			int readByte;
			while ((readByte = in.read()) != -1) {
				fileCont.append((char) readByte);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (in != null)
				in.close();

		}
		new BASE64Decoder().decodeBuffer(in);
		// fileCont.toString()
		return fileCont.toString().getBytes();
	}

	public byte[] readFile2(String fileName) throws IOException {
		File file = new File(fileName);
		StringBuilder fileCont = new StringBuilder();
		FileInputStream in = null;
		try {
			in = new FileInputStream(file);
			int readByte;
			while ((readByte = in.read()) != -1) {
				fileCont.append(readByte);
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (in != null)
				in.close();

		}
		return new BASE64Decoder().decodeBuffer(fileCont.toString());
	}

	public boolean writedFile(byte[] cipherText, String fileName)
			throws IOException {
		File file = new File(fileName);
		FileOutputStream out = null;
		try {
			out = new FileOutputStream(file);
			out.write(cipherText);
			return true;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (out != null)
				out.close();
		}
		return false;
	}

	public boolean writedFile2(byte[] cipherText, String fileName)
			throws IOException {
		File file = new File(fileName);
		FileOutputStream out = null;
		try {
			out = new FileOutputStream(file);
			out.write(cipherText);
			return true;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (out != null)
				out.close();
		}
		return false;
	}
}
