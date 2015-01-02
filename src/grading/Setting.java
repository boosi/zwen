package grading;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;



/**
 * 程序设置，运行中需要的参数设定，变量等；
 * @author Zhengwen 
 * @date 31 Dec, 2014
 * @version Grading 3.0 Builder	0009
 */
public class Setting {
	/** 与主线程通信（表示启动该类的主线程) */
	Comparer comm;
	
	
	
	public Map<String, String> ConfigMap;
	
	
	
	
	
	public Setting() {
		comm = new Comparer();
		initConfMap();
	}
	
	public Setting(Object conponentObject) {
		comm = (Comparer) conponentObject;
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
		ConfigMap.put("150", "8");
		ConfigMap.put("151", "8");
		ConfigMap.put("152", "12");
		ConfigMap.put("153", "12");
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
		
		regexString = "(?<=171#)(\\w+)(?=,|)";
		matcher = Pattern.compile(regexString).matcher(instr);
		if (matcher.find()) 
			ConfigMap.put("171", matcher.group(0));	//截取子字符串
		else 
			ConfigMap.put("171", "");
		
		regexString = "(?<=15([0-3])#)(\\d+)(?=,|)";
		matcher = Pattern.compile(regexString).matcher(instr);
		while (matcher.find()) {
			ConfigMap.put("150", matcher.group(1).equals("0") ? matcher.group(2) : "8");
			ConfigMap.put("151", matcher.group(1).equals("1") ? matcher.group(2) : "8");
			ConfigMap.put("152", matcher.group(1).equals("2") ? matcher.group(2) : "");
			ConfigMap.put("153", matcher.group(1).equals("3") ? matcher.group(2) : "");
		}
	}
	
	
}
