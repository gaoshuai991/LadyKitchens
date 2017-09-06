package cn.gss.lk.util;

public class StringUtil {
	public static String initCap(String str){
		if(str==null||str.equals("")){
			return str;
		}else{
			return str.substring(0, 1).toUpperCase() +  str.substring(1);
		}
	}
}
