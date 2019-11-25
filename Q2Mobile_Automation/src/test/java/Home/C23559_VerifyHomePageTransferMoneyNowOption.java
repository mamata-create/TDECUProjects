package Home;

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

public class C23559_VerifyHomePageTransferMoneyNowOption   extends GenericKeywords {

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
	public void C23559_VerifyHomePageTransferMoneyNowOption() throws InterruptedException
	{
		Thread.sleep(20000);	
	//Verify menu item option
		verifyElementPresent(ObjectRepository.menu_btn);
		test.log(Status.INFO, "Menu link appearing");
		getElement(ObjectRepository.more_menu).click();
		test.log(Status.INFO, "More menu clicked");
		Thread.sleep(3000);	
		verifyElementPresent(ObjectRepository.trnsfrmoney_lnk);
		test.log(Status.INFO, "Transfer Money now link appearing");
		
//		TouchAction actn=new TouchAction(driver);
//		actn.tap(460,120).perform();
//		test.log(Status.INFO, "Transfer Money Now option clicked");
		
		Thread.sleep(3000);
		getElement(ObjectRepository.trnsfrmoney_lnk).click();
		test.log(Status.INFO, "Transfer Money now link clicked");
//		
//		Thread.sleep(15000);	
//		verifyElementPresent(ObjectRepository.fndtrnsfr_ttl);
//		test.log(Status.INFO, "Fund Transfer title appearing");
		
	}
	
	@AfterMethod
	public void afterMethod(ITestResult result) throws Throwable{
		if(result.getStatus()==ITestResult.FAILURE){
			test.log(Status.FAIL, "Test Failed - "+result.getThrowable());	
			GenericKeywords.takescreenshot(myTestCaseName,test);
		}else
		{
			test.log(Status.PASS, "Verify home page transfer money now option scenario working fine");
		}
	}
	
	@AfterTest
	public void tearDown(){
		driver.quit();
		stopAppium();
		extent.flush();
		
	}
}
