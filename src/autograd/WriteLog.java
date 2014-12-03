package autograd;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;

import javax.sound.midi.Instrument;
import javax.swing.text.DateFormatter;

public final class WriteLog {

	static String			filepath 		= "c:\\temp\\acelog\\autolog.dat"; 
	static File 			file;
	
	
	static void write(Exception inex) {
		FileWriter	fwrite = null;
		file = new File(filepath);
		try {
			fwrite = new FileWriter(file, true);
			fwrite.write("\n\n" + inex.getMessage());
			fwrite.write("\n" + new Date());
			fwrite.flush();
			fwrite.close();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	static boolean writeFile(Object obj) {
		FileWriter	fwrite = null;
		file = new File(filepath);
		try {
			fwrite = new FileWriter(file, true);
			fwrite.write("\n\n" + obj);
			fwrite.flush();
			fwrite.close();
		}
		catch (Exception ex) {
			
		}
		finally {
			if (fwrite != null)
				try {
					fwrite.close();
				} catch (IOException ex) {
					ex.printStackTrace();
				}
		}
		return false;
	}
	
	static boolean writelog(String instr) {
		writeFile(instr);
		return true;
	}
}
