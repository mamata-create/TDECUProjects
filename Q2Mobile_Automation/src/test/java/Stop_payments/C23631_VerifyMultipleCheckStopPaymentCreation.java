package Stop_payments;

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

public class C23631_VerifyMultipleCheckStopPaymentCreation  extends GenericKeywords {

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
	public void C23631_VerifyMultipleCheckStopPaymentCreation() throws InterruptedException
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
					String endchknmbr=excl.getCellData(sheetName, 6, startIter);
					
					
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
		
		getElement(ObjectRepository.alrt_acntback).click();
		test.log(Status.INFO, "Back button clicked");
		Thread.sleep(2000);	
		getElement(ObjectRepository.menu_btn).click();
		test.log(Status.INFO, "Menu link clicked");
		Thread.sleep(4000);	
		getElement(ObjectRepository.service_menu).click();
		test.log(Status.INFO, "Services menu clicked");
		Thread.sleep(4000);
		getElement(ObjectRepository.stppymnt_menu).click();
		test.log(Status.INFO, "Stop Payment Menu link clicked");
		Thread.sleep(4000);
		
		
		getElement(ObjectRepository.stppymnt_rqsttyp).click();
		test.log(Status.INFO, "Request Type option clicked");
		Thread.sleep(2000);	
		
		getElement(ObjectRepository.mltplchk_optn).click();
		test.log(Status.INFO, "Multiple Check option selected");
		Thread.sleep(4000);	
		
		verifyElementPresent(ObjectRepository.stppymnt_strtchknmbr);
		verifyElementPresent(ObjectRepository.stppymnt_endchknmbr);
		verifyElementPresent(ObjectRepository.stppymnt_acnt);
		verifyElementPresent(ObjectRepository.stppymnt_strtdate);
		verifyElementPresent(ObjectRepository.stppymnt_enddate);
		test.log(Status.INFO, "Account,Start Check Number,Ending Check Number and date fields appearing on Stop Payment page");
		
		
//Account		
		
		getElement(ObjectRepository.stppymnt_acnt).click();
		test.log(Status.INFO, "Account option clicked");
		Thread.sleep(2000);	
		
		verifyElementPresent("//android.view.View[contains(@content-desc,'Classic Checking')]");
		verifyElementPresent("//android.view.View[contains(@content-desc,'$')]");
		test.log(Status.INFO, "Account minor information and balance appearing");
		
		getElement(ObjectRepository.alrt_acntback).click();
		test.log(Status.INFO, "Back button clicked");
		Thread.sleep(2000);
		getElement(ObjectRepository.menu_btn).click();
		test.log(Status.INFO, "Menu link clicked");
		Thread.sleep(4000);		
		getElement(ObjectRepository.service_menu).click();
		test.log(Status.INFO, "Services menu clicked");
		Thread.sleep(4000);
		getElement(ObjectRepository.stppymnt_menu).click();
		test.log(Status.INFO, "Stop Payment Menu link clicked");
		Thread.sleep(4000);
		
		getElement(ObjectRepository.stppymnt_rqsttyp).click();
		test.log(Status.INFO, "Request Type option clicked");
		Thread.sleep(2000);	
		
		getElement(ObjectRepository.mltplchk_optn).click();
		test.log(Status.INFO, "Multiple Check option selected");
		Thread.sleep(4000);	
		
		getElement(ObjectRepository.stppymnt_acnt).click();
		test.log(Status.INFO, "Account option clicked");
		Thread.sleep(2000);	
		
		getElement("//android.view.View[contains(@content-desc,'"+acnt+"')]").click();
		test.log(Status.INFO, "Account selected");
		Thread.sleep(4000);	
		
//Starting Check Number
		
		scrollToElement(1);
		Thread.sleep(2000);	
		
		getElement(ObjectRepository.stppymnt_strtchknmbr).click();
		test.log(Status.INFO, "Starting Check Number option clicked");
		Thread.sleep(2000);
		
		getElement(ObjectRepository.otp_txt).sendKeys("9876543210123456");
		test.log(Status.INFO, "Check Number entered more than 15 characters");
		Thread.sleep(2000);
		int chkno=getElement(ObjectRepository.otp_txt).getAttribute("name").length();
		Assert.assertTrue(chkno==9);
		
		getElement(ObjectRepository.alrt_amntdlt).click();
		test.log(Status.INFO, "Check Number-Delete button clicked");
		Thread.sleep(2000);
		
		chkno=getElement(ObjectRepository.otp_txt).getAttribute("name").length();
		Assert.assertTrue(chkno==8);
		
		getElement(ObjectRepository.alrt_amntcross).click();
		test.log(Status.INFO, "Check Number-Clear button clicked");
		Thread.sleep(2000);
		
		chkno=getElement(ObjectRepository.otp_txt).getAttribute("name").length();
		Assert.assertTrue(chkno==0);
		
		getElement(ObjectRepository.alrt_acntback).click();
		test.log(Status.INFO, "Back button clicked");
		Thread.sleep(2000);
		getElement(ObjectRepository.menu_btn).click();
		test.log(Status.INFO, "Menu link clicked");
		Thread.sleep(4000);		
		getElement(ObjectRepository.service_menu).click();
		test.log(Status.INFO, "Services menu clicked");
		Thread.sleep(4000);
		getElement(ObjectRepository.stppymnt_menu).click();
		test.log(Status.INFO, "Stop Payment Menu link clicked");
		Thread.sleep(4000);
		getElement(ObjectRepository.stppymnt_rqsttyp).click();
		test.log(Status.INFO, "Request Type option clicked");
		Thread.sleep(2000);	
		
		getElement(ObjectRepository.mltplchk_optn).click();
		test.log(Status.INFO, "Multiple Check option selected");
		Thread.sleep(4000);	
		
		
		
		Thread.sleep(2000);	
		
		clickElement(ObjectRepository.stppymnt_strtchknmbr);
		test.log(Status.INFO, "Starting Check Number option clicked");
		Thread.sleep(2000);
		
		getElement(ObjectRepository.otp_txt).sendKeys(chknmbr);
		test.log(Status.INFO, "Starting Check Number entered ");
		Thread.sleep(2000);
		
		getElement(ObjectRepository.alrt_amntsv).click();
		test.log(Status.INFO, "Save button clicked");
		Thread.sleep(2000);
		

//Ending Check Number
				
				
				Thread.sleep(4000);	
				
				clickElement(ObjectRepository.stppymnt_endchknmbr);
				test.log(Status.INFO, "Ending Check Number option clicked");
				Thread.sleep(2000);
				
				getElement(ObjectRepository.otp_txt).sendKeys("987654321");
				test.log(Status.INFO, "Check Number entered more than 15 characters");
				Thread.sleep(2000);
				int endchkno=getElement(ObjectRepository.otp_txt).getAttribute("name").length();
				Assert.assertTrue(endchkno==9);
				
				getElement(ObjectRepository.alrt_amntdlt).click();
				test.log(Status.INFO, "Check Number-Delete button clicked");
				Thread.sleep(2000);
				
				endchkno=getElement(ObjectRepository.otp_txt).getAttribute("name").length();
				Assert.assertTrue(endchkno==8);
				
				getElement(ObjectRepository.alrt_amntcross).click();
				test.log(Status.INFO, "Check Number-Clear button clicked");
				Thread.sleep(2000);
				
				endchkno=getElement(ObjectRepository.otp_txt).getAttribute("name").length();
				Assert.assertTrue(endchkno==0);
				
				getElement(ObjectRepository.alrt_acntback).click();
				test.log(Status.INFO, "Back button clicked");
				Thread.sleep(2000);
				getElement(ObjectRepository.menu_btn).click();
				test.log(Status.INFO, "Menu link clicked");
				Thread.sleep(4000);		
				getElement(ObjectRepository.service_menu).click();
				test.log(Status.INFO, "Services menu clicked");
				Thread.sleep(4000);
				getElement(ObjectRepository.stppymnt_menu).click();
				test.log(Status.INFO, "Stop Payment Menu link clicked");
				Thread.sleep(4000);
				getElement(ObjectRepository.stppymnt_rqsttyp).click();
				test.log(Status.INFO, "Request Type option clicked");
				Thread.sleep(2000);	
				
				getElement(ObjectRepository.mltplchk_optn).click();
				test.log(Status.INFO, "Multiple Check option selected");
				Thread.sleep(4000);	
				
				
				clickElement(ObjectRepository.stppymnt_endchknmbr);
				test.log(Status.INFO, "Ending Check Number option clicked");
				Thread.sleep(2000);
				
				getElement(ObjectRepository.otp_txt).sendKeys(endchknmbr);
				test.log(Status.INFO, "Check Number entered ");
				Thread.sleep(2000);
				
				getElement(ObjectRepository.alrt_amntsv).click();
				test.log(Status.INFO, "Save button clicked");
				Thread.sleep(2000);
//Start Date		
		clickElement(ObjectRepository.stppymnt_strtdate);
		test.log(Status.INFO, "Start Date option clicked");
		Thread.sleep(2000);
		
		
		getElement(ObjectRepository.alrt_acntback).click();
		test.log(Status.INFO, "Back button clicked");
		Thread.sleep(2000);
		getElement(ObjectRepository.menu_btn).click();
		test.log(Status.INFO, "Menu link clicked");
		Thread.sleep(4000);		
		getElement(ObjectRepository.service_menu).click();
		test.log(Status.INFO, "Services menu clicked");
		Thread.sleep(4000);
		getElement(ObjectRepository.stppymnt_menu).click();
		test.log(Status.INFO, "Stop Payment Menu link clicked");
		Thread.sleep(4000);
		getElement(ObjectRepository.stppymnt_rqsttyp).click();
		test.log(Status.INFO, "Request Type option clicked");
		Thread.sleep(2000);	
		getElement(ObjectRepository.mltplchk_optn).click();
		test.log(Status.INFO, "Multiple Check option selected");
		Thread.sleep(4000);
		
		clickElement(ObjectRepository.stppymnt_strtdate);
		test.log(Status.INFO, "Start Date option clicked");
		Thread.sleep(2000);
		
		selectStopPaymentFutureDate(0,5);
		test.log(Status.INFO, "Start Date selected");
		Thread.sleep(4000);
		
//End Date		
				clickElement(ObjectRepository.stppymnt_enddate);
				test.log(Status.INFO, "End Date option clicked");
				Thread.sleep(2000);
				
				
				getElement(ObjectRepository.alrt_acntback).click();
				test.log(Status.INFO, "Back button clicked");
				Thread.sleep(2000);
				getElement(ObjectRepository.menu_btn).click();
				test.log(Status.INFO, "Menu link clicked");
				Thread.sleep(4000);		
				getElement(ObjectRepository.service_menu).click();
				test.log(Status.INFO, "Services menu clicked");
				Thread.sleep(4000);
				getElement(ObjectRepository.stppymnt_menu).click();
				test.log(Status.INFO, "Stop Payment Menu link clicked");
				Thread.sleep(4000);
				getElement(ObjectRepository.stppymnt_rqsttyp).click();
				test.log(Status.INFO, "Request Type option clicked");
				Thread.sleep(2000);	
				getElement(ObjectRepository.mltplchk_optn).click();
				test.log(Status.INFO, "Multiple Check option selected");
				Thread.sleep(4000);
				
				clickElement(ObjectRepository.stppymnt_enddate);
				test.log(Status.INFO, "End Date option clicked");
				Thread.sleep(2000);
				
				selectStopPaymentFutureDate(7,5);
				test.log(Status.INFO, "End Date selected");
				Thread.sleep(4000);
		
//Note
		clickElement(ObjectRepository.stppymnt_note);
		test.log(Status.INFO, "Note option clicked");
		Thread.sleep(2000);
		
		verifyElementPresent(ObjectRepository.stppymnt_notemsg);
		test.log(Status.INFO, "Note Message appearing");
		
		getElement(ObjectRepository.alrt_acntback).click();
		test.log(Status.INFO, "Back button clicked");
		Thread.sleep(2000);
		getElement(ObjectRepository.menu_btn).click();
		test.log(Status.INFO, "Menu link clicked");
		Thread.sleep(4000);		
		getElement(ObjectRepository.service_menu).click();
		test.log(Status.INFO, "Services menu clicked");
		Thread.sleep(4000);
		getElement(ObjectRepository.stppymnt_menu).click();
		test.log(Status.INFO, "Stop Payment Menu link clicked");
		Thread.sleep(4000);
		getElement(ObjectRepository.stppymnt_rqsttyp).click();
		test.log(Status.INFO, "Request Type option clicked");
		Thread.sleep(2000);	
		getElement(ObjectRepository.snglchk_optn).click();
		test.log(Status.INFO, "Single Check option selected");
		Thread.sleep(4000);
		
		clickElement(ObjectRepository.stppymnt_note);
		test.log(Status.INFO, "Note option clicked");
		Thread.sleep(2000);
		
		getElement(ObjectRepository.stppymnt_notetxt).sendKeys("Note Message");
		test.log(Status.INFO, "Note entered");
		Thread.sleep(2000);
		
		getElement(ObjectRepository.stppymnt_set).click();
		test.log(Status.INFO, "Set button clicked");
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
			test.log(Status.PASS, "Verify Multiple Check Stop Payment creation scenario working fine");
		}
	}
	
	@AfterTest
	public void tearDown(){
		driver.quit();
		stopAppium();
		extent.flush();
		
	}
}
