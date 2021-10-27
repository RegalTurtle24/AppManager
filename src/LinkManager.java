import java.util.HashMap;

public class LinkManager {
	private static HashMap<String, QuickLinks> links;
	
	public LinkManager()
	{
		links = new HashMap<String, QuickLinks>();
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
	public static boolean addCredentials(String name, String user, String pass)
	{
		return false;
	}
	
	// Returns the HashMap of QuickLinks
	public static HashMap<String, QuickLink> getHashMap()
	{
		return links;
	}
}
