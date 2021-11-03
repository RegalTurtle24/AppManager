import java.util.ArrayList;

public class NewQuickLink {
	
	// purpose: createNewQuickLink takes in a Name, URL, usernames, and password and
	// both returns a quickLink with those parameters and uses the textfilemanager to write
	// the quick link into files. 
	// input: Name, URL, username, and password
	// output: returns a QuickLinks with the inputted Name, URL, username, and password
	public static QuickLinks createNewQuickLink(String username, String password, String url, String name) {
		if (name.equals("") && url.equals("") && username.equals("") && password.equals("")) {
			return null; // return null if the nothing was inputted
		} else { // if any parameter inputted return quicklink
			ArrayList<String> parameters = new ArrayList<String>();
			parameters.add(name);
			parameters.add(url);
			parameters.add(username);
			parameters.add(password);
			//FileManager.writeToFile(parameters);
			return new QuickLinks(username, password, url, name);
		}
	}
}
