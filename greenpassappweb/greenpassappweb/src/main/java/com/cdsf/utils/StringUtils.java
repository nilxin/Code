package com.cdsf.utils;

public class StringUtils {
	/**
	 * 将字母全转为大写
	 * 
	 * @param str
	 * @return
	 */
	public static String toUpperCase(String str) {
		return Tools.isNull(str) ? "" : str.toUpperCase();
	}
}
