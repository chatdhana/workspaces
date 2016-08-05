package file_manipulation;

import java.io.File;
import java.io.FilenameFilter;

public class FindFile {

	public static void main(String[] args) {
		// ls -a
		new FindFile().displayFiles("C:/");
		// Display all the files in a directory recursively
//		new FindFile().displayFilesRecursively("C:/Documents and Settings/dgovindan/Desktop/pro1");
	}

	// Displays the files in a current directory( ls -a)
	void displayFiles(String directory) {
		File dir = new File(directory);
		File[] files = dir.listFiles(filterBoth);
		System.out.println("*************** Files in :" + directory +" directory");
		for (File file : files) {
			if (file.isFile()) {
				System.out.println(file.getName());
			}
		}
	}

	// Display all the files recursively
	void displayFilesRecursively(String directory) {
		File dir = new File(directory);
		if (dir.isDirectory()) {
			new FindFile().displayFiles(directory);
			File[] files = dir.listFiles();
			for (File file : files) {
				if (file.isDirectory()) {
					new FindFile().displayFilesRecursively(file.getPath());
				}
			}
		} else if (dir.isFile()) {
			System.out.println(dir.getName());
		}
	}
	
	// Display the files recursively
	void displayFilteredFilesRecursively(String directory) {
		File dir = new File(directory);
		if (dir.isDirectory()) {
			new FindFile().displayFiles(directory);
			File[] files = dir.listFiles(filterEnd);
			for (File file : files) {
				if (file.isDirectory()) {
					new FindFile().displayFilesRecursively(file.getPath());
				}
			}
		} else if (dir.isFile()) {
			System.out.println(dir.getName());
		}
	}

	// File filter to not to display the files starts with "."
	FilenameFilter filterStart = new FilenameFilter() {
        public boolean accept(File dir, String name) {
            return !name.startsWith(".");
        }
    };
 // File filter to not to display the files ends with ".BAT"
    FilenameFilter filterEnd = new FilenameFilter() {
        public boolean accept(File dir, String name) {
            return !name.endsWith(".BAT");
        }
    };
 // File filter to not to display the files starts with "." & ends with ".SYS"
    FilenameFilter filterBoth = new FilenameFilter() {
        public boolean accept(File dir, String name) {
            return (!name.startsWith("."))&&(!name.endsWith(".SYS"));
        }
    };

}
