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

import com.ntc.exception.InvalidParamException;
import com.ntc.exception.NotExistException;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author nghiatc
 * @since Sep 22, 2015
 */
public class HReqParam {
    private static String _getParameterAsString(HttpServletRequest req, String paramName) throws NotExistException, InvalidParamException {
		if (paramName == null) {
			throw new InvalidParamException("Parameter name is null");
		}
		paramName = paramName.trim();
		if (paramName.isEmpty()) {
			throw new InvalidParamException("Parameter name is empty");
		}

		String strVal = req.getParameter(paramName);
		if (strVal == null) {
			throw new NotExistException();
		}
		return strVal;
	}

	////////////////////////////////////////////////////////////////////////////
	///specdatatype read with throwing exceptions
	///
    public static Boolean parseBoolean(String strVal) {
		if (strVal != null) {
			strVal = strVal.trim();
			if (strVal.equalsIgnoreCase("true")) {
				return true;
			} else if (strVal.equalsIgnoreCase("false")) {
				return false;
			} else if (strVal.equalsIgnoreCase("yes")) {
				return true;
			} else if (strVal.equalsIgnoreCase("no")) {
				return false;
			} else if (strVal.equalsIgnoreCase("on")) {
				return true;
			} else if (strVal.equalsIgnoreCase("off")) {
				return false;
			} else if (strVal.equalsIgnoreCase("1")) {
				return true;
			} else if (strVal.equalsIgnoreCase("0")) {
				return false;
			}
		}
		return null;
	}
    
	public static Boolean getBoolean(HttpServletRequest req, String paramName) throws NotExistException, NumberFormatException, InvalidParamException {
		String strVal = _getParameterAsString(req, paramName);

		Boolean ret = parseBoolean(strVal);
		if (ret != null) {
			return ret.booleanValue();
		} else {
			throw new NumberFormatException("Wrong format while parsing boolean");
		}
	}

	public static Byte getByte(HttpServletRequest req, String paramName) throws NotExistException, NumberFormatException, InvalidParamException {
		return Byte.valueOf(_getParameterAsString(req, paramName));
	}

	public static Double getDouble(HttpServletRequest req, String paramName) throws NotExistException, NumberFormatException, InvalidParamException {
		return Double.valueOf(_getParameterAsString(req, paramName));
	}

	public static Float getFloat(HttpServletRequest req, String paramName) throws NotExistException, NumberFormatException, InvalidParamException {
		return Float.valueOf(_getParameterAsString(req, paramName));
	}

	public static Integer getInt(HttpServletRequest req, String paramName) throws NotExistException, NumberFormatException, InvalidParamException {
		return Integer.valueOf(_getParameterAsString(req, paramName));
	}

	public static Long getLong(HttpServletRequest req, String paramName) throws NotExistException, NumberFormatException, InvalidParamException {
		return Long.valueOf(_getParameterAsString(req, paramName));
	}

	public static Short getShort(HttpServletRequest req, String paramName) throws NotExistException, NumberFormatException, InvalidParamException {
		return Short.valueOf(_getParameterAsString(req, paramName));
	}

	public static String getString(HttpServletRequest req, String paramName) throws NotExistException, InvalidParamException {
		return _getParameterAsString(req, paramName);
	}

	////////////////////////////////////////////////////////////////////////////
	///specdatatype read without throwing exception (use defaultVal instead)
	///
	public static Boolean getBoolean(HttpServletRequest req, String paramName, Boolean defaultVal) {
		try {
			return getBoolean(req, paramName);
		} catch (Exception ex) {
			return defaultVal;
		}
	}

	public static Byte getByte(HttpServletRequest req, String paramName, Byte defaultVal) {
		try {
			return getByte(req, paramName);
		} catch (Exception ex) {
			return defaultVal;
		}
	}

	public static Double getDouble(HttpServletRequest req, String paramName, Double defaultVal) {
		try {
			return getDouble(req, paramName);
		} catch (Exception ex) {
			return defaultVal;
		}
	}

	public static Float getFloat(HttpServletRequest req, String paramName, Float defaultVal) {
		try {
			return getFloat(req, paramName);
		} catch (Exception ex) {
			return defaultVal;
		}
	}

	public static Integer getInt(HttpServletRequest req, String paramName, Integer defaultVal) {
		try {
			return getInt(req, paramName);
		} catch (Exception ex) {
			return defaultVal;
		}
	}

	public static Long getLong(HttpServletRequest req, String paramName, Long defaultVal) {
		try {
			return getLong(req, paramName);
		} catch (Exception ex) {
			return defaultVal;
		}
	}

	public static Short getShort(HttpServletRequest req, String paramName, Short defaultVal) {
		try {
			return getShort(req, paramName);
		} catch (Exception ex) {
			return defaultVal;
		}
	}

	public static String getString(HttpServletRequest req, String paramName, String defaultVal) {
		try {
			return getString(req, paramName);
		} catch (Exception ex) {
			return defaultVal;
		}
	}

	////////////////////////////////////////////////////////////////////////////
	///specdatatype read without throwing exception (suffix: ExL - Exception less) (use null instead)
	///
	public static Boolean getBooleanExl(HttpServletRequest req, String paramName) {
		return getBoolean(req, paramName, null);
	}

	public static Byte getByteExl(HttpServletRequest req, String paramName) {
		return getByte(req, paramName, null);
	}

	public static Double getDoubleExl(HttpServletRequest req, String paramName) {
		return getDouble(req, paramName, null);
	}

	public static Float getFloatExl(HttpServletRequest req, String paramName) {
		return getFloat(req, paramName, null);
	}

	public static Integer getIntExl(HttpServletRequest req, String paramName) {
		return getInt(req, paramName, null);
	}

	public static Long getLongExl(HttpServletRequest req, String paramName) {
		return getLong(req, paramName, null);
	}

	public static Short getShortExl(HttpServletRequest req, String paramName) {
		return getShort(req, paramName, null);
	}

	public static String getStringExl(HttpServletRequest req, String paramName) {
		return getString(req, paramName, null);
	}
}
