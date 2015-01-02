package grading;

import org.w3c.dom.Document;

import test.Examine;
import static grading.Log.*;


/**
 * 比较器，类库的启动类，启动比较程序；
 * @author Zhengwen 
 * @date 19 Dec, 2014
 * @version Grading 3.0 Builder 0009
 */
public class Comparer {
	
	Inspector 	insp;
	Equation	equt;
	Evaluate	eval;
	Setting 	conf;
	Document	ansDom;
	Document	usrDom;
	
	public String ansStr 	= "";
	public String usrStr 	= "";
	public boolean model 	= true;		//模式
	public String strConf 	= "";		//设定
	
	
	//public OperatObject 	oo1;		//操作对象；
	//public OperatObject 	oo2;		//输入的操作对象；
	
	
	
	//{rem 构造器；
	/** 构造; */
	public Comparer() {	}
	
	/** 
	 * 构造；
	 * @param strans		//正确答案；
	 * @param strusr		//用户输入；
	 * @param isMath		//比较模式；
	 * @param strconf		//设定条件；
	 */
	public Comparer(String strans, String strusr, boolean isMath, String strconf) {
		ansStr 		= strans;
		usrStr 		= strusr;
		model 		= isMath;
		strConf 	= strconf;
	}
	//}end
	
	
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
	 * 调用此方法进行表达式比较；
	 * @return		0，等价；否则，不等价；
	 */
	private int Compar() {
		if (model) {									//为真时 mathML 字符串方式比较；
			int chknum = isEmpty();						//检查字串是否为空；
			if (chknum == 0) {
				conf	= new Setting(this); 			//环境搭建；
				insp 	= new Inspector(this);
				equt 	= new Equation(this);
				eval	= new Evaluate(this);
			
				print("1. Debug.Xmlstr:\t" + usrStr);
				
				chknum = insp.checkStandar(usrStr);		//检查字串的标准化与唯一化；
				if (chknum != 0)
					return chknum;
				
				try {
					conf.setConfmap(strConf);						//设定比较条件；
					ansStr = Transverter.necessaryTrans(ansStr);	//规范 MathML 字串；
					usrStr = Transverter.necessaryTrans(usrStr);	//规范 MathML 字串；
					
					
					print("2. Debug.Xmlstr:\t" + usrStr);			//分阶段检查、输出、调试 bug；
					
					
					
					
					
					
					
					
					chknum = insp.violationRules();					//检查MathML 字符串违例；
					if (chknum == 0) {
						chknum = insp.violationNode();				//检查节点违背规则
						if (chknum == 0) {
							ansStr = equt.transform(ansStr);		//最终转换为对象
							usrStr = equt.transform(usrStr);		//最终转换为对象
							ansDom = new OperatObject(ansStr).getDocument();				//重新创建对象；
							ansDom = new OperatObject(ansStr).getDocument();				//重新创建对象；
							/*if (ansDom == null)
									return -6800;
							if (usrDom == null)
									return -6900;*/
							chknum = eval.EvalObject(ansDom, usrDom);
						}
					}
				}
				catch (Exception ex) {
					new Log().outLog(ex.getMessage());
					chknum = -1010;
				}
			}
			return chknum;
		}
		else {
			return ansStr.equals(usrStr) ? 0 : -1000;										//直接比较字符串；
		}
	}
	
	
	
	/**
	 * 输入字符串包含空格或非法字符；
	 * @return		0，不包含；其它，非法或不合格字串；
	 */
	private int isEmpty() {
		if (ansStr == null || ansStr.equals("") || usrStr == null || usrStr.equals(""))		//空字串；
			return -3502;
		
		if (!Sharing.isMathString(ansStr))													//不是 MathML 字符串，需要经过编辑；
			ansStr = editor.Editor.getMathStr(ansStr);
		if (!Sharing.isMathString(usrStr)) 
			usrStr = editor.Editor.getMathStr(usrStr);										//转换为 MathML字符串；
		
		if (Sharing.illicitChars(usrStr))													//为“真”, 输入含有非法字符；
			return -3012;
		
		return Inspector.hasSpace(usrStr);													//检查空格、配对、标签等；
	}

	
	
	
	
	
	
	
	
	
	//{rem For test!
	public static void main(String[] args) {
		String s1 = Examine.BASE;
		String s2 = "24";
		String s4 = "121";
		boolean s3 = true;
		int result = Comparison(s1,s2,s3,s4);
		print("\nResult of Compare:\t" + result);
	}
	
	//}end
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}






/**
 * 程序说明；
 * @author Zhengwen
 * 
 *17 Dec, 2014
 */
class Remark {
	
	/* 操作思路：
	 * 	1. 运行规范化程序，将不规范的 mathml 字符串代码规范为标准的字符串；
	 * 	2. 检查字符串是否符合比较的‘条件设定’；（不符合的要 Prompt）
	 * 	3. 将 mathml 字符串对象化为‘文档对象’；（对象化）
	 * 	4. 检查‘文档对象’是否合理及符合‘比较条件’；（以文档对象格式检查是否符合数学规范）
	 * 	5. 进行赋值；（最终给未知变量赋值）
	 * 	6. 比较并返回结果；（返回比较结果）
	 * 
	 */
	
	/*
	 * 类创建：
	 * 	1. 可以让该类继承 Thread 类，然后启动新的线程；
	 * 	2. 在新的线程中完成比较任务；
	 * 	3. 设定某个变量为返回值；
	 * 	4. 将比较结果返回给调用程序；	
	 * 
	 */
	
	/*
	 * 注意事项：
	 * 	1. 比较前一定要首先确定比较条件和设定 HashMap;
	 * 
	 * 
	 */
	
	
	/*
	 * 检查器分为两部分：
	 * 	1. 数字检查器；
	 * 	2. 代数检查器；
	 * 	3. 表达式还有多项式检查器；
	 * 	4. 检查器中设定一个字符串变量，该变量为唯一操作字符串，代表用户输入的字符串。
	 * 		当计算完成时，应该使得改变量再次返回给调用程序；
	 * 
	 */
	
	/*
	 *转换器分三部分：
	 *	1. 必须的转换；（格式化与标准化过程）
	 *	2. 通用转换；(当接收非法字符时，可以转换的内容需要标准化)
	 *	3. 最终转换；（最后的阶段，需要将变量赋值前）
	 *	4. 转换器的变量设定仿照检查器。
	 *
	 */
	
}