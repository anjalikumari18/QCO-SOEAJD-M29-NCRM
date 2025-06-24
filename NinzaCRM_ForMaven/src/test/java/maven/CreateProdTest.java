package maven;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class CreateProdTest {
	@Test(groups = "SmokeTest")
	public void createProductTest() {
		Reporter.log("Product Created Successfully", true);
	}

}
