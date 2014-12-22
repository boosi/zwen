package autogrd;

import org.w3c.dom.Document;



/**
 * （比较）库的主要类，启动比较程序；
 * @author Zhengwen 
 * @date 19 Dec, 2014
 * @version Grading 3.0 Builder 008
 */
public class Comparer {
	
	Inspector 	ipt;
	Phrase		phrase;
	Evaluate	evl;
	Setting 	conf;
	Document	optAns;
	Document	optUsr;
	
	public String strAns 	= "";
	public String strUsr 	= "";
	public boolean model 	= true;		//模式
	public String strConf 	= "";		//设定
	
	
	
	
	/**
	 * 构造器；
	 */
	public Comparer() {	}
	
	/**
	 * 构造器；
	 * @param strans		//正确答案；
	 * @param strusr		//用户输入；
	 * @param isMath		//比较模式；
	 * @param strconf		//设定条件；
	 */
	public Comparer(String strans, String strusr, boolean isMath, String strconf) {
		strAns 		= strans;
		strUsr 		= strusr;
		model 		= isMath;
		strConf 	= strconf;
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
	 * 调用此方法进行表达式比较；
	 * @return		0，等价；否则，不等价；
	 */
	private int Compar() {
		if (model) {														//为真时 mathML 字符串方式比较；
			int chknum = isEmpty();
			if (chknum == 0) {
				conf	= new Setting(this); 
				ipt 	= new Inspector(this);
				phrase 	= new Phrase(this);
				evl		= new Evaluate(this);
			
				try {
					conf.setConfmap(strConf);								//设定比较条件；
					if (!ipt.needful())
						return MsgCode.TRANS_FAIL;
					
					chknum = ipt.check_prompt();							//检查字符串合理性；
					if (chknum == 0) {
						chknum = ipt.node_trim();
						if (chknum == 0) {
						
							optAns = new W3cDocument(phrase.transform(strAns));	//创建新对象；
							optUsr = new W3cDocument(phrase.transform(strUsr));
							if (optAns == null)
									return -6800;
							if (optUsr == null)
									return -6900;
					
							chknum = evl.EvalObject(optAns, optUsr);
						}
					}
				}
				catch (Exception ex) {
					new EventLog().outLog(ex.getMessage());
					chknum = -1010;
				}
			}
			return chknum;
		}
		else {
			return strAns.equals(strUsr) ? 0 : -1000;						//直接比较字符串；
		}
	}
	
	
	
	/**
	 * 输入字符串是否为空或者符合要求的其他条件；
	 * @return		0，符合；其它，不符合；
	 */
	private int isEmpty() {
		int ret		= 0;
		
		if (strAns == null || strAns.equals("") || strUsr == null || strUsr.equals(""))		//空字串；
			return -3502;
		
		if (!Sharing.isMathString(strAns))									//不是 MathML 字符串，需要经过编辑；
			strAns = editor.Editor.getMathStr(strAns);
		if (!Sharing.isMathString(strUsr)) 
			strUsr = editor.Editor.getMathStr(strUsr);						//转换为 MathML字符串；
		
		if (Sharing.illicitChars(strUsr))									//为“真”, 输入含有非法字符；
			return -3012;
		ret = RegularReview.formater(strUsr);								//检查空格、配对、标签等；
		if (ret != 0)
			return ret;
		
		
		
		return ret;
	}

	
	
	
	
	
	
	
	
	
	// For test!
	public static void main(String[] args) {
		String s1 = "<math xmlns=\"http://www.w3.org/1998/Math/MathML\"><mn>65</mn><mi>x</mi></math>";
		String s2 = "24";
		String s4 = "121";
		boolean s3 = true;
		int result = Comparison(s1,s2,s3,s4);
		System.out.print("\nResult of Compare:\t" + result);
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
	 * 1. 运行规范化程序，将不规范的 mathml 字符串代码规范为标准的字符串；
	 * 2. 检查字符串是否符合比较的‘条件设定’；（不符合的要 Prompt）
	 * 3. 将 mathml 字符串对象化为‘文档对象’；（对象化）
	 * 4. 检查‘文档对象’是否合理及符合‘比较条件’；（以文档对象格式检查是否符合数学规范）
	 * 5. 进行赋值；（最终给未知变量赋值）
	 * 6。 比较并返回结果；（返回比较结果）
	 */
	
	/*
	 * 类的创建：
	 * 1. 可以让该类继承 Thread 类，然后启动新的线程；
	 * 2. 在新的线程中完成比较任务；
	 * 3. 设定某个变量为返回值；
	 * 4. 将比较结果返回给调用程序；	
	 */
	
	
	
	
}