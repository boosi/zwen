package editor;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * 编辑器；<br/>
 * 将通常的数学字串转换为 MathNL 字符串；
 * @author Zhengwen 
 * @date 2 Jan, 2015
 * @version Grading 3.0 Builder		0009
 */
public class Editor {

	/** 构造器 **/
	public Editor() {
		
	}
	
	
	
	
	/**
	 * 将源文本转换为 MathML 字符串；
	 * @param text		源文本；
	 * @return			MathML 字符串；
	 */
	public static String getMathStr(String text) {
		String rst = "<math xmlns=\"http://www.w3.org/1998/Math/MathML\">";
		String[] 	rxs		= new String[] {
				"^[a-zA-Z\\u004e-\\u009f&&[^\\{\\},]]", 
				"^[0-9]+", 
				"^[\\(\\[\\{\\<\\>\\}\\]\\)\\|]", 
				"^[\\+\\-\\*\\/]", 
				"^[\\.\\=\\:,]",
				"[\\s]"
		};
		String		str		= text;
		//int num = 0;
		Matcher match = null;
		while (!str.equals("")) {
			match = Pattern.compile(rxs[0]).matcher(str);
			if (match.find()) {
				rst += "<mi>" + match.group(0) + "</mi>";
				str = str.substring(match.group(0).length());
				continue;
			}
			match = Pattern.compile(rxs[1]).matcher(str);
			if (match.find()) {
				rst += "<mn>" + match.group(0) + "</mn>";
				str = str.substring(match.group(0).length());
				continue;
			}
			match = Pattern.compile(rxs[2]).matcher(str);
			if (match.find()) {
				if (match.group(0).equals("{")) {
					rst += "<mfenced open=\"{\" close=\"}\"><mrow>";
				}
				else if (match.group(0).equals("[")) {
					rst += "<mfenced open=\"[\" close=\"]\"><mrow>";
				}
				else if (match.group(0).equals("(")) {
					rst += "<mfenced><mrow>";
				}
				else if (match.group(0).equals("}") || match.group(0).equals("]") || match.group(0).equals(")")) {
					rst += "</mrow></mfenced>" + "";
				}
				else {
					rst += "<mo>" + match.group(0) + "</mo>";
				}
				str = str.substring(match.group(0).length());
				continue;
			}
			match = Pattern.compile(rxs[3]).matcher(str);
			if (match.find()) {
				rst += "<mo>" + match.group(0) + "</mo>";
				str = str.substring(match.group(0).length());
				continue;
			}
			match = Pattern.compile(rxs[4]).matcher(str);
			if (match.find()) {
				rst += "<mo>" + match.group(0) + "</mo>";
				str = str.substring(match.group(0).length());
				continue;
			}
			match = Pattern.compile(rxs[5]).matcher(str);
			if (match.find()) {
				rst += "<mo>&#160;</mo>";
				str = str.substring(match.group(0).length());
				continue;
			}
			rst += "<mi>" + str.substring(0, 1) + "</mi>";
			str = str.substring(1);
		}
		
		return rst + "</math>";
	}
	
	
	
	
	public String mathStr(String text) {
		
		
		return "<math><mn>9876543210</mn></math>";
	}

	
	
	public static void main(String[] args) {
		System.out.println(">>\t"+getMathStr("9+3"));
	}
	
	
	
	
	
	
	
}
