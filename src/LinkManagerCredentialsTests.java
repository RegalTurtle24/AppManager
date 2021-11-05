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
	
	
}
