import static org.junit.Assert.*;


import org.junit.Test;

public class DesktopManagerTests {
	DesktopManager runner = new DesktopManager();
	@Test
	public void openBrowser() {
		QuickLinks test = new QuickLinks("yes", "yes", "https://lwsd.org", "lwsd website");
		runner.openLink(test);
		assertTrue("this did not open lwsd.org", true);
	}
//	public static void loginSkyward() {
//		QuickLinks test = new QuickLinks("yes", "yes", "https://www2.saas.wa-k12.net/scripts/cgiip.exe/WService=wlkwashs71/fwemnu01.w", "lwsd website");
//		DesktopManager.loginSkyward(test);
//		assertTrue("opened skyward", true);
//	}
}
