/*
 * Copyright 2015 nghiatc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.ntc.utils;

import java.security.MessageDigest;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;

public class AESDigestUtils {
	private static final String CIPHER = "AES";
	private static final String HASH = "SHA-256";
	private static final String CHARSET = "utf-8";
	private static final IvParameterSpec iv = new IvParameterSpec("dkmobile@#3%&123".getBytes());

	public static String encrypt(String text, String secretKey) throws Exception {
		MessageDigest md = MessageDigest.getInstance(HASH);
		byte[] digestOfPassword = md.digest(secretKey.getBytes(CHARSET));
		byte[] keyBytes = digestOfPassword;

		SecretKey key = new SecretKeySpec(keyBytes, CIPHER);
		final Cipher cipher = Cipher.getInstance(CIPHER + "/CBC/NoPadding");		
		cipher.init(Cipher.ENCRYPT_MODE, key, iv);

		byte[] plainTextBytes = text.getBytes(CHARSET);
		if(plainTextBytes.length % 16 > 0) {
			byte[] oldData = plainTextBytes;
			int length = oldData.length + (16 - (plainTextBytes.length % 16));
			plainTextBytes = new byte[length];
			System.arraycopy(oldData, 0, plainTextBytes, 0, oldData.length);
		}

	    byte[] buf = cipher.doFinal(plainTextBytes);
	    String base64EncryptedString = Base64.encodeBase64String(buf);

	    return base64EncryptedString;
	}

	public static String decrypt(String encryptedText, String secretKey) throws Exception {
	    byte[] message = Base64.decodeBase64(encryptedText);

		MessageDigest md = MessageDigest.getInstance(HASH);
		byte[] digestOfPassword = md.digest(secretKey.getBytes(CHARSET));
		byte[] keyBytes =digestOfPassword;
		SecretKey key = new SecretKeySpec(keyBytes, CIPHER);

		final Cipher cipher = Cipher.getInstance(CIPHER + "/CBC/NoPadding");
		cipher.init(Cipher.DECRYPT_MODE, key, iv);

		byte[] plainText = cipher.doFinal(message);

		return new String(plainText, "UTF-8");
	}
}
