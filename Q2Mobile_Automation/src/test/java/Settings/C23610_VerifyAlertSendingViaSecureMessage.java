package Settings;

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

public class C23610_VerifyAlertSendingViaSecureMessage  extends GenericKeywords {

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
	public void C23610_VerifyAlertSendingViaSecureMessage() throws InterruptedException
	{
		if(continuetestcase==true)
		{
			sheetName = "Alerts";
			int totalRowCount = excl.getRowCount(sheetName);
			for(startIter=1;startIter<=totalRowCount;startIter++) //It is mandatory to have this for loop in every test case
			 {	
				if(this.getClass().getSimpleName().equals(excl.getCellData(sheetName, 0, startIter)))
				 {
					String alerttype=excl.getCellData(sheetName, 1, startIter);
					String type=excl.getCellData(sheetName, 9, startIter);
					String msg=excl.getCellData(sheetName, 10, startIter);
					String cmprsn=excl.getCellData(sheetName, 4, startIter);
					String amnt=excl.getCellData(sheetName, 5, startIter);
					String dlvrymthd=excl.getCellData(sheetName, 6, startIter);
								
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
		
		
//		verifyElementPresent(ObjectRepository.acntalrt_sctn);
//		test.log(Status.INFO, "Account alert sections appearing on alert page");
		
		verifyElementPresent(ObjectRepository.alrttyp_dropdown);
		test.log(Status.INFO, "Alerts type dropdown appearing");
		
	//Select alert as date alert 
		getElement(ObjectRepository.alrttyp_dropdown).click();
		test.log(Status.INFO, "Alert type dropdown clicked");
		Thread.sleep(4000);
		
		getElement("//android.view.View[@content-desc='"+alerttype+"']").click();
		test.log(Status.INFO, "Date Alert type selected");
		Thread.sleep(4000);

		verifyElementPresent(ObjectRepository.datealrt_ttl);
		test.log(Status.INFO, "Date alert page title appearing");
	
				
	//	Select Type
		getElement(ObjectRepository.alrt_type).click();
		test.log(Status.INFO, "Alert Type option clicked");
		Thread.sleep(4000);
		
		getElement("//android.view.View[contains(@content-desc,'"+type+"')]").click();
		test.log(Status.INFO, "Event Type selected");
		Thread.sleep(4000);
		
		
		
	//Select Date
		getElement(ObjectRepository.alrt_date).click();
		test.log(Status.INFO, "Alert Date option clicked");
		Thread.sleep(4000);
		
		selectAlertDate(0);
		test.log(Status.INFO, "Date selected");
		Thread.sleep(4000);
		
	//Enter message
		getElement(ObjectRepository.alrt_msg).click();
		test.log(Status.INFO, "Alert Message option clicked");
		Thread.sleep(4000);
		
		getElement(ObjectRepository.alrt_msg).sendKeys(msg);
		test.log(Status.INFO, "Alert Message entered");
		Thread.sleep(4000);
		
//		getElement(ObjectRepository.alrt_setbtn).click();
//		test.log(Status.INFO, "Alert Set button clicked");
//		Thread.sleep(4000);
		
	//Select Delivery Method
//		getElement(ObjectRepository.alrt_dlvrymthd).click();
//		test.log(Status.INFO, "Alert Delivery Method option clicked");
//		Thread.sleep(4000);
		
		verifyElementPresent(ObjectRepository.alrt_dlvrymthd_ttl);
		test.log(Status.INFO, "Delivery MEthod Page title appearing");
		
//		getElement(ObjectRepository.alrt_dlvrymthdtyp).click();
//		test.log(Status.INFO, "Alert Delivery Method type dropdown clicked");
//		Thread.sleep(4000);
		scrollToElement(1);
		getElement("//android.widget.RadioButton[@content-desc='"+dlvrymthd+"']").click();
		test.log(Status.INFO, "Delivery MEthod selected");
		
//		getElement(ObjectRepository.alrt_donebtn).click();
//		test.log(Status.INFO, "Done button clicked");
//		Thread.sleep(4000);
//		
		clickElement(ObjectRepository.alrt_svbtn);
		test.log(Status.INFO, "Create Alert button clicked");
		Thread.sleep(4000);
		
		verifyElementPresent(ObjectRepository.alrt_svsccs);
		test.log(Status.INFO, "Alert success message appearing");
		
		getElement(ObjectRepository.mtm_clsbtn).click();
		test.log(Status.INFO, "Close button clicked");
		Thread.sleep(4000);
		
/*
 * Verify the date alert message sent		
 */
		getElement(ObjectRepository.menu_btn).click();
		test.log(Status.INFO, " menu clicked");
		Thread.sleep(4000);	
		
		getElement(ObjectRepository.msg_menu).click();
		test.log(Status.INFO, " Message menu clicked");
		Thread.sleep(4000);	
		
//		getElement(ObjectRepository.mtngrmndr).click();
//		test.log(Status.INFO, " New Message - Meeting reminder clicked");
//		Thread.sleep(4000);
		
//		getElement(ObjectRepository.rply).click();
//		test.log(Status.INFO, "Reply icon clicked");
//		Thread.sleep(4000);
		
//		verifyElementPresent(ObjectRepository.rply_notallwd);
//		test.log(Status.INFO, "Reply not allowed message appearing");
		
//		getElement(ObjectRepository.mtm_clsbtn).click();
//		test.log(Status.INFO, "Close button clicked");
//		Thread.sleep(4000);
		
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
			test.log(Status.PASS, "Verify Alert sending via secure message working fine");
		}
	}
	
	@AfterTest
	public void tearDown(){
		driver.quit();
		stopAppium();
		extent.flush();
		
	}
}
