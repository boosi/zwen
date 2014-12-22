




/**
 * 专用于测试各种代码，每种启用一个新线程；
 * @author Zhengwen
 * 
 *19 Dec, 2014
 */
public class Newtest /*extends Thread*/ implements Runnable{

	
	
	public static void Launch() {
		Newtest thd = new Newtest();
		//thd.start();
		thd.run();
	}
	
	
	public void run() {
		System.out.print(">>" + getClass().getName());
	}
	
	
	
	
	
	
	
	
	
	
	public static void main(String[] args) {
		
		Newtest.Launch();
	}


}
