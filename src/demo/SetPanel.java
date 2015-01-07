package demo;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;




/**
 * 
 * @author Zhengwen 
 * @date 5 Jan, 2015
 * @version Grading 3.0 Builder
 */
public class SetPanel extends JDialog implements ActionListener {
	
	private static final long serialVersionUID = 5595326375208282406L;

	private JButton configBtn 	= new JButton("Config");
	private JButton resetBtn 	= new JButton("Reset");
	private JButton cancelBtn 	= new JButton("Cancel");
	
	private JCheckBox[] boxs 	= new JCheckBox[] {
			new JCheckBox("111 (2021)\t Bearing / Degree '0'"),
			new JCheckBox("121 (2023)\t Answer is not in the simplest form"),
			new JCheckBox("122 (2025)\t Mixed Number"),
			new JCheckBox("131 (2027)\t Standard Form"),
			new JCheckBox("132 (2029)\t Index Notation"),
			
			new JCheckBox("133 (2031)\t Surds"),
			new JCheckBox("134 (2033)\t Set Notation"),
			new JCheckBox("141 (2035)\t Trigonometric Function"),
			new JCheckBox("142 (2037)\t Logarithmic Function"),

			new JCheckBox("150 (2039) Decimal Places"),
			new JCheckBox("151 (2041) Decimal Places"),
			new JCheckBox("152 (2043) Significant Figures"),
			new JCheckBox("153 (2045) Significant Figures (strictly) "),
			
			new JCheckBox("161 (2047) Rounding "),
			new JCheckBox("162 (2049) Rund Up "),
			new JCheckBox("163 (2051) Rund Down "),
			
			new JCheckBox("171 (2053) Accept specified answer "),
			
			new JCheckBox("181 (2055) Is Expansion "),
			new JCheckBox("182 (2057) Is Factorisation "),
			new JCheckBox("190 (2059) Surds Radical Form "),
			new JCheckBox("191 (2061) Surds Index Form "),
			new JCheckBox("192 (2063) Surds is the Index of Lager than Zero ")
	};
	
	private JTextField[] txs 	= new JTextField[] {
			new JTextField(12),
			new JTextField(12),
			new JTextField(12),
			new JTextField(12),
			new JTextField(12),
	};
	
	
	public String strConf = "";
	
	
	
	
	
	public SetPanel(Object oweObject, Dimension dim) {
		super();
		setModal(true);
		setTitle("Configurate Model");
		setSize(dim.width, dim.height);
		setLocationRelativeTo(null);
		Container c = getContentPane();
		
		GridLayout lyout = new GridLayout();
		lyout.setHgap(15);
		lyout.setVgap(2);
		lyout.setRows(boxs.length + 3);
		lyout.setColumns(2);
		c.setLayout(lyout);
		for (int i = 0; i < boxs.length; i++) {
			c.add(boxs[i]);
//			if (i > 9 && i < 14) {
//				c.add(txs[i - 10], i, 1);
//			}
			if (i == 3) {
				c.add(txs[4], i, 1);
			}
		}
		
		c.add(configBtn);
		configBtn.addActionListener(this);
		c.add(resetBtn);
		resetBtn.addActionListener(this);
		c.add(cancelBtn);
		cancelBtn.addActionListener(this);
	}
	
	
	
	
	public SetPanel(int wid, int hgt) {
		Object[] options ={ "Config", "Reset", "Cancel" };   
		int m = JOptionPane.showOptionDialog(null, "选择下面一个设定项目：\n", "Setting",JOptionPane.OK_CANCEL_OPTION, 
				JOptionPane.WARNING_MESSAGE, null, options, options[2]);  
		setSize(new Dimension(wid, hgt));
		add(new JTextArea(40, 26));
		
		
		
	}
	
	
	
	
	/**
	 * 重写父方法；
	 */
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(configBtn)) {
			strConf = access();
			setVisible(false);
		}
		else if (e.getSource().equals(resetBtn)) {
			for (int i = 0; i < boxs.length; i++) {
				boxs[i].setSelected(false);
			}
		}
		else {
			setVisible(false);
		}
		
	}
	
	
	
	private String access() {
		String ret = "";
		if (boxs[0].isSelected()) 
			ret += "111,";
		if (boxs[1].isSelected()) 
			ret += "121,";
		if (boxs[2].isSelected()) 
			ret += "122,";
		if (boxs[3].isSelected()) 
			ret += "131,";
		if (boxs[4].isSelected()) 
			ret += "132,";
		if (boxs[5].isSelected()) 
			ret += "133,";
		if (boxs[6].isSelected()) 
			ret += "134,";
		if (boxs[7].isSelected()) 
			ret += "141,";
		if (boxs[8].isSelected()) 
			ret += "142,";
		
		return ret;
	}
	
	
	
	
//	private String ReadSchema() {
//		ConfigPanel pane = (ConfigPanel) cfgPane;
//		String result = "";
//		
//		if (pane.boxs[1].isSelected())	
//			result += "121,";
//		if (pane.boxs[2].isSelected())	
//			result += "122,";
//		if (pane.boxs[3].isSelected())	
//			result += "131,";
//		if (pane.boxs[4].isSelected())	
//			result += "132,";
//		
//		if (pane.boxs[5].isSelected())	
//			result += "133,";
//		if (pane.boxs[6].isSelected())	
//			result += "134,";
//		if (pane.boxs[7].isSelected())	
//			result += "141,";
//		if (pane.boxs[8].isSelected())	
//			result += "142,";
//		if (pane.boxs[9].isSelected())	
//			result += "150#5,";
//		
//		if (pane.boxs[10].isSelected())	
//			result += "151#5,";
//		if (pane.boxs[11].isSelected())	
//			result += "152#13,";
//		if (pane.boxs[12].isSelected())	
//			result += "153#13,";
//		if (pane.boxs[13].isSelected())	
//			result += "161,";
//		if (pane.boxs[14].isSelected())	
//			result += "162,";
//		
//		if (pane.boxs[15].isSelected())	
//			result += "163,";
//		if (pane.boxs[16].isSelected())	
//			result += "171,";
//		if (pane.boxs[17].isSelected())	
//			result += "181,";
//		if (pane.boxs[18].isSelected())	
//			result += "182,";
//		if (pane.boxs[19].isSelected())	
//			result += "191,";
//		
//		if (pane.boxs[20].isSelected())	
//			result += "192,";
//		
//		if (!(result == "") && result.charAt(result.length()-1) == ',')
//			result = result.substring(0, result.length()-1);
//		return result;
//	}
	
	
	
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		
		SetPanel sPanel = new SetPanel(420, 360);
		sPanel.setVisible(true);

		
		//JComponent.setDefaultLocale(getDefaultLocale());
		
		
	}





}
