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
	
	public static WebDriver driver;
	public static  PropertiesUtility PU = new PropertiesUtility();

	
	@BeforeClass(alwaysRun = true)
	public void BrowserSetup() throws Exception {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--headless");
		options.addArguments("--no-sandbox");
		options.addArguments("--disable-dev-shm-usage");
		options.addArguments("--remote-allow-origins=*");
		
		String URL = PU.getDataFromProperties("url");
		driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get(URL);
	}
	@BeforeMethod(alwaysRun = true)
	public void LoginOperation() throws Exception {
		
		LoginPage LP = new LoginPage(driver);
		String USERNAME = PU.getDataFromProperties("username");
		String PASSWORD = PU.getDataFromProperties("password");
		LP.PerformLogin(USERNAME, PASSWORD);
	}
	
	@AfterMethod(alwaysRun = true)
	public void LogoutOperation() throws InterruptedException {
		HomePage  HP = new HomePage(driver);
		Thread.sleep(5000);
		HP.ClickonLogout();
		System.out.println("logout successfully..");
	}
	
	@AfterClass(alwaysRun = true)
	public void TearDown() {
	    if (driver != null) {
	        driver.quit();
	    }
	    System.out.println("Browser closed successfully..");
	}

}
