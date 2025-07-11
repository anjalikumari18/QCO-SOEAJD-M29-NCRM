package objectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LeadWithCampPage {
	WebDriver driver;
	public LeadWithCampPage(WebDriver driver) {
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "search-criteria")
	private WebElement searchCriteria;
	
	@FindBy(id = "search-input")
	private WebElement searchTF;

	public WebElement getSearchCriteria() {
		return searchCriteria;
	}

	public WebElement getSearchTF() {
		return searchTF;
	}
	
	

}
