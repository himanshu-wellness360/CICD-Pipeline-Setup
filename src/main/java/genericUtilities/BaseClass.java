package genericUtilities;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;
import objectRepo.HomePage;
import objectRepo.LoginPage;

public class BaseClass {
	
	protected WebDriver driver;
	public static  PropertiesUtility PU = new PropertiesUtility();

	
	@BeforeClass(alwaysRun = true)
	public void BrowserSetup() throws Exception {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--headless");
		options.addArguments("window-size=1920,1080");
		options.addArguments("--no-sandbox");
		options.addArguments("--disable-dev-shm-usage");
		options.addArguments("--remote-allow-origins=*");
	
		String URL = PU.getDataFromProperties("url");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get(URL);
		System.out.println("Browser setup successful..");
	}
	@BeforeMethod(alwaysRun = true)
	public void LoginOperation() throws Exception {
		
		if (driver == null) {
            throw new IllegalStateException("WebDriver instance is not initialized.");
        }
		
		LoginPage LP = new LoginPage(driver);
		String USERNAME = PU.getDataFromProperties("username");
		String PASSWORD = PU.getDataFromProperties("password");
		LP.PerformLogin(USERNAME, PASSWORD);
		System.out.println("Login successful..");
	}
	
	@AfterMethod(alwaysRun = true)
	public void LogoutOperation() throws InterruptedException {
		
		 if (driver == null) {
	            throw new IllegalStateException("WebDriver instance is not initialized.");
	        }
		 
		HomePage  HP = new HomePage(driver);
		Thread.sleep(5000);
		HP.ClickonLogout();
		System.out.println("logout successful..");
	}
	
	@AfterClass(alwaysRun = true)
	public void TearDown() {
	    if (driver != null) {
	        driver.quit();
	    }
	    System.out.println("Browser closed successfully..");
	}

}
