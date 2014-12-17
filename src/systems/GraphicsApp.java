package systems;
import com.wolfram.jlink.*;
import java.awt.*;
import java.awt.event.*;

public class GraphicsApp extends Frame {
	static GraphicsApp app;
	static KernelLink ml;
	MathCanvas mathCanvas;
	TextArea inputTextArea;
	Button evalButton;
	Checkbox useFEButton;
	Checkbox graphicsButton;
	Checkbox typesetButton;

	public static void main(String[] argv) {
		try {
			//String path = "-linkmode launch -linkname 'c:\\program files\\wolfram research\\mathematica\\7.0\\mathkernel'";
			String path = "-linkmode launch -linkname 'D:\\Program Files\\Wolfram Research\\Mathematica\\mathkernel'";
			ml = MathLinkFactory.createKernelLink(path);
			ml.discardAnswer();
		} catch (MathLinkException e) {
			System.out.println("An error occurred connecting to the kernel.");
			if (ml != null)
				ml.close();
			return;
		}

		app = new GraphicsApp();
	}

	public GraphicsApp() {
		setLayout(null);
		setTitle("Graphics App");
		mathCanvas = new MathCanvas(ml);
		add(mathCanvas);
		mathCanvas.setBackground(Color.white);
		inputTextArea = new TextArea("", 2, 40, TextArea.SCROLLBARS_VERTICAL_ONLY);
		add(inputTextArea);
		evalButton = new Button("Evaluate");
		add(evalButton);
		evalButton.addActionListener(new BnAdptr());
		useFEButton = new Checkbox("Use front end", false);
		CheckboxGroup cg = new CheckboxGroup();
		graphicsButton = new Checkbox("Show graphics output", true, cg);
		typesetButton = new Checkbox("Show typeset result", false, cg);
		add(useFEButton);
		add(graphicsButton);
		add(typesetButton);
		setSize(300, 400);
		setLocation(100, 100);
		mathCanvas.setBounds(10, 25, 280, 240);
		inputTextArea.setBounds(10, 270, 210, 60);
		evalButton.setBounds(230, 290, 60, 30);
		graphicsButton.setBounds(20, 340, 160, 20);
		typesetButton.setBounds(20, 365, 160, 20);
		useFEButton.setBounds(180, 340, 100, 20);
		addWindowListener(new WnAdptr());
		setBackground(Color.lightGray);
		setResizable(false);
		// Although this code would automatically be called in
		// evaluateToImage or evaluateToTypeset, it can cause the
		// front end window to come in front of this Java window.
		// Thus, it is best to get it out of the way at the start
		// and call toFront to put this window back in front.
		// KernelLink.PACKAGE_CONTEXT is just "JLink`", but it is
		// preferable to use this symbolic constant instead of
		// hard-coding the package context.
		ml.evaluateToInputForm("Needs[\"" + KernelLink.PACKAGE_CONTEXT + "\"]", 0);
		ml.evaluateToInputForm("ConnectToFrontEnd[]", 0);
		setVisible(true);
		toFront();
	}

	class BnAdptr implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			mathCanvas.setImageType(graphicsButton.getState() ? MathCanvas.GRAPHICS : MathCanvas.TYPESET);
			mathCanvas.setUsesFE(useFEButton.getState());
			mathCanvas.setMathCommand(inputTextArea.getText());
		}
	}

	class WnAdptr extends WindowAdapter {

		public void windowClosing(WindowEvent event) {
			if (ml != null) {
				// Because we used the front end, it is important
				// to call CloseFrontEnd[] before closing the link.
				// Counterintuitively, this is not because we want
				// to force the front end to quit, but because we
				// _don't_ want to do this if the user has begun
				// working in the front end session we started.
				// CloseFrontEnd knows how to politely disengage
				// from the front end if necessary. The need for
				// this will go away in future releases of
				// Mathematica.
				ml.evaluateToInputForm("CloseFrontEnd[]", 0);
				ml.close();
			}
			app.evalButton.addActionListener(new BnAdptr(){
				public void actionPerformed(ActionEvent e) {
					if (e.getSource().equals(MouseEvent.BUTTON2)) {
						System.out.println("........................................");
					}
				}
			}); 
				
			
			dispose();
			System.exit(0);
		}
	}
}
