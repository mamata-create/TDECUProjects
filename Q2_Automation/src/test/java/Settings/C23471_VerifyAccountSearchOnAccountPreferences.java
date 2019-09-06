package Settings;

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

public class C23471_VerifyAccountSearchOnAccountPreferences extends GenericKeywords {

	ExtentReports extent;
	ExtentTest test;
	/*
	 * Verify Account Search on Account Preferences
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
	public void C23471_VerifyAccountSearchOnAccountPreferences() throws InterruptedException, MessagingException, IOException
	{
		
		if(continuetestcase==true)
		{
			sheetName = "Accounts";
			int totalRowCount = excl.getRowCount(sheetName);
			for(startIter=1;startIter<=totalRowCount;startIter++) //It is mandatory to have this for loop in every test case
			 {	
				if(this.getClass().getSimpleName().equals(excl.getCellData(sheetName, 0, startIter)))
				 {
					String acnt=excl.getCellData(sheetName, 1, startIter);
					String acntnickname=excl.getCellData(sheetName, 2, startIter);
					
					getElement(ObjectRepository.stng_menu).click();
					test.log(Status.INFO, "Settings menu clicked");
					
					getElement(ObjectRepository.acntprfrnc_menu).click();
					test.log(Status.INFO, "Account preferences menu clicked");
					Thread.sleep(5000);
					
					verifyElementPresent(ObjectRepository.prfrnc_ttl);
					test.log(Status.INFO, "Account preferences page opened");
				//search account by account number	
					getElement(ObjectRepository.acntsrch_txt).sendKeys(acnt);
					test.log(Status.INFO, "Account Number entered for search");
					Thread.sleep(3000);
					
					verifyElementPresent("//span[@test-id='lblAccountPreferencesAccountNumber' and contains(text(),'"+acnt+"')]");
					test.log(Status.INFO, "Searched Account number appearing correctly");
					
					getElement(ObjectRepository.acntsrch_clr).click();
					test.log(Status.INFO, "Account Search clear icon clicked");
					Thread.sleep(3000);
			//search account by account nickname	
					getElement(ObjectRepository.acntsrch_txt).sendKeys(acntnickname);
					test.log(Status.INFO, "Account nickname entered for search");
					Thread.sleep(3000);
					
					String text=getElement("//div[@test-id='lblAccountTitle']").getText();
					Assert.assertTrue(text.contains(acntnickname));
					test.log(Status.INFO, "Searched Account based on nickname appearing correctly");
					
					getElement(ObjectRepository.acntsrch_clr).click();
					test.log(Status.INFO, "Account Search clear icon clicked");
					Thread.sleep(3000);
			//search account by invalid criteria			
					getElement(ObjectRepository.acntsrch_txt).sendKeys("asder123!@#");
					test.log(Status.INFO, "Account invalid search criteria entered");
					Thread.sleep(3000);
					
					verifyElementPresent(ObjectRepository.acntsrch_errmsg);
					test.log(Status.INFO, "No Accounts message appearing due to invalid search criteria");
	
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
			test.log(Status.PASS, "Verify Account Search on Account Preferences scenario working fine");
		}
	}

	@AfterTest
	public void tearDown() {
		extent.flush();
		driver.quit();
	}

}
