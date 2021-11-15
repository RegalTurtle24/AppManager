import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.HashMap;

class LinkManagerTests {

	@Test
	void testAddLink() {
		//makes a HashMap
		HashMap<String, QuickLinks> tester = new HashMap<String, QuickLinks>();
		
		//populates above HashMap (not randomly, unfortunately)
		for (int i = 0; i < 5; i++) {
			String name = i + "";
			QuickLinks temp = new QuickLinks(
								  name + "username", 
								  name + "password", 
								  name + "url",
								  name);
			tester.put(temp.getName(), temp);
		}
		
		//makes a LinkManager with the HashMap in it
		LinkManager manager = new LinkManager(tester);
		
		//should be true
		boolean testTrueA = manager.addLink(new QuickLinks("lol", "lmao", "haha", "1"));
		boolean testTrueB = manager.addLink(new QuickLinks("lol", "lmao", "haha", "4"));
		//should be false
		boolean testFalse = manager.addLink(new QuickLinks("lol", "lmao", "haha", "beans"));
		
		//moment of truth
		assertTrue(testTrueA && testTrueB && !testFalse);
	}
	
	@Test
	public void testAddSameCredentials() {
		LinkManager manager = new LinkManager();
		
		for (int i = 0; i < manager.getHashMap().size(); i++) {
			manager.addLink(new QuickLinks("a" + i, "b" + i, "c" + i, "d" + i));
			System.out.println(	"username: " + manager.getLink("d" + i).getUsername() + 
							   	"\npassword: " + manager.getLink("d" + i).getPassword() +
							   	"\nurl: " + manager.getLink("d" + i).getUrl() +
							   	"\nname: " + manager.getLink("d" + i).getName());
		}
		
		String newCred = "large wall";
		
		for (int i = 0; i < manager.getHashMap().size(); i++) {
			manager.addCredentials(newCred, newCred, newCred);
		}
		
		assertTrue(	manager.getLink(newCred).getUsername() == newCred
					&& manager.getLink(newCred).getPassword() == newCred
					&& manager.getLink(newCred).getPassword() == newCred
					&& manager.getLink(newCred).getPassword() == newCred);
	}

	@Test
	public void testAddDifferentCredentials() {
		LinkManager manager = new LinkManager();
		
		for (int i = 0; i < manager.getHashMap().size(); i++) {
			manager.addLink(new QuickLinks("a" + i, "b" + i, "c" + i, "d" + i));
			System.out.println(	"username: " + manager.getLink("d" + i).getUsername() + 
							   	"\npassword: " + manager.getLink("d" + i).getPassword() +
							   	"\nurl: " + manager.getLink("d" + i).getUrl() +
							   	"\nname: " + manager.getLink("d" + i).getName());
		}
		
		String newCred = "large wall";
		
		for (int i = 0; i < manager.getHashMap().size(); i++) {
			manager.addCredentials(newCred + i, newCred + i, newCred + i);
		}
		
		assertTrue(	manager.getLink(newCred + "1").getUsername() == newCred + "1"
					&& manager.getLink(newCred + "1").getPassword() == newCred + "1"
					&& manager.getLink(newCred + "1").getName() == newCred + "1");
	}
}
