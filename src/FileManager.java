import java.util.HashMap;

public class FileManager {
	HashMap<String, QuickLink> links;
	
	// Take in a HashMap provided by Runner to store the QuickLinks
	public FileManager(HashMap<String, QuickLink> runnerLinks)
	{
		links = runnerLinks;
	}
	
	// Adds a link with the characteristics Name, Link, Username, and Password as
	// given by the parameters
	public static boolean addLink(String name, String link, String use, String pass)
	{
		return false;
	}
	
	private static void importLinks()
	{
		
	}
}
