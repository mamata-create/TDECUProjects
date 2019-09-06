package Settings;

import java.io.IOException;

import javax.mail.MessagingException;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
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

public class C23465_VerifyMyAccountsVisibility extends GenericKeywords {

	ExtentReports extent;
	ExtentTest test;
	/*
	 * Verify My Accounts Visibility
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
	public void C23465_VerifyMyAccountsVisibility() throws InterruptedException, MessagingException, IOException
	{
		
		if(continuetestcase==true)
		{
			sheetName = "Data";
			int totalRowCount = excl.getRowCount(sheetName);
			for(startIter=1;startIter<=totalRowCount;startIter++) //It is mandatory to have this for loop in every test case
			 {	
				if(this.getClass().getSimpleName().equals(excl.getCellData("Data", 0, startIter)))
				 {
					String acnt=excl.getCellData(sheetName, 1, startIter);
					
					getElement(ObjectRepository.stng_menu).click();
					test.log(Status.INFO, "Settings menu clicked");
					
					getElement(ObjectRepository.acntprfrnc_menu).click();
					test.log(Status.INFO, "Account preferences menu clicked");
					Thread.sleep(3000);
					
					verifyElementPresent(ObjectRepository.prfrnc_ttl);
					test.log(Status.INFO, "Account preferences page opened");
					
					//scrollToElement("//span[@test-id='lblAccountPreferencesAccountNumber' and contains(text(),'"+acnt+"')]");
					Thread.sleep(2000);
					getElement("//span[@test-id='lblAccountPreferencesAccountNumber' and contains(text(),'"+acnt+"')]").click();
					test.log(Status.INFO, "Account number row clicked");
					Thread.sleep(3000);
					
					getElement(ObjectRepository.hidden_lnk).click();
					test.log(Status.INFO, "Hidden account link clicked");
					Thread.sleep(3000);
					
					getElement(ObjectRepository.hide_btn).click();
					test.log(Status.INFO, "HIde confirmation button clicked");
					Thread.sleep(3000);
					
					getElement(ObjectRepository.home_menu).click();
					test.log(Status.INFO, "Home menu item clicked");
					Thread.sleep(3000);
					
					verifyElementNotPresent("//span[@class='account-nbr' and contains(text(),'"+acnt+"')]");
					
					getElement(ObjectRepository.stng_menu).click();
					test.log(Status.INFO, "Settings menu clicked");
					
					getElement(ObjectRepository.acntprfrnc_menu).click();
					test.log(Status.INFO, "Account preferences menu clicked");
					Thread.sleep(3000);
					
					verifyElementPresent(ObjectRepository.prfrnc_ttl);
					test.log(Status.INFO, "Account preferences page opened");
					
					scrollToElement("//span[@test-id='lblAccountPreferencesAccountNumber' and contains(text(),'"+acnt+"')]");
					getElement("//span[@test-id='lblAccountPreferencesAccountNumber' and contains(text(),'"+acnt+"')]").click();
					test.log(Status.INFO, "Account number row clicked");
					
					getElement(ObjectRepository.hidden_lnk).click();
					test.log(Status.INFO, "Hidden account link clicked");
					scrollToElement(ObjectRepository.home_menu);
					
					
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
			test.log(Status.PASS, "Verify My Accounts Visibility scenario working fine");
		}
	}

	@AfterTest
	public void tearDown() {
		extent.flush();
		driver.quit();
	}

}
