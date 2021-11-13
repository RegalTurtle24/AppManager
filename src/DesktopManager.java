import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
		driver.get(skyward.getUrl());
		WebElement loginUser = driver.findElement(By.id("login"));
		loginUser.sendKeys(skyward.getUsername());
		WebElement loginPass = driver.findElement(By.id("password"));
		loginPass.sendKeys(skyward.getPassword()+ Keys.ENTER);
	}
	
	public void openSkywardGrading(QuickLinks skywardLink) {
		loginSkyward(skywardLink);
		WebElement home = driver.findElement(By.className("first selected"));
		WebElement gradebook = driver.findElement(with(By.className("sf_navMenuItem").below(home));
	}
	
	
	public void openSkywardAttendance(QuickLinks skywardLink) {
		loginSkyward(skywardLink);

	}
	
		
	public void loginCustomQuicklink(QuickLinks customLink) {
		openLink(customLink);

	}
	
	public void loginPearson(QuickLinks pearsonLink) {
		WebElement username = driver.findElement(By.id("username"));
		WebElement password = driver.findElement(By.id("password"));
		username.sendKeys(pearsonLink.getUsername());
		password.sendKeys(pearsonLink.getPassword() + Keys.ENTER);
	}
}