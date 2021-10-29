import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class FileManager {
	private static final int LINES_PER_SET = 4;
	private static Scanner sc;
	private static File info;
	
	// Purpose: Gets the next set of LINES_PER_SET lines and returns them in an ArrayList to
	// LinkManager
	// Input: None
	// Output: ArrayList of the next LINES_PER_SET lines
	public static ArrayList<String> getNextSet()
	{
		if(info == null) {
			info = new File("infoFile.txt");
		}
		if(sc == null) {
			sc = new Scanner("infoFile");
		}
		ArrayList<String> set = new ArrayList<String>();
		for(int i = 0 ; i < LINES_PER_SET ; i++) {
			if (sc.hasNext()) {
				set.add(sc.nextLine());
			} else {
				return null;
			}
		}
		return set;
	}
	
	// Purpose: Checks if there is a file in the folder already, and if there is not it will create
	// a file and load it with the default links
	// Input: None
	// Output: If there is no file, create file
	public static boolean createDefaultFile()
	{
		return false;
	}
	
	// Purpose: Write a new set of information at the bottom of the file or where 1st parameter
	// (name) is found
	// Input: ArrayList of parameters to be added
	// Output: Returns false if no data was overridden, true if any data was changed
	public static boolean writeToFile(ArrayList<String> parameters)
	{
		return false;
	}
	
	// Purpose: Get the number of different sets, stored at the top of the file
	// Input: None
	// Output: Number of sets
	public static int getNumSets()
	{
		return 0;
	}
}
