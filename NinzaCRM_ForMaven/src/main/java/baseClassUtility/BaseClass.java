package baseClassUtility;

import java.io.IOException;

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
import org.testng.annotations.Parameters;

import genericUtility.ExcelFileUtility;
import genericUtility.JavaUtility;
import genericUtility.PropertyFileUtility;
import genericUtility.WebDriverUtility;
import objectRepo.HomePage;
import objectRepo.LoginPage;

public class BaseClass {
	public WebDriverUtility wutil= new WebDriverUtility();
	public PropertyFileUtility putil= new PropertyFileUtility();
	public WebDriver driver=null;
	public static WebDriver sDriver= null;// for listeners
	//public HomePage hp= new HomePage(driver);
	@BeforeSuite(groups = {"SmokeTest", "RegressionTest"})
	public void configBS() {
	Reporter.log("Establish the DB Connectivity", true);	
	}
	
	@BeforeTest(groups = {"SmokeTest", "RegressionTest"})
	public void configBT() {
		Reporter.log("Pre-condition", true);	
	}
	
	//@Parameters("Browser")// For cross Browser Parallel execution
	@BeforeClass(groups = {"SmokeTest", "RegressionTest"})
	public void configBC(/*String Brow*/) throws IOException {
		String BROWSER = putil.toReadDataFromProperties("Browser");
		
		//String BROWSER= Brow;//CBT
		
		String URL = putil.toReadDataFromProperties("Url");
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
				
				sDriver= driver ; //listeners implementation purpose
			
				driver.manage().window().maximize();
				wutil.waitForPageToLoad(driver);
				driver.get(URL);
				Reporter.log("Successfully Opened the Browser and Navigated to URL", true);
	}

	@BeforeMethod(groups = {"SmokeTest", "RegressionTest"})
	public void configBM() throws IOException {
		String UNAME = putil.toReadDataFromProperties("Username");
		String PWD = putil.toReadDataFromProperties("Password");
		LoginPage lp= new LoginPage(driver);
		lp.toLoginToNinzaCRM(UNAME, PWD);
		Reporter.log("Logged in Successfully", true);

	}
	
	@AfterSuite(groups = {"SmokeTest", "RegressionTest"})
	public void configAS() {
		Reporter.log("Close the DB Connectivity", true);
	}
	
	@AfterTest(groups = {"SmokeTest", "RegressionTest"})
	public void configAT() {
		Reporter.log("Post-condition", true);	
	}
	
	@AfterClass(groups = {"SmokeTest", "RegressionTest"})
	public void configAC() throws InterruptedException {
		//Thread.sleep(5000);
		Reporter.log("Successfully closed the Browser", true);
		driver.quit();
		

	}

	@AfterMethod(groups = {"SmokeTest", "RegressionTest"})
	public void configAM() throws InterruptedException {
		Thread.sleep(2000);
		 //log out
		HomePage hp= new HomePage(driver);
		 hp.logOutOfNinzaCRM();
		 Reporter.log("Successfully Logged out", true);
	}
}
