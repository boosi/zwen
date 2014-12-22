package autogrd;

import java.util.Map;

import org.w3c.dom.Document;



/**
 * 检查 mathml 字符串‘合理性’；
 * @author Zhengwen
 * 
 *17 Dec, 2014
 */
public final class Inspector {
	/**与主线程通信（表示启动该类的主线程)*/
	Comparer communicate = null;
	
	
	private Map<String, String> confmap;
	
	public Document document = null;		//当前‘文档对象’；
	
	
	
	
	public Inspector() {
		communicate 		= new Comparer();
		confmap		= communicate.conf.ConfigMap;
	}
	
	
	public Inspector(Object conponentObject) {
		communicate 		= (Comparer) conponentObject;
		confmap		= communicate.conf.ConfigMap;
	}
	
	
	
	
	
	/**
	 * 在检查之前必须要做的变换，将不规范的代码规范；
	 * @param wdoc		
	 * @return
	 */
	public boolean needful() {
		boolean res = true;
		System.out.print(confmap.get("\t\t122"));
		return res;
	}
	
	
	/**
	 * 检查字符串合理性；
	 * @return		返回代码:[0, OK; 其他，代表错误类型]
	 */
	public int check_prompt() {
		
		
		return 0;
	}
	
	
	/**
	 * 以节点树形式检查 math 表达式的合理性；
	 * @return		错误代码:[0, OK; 其他，代表错误类型]
	 */
	public int node_trim() {
		
		return 0;
	}
	
	
	/**
	 * 字符串变形为合理等价的数学表达式；
	 * @return
	 */
	public int neaten() {
		
		return 0;
	}
	
	
	
	
	
	
	
	
	// For Test!
	public static void main(String[] args) {
		System.out.print(new Inspector().confmap.get("122"));
	}
	
	
	
	
	
	
	
	
	
	
}
