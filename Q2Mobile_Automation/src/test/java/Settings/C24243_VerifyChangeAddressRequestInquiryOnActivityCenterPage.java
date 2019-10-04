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

public class C24243_VerifyChangeAddressRequestInquiryOnActivityCenterPage extends GenericKeywords {

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
	public void C24243_VerifyChangeAddressRequestInquiryOnActivityCenterPage() throws InterruptedException
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
		
		getElement("//android.view.View[contains(@content-desc,'"+acnt+"')]").click();
		test.log(Status.INFO, "Account selected");
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
		Thread.sleep(6000);	
		
		verifyElementPresent(ObjectRepository.actvtycntr_ttl);
		test.log(Status.INFO, "View Activity page opened");
		
		verifyElementPresent(ObjectRepository.actvtycntr_addrschng);
		test.log(Status.INFO, "Address change request appearing on the activity center page");
		
		getElement(ObjectRepository.actvtycntr_addrschng).click();
		test.log(Status.INFO, "Address Change Request selected");
		Thread.sleep(4000);	
		
		getElement(ObjectRepository.actns_lnk).click();
		test.log(Status.INFO, "Actions link clicked");
		Thread.sleep(4000);	
		
		getElement(ObjectRepository.inqr_lnk).click();
		test.log(Status.INFO, "Inquire link clicked");
		Thread.sleep(4000);	
		
		getElement(ObjectRepository.otp_txt).sendKeys("Inquiry message");
		test.log(Status.INFO, "Inquire message entered");
		Thread.sleep(4000);	
		
		getElement(ObjectRepository.snd_btn).click();
		test.log(Status.INFO, "Send button clicked");
		Thread.sleep(4000);
		
		verifyElementPresent(ObjectRepository.inqr_msg);
		test.log(Status.INFO, "Inquiry success message appearing");
		
		
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
			test.log(Status.PASS, "Verify change address request inquiry on Activity Center page scenario working fine");
		}
	}
	
	@AfterTest
	public void tearDown(){
		driver.quit();
		stopAppium();
		extent.flush();
		
	}
}
