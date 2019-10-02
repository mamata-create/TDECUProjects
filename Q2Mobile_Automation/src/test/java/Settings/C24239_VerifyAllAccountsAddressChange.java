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

public class C24239_VerifyAllAccountsAddressChange  extends GenericKeywords {

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
	public void C24239_VerifyAllAccountsAddressChange() throws InterruptedException
	{
		if(continuetestcase==true)
		{
			sheetName = "Data";
			int totalRowCount = excl.getRowCount(sheetName);
			for(startIter=1;startIter<=totalRowCount;startIter++) //It is mandatory to have this for loop in every test case
			 {	
				if(this.getClass().getSimpleName().equals(excl.getCellData(sheetName, 0, startIter)))
				 {
					String acnt=excl.getCellData(sheetName, 1, startIter);
					String scndacnt=excl.getCellData(sheetName, 2, startIter);
					
		Thread.sleep(20000);	
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
		
		getElement(ObjectRepository.addrschange_menu).click();
		test.log(Status.INFO, "Address Change menu clicked");
		Thread.sleep(4000);	
		
		verifyElementPresent(ObjectRepository.addrschange_menu);
		test.log(Status.INFO, "Address cange option appearing");
		
		getElement(ObjectRepository.clrall_btn).click();
		test.log(Status.INFO, "Clear All button clicked");
		Thread.sleep(4000);
		
		getElement(ObjectRepository.slctall_btn).click();
		test.log(Status.INFO, "Select All button clicked");
		Thread.sleep(4000);
		
		clickElement(ObjectRepository.homephone_txt);
		Thread.sleep(2000);	
		getElement(ObjectRepository.homephone_txt).sendKeys("9876543210");
		test.log(Status.INFO, "Phone number updated");
		
		clickElement(ObjectRepository.submit_btn);
		test.log(Status.INFO, "Submit button clicked");
		Thread.sleep(4000);	
		
		verifyElementPresent(ObjectRepository.vwactvty_btn);
		test.log(Status.INFO, "View Activity button appearing on the success page");
		
		verifyElementPresent(ObjectRepository.mtm_clsbtn);
		test.log(Status.INFO, "Close button appearing");
		
		getElement(ObjectRepository.vwactvty_btn).click();
		test.log(Status.INFO, "View Activity button clicked");
		Thread.sleep(4000);	
		
		verifyElementPresent(ObjectRepository.actvtycntr_ttl);
		test.log(Status.INFO, "View Activity page opened");
		
				 }
			 }
		}
				
	}
	
	@AfterMethod
	public void afterMethod(ITestResult result) throws Throwable{
		if(result.getStatus()==ITestResult.FAILURE){
			test.log(Status.FAIL, "Test Failed - "+result.getThrowable());	
			GenericKeywords.takescreenshot(myTestCaseName,test);
		}else
		{
			test.log(Status.PASS, "Verify All Accounts Address Change scenario working fine");
		}
	}
	
	@AfterTest
	public void tearDown(){
		driver.quit();
		stopAppium();
		extent.flush();
		
	}
}
