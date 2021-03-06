package Alerts;

import java.io.IOException;

import javax.mail.MessagingException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
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

public class C23469_VerifyAlertsSetup extends GenericKeywords {

	ExtentReports extent;
	ExtentTest test;
	/*
	 * Verify alert SetUp
	 * 
	 */

	@BeforeTest
	public void setUp() throws InterruptedException, MessagingException, IOException {
		extent = ExtentManager.GetExtent();
		test = extent.createTest(this.getClass().getSimpleName());
		BaseClass iDriver = new BaseClass();
		iDriver.myTestCaseName = this.getClass().getSimpleName();
		executeDriverScript();
		test.log(Status.INFO, "Application url navigated");
		//enter loginId
				getElement(ObjectRepository.loginid_txt).sendKeys(username);
				test.log(Status.INFO, "Login ID entered");
				
				//enter password
				getElement(ObjectRepository.password_txt).sendKeys(password);
				test.log(Status.INFO, "Password entered");
				
				//click login button
				getElement(ObjectRepository.login_btn).click();
				test.log(Status.INFO, "Login button clicked");
				
				//click login button
				/*getElement(ObjectRepository.otpemail_btn).click();
				test.log(Status.INFO, "Send OTP to email button clicked");
				Thread.sleep(15000);
				
				getElement(ObjectRepository.otp_txt).sendKeys(fetchOutlookOTP());
				test.log(Status.INFO, "Login ID entered");
				
				
				getElement(ObjectRepository.submit_btn).click();
				test.log(Status.INFO, "Send OTP to email button clicked");
				Thread.sleep(7000);
				
				try{
					if(getElement(ObjectRepository.register_btn).isDisplayed()){
						getElement(ObjectRepository.register_btn).click();
						test.log(Status.INFO, "Register device button clicked");
						Thread.sleep(7000);
					}
					}catch(Exception e){
						test.log(Status.INFO, "Register device button not available to be clicked");
					}*/
				//Verify log off link available after login
				verifyElementPresent(ObjectRepository.logoff_lnk);
				test.log(Status.INFO, "User successfully logged in as Logoff link available");
		
	}

	@Test
	public void C23469_VerifyAlertsSetup() throws InterruptedException, MessagingException, IOException
	{

		if(continuetestcase==true)
		{
			sheetName = "Alerts";
			int totalRowCount = excl.getRowCount(sheetName);
			for(startIter=1;startIter<=totalRowCount;startIter++) //It is mandatory to have this for loop in every test case
			 {	
				if(this.getClass().getSimpleName().equals(excl.getCellData(sheetName, 0, startIter)))
				 {
					String alrtopts=excl.getCellData(sheetName, 1, startIter);
					String alrt_typ=excl.getCellData(sheetName, 2, startIter);
					String msg=excl.getCellData(sheetName, 3, startIter);
					String cntry=excl.getCellData(sheetName, 4, startIter);
					String phone2=excl.getCellData(sheetName, 5, startIter);
					String phone=excl.getCellData(sheetName, 6, startIter);
					String errorField1=excl.getCellData(sheetName, 7, startIter);
					String errorField2=excl.getCellData(sheetName, 8, startIter);
					String SMSerror=excl.getCellData(sheetName, 9, startIter);
					
				
				//Click Settings Menu
					getElement(ObjectRepository.stng_menu).click();
					test.log(Status.INFO, "Settings menu clicked");
					
					getElement(ObjectRepository.alrt_menu).click();
					test.log(Status.INFO, "Alerts menu clicked");
				//Verify Alerts page title
					verifyElementPresent(ObjectRepository.alrt_ttl);
					test.log(Status.INFO, "Alerts page opened and title available");
					
					selectValue(ObjectRepository.alrtopts_drop,ObjectRepository.alrtTypes, alrtopts);
					test.log(Status.INFO, "Alerts type selected");
					
					Thread.sleep(1000);
					getElement(ObjectRepository.alrtBackLink).click();
					test.log(Status.INFO, "Back to Alerts clicked");
					selectValue(ObjectRepository.alrtopts_drop,ObjectRepository.alrtTypes, alrtopts);
					
					Thread.sleep(1000);
					getElement(ObjectRepository.alrt_svbtn).click();
					verifyAlrtErrMsg(errorField1, errorField2);
					test.log(Status.INFO, "Save button clicked, error message displayed");
									
					selectValue(ObjectRepository.alrtsel_typ,ObjectRepository.alrtEvents, alrt_typ);
					test.log(Status.INFO, "Event selected");
					
					selectTodayShadowRootCal(-1);
					test.log(Status.INFO, "Date selected");
					
					Boolean recursYearly = getElement(ObjectRepository.alrt_rccryr).isSelected();
					if(recursYearly == true){
						Assert.assertTrue(recursYearly);
					}
					getElement(ObjectRepository.alrt_rccryr).click();
					Boolean recursUpdated = getElement(ObjectRepository.alrt_rccryr).isSelected();
					if(!recursUpdated){						
						Assert.assertTrue(true);						
					}
					else{
						Assert.assertTrue(false);
					}
					test.log(Status.INFO, "Recurr every year checkbox verified");
					
					enterText(ObjectRepository.alrt_msg,msg);
					test.log(Status.INFO, "Alerts message entered");
					
					verifyElementPresent(ObjectRepository.alrtsel_dlvryEmail);
					verifyElementPresent(ObjectRepository.alrtsel_dlvryVoice);
					verifyElementPresent(ObjectRepository.alrtsel_dlvryText);
					verifyElementPresent(ObjectRepository.alrtsel_dlvrymsg);
					getElement(ObjectRepository.alrtsel_dlvryText).click();
					test.log(Status.INFO, "Delivery method selected");
					
					selectValue(ObjectRepository.alrt_cntry,ObjectRepository.countryList, cntry);
					test.log(Status.INFO, "Country selected");
					
					getElement(ObjectRepository.alrtTermsLink).click();
					verifyElementPresent(ObjectRepository.SMStermsTitle);
					getElement(ObjectRepository.alrt_clsbtn).click();
					test.log(Status.INFO, "Terms and Conditions displayed");
					
					getElement(ObjectRepository.alrt_acpttrms).click();
					test.log(Status.INFO, "Accept term & Conditions");
					
					enterText(ObjectRepository.alrt_phone,phone2);
					getElement(ObjectRepository.alrt_svbtn).click();		
					verifyText(ObjectRepository.modalTxt,SMSerror);
					getElement(ObjectRepository.alrt_clsbtn).click();
					test.log(Status.INFO, "Phone number field validated");
					
					enterText(ObjectRepository.alrt_phone,phone);
					test.log(Status.INFO, "Phone number entered");
					
					getElement(ObjectRepository.alrt_svbtn).click();
					test.log(Status.INFO, "Alert save button clicked");
					Thread.sleep(2000);
					
					verifyElementPresent(ObjectRepository.alrt_svsccs);
					test.log(Status.INFO, "Alert save success available");
					
					getElement(ObjectRepository.alrt_clsbtn).click();
					test.log(Status.INFO, "Alert close button clicked");
					
				 }
			 }
			
		}
				
	}

	@AfterMethod
	public void afterMethod(ITestResult result) throws Throwable {
		if (result.getStatus() == ITestResult.FAILURE) {
			test.log(Status.FAIL, "Test Failed-" + result.getThrowable());

			takescreenshot(this.getClass().getSimpleName(), test);
		} else {
			test.log(Status.PASS, "Verify SMS text reminder setup working fine");
		}
	}

	@AfterTest
	public void tearDown() {
		extent.flush();
		driver.quit();
	}

}
