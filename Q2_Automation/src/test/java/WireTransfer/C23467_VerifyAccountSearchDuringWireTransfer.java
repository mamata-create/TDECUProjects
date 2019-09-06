package WireTransfer;

import java.io.IOException;

import javax.mail.MessagingException;

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

public class C23467_VerifyAccountSearchDuringWireTransfer extends GenericKeywords {

	ExtentReports extent;
	ExtentTest test;
	/*
	 * Verify Account Search During Wire Transfer
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
			/*	getElement(ObjectRepository.otpemail_btn).click();
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
	public void C23467_VerifyAccountSearchDuringWireTransfer() throws InterruptedException, MessagingException, IOException
	{
		
		if(continuetestcase==true)
		{
			sheetName = "WireTransfer";
			int totalRowCount = excl.getRowCount(sheetName);
			for(startIter=1;startIter<=totalRowCount;startIter++) //It is mandatory to have this for loop in every test case
			 {	
				if(this.getClass().getSimpleName().equals(excl.getCellData(sheetName, 0, startIter)))
				 {
					String rcpnt=excl.getCellData(sheetName, 8, startIter);
					String message=excl.getCellData(sheetName, 9, startIter);
					String acntnumber=excl.getCellData(sheetName, 1, startIter);
					String amnt=randomAmount();
					
					//Click Services option
					getElement(ObjectRepository.service_menu).click();
					test.log(Status.INFO, "Service menu clicked");
					
					getElement(ObjectRepository.wiretrnsfr_menu).click();
					test.log(Status.INFO, "Wire Transfer menu clicked");
					Thread.sleep(3000);
				//Verify Wire Transfer page title
					verifyElementPresent(ObjectRepository.wiretrnsfr_ttl);
					test.log(Status.INFO, "Wire Transfer page opened and title available");
					
					getElement(ObjectRepository.locsrch_txt).sendKeys(rcpnt);
					test.log(Status.INFO, "Recipient entered for searching");
					Thread.sleep(3000);
					
					getElement(ObjectRepository.wiretrnsfr_rcpchk).click();
					test.log(Status.INFO, "Checkbox against recipient clicked");
					Thread.sleep(2000);
					
					getElement(ObjectRepository.amnt_txt).sendKeys(amnt);
					test.log(Status.INFO, "Amount entered for wire transfer");
					
					getElement(ObjectRepository.wiretrnsfr_msg).sendKeys(message);
					test.log(Status.INFO, "Message to beneficiary entered for wire transfer");
					
					getElement(ObjectRepository.wiretrnsfr_nxtbtn).click();
					test.log(Status.INFO, "Next button clicked");
					Thread.sleep(4000);
					
					getElement(ObjectRepository.locsrch_txt).sendKeys("XYZ@#$");
					test.log(Status.INFO, "Invalid account number entered for searching");
					Thread.sleep(3000);
					
					verifyElementPresent(ObjectRepository.noacnt_msg);
					test.log(Status.INFO, "No Accounts message appearing");
					Thread.sleep(2000);
					
					getElement(ObjectRepository.locsrch_txt).clear();
					getElement(ObjectRepository.locsrch_txt).sendKeys(acntnumber);
					test.log(Status.INFO, "Valid account number entered for searching");
					Thread.sleep(3000);
					
					verifyElementPresent("//td[contains(text(),'"+acntnumber+"')]");
					test.log(Status.INFO, "Account Number Searched correctly");
					
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
			test.log(Status.PASS, "Verify Account Search During Wire Transfer scenario working fine");
		}
	}

	@AfterTest
	public void tearDown() {
		extent.flush();
		driver.quit();
	}

}
