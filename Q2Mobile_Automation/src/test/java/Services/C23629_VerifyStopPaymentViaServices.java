package Services;

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

public class C23629_VerifyStopPaymentViaServices  extends GenericKeywords {

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
			
		
	}
	

	@Test
	public void C23629_VerifyStopPaymentViaServices() throws InterruptedException
	{
		Thread.sleep(20000);	
		verifyElementPresent(ObjectRepository.home_ttl);
		test.log(Status.INFO, "Home link appearing");
	//Verify menu item option
		verifyElementPresent(ObjectRepository.menu_btn);
		test.log(Status.INFO, "Menu link appearing");
	
		getElement(ObjectRepository.menu_btn).click();
		test.log(Status.INFO, "Menu link clicked");
		Thread.sleep(4000);	
			
		getElement(ObjectRepository.service_menu).click();
		test.log(Status.INFO, "Services menu clicked");
		Thread.sleep(4000);
		
		getElement(ObjectRepository.stppymnt_menu).click();
		test.log(Status.INFO, "Stop Payment Menu link clicked");
		Thread.sleep(4000);
		
		verifyElementPresent(ObjectRepository.stppymnt_ttl);
		test.log(Status.INFO, "Stop Payment page opened");
		
		getElement(ObjectRepository.info_msg_cls).click();
		test.log(Status.INFO, "Stop Payment info message close icon clicked");
		Thread.sleep(4000);	
		
		verifyElementPresent(ObjectRepository.stppymnt_tnc);
		test.log(Status.INFO, "Stop Payment term and conditions appearing");
		
		verifyElementPresent(ObjectRepository.stppymnt_rqsttyp);
		verifyElementPresent(ObjectRepository.stppymnt_acnt);
		verifyElementPresent(ObjectRepository.stppymnt_note);
		test.log(Status.INFO, "Request Type,Account and Note fields appearing on Stop Payment page");
		
		scrollToElement(1);
		Thread.sleep(2000);	
		boolean sendrequest=getElement(ObjectRepository.sndrqst_btn).isEnabled();
		Assert.assertFalse(sendrequest);
		test.log(Status.INFO, "Send Request is disabled by default");
		
		
	}
	
	@AfterMethod
	public void afterMethod(ITestResult result) throws Throwable{
		if(result.getStatus()==ITestResult.FAILURE){
			test.log(Status.FAIL, "Test Failed - "+result.getThrowable());	
			GenericKeywords.takescreenshot(myTestCaseName,test);
		}else
		{
			test.log(Status.PASS, "Verify Stop Payment Via Services scenario working fine");
		}
	}
	
	@AfterTest
	public void tearDown(){
		driver.quit();
		stopAppium();
		extent.flush();
		
	}
}
