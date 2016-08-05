package com.pm.common;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class SessionMgr {

	static HashMap<String, HashMap<String, String>> loggedInMap = new HashMap<String, HashMap<String, String>>();

	public static Map<String, String> getSession(String userId) {
		if (!loggedInMap.containsKey(userId)) {
			loggedInMap.put(userId, new HashMap<String, String>());
			return loggedInMap.get(userId);
		} else {
			return loggedInMap.get(userId);
		}
	}

	public static boolean relSession(String userId) {
		if (loggedInMap.containsKey(userId)) {
			loggedInMap.remove(userId);
			return true;
		}
		return false;
	}

	public static boolean updateSession(String userId,
			Map<String, String> session) {

		if (!loggedInMap.containsKey(userId)) {
			loggedInMap.put(userId, new HashMap<String, String>());
			return true;
		}
		return false;
	}

	public static boolean isLoggedIn(String userId) {
		if (loggedInMap.containsKey(userId)) {
			return true;
		} else {
			return false;
		}

	}

	public static String getValue(String userId, String key) {
		if (loggedInMap.containsKey(userId)) {
			return loggedInMap.get(userId).get(key).toString();
		}
		return null;
	}

	public static void putValue(String userId, String sesnKey, String sesnValue) {
		if (loggedInMap.containsKey(userId)) {
			loggedInMap.get(userId).put(sesnKey, sesnValue);
			loggedInMap.get(userId).put("lastAccessTime",
					Calendar.getInstance().getTime().toString());
		}

	}

	public static int relLoginLock(String userId) {
		int minuteDiff = 30;
		int sesnOutTime = 2;
		if (loggedInMap.containsKey(userId)) {
			// Sample format - "Fri Feb 19 18:50:54 IST 2010"
			DateFormat formatter = new SimpleDateFormat(
					"EEE MMM dd HH:mm:ss z yyyy");
			try {
				if (loggedInMap.get(userId).get("lastAccessTime") == null) {
					return 0;
				}
				Calendar lastAccessTime = Calendar.getInstance();
				Calendar currTime = Calendar.getInstance();

				lastAccessTime.setTime(formatter.parse(loggedInMap.get(userId)
						.get("lastAccessTime")));
				lastAccessTime.get(Calendar.HOUR);
				if (currTime.get(Calendar.HOUR) >= lastAccessTime
						.get(Calendar.HOUR)) {
					minuteDiff = currTime.get(Calendar.MINUTE)
							- lastAccessTime.get(Calendar.MINUTE);
					if (minuteDiff >= 0) {

						if (minuteDiff >= sesnOutTime) {
							loggedInMap.remove(userId);
							return 0;
						}
					} else {
						if (minuteDiff <= (-sesnOutTime)) {
							loggedInMap.remove(userId);
							return 0;

						}
					}
				}

			} catch (ParseException e) {
				e.printStackTrace();
			}

		}
		return (sesnOutTime - Math.abs(minuteDiff));
	}
}
