package maven;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class CreateCampaignTest {
	@Test(groups = "SmokeTest")
	public void createCampTest() {
		Reporter.log("Campaign Created Successfully", true);
		WebDriver driver= new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		//Reading the data from CMD
//		String URL = System.getProperty("Url");
//		String UNAME= System.getProperty("Username");
//		String PWD= System.getProperty("Password");
//		driver.get(URL);
//		System.out.println("URL is :"+URL);
//		System.out.println("Username is :"+UNAME);
//		System.out.println("Password is :"+PWD);
		
	}
	@Test(groups = "RegressionTest")
	public void createCampWithDateTest() {
		Reporter.log("Campaign with Date Created Successfully", true);
	}

}
