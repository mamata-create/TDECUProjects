package Alerts;

import java.io.IOException;
import java.util.List;

import javax.mail.MessagingException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
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

public class C23477_VerifySecurityAlertSetupByEmail extends GenericKeywords {

	ExtentReports extent;
	ExtentTest test;
	/*
	 * Verify security alert setup by Email
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
	public void C23477_VerifySecurityAlertSetupByEmail() throws InterruptedException, MessagingException, IOException
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
			
					getElement(ObjectRepository.cancl_btn).click();
					test.log(Status.INFO, "Cancel button clicked");
					Thread.sleep(3000);
					
					verifyElementPresent(ObjectRepository.alrt_ttl);
					test.log(Status.INFO, "Alerts page opened and title available");
					
					getElement(ObjectRepository.edtscrtyPrfrnc_lnk).click();
					test.log(Status.INFO, "Edit Delivery preference link  clicked");
					Thread.sleep(3000);
					
					verifyElementPresent(ObjectRepository.edtscrtyPrfrnc_ttl);
					test.log(Status.INFO, "Delivery preference page opened and title available");
					
					//verify email, phone and sms sections
					verifyElementPresent(ObjectRepository.email_sctn);
					verifyElementPresent(ObjectRepository.phone_sctn);
					verifyElementPresent(ObjectRepository.sms_sctn);
					test.log(Status.INFO, "Email, Phone and SMS sections available");
					
				//try to update email without @
					WebElement emailroot = getElement(ObjectRepository.emailadrs_txt);
					WebElement shadow_emailroot = ObjectRepository.expandRootElement(driver, emailroot);
					WebElement email_txt=shadow_emailroot.findElement(By.cssSelector("input.input-field"));
					email_txt.clear();
					email_txt.sendKeys("sravyagmail.com");
					test.log(Status.INFO, "Email address without @ entered");
					Thread.sleep(3000);
					
					getElement(ObjectRepository.alrt_svbtn).click();
					test.log(Status.INFO, "Save button clicked");
					Thread.sleep(3000);
					
					WebElement emailerror = getElement(ObjectRepository.alrt_error);
					WebElement shadow_emailerror = ObjectRepository.expandRootElement(driver, emailerror);
					WebElement email_validation=driver.findElement(By.xpath("//li[text()='Email Address']"));
					Assert.assertTrue(email_validation.isDisplayed());
					test.log(Status.INFO, "Email address validation appears for providing email without @");
					
				//try to update email without domain
					 emailroot = getElement(ObjectRepository.emailadrs_txt);
					 shadow_emailroot = ObjectRepository.expandRootElement(driver, emailroot);
					 email_txt=shadow_emailroot.findElement(By.cssSelector("input.input-field"));
					email_txt.clear();
					email_txt.sendKeys("sravya@gmail");
					test.log(Status.INFO, "Email address without domain entered");
					Thread.sleep(3000);
					
					getElement(ObjectRepository.alrt_svbtn).click();
					test.log(Status.INFO, "Save button clicked");
					Thread.sleep(3000);
					
					 shadow_emailerror = ObjectRepository.expandRootElement(driver, getElement(ObjectRepository.alrt_error));
					 email_validation=driver.findElement(By.xpath("//li[text()='Email Address']"));
					Assert.assertTrue(email_validation.isDisplayed());
					test.log(Status.INFO, "Email address validation appears for providig email without domain");
					
			//update valid email
					emailroot = getElement(ObjectRepository.emailadrs_txt);
					 shadow_emailroot = ObjectRepository.expandRootElement(driver, emailroot);
					 email_txt=shadow_emailroot.findElement(By.cssSelector("input.input-field"));
					email_txt.clear();
					email_txt.sendKeys("sravya@gmail.com");
					test.log(Status.INFO, "Valid Email address entered");
					Thread.sleep(3000);
					
					getElement(ObjectRepository.alrt_svbtn).click();
					getElement(ObjectRepository.alrt_svbtn).sendKeys(Keys.ENTER);
					test.log(Status.INFO, "Save button clicked");
					Thread.sleep(3000);
					
					verifyElementPresent(ObjectRepository.sccs_msg);
					test.log(Status.INFO, "Email address updation success message appeared");
					
					getElement(ObjectRepository.alrt_clsbtn).click();
					test.log(Status.INFO, "Close button clicked");
					Thread.sleep(3000);
					
		}
				
	}

	@AfterMethod
	public void afterMethod(ITestResult result) throws Throwable {
		if (result.getStatus() == ITestResult.FAILURE) {
			test.log(Status.FAIL, "Test Failed-" + result.getThrowable());

			takescreenshot(this.getClass().getSimpleName(), test);
		} else {
			test.log(Status.PASS, "Verify security alert setup by Email scenario working fine");
		}
	}

	@AfterTest
	public void tearDown() {
		extent.flush();
		driver.quit();
	}

}
