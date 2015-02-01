package demo;

import grading.Comparer;
import grading.Inspector;
import grading.Sharing;

import java.awt.Dialog;
import java.awt.Dialog.ModalityType;
import java.awt.Dimension;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;

import maths.Calculator;
import maths.Mathematic;


public class RespontEvt implements ActionListener {

	private JFileChooser 		chooser;
	private GuiElements 		evtSource;
	private ConfigPanel			configPane;
	private JFrame				showFrame;
	
	public JFrame				mainFrm;
	public SetPanel 			sPanel;
	public String 				strconf 		= "";
	
	public RespontEvt(Object object) {
		evtSource = (GuiElements) object;
		sPanel		= new SetPanel(this, new Dimension(520, 780));
	}
	
	
	
	
	//{bgn	实现 ActionListener 接口方法
	public void actionPerformed(ActionEvent e) {
		//绘图
		if (e.getSource().equals(evtSource.btnPlot)) {
			String mathStr = evtSource.txEditor.getText();
			if (mathStr.indexOf("<math") >= 0 || mathStr.indexOf("</math>") >= 0) {
				evtSource.txMessage.setText("Can't use Math string drawing, \nplease into the equations of mathematical format, \nand then try again.");
				return;
			}
			String expression = evtSource.txEditor.getText();
			LoadPicture(Calculator.getImageBytes(expression));
		}
		//转换 	to Math ML字符串 
		if (e.getSource().equals(evtSource.btnCovert1)) {
			String strExpr = evtSource.txEditor.getText();
			evtSource.txMessage.setText(Calculator.Transform(strExpr, 2));
		}
		//转换 	to Arith字符串并计算结果
		if (e.getSource().equals(evtSource.btnCovert2)) {
			String strExpr = evtSource.txEditor.getText();
			evtSource.txMessage.setText(Calculator.Transform(strExpr, -2));
		}
		//导入
		if (e.getSource().equals(evtSource.btnImport)) {
			chooser = new JFileChooser();
			int result = chooser.showOpenDialog(null);
			if (result == JFileChooser.APPROVE_OPTION) {
				LoadPicture(chooser.getSelectedFile().getPath());
			} 
		}
		//计算
		if (e.getSource().equals(evtSource.btnCalcul)) {
			String strExpr = evtSource.txEditor.getText();
			evtSource.txMessage.setText(Calculator.Calculation(strExpr).toString());
		}
		//导出
		if (e.getSource().equals(evtSource.btnExport)) {
			//暂时不设定此功能；
		}
		//弹出设定框
		if (e.getSource().equals(evtSource.btnConfig)) {
			sPanel.setVisible(true);
			strconf = sPanel.strConf;
			System.out.println("strconf = " + strconf);		
			
			
		}
		//比较
		if (e.getSource().equals(evtSource.btnCompara)) {
			int k = Comparer.Comparison(
					evtSource.txEditor.getText(), 
					evtSource.txMessage.getText(), 
					true, strconf);
			evtSource.labOutMsg.setText(k + "");
		}
		//检查
		if (e.getSource().equals(evtSource.btnCheck)) {
			int msgcode = -1000;
			String str = evtSource.txMessage.getText();
			if (str.equals(null) || str.equals(""))			//It is Empty, return; 
				evtSource.labOutMsg.setText(6100 + "");
			else {
				if (!Sharing.isMathString(str)){			//Is MathML character?
					if (Sharing.illicitChars(str)) {				//Contain illicit character?
						evtSource.labOutMsg.setText(3012 + "");		//Message out.
						return ;
					}
					str = editor.Editor.getMathStr(str);			//Convert to MathML character.
				}
				
				msgcode = Inspector.incompleteNode(str);					//Contain space character?
				Inspector isp = new Inspector(str);
				
				evtSource.labOutMsg.setText(msgcode + "");
			}
		}
		//清理；
		if (e.getSource().equals(evtSource.btnClear)) {
			evtSource.txEditor.setText("");
			evtSource.txMessage.setText("");
		}
		
		
		//退出
		if (e.getSource().equals(evtSource.btnExit)) {
			System.exit(JFrame.EXIT_ON_CLOSE);
		}
	}
	//}end
	
	
	/**
	 * 加载图片以显示；
	 * @param picObject
	 */
	private void LoadPicture(Object picObject) {
		evtSource.northPane.removeAll();
		JLabel label = new JLabel("");
		label.setAlignmentX(Label.CENTER_ALIGNMENT);
		label.setAlignmentY(Label.CENTER_ALIGNMENT);
		evtSource.northPane.add(label);
		if (picObject instanceof String) {
			label.setIcon(new ImageIcon(picObject.toString()));
		}

		if (picObject instanceof byte[]) {
			label.setIcon(new ImageIcon((byte[]) picObject));
		}
		
		evtSource.northPane.repaint();
	}


}
