package demo;

import javax.swing.JButton;
import javax.swing.JLabel;
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
	JPanel 		west1Pane 	= new JPanel();		//绘图按钮面板；	
	JPanel 		west2Pane 	= new JPanel();		//控制按钮面板；	
	JPanel 		west3Pane 	= new JPanel();		//功能按钮面板；	
	//JPanel 		west4Pane 	= new JPanel();		//控制面板；	
	JPanel 		northPane 	= new JPanel();		//图片显示；	
	JPanel 		southPane 	= new JPanel();		//编辑显示；	
	JPanel 		boxPicture 	= new JPanel();		//图片显示组件；	
	JTextArea	txEditor	= new JTextArea("");		//编辑器输入文本框；
	JTextArea	txMessage	= new JTextArea("");		//信息输出文本框；
	
	JButton 	btnPlot		= new JButton("Plot");		//绘图按钮；
	JButton 	btnCovert1	= new JButton("To MML");	//转换为MathML格式；
	JButton 	btnCovert2	= new JButton("To TXT");	//转换为文本格式；
	JButton 	btnImport	= new JButton("Import");	//导入按钮；
	JButton 	btnCalcul	= new JButton("Calculate");	//计算按钮；
	JButton 	btnExport	= new JButton("Export");	//导出按钮；
	JButton 	btnCheck	= new JButton("Checking");	//检查按钮；
	JButton 	btnCompara	= new JButton("Compara");	//比较按钮；
	JButton 	btnConfig	= new JButton("Config");	//设定按钮；
	JButton 	btnClear	= new JButton("Clear");		//清理按钮；
	JButton 	btnExit		= new JButton("Exit");		//退出按钮；
	
	JLabel		labOutMsg	= new JLabel("  Display the information for result.");


	
	public static String[] boxName = new String[] {
		  "(111) Bearing / Degree '0' 2021"
		, "(121) Answer is not in the simplest form 2023"
		, "(122) Mixed Number 2025"
		, "(131) Standard Form 2027"
		, "(132) Index Notation 2029"
		
		, "(133) Surds 2031"
		, "(134) Set Notation 2033"
		, "(141) Trigonometric Function 2035"
		, "(142) Logarithmic Function 2037"
		, "(150#4) Decimal Places (strictly) 2039"
		
		, "(151#2) Decimal Places 2041"
		, "(152#3) Significant Figures 2043"
		, "(153#8) Significant Figures (strictly) 2045"
		, "(161) Rounding 2047"
		, "(162) Rund Up 2049"
		
		, "(163) Rund Down 2051"
		, "(171) Accept specified answer 2053"
		, "(181) Is Expansion 2055"
		, "(182) Is Factorisation 2057"
		, "(190) Surds Radical Form 2059"
		, "(191) Surds Index Form 2061"
		, "(192) Surds is the Index of Lager than Zero 2063"
	};
	




}
