package Alerts;

import java.io.IOException;

import javax.mail.MessagingException;

import org.openqa.selenium.By;
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

import io.github.sukgu.Shadow;

public class C23478_VerifySecurityAlertSetupByPhoneNumber  extends GenericKeywords {

	ExtentReports extent;
	ExtentTest test;
	/*
	 * Verify security alert setup by phone number
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
	public void C23478_VerifySecurityAlertSetupByPhoneNumber() throws InterruptedException, MessagingException, IOException
	{

		if(continuetestcase==true)
		{
			
				//Click Settings Menu
					getElement(ObjectRepository.stng_menu).click();
					test.log(Status.INFO, "Settings menu clicked");
					Thread.sleep(3000);
					
					getElement(ObjectRepository.alrt_menu).click();
					test.log(Status.INFO, "Alerts menu clicked");
					Thread.sleep(3000);
				//Verify alert page title
					verifyElementPresent(ObjectRepository.alrt_ttl);
					test.log(Status.INFO, "Alerts page opened and title available");
					
					getElement(ObjectRepository.edtscrtyPrfrnc_lnk).click();
					test.log(Status.INFO, "Edit Delivery preference link  clicked");
					Thread.sleep(3000);
					
					verifyElementPresent(ObjectRepository.edtscrtyPrfrnc_ttl);
					test.log(Status.INFO, "Delivery preference page opened and title available");
			
//					getElement(ObjectRepository.cancl_btn).click();
//					test.log(Status.INFO, "Cancel button clicked");
//					Thread.sleep(3000);
					
					Assert.assertTrue(getShadowElement(ObjectRepository.phonecntry_drop).getAttribute("value").contains("United States"));	
					test.log(Status.INFO, "Default value in phone country dropdown is 'United States'");
					
					getShadowElement(ObjectRepository.phonearea_code).sendKeys("a1");
					test.log(Status.INFO, "Invalid Phone area code entered");
					
					getShadowElement(ObjectRepository.phonenumber).sendKeys("5607124532");
					test.log(Status.INFO, "Invalid Phone area code entered");
					
					getElement(ObjectRepository.alrt_svbtn).click();
					test.log(Status.INFO, "Save button clicked");
					Thread.sleep(3000);
					
					verifyElementPresent(ObjectRepository.phone_errmsg);
					test.log(Status.INFO, "Phone number validation message appeared");
					Thread.sleep(3000);
				
				//Valid phone number and invalid area code
					
					getShadowElement(ObjectRepository.phonearea_code).sendKeys("+12");
					test.log(Status.INFO, "Invalid Phone area code entered");
					
					getShadowElement(ObjectRepository.phonenumber).sendKeys("5607124532");
					test.log(Status.INFO, "Invalid Phone area code entered");
					
					getElement(ObjectRepository.alrt_svbtn).click();
					test.log(Status.INFO, "Save button clicked");
					Thread.sleep(3000);
					
					verifyElementPresent(ObjectRepository.phone_errmsg);
					test.log(Status.INFO, "Phone number validation message appeared");
					Thread.sleep(3000);
					
				//Valid phone number and area code
					getShadowElement(ObjectRepository.phonearea_code).sendKeys("+1");
					test.log(Status.INFO, "Invalid Phone area code entered");
					
					getShadowElement(ObjectRepository.phonenumber).sendKeys("5607124532");
					test.log(Status.INFO, "Invalid Phone area code entered");
					
					getElement(ObjectRepository.alrt_svbtn).click();
					test.log(Status.INFO, "Save button clicked");
					Thread.sleep(3000);
					
					verifyElementPresent(ObjectRepository.phone_errmsg);
					test.log(Status.INFO, "Phone number validation message appeared");
					Thread.sleep(3000);
					
//					verifyElementPresent(ObjectRepository.sccs_msg);
//					test.log(Status.INFO, "Phone Number updation success message appeared");
//					
//					getElement(ObjectRepository.alrt_clsbtn).click();
//					test.log(Status.INFO, "Close button clicked");
//					Thread.sleep(3000);
					
		}
				
	}

	@AfterMethod
	public void afterMethod(ITestResult result) throws Throwable {
		if (result.getStatus() == ITestResult.FAILURE) {
			test.log(Status.FAIL, "Test Failed-" + result.getThrowable());

			takescreenshot(this.getClass().getSimpleName(), test);
		} else {
			test.log(Status.PASS, "Verify security alert setup by phone number scenario working fine");
		}
	}

	@AfterTest
	public void tearDown() {
		extent.flush();
		driver.quit();
	}

}
