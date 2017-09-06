package cn.gss.lk.util;

import java.util.HashSet;
import java.util.Set;

public class SplitUtil {
	public static Set<Integer> splitInteger(String params) {
		if (params == null || params.equals(""))
			return null;
		Set<Integer> set = new HashSet<>();
		for (String s : params.split("\\|"))
			set.add(Integer.parseInt(s));
		return set;
	}

	public static Set<String> splitString(String params) {
		if (params == null || params.equals(""))
			return null;
		Set<String> set = new HashSet<>();
		for (String s : params.split("\\|"))
			set.add(s);
		return set;
	}
}
