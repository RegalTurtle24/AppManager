import org.junit.*;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class NewQuickLinkTest {
	
	//@Test
	// purpose: 
	// input:
	// output:
	//public void doesCodeAddQuickLink() {
		
	//}
	
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
