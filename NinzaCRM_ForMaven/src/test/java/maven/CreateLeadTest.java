package maven;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class CreateLeadTest {
	@Test(groups = "RegressionTest")
	public void createLeadWithCampTest() {
		Reporter.log("Lead With Campaign Created Successfully", true);
	}
}
