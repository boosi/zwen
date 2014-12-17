package autogrd;

import org.w3c.dom.Document;



/**
 * 检查 mathml 字符串‘合理性’；
 * @author Zhengwen
 * 
 *17 Dec, 2014
 */
public final class Inspector {
	
	public static Document document = null;		//当前‘文档对象’；
	
	
	
	/**
	 * 在检查之前必须要做的变换，将不规范的代码规范；
	 * @param wdoc		
	 * @return
	 */
	public static boolean needful(/*Document wdoc*/) {
		
		return false;
	}
	
	
	/**
	 * 检查字符串合理性；
	 * @return		错误代码:[0, OK; 其他，代表错误类型]
	 */
	public static int checking() {
		
		
		return 0;
	}
	
	
	/**
	 * 字符串变形为合理等价的数学表达式；
	 * @return
	 */
	public int neaten() {
		
		return 0;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
