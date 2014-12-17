package autogrd;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.w3c.dom.Document;

public class Sharing {

	
	public static int OPREAT_ANS = 0;
	public static int OPREAT_USR = 1;
	
	
	
	/**
	 * 检查输入字符串中是否包含非法字符；
	 * @return		true，包含；false，不包含；
	 */
	public static boolean illicitChars(String instr) {
		String rex = "[^\\w\\+\\-\\(\\)\\=\\<\\>,\\|\\{\\}\\:\\.\\u03B1-\\u03D6]";
		return Pattern.compile(rex).matcher(instr).find();
	}
	
	
	/**
	 * 判断方程式； 
	 * @param document		文档对象；
	 * @return				true，方程式；否则为表达式；
	 */
	public static boolean isEquation(Document document) {
		
		return false;
	}
	
	
	public static boolean isMathString(String instr) {
		String rex = "<math[^>]*>.+</math>";
		Matcher mat = Pattern.compile(rex).matcher(instr);
		return mat.find();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public static void main(String[] args) {

	}

}
