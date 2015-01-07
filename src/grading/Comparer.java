package grading;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
	 * 主类；对 MathML 字符串进行比较；调用比较器；<br/>
	 * 启动比较程序的主类；
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
		int chknum = -1000;
		chknum = isEmpty();								//检查字串是否为空；code:3502 or 6100
		if (chknum != 0)
			return chknum; 
		if (model) {									//model 为真, mathML 字符串；
			chknum = ReviewInput();						//检查输入合理与完整性；	code:3502,6100.3012,3010;
			if (chknum != 0) 
				return chknum;							//不合格则退出程序；
			
			conf	= new Setting(this); 				//环境搭建；
			insp 	= new Inspector(this);
			equt 	= new Equation(this);
			eval	= new Evaluate(this);
			print("1.usrStr:\t" + usrStr);
				
			try {
				ansStr = Transverter.necessaryTrans(ansStr);	//规范 MathML 字串,格式化为唯一表达形式；
				usrStr = Transverter.necessaryTrans(usrStr);
				print("2.usrStr:\t" + usrStr);					//分阶段检查、输出、调试 bug；
				
				conf.setConfmap(strConf);						//设置比较条件；
				
				//{rem 启动比较；
				chknum = insp.violationRules(usrStr);						//字符串违例；
				if (chknum == 0) {
					chknum = insp.violationNode(usrStr);					//节点违规；
					if (chknum == 0) {
						ansStr = equt.transform(ansStr);					//最终变换及赋值；
						usrStr = equt.transform(usrStr);					//最终变换及赋值；
						ansDom = new OperatObject(ansStr).getDocument();	//重建对象；
						ansDom = new OperatObject(ansStr).getDocument();	//重建对象；
						if (ansDom == null)
								return -6800;								//如果为空，中止程序；
						if (usrDom == null)
								return -6900;								//如果为空，中止程序；
						chknum = eval.EvalObject(ansDom, usrDom);			//评估表达式；
					}
				}
				//}end
			}
			catch (Exception ex) {
				new Log().outLog(ex.getMessage());		//错误写入日志；
				chknum = -1000;
			}
			
			return chknum;
		}
		else {
			return ansStr.equals(usrStr) ? 0 : -1000;										//直接比较字符串；
		}
	}
	
	
	
	/**
	 * 输入是否为空或者格式有空缺；
	 */
	private int isEmpty() {
		if (ansStr == null || ansStr.equals("") || usrStr == null || usrStr.equals(""))		//空字串；
			return -6100;
		
		return isNull();																	//检查格式有空否(null)； code:3502;
	}
	
	
	private int isNull() {
		int count;
		count = 0;
		Matcher mat = Pattern.compile("(\\)|\\()").matcher(usrStr);
		while (mat.find()) 
			count++;
		if (count % 2 != 0) 				//括号不配对；
			return -3502;
		count = 0;							//还原；
		mat = Pattern.compile("(\\{|\\})").matcher(usrStr);
		while (mat.find()) 
			count++;
		if (count % 2 != 0)
			return -3502;
		count = 0;
		mat = Pattern.compile("\\|").matcher(usrStr);
		while (mat.find()) 
			count++;
		if (count % 2 != 0)
			return -3502;
		
		return 0;
	}

	/**
	 * 检查输入字符串是否含有非法字符或空格等；
	 * <br/>检查字串的完整性；
	 * @return
	 */
	private int ReviewInput() {
		int chknum = 0;
		if (!Sharing.isMathString(ansStr)){												//不是 MathML 字符串，需要经过编辑；
			if (Sharing.illicitChars(ansStr))											//为“真”, 输入含有非法字符；
				return -3012;
			ansStr = editor.Editor.getMathStr(ansStr);
		}
		if (!Sharing.isMathString(usrStr)) {
			if (Sharing.illicitChars(usrStr))											//为“真”, 输入含有非法字符；
				return -3012;
			usrStr = editor.Editor.getMathStr(usrStr);									//转换为 MathML字符串；
		}
		
		chknum = Inspector.incompleteNode(usrStr);											//检查空格、配对、标签等；
		return 	chknum;
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
	 * 	2. 检查字符串是否合理及完整性；
	 *  3. 检查文档对象的节点是否违规；
	 * 	4. 转换字符串为标准的、唯一的，并且重新创建新文档对象；
	 * 	5. 进行赋值；（最终给未知变量赋值）；
	 * 	6. 比较并返回结果；（返回比较结果）；
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
	 * 检查器分为几部分：
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