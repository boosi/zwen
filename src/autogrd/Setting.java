package autogrd;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;



/**
 * 运行中需要设定的若干变量；
 * @author Zhengwen
 * 
 *27 Nov, 2014
 */
public class Setting {
	/** 与主线程通信（表示启动该类的主线程) */
	Comparer communicate;
	
	
	
	public Map<String, String> ConfigMap;
	
	
	
	
	
	public Setting() {
		communicate = new Comparer();
		initConfMap();
	}
	
	public Setting(Object conponentObject) {
		communicate = (Comparer) conponentObject;
		initConfMap();
	}
	


	/**
	 * 
	 */
	private void initConfMap() {
		ConfigMap	= new HashMap<String, String>();
		ConfigMap.put("111", "FALSE");
		ConfigMap.put("121", "FALSE");
		ConfigMap.put("122", "FALSE");
		ConfigMap.put("131", "FALSE");
		ConfigMap.put("132", "FALSE");
		ConfigMap.put("133", "FALSE");
		ConfigMap.put("134", "FALSE");
		ConfigMap.put("141", "FALSE");
		ConfigMap.put("142", "FALSE");
		ConfigMap.put("161", "FALSE");
		ConfigMap.put("162", "FALSE");
		ConfigMap.put("163", "FALSE");
		ConfigMap.put("181", "FALSE");
		ConfigMap.put("182", "FALSE");
		ConfigMap.put("190", "FALSE");
		ConfigMap.put("191", "FALSE");
		ConfigMap.put("192", "FALSE");
		ConfigMap.put("171", "");
		ConfigMap.put("150", "12");
		ConfigMap.put("151", "12");
		ConfigMap.put("152", "14");
		ConfigMap.put("153", "14");
	}
	
	
	
	public void setConfmap(String instr) {
		String regexString = "";
		Matcher matcher = null;
		ConfigMap.put("111", instr.indexOf("111") >= 0 ? "TRUE" : "FALSE");
		ConfigMap.put("121", instr.indexOf("121") >= 0 ? "TRUE" : "FALSE");
		ConfigMap.put("122", instr.indexOf("122") >= 0 ? "TRUE" : "FALSE");
		ConfigMap.put("131", instr.indexOf("131") >= 0 ? "TRUE" : "FALSE");
		ConfigMap.put("132", instr.indexOf("132") >= 0 ? "TRUE" : "FALSE");
		ConfigMap.put("133", instr.indexOf("133") >= 0 ? "TRUE" : "FALSE");
		ConfigMap.put("134", instr.indexOf("134") >= 0 ? "TRUE" : "FALSE");
		ConfigMap.put("141", instr.indexOf("141") >= 0 ? "TRUE" : "FALSE");
		ConfigMap.put("142", instr.indexOf("142") >= 0 ? "TRUE" : "FALSE");
		ConfigMap.put("161", instr.indexOf("161") >= 0 ? "TRUE" : "FALSE");
		ConfigMap.put("162", instr.indexOf("162") >= 0 ? "TRUE" : "FALSE");
		ConfigMap.put("163", instr.indexOf("163") >= 0 ? "TRUE" : "FALSE");
		ConfigMap.put("181", instr.indexOf("181") >= 0 ? "TRUE" : "FALSE");
		ConfigMap.put("182", instr.indexOf("182") >= 0 ? "TRUE" : "FALSE");
		ConfigMap.put("190", instr.indexOf("190") >= 0 ? "TRUE" : "FALSE");
		ConfigMap.put("191", instr.indexOf("191") >= 0 ? "TRUE" : "FALSE");
		ConfigMap.put("192", instr.indexOf("192") >= 0 ? "TRUE" : "FALSE");
		
		if (instr.indexOf("171") >= 0) {
			String string = instr.substring(
					instr.indexOf("171#") + 4, instr.indexOf(",", instr.indexOf("171#") + 4));	//截取子字符串
		}
		ConfigMap.put("171", instr.indexOf("171") >= 0 ? "TRUE" : "FALSE");
		regexString = "15(\\d)#(\\d+)";
		matcher = Pattern.compile(regexString).matcher(instr);
		while (matcher.find()) {
			if (matcher.group(1).equals("0")) 
				ConfigMap.put("150", matcher.group(2));
			else if (matcher.group(1).equals("1")) 
				ConfigMap.put("151", matcher.group(2));
			else if (matcher.group(1).equals("2")) 
				ConfigMap.put("152", matcher.group(2));
			else {
				ConfigMap.put("153", matcher.group(2));
			}
		}
	}
	
	
}
