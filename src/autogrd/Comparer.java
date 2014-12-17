package autogrd;

import java.util.regex.Pattern;

import org.w3c.dom.Document;



/**
 * 库（比较）的主要类，启动比较程序；
 * @author Zhengwen
 * 
 *17 Dec, 2014
 */
public class Comparer {
	
	public String strAns 	= "";		//答案
	public String strUsr 	= "";		//输入
	public boolean model 	= true;		//模式
	public String strConf 	= "";		//设定
	
	public Document		optAns = null;
	public Document		optUsr = null;
	
	
	
	
	/**
	 * 构造器；
	 */
	public Comparer() {
		
	}
	
	/**
	 * 构造器；
	 * @param strans		//正确答案；
	 * @param strusr		//用户输入；
	 * @param isMath			//比较模式；
	 * @param strconf		//设定条件；
	 */
	public Comparer(String strans, String strusr, boolean isMath, String strconf) {
		strAns 		= strans;
		strUsr 		= strusr;
		model 		= isMath;
		strConf 	= strconf;
	}
	
	
	
	/**
	 * 调用此方法进行表达式比较；
	 * @return		0，等价；否则，不等价；
	 */
	public int Compar() {
		if (model) {
			int chknum = checking();
			if (chknum == 0) {
				if (!Config.setConfmap())
					return MsgCode.CONFIG_ERROR;
				if (!Inspector.needful())
					return MsgCode.TRANS_FAIL;
				chknum = Inspector.checking();
				if (chknum == 0) {
					//检查字符串合理性；
					
					
					
					
				
				
						optAns = OptDocumt.generatDocument(strAns);
						optUsr = OptDocumt.generatDocument(strUsr);
						if (optAns == null)
								return -6800;
						if (optUsr == null)
								return -6900;
				
					
						
						
						
					chknum = Evaluate.EvalObject(optAns, optUsr);
				}
			}
			return chknum;
		}
		else {
			return strAns.equals(strUsr) ? 0 : -1000;
		}
	}
	
	
	
	/**
	 * 主类；对 MathML 字符串进行比较；
	 * @param strAnswer			正确答案字符串；
	 * @param strInput			用户输入字符串；
	 * @param model				比较的模式；
	 * @param setting			比较的条件设定；
	 * @return					返回:[0, 等值；任何其他; 不等值；]
	 */
	public static int Comparison(String strans, String strusr, boolean model, String strconf) {
		Comparer comparer = new Comparer(strans, strusr, model, strconf);
		return comparer.Compar();
	}
	
	
	
	/**
	 * 检查输入字符串是否合格；
	 * @return		0，合格；其它，不合格；
	 */
	private int checking() {
		String instr = "";
		
		if (strAns == null || strAns.equals(""))		//空；
			return -3502;
		if (strUsr == null || strUsr.equals("")) 
			return -3502;
		
		if (Pattern.compile("<math[^>]*>.+</math>").matcher(strUsr).find()) {
			instr = strUsr;
		}
		else  {											//不是 MathML 字符串；
			if (Sharing.illicitChars(strUsr))			//非法字符；
				return -3012;
			instr = editor.Editor.getMathStr(strUsr);	//转换为 MathML字符串；
		}
		strUsr = instr;
		return 0;
	}

}



/**
 * 评估两个对象是否等价；
 * @author Zhengwen
 * 
 *17 Dec, 2014
 */
class Evaluate {
	public Evaluate() {
		
	}
	
	
	public static int EvalObject(Object obj1, Object obj2) {
		
		
		return 0;
	}
	
	
}




/**
 * 程序说明；
 * @author Zhengwen
 * 
 *17 Dec, 2014
 */
class Remark {
	
	/* 操作思路：
	 * 1. 运行规范化程序，将不规范的 mathml 字符串代码规范为标准的字符串；EventQua
	 * 2. 检查字符串是否符合比较的‘条件设定’；（不符合的要 Prompt）
	 * 3. 将 mathml 字符串对象化为‘文档对象’；（对象化）
	 * 4. 检查‘文档对象’是否合理及符合‘比较条件’；（以文档对象格式检查是否符合数学规范）
	 * 5. 进行赋值；（最终给未知变量赋值）
	 * 6。 比较并返回结果；（返回比较结果）
	 */
	
	
	
	
}