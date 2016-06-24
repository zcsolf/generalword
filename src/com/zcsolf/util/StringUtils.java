package com.zcsolf.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtils {

	public static String replaceBlank(String str){
		String result = "";
		if(str != null){
			Pattern p = Pattern.compile("\\n");
			Matcher m = p.matcher(str);
			result = m.replaceAll("");
		}
		return result.trim();
	}
}
