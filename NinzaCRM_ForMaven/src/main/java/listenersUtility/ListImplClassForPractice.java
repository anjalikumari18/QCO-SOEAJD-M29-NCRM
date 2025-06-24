package listenersUtility;

import java.io.IOException;

import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import baseClassUtility.BaseClass;
import baseClassUtility.DummyBaseClass;
import genericUtility.WebDriverUtility;

public class ListImplClassForPractice implements ISuiteListener, ITestListener {
WebDriverUtility wutil= new WebDriverUtility();
	@Override
	public void onTestStart(ITestResult result) {
		Reporter.log("TC Execution Started", true);	
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		Reporter.log("TC Execution- PASS", true);
	}

	@Override
	public void onTestFailure(ITestResult result) {
		Reporter.log("TC Execution- FAIL", true);
		try {
			wutil.takeScreenshotOfWebPage(DummyBaseClass.sDriver, "sample");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		Reporter.log("TC Execution- SKIP", true);
	}

	@Override
	public void onStart(ISuite suite) {
		Reporter.log("Report configuration", true);
	}

	@Override
	public void onFinish(ISuite suite) {
		Reporter.log("Report back up", true);
	}
	
}
