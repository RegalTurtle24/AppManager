import java.util.HashMap;

public class LinkManager {
	private HashMap<String, QuickLinks> links;
	
	public LinkManager()
	{
		links = new HashMap<String, QuickLinks>();
	}
	
	//this method is just for testing
	/* public LinkManager(HashMap<String, QuickLinks> links) {
		this.links = links;
	}*/
	
	// Purpose: Adds a link with the characteristics Name, Link, Username, and Password as
	// given by the parameters 
	// Input: QuickLinks
	// Output: Returns true if there was a link with name already, and false if it was a new
	// name
	public boolean addLink(QuickLinks link)
	{
		//if there's already an entry in the map with the same name as the link to be added
		//return true
		if (links.containsKey(link.getName())) {
			return true;
		}
		
		//otherwise put the link into the map
		//return false
		links.put(link.getName(), link);
		return false;
	}
	
	// Purpose: Changes the username and password areas of the website named "name"
	// Input: Name of website, username for site, and password for site
	// Output: Returns true if the username and password were input, and false if the name
	// submitted does not appear in the text file
	public boolean addCredentials(String name, String user, String pass) {
		// set up links
		if (links.containsKey(name)) {
			QuickLinks link = links.get(name);
			link.setUsername(user);
			link.setPassword(pass);
			return true ;
		// or else return false if not in HashMap
		} else {
			return false;
		}
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
		return links.get(name);
	}
}
