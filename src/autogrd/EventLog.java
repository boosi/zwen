package autogrd;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

public class EventLog extends Exception {
	private static final long serialVersionUID = 5012888463041971623L;

	private String pathname = System.getenv("APPDATA") + "/autograd.dat";
	private File file = null;

	
	
	
	public EventLog() {
		file = new File(pathname);
	}


	
	
	/**
	 * 将异常写入磁盘日志；
	 * @param strContent	异常的消息；
	 * @throws Exception	当日志文件找不到的话，抛出异常；
	 */
	public void outLog(String strContent) throws Exception {
		BufferedWriter bw = new BufferedWriter(new FileWriter(file, true));
		String str = "\n=== " + getDate(0) + " ===\n" + strContent + "\n ---------- END ----------\n";
		bw.write(str);
		bw.flush();
		bw.close();
	}

	/**
	 * 打印异常；
	 * @param exception
	 */
	public void printLog(Exception exception) {
		System.out.println(exception.getMessage());
	}
	
	/**
	 * 得到日期的字符串，格式（“YYYY/MM/dd HH:mm:ss”）；
	 * @param index
	 * @return
	 */
	private String getDate(int index) {
		if (index == 0)
			return new SimpleDateFormat("YYYY/MM/dd, HH:mm:ss").format(new Date());
		return "";
	}

	
	/**
	 * 取得系统当前用户的各种路径； 
	 * @param keyName		特定的属性名称；
	 * @return					如果指定名称，则返回改名成的属性（字符串）；否则返回全部的属性 Map；
	 */
	private Object getSystemPaths(String keyName) {
		Map m = System.getenv();
		if (keyName == null || keyName.equals("")) {
			return m;
		}
		else 
			return m.get(keyName);
	}

	
	/**
	 * 取得当前系统的各种环境变量； 
	 * @param propertyName		特定的属性名称；
	 * @return					如果指定名称，则返回改名成的属性（字符串）；否则返回全部的属性 Map；
	 */
	private Object getProperties(String propertName) {
		Properties p = System.getProperties();

		if (propertName == null || propertName.equals(""))
			return p;
		else 
			return p.get(propertName);
	}
	
	
	/*
	public static void main(String[] args) {
		EventLog pe = new EventLog();
		String string = "1234567890\nABCDEFGHIJKLMNOPQRS";
		try {
			pe.outLog(string);

			//System.out.println("APPDATA: >>>>> \t" + System.getenv("APPDATA"));

		} catch (Exception ex) {
			//System.out.println("error:" + ex.getMessage());
		}
	}
	 */
}
