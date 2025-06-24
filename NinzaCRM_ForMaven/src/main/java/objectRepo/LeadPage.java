package objectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtility.WebDriverUtility;

public class LeadPage {
	WebDriver driver;
	public LeadPage(WebDriver driver) {
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[text()='Create Lead']")
	private WebElement createLeadBtn;

	public WebElement getCreateLeadBtn() {
		return createLeadBtn;
	}
	
	
	@FindBy(xpath = "//div[contains(text(), 'Lead ')]")
	private WebElement leadSuccessMsg;
	public WebElement getLeadSuccessMsg() {
		return leadSuccessMsg;
	}
	

}
