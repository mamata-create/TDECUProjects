package cPFM;

import java.io.IOException;

import javax.mail.MessagingException;

import org.openqa.selenium.Keys;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.FrameworkComponents.BaseClass;
import com.FrameworkComponents.ExtentManager;
import com.FrameworkComponents.GenericKeywords;
import com.FrameworkComponents.ObjectRepository;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class C25207_VerifyTrendTransactionDetails extends GenericKeywords {

	ExtentReports extent;
	ExtentTest test;
	/*
	 * Verify trend transaction details
	 * 
	 */

	@BeforeTest
	public void setUp() throws InterruptedException, MessagingException, IOException {
		extent = ExtentManager.GetExtent();
		test = extent.createTest(this.getClass().getSimpleName());
		BaseClass iDriver = new BaseClass();
		iDriver.myTestCaseName = this.getClass().getSimpleName();
		executeDriverScript();
		test.log(Status.INFO, "Application url navigated");
		//enter loginId
				getElement(ObjectRepository.loginid_txt).sendKeys(username);
				test.log(Status.INFO, "Login ID entered");
				
				//enter password
				getElement(ObjectRepository.password_txt).sendKeys(password);
				test.log(Status.INFO, "Password entered");
				
				//click login button
				getElement(ObjectRepository.login_btn).click();
				test.log(Status.INFO, "Login button clicked");
				
				
				//Verify log off link available after login
				verifyElementPresent(ObjectRepository.logoff_lnk);
				test.log(Status.INFO, "User successfully logged in as Logoff link available");
		
	}

	@Test
	public void C25207_VerifyTrendTransactionDetails() throws InterruptedException, MessagingException, IOException
	{
		if(continuetestcase==true)
		{
			sheetName = "cPFM";
			int totalRowCount = excl.getRowCount(sheetName);
			for(startIter=1;startIter<=totalRowCount;startIter++) //It is mandatory to have this for loop in every test case
			 {	
				if(this.getClass().getSimpleName().equals(excl.getCellData(sheetName, 0, startIter)))
				 {
					String acnt=excl.getCellData(sheetName, 1, startIter);
					
	
				Thread.sleep(4000);
				verifyElementPresent(ObjectRepository.trends_tab);
				test.log(Status.INFO, "Trends tab appeared");
				
			getElement(ObjectRepository.trends_tab).click();
			test.log(Status.INFO, "Trends tab clicked");
			Thread.sleep(5000);

			driver.switchTo().frame(getElement(ObjectRepository.asst_frame));
			
			getElement(ObjectRepository.trndstablevw_btn).click();
			test.log(Status.INFO, "Trend table view tab clicked");
			Thread.sleep(2000);
			
			getElement(ObjectRepository.trndctgry_row).click();
			test.log(Status.INFO, "Trend category row clicked");
			Thread.sleep(2000);
			
			getElement(ObjectRepository.trndtrnsctn_row).click();
			test.log(Status.INFO, "Trend transaction row clicked");
			Thread.sleep(2000);
			
			verifyElementPresent(ObjectRepository.payee_dtls);
			test.log(Status.INFO, "Payee details appeared");
			
			verifyElementPresent(ObjectRepository.date_dtls);
			test.log(Status.INFO, "Date details appeared");
			
			verifyElementPresent(ObjectRepository.ctgry_dtls);
			test.log(Status.INFO, "Category details appeared");
			
			verifyElementPresent(ObjectRepository.tags_dtls);
			test.log(Status.INFO, "Tags detail appeared");
			
			verifyElementPresent(ObjectRepository.memo_dtls);
			test.log(Status.INFO, "Memo details appeared");
				 }
				
			 }
		}
				
	}

	@AfterMethod
	public void afterMethod(ITestResult result) throws Throwable {
		if (result.getStatus() == ITestResult.FAILURE) {
			test.log(Status.FAIL, "Test Failed-" + result.getThrowable());

			takescreenshot(this.getClass().getSimpleName(), test);
		} else {
			test.log(Status.PASS, "Verify trend transaction details scenario working fine");
		}
	}

	@AfterTest
	public void tearDown() {
		extent.flush();
		driver.quit();
	}

}
