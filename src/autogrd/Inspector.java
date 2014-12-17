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
	
	private Comparer cmp = null;			//当前线程的根；
	private Map<String, String> confmap;
	
	public Document document = null;		//当前‘文档对象’；
	
	
	
	
	public Inspector() {
		cmp 		= new Comparer();
		confmap		= cmp.conf.ConfigMap;
	}
	
	
	public Inspector(Object conponentObject) {
		cmp 		= (Comparer) conponentObject;
		confmap		= cmp.conf.ConfigMap;
	}
	
	
	
	
	
	/**
	 * 在检查之前必须要做的变换，将不规范的代码规范；
	 * @param wdoc		
	 * @return
	 */
	public boolean needful(/*Document wdoc*/) {
		boolean res = true;
		System.out.print(confmap.get("\t\t122"));
		return res;
	}
	
	
	/**
	 * 检查字符串合理性；
	 * @return		错误代码:[0, OK; 其他，代表错误类型]
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
	
	
	
	
	
	
	
	
	
	public static void main(String[] args) {
		System.out.print(new Inspector().confmap.get("122"));
	}
	
	
	
	
	
	
	
	
	
	
}
