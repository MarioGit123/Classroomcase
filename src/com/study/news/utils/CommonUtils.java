package com.study.news.utils;

public class CommonUtils {
	/**如果参数能够转成数字，返回true
	 * @param p
	 * @return
	 */
	public static boolean verifyPageNo(String p) {
		boolean flag=true;
		try {
			Integer.parseInt(p);
		} catch (Exception e) {
			flag=false;
		}
		return flag;
	}
}
