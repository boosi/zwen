package autograd;

import static java.lang.System.out;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.util.Date;

import javax.imageio.ImageIO;

import com.wolfram.jlink.KernelLink;
import com.wolfram.jlink.MathLinkException;
import com.wolfram.jlink.MathLinkFactory;
import com.wolfram.jlink.PacketListener;




public final class Mathematic {

	static 	KernelLink 		kerLink		= null;		
			PacketListener 	pkltener 	= null;
	
	
	/**
	 * 得到图片二进制数据；
	 * @param expressio	n	表达式；
	 * @return		二进制数据 byte[]；
	 */
	public static byte[] ExpressGraph(String expression) {
		byte[] res = null;
		String str = "";
		kerLink = getKernelLink();
		if (!kerLink.equals(null)) {
			try {

				kerLink.discardAnswer();
		        kerLink.evaluate(str);
		        kerLink.waitForAnswer();
		        String x = kerLink.getString();
				String datestr = new Date().toGMTString();
		        kerLink.evaluate("tmp = renderImageGeneric[" + datestr + "], noteText,400,380, margin,72,50,20,20,20,20,20,50,50,50]");
	            kerLink.discardAnswer();
	            res = kerLink.evaluateToImage("Plot[" + expression + ", {x, -100, 100},PlotStyle -> {RGBColor[1, 0.5, 0.5]}]", -20, -10);
	            out.println("Getting successfully.");
	            kerLink.close();
	            
	            //{bgn 	写到磁盘文件；
	            	//saveImage(res, "D:/temp/Users/test2.png");
	            //}end
			} catch (Exception ex) {
				System.out.println("Error \n" + ex.getMessage());
				kerLink.close();
			}
		}
		return res;
	}
	
	
	/**
	 * 获得绘图的数据（二进制数组）；
	 * @param expression	表达式；
	 * @return				图片数据；
	 */
	public static byte[] getByteArray(String expression) {
		byte[] res = null;
		kerLink = getKernelLink();
		if (!kerLink.equals(null)) {
			try {
				kerLink.discardAnswer();
		        kerLink.evaluate("");
		        kerLink.waitForAnswer();
		        String x = kerLink.getString();
				String datestr = new Date().toGMTString();
		        kerLink.evaluate("tmp = renderImageGeneric[" + datestr + "], noteText,400,380, margin,72,50,20,20,20,20,20,50,50,50]");
	            kerLink.discardAnswer();
	            res = kerLink.evaluateToImage("Plot[" + expression + ", {x, -100, 100},PlotStyle -> {RGBColor[1, 0.5, 0.5]}]", -20, -10);
	            out.println("Getting successfully.");
	            kerLink.close();
			} catch (Exception ex) {
				System.out.println("Error \n" + ex.getMessage());
				kerLink.close();
			}
		}
		return res;
	}
	
	
	/**
	 * 得到 KernelLink对象；
	 */
	@SuppressWarnings("null")
	private static KernelLink getKernelLink() {
		KernelLink 	rstLink		= null;
		String[] argv = new String[] {"-linkmode", "", "-linkname", "D:\\Program Files\\Wolfram Research\\Mathematica\\MathKernel"};	//10.0版本；
		try {
			rstLink = MathLinkFactory.createKernelLink(argv);
		}
		catch (MathLinkException mex) {
			out.println("An error occurred while connected to the Kernel_Link.");
			rstLink.close();
			return null;
		} catch (Exception ex) {
			rstLink.close();
			return null;
		}
		
		return rstLink;
	}
	
	
	/**
	 * 存文件在磁盘中；
	 * @param bytes		图片的二进制数据；
	 * @param filePath	图片存放路径；
	 */
	private static void saveImage(byte[] bytes, String filePath) {
		if (bytes == null)
			return;
		BufferedImage BuffImg;
	    ByteArrayInputStream strm = new ByteArrayInputStream(bytes);
	    try {
	    	BuffImg = ImageIO.read(strm);
	    		ImageIO.write(BuffImg, "png", new File(filePath));
	    		out.println("Images successfully deposited in the disk.\tfile path:" + filePath);
	    }
	    catch (Exception ex) {
	    	out.println("Write file error:\n"+ex.getMessage());
	    }
	}
	
	
}
