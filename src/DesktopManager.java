import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.List;


//This entire class uses Selenium, a library for automating browsers.
// The Selenium website and library can be found here: https://www.selenium.dev/
public class DesktopManager {

	private WebDriver driver;
	
	//Initializes the webdriver and finds where chromedriver is in the local library
	public DesktopManager() {
		System.setProperty("webdriver.chrome.driver", ".\\libs\\chromedriver.exe");
		driver = new ChromeDriver(); 
	}
	
	//This opens a single link
	public void openLink(QuickLinks customLink) {
		driver.get(customLink.getUrl());
	}
	
	//opens skyward login and enters the credentials after finding the html ids for each login box
	public void loginSkyward(QuickLinks skyward) {
		driver.get(skyward.getUrl());
		System.out.println(driver.getWindowHandle());
		WebElement loginUser = driver.findElement(By.id("login"));
		loginUser.sendKeys(skyward.getUsername());
		WebElement loginPass = driver.findElement(By.id("password"));
		loginPass.sendKeys(skyward.getPassword()+ Keys.ENTER);
	}
	
	
	//logs into skyward and opens the student gradebook
	public void openSkywardGrading(QuickLinks skywardLink) throws InterruptedException {
		
		//stores the original window id to be able to change to an alternate window later
		String originalWindow = driver.getWindowHandle();
		loginSkyward(skywardLink);	
		
		//waits until a new window has been created
		while(driver.getWindowHandles().size()==1) {
			Thread.sleep(50);
		}
		//loops through to a new window (where the skyward pop-up will be
		for (String windowHandle : driver.getWindowHandles()) {
		    if(!originalWindow.contentEquals(windowHandle)) {
		        driver.switchTo().window(windowHandle);
		        break;
		    }
		}
//		loops until the page loads and finds the menu webelement, then I create the list and choose
//		the wanted index
		WebElement menu;
		while(true) {
			try {
				 menu = driver.findElement(By.id("sf_navMenu"));
					System.out.println("hi");

				break;
			} catch(org.openqa.selenium.NoSuchElementException noSuchElementException) {
				Thread.sleep(50);
			}
		}
		List<WebElement> menuList = menu.findElements(By.tagName("li"));;
		WebElement gradebook =  menuList.get(1);
		gradebook.click();
		System.out.println(gradebook.isEnabled());
	}
	
	
	public void openSkywardAttendance(QuickLinks skywardLink) {
		loginSkyward(skywardLink);

	}
	

//	This opens the login and uses finding by id to login, most sites have a common
//	name system for login: this is applicable for Pearson and AP
	public void loginCustomQuicklink(QuickLinks customLink) {
		openLink(customLink);
		WebElement username = driver.findElement(By.id("username"));
		WebElement password = driver.findElement(By.id("password"));
		username.sendKeys(customLink.getUsername());
		password.sendKeys(customLink.getPassword() + Keys.ENTER);

	}
	
//	This is a method on its own to ensure modularity if something changes, I can fix this
//	method and the user interface will work for this class
	public void loginPearson(QuickLinks pearsonLink) {
		loginCustomQuicklink(pearsonLink);
	}
	
//	This is a method on its own to ensure modularity if something changes, I can fix this
//	method and the user interface will work for this class
	public void loginAPClassroom(QuickLinks APLink) {
		loginCustomQuicklink(APLink);
	}
}