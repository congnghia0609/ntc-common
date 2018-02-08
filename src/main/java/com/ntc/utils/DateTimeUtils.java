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

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import org.apache.commons.lang.math.NumberUtils;


public class DateTimeUtils {

	public static int EQUAL = 0;
	public static int LESSER = -1;
	public static int GREATER = 1;

	public static int compare(String date, String compareDate, String split) {
		int source = parseDateToInt(date, split);
		int compare = parseDateToInt(compareDate, split);

		int rs = 0;
		if(source > compare) {
			rs = GREATER;
		} else if(source < compare) {
			rs = LESSER;
		}

		return rs;
	}

	public static int parseDateToInt(String date, String split) {
		String intValue = date.replaceAll(split, "");
		return NumberUtils.toInt(intValue);
	}

	public static Date parseStringToDate(String strDate) {
		Date date = new Date();
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");
			date = sdf.parse(strDate);
		} catch (ParseException e) {
		}

		return date;
	}
	
	public static Date parseStringToDate(String strDate, TimeZone timeZone) {
		Date date = new Date();
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");
			sdf.setTimeZone(timeZone);
			date = sdf.parse(strDate);
		} catch (ParseException e) {
		}

		return date;
	}

	public static String formatDate(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");
		return sdf.format(date);
	}
	
	public static String formatDate(Date date, TimeZone timeZone) {
		SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");
		sdf.setTimeZone(timeZone);
		return sdf.format(date);
	}

	public static String formatDate(Date date, String format) {
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		return sdf.format(date);
	}

	public static Date addDays(Date date, int days) {
		Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DATE, days);
        return cal.getTime();
	}

	public static long daysBetween(Date date1, Date date2) {
		return (date1.getTime() - date2.getTime()) / (24 * 60 * 60 * 1000);
	}

	public static long daysBetween(long date1, long date2) {
		return (date1 - date2) / (24 * 60 * 60 * 1000);
	}

	public static Calendar getCalendar(long date) {
		 Calendar cal = Calendar.getInstance();
		 cal.setTimeInMillis(date);
		 return cal;
	}

	public static Calendar getCalendar(Date date) {
	    Calendar cal = Calendar.getInstance();
	    cal.setTime(date);
	    return cal;
	}

	public static int yearsBetween(Date first, Date last) {
	    Calendar a = getCalendar(first);
	    Calendar b = getCalendar(last);
	    int diff = a.get(Calendar.YEAR) - b.get(Calendar.YEAR);
	    if (b.get(Calendar.MONTH) > a.get(Calendar.MONTH) ||
	        (b.get(Calendar.MONTH) == a.get(Calendar.MONTH) && b.get(Calendar.DATE) > a.get(Calendar.DATE))) {
	        diff--;
	    }
	    return diff;
	}

	public static boolean checkDateWithoutYear(String strDate) {
		// append year 2012
		strDate = strDate + "/12";
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yy");
		sdf.setLenient(false);
		try {
			sdf.parse(strDate);
			return true;
		} catch (ParseException e) {
			return false;
		}
	}

	public static int getAge(long time) {
	    Calendar a = Calendar.getInstance();
		Calendar b = getCalendar(time);
//		int diff = a.get(Calendar.YEAR) - b.get(Calendar.YEAR);
		int diff = yearsBetween(a.getTime(), b.getTime());
	    return diff;
	}

	public static Date getToday() {
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);

		return calendar.getTime();
	}
}
