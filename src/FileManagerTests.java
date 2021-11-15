import static org.junit.Assert.assertEquals;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.Test;

@TestMethodOrder(OrderAnnotation.class)
public class FileManagerTests {	
	@Test
	@Order(1)
	public void creationOfNewFile() {
		try {
			File f = new File("infoFile.txt");
			FileManager.createDefaultFile(f);
			Scanner sc = new Scanner(f);
			assertEquals(sc.hasNextLine(), true);
			assertEquals(sc.nextLine(), "Skyward Grades");
			for (int i = 0 ; i < 15 ; i++) {
				assertEquals(sc.hasNextLine(), true);
				sc.nextLine();
			}
			
			sc.close();
			
		} catch (NoSuchElementException e) {
			assertEquals(true, false);
		} catch (IOException e) {
			assertEquals(true, false);
		}
	}
	
	@Test
	@Order(2)
	public void seeFirstSet() {
		
		ArrayList<String> correctFirstSet = new ArrayList<String>();
		correctFirstSet.add("Skyward Grades");
		correctFirstSet.add("https://www2.saas.wa-k12.net/scripts/cgiip.exe/WService=wlkwashs71/fwemnu01.w");
		correctFirstSet.add("");
		correctFirstSet.add("");
		ArrayList<String> testFirstSet = FileManager.getNextSet();
				
		assertEquals(correctFirstSet, testFirstSet);
	}
	
	@Test
	@Order(3)
	public void seeSecondSet() {
		
		ArrayList<String> correctSecondSet = new ArrayList<String>();
		correctSecondSet.add("Skyward Attendance");
		correctSecondSet.add("");
		correctSecondSet.add("");
		correctSecondSet.add("");
		ArrayList<String> testSecondSet = FileManager.getNextSet();
		
		assertEquals(correctSecondSet, testSecondSet);
	}
	
	@Test
	@Order(4)
	public void seeNonexistantSet() {
		
		for(int i = 0 ; i < 4 ; i++) {
			FileManager.getNextSet();
		}
		
		ArrayList<String> nextSet = FileManager.getNextSet();
		
		assertEquals(null, nextSet);
	}
	
	@Test
	@Order(5)
	public void writeToFileFrontline() {
		ArrayList<String> newFrontline = new ArrayList<String>();
		newFrontline.add("Frontline Absence Management");
		newFrontline.add("user");
		newFrontline.add("pass");
		newFrontline.add("");
		
		assertEquals(true, FileManager.writeToFile(newFrontline));
		
		FileManager.getNextSet();
		FileManager.getNextSet();
		
		assertEquals(newFrontline, FileManager.getNextSet());
	}
	
	@Test
	@Order(6)
	public void writeToFileFrontLineOverride() {
		ArrayList<String> newFrontline = new ArrayList<String>();
		newFrontline.add("Frontline Absence Management");
		newFrontline.add("link");
		newFrontline.add("username");
		newFrontline.add("password");
		
		assertEquals(true, FileManager.writeToFile(newFrontline));
		
		FileManager.getNextSet();
		FileManager.getNextSet();
		
		assertEquals(newFrontline, FileManager.getNextSet());
	}
	
	@Test
	@Order(7)
	public void writeToFileNewName() {
		ArrayList<String> newName = new ArrayList<String>();
		newName.add("Hello World");
		newName.add("helloworld.com");
		newName.add("hello");
		newName.add("world");
		
		assertEquals(false, FileManager.writeToFile(newName));
		
		for(int i = 0 ; i < 6 ; i++) {
			FileManager.getNextSet();
		}
		
		assertEquals(newName, FileManager.getNextSet());
	}
	
	@Test
	@Order(8)
	public void deleteSetWrongName() {
		assertEquals(false, FileManager.deleteSet(""));
	}
	
	@Test
	@Order(9)
	public void deleteSet() {
		assertEquals(true, FileManager.deleteSet("Skyward Grades"));
		ArrayList<String> expected = new ArrayList<String>();
		expected.add("Skyward Attendance");
		expected.add("");
		expected.add("");
		expected.add("");
		assertEquals(expected, FileManager.getNextSet());
	}
}