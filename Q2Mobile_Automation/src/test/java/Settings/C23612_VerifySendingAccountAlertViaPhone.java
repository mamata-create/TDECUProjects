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

public class C23612_VerifySendingAccountAlertViaPhone extends GenericKeywords {

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
	public void C23612_VerifySendingAccountAlertViaPhone() throws InterruptedException
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
					String field=excl.getCellData(sheetName, 3, startIter);
					String cmprsn=excl.getCellData(sheetName, 4, startIter);
					String amnt=excl.getCellData(sheetName, 5, startIter);
					String dlvrymthd=excl.getCellData(sheetName, 6, startIter);
					String phone=excl.getCellData(sheetName, 12, startIter);
								
		Thread.sleep(20000);	
		verifyElementPresent(ObjectRepository.home_ttl);
		test.log(Status.INFO, "Home link appearing");
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
		
		verifyElementPresent(ObjectRepository.alrt_menu);
		test.log(Status.INFO, "Alerts page opened");
		
				
	//Select alert as account alert 
		getElement(ObjectRepository.alrttyp_dropdown).click();
		test.log(Status.INFO, "Alert type dropdown clicked");
		Thread.sleep(4000);
		
		getElement("//android.widget.CheckedTextView[@text='"+alerttype+"']").click();
		test.log(Status.INFO, "Account Alert type selected");
		Thread.sleep(6000);

		verifyElementPresent(ObjectRepository.acntalrt_ttl);
		test.log(Status.INFO, "Account alert page title appearing");
		
	//	Select account
		getElement(ObjectRepository.alrt_acnt).click();
		test.log(Status.INFO, "Alert account option clicked");
		Thread.sleep(4000);
		
		getElement("//android.view.View[contains(@content-desc,'"+acnt+"')]").click();
		test.log(Status.INFO, "Account selected");
		Thread.sleep(4000);
		
	//Select Field
		getElement(ObjectRepository.alrt_fld).click();
		test.log(Status.INFO, "Alert Field option clicked");
		Thread.sleep(4000);
		
		getElement("//android.view.View[contains(@content-desc,'"+field+"')]").click();
		test.log(Status.INFO, "Field selected");
		Thread.sleep(4000);
		
	//Select Comparison
		getElement(ObjectRepository.alrt_cmprsn).click();
		test.log(Status.INFO, "Alert Comparison option clicked");
		Thread.sleep(4000);
		
		getElement("//android.view.View[contains(@content-desc,'"+cmprsn+"')]").click();
		test.log(Status.INFO, "Comparison type selected");
		Thread.sleep(4000);
		
	//Enter amount
		getElement(ObjectRepository.alrt_amnt).click();
		test.log(Status.INFO, "Alert Amount option clicked");
		Thread.sleep(4000);
		
		verifyElementPresent(ObjectRepository.amnt_txt);
		test.log(Status.INFO, "Amount field appearing");
	
	
	//Set amount and save
		if(!amnt.contains(".")){
		getElement(ObjectRepository.amnt_txt).sendKeys(amnt);
		test.log(Status.INFO, "Alert Amount entered");
		Thread.sleep(2000);
		}else{
			getElement(ObjectRepository.amnt_txt).sendKeys(amnt+"00");
			test.log(Status.INFO, "Alert Amount entered");
			Thread.sleep(2000);
		}
		
		getElement(ObjectRepository.alrt_amntsv).click();
		test.log(Status.INFO, "Alert Amount save button clicked");
		Thread.sleep(2000);
		
	//Select Delivery Method
		getElement(ObjectRepository.alrt_dlvrymthd).click();
		test.log(Status.INFO, "Alert Delivery Method option clicked");
		Thread.sleep(4000);
		
		verifyElementPresent(ObjectRepository.alrt_dlvrymthd_ttl);
		test.log(Status.INFO, "Delivery MEthod Page title appearing");
		
		getElement(ObjectRepository.alrt_dlvrymthdtyp).click();
		test.log(Status.INFO, "Alert Delivery Method type dropdown clicked");
		Thread.sleep(4000);
		
		verifyElementPresent("//android.widget.CheckedTextView[@text='Email']");
		verifyElementPresent("//android.widget.CheckedTextView[@text='Phone']");
		verifyElementPresent("//android.widget.CheckedTextView[@text='Text Message']");
		test.log(Status.INFO, "Alert Delivery Method different options appearing");
		
		getElement("//android.widget.CheckedTextView[@text='"+dlvrymthd+"']").click();
		test.log(Status.INFO, "Delivery Method selected");
		Thread.sleep(4000);
		
//		getElement(ObjectRepository.alrt_msgtxt).sendKeys("sravyavagalaboina.com");
//		Assert.assertFalse(getElement(ObjectRepository.alrt_donebtn).isEnabled());
//		test.log(Status.INFO, "Done button disabled when email without @ provided");
//		Thread.sleep(4000);
		
		String callimdt=getElement(ObjectRepository.alrt_callimdt).getAttribute("checked");
		Assert.assertTrue(callimdt.equalsIgnoreCase("true"));
		test.log(Status.INFO, "By default Call Immediately field checked");
		Thread.sleep(2000);
		
		getElement(ObjectRepository.alrt_phone).sendKeys(phone);
		test.log(Status.INFO, "Valid Phone provided");
		Thread.sleep(2000);
		
		getElement(ObjectRepository.alrt_callimdt).click();
		test.log(Status.INFO, "Call Immediately field Unchecked");
		Thread.sleep(2000);
		
		getElement(ObjectRepository.alrt_hour).click();
		test.log(Status.INFO, "Hour spinner opened");
		Thread.sleep(2000);
		
		getElement("//android.widget.CheckedTextView[@text='07']").click();
		test.log(Status.INFO, "Hour selected");
		Thread.sleep(2000);
		
		getElement(ObjectRepository.alrt_min).click();
		test.log(Status.INFO, "Minute spinner opened");
		Thread.sleep(2000);
		
		getElement("//android.widget.CheckedTextView[@text='30']").click();
		test.log(Status.INFO, "Minute selected");
		Thread.sleep(2000);
		
		getElement(ObjectRepository.alrt_ampm).click();
		test.log(Status.INFO, "AM/PM spinner opened");
		Thread.sleep(2000);
		
		getElement("//android.widget.CheckedTextView[@text='AM']").click();
		test.log(Status.INFO, "AM selected");
		Thread.sleep(2000);
		
		getElement(ObjectRepository.alrt_donebtn).click();
		test.log(Status.INFO, "Done button clicked");
		Thread.sleep(4000);
		
		

	//Verify Occurence field	
		String frqncy=getElement(ObjectRepository.alrt_occrnc).getAttribute("checked");
		Assert.assertTrue(frqncy.equalsIgnoreCase("true"));
		test.log(Status.INFO, "By default Every occurence field checked");
		
		
	//Save the alert
		getElement(ObjectRepository.alrt_svbtn).click();
		test.log(Status.INFO, "Save button clicked");
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
			test.log(Status.PASS, "Verify Sending Account Alert via Phone scenario working fine");
		}
	}
	
	@AfterTest
	public void tearDown(){
		driver.quit();
		stopAppium();
		extent.flush();
		
	}
}
