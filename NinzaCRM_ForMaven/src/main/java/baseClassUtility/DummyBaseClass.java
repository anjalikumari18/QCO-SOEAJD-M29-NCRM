package baseClassUtility;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import genericUtility.PropertyFileUtility;
import genericUtility.WebDriverUtility;
import objectRepo.HomePage;
import objectRepo.LoginPage;

public class DummyBaseClass {
	public WebDriverUtility wutil= new WebDriverUtility();
	//public PropertyFileUtility putil= new PropertyFileUtility();
	public WebDriver driver=null;
	public static WebDriver sDriver= null; //listeners
	//public HomePage hp= new HomePage(driver);
	@BeforeSuite
	public void configBS() {
	Reporter.log("Establish the DB Connectivity", true);	
	}
	
	@BeforeTest
	public void configBT() {
		Reporter.log("Pre-condition", true);	
	}
	
	@BeforeClass
	public void configBC() throws IOException {
		String BROWSER = "Chrome";
		String URL = "https://www.saucedemo.com/";
		//cross Browser Testing
				 
				if(BROWSER.equalsIgnoreCase("chrome")) {
					driver= new ChromeDriver();
				}else if(BROWSER.equalsIgnoreCase("firefox")) {
					driver= new FirefoxDriver();
				}else if(BROWSER.equalsIgnoreCase("edge")) {
					driver= new EdgeDriver();
				}else {
					driver= new ChromeDriver();
				}
			
				sDriver= driver;//listeners purpose
				driver.manage().window().maximize();
				wutil.waitForPageToLoad(driver);
				driver.get(URL);	
	}

	@BeforeMethod
	public void configBM() throws IOException {
		String UNAME = "standard_user";
		String PWD = "secret_sauce";
		driver.findElement(By.id("user-name")).sendKeys(UNAME);
		driver.findElement(By.id("password")).sendKeys(PWD);
		driver.findElement(By.id("login-button")).click();
		Reporter.log("Logged in Successfully", true);

	}
	
	@AfterSuite
	public void configAS() {
		Reporter.log("Close the DB Connectivity", true);
	}
	
	@AfterTest
	public void configAT() {
		Reporter.log("Post-condition", true);	
	}
	
	@AfterClass
	public void configAC() throws InterruptedException {
		Thread.sleep(5000);
		driver.quit();
		Reporter.log("Successfully closed the Browser", true);

	}

	@AfterMethod
	public void configAM() {
		 //log out
		driver.findElement(By.id("react-burger-menu-btn")).click();
		driver.findElement(By.linkText("Logout")).click();
		
			
	}

}
