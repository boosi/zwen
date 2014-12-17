package autogrd;


/**
 * 库（比较）的主要类，启动比较程序；
 * @author Zhengwen
 * 
 *17 Dec, 2014
 */
public class Comparer {
	
	public String strAns = "";
	public String strUsr = "";
	
	/**
	 * 对 MathML 字符串进行比较；
	 * @param strAnswer			正确答案字符串；
	 * @param strInput			用户输入字符串；
	 * @param model				比较的模式；
	 * @param setting			比较的条件设定；
	 * @return					返回:[0, 等值；任何其他; 不等值；]
	 */
	public static int Comparison(String strAnswer, String strInput, boolean model, String setting) {
		
		
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
	 * 1. 运行规范化程序，将不规范的 mathml 字符串代码规范为标准的字符串；
	 * 2. 检查字符串是否符合比较的‘条件设定’；（不符合的要 Prompt）
	 * 3. 将 mathml 字符串对象化为‘文档对象’；（对象化）
	 * 4. 检查‘文档对象’是否合理及符合‘比较条件’；（以文档对象格式检查是否符合数学规范）
	 * 5. 进行赋值；（最终给未知变量赋值）
	 * 6。 比较并返回结果；（返回比较结果）
	 */
	
	
	
	
}