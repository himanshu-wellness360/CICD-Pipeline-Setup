package objectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	@FindBy(xpath = "//span[starts-with(@class,'ng-tns-') and .='Dashboards'] ")
	private WebElement Dashboards;

	@FindBy(xpath = "//a[@ng-reflect-router-link='/dashboard/content']")
	private WebElement Content;

	@FindBy(xpath = "//a[@ng-reflect-router-link='/dashboard/campaign']")
	private WebElement Engagement1;

	@FindBy(xpath = "//span[starts-with(@class,'ng-tns-') and .='Audience']")
	private WebElement Audiance;

	@FindBy(xpath = "//span[.='Members']")
	private WebElement Members;

	@FindBy(xpath = "//span[.='Segments']")
	private WebElement Segments;

	@FindBy(xpath = "///span[.='Engagement']")
	private WebElement Engagement2;

	@FindBy(xpath = "//a[@ng-reflect-router-link='/engagement/campaigns/landing']")
	private WebElement Campaigns;

	@FindBy(xpath = "//a[@ng-reflect-router-link='/engagement/journey/landing']")
	private WebElement Journeys;

	@FindBy(xpath = "//i[@class='topbar-icon pi pi-refresh']")
	private WebElement RefreshBtn;

	@FindBy(xpath = "//a[@routerlink='/settings/settings-page']")
	private WebElement Settings;

	@FindBy(xpath = "//span[.='Logout']")
	private WebElement Logout;

	//Constructor
	public HomePage(WebDriver driver) {

		PageFactory.initElements(driver, this);
	}

	//Getters
	public WebElement getDashboards() {
		return Dashboards;
	}

	public WebElement getContent() {
		return Content;
	}

	public WebElement getEngagement1() {
		return Engagement1;
	}

	public WebElement getAudiance() {
		return Audiance;
	}

	public WebElement getMembers() {
		return Members;
	}

	public WebElement getSegments() {
		return Segments;
	}

	public WebElement getEngagement2() {
		return Engagement2;
	}

	public WebElement getCampaigns() {
		return Campaigns;
	}

	public WebElement getJourneys() {
		return Journeys;
	}

	public WebElement getRefreshBtn() {
		return RefreshBtn;
	}

	public WebElement getSettings() {
		return Settings;
	}

	public WebElement getLogout() {
		return Logout;
	}

	//Business Library
	public void ClickOnDashboards() {

		getDashboards().click();
	}


	public void ClickonContent() {

		getContent().click();    
	}
	
	public void ClickonEngagement1() {
		getEngagement1().click();
	}
	
	public void ClickonAudiance() {
		getAudiance().click();
	}
	
	public void ClickonMembers() {
		getMembers().click();
	}
	
	public void ClickonSegments() {
		getSegments().click();
	}
	
	public void ClickonEngagement2() {
		getEngagement2().click();
	}
	
	public void ClickonCampaigns() {
		getCampaigns().click();
	}
	
	public void ClickonJourneys() {
		getJourneys().click();
	}
	
	public void ClickonRefresh() {
		getRefreshBtn().click();
	}
	
	public void ClickonSettings() {
		getSettings().click();
	}
	
	public void ClickonLogout() {
		getLogout().click();
	}
}
