package autograd;

public class Range {

	private int x1 = 0;
	private int x2 = 0;

	public Range() {
		x1 = 0;
		x2 = 0;
	}

	public Range(int start, int end) {
		x1 = start;
		x2 = end;
	}

	public int getStart() {
		return x1;
	}
	public void setStart(int start) {
		x1 = start;
	}
	
	public int getEnd() {
		return x2;
	}
	public void setEnd(int end) {
		x2 = end;
	}
	
	
	
	
	
	

}
