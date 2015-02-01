package grading;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.w3c.dom.Document;

import test.Examine;



/**
 * 检查器，检查 mathml 字符串‘合理性’；
 * @author Zhengwen 
 * @date 23 Dec, 2014
 * @version Grading 3.0 Builder	008
 */
public final class Inspector {
	/**与主线程通信（表示启动该类的主线程)*/
	Comparer 		comm 		= null;
	Matcher 		mat			= null;
	
	private Map<String, String> confmap;						//比较方式的设定；
	private String 				testTxt		= "";
	
	public Document document = null;							//当前‘文档对象’；
	
	
	
	//{rem	构造
	/** 构造器； */
	public Inspector() {
		comm 		= new Comparer();
		confmap		= comm.conf.ConfigMap;
	}
	/** 构造器； 
	 * * @param conponentObject		启动比较程序的主类对象，通常为 Comparer 类；
	 */
	public Inspector(Object conponentObject) {
		comm 		= (Comparer) conponentObject;
		confmap		= comm.conf.ConfigMap;
	}
	/** 测试使用的构造器；*/
	public Inspector(String fortestTxt) {
		testTxt = fortestTxt;
		comm 		= new Comparer();
		//confmap		= comm.conf.ConfigMap;
	}
	//}end
	
	
	
	/**
	 * 检查文本是否含有空格、回车字符，以及格式是否完整；
	 * @param string		来源字串；
	 * @return				0，合理；其他，不合理；
	 */
	public static int incompleteNode(String string) {
		Matcher mat = Pattern.compile(RexExpr.SPACE).matcher(string);	//space character.
			while (mat.find()) 
				return -3010;
		mat = Pattern.compile(RexExpr.MathEnter).matcher(string);
			while (mat.find()) 
				return -3015;
		
		mat = Pattern.compile(RexExpr.CONTENT_NULL).matcher(string);	//Null 节点；
			while (mat.find()) 
				return -6100;
		mat = Pattern.compile(RexExpr.CONTENT_EMPTY).matcher(string);	//空节点；
			while (mat.find()) 
				return -6100;
		
		//{rem 不完整节点	
		mat = Pattern.compile(RexExpr.TWO_CHILD_NODE).matcher(string);							//分式、指数、下角标、开任意方、上标、小标等；
			while (mat.find()) {
				String tmp = mat.group(2);
				boolean bool = Pattern.compile(RexExpr.ABREAST_NODE).matcher(tmp).matches();	//缺少两个项目中的任一个（不能完全匹配）；
				if (!bool)
					return -3502;
			}
		mat = Pattern.compile(RexExpr.TAG_ROW_SQRT).matcher(string);								//开平方以及行处理等；
			while (mat.find()) {
				String tmp = mat.group(2);
				boolean bool = tmp == null || tmp.equals("");									
				if (bool)
					return -3502;
			}
		mat = Pattern.compile(RexExpr.TAG_MFENCED).matcher(string);							// 括号、绝对值、花括弧等内容为空（软键盘）；
			while (mat.find()) {
				String tmp = mat.group(2);
				boolean bool = tmp == null || tmp.equals("");									
				if (bool)
					return -3502;
			}
		mat = Pattern.compile(RexExpr.TAG_MTABLE).matcher(string);							// 矩阵缺少项目；
			while (mat.find()) {
				String tmp = mat.group(2);
				boolean bool = tmp == null || tmp.equals("");									
				if (bool)
					return -3502;
			}	
		mat = Pattern.compile(RexExpr.CONTENT_EMPTY).matcher(string);							//彻底为空；
		if (mat.find())												
			return -3502;
		mat = Pattern.compile(RexExpr.CONTENT_EMPTY).matcher(string);
		if (mat.find())
			return -3502;
		//}end
		
		
		//调试，暂时屏蔽；
		/**
		mat = Pattern.compile(RexExpr.MATH_TAG).matcher(string);
		while (!mat.find())
			return -3504;		
		**/
		return 0;
	}
	
	
	/**
	 * 规范字符串，使得该字符串仅有唯一形式；
	 * @param instr		源字串；
	 * @return			返回提示码或错误码；
	 */
	public int checkStandar(String instr) {
		String 	rex;
		Matcher mat;
		
		//{rem 	格式检查；		
		//}end
		
		comm.usrStr = instr;																//最终修改并赋值；
		return 0;
	}

	
	/**
	 * 在检查之前必须要做的变换，将不规范的代码规范；
	 * @param wdoc		
	 * @return
	 */
	public boolean necessaryTrans() {
		boolean res = true;
		System.out.print(confmap.get("\t\t122"));
		return res;
	}
	
	
	/**
	 * 检查 MathML 字符串违背规则；
	 * @return		返回代码:[0, OK; 其他，代表错误类型]
	 */
	public int violationRules(String instr) {
		
		
		return 0;
	}
	
	
	/**
	 * 以节点树形式检查 math 表达式的合理性；
	 * @return		错误代码:[0, OK; 其他，代表错误类型]
	 */
	public int violationNode(String instr) {
		
		return 0;
	}
	
	
	/**
	 * 字符串变形为合理等价的数学表达式；
	 * @return
	 */
	public int neaten() {
		
		return 0;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
