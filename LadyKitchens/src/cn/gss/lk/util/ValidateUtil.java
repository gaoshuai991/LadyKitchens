package cn.gss.lk.util;

public class ValidateUtil {
	/**
	 * 验证数据是否为空,支持传入多个数据，
	 * @param data 要验证的数据
	 * @return 所有数据都非空时返回true，否则返回false
	 */
	public static boolean validateEmpty(String... data){
		boolean flag = true;
		for(String s:data){
			if(s==null||s.equals(""))
				flag = false;
		}
		return flag;
	}

	/**
	 * 进行数据的正则验证
	 * @param data 要验证的数据
	 * @param regex 要匹配的正则表达式
	 * @return 匹配返回true，否则返回false
	 */
	public static boolean validateRegex(String data,String regex){
		if(validateEmpty(data)){
			return data.matches(regex);
		}
		return false;
	}

	/**
	 * 验证两个数据是否相同，忽略大小写
	 * @param dataa
	 * @param datab
	 * @return
	 */
	public static boolean validateSame(String dataa,String datab){
		if(validateEmpty(dataa,datab)){
			return dataa.equalsIgnoreCase(datab);
		}
		return false;
	}
}
