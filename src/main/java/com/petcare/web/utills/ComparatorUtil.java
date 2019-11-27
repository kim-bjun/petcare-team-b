package com.petcare.web.utills;

import java.lang.reflect.Array;
import java.util.List;
import java.util.Map;


public class ComparatorUtil {
	
	public static boolean isEmpty(Object obj) {
		if (obj instanceof String)
			return obj == null || "".equals(obj.toString().trim());
		else if (obj instanceof List)
			return obj == null || ((List) obj).isEmpty();
		else if (obj instanceof Map)
			return obj == null || ((Map) obj).isEmpty();
		else if (obj instanceof Object[])
			return obj == null || Array.getLength(obj) == 0;
		else
			return obj == null;
	}

	public static boolean isNotEmpty(String s) {
		return !isEmpty(s);
	}

	public static String isString(String s) {
		if (isEmpty(s))
			return "";
		return s;
	}

	public static String isString(String s, String r) {
		if (isEmpty(s)) {
			if (isEmpty(r))
				return "";
			return r;
		}
		return s;
	}

	public static int checkNumeric(String str) {
		try {
			if (isEmpty(str))
				return 0;

			if (isNumeric(str))
				return Integer.parseInt(str);
		} catch (NullPointerException e) {
			e.printStackTrace();
		}

		return 0;
	}

	public static boolean isNumeric(String str) {
		return str.matches("-?\\d+(.\\d+)?");
	}
}
