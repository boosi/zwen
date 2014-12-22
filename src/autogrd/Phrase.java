package autogrd;






/**
 * 本类相当于表达式的功能，为了不与 mathematic 包里的 Expression 或 Expr 类名称重复；专门处理表达式的各种运算；
 * @author Zhengwen
 * 
 *19 Dec, 2014
 */
public class Phrase {
	/** 与主线程通信（表示启动该类的主线程)； */
	Comparer communicate = null;
	
	
	
	
	public Phrase() {
		communicate = new Comparer();
	}
	
	public Phrase(Object conponentObject) {
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
