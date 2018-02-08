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

import org.apache.commons.lang.RandomStringUtils;
import org.apache.commons.lang.math.RandomUtils;

public class PasswordUtils {
	
	public static boolean checkPassword(String password, String username, boolean requireStrong) {
		if (requireStrong)
			return isStrongPassword(password, username);
		else
			return isMediumPassword(password, username);
	}

	public static boolean isStrongPassword(String password, String username) {
		if (password.length() < 7 || password.length() > 20) {
			return false;
		}
		
		if (password.toLowerCase().contains(username)) {
			return false;
		}

		boolean isContainDigit = false;
		boolean isContainSpecialCharacter = false;
		for (int i = 0; i < password.length(); i++) {
			final char c = password.charAt(i);
			if (Character.isDigit(c)) {
				isContainDigit = true;
			} else if (!Character.isLetter(c) && !Character.isWhitespace(c)) {
				isContainSpecialCharacter = true;
			}
		}

		return isContainDigit & isContainSpecialCharacter;
	}
	
	public static boolean isMediumPassword(String password, String username) {
		if (password.length() < 5) {
			return false;
		}
		
		return true;
	}
	
	public static String random(String username, boolean requireStrong) {
		if (requireStrong)
			return randomStrongPassword(username);
		else
			return randomMediumPassword(username);
	}
	
	public static String randomStrongPassword(String username) {
		String password = "";

		do {
			password = RandomStringUtils.randomAlphanumeric(10);
			String specialChar = RandomStringUtils.random(1, "~!@#$%^&*()-+=");
			int randPos = RandomUtils.nextInt(password.length() + 1);
			password = new StringBuilder(password).insert(randPos, specialChar).toString();
		} while (!PasswordUtils.isStrongPassword(password, username));
		
		return password;
	}
	
	public static String randomMediumPassword(String username) {
		String password = "";

		do {
			password = RandomStringUtils.randomAlphanumeric(6);
		} while (!PasswordUtils.isMediumPassword(password, username));
		
		return password;
	}
}
