package autogrd;







public class Expression {

	private Comparer cmp = null;
	
	
	
	
	public Expression() {
		cmp = new Comparer();
	}
	
	public Expression(Object conponentObject) {
		cmp = (Comparer) conponentObject;
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
