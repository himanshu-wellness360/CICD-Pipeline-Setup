package objectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MembersPage {

	@FindBy(xpath = "//div[@class='p-ripple p-element p-button-rounded helperBtns p-button p-togglebutton p-component p-button-icon-only']")
	private WebElement searchbtn;

	@FindBy(xpath = "//button[@class='p-element p-ripple helperBtns p-button-raised p-button-link p-button-rounded p-button-outlined p-button p-component p-button-icon-only']")
	private WebElement memebers_attribute;

	@FindBy(xpath = "//button[@label='Add New Member']")
	private WebElement add_new_memebrbtn;

	@FindBy(xpath = "//span[.='Upload New']")
	private WebElement upload_newbtn;

	@FindBy(xpath = "//input[@placeholder='John']")
	private WebElement firstname_textfield;

	@FindBy(xpath = "//input[@placeholder='Doe']")
	private WebElement lastname_textfield;

	@FindBy(xpath = "//input[@placeholder='johndoe@example.com']")
	private WebElement email_textfield;

	@FindBy(xpath = "//input[@placeholder='+15553334444']")
	private WebElement phone_numebr_textfield;

	@FindBy(xpath = "//input[@class='ng-tns-c79-90 p-inputtext p-component ng-star-inserted']")
	private WebElement dateofbirth;

	@FindBy(xpath = "//button[@ng-reflect-label='Add ']")
	private WebElement addbtn;

	@FindBy(xpath = "//button[@ng-reflect-label='Add All']")
	private WebElement add_allbtn;

	@FindBy(xpath = "//button[@label='Save']")
	private WebElement savebtn;

	@FindBy(xpath = "//button[@label='Cancel']")
	private WebElement cancelbtn;
	
	@FindBy(xpath = "//li[@ng-reflect-ng-class='[object Object]']/a/i[@class='topbar-icon pi pi-power-off']")
	private WebElement Logout;

	//Constructor
	public MembersPage(WebDriver driver) {

		PageFactory.initElements(driver, this);
	}

	//Getters
	public WebElement getSearchbtn() {
		return searchbtn;
	}

	public WebElement getMemebers_attribute() {
		return memebers_attribute;
	}

	public WebElement getAdd_new_memebrbtn() {
		return add_new_memebrbtn;
	}

	public WebElement getUpload_newbtn() {
		return upload_newbtn;
	}

	public WebElement getFirstname_textfield() {
		return firstname_textfield;
	}

	public WebElement getLastname_textfield() {
		return lastname_textfield;
	}

	public WebElement getEmail_textfield() {
		return email_textfield;
	}

	public WebElement getPhone_numebr_textfield() {
		return phone_numebr_textfield;
	}

	public WebElement getDateofbirth() {
		return dateofbirth;
	}

	public WebElement getAddbtn() {
		return addbtn;
	}

	public WebElement getAdd_allbtn() {
		return add_allbtn;
	}

	public WebElement getSavebtn() {
		return savebtn;
	}

	public WebElement getCancelbtn() {
		return cancelbtn;
	}
	
	public WebElement getLogout() {
		return Logout;
	}

	//Business Library
	public void Clickon_Search() {

		getSearchbtn().click();

	}

	public void Clickon_Memebr_Attributes() {

		getMemebers_attribute().click();

	}

	public void Clickon_Add_New_Member() {

		getAdd_new_memebrbtn().click();

	}

	public void Clickon_Upload_New() {

	}

	public void Enter_FirstName(String firstname) {

		getFirstname_textfield().sendKeys(firstname);

	}

	public void Enter_LastNmame(String lastname) {

		getLastname_textfield().sendKeys(lastname);

	}

	public void Enter_Email(String email) {

		getEmail_textfield().sendKeys(email);

	}

	public void Enter_Phone_Number(String number) {

		getPhone_numebr_textfield().sendKeys(number);

	}

	public void EnterDOB() {

		getDateofbirth().click();

	}

	public void Clickon_Add() {

		getAddbtn().click();
	}

	public void Clickon_Add_All() {

		getAdd_allbtn().click();

	}

	public void Clickon_Save() {

		getSavebtn().click();

	}

	public void Clickon_Cancel() {

		getCancelbtn().click();
	}
	
	public void Clickon_Logout() {
		
		getLogout().click();
	}
	

}
