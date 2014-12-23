package autogrd;







/**
 * 各种表达式，为不与 mathematic 包的 Expression 或 Expr 类名称重复；<br/>专门处理表达式的各种运算；
 * @author Zhengwen 
 * @date 23 Dec, 2014
 * @version Grading 3.0 Builder	008
 */
public class Equation {
	/** 与主线程通信（表示启动该类的主线程)； */
	Comparer communicate = null;
	
	
	
	
	public Equation() {
		communicate = new Comparer();
	}
	
	public Equation(Object conponentObject) {
		communicate = (Comparer) conponentObject;
	}
	
	
	
	public String transform(String instr) {


		
		
		return instr;
	}
	
	
	
	private String convert(String instr) {
		
		return instr;
	}
	
	
	// For Test!
	public static void main(String[] args) {

	}

}
