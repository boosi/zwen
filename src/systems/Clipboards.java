package systems;

import java.awt.Component;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;




public class Clipboards extends Clipboard {
	
	Clipboard clipboard;
	
	

	public Clipboards(String arg0) {
		super(arg0);
	}

	 
	public void Copy(Object object) {
		clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
	}


	private Object getToolKit() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
	
	
}
