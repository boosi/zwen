package grading;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.w3c.dom.Document;





/**
 * 共享类，集中了程序运行时的各种通用方法，共享方法等；
 * @author Zhengwen 
 * @date 23 Dec, 2014
 * @version Grading 3.0 Builder	0009
 */
public class Sharing {

	
	public static int OPREAT_ANS = 0;
	public static int OPREAT_USR = 1;
	
	
	
	/**
	 * 检查输入字符串中是否包含非法字符；
	 * @return		true，包含；false，不包含；
	 */
	public static boolean illicitChars(String instr) {
		String 	result = ""; 
		Matcher mat = Pattern.compile(RexExpr.ANY_CONTENT).matcher(instr);
		
		while (mat.find())
			result += mat.group(0);		//去掉标签的全部文本；
		
		return Pattern.compile(RexExpr.CORRECT_CHAR).matcher(result).find();		//在其中查询是否含有不合理字符；; 
	}
	
	
	/**
	 * 判断方程式； 
	 * @param document		文档对象；
	 * @return				true，方程式；否则为表达式；
	 */
	public static boolean isEquation(Document document) {
		
		return false;
	}
	
	/**
	 * 是否为 MathML 字符串；
	 * @param instr		源 MathML 字符串；
	 * @return			true，MathML 字符串；否则不是 MathML 字符串；
	 */
	public static boolean isMathString(String instr) {
		return Pattern.compile(RexExpr.TAG_MATH).matcher(instr).find();
	}
	
	
	/**
	 * 根据已知的 Matcher 类，将已知字符串分割为字符串数组；
	 * (根据当前的匹配对象，获取组的长度，然后创建字符串数组并赋值)；
	 * @param mater		正则匹配对象；
	 * @return			字符串数组；
	 */
	public static String[] sectionalization(Matcher mater) {
		String[] trans;
		int len = mater.groupCount() + 1;
		trans = new String[len];
		for (int i = 0; i < len; i++) {
			trans[i] = mater.group(i);
		}
		return trans;
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public static void main(String[] args) {

	}

}
