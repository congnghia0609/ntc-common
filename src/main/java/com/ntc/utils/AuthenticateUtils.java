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

import java.security.SecureRandom;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.digest.DigestUtils;

public class AuthenticateUtils {

	public static String generateSession(String userName) {
		StringBuilder session = new StringBuilder(Base64.encodeBase64String(DigestUtils.sha256(userName + System.nanoTime())));
		return session.toString();
	}

	public static String hashPassword(String realPass, String salt) {
		StringBuilder hash = new StringBuilder(Base64.encodeBase64String(realPass.getBytes()).replace("=", ""));
		String hashSalt = Base64.encodeBase64String(salt.getBytes()).replace("=", "");
		hash.insert(hash.length() / 2, hashSalt);
		String hPass = Base64.encodeBase64String(DigestUtils.sha256(hash.toString())).replace("=", "");
		return hPass;
	}

	public static void main(String[] args) {
		SecureRandom secureRandom = new SecureRandom();
        int seedByteCount = 50;
        byte[] seed = secureRandom.generateSeed(seedByteCount);
        secureRandom.setSeed(seed);
        String random = String.valueOf(secureRandom.nextLong());
        String s = Base64.encodeBase64String(seed);
        System.out.println(random + " -- " + s);
	}
}
