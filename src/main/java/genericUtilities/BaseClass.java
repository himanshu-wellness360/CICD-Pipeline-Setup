package genericUtilities;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import objectRepo.HomePage;
import objectRepo.LoginPage;

public class BaseClass {
	
	public static WebDriver driver = null;
	public static  PropertiesUtility PU = new PropertiesUtility();

	
	@BeforeClass(alwaysRun = true)
	public void BrowserSetup() throws Exception {
		
		String URL = PU.getDataFromProperties("url");
		driver = new ChromeDriver();
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
		
		driver.quit();
		System.out.println("Browser closed successfully..");
	}

}
