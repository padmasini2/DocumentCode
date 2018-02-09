import java.io.File;

import javax.swing.filechooser.FileFilter;

public class FileFilterprg extends FileFilter {
	
    private String extension;
    private String description;

    public FileFilterprg(String extension, String description) {
        this.extension = extension;
        this.description = description;
    }
	@Override
	public boolean accept(File file) {
		 if (file.isDirectory()) {
	            return true;
	        }
	        return file.getName().endsWith(extension);
	    }

	@Override
	public String getDescription() {
		 return description + String.format(" (*%s)", extension);
	}
	
	

}
