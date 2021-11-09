import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DesktopManager {
	
	public static void openLink(QuickLinks customLink) {
		System.setProperty("webdriver.chrome.driver", "C:\\WebDriver\\bin\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.lwsd.org/");
		driver.quit();
	}
	
	public static void loginSkyward(QuickLinks skyward) {
		
	}
	
	public static void openSkywardGrading(QuickLinks skywardLink) {
		openLink(skywardLink);
	}
	
	
	public static void openSkywardAttendance(QuickLinks skywardLink) {
		openLink(skywardLink);

	}
	
		
	public static void loginCustomQuicklink(QuickLinks customLink) {
		openLink(customLink);

	}
}
