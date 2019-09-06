package CreditCards;

import java.io.IOException;
import java.util.ArrayList;

import javax.mail.MessagingException;

import org.openqa.selenium.JavascriptExecutor;
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

public class C23442_VerifyCreditCardInformation extends GenericKeywords {

	ExtentReports extent;
	ExtentTest test;
	/*
	 * Verify Credit Card Information
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
	public void C23442_VerifyCreditCardInformation() throws InterruptedException, MessagingException, IOException
	{
		
		if(continuetestcase==true)                                                                                                                                                                                                                                                                                                                                                                                                                                              
		{
			sheetName = "StopPayment";
			int totalRowCount = excl.getRowCount(sheetName);
			for(startIter=1;startIter<=totalRowCount;startIter++) //It is mandatory to have this for loop in every test case
			 {	
				if(this.getClass().getSimpleName().equals(excl.getCellData(sheetName, 0, startIter)))
				 {
					String acnt=excl.getCellData(sheetName, 1, startIter);				
					
					//Click Services option
					getElement(ObjectRepository.service_menu).click();
					test.log(Status.INFO, "Service menu clicked");
					Thread.sleep(3000);
					
					getElement(ObjectRepository.credt_crd).click();
					test.log(Status.INFO, "Credit card menu clicked");
					Thread.sleep(3000);
					
					
				//Verify Stop Payment page title
					verifyElementPresent(ObjectRepository.accsspnt_ttl);
					test.log(Status.INFO, "Select an account page opened");
					
					getElement("//label[@test-id='lblListItemDesc' and contains(text(),'"+acnt+"')]").click();
					test.log(Status.INFO, "Credit Card Account selected");
					Thread.sleep(3000);
					
					ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
				    driver.switchTo().window(tabs2.get(1));
				    test.log(Status.INFO, "Switched to newly opened PSCU registration tab");
				    Thread.sleep(3000);
				    
				    //verify registration page title
				    verifyElementPresent(ObjectRepository.addcrd_ttl);
					test.log(Status.INFO, "Add Card page opened");
					
					
				    //click cancel
					
					getElement(ObjectRepository.cncl_btn).click();
					test.log(Status.INFO, "Cancel button clicked");
					Thread.sleep(3000);
					getElement(ObjectRepository.yes_btn).click();
					Thread.sleep(3000);
					
				    //switch to Q2 tab again
				    driver.switchTo().window(tabs2.get(0));
				    test.log(Status.INFO, "Switched to Q2 application tab");
				    Thread.sleep(3000);
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
			test.log(Status.PASS, "Verify Credit Card Information scenario working fine");
		}
	}

	@AfterTest
	public void tearDown() {
		extent.flush();
		driver.quit();
	}

}
