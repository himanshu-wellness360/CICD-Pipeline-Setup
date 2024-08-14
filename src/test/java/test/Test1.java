package test;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import genericUtilities.BaseClass;
import objectRepo.HomePage;



public class Test1 extends BaseClass {
	@Test
	public void test1() {
		
		
		HomePage  HP = new HomePage(driver);
		
		HP.ClickonAudiance();
		HP.ClickonMembers();
		String ExpectedURL = "https://enpdemo.myhealthfeed.com/#/audience/members/landing";
		String CurrentURL = driver.getCurrentUrl();
		
		AssertJUnit.assertEquals(ExpectedURL, CurrentURL);
		System.out.println("test executed successfully..");
	}

}
