package test;

import org.testng.annotations.Test;

import genericUtilities.BaseClass;
import objectRepo.HomePage;

public class Test2 extends BaseClass {
	
	@Test
	public void test2() {
		
		HomePage HP = new HomePage(driver);
		HP.ClickOnDashboards();
		HP.ClickonEngagement1();
		HP.ClickonRefresh();
		System.out.println("Test executed successfully..");
		
	}

}
