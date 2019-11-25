package Activity_center;

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

public class C23746_VerifyActivityCenterSearchTransactionByKeyword  extends GenericKeywords {

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
	public void C23746_VerifyActivityCenter() throws InterruptedException
	{
		Thread.sleep(20000);	
	//Verify menu item option
		verifyElementPresent(ObjectRepository.menu_btn);
		test.log(Status.INFO, "Menu link appearing");
	
		getElement(ObjectRepository.menu_btn).click();
		test.log(Status.INFO, "Menu link clicked");
		Thread.sleep(4000);	
			
		getElement(ObjectRepository.trnsctn_menu).click();
		test.log(Status.INFO, "Transactions menu clicked");
		Thread.sleep(4000);	
		
		getElement(ObjectRepository.actvtycntr_menu).click();
		test.log(Status.INFO, "Activity Center menu clicked");
		Thread.sleep(30000);
		
		verifyElementPresent(ObjectRepository.actvtycntr_infomsg);
		test.log(Status.INFO, "Informative Message appeared on activity center page");
		
		clickElement(ObjectRepository.actvtycntr_srchtxt);
		
		getElement(ObjectRepository.actvtycntr_srchtxt).sendKeys("Processed");
		test.log(Status.INFO, "Status entered in search field");
		Thread.sleep(2000);
		
		getElement(ObjectRepository.actvtycntr_srchbtn).click();
		test.log(Status.INFO, "Activity Search button clicked");
		Thread.sleep(4000);
		
		verifyElementPresent("//android.widget.GridView//android.view.View[@content-desc='Processed']");
		test.log(Status.INFO, "Searched record by status are correct");
		
		
	}
	
	@AfterMethod
	public void afterMethod(ITestResult result) throws Throwable{
		if(result.getStatus()==ITestResult.FAILURE){
			test.log(Status.FAIL, "Test Failed - "+result.getThrowable());	
			GenericKeywords.takescreenshot(myTestCaseName,test);
		}else
		{
			test.log(Status.PASS, "Verify activity center search transaction by keyword scenario working fine");
		}
	}
	
	@AfterTest
	public void tearDown(){
		driver.quit();
		stopAppium();
		extent.flush();
		
	}
}
