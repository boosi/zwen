package mathematica;

import static java.lang.System.out;

import com.wolfram.jlink.Expr;
import com.wolfram.jlink.KernelLink;
import com.wolfram.jlink.MathLinkException;
import com.wolfram.jlink.MathLinkFactory;


/**
 * 操作 Mathematica 对象的封装类；
 * @author Zhengwen
 * 
 *3 Dec, 2014
 */
public class Calculate {
	static String 		linktype 	= "-linkmode";
	static String 		linkname 	= "-linkname";
	static String 		mode 		= "launch";
	static String 		path 		= "D:\\Program Files\\Wolfram Research\\Mathematica\\MathKernel";
	static KernelLink 	kLink 		= null;
	
	
	/**
	 * 获得链接对象；
	 * @return		Mathematica 的连接对象；
	 */
	static KernelLink getLink() throws MathLinkException {
		KernelLink 	link = null;
		String[] argv = new String[] {linktype, mode, linkname, path};	//10.0版本；
		link = MathLinkFactory.createKernelLink(argv);
		
		return link;
	}
	
	
	/**
	 * 获得图片的输出数据；
	 * @param expression	绘图表达式（或方程式）；
	 * @return	Mathematica 图片的 byte[]；
	 */
	public static byte[] getImageBytes(String expression) {
		int x1 = 480, 	x2 = 400;		//范围
		int wid = 100,	hgt = 100;		//宽度与高度
		byte[] bytes =getImageBytes(expression, new Range(x1, x2), new Range(wid, hgt)); 
		return bytes;
	}
	
	
	public static byte[] getImageBytes(String expression, Range range, Range size) {
		byte[] result = null;
		
		try {
			kLink = getLink();
			kLink.discardAnswer();
	        kLink.evaluate("");
	        kLink.waitForAnswer();
	        String x = kLink.getString();
			String dstr = System.currentTimeMillis() + "";
			dstr = dstr.substring(0, dstr.length() -3);
	        kLink.evaluate("tmp = renderImageGeneric[" + dstr + "], noteText,400,380, margin,72,50,20,20,20,20,20,50,50,50]");
            kLink.discardAnswer();
            result = kLink.evaluateToImage("Plot[" + expression + ", {x, -50, 50},PlotStyle -> {RGBColor[1, 0.5, 0.5]}]", -20, -10);
		} catch (Exception ex) {
			//WriteLog.writelog("source: getImageBytes();\nerror: " + ex.getMessage());
		}
		kLink.terminateKernel();
		
		return result;
	}
	
	
	/**
	 * 在Math字符串与数学Text之间转换；
	 * @param expression	表达式；
	 * @param direct		当方向大于等于零，数学表达式转化为Math字符串；当方向小于零，Math字符串转换为数学Text表达式；
	 * @return				转换后的字符串；
	 */
	public static String Transform(String expression, int direct) {
		String result = "";
		
		try {
			kLink = getLink();
			kLink.discardAnswer();
			Expr e1 = new Expr(expression);
			Expr e2 = new Expr("MathML");
			if (direct > 0) {
				kLink.evaluate("ExportString[Unevaluated[" + expression + "], \"MathML\", \"Annotition\" -> {}]");
				kLink.waitForAnswer();
		        result = kLink.getString();
			}
			else {
				kLink.evaluate("ImportString[" + e1 + "," + e2 + "]");
				kLink.waitForAnswer();
				Expr res = kLink.getExpr();
				kLink.evaluate("ToExpression[" + res + "]");
				kLink.waitForAnswer();
				result = kLink.getString();
			}
		}
		catch (Exception ex) {
			out.println("source: Transform();\nerror:" + ex.getMessage());
		}
		kLink.terminateKernel();
		return result;
	}
	
	
	public static Expr Calculation(String expression) {
		Expr result = null;

		try {
			kLink = getLink();
			Expr exp = new Expr(expression);
			kLink.discardAnswer();
			kLink.evaluate("ToExpression[" + exp + "]");
			kLink.waitForAnswer();
			result = kLink.getExpr();
		} catch (Exception ex) {
			out.println("source: Calculation();\nerror:" + ex.getMessage());
		}
		kLink.terminateKernel();
		
		return result;
	}

	//	For test;
	public static void main(String[] args) {
		System.out.println(System.currentTimeMillis());

	}

}
