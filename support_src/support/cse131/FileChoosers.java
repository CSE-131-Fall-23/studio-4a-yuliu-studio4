package support.cse131;

import java.io.File;

import javax.swing.JFileChooser;

/**
 * @author Dennis Cosgrove (http://www.cse.wustl.edu/~cosgroved/)
 */
public class FileChoosers {
	public static File chooseFile(String[] argsFromMain, File directory) {
		File file = null;
		if (argsFromMain.length > 0) {
			file = new File(argsFromMain[0]);
			if (file.exists()) {
				// pass
			} else {
				file = new File(directory, argsFromMain[0]);
				if (file.exists()) {
					// pass
				} else {
					file = null;
				}
			}
		}
		if (file == null) {
			JFileChooser fc = new JFileChooser();
			fc.setCurrentDirectory(directory);
			fc.showOpenDialog(null);
			file = fc.getSelectedFile();
		}
		return file;
	}
}
