package autogrd;

import java.util.regex.Pattern;

public class Sharing {

	
	
	
	
	
	/**
	 * 检查输入字符串中是否包含非法字符；
	 * @return		true，包含；false，不包含；
	 */
	public static boolean illicitChars(String instr) {
		String rex = "[^\\w\\+\\-\\(\\)\\=\\<\\>,\\|\\{\\}\\:\\.\\u03B1-\\u03D6]";
		return Pattern.compile(rex).matcher(instr).find();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public static void main(String[] args) {

	}

}
