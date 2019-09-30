package Settings;

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

import io.appium.java_client.TouchAction;

public class C23605_VerifyMyAlertsViaSettings  extends GenericKeywords {

	ExtentReports extent;
	ExtentTest test;
	
	@BeforeTest
	public void setUp() throws InterruptedException, MessagingException, IOException{
		extent=ExtentManager.GetExtent();
		test=extent.createTest(this.getClass().getSimpleName());
		BaseClass iDriver = new BaseClass();
	    iDriver.myTestCaseName = this.getClass().getSimpleName();
		startAppium();
		executeMobileDriver();
		test.log(Status.INFO, " Q2 Mobile application launched");
		getElement(ObjectRepository.username_txt).sendKeys(username);
		getElement(ObjectRepository.password_txt).sendKeys(password);
		getElement(ObjectRepository.login_btn).click();
		test.log(Status.INFO, "Login button clicked after entering username and password");
		
//		try{
//			if(getElement(ObjectRepository.emailotp_btn).isDisplayed()){
//				getElement(ObjectRepository.emailotp_btn).click();
//				test.log(Status.INFO, "Send otp to email button clicked");
//				Thread.sleep(17000);
//				getElement(ObjectRepository.otp_txt).sendKeys(fetchOutlookOTP());
//				test.log(Status.INFO, "Secure Access code entered");
//
//				getElement(ObjectRepository.submit_btn).click();
//				test.log(Status.INFO, "Submit button clicked");
//				Thread.sleep(3000);
//				try{
//					if(getElement(ObjectRepository.rgstrdvc_btn).isDisplayed()){
//						getElement(ObjectRepository.rgstrdvc_btn).click();
//						test.log(Status.INFO, "Register device button available to be clicked");
//					}
//				}catch(Exception e1){
//					test.log(Status.INFO, "Register device button not available to be clicked");
//				}
//			}
//			}catch(Exception e){
//				test.log(Status.INFO, "Device already registered");
//			}
		
		
	}
	

	@Test
	public void C23605_VerifyMyAlertsViaSettings() throws InterruptedException
	{
		Thread.sleep(8000);	
		verifyElementPresent(ObjectRepository.home_ttl);
		test.log(Status.INFO, "Home link appearing");
	//Verify menu item option
		verifyElementPresent(ObjectRepository.menu_btn);
		test.log(Status.INFO, "Menu link appearing");
	
		getElement(ObjectRepository.menu_btn).click();
		test.log(Status.INFO, "Menu link clicked");
		Thread.sleep(4000);	
			
		getElement(ObjectRepository.settings_menu).click();
		test.log(Status.INFO, "Settings menu clicked");
		Thread.sleep(4000);	
		
		getElement(ObjectRepository.alrt_menu).click();
		test.log(Status.INFO, "Alert menu clicked");
		Thread.sleep(4000);
		
		verifyElementPresent(ObjectRepository.alrt_menu);
		test.log(Status.INFO, "Alerts page opened");
		
		verifyElementPresent(ObjectRepository.dtalrt_sctn);
		verifyElementPresent(ObjectRepository.acntalrt_sctn);
		verifyElementPresent(ObjectRepository.hstryalrt_sctn);
		verifyElementPresent(ObjectRepository.onlntrnsctnalrt_sctn);
		verifyElementPresent(ObjectRepository.scrtyalrt_sctn);
		test.log(Status.INFO, "Date,Account,History,Online Transaction and Security alert sections appearing on alert page");
		
		verifyElementPresent(ObjectRepository.alrttyp_dropdown);
		test.log(Status.INFO, "Alerts type dropdown appearing");
		
		
	}
	
	@AfterMethod
	public void afterMethod(ITestResult result) throws Throwable{
		if(result.getStatus()==ITestResult.FAILURE){
			test.log(Status.FAIL, "Test Failed - "+result.getThrowable());	
			GenericKeywords.takescreenshot(myTestCaseName,test);
		}else
		{
			test.log(Status.PASS, "Verify My Alerts Via Settings scenario working fine");
		}
	}
	
	@AfterTest
	public void tearDown(){
		driver.quit();
		stopAppium();
		extent.flush();
		
	}
}
