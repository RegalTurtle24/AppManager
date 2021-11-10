import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DesktopManager {
	private WebDriver driver;
	public DesktopManager() {
		System.setProperty("webdriver.chrome.driver", ".\\libs\\chromedriver.exe");
		driver = new ChromeDriver(); 
	}
	public void openLink(QuickLinks customLink) {
		driver.get(customLink.getUrl());
	}
	
	public void loginSkyward(QuickLinks skyward) {
		
	}
	
	public void openSkywardGrading(QuickLinks skywardLink) {
		openLink(skywardLink);
	}
	
	
	public void openSkywardAttendance(QuickLinks skywardLink) {
		openLink(skywardLink);

	}
	
		
	public void loginCustomQuicklink(QuickLinks customLink) {
		openLink(customLink);

	}
}