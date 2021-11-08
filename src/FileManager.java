import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileManager {
	private static final int LINES_PER_SET = 4;
	private static Scanner sc;
	private static File info;
	private static FileWriter fw;
	
	// Purpose: Gets the next set of LINES_PER_SET lines and returns them in an ArrayList to
	// LinkManager
	// Input: None
	// Output: ArrayList of the next LINES_PER_SET lines
	public static ArrayList<String> getNextSet() {
		try {
			if(info == null) {
				info = new File("infoFile.txt");
				createDefaultFile(info);
			}
			if(sc == null) {
				sc = new Scanner(info);
			}
			ArrayList<String> set = new ArrayList<String>();
			for(int i = 0 ; i < LINES_PER_SET ; i++) {
				if (sc.hasNextLine()) {
					set.add(sc.nextLine());
				} else {
					return null;
				}
			}
			return set;
		} catch (IOException e) {
			return null;
		}
	}
	
	// Purpose: Checks if there is a file in the folder already, and if there is not it will create
	// a file and load it with the default links
	// Input: None
	// Output: If there is no file, create file, returns true if a new file was created
	public static boolean createDefaultFile(File f)
	{
		try {
//			createNewFile tries to create a new file, if it does, returns true, if not, returns
//			false
			if(f.createNewFile()) {
				FileWriter fw = new FileWriter(f, true);
//				name
				fw.write("Skyward Grades\n");
//				URL
				fw.write("https://www2.saas.wa-k12.net/scripts/cgiip.exe/WService=wlkwashs71/fwemnu01.w\n");
//				username
				fw.write("\n");
//				password
				fw.write("\n");
				
				fw.write("Skyward Attendance\n");
				fw.write("\n");
				fw.write("\n");
				fw.write("\n");
				
				fw.write("Frontline Absence Management\n");
				fw.write("\n");
				fw.write("\n");
				fw.write("\n");
				
				fw.write("Frontline Evaluations\n");
				fw.write("\n");
				fw.write("\n");
				fw.write("\n");
				
				fw.close();
				return true;
			} else {
				return false;
			}
		} catch (IOException e) {
			return false;
		}
	}
	
	// Purpose: Write a new set of information at the bottom of the file or where 1st parameter
	// (name) is found
	// Input: ArrayList of parameters to be added
	// Output: Returns false if no data was overridden, true if any data was changed
	public static boolean writeToFile(ArrayList<String> parameters)
	{
		return false;
	}
}
