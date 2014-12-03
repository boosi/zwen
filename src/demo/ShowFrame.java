package demo;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import autograd.ConfigPanel;

public class ShowFrame extends JFrame implements ActionListener {

	private static final long serialVersionUID = 2063757431691249916L;
	private JPanel		cfgPane;
	private JButton 	btnOk;
	private JButton 	btnReset;
	private JButton 	btnCancel;
	
	public String 		strConfig = "";
	
	
	
	
	public ShowFrame(JPanel pane, String title, int width, int height) {
		cfgPane = pane;
		setTitle(title);
		setSize(new Dimension(width, height));
		setLocationRelativeTo(null);
		add(pane, BorderLayout.CENTER);
		JPanel spane = new JPanel();
		spane.add(btnOk 		= new JButton("OK"));
		spane.add(btnReset 		= new JButton("Reset"));
		spane.add(btnCancel 	= new JButton("Cancel"));
		btnOk.addActionListener(this);
		btnReset.addActionListener(this);
		btnCancel.addActionListener(this);
		add(spane, BorderLayout.SOUTH);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(btnOk)) {
			ConfigPanel pane = (ConfigPanel) cfgPane;
			strConfig = ReadSchema();
			setVisible(false);
		}
		if (e.getSource().equals(btnReset)) {
			ConfigPanel pane = (ConfigPanel) cfgPane;
			strConfig = "";
			ResetBoxs();
		}
		if (e.getSource().equals(btnCancel)) {
			setVisible(false);
		}
	}
	

	private String ReadSchema() {
		ConfigPanel pane = (ConfigPanel) cfgPane;
		String result = "";
		if (pane.boxs[0].isSelected()) 
			result += "111,";
		if (pane.boxs[1].isSelected())	
			result += "121,";
		if (pane.boxs[2].isSelected())	
			result += "122,";
		if (pane.boxs[3].isSelected())	
			result += "131,";
		if (pane.boxs[4].isSelected())	
			result += "132,";
		
		if (pane.boxs[5].isSelected())	
			result += "133,";
		if (pane.boxs[6].isSelected())	
			result += "134,";
		if (pane.boxs[7].isSelected())	
			result += "141,";
		if (pane.boxs[8].isSelected())	
			result += "142,";
		if (pane.boxs[9].isSelected())	
			result += "150#5,";
		
		if (pane.boxs[10].isSelected())	
			result += "151#5,";
		if (pane.boxs[11].isSelected())	
			result += "152#13,";
		if (pane.boxs[12].isSelected())	
			result += "153#13,";
		if (pane.boxs[13].isSelected())	
			result += "161,";
		if (pane.boxs[14].isSelected())	
			result += "162,";
		
		if (pane.boxs[15].isSelected())	
			result += "163,";
		if (pane.boxs[16].isSelected())	
			result += "171,";
		if (pane.boxs[17].isSelected())	
			result += "181,";
		if (pane.boxs[18].isSelected())	
			result += "182,";
		if (pane.boxs[19].isSelected())	
			result += "191,";
		
		if (pane.boxs[20].isSelected())	
			result += "192,";
		
		if (!(result == "") && result.charAt(result.length()-1) == ',')
			result = result.substring(0, result.length()-1);
		return result;
	}
	
	/**
	 * 清理所有的Box为不选择；
	 */
	private void ResetBoxs() {
		for (int i = 0; i < ((ConfigPanel) cfgPane).boxs.length; i++) {
			((ConfigPanel) cfgPane).boxs[i].setSelected(false);
		}
	}

}
