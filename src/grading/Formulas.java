package grading;

import org.w3c.dom.Node;







/**
 * 等式，方程式，表达式等；为不与 mathematic 包的 Expression 或 Expr 类名称重复；<br/>专门处理表达式的各种运算；
 * @author Zhengwen 
 * @date 23 Dec, 2014
 * @version Grading 3.0 Builder	0009
 */
public class Formulas {
	/** 与主线程通信（表示启动该类的主线程)； */
	Comparer comm = null;
	
	
	
	//{rem 构造器
	public Formulas() {
		comm = new Comparer();
	}
	
	public Formulas(Object conponentObject) {
		comm = (Comparer) conponentObject;
	}
	//}end
	
	
	public String transform(String instr) {


		
		
		return instr;
	}
	
	
	
	private String convert(String instr) {
		
		return instr;
	}
	
	
	
	
	
	
	
	
	
	
	
	//============================
	public static String getExprValue(Node node) {
		String name = node.getNodeName();
		String retStr = "";
		switch (name) {
		case "msqrt":
			retStr = Math.sqrt(Double.parseDouble(node.getTextContent())) + "";
			break;

		default:
			break;
		}
		
		return retStr;
	}
	
	
	
	
	
	// For Test!
	public static void main(String[] args) {

	}

	
	
	
	
	
	
	
}
