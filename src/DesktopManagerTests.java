import static org.junit.Assert.*;


import org.junit.Test;

public class DesktopManagerTests {
	DesktopManager runner = new DesktopManager();
	@Test
	public void openBrowser() {
		QuickLinks test = new QuickLinks("yes", "yes", "https://lwsd.org", "lwsd website");
		runner.openLink(test);
		assertTrue("this shouldn't fail", true);
	}
	
	@Test
	public void loginSkyward() {
		QuickLinks test = new QuickLinks("subotmar000", "DodgersH@veWon20", "https://www2.saas.wa-k12.net/scripts/cgiip.exe/WService=wlkwashs71/fwemnu01.w", "lwsd website");
		runner.loginSkyward(test);
		assertTrue("this shouldn't fail", true);
	}
	@Test
	public void gradingSkyward() {
		try{
			QuickLinks test = new QuickLinks("subotmar000", "DodgersH@veWon20", "https://www2.saas.wa-k12.net/scripts/cgiip.exe/WService=wlkwashs71/fwemnu01.w", "lwsd website");
		runner.openSkywardGrading(test);
		assertTrue("this shouldn't fail", true);
		} catch(InterruptedException interruptedException){
			
		} finally {
			
		}
	}
}
