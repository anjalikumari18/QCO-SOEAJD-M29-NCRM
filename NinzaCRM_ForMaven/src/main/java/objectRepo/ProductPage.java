package objectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {
	WebDriver driver;
	
	public ProductPage(WebDriver driver) {
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[text()='Add Product']")
	private WebElement createProdBtn;

	@FindBy(xpath = "//div[contains(text(), 'Product')]")
	private WebElement productSuccessMsg;
	
	
	public WebElement getProductSuccessMsg() {
		return productSuccessMsg;
	}


	public WebElement getCreateProdBtn() {
		return createProdBtn;
	}
	

}
