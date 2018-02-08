package com.ntc.utils;


public class NoiseIdUtils {
	private static TEA tea = new TEA("luvdk@#$!DKMcvbt".getBytes());

	public static String encryptString(String id) {
		return StringUtils.bytesToHexString(tea.encrypt(id.getBytes()));
	}

	public static String decryptString(String hash) {
		String id = "";
		try {
			id = new String(tea.decrypt(StringUtils.hexStringToBytes(hash)));
		} catch(Exception e) {

		}

		return id;
	}
}
