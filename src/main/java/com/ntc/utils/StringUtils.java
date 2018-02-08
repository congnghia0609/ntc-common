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

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang.math.NumberUtils;

public class StringUtils {

	private static final String EMAIL_PATTERN ="^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
		+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

	private static Pattern emailPattern = Pattern.compile(EMAIL_PATTERN);

	public StringUtils() {
	}

	/**
	 * Validate hex with regular expression
	 *
	 * @param hex
	 *            hex for validation
	 * @return true valid hex, false invalid hex
	 */
	public static boolean validateEmail(String email) {
		Matcher matcher = emailPattern.matcher(email);
		return matcher.matches();

	}

	public static List<Integer> stringToList(String listStr, boolean removeZero) {
		String[] parts = listStr.split(",");
		List<Integer> list = new ArrayList<Integer>(parts.length);
		for (String part: parts) {
			int num = NumberUtils.toInt(part);
			if (!removeZero || num != 0) {
				list.add(num);
			}
		}
		return list;
	}
	
	public static List<Long> stringToLongList(String listStr, boolean removeZero) {
		String[] parts = listStr.split(",");
		List<Long> list = new ArrayList<Long>(parts.length);
		for (String part: parts) {
			long num = NumberUtils.toLong(part);
			if (!removeZero || num != 0) {
				list.add(num);
			}
		}
		return list;
	}

	public static byte[] hexStringToBytes(String hexString) {
		final byte[] tokenBytes = new byte[hexString.length() / 2];

		for (int i = 0; i < hexString.length(); i += 2) {
			tokenBytes[i / 2] = (byte) (Integer.parseInt(hexString.substring(i, i + 2), 16));
		}

		return tokenBytes;
	}

	public static String bytesToHexString(final byte[] tokenBytes) {

		final StringBuilder builder = new StringBuilder();

		for (final byte b : tokenBytes) {
			final String hexString = Integer.toHexString(b & 0xff);

			if (hexString.length() == 1) {
				// We need a leading zero
				builder.append("0");
			}

			builder.append(hexString);
		}

		return builder.toString();
	}

	public static String buildAddress(String addr, String city, String state, String country, String zipCode) {
		StringBuilder builder = new StringBuilder();

		if(addr != null && !addr.isEmpty()) {
			builder.append(addr);
		}

		if(city != null && !city.isEmpty()) {
			builder.append(" " + city);
		}

		if(state != null && !state.isEmpty()) {
			builder.append(", " + state);
		}

		if(country != null && !country.isEmpty()) {
			builder.append(", " + country);
		}

		if(zipCode != null && !zipCode.isEmpty()) {
			builder.append(" " + zipCode);
		}

		return builder.toString();
	}
}