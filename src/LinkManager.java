import java.util.ArrayList;
import java.util.HashMap;

public class LinkManager {
	private static HashMap<String, QuickLinks> links;
	
	public LinkManager()
	{
		links = new HashMap<String, QuickLinks>();
		ArrayList<String> nextSet = FileManager.getNextSet();
		while(nextSet != null) {
			QuickLinks newQL = new QuickLinks(
						nextSet.get(2),
						nextSet.get(3),
						nextSet.get(1),
						nextSet.get(0));
			links.put(nextSet.get(0), newQL);
			nextSet = FileManager.getNextSet();
		}
	}
	
	// Purpose: Adds a link with the characteristics Name, Link, Username, and Password as
	// given by the parameters 
	// Input: QuickLinks
	// Output: Returns true if there was a link with name already, and false if it was a new
	// name
	public boolean addLink(QuickLinks link)
	{
		return false;
	}
	
	// Purpose: Changes the username and password areas of the website named "name"
	// Input: Name of website, username for site, and password for site
	// Output: Returns true if the username and password were input, and false if the name
	// submitted does not appear in the text file
	public boolean addCredentials(String name, String user, String pass)
	{
		return false;
	}
	
	// Purpose: Returns the HashMap of QuickLinks
	// Input: None
	// Output: HashMap of links
	public HashMap<String, QuickLinks> getHashMap()
	{
		return links;
	}
	
	// Purpose: Returns a QuickLink in the HashMap based on a String name
	// Input: Name of link
	// Output: QuickLinks if it was found, null if not
	public QuickLinks getLink(String name)
	{
		return null;
	}
}
