package demo;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JPanel;

public class ConfigPanel extends JPanel{

	private static final long serialVersionUID = 343142293443566319L;
	
	public JCheckBox[] boxs;
	
	private String[] chkboxs = new String[] {
		//{ bgn
		  "(111) Bearing / Degree '0' "
		, "(121) Answer is not in the simplest form "
		, "(122) Mixed Number "
		, "(131) Standard Form "
		, "(132) Index Notation "
		
		, "(133) Surds "
		, "(134) Set Notation "
		, "(141) Trigonometric Function "
		, "(142) Logarithmic Function"
		, "(150#4) Decimal Places (strictly) "
		
		, "(151#2) Decimal Places "
		, "(152#3) Significant Figures "
		, "(153#8) Significant Figures (strictly) "
		, "(161) Rounding "
		, "(162) Rund Up "
		
		, "(163) Rund Down "
		, "(171) Accept one ... "
		, "(181) Is Expansion "
		, "(182) Is Factorisation "
		, "(191) Surds Radical Form "
		, "(192) Surds is Index Form "
		//}end
	};
	
	
	private Map<String, String> configMap;
	
	public void setSchema(String instr) {
		Matcher matcher;
		configMap = new HashMap<String, String>();
		configMap.put("111", (instr.indexOf("111") >= 0 ? "TRUE" : "FALSE"));
		configMap.put("121", (instr.indexOf("121") >= 0 ? "TRUE" : "FALSE"));
		configMap.put("122", (instr.indexOf("122") >= 0 ? "TRUE" : "FALSE"));
		configMap.put("131", (instr.indexOf("131") >= 0 ? "TRUE" : "FALSE"));
		configMap.put("132", (instr.indexOf("132") >= 0 ? "TRUE" : "FALSE"));
		
		configMap.put("133", (instr.indexOf("133") >= 0 ? "TRUE" : "FALSE"));
		configMap.put("134", (instr.indexOf("134") >= 0 ? "TRUE" : "FALSE"));
		configMap.put("141", (instr.indexOf("141") >= 0 ? "TRUE" : "FALSE"));
		configMap.put("142", (instr.indexOf("142") >= 0 ? "TRUE" : "FALSE"));
		configMap.put("161", (instr.indexOf("161") >= 0 ? "TRUE" : "FALSE"));
		
		configMap.put("162", (instr.indexOf("162") >= 0 ? "TRUE" : "FALSE"));
		configMap.put("163", (instr.indexOf("163") >= 0 ? "TRUE" : "FALSE"));
		configMap.put("171", (instr.indexOf("171") >= 0 ? "TRUE" : "FALSE"));
		configMap.put("181", (instr.indexOf("181") >= 0 ? "TRUE" : "FALSE"));
		configMap.put("182", (instr.indexOf("182") >= 0 ? "TRUE" : "FALSE"));

		configMap.put("191", (instr.indexOf("191") >= 0 ? "TRUE" : "FALSE"));
		configMap.put("192", (instr.indexOf("192") >= 0 ? "TRUE" : "FALSE"));
		
		matcher = Pattern.compile("150#(\\d+)(?=,|)").matcher(instr);
		configMap.put("150", (matcher.find()) ? matcher.group(1) : "5");
		matcher = Pattern.compile("151#(\\d+)(?=,|)").matcher(instr);
		configMap.put("151", (matcher.find()) ? matcher.group(1) : "5");
		matcher = Pattern.compile("152#(\\d+)(?=,|)").matcher(instr);
		configMap.put("152", (matcher.find()) ? matcher.group(1) : "13");
		matcher = Pattern.compile("153#(\\d+)(?=,|)").matcher(instr);
		configMap.put("153", (matcher.find()) ? matcher.group(1) : "13");
	}
	
	
	public ConfigPanel() {
		setSchema("");
		initializeComponents();
		setVisible(true); 
	}
	
	
	public ConfigPanel(Container argComponent) {
		this();
		
	}
	
	private void initializeComponents() {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		boxs = new JCheckBox[chkboxs.length];
		for (int i = 0; i < chkboxs.length; i++) {
			boxs[i] = new JCheckBox(chkboxs[i]);
			add(boxs[i]);
		}
	}
	
	
}
