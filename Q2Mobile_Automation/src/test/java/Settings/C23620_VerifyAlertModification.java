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

public class C23620_VerifyAlertModification  extends GenericKeywords {

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
	public void C23620_VerifyAlertModification() throws InterruptedException
	{
		if(continuetestcase==true)
		{
			sheetName = "Alerts";
			int totalRowCount = excl.getRowCount(sheetName);
			for(startIter=1;startIter<=totalRowCount;startIter++) //It is mandatory to have this for loop in every test case
			 {	
				if(this.getClass().getSimpleName().equals(excl.getCellData(sheetName, 0, startIter)))
				 {
					String msg=excl.getCellData(sheetName, 10, startIter);
					String type=excl.getCellData(sheetName, 9, startIter);
		Thread.sleep(30000);
	//Verify menu item option
		verifyElementPresent(ObjectRepository.menu_btn);
		test.log(Status.INFO, "Menu link appearing");
		
		getElement(ObjectRepository.menu_btn).click();
		test.log(Status.INFO, " menu clicked");
		Thread.sleep(4000);	
		
		getElement(ObjectRepository.settings_menu).click();
		test.log(Status.INFO, "Settings menu clicked");
		Thread.sleep(4000);	
	
		getElement(ObjectRepository.alrt_menu).click();
		test.log(Status.INFO, "Alert menu clicked");
		Thread.sleep(4000);
		
		verifyElementPresent(ObjectRepository.alrt_ttl);
		test.log(Status.INFO, "Alerts page opened");
		
		scrollTillElement(ObjectRepository.dtalrt_sctn);
		Thread.sleep(2000);
		
		verifyElementPresent(ObjectRepository.dtalrt_sctn);
		test.log(Status.INFO, "Reminder alert section appearing on alert page");
		Thread.sleep(4000);
		
//		getElement("//android.view.View[contains(@content-desc,'"+msg+"')]").click();
//		test.log(Status.INFO, "Date Alert selected");
//		Thread.sleep(4000);
		getElement(ObjectRepository.alrt_edtbtn).click();
		test.log(Status.INFO, "Alert Edit option clicked");
		Thread.sleep(4000);
		
		verifyElementPresent(ObjectRepository.datealrt_ttl);
		test.log(Status.INFO, "Date alert page title appearing");
		
//		Update Type
			getElement(ObjectRepository.alrt_type).click();
			test.log(Status.INFO, "Alert Type option clicked");
			Thread.sleep(4000);
			
			getElement("//android.view.View[contains(@content-desc,'"+type+"')]").click();
			test.log(Status.INFO, "Event Type selected");
			Thread.sleep(4000);
		
		//Save the alert
			clickElement(ObjectRepository.alrt_svbtn);
			test.log(Status.INFO, "Create Alert button clicked");
			Thread.sleep(4000);
			
			verifyElementPresent(ObjectRepository.alrt_svsccs);
			test.log(Status.INFO, "Alert success message appearing");
			
			getElement(ObjectRepository.mtm_clsbtn).click();
			test.log(Status.INFO, "Close button clicked");
			Thread.sleep(4000);	
		
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
			test.log(Status.PASS, "Verify Alert modification scenario working fine");
		}
	}
	
	@AfterTest
	public void tearDown(){
		driver.quit();
		stopAppium();
		extent.flush();
		
	}
}
