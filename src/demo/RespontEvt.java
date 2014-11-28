package demo;

import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;

import autograd.Mathematic;
import others.HandleImage;


public class RespontEvt implements ActionListener {

	private JFileChooser 		chooser;
	private GuiElements 		evtSource;
	
	
	public RespontEvt(Object object) {
		evtSource = (GuiElements) object;
	}
	
	
	
	
	
	public void actionPerformed(ActionEvent e) {
		//绘图
		if (e.getSource().equals(evtSource.btnPlot)) {
			String expression = evtSource.txEditor.getText();
			LoadPicture(Mathematic.getByteArray(expression));
		}
		//导入
		if (e.getSource().equals(evtSource.btnImport)) {
			chooser = new JFileChooser();
			int result = chooser.showOpenDialog(null);
			if (result == JFileChooser.APPROVE_OPTION) {
				LoadPicture(chooser.getSelectedFile().getPath());
			} 
		}
		//导出
		if (e.getSource().equals(evtSource.btnExport)) {
			//byte[] bytess = Mathematic.ExpressGraph(inputtxt.getText());
			//LoadPicture(bytess);

			//System.out.println(inputtxt.getText());
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

	
	
	public void LoadPicture(Object picObject) {
		evtSource.northPane.removeAll();
		JLabel label = new JLabel("");
		label.setAlignmentX(label.HORIZONTAL);
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
