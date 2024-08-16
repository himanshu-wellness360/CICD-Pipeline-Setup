package test;

import java.time.Duration;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import genericUtilities.BaseClass;
import objectRepo.HomePage;

public class Test2 extends BaseClass {
	
	@Test
	public void test2() {
		
		HomePage HP = new HomePage(driver);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		HP.ClickOnDashboards();
		HP.ClickonEngagement1();
		HP.ClickonRefresh();
		System.out.println("Test executed successfully..");
		
	}

}
