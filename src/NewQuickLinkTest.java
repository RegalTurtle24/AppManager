import org.junit.*;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class NewQuickLinkTest {
	
	@Test
	// purpose: Tests if NewQuickLink returns an object 
	// input: No parameters, just runs createNewQuickLink
	// output: null or an object
	public void doesReturnObject() {
		QuickLinks link = NewQuickLink.createNewQuickLink("", "", "", "");
		Assert.assertEquals(link, null);
	}
	
	@Test
	// purpose: Tests if node input appear in QuickLink 
	// input: Name = LWSD
	// output: QuickLink with name Lwsd
	public void doesMethodInputNameIntoQuickLink() {
		QuickLinks link = NewQuickLink.createNewQuickLink("", "", "", "LWSD");
		Assert.assertEquals(link.getName(), "LWSD");
	}
	
	@Test
	// purpose: Tests if write onto file
	// input: username = gaming, password = gaming, url = gaming.com, name = gaming
	// output: gaming, gaming, gaming.com, and gaming is written onto file
	public void doesCodeWriteOntoFile() {
		try {
			NewQuickLink.createNewQuickLink("gaming", "gaming", "gaming", "gaming");
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
