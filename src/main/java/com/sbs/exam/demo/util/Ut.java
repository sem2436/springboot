package com.sbs.exam.demo.util;

public class Ut {

	public static boolean empty(Object obj) {
		if(obj==null) {
			return true;
		}
		if(obj instanceof String && ((String) obj).trim().length()== 0 ) {
			return true;
		}
		return false;
	}

	public static String f(String format, Object...args) {
		return String.format(format, args);
	}
}

