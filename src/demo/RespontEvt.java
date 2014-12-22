package demo;

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

import mathematica.Calculate;
import mathematica.Mathematic;
import autogrd.Comparer;


public class RespontEvt implements ActionListener {

	private JFileChooser 		chooser;
	private GuiElements 		evtSource;
	private ConfigPanel			configPane;
	private JFrame				showFrame;
	
	public JFrame				mainFrm;
	public String 				strConfig;
	
	
	public RespontEvt(Object object) {
		evtSource = (GuiElements) object;
		configPane = new ConfigPanel(null);
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
			LoadPicture(Calculate.getImageBytes(expression));
		}
		//转换 	to Math ML字符串 
		if (e.getSource().equals(evtSource.btnCovert1)) {
			String strExpr = evtSource.txEditor.getText();
			evtSource.txMessage.setText(Calculate.Transform(strExpr, 2));
		}
		//转换 	to Arith字符串并计算结果
		if (e.getSource().equals(evtSource.btnCovert2)) {
			String strExpr = evtSource.txEditor.getText();
			evtSource.txMessage.setText(Calculate.Transform(strExpr, -2));
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
			evtSource.txMessage.setText(Calculate.Calculation(strExpr).toString());
		}
		//导出
		if (e.getSource().equals(evtSource.btnExport)) {
			//暂时不设定此功能；
		}
		//显示设定对话框
		if (e.getSource().equals(evtSource.btnConfig)) {
			showFrame = new ShowFrame(configPane, "Configurable Compare Schema", 320, 480);
			showFrame.setVisible(true);
			showFrame.addWindowListener(new WindowAdapter() {
				public void windowClosing(WindowEvent e) {
					System.out.println("Button:");
					System.out.println("Button:" + showFrame.getOwner());
				}
			});
		}
		//比较
		if (e.getSource().equals(evtSource.btnCompara)) {
			int k = Comparer.Comparison(
					evtSource.txEditor.getText(), 
					evtSource.txMessage.getText(), 
					true, "121");
			evtSource.labOutMsg.setText(k + "");
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


	//{bgn	实现 WindowListener 接口方法
	public void windowActivated(WindowEvent e) {
		
	}

	public void windowClosed(WindowEvent e) {
		
	}

	public void windowClosing(WindowEvent e) {
		
	}

//	public void windowDeactivated(WindowEvent e) {
//		if (e.getSource().equals(showFrame)) {
//			strConfig = ((ShowFrame) showFrame).strConfig;
//			System.out.println(e.getSource());
//		}
//	}

	public void windowDeiconified(WindowEvent e) {
		
	}

	public void windowIconified(WindowEvent e) {
		
	}

	public void windowOpened(WindowEvent e) {
		
	}
	//}end
	
}
