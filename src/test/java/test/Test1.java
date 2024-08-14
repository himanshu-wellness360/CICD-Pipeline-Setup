package test;

import org.testng.Assert;

import genericUtilities.BaseClass;


public class Test1 extends BaseClass {
	
	public void test1() {
		
		HP.ClickonAudiance();
		HP.ClickonMembers();
		String ExpectedURL = "https://enpdemo.myhealthfeed.com/#/audience/members/landing";
		String CurrentURL = driver.getCurrentUrl();
		
		Assert.assertEquals(ExpectedURL, CurrentURL);
	}

}
