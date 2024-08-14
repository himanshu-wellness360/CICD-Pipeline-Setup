package objectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	@FindBy(xpath = "//input[@placeholder='Username']")
	private WebElement username;
	
	@FindBy(xpath = "//input[@placeholder='Password']")
	private WebElement password;
	
	@FindBy(xpath = "//span[@class='p-button-label']")
	private WebElement signinbtn;
	
	//Constructor
	public LoginPage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
	}
	
	//Getters

	public WebElement getUsername() {
		return username;
	}

	public WebElement getPassword() {
		return password;
	}

	public WebElement getLoginbtn() {
		return signinbtn;
	}
	
	//Business Library
	public void PerformLogin(String username, String password) {
		
		getUsername().sendKeys(username);
		getPassword().sendKeys(password);
		getLoginbtn().click();
	}
}
