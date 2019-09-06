package StopPayment;

import java.io.IOException;

import javax.mail.MessagingException;

import org.testng.Assert;
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

public class C23421_VerifyStopPaymentScreen  extends GenericKeywords {

	ExtentReports extent;
	ExtentTest test;
	/*
	 * Verify Stop Payment Screen
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
				
				//click login button
				/*getElement(ObjectRepository.otpemail_btn).click();
				test.log(Status.INFO, "Send OTP to email button clicked");
				Thread.sleep(15000);
				
				getElement(ObjectRepository.otp_txt).sendKeys(fetchOutlookOTP());
				test.log(Status.INFO, "Login ID entered");
				
				
				getElement(ObjectRepository.submit_btn).click();
				test.log(Status.INFO, "Send OTP to email button clicked");
				Thread.sleep(7000);
				
				try{
					if(getElement(ObjectRepository.register_btn).isDisplayed()){
						getElement(ObjectRepository.register_btn).click();
						test.log(Status.INFO, "Register device button clicked");
						Thread.sleep(7000);
					}
					}catch(Exception e){
						test.log(Status.INFO, "Register device button not available to be clicked");
					}*/
				
				
				//Verify log off link available after login
				verifyElementPresent(ObjectRepository.logoff_lnk);
				test.log(Status.INFO, "User successfully logged in as Logoff link available");
		
	}

	@Test
	public void C23421_VerifyStopPaymentScreen() throws InterruptedException, MessagingException, IOException
	{
		
		if(continuetestcase==true)
		{
			sheetName = "StopPayment";
			int totalRowCount = excl.getRowCount(sheetName);
			for(startIter=1;startIter<=totalRowCount;startIter++) //It is mandatory to have this for loop in every test case
			 {	
				if(this.getClass().getSimpleName().equals(excl.getCellData(sheetName, 0, startIter)))
				 {
					String zip=excl.getCellData(sheetName, 1, startIter);				
					
					//Click Services option
					getElement(ObjectRepository.service_menu).click();
					test.log(Status.INFO, "Service menu clicked");
					Thread.sleep(3000);
					
					getElement(ObjectRepository.stppaymnt_menu).click();
					test.log(Status.INFO, "Stop Payment menu clicked");
					Thread.sleep(3000);
				//Verify Stop Payment page title
					verifyElementPresent(ObjectRepository.stppaymnt_ttl);
					test.log(Status.INFO, "Stop Payment page opened and title available");
					
					String sendbtn_class=getElement(ObjectRepository.stppaymnt_sndrqst_btn).getAttribute("class");
					Assert.assertTrue(sendbtn_class.contains("disabled"));
					
					getElement(ObjectRepository.stppaymnt_bckbtn).click();
					test.log(Status.INFO, "Back button clicked");
					Thread.sleep(3000);
					
					verifyElementPresent(ObjectRepository.acnt_ttl);
					test.log(Status.INFO, "Accounts page opened and title available");
					
					//Click Services option
					getElement(ObjectRepository.service_menu).click();
					test.log(Status.INFO, "Service menu clicked");
					Thread.sleep(3000);
					
					getElement(ObjectRepository.stppaymnt_menu).click();
					test.log(Status.INFO, "Stop Payment menu clicked");
					Thread.sleep(3000);
					
					getElement(ObjectRepository.stppaymnt_snglchk).click();
					test.log(Status.INFO, "Single Check link clicked");
					Thread.sleep(3000);
					
					getElement(ObjectRepository.stppaymnt_bckbtn).click();
					test.log(Status.INFO, "Back button clicked");
					Thread.sleep(3000);
					
					verifyElementPresent(ObjectRepository.acnt_ttl);
					test.log(Status.INFO, "Accounts page opened and title available");
					
					//Click Services option
					getElement(ObjectRepository.service_menu).click();
					test.log(Status.INFO, "Service menu clicked");
					Thread.sleep(3000);
					
					getElement(ObjectRepository.stppaymnt_menu).click();
					test.log(Status.INFO, "Stop Payment menu clicked");
					Thread.sleep(3000);
					
					getElement(ObjectRepository.stppaymnt_mltchk).click();
					test.log(Status.INFO, "Single Check link clicked");
					Thread.sleep(3000);
					
					getElement(ObjectRepository.stppaymnt_bckbtn).click();
					test.log(Status.INFO, "Back button clicked");
					Thread.sleep(3000);
					
					verifyElementPresent(ObjectRepository.acnt_ttl);
					test.log(Status.INFO, "Accounts page opened and title available");
					
					
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
			test.log(Status.PASS, "Verify Stop payments screen scenario working fine");
		}
	}

	@AfterTest
	public void tearDown() {
		extent.flush();
		driver.quit();
	}

}
