import java.util.HashMap;

public class FileManager {
	private static HashMap<String, QuickLink> links;
	
	// Constructor calls ImportLinks and CreateDefaultFile if needed
	public FileManager()
	{
		return;
	}
	
	// Adds a link with the characteristics Name, Link, Username, and Password as
	// given by the parameters
	
	// Returns true if there was a link with "name" already, and false if it was a new
	// name
	public static boolean addLink(String name, String link, String user, String pass)
	{
		return false;
	}
	
	// Changes the username and password areas of the website named "name"
	
	// Returns true if the username and password were input, and false if the name
	// submitted does not appear in the text file
	public static boolean addInfo(String name, String user, String pass)
	{
		return false;
	}
	
	public static HashMap<String, QuickLink> getHashMap()
	{
		return links;
	}
	
	// Reads through the file and imports all links in the file to QuickLinks, stored in
	// a HashMap
	private static void importLinks()
	{
		return;
	}
	
	// Checks if there is a file in the folder already, and if there is not it will create
	// a file and load it with the default links
	private static void createDefaultFile()
	{
		return;
	}
}
