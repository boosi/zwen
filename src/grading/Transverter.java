package grading;

import java.util.regex.Matcher;
import java.util.regex.Pattern;





/**
 * 转换器，变形各种 MathML 字符串形式；
 * @author Zhengwen 	
 * @date 23 Dec, 2014
 * @version Grading 3.0 Builder	0009
 */
public class Transverter {
	/**与主线程通信（表示启动该类的主线程)*/
	Comparer comm = null;
	
	
	/**
	 * 在检查之前必须要做的变换，将不规范的代码规范；
	 * @param mathTrans		需要变换的字符串；
	 * @return				变换完成并且无错，返回 true，否则返回 false；
	 */
	public static String necessaryTrans(String mathTrans) {
		String res 	= "";
		mathTrans 	= deleteStyle(mathTrans);										// 删除 mstyle 或 mspace 等无用标签；
		mathTrans 	= removeTagProperts(mathTrans);
		mathTrans 	= replaceTag(mathTrans);
		mathTrans 	= modifyTagSup(mathTrans);
		
		return mathTrans;
	}

	
	/**
	 * 删除标签中的属性；
	 * @param instr		源字符串；
	 * @return			返回规范后的字符串；
	 */
	private static String removeTagProperts(String instr) {
		Matcher 	mat 	= null;
		
		mat = Pattern.compile(RexExpr.ENTRY).matcher(instr);
			while (mat.find()) 
				instr = mat.replaceFirst("");
		
		mat = Pattern.compile(RexExpr.TAG_MI).matcher(instr);
			while (mat.find()) 
				instr = mat.replaceFirst("<mi>");
		
		mat = Pattern.compile(RexExpr.TAG_MN).matcher(instr);
			while (mat.find()) 
				instr = mat.replaceFirst("<mn>");
		
		mat = Pattern.compile(RexExpr.TAG_MO).matcher(instr);
			while (mat.find()) 
				instr = mat.replaceFirst("<mo>");
			
		mat = Pattern.compile(RexExpr.XMLTAG).matcher(instr);
			while (mat.find()) {
				instr = mat.replaceFirst("<" + mat.group(1)+ ">");
			}
		
		return instr;
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
		
		mat = Pattern.compile(RexExpr.TAG_SIN).matcher(instr);
			while (mat.find()) 
				instr = mat.replaceFirst("<mi>sin</mi>");
		
		mat = Pattern.compile(RexExpr.TAG_COS).matcher(instr);
			while (mat.find()) {
				instr = mat.replaceFirst("<mi>cos</mi>");
			}
			
		mat = Pattern.compile(RexExpr.TAG_TAN).matcher(instr);
			while (mat.find()) {
				instr = mat.replaceFirst("<mi>tan</mi>");
			}
			
		mat = Pattern.compile(RexExpr.TAG_CSC).matcher(instr);
			while (mat.find()) {
				instr = mat.replaceFirst("<mi>csc</mi>");
			}
			
		mat = Pattern.compile(RexExpr.TAG_SEC).matcher(instr);
			while (mat.find()) {
				instr = mat.replaceFirst("<mi>sec</mi>");
			}
			
		mat = Pattern.compile(RexExpr.TAG_COT).matcher(instr);
			while (mat.find()) {
				instr = mat.replaceFirst("<mi>cot</mi>");
			}
			
		mat = Pattern.compile(RexExpr.TAG_LOG).matcher(instr);
			while (mat.find()) {
				instr = mat.replaceFirst("<mi>log</mi>");
			}
			
		mat = Pattern.compile(RexExpr.TAG_LG).matcher(instr);
			while (mat.find()) {
				instr = mat.replaceFirst("<mi>lg</mi>");
			}
			
			mat = Pattern.compile(RexExpr.TAG_LN).matcher(instr);
			while (mat.find()) {
				instr = mat.replaceFirst("<mi>ln</mi>");
			}
			
		mat = Pattern.compile(RexExpr.TAG_OR).matcher(instr);		// or
			while (mat.find()) {
				instr = mat.replaceFirst("<mo>∨</mo>");
			}
			
		mat = Pattern.compile(RexExpr.TAG_AND).matcher(instr);		//and
			while (mat.find()) {
				instr = mat.replaceFirst("<mo>∧</mo>");
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
		
		mat = Pattern.compile(RexExpr.TAG_SUP1).matcher(instr);	//(括号；
		while (mat.find()) {
			trans = Sharing.sectionalization(mat);
			trans[1] = "<mfenced><mrow>" + trans[1] + "</mrow></mfenced>";
			trans[1] = trans[1].replace("<msup>", "");
			trans[2] = trans[2].replace(trans[3], trans[1]);
			instr = mat.replaceFirst(trans[2]);
		}
		
		mat = Pattern.compile(RexExpr.TAG_SUP1).matcher(instr); //{括号；
		while (mat.find()) {
				trans = Sharing.sectionalization(mat);
					trans[1] = "<mfenced open=\"{\" close=\"}\"><mrow>" + trans[1] + "</mrow></mfenced>";
					trans[1] = trans[1].replace("<msup>", "");
					trans[2] = trans[2].replace(trans[3], trans[1]);
					instr = mat.replaceFirst(trans[2]);
		}
		return ret;
	}
	
	/**
	 * 删除 mstyle 或 mspace 等无用标签；
	 */
	private static String deleteStyle(String instr) {
		Matcher 	mat;
		
		mat = Pattern.compile(RexExpr.TAG_STYLE).matcher(instr);
		while (mat.find()) {
			instr = mat.replaceAll("");
		}
		
		mat = Pattern.compile(RexExpr.TAG_SPEAC).matcher(instr);
		while (mat.find()) {
			instr = mat.replaceAll("");
		}
		
		return instr;
	}
	
	//{rem	说明文本(Remark):
	// 1. 检查之前首先把<mfenced><mrow>联合标签拆散，分为单独的<mfenced>标签与<mrow>标签；以便于分式的格式检查（标准化分式）；
	
	//}end

}
