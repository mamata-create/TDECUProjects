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

public class C23632_VerifySendingSingleCheckStopPayment  extends GenericKeywords {

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
	public void C23630_VerifySingleCheckStopPaymentCreation() throws InterruptedException
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
					String payee=excl.getCellData(sheetName, 2, startIter);
					String amnt=excl.getCellData(sheetName, 3, startIter);
					String chknmbr=excl.getCellData(sheetName, 5, startIter);
					
					
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
//Request Type 		
		getElement(ObjectRepository.stppymnt_rqsttyp).click();
		test.log(Status.INFO, "Request Type option clicked");
		Thread.sleep(2000);	
		
		verifyElementPresent(ObjectRepository.rqsttyp_msg);
		test.log(Status.INFO, "Request Type warning message appearing");
		
		
		getElement(ObjectRepository.snglchk_optn).click();
		test.log(Status.INFO, "Single Check option selected");
		Thread.sleep(4000);	
		
		verifyElementPresent(ObjectRepository.stppymnt_chknmbr);
		verifyElementPresent(ObjectRepository.stppymnt_acnt);
		verifyElementPresent(ObjectRepository.stppymnt_payee);
		verifyElementPresent(ObjectRepository.stppymnt_date);
		test.log(Status.INFO, "Account, Check Number, Payee and date fields appearing on Stop Payment page");
		
		
//Account		
		
		getElement(ObjectRepository.stppymnt_acnt).click();
		test.log(Status.INFO, "Account option clicked");
		Thread.sleep(2000);	
		
		
		getElement("//android.view.View[contains(@content-desc,'"+acnt+"')]").click();
		test.log(Status.INFO, "Account selected");
		Thread.sleep(4000);	
		
//Check Number
		
		scrollToElement(1);
		Thread.sleep(2000);	
		
		getElement(ObjectRepository.stppymnt_chknmbr).click();
		test.log(Status.INFO, "Check Number option clicked");
		Thread.sleep(2000);
		
		
		getElement(ObjectRepository.otp_txt).sendKeys(chknmbr);
		test.log(Status.INFO, "Check Number entered ");
		Thread.sleep(2000);
		
		getElement(ObjectRepository.alrt_amntsv).click();
		test.log(Status.INFO, "Save button clicked");
		Thread.sleep(2000);
		
		
//	Payee
		clickElement(ObjectRepository.stppymnt_payee);
		test.log(Status.INFO, "Payee option clicked");
		Thread.sleep(2000);
		
		verifyElementPresent(ObjectRepository.stppymnt_payeename);
		test.log(Status.INFO, "Payee name field appearing");
		
		
		getElement(ObjectRepository.stppymnt_payeename).sendKeys(payee+"abc");
		test.log(Status.INFO, "Payee Name entered");
		Thread.sleep(4000);
		
		int name=getElement(ObjectRepository.alrt_msgtxt).getAttribute("name").length();
		Assert.assertTrue(name==40);
		
		getElement(ObjectRepository.stppymnt_set).click();
		test.log(Status.INFO, "Set button clicked");
		Thread.sleep(2000);
		
//Amount
		clickElement(ObjectRepository.stppymnt_amnt);
		test.log(Status.INFO, "Amount option clicked");
		Thread.sleep(2000);
		
		if(!amnt.contains(".")){
			getElement(ObjectRepository.amnt_txt).sendKeys(amnt);
			test.log(Status.INFO, "Stop Payment Amount entered");
			Thread.sleep(2000);
			}else{
				getElement(ObjectRepository.amnt_txt).sendKeys(amnt+"00");
				test.log(Status.INFO, "Stop Payment Amount entered");
				Thread.sleep(2000);
			}
		
		getElement(ObjectRepository.alrt_amntsv).click();
		test.log(Status.INFO, "Stop Payment Amount save button clicked");
		Thread.sleep(2000);
//Date		
		clickElement(ObjectRepository.stppymnt_date);
		test.log(Status.INFO, "Date option clicked");
		Thread.sleep(2000);
		
		verifyElementPresent(ObjectRepository.stppymnt_dtttl);
		test.log(Status.INFO, "Calender appearing");
		
		selectStopPaymentFutureDate(0,5);
		test.log(Status.INFO, "Date selected");
		Thread.sleep(4000);
		
//Note
		clickElement(ObjectRepository.stppymnt_note);
		test.log(Status.INFO, "Note option clicked");
		Thread.sleep(2000);
		
		verifyElementPresent(ObjectRepository.stppymnt_notemsg);
		test.log(Status.INFO, "Note Message appearing");
		
		
		getElement(ObjectRepository.stppymnt_notetxt).sendKeys("Note Message");
		test.log(Status.INFO, "Note entered");
		Thread.sleep(2000);
		
		getElement(ObjectRepository.stppymnt_set).click();
		test.log(Status.INFO, "Set button clicked");
		Thread.sleep(2000);
		
		getElement(ObjectRepository.sndrqst_btn).click();
		test.log(Status.INFO, "Send Request button clicked");
		Thread.sleep(2000);
		
		verifyElementPresent(ObjectRepository.vwactvty_btn);
		test.log(Status.INFO, "View Activity center button appearing");
		Thread.sleep(2000);
		
		getElement(ObjectRepository.vwactvty_btn).click();
		test.log(Status.INFO, "View Activity Center button clicked");
		Thread.sleep(2000);
		
		verifyElementPresent(ObjectRepository.actvtycntr_ttl);
		test.log(Status.INFO, "Activity center page appearing");
		Thread.sleep(2000);
		
		
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
			test.log(Status.PASS, "Verify Sending Single Check Stop Payment scenario working fine");
		}
	}
	
	@AfterTest
	public void tearDown(){
		driver.quit();
		stopAppium();
		extent.flush();
		
	}
}
