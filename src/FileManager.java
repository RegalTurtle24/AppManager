import java.util.ArrayList;
import java.util.HashMap;

public class FileManager {
	private static final int LINES_PER_SET = 4;
		
	// Purpose: Gets the next set of LINES_PER_SET lines and returns them in an ArrayList to
	// LinkManager
	// Input: None
	// Output: ArrayList of the next LINES_PER_SET lines
	public static ArrayList<String> getNextSet()
	{
		return null;
	}
	
	// Purpose: Checks if there is a file in the folder already, and if there is not it will create
	// a file and load it with the default links
	// Input: None
	// Output: If there is no file, create file
	public static void createDefaultFile()
	{
		return;
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
