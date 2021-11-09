import org.junit.*;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

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
	
	
	@Test
	// purpose: check if URL is not changed when QuickLink is changed
	// input: run addlink with QuickLink containing name = gaming, username = gaming, 
	// password = gaming, and url gaming.com. THen run addCredentials with name = gaming, user = go,
	// password = go.
	// output: the URL is still "gaming"
	public void doesAddCedentialsKeepTheUrl() {
		// set up link
		LinkManager manager = new LinkManager();
		QuickLinks link = new QuickLinks("gaming", "gaming", "gaming.com", "gaming");
		manager.addLink(link);
		// test
		manager.addCredentials("gaming", "go", "go");
		QuickLinks changedLink = manager.getLink("gaming");
		Assert.assertEquals("gaming.com", changedLink.getUrl());
	}
	
	/*
	@Test 
	// purpose: check if the username and file is written onto file 
	// input: addlink with name = "jargon", username = "gaming", password = "gaming", url = "gaming.com"
	// Runs addCredentials with name = "gaming", user = "go", pass = "go"
	// output: in file "jargon"'s  username and password are both changed to go, go
	public void doesAddCedentialsChangeFile() {
		try {
			// set up QuickLink
			LinkManager manager = new LinkManager();
			QuickLinks link = new QuickLinks("gaming", "gaming", "gaming", "jargon");
			manager.addLink(link);
			// look though file to setup QuickLink
			File file = new File("infoFile.txt"); // <- Thys supplies this
			Scanner scanner = new Scanner(file);
			// look though file
			boolean isInformationCorrect = true;
			ArrayList<String> linkInFile = scanner.next;
			while (fileManager.getNextSet()) {
				linkInFile 
			}
			
		} catch (FileNotFoundException E) {
			Assert.fail("The file doesn't exist");
		}
		
		
		
	}
	*/
	
	
}
