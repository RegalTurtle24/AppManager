import org.junit.*;

public class CreateNewLinksTestCases {
	@Test
	public void nameLinkTest() {
		QuickLink link = new QuickLink("lwsd", "lwsd.org", null, null);
		QuickLink createdLink = CreateNewLinks.createNewLink("lwsd", "lwsd.org");
		//Assert.assertEquals(createdLink);
		// jUnit test that tests if new links can accept user inputs
		// takes in new link with name: Lwsd, link: lwsd.org, no username, no passsword
		// test is successful if method returns link with these perimeters
		// it's going to test be manually creating quicklink and comparing the contents of the two.
	}

}
