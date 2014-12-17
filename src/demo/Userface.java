package demo;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Event;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Label;

import javax.swing.GroupLayout.Alignment;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SpringLayout.Constraints;
import javax.swing.UIManager;



/**
 * 用户图形界面；
 * @author Zhengwen
 * 
 *27 Nov, 2014
 */
public class Userface extends JFrame {

	private static final long serialVersionUID = 4855245135785428711L;
	
	private Container 			contentPanel;
	private GuiElements 		ufs;
	private GridBagLayout		layout;
	private GridBagConstraints	gridbag;
	private RespontEvt			Evt;
	
	/**
	 * 构造器；
	 */
	public Userface() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gridbag		= new GridBagConstraints();
		layout			= new GridBagLayout();
		ufs 			= new GuiElements();
		Evt				= new RespontEvt(ufs);
		Evt.mainFrm		= this;
		contentPanel 	= getContentPane();
		initialComponents();
		addEvents();
	}
	
	
	/**
	 * 初始化控件；
	 */
	void initialComponents() {
		setTitle("Auto-Griding 2.0");
		setSize(840, 560);
		setLocationRelativeTo(null);
		contentPanel.setLayout(layout);
		layout.rowWeights 		= new double[] {0.4, 0.0, 0.4, 0.0, 0.0};
		layout.columnWeights	= new double[] {0.25, 0.75};
		gridbag.fill = GridBagConstraints.BOTH; 	// 组件彼此的间距
		gridbag.insets = new Insets(2, 2, 2, 2); 	// 组件彼此的间距
		gridbag.anchor = GridBagConstraints.CENTER;	// 当组件小于单元格，被锚在中间；
		
		// 编辑器、输入；
		add(new JScrollPane(ufs.txEditor), gridbag);
		// 图形，图像显示区域；
		gridbag.gridx 		= 1;
		gridbag.gridy 		= 0;
		gridbag.gridwidth 	= GridBagConstraints.REMAINDER;
		gridbag.gridheight 	= 4;
		add(new JScrollPane(ufs.northPane), gridbag);
		// 功能按钮；
		gridbag.gridx = 0;
		gridbag.gridy 		= 1;
		gridbag.gridwidth	= 1;
		gridbag.gridheight	= 1;
		ufs.west1Pane.setPreferredSize(new Dimension(280, 40));
		add(ufs.west1Pane, gridbag);
		ufs.west1Pane.setBackground(new Color(240, 240, 240));
		// 输出；
		gridbag.gridy 		= 2;
		add(new JScrollPane(ufs.txMessage), gridbag);
		// 功能按钮
		gridbag.gridy 		= 3;
		ufs.west2Pane.setPreferredSize(new Dimension(280, 40));
		add(ufs.west2Pane, gridbag);
		ufs.west2Pane.setBackground(new Color(240, 240, 240));
		//备用，系统等；
		gridbag.gridy 		= 4;
		add(ufs.west3Pane, gridbag);
		ufs.west3Pane.setBackground(new Color(240, 240, 240));
		// 图像、图形控制；
		gridbag.gridx 		= 1;
		gridbag.gridy 		= 4;
		add(ufs.southPane, gridbag);
		ufs.southPane.setBackground(new Color(200,240,180));
		ufs.southPane.setLayout(new BorderLayout(2, 2));
		ufs.southPane.add(new JLabel("Message:"), BorderLayout.WEST);
		ufs.southPane.add(ufs.labOutMsg, BorderLayout.CENTER);
		
		// 功能按钮一；
		ufs.west1Pane.add(ufs.btnPlot);
		ufs.west1Pane.add(ufs.btnCovert1);
		ufs.west1Pane.add(ufs.btnCovert2);
		ufs.west1Pane.add(ufs.btnImport);
		ufs.west1Pane.add(ufs.btnCalcul);
		// 功能按钮二；
		ufs.west2Pane.add(ufs.btnCheck);	ufs.btnCheck.setEnabled(false);
		ufs.west2Pane.add(ufs.btnCompara);	//ufs.btnCompara.setEnabled(false);
		ufs.west2Pane.add(ufs.btnExport);	ufs.btnExport.setEnabled(false);
		//系统按钮
		ufs.west3Pane.add(ufs.btnConfig);
		ufs.west3Pane.add(ufs.btnClear);
		ufs.west3Pane.add(ufs.btnExit);
		
		//图像显示；
		ImageIcon img = new ImageIcon("E:/Users/Adminis/Pictures/CAEB6SJ2.jpg");
		JLabel label = new JLabel();
		label.setHorizontalAlignment(Label.RIGHT);
		label.setVerticalAlignment(Label.CENTER);
		label.setIcon((Icon) img);
		ufs.northPane.add(label);
	}
	
	
	/**
	 * 给控件添加动作；
	 */
	void addEvents() {
		// 功能按钮一；
		ufs.btnPlot.	addActionListener(Evt);
		ufs.btnCovert1.	addActionListener(Evt);
		ufs.btnCovert2.	addActionListener(Evt);
		ufs.btnImport.	addActionListener(Evt);
		ufs.btnCalcul.	addActionListener(Evt);
		// 功能按钮二；
		ufs.btnCheck.	addActionListener(Evt);
		ufs.btnCompara.	addActionListener(Evt);
		ufs.btnExport.	addActionListener(Evt);
		//系统按钮
		ufs.btnCheck.	addActionListener(Evt);
		ufs.btnConfig.	addActionListener(Evt);
		ufs.btnClear.	addActionListener(Evt);
		ufs.btnExit.	addActionListener(Evt);
	}
	
	
	
	
	/**
	 * For Test luanch;
	 */
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getInstalledLookAndFeels()[1].getClassName());
		} catch (Exception ex) {
			
		}
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFrame ugi = new Userface();
					ugi.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
