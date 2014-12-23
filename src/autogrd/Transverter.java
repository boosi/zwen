package autogrd;

import java.util.regex.Matcher;
import java.util.regex.Pattern;





/**
 * 转换器，变形各种 MathML 字符串形式；
 * @author Zhengwen 	
 * @date 23 Dec, 2014
 * @version Grading 3.0 Builder	008
 */
public class Transverter {
	/**与主线程通信（表示启动该类的主线程)*/
	Comparer communicate = null;
	
	
	/**
	 * 在检查之前必须要做的变换，将不规范的代码规范；
	 * @param mathTrans		需要变换的字符串；
	 * @return				变换完成并且无错，返回 true，否则返回 false；
	 */
	public static String necessaryTrans(String mathTrans) {
		String res = "";
		
		res = removeTagProperts(mathTrans);
		res = replaceTag(res);
		res = modifyTagSup(res);
		
		return res;
	}

	
	/**
	 * 删除标签中的属性；
	 * @param instr		源字符串；
	 * @return			返回规范后的字符串；
	 */
	private static String removeTagProperts(String instr) {
		String 		rex 	= "", 
					ret = instr;
		Matcher 	mat 	= null;
		
		rex = "(?i)(?:\\r|\\n)";									//删除全部换行，回车符号； 
		mat = Pattern.compile(rex).matcher(ret);
			while (mat.find()) {
				ret = mat.replaceFirst("");
			}
		rex = "(?i)<mi\\s[^>]+>";
		mat = Pattern.compile(rex).matcher(ret);
			while (mat.find()) {
				ret = mat.replaceFirst("<mi>");
			}
		rex = "(?i)<mn\\s[^>]+>";
		mat = Pattern.compile(rex).matcher(ret);
			while (mat.find()) {
				ret = mat.replaceFirst("<mn>");
			}
		rex = "(?i)<mo(?!ver)\\s[^>]+>";
		mat = Pattern.compile(rex).matcher(ret);
			while (mat.find()) {
				ret = mat.replaceFirst("<mo>");
			}
		rex = "(?i)<(m(?:sup|sub|frac|sqrt|root|table|tr|td|row|text))\\s[^>]*>";
		mat = Pattern.compile(rex).matcher(ret);
			while (mat.find()) {
				ret = mat.replaceFirst("<" + mat.group(1)+ ">");
			}
		
		return ret;
	}
	
	/**
	 * 替换 sin、log、and 等不规范的标签为规范形式；
	 * @param instr		源字符串；
	 * @return			返回规范后的字符串；
	 */
	private static String replaceTag(String instr) {
		String 		rex 	= "", 
					ret = instr;
		Matcher 	mat 	= null;
		
		rex = "(?i)<(m(?:i|text))>\\s*s\\s*(</\\1><(m(?:i|text))>)?\\s*i\\s*(</\\1><(m(?:i|text))>)?\\s*n\\s*</\\1>";	//sin
		mat = Pattern.compile(rex).matcher(ret);
			while (mat.find()) {
				ret = mat.replaceFirst("<mi>sin</mi>");
			}
		
		rex = "(?i)<(m(?:i|text))>\\s*c\\s*(</\\1><(m(?:i|text))>)?\\s*o\\s*(</\\1><(m(?:i|text))>)?\\s*s\\s*</\\1>";	//cos
			mat = Pattern.compile(rex).matcher(ret);
			while (mat.find()) {
				ret = mat.replaceFirst("<mi>cos</mi>");
			}
			
		rex = "(?i)<(m(?:i|text))>\\s*t\\s*(</\\1><(m(?:i|text))>)?\\s*a\\s*(</\\1><(m(?:i|text))>)?\\s*n\\s*</\\1>";	//tan
			mat = Pattern.compile(rex).matcher(ret);
			while (mat.find()) {
				ret = mat.replaceFirst("<mi>tan</mi>");
			}
			
		rex = "(?i)<(m(?:i|text))>\\s*c\\s*(</\\1><(m(?:i|text))>)?\\s*s\\s*(</\\1><(m(?:i|text))>)?\\s*c\\s*</\\1>";	//csc
			mat = Pattern.compile(rex).matcher(ret);
			while (mat.find()) {
				ret = mat.replaceFirst("<mi>csc</mi>");
			}
			
		rex = "(?i)<(m(?:i|text))>\\s*s\\s*(</\\1><(m(?:i|text))>)?\\s*e\\s*(</\\1><(m(?:i|text))>)?\\s*c\\s*</\\1>";	//sec
			mat = Pattern.compile(rex).matcher(ret);
			while (mat.find()) {
				ret = mat.replaceFirst("<mi>sec</mi>");
			}
			
		rex = "(?i)<(m(?:i|text))>\\s*c\\s*(</\\1><(m(?:i|text))>)?\\s*o\\s*(</\\1><(m(?:i|text))>)?\\s*t\\s*</\\1>";	//cot
			mat = Pattern.compile(rex).matcher(ret);
			while (mat.find()) {
				ret = mat.replaceFirst("<mi>cot</mi>");
			}
			
		rex = "(?i)<(m(?:i|text))>\\s*l\\s*(</\\1><(m(?:i|text))>)?\\s*o\\s*(</\\1><(m(?:i|text))>)?\\s*g\\s*</\\1>";	//log
			mat = Pattern.compile(rex).matcher(ret);
			while (mat.find()) {
				ret = mat.replaceFirst("<mi>log</mi>");
			}
			
		rex = "(?i)<(m(?:i|text))>\\s*l\\s*(</\\1><(m(?:i|text))>)?\\s*g\\s*</\\1>";	//lg
			mat = Pattern.compile(rex).matcher(ret);
			while (mat.find()) {
				ret = mat.replaceFirst("<mi>lg</mi>");
			}
			
		rex = "(?i)<(m(?:i|text))>\\s*l\\s*(</\\1><(m(?:i|text))>)?\\s*n\\s*</\\1>";	//ln	
			mat = Pattern.compile(rex).matcher(ret);
			while (mat.find()) {
				ret = mat.replaceFirst("<mi>ln</mi>");
			}
			
		rex = "(?i)<(m(?:i|text))>\\s*o\\s*(</\\1><(m(?:i|text))>)?\\s*r\\s*</\\1>";	//or	
			mat = Pattern.compile(rex).matcher(ret);
			while (mat.find()) {
				ret = mat.replaceFirst("<mo>∨</mo>");
			}
			
		rex = "(?i)<(m(?:i|text))>\\s*a\\s*(</\\1><(m(?:i|text))>)?\\s*n\\s*(</\\1><(m(?:i|text))>)?\\s*d\\s*</\\1>";	//and	
			mat = Pattern.compile(rex).matcher(ret);
			while (mat.find()) {
				ret = mat.replaceFirst("<mo>∧</mo>");
			}
		
		return ret;
	}
	
	/**
	 * 把原来不规范的 msup 标签规范为标准 msup 标签；
	 * @param instr		源字符串；
	 * @return			返回规范后的字符串；
	 */
	private static String modifyTagSup(String instr) {
		String 		rex 	= "", 
					ret 	= instr;
		Matcher 	mat 	= null;
		String []	trans	= null;
		
		rex = "(?i)<mo>\\(</mo>(.*?)(<msup>(<mo>\\)</mo>)<mn>3</mn></msup>)";	//键盘输入的 msup；
		mat = Pattern.compile(rex).matcher(ret);
		while (mat.find()) {
				trans = Sharing.sectionalization(mat);
					trans[1] = "<mfenced><mrow>" + trans[1] + "</mrow></mfenced>";
					trans[1] = trans[1].replace("<msup>", "");
					trans[2] = trans[2].replace(trans[3], trans[1]);
					ret = mat.replaceFirst(trans[2]);
		}
		
		rex = "(?i)<mo>\\{</mo>(.*?)(<msup>(<mo>\\}</mo>)<mn>3</mn></msup>)";	//键盘输入的 msup；
		mat = Pattern.compile(rex).matcher(ret);
		while (mat.find()) {
				trans = Sharing.sectionalization(mat);
					trans[1] = "<mfenced open=\"{\" close=\"}\"><mrow>" + trans[1] + "</mrow></mfenced>";
					trans[1] = trans[1].replace("<msup>", "");
					trans[2] = trans[2].replace(trans[3], trans[1]);
					ret = mat.replaceFirst(trans[2]);
		}
		return ret;
	}
	
	
	
	
	

}
