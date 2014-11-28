package demo;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;



/**
 * 界面的组件及元素；
 * @author Zhengwen
 * 
 *27 Nov, 2014
 */
public final class GuiElements {
	

	//JPanel 		mainPanel 	= new JPanel();		//主要信息面板； 
	JPanel 		west1Pane 	= new JPanel();		//控制面板；	
	JPanel 		west2Pane 	= new JPanel();		//控制面板；	
	JPanel 		west3Pane 	= new JPanel();		//控制面板；	
	JPanel 		west4Pane 	= new JPanel();		//控制面板；	
	JPanel 		northPane 	= new JPanel();		//图片显示；	
	JPanel 		southPane 	= new JPanel();		//编辑显示；	
	JPanel 		boxPicture 	= new JPanel();		//图片显示组件；	
	JTextArea	txEditor	= new JTextArea("");		//编辑器输入文本框；
	JTextArea	txMessage	= new JTextArea("");		//信息输出文本框；
	
	JButton 	btnPlot		= new JButton("Plot");		//绘图按钮；
	JButton 	btnImport	= new JButton("Import");	//导入按钮；
	JButton 	btnCovert	= new JButton("Convert");	//转换为MathML格式；
	JButton 	btnExport	= new JButton("Export");	//导出按钮；
	JButton 	btnCheck	= new JButton("Checking");	//导出按钮；
	JButton 	btnCompara	= new JButton("Compara");	//导出按钮；
	JButton 	btnConfig	= new JButton("Config");	//退出按钮；
	JButton 	btnClear	= new JButton("Clear");		//退出按钮；
	JButton 	btnExit		= new JButton("Exit");		//退出按钮；
}