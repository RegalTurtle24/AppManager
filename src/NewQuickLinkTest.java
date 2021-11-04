import org.junit.*;
import java.util.Scanner;

import static org.junit.Assert.fail;

import java.io.File;
import java.io.FileNotFoundException;

public class NewQuickLinkTest {
	
	@Test
	// purpose: Check if the code adds a particular quickLink to the QuickLink HashMap
	// input: username = gaming, password = gaming, url = gaming, name = gaming
	// output: There is a quickLink stored in the HashMap.
	public void doesCodeAddQuickLink() {
		// create quickLink
		LinkManager manager = new LinkManager();
		NewQuickLink.createNewQuickLink("gaming", "gaming", "gaming", "gaming", manager);
		QuickLinks link = manager.getLink("gaming");
		//retrieve
		if (link == null) {
			Assert.fail("QuickLink wasn't even in linkManager Hashmap");
		} else {
			String[] expected = {"gaming", "gaming", "gaming", "gaming"};
			String[] results = new String[4];
			results[0] = link.getUsername();
			results[1] = link.getPassword();
			results[2] = link.getUrl();
			results[3] = link.getName();
			Assert.assertEquals(expected, results);
		}

	}
	
	@Test
	// purpose: Tests if write onto file
	// input: username = gaming, password = gaming, url = gaming, name = gaming
	// output: gaming, gaming, gaming.com, and gaming is written onto file
	public void doesCodeWriteOntoFile() {
		try {
			// createNewLink
			LinkManager manager = new LinkManager();
			NewQuickLink.createNewQuickLink("gaming", "gaming", "gaming", "gaming", manager);
			// create File and file Reader
			File file = new File("infoFile.txt"); // <-- Thys supplies this 
			Scanner scanner = new Scanner(file);
			// goes though file to see if information was written
			boolean isInformationCorrect = true;
			for (int x = 0; x < 4; x++) {
				if (!scanner.hasNextLine() || !scanner.nextLine().equals("gaming")) {
					isInformationCorrect = false;
				} 
			}
			Assert.assertTrue("successfully wrote on file", isInformationCorrect);
			scanner.close();
			
		} catch (FileNotFoundException E) {
			Assert.fail("The File didn't exist");
		}
	}
}
