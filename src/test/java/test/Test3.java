package test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
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
		System.out.println(FIRSTNAME);
		System.out.println(LASTNAME);
		System.out.println(EMAIL);
		System.out.println(PHONENUM);
		
		System.out.println("member created successfully..");
		/* MP.Clickon_Search();
		WebElement searchbox = driver.findElement(By.xpath("//input[@placeholder='Search']"));
		searchbox.sendKeys(FIRSTNAME, Keys.ENTER);
		//MP.Clickon_Search();
		String Actualname = driver.findElement(By.xpath("//div[@class='p-card-content']/app-members-table/p-toast/following-sibling::p-table/div/div[2]/table/thead/following-sibling::tbody/tr/td[2]")).getText();
		Assert.assertEquals(FIRSTNAME, Actualname);
		*/
		
		
		
		 // Wait for the table to be updated with the new member
       // WebDriverWait wait = new WebDriverWait(driver, 10);
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("membersTable")));
		
		/*driver.findElement(By.xpath("//div[@role='button']")).click();
		driver.findElement(By.xpath("//li[@role='option']/span[.='500']")).click();

        // Locate the table containing members
        WebElement membersTable = driver.findElement(By.xpath("//table[@role='table']"));
        List<WebElement> rows = membersTable.findElements(By.tagName("tr"));

        boolean memberFound = false;
        
        System.out.println("Total rows in the table: " + rows.size());


        // Loop through the rows of the table to find the newly created member
        for (WebElement row : rows) {
            if (row.getText().contains(FIRSTNAME) && row.getText().contains(LASTNAME)) {
                memberFound = true;
                break;
            }
        }

        // Assert that the new member exists in the table
       Assert.assertEquals("New member was not found in the table", memberFound);

*/
		
		List<WebElement> allRows = new ArrayList<>();
        boolean memberFound = false;

        // Loop through all pages if pagination exists
        boolean morePages = true;
        while (morePages) {
            // Collect rows from the current page
            WebElement membersTable = driver.findElement(By.xpath("//table[@role='table']"));
            List<WebElement> rows = membersTable.findElements(By.tagName("tr"));

            // Check each row for the newly created member
            for (WebElement row : rows) {
                if (row.getText().contains(FIRSTNAME) && row.getText().contains(LASTNAME)) {
                    memberFound = true;
                    break;
                }
            }

            if (memberFound) {
                break;  // Stop if the member is found
            }

            // Check if the "Next" button for pagination is enabled
            //WebElement nextButton = driver.findElement(By.xpath("//span[@class='p-paginator-icon pi pi-angle-right']"));
            
            WebElement nextButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@class='p-paginator-icon pi pi-angle-right']")));

            try {
                // Scroll to the "Next" button to ensure it is in view
                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", nextButton);

                // Try clicking the "Next" button
                nextButton.click();

                // Wait for the next page to load
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@role='table']")));

            } catch (org.openqa.selenium.ElementClickInterceptedException e) {
                // If click is intercepted, try forcing the click with JavaScript
                ((JavascriptExecutor) driver).executeScript("arguments[0].click();", nextButton);
            }
        }

        // Assert that the new member exists
        assert memberFound : "New member was not found in the table";

        System.out.println("New member '" + FIRSTNAME + "' was successfully found in the table!");

	}

}
