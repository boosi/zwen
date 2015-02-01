package grading;




/**
 * 正则表达的匹配类；表示相关匹配与检查的正则表达式；<br/>
 * 静态类，非继承；
 * @author Zhengwen 
 * @date 19 Dec, 2014
 * @version Grading 3.0 Builder 0009
 */
public final class RexExpr {
	
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
	
	
	/** 匹配任何 XML 标签。 */
	static String		ANY_TAG				= "(?i)<\\s*/?\\s*m\\w+[^>]*>";
	/** 匹配任何含有属性的 XML 标签。注意：这个选择包括&lt;mfenced&gt;标签，也许使用中需要排除此标签。 **/
	static String 		PROPERT_TAG			= "(?i)<(m[a-z&&[^gjkwz]]+)\\s+[^>]+>";
	/** 匹配任何内容。提取不含 XML 标签的所有（纯内容的）文本。 **/
	static String 		ANY_CONTENT			= "(?i)(?<=>)[^<>]+?(?=<\\s*/)";
	/** 匹配不含（正则表达式）指定字符的其它（所有）字符。<br/>用于查找非法字符。 **/
	static String 		CORRECT_CHAR		= "[^\\w\\+\\-\\(\\)\\=\\<\\>,\\|\\{\\}\\:\\.(\\u03B1-\\u03D6)(&#(?:215|247|945|946|952|960|8745|8746|8804|8805|9651);)]";
	/** 凡是两个标签为同级，则匹配。（并排节点）。<br/> &lt;(m\w+)&gt;内容1&lt;/\1
	 * &gt;&lt;(m\w+)&gt;内容2&lt;/\2&gt; **/
	static String 		ABREAST_NODE		= "(?i)<(m\\w+)>.+?</\\1><(m\\w+)>.+?</\\2>";
	/** 如果子节点仅包含两个节点的节点（标签），则匹配。<br/> &lt;m(?:frac|sup|sub|root|over|under)&gt;内容&lt;/\1&gt; **/
	static String 		TWO_CHILD_NODE		= "(?i)<(m(?:frac|sup|sub|root|over|under))[^>]*>(.*?)</\\1>";
	
	//{rem	匹配内容
	/** 匹配节点无实质内容的标签；<BR/>e.g. &lt;mrow>   &lt;/mrow> **/
	static String 		CONTENT_EMPTY		= "(?i)<\\s*(m\\w+)[^>]*>\\s*</\\1>";
	/** 如果节点打开和关闭标签都是同一个标签，则匹配。e.g. &lt;mrow/><br/>内容为空（内容 = NULL）。 **/
	static String 		CONTENT_NULL	= "(?i)<m\\w+[^>]*/\\s*>";
	//}end
	
	//{rem	匹配标签	
	/** 标签名称为 &lt;mrow&gt; 和 &lt;msqrt&gt;，则匹配。<br/>e.g. : &lt;mrow&gt;任意内容&lt;/\1&gt; 或 &lt;msqrt>内容&lt;\1>**/
	static String 		TAG_ROW_SQRT			= "(?i)<(m(?:row|sqrt))[^>]*>(.*?)</\\1>";
	/** 标签名称为 &lt;mfenced&gt;则匹配。不论是否有&lt;mrow&gt;标签配合。<br/>(通常在三角函数或者对数函数中，表示将完整的表达式取对数或三角函数。<br/>其它情况多数会附加&lt;mrow&gt;标签)<br/> &lt;mfenced&gt;内容&lt;mfenced&gt; **/
	static String 		TAG_MFENCED			= "(?i)<mfenced>(.*?)</mfenced>";
	/** 标签名称为&lt;mtable&gt;则匹配；表示矩阵。<br/>e.g. :  &lt;mtable&gt;表格&lt;/mtable&gt; */
	static String 		TAG_MTABLE 			= "(?i)<mtable>(.*?)</mtable>";
	/** 匹配标签名称为  &lt;style>的标签。对应 MathML 语言的版式设定。<br/>e.g. : &lt;style 属性&gt;内容&lt;/style&gt; */
	static String 		TAG_STYLE			= "(?i)</?mstyle[^>]*>";
	/** 匹配标签名称为 &lt;mspace&gt;的标签。对应 MathML 语言的换行字符。<br/>空格标签 */
	static String 		TAG_SPEAC			= "(?i)</?mspace[^>]*>";
	/** 匹配键盘输入的左边圆括弧  **/
	static String 		TAG_LEFT_BRACKET	= "(?i)<mo>\\(</mo>";
	/** 匹配键盘输入的右边圆括弧  **/
	static String 		TAG_RIGHT_BRACKET	= "(?i)<mo>\\)</mo>";
	//}end
	
	
	//{rem 三角函数  标签 */
	/** 匹配所有三角函数的标签。将分散的标签合并为一个标签。 */
	static String 		TAG_SIN				= "(?i)<(m(?:i|text))>\\s*s\\s*(</\\1><(m(?:i|text))>)?\\s*i\\s*(</\\1><(m(?:i|text))>)?\\s*n\\s*</\\1>";
	static String 		TAG_COS				= "(?i)<(m(?:i|text))>\\s*c\\s*(</\\1><(m(?:i|text))>)?\\s*o\\s*(</\\1><(m(?:i|text))>)?\\s*s\\s*</\\1>";
	static String 		TAG_TAN				= "(?i)<(m(?:i|text))>\\s*t\\s*(</\\1><(m(?:i|text))>)?\\s*a\\s*(</\\1><(m(?:i|text))>)?\\s*n\\s*</\\1>";
	static String 		TAG_CSC				= "(?i)<(m(?:i|text))>\\s*c\\s*(</\\1><(m(?:i|text))>)?\\s*s\\s*(</\\1><(m(?:i|text))>)?\\s*c\\s*</\\1>";
	static String 		TAG_SEC				= "(?i)<(m(?:i|text))>\\s*s\\s*(</\\1><(m(?:i|text))>)?\\s*e\\s*(</\\1><(m(?:i|text))>)?\\s*c\\s*</\\1>";
	static String 		TAG_COT				= "(?i)<(m(?:i|text))>\\s*c\\s*(</\\1><(m(?:i|text))>)?\\s*o\\s*(</\\1><(m(?:i|text))>)?\\s*t\\s*</\\1>";
	//}end
	
	
	//{rem	对数
	/** 匹配所有对数函数的标签。将分散的标签合并为一个标签。 */
	static String 		TAG_LOG				= "(?i)<(m(?:i|text))>\\s*l\\s*(</\\1><(m(?:i|text))>)?\\s*o\\s*(</\\1><(m(?:i|text))>)?\\s*g\\s*</\\1>";
	static String 		TAG_LG				= "(?i)<(m(?:i|text))>\\s*l\\s*(</\\1><(m(?:i|text))>)?\\s*g\\s*</\\1>";
	static String 		TAG_LN				= "(?i)<(m(?:i|text))>\\s*l\\s*(</\\1><(m(?:i|text))>)?\\s*n\\s*</\\1>";
	//}end
	
	
	//{rem	and(与), or(或)
	/** 匹配内容为 ‘and’、‘or’。将内容转换为标准格式。 */
	static String 		TAG_AND				= "(?i)<(m(?:i|text))>\\s*a\\s*(</\\1><(m(?:i|text))>)?\\s*n\\s*(</\\1><(m(?:i|text))>)?\\s*d\\s*</\\1>";
	static String 		TAG_OR				= "(?i)<(m(?:i|text))>\\s*o\\s*(</\\1><(m(?:i|text))>)?\\s*r\\s*</\\1>";
	//}end
	
	
	//{rem 匹配格式
	/** 匹配格式。对应‘键盘输入的圆括号配合指数’的转换。  */
	static String 		TAG_SUP1			= "(?i)<mo>\\(</mo>(.*?)(<msup>(<mo>\\)</mo>)<mn>3</mn></msup>)";		//(括号
	static String 		TAG_SUP2			= "(?i)<mo>\\{</mo>(.*?)(<msup>(<mo>\\}</mo>)<mn>3</mn></msup>)";		//{括号
	
	//}end
	
	
	
	
	
	
	
	
	//{rem For test!!!
	/*
	 public static void main(String[] args) {
		//String instr = "<math xmlns=\"http://www.w3.org/1998/Math/MathML\"><mfrac><mrow><mn>15</mn><msup><mi>e</mi><mrow><mo>(</mo><mn>2</mn><mi>x</mi><mo>-</mo><mn>5</mn><msup><mo>)</mo><mn>3</mn></msup></mrow></msup></mrow><mrow><mn>16</mn><mi>b</mi></mrow></mfrac></math>";
		String instr = "<math xmlns=\"http://www.w3.org/1998/Math/MathML\"><mfrac><mrow/><mrow/></mfrac></math>";
		out.println(RegularReview.formater(instr));

	*/
	//}end 

}
