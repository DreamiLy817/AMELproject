package fr.eni.amel.bll.manager.impl;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class PasswordTools {
	
	public static String hashSHA256(String password) throws NoSuchAlgorithmException{
		String hash = null;
		
		MessageDigest digest = MessageDigest.getInstance("SHA-256");
		digest.update(password.getBytes());
		
		byte byteData[] = digest.digest();
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < byteData.length; i++) {
			sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
		}
		hash = sb.toString();
		
		return hash;
	}
}
