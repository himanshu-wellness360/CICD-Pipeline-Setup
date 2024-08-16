package test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import genericUtilities.BaseClass;
import genericUtilities.JavaUtility;
import objectRepo.HomePage;
import objectRepo.MembersPage;

public class Test3 extends BaseClass{
	
	@Test
	public void test3() throws Exception {
		
		JavaUtility JU = new JavaUtility();
		String FIRSTNAME = JU.generateFakeFirstName();
		String LASTNAME  = JU.generateFakeLastName();
		String EMAIL     = JU.generateFakeEmail(FIRSTNAME, LASTNAME);
		String PHONENUM  = JU.generateFakePhoneNumber();
		HomePage HP = new HomePage(driver);
		MembersPage MP = new MembersPage(driver);
		HP.ClickonAudiance();
		HP.ClickonMembers();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".p-datatable-loading-overlay")));
		MP.Clickon_Add_New_Member();
		MP.Enter_FirstName(FIRSTNAME);
		MP.Enter_LastNmame(LASTNAME);
		MP.Enter_Email(EMAIL);
		MP.Enter_Phone_Number(PHONENUM);
		MP.Clickon_Save();
		/*System.out.println(FIRSTNAME);
		System.out.println(LASTNAME);
		System.out.println(EMAIL);
		System.out.println(PHONENUM);
		*/
		System.out.println("member created successfully..");
		
	}

}
