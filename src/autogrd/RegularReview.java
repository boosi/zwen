package autogrd;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.lang.System.*;



/**
 * 专门处理正则表达式的相关检查；<br/>
 * 全部为静态函数；不能继承；
 * @author Zhengwen 
 * @date 19 Dec, 2014
 * @version Grading 3.0 Builder 008
 */
public final class RegularReview {

	
	
	
	/**
	 * 规范字符串，使得该字符串仅有唯一形式；
	 * @param instr		源字串；
	 * @return			返回提示码或错误码；
	 */
	static int formater(String instr) {
		String 	rex;
		Matcher mat;
		
		rex = "(?i)<math[^>]*>(.+)</math>";									// Math 标签不配对；
		mat = Pattern.compile(rex).matcher(instr);
			while (!mat.find())
				return -3504;
			if (mat.group(1).indexOf("<math") >= 0 || mat.group(1).indexOf("</math>") >= 0)
				return -3506;												// 多余的 Math 标签； 新增 3504： 多余的标签；
		instr = deleteStyle(instr);											// 删除 mstyle 或 mspace 等无用标签；
		rex = "(?i)(&#160;)";												// 空格检查； 
		mat = Pattern.compile(rex).matcher(instr);
			while (mat.find())
				return -3010;
		
		//{bgn 括弧；	
		Matcher mL = Pattern.compile("\\(").matcher(instr), 
				mR = Pattern.compile("\\)").matcher(instr);
		int		nL = 0,
				nR = 0;
				while (mL.find())
					nL++;	//计数；
				while (mR.find())
					nR++;
				if (nL != nR)
					return -6100;
			
			mL = Pattern.compile("\\{").matcher(instr);
			mR = Pattern.compile("\\}").matcher(instr);
			nL = 0;
			nR = 0;
				while (mL.find())
					nL++;
				while (mR.find())
					nR++;
				if (nL != nR)
					return -6100;	
				
			mL = Pattern.compile("\\|").matcher(instr);
				while (mL.find())
					nL++;	//计数；
				if (nL % 2 != 0)
					return -6100;
		//}end	
			
		
		//{bgn 	格式检查；		
		rex = "(?i)<(m(?:frac|sup|sub|root|over))[^>]*>(.*?)</\\1>";							//分式、开任意方、平方、小标；
		mat = Pattern.compile(rex).matcher(instr);
			while (mat.find()) {
				String tmp = mat.group(2);
				boolean bool = Pattern.compile(
						"(?i)<(m\\w+)>.+?</\\1><(m\\w+)>.+?</\\2>").matcher(tmp).matches();		//缺少两个项目中的任一个（不能完全匹配）；
				if (!bool)
					return -3502;
			}
			
		rex = "(?i)<(m(?:row|sqrt))[^>]*>(.*?)</\\1>";											//开平方、行组合等；
		mat = Pattern.compile(rex).matcher(instr);
			while (mat.find()) {
				String tmp = mat.group(2);
				boolean bool = tmp == null || tmp.equals("");									
				if (bool)
					return -3502;
			}
			
		rex = "(?i)<mfenced>(.*?)</mfenced>"; 													// 括号、绝对值、花括弧等内容为空（软键盘）；
		mat = Pattern.compile(rex).matcher(instr);
			while (mat.find()) {
				String tmp = mat.group(2);
				boolean bool = tmp == null || tmp.equals("");									
				if (bool)
					return -3502;
			}
			
		rex = "(?i)<mtable>(.*?)</mtable>"; 													// 矩阵缺少项目；
		mat = Pattern.compile(rex).matcher(instr);
			while (mat.find()) {
				String tmp = mat.group(2);
				boolean bool = tmp == null || tmp.equals("");									
				if (bool)
					return -3502;
			}	
				
			
		if (Pattern.compile("(?i)<(m\\w+)[^>]*>\\s*</\\1>").matcher(instr).find())				//彻底为空；
			return -3502;
		if (Pattern.compile("(?i)<m\\w+[^>]*/\\s*>").matcher(instr).find())
			return -3502;
		//}end
			
		return 0;
	}
	
	/**
	 * 删除 mstyle 或 mspace 等无用标签；
	 */
	static String deleteStyle(String instr) {
		String 		rex = "(?i)</?mstyle[^>]*>", 
					ret = instr;
		Matcher 	mat = Pattern.compile(rex).matcher(ret);
		
		while (mat.find()) {
			ret = mat.replaceAll("");
		}
		
		rex = "(?i)<mspace[^>]*>";
		mat = Pattern.compile(rex).matcher(ret);
		while (mat.find()) {
			ret = mat.replaceAll("");
		}
		
		return ret;
	}
	
	
	
	
	
	
	// For test!!!
	/*public static void main(String[] args) {
		//String instr = "<math xmlns=\"http://www.w3.org/1998/Math/MathML\"><mfrac><mrow><mn>15</mn><msup><mi>e</mi><mrow><mo>(</mo><mn>2</mn><mi>x</mi><mo>-</mo><mn>5</mn><msup><mo>)</mo><mn>3</mn></msup></mrow></msup></mrow><mrow><mn>16</mn><mi>b</mi></mrow></mfrac></math>";
		String instr = "<math xmlns=\"http://www.w3.org/1998/Math/MathML\"><mfrac><mrow/><mrow/></mfrac></math>";
		out.println(RegularReview.formater(instr));

	}*/

}
