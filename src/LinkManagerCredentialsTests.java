import org.junit.*;

public class LinkManagerCredentialsTests {
	@Test
	// purpose: checks if add credentials replaces clickLink and adds new credentials
	// input: run addLink with QuickLink containing name = gaming, user = gaming,
	// password = gaming, and url = gaming. Then run addCredentials with name = gaming,
	// user = array, password = array
	// output: HashMap link with name gaming, has username of array and password of array
	public void doesAddCedentialsChangeLink() {
		// set up link
		LinkManager manager = new LinkManager();
		QuickLinks link = new QuickLinks("gaming", "gaming", "gaming", "gaming");
		manager.addLink(link);
		// run addCedentials
		manager.addCredentials("gaming", "array", "array");
		// test
		QuickLinks outputLink = manager.getLink("gaming");
		String[] output = {outputLink.getUsername(), outputLink.getPassword()};
		String[] expected = {"array", "array"};
		Assert.assertEquals(output, expected);
	}
	
	@Test
	// purpose: checks if the method returns true if the username and password were input
	// input: run addlink with QuickLink containing name = gaming, useranme = gaming, 
	// password = gaming, and url gaming. THen run addCredentials with name = gaming, user = bruh,
	// password = bruh.
	// output: returns true the changes
	public void doesAddCedentialsReturnTrueIfUserPassInputted() {
		// set up link
		LinkManager manager = new LinkManager();
		QuickLinks link = new QuickLinks("gaming", "gaming", "gaming", "gaming");
		manager.addLink(link);
		// test
		Assert.assertTrue(manager.addCredentials("gaming", "bruh", "bruh"));
	}
	
	/*
	@Test
	// purpose: check if URL is not changed when QuickLink is changed
	// input: run addlink with QuickLink containing name = gaming, username = gaming, 
	// password = gaming, and url gaming. THen run addCredentials with name = gaming, user = go,
	// password = go.
	// output: the URL is still "gaming"
	public void doesAddCedentialsKeepTheUrl() {
		// set up link
		LinkManager manager = new LinkManager();
		QuickLinks link = new QuickLinks("gaming", "gaming", "gaming", "gaming");
	}
	*/
	
	
}
