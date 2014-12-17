package autogrd;

import org.w3c.dom.Document;





/**
 * 评估两个对象是否等价；
 * @author Zhengwen
 * 
 *17 Dec, 2014
 */
public class Evaluate {

	Comparer cmp = null;
	
	
	
	
	/**
	 * 构造器；
	 */
	public Evaluate(Comparer comparer) {
		cmp = comparer;
	}
	
	/**
	 * 评估对象等值性；
	 * @return
	 */
	public int EvalObject(Document opt1, Document opt2) {
		String st1 = opt1.getDocumentElement().getTextContent();
		if (st1.indexOf("") >= 0) 
			return evalEquation(opt1, opt2);
		else 
			return evalExpress(opt1, opt2);
	}
	
	
	/**
	 * 评估方程式等值性；
	 * @return
	 */
	private int evalEquation(Document opt1, Document opt2) {
		
		return 0;
	}
	
	
	/**
	 * 评估表达式等值性；
	 * @return
	 */
	private int evalExpress(Document opt1, Document opt2) {
		
		return 0;
	}
	
	
	
	
	
	
	
	
	
	
	public static void main(String[] args) {

	}

	
	
}
