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

public class C23609_VerifyOnlineTransactionAlertSetup extends GenericKeywords {

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
	public void C23609_VerifyOnlineTransactionAlertSetup() throws InterruptedException
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
					String acnt=excl.getCellData(sheetName, 2, startIter);

					String stts=excl.getCellData(sheetName, 4, startIter);
					String amnt=excl.getCellData(sheetName, 5, startIter);
					String dlvrymthd=excl.getCellData(sheetName, 6, startIter);
					String trnsctn=excl.getCellData(sheetName, 7, startIter);
								
		Thread.sleep(30000);	
//		verifyElementPresent(ObjectRepository.home_ttl);
//		test.log(Status.INFO, "Home link appearing");
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
		
	//Select alert as history alert 
		getElement(ObjectRepository.alrttyp_dropdown).click();
		test.log(Status.INFO, "Alert type dropdown clicked");
		Thread.sleep(4000);
		
		getElement("//android.view.View[@content-desc='"+alerttype+"']").click();
		test.log(Status.INFO, "Online Transaction Alert type selected");
		Thread.sleep(4000);

		verifyElementPresent(ObjectRepository.onlntrnstcnalrt_ttl);
		test.log(Status.INFO, "Online Transaction alert page title appearing");
	//Back button clicked	
//		getElement(ObjectRepository.back_btn).click();
//		test.log(Status.INFO, "Back button clicked");
//		Thread.sleep(4000);
//		
//		verifyElementPresent(ObjectRepository.alrt_menu);
//		test.log(Status.INFO, "Alerts page opened");
//	//select account alert type again	
//		getElement(ObjectRepository.alrttyp_dropdown).click();
//		test.log(Status.INFO, "Alert type dropdown clicked");
//		Thread.sleep(4000);
//		
//		getElement("//android.widget.CheckedTextView[@text='"+alerttype+"']").click();
//		test.log(Status.INFO, "Online TRansaction Alert type selected");
//		Thread.sleep(4000);
//
//		verifyElementPresent(ObjectRepository.onlntrnstcnalrt_ttl);
//		test.log(Status.INFO, "Online Transaction alert page title appearing");
		
		
	//Select transaction
		
//		verifyElementPresent(ObjectRepository.alrt_notrnsctn);
//		test.log(Status.INFO, "No transaction messages appearing");
		
		getElement(ObjectRepository.alrt_trnsctn).click();
		test.log(Status.INFO, "Alert Transaction option clicked");
		Thread.sleep(4000);
		
		verifyElementPresent("//android.view.View[contains(@content-desc,'Domestic Wire')]");
		verifyElementPresent("//android.view.View[contains(@content-desc,'External Transfer')]");
		verifyElementPresent("//android.view.View[contains(@content-desc,'Funds Transfer')]");
		verifyElementPresent("//android.view.View[contains(@content-desc,'Stop Payment')]");
		test.log(Status.INFO, "Transaction different options appearing");
		
//		getElement(ObjectRepository.alrt_acntback).click();
//		test.log(Status.INFO, "Back button clicked");
//		Thread.sleep(4000);
//		
//		getElement(ObjectRepository.alrt_trnsctn).click();
//		test.log(Status.INFO, "Alert Transaction option again clicked");
//		Thread.sleep(4000);
		
		getElement("//android.view.View[contains(@content-desc,'"+trnsctn+"')]").click();
		test.log(Status.INFO, "Transaction selected");
		Thread.sleep(4000);
		
//		Select account
			getElement(ObjectRepository.alrt_acnt).click();
			test.log(Status.INFO, "Alert account option clicked");
			Thread.sleep(4000);
			
//			getElement(ObjectRepository.alrt_acntback).click();
//			test.log(Status.INFO, "Back button clicked");
//			Thread.sleep(4000);
//			
//			getElement(ObjectRepository.alrt_acnt).click();
//			test.log(Status.INFO, "Alert account option clicked");
//			Thread.sleep(4000);
			
			getElement("//android.view.View[contains(@content-desc,'"+acnt+"')]").click();
			test.log(Status.INFO, "Account selected");
			Thread.sleep(6000);
		
		
	//Select Status
		getElement(ObjectRepository.alrt_stts).click();
		test.log(Status.INFO, "Alert Status option clicked");
		Thread.sleep(4000);
		
		verifyElementPresent("//android.view.View[contains(@content-desc,'Authorized')]");
		verifyElementPresent("//android.view.View[contains(@content-desc,'Cancelled')]");
		verifyElementPresent("//android.view.View[contains(@content-desc,'Drafted')]");
		verifyElementPresent("//android.view.View[contains(@content-desc,'Failed')]");
		verifyElementPresent("//android.view.View[contains(@content-desc,'Processed')]");
		test.log(Status.INFO, "Status different options appearing");
		
//		getElement(ObjectRepository.alrt_acntback).click();
//		test.log(Status.INFO, "Back button clicked");
//		Thread.sleep(6000);
		
		getElement("//android.view.View[contains(@content-desc,'"+stts+"')]").click();
		test.log(Status.INFO, "Status type selected");
		Thread.sleep(4000);
		
		
	//Select Delivery Method
//		getElement(ObjectRepository.alrt_dlvrymthd).click();
//		test.log(Status.INFO, "Alert Delivery Method option clicked");
//		Thread.sleep(4000);
		
		verifyElementPresent(ObjectRepository.alrt_dlvrymthd_ttl);
		test.log(Status.INFO, "Delivery MEthod Page title appearing");
		
//		getElement(ObjectRepository.alrt_dlvrymthdtyp).click();
//		test.log(Status.INFO, "Alert Delivery Method type dropdown clicked");
//		Thread.sleep(4000);
		
		verifyElementPresent("//android.widget.RadioButton[@content-desc='Email']");
		verifyElementPresent("//android.widget.RadioButton[@content-desc='Voice']");
		verifyElementPresent("//android.widget.RadioButton[@content-desc='SMS Text Message']");
		test.log(Status.INFO, "Alert Delivery Method different options appearing");
		
		getElement("//android.widget.RadioButton[@content-desc='"+dlvrymthd+"']").click();
		test.log(Status.INFO, "Delivery Method selected");		


	//Verify Occurence field	
//		String frqncy=getElement(ObjectRepository.alrt_occrnc).getAttribute("checked");
//		Assert.assertTrue(frqncy.equalsIgnoreCase("true"));
//		test.log(Status.INFO, "By default Every occurence field checked");
//		
//		getElement(ObjectRepository.alrt_occrnc).click();
//		test.log(Status.INFO, "Every occurence check box clicked");
//		
		
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
			test.log(Status.PASS, "Verify Online Transaction Alert Setup scenario working fine");
		}
	}
	
	@AfterTest
	public void tearDown(){
		driver.quit();
		stopAppium();
		extent.flush();
		
	}
}
