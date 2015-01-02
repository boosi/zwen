package grading;

import javax.swing.JFrame;

import java.lang.reflect.*;
import java.util.Arrays;

import org.w3c.dom.Document;

import static grading.Log.*;





/**
 * 评估两个对象是否等价；
 * @author Zhengwen 
 * @date 31 Dec, 2014
 * @version Grading 3.0 Builder	0009
 */
public class Evaluate {
	/**与主线程通信（表示启动该类的主线程)*/
	Comparer comm = null;
	
	
	
	
	/**
	 * 构造器；
	 */
	public Evaluate(Comparer comparer) {
		comm = comparer;
		try {
			print("Super.class:\t" + this.getClass().getName());
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
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
