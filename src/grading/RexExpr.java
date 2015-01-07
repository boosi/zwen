package grading;




/**
 * 专门处理正则表达式的相关检查；<br/>
 * 全部为静态函数；不能继承；
 * @author Zhengwen 
 * @date 19 Dec, 2014
 * @version Grading 3.0 Builder 0009
 */
public final class RexExpr {

	//	&lt;TAG&gt;       &lt;/TAG&gt;  //
	
	//{rem 系统与简单的符号；
	/** 空格字符, #160; **/
	static String 		SPACE				= "(?i)<mo>&#160;</mo>";
	/** 换行与回车符, \r or \n */
	static String		ENTRY				= "(?i)(?:\\r|\\n)";
	/** MathML 换行(回车符) */
	static String 		MathEnter			= "(?i)</?mspace[^>]*>";
	/** 标识符（变量） */
	static String 		TAG_MI				= "(?i)<mi[^>]*>";
	/** 数字常数（数字） */
	static String 		TAG_MN				= "(?i)<mn[^>]*>";
	/** 运算符（+，-，*， /）等； */
	static String 		TAG_MO				= "(?i)<mo(?!ver)[^>]*>";
	/** MathML 标签，&lt;math&gt; **/
	static String 		TAG_MATH			= "<math[^>]*>(.+)</math>";
	/** MathML语言系统所有标签<br/>
	 * (包含全部开闭标签) */
	static String 		TAG_ALL				= "(?i)<\\s*/?\\s*m\\w+[^>]*>";
	/** MathML语言系统常用标签<br/>
	 * m(?:ath|sup|sub|frac|sqrt|root|table
	 * |tr|td|row|text|over|under */
	static String 		XMLTAG				= "(?i)<(m(?:ath|sup|sub|frac|sqrt|root|table|tr|td|row|text|over|under|i|n|o))[^>]*>";
	//}end
	
	
	/** 任何标签字符串（无论是否含属性） **/
	static String 		ANY_TAG				= "(?i)(?<=>)[^<>]+?(?=</)";
	/**不含非法字符的其它所有字符	**/
	static String 		CORRECT_CHAR		= "[^\\w\\+\\-\\(\\)\\=\\<\\>,\\|\\{\\}\\:\\.(\\u03B1-\\u03D6)(&#(?:215|247|945|946|952|960|8745|8746|8804|8805|9651);)]";
	/** 并排节点， &lt;(m\w+)&gt;内容1&lt;/\1
	 * &gt;&lt;(m\w+)&gt;内容2&lt;/\2&gt; **/
	static String 		ABREAST_NODE		= "(?i)<(m\\w+)>.+?</\\1><(m\\w+)>.+?</\\2>";
	/** 双字节点， &lt;m(?:frac|sup|sub|root
	 * |over|under)&gt;内容&lt;/\1&gt; **/
	static String 		TWO_CHILD_NODE		= "(?i)<(m(?:frac|sup|sub|root|over|under))[^>]*>(.*?)</\\1>";
	/** &lt;mrow|msqrt&gt;任意内容&lt;/\1&gt; **/
	static String 		ROW_SQRT			= "(?i)<(m(?:row|sqrt))[^>]*>(.*?)</\\1>";
	
	
	/** &lt;mfenced&gt;内容&lt;mfenced&gt; **/
	static String 		TAG_MFENCED			= "(?i)<mfenced>(.*?)</mfenced>";
	/** &lt;mtable&gt;表格&lt;/mtable&gt; **/
	static String 		TAG_MTABLE 			= "(?i)<mtable>(.*?)</mtable>";
	/** Null节点 **/
	static String 		INCOMPLETE_1		= "(?i)<\\s*(m\\w+)[^>]*/\\s*>"; 
	/** 空节点 **/
	static String 		INCOMPLETE_2		= "(?i)<\\s*(m\\w+)[^>]*>\\s*</\\1>";
	/** 不完整节点 **/
	static String 		INCOMPLETE_3		= "(?i)<(m\\w+)[^>]*>\\s*</\\1>";
	
	
	/** 单个空标签 **/
	static String 		TAG_SINGLE_EMPTY	= "(?i)<m\\w+[^>]*/\\s*>";
	/** &lt;style 属性&gt;内容&lt;/style&gt; */
	static String 		TAG_STYLE			= "(?i)</?mstyle[^>]*>";
	/** 空格标签 */
	static String 		TAG_SPEAC			= "(?i)</?mspace[^>]*>";
	
	
	
	//{rem 三角函数  标签 */
	static String 		TAG_SIN				= "(?i)<(m(?:i|text))>\\s*s\\s*(</\\1><(m(?:i|text))>)?\\s*i\\s*(</\\1><(m(?:i|text))>)?\\s*n\\s*</\\1>";
	static String 		TAG_COS				= "(?i)<(m(?:i|text))>\\s*c\\s*(</\\1><(m(?:i|text))>)?\\s*o\\s*(</\\1><(m(?:i|text))>)?\\s*s\\s*</\\1>";
	static String 		TAG_TAN				= "(?i)<(m(?:i|text))>\\s*t\\s*(</\\1><(m(?:i|text))>)?\\s*a\\s*(</\\1><(m(?:i|text))>)?\\s*n\\s*</\\1>";
	static String 		TAG_CSC				= "(?i)<(m(?:i|text))>\\s*c\\s*(</\\1><(m(?:i|text))>)?\\s*s\\s*(</\\1><(m(?:i|text))>)?\\s*c\\s*</\\1>";
	static String 		TAG_SEC				= "(?i)<(m(?:i|text))>\\s*s\\s*(</\\1><(m(?:i|text))>)?\\s*e\\s*(</\\1><(m(?:i|text))>)?\\s*c\\s*</\\1>";
	static String 		TAG_COT				= "(?i)<(m(?:i|text))>\\s*c\\s*(</\\1><(m(?:i|text))>)?\\s*o\\s*(</\\1><(m(?:i|text))>)?\\s*t\\s*</\\1>";
	//}end
	
	
	//{rem	对数
	static String 		TAG_LOG				= "(?i)<(m(?:i|text))>\\s*l\\s*(</\\1><(m(?:i|text))>)?\\s*o\\s*(</\\1><(m(?:i|text))>)?\\s*g\\s*</\\1>";
	static String 		TAG_LG				= "(?i)<(m(?:i|text))>\\s*l\\s*(</\\1><(m(?:i|text))>)?\\s*g\\s*</\\1>";
	static String 		TAG_LN				= "(?i)<(m(?:i|text))>\\s*l\\s*(</\\1><(m(?:i|text))>)?\\s*n\\s*</\\1>";
	//}end
	
	
	//{rem	与 或
	static String 		TAG_AND				= "(?i)<(m(?:i|text))>\\s*a\\s*(</\\1><(m(?:i|text))>)?\\s*n\\s*(</\\1><(m(?:i|text))>)?\\s*d\\s*</\\1>";
	static String 		TAG_OR				= "(?i)<(m(?:i|text))>\\s*o\\s*(</\\1><(m(?:i|text))>)?\\s*r\\s*</\\1>";
	//}end
	
	
	//{rem 键盘输入括号的平方
	static String 		TAG_SUP1			= "(?i)<mo>\\(</mo>(.*?)(<msup>(<mo>\\)</mo>)<mn>3</mn></msup>)";		//(括号
	static String 		TAG_SUP2			= "(?i)<mo>\\{</mo>(.*?)(<msup>(<mo>\\}</mo>)<mn>3</mn></msup>)";		//{括号
	
	//}end
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	// For test!!!
	/*public static void main(String[] args) {
		//String instr = "<math xmlns=\"http://www.w3.org/1998/Math/MathML\"><mfrac><mrow><mn>15</mn><msup><mi>e</mi><mrow><mo>(</mo><mn>2</mn><mi>x</mi><mo>-</mo><mn>5</mn><msup><mo>)</mo><mn>3</mn></msup></mrow></msup></mrow><mrow><mn>16</mn><mi>b</mi></mrow></mfrac></math>";
		String instr = "<math xmlns=\"http://www.w3.org/1998/Math/MathML\"><mfrac><mrow/><mrow/></mfrac></math>";
		out.println(RegularReview.formater(instr));

	}*/

}
