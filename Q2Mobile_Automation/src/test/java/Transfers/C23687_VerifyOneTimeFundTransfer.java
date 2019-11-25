package Transfers;

import java.io.IOException;

import javax.mail.MessagingException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
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

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;

public class C23687_VerifyOneTimeFundTransfer  extends GenericKeywords {

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
	public void C23687_VerifyOneTimeFundTransfer() throws InterruptedException
	{
		if(continuetestcase==true)
		{
			sheetName = "Data";
			int totalRowCount = excl.getRowCount(sheetName);
			for(startIter=1;startIter<=totalRowCount;startIter++) //It is mandatory to have this for loop in every test case
			 {	
				if(this.getClass().getSimpleName().equals(excl.getCellData(sheetName, 0, startIter)))
				 {
					String frmacnt=excl.getCellData(sheetName, 1, startIter);
					String toacnt=excl.getCellData(sheetName, 2, startIter);
					String amnt=excl.getCellData(sheetName, 3, startIter);
					
		Thread.sleep(20000);
	//Verify menu item option
		verifyElementPresent(ObjectRepository.menu_btn);
		test.log(Status.INFO, "Menu link appearing");
	
		getElement(ObjectRepository.menu_btn).click();
		test.log(Status.INFO, "Menu link clicked");
		Thread.sleep(4000);	
		
		getElement(ObjectRepository.trnsctn_menu).click();
		test.log(Status.INFO, "Transaction menu clicked");
		Thread.sleep(2000);	
		
		getElement(ObjectRepository.fndtrnsfr_menu).click();
		test.log(Status.INFO, "Fund Transfer menu clicked");
		Thread.sleep(2000);
		
		verifyElementPresent(ObjectRepository.fndtrnsfr_menu);
		test.log(Status.INFO, "Transfer title appeared");
		
		verifyElementPresent(ObjectRepository.fndtrnsfr_frm);
		test.log(Status.INFO, "From field appeared");
		
		verifyElementPresent(ObjectRepository.fndtrnsfr_to);
		test.log(Status.INFO, "To field appeared");
		
		verifyElementPresent(ObjectRepository.fndtrnsfr_amnt);
		test.log(Status.INFO, "Amount field appeared");
		
		verifyElementPresent(ObjectRepository.fndtrnsfr_dt);
		test.log(Status.INFO, "Date field appeared");
		
		getElement(ObjectRepository.fndtrnsfr_frm).click();
		Thread.sleep(2000);	
		
		getElement("//android.view.View[contains(@content-desc,'"+frmacnt+"')]").click();
		test.log(Status.INFO, "From Account selected");
		Thread.sleep(2000);	
		
		getElement(ObjectRepository.fndtrnsfr_to).click();
		Thread.sleep(5000);	
		
		getElement("//android.view.View[contains(@content-desc,'"+toacnt+"')]").click();
		test.log(Status.INFO, "To Account selected");
		Thread.sleep(2000);	
		
		getElement(ObjectRepository.fndtrnsfr_amnt).click();
		Thread.sleep(2000);	
		
//		JavascriptExecutor jse = (JavascriptExecutor)driver;
//		jse.executeScript("arguments[0].value='"+ amnt +"';", getElement(ObjectRepository.fndtrnsfr_amnt));
		
		//clickElement(ObjectRepository.fndtrnsfr_amnt);
		Thread.sleep(2000);	
		if (amnt.contains(".")){
			amnt=amnt.replace(".", "");
		//Submitamount(amnt, ObjectRepository.fndtrnsfr_amnt);
		}else{
			amnt=amnt+"00";
			
			//Submitamount(amnt, ObjectRepository.fndtrnsfr_amnt);
		}
		MobileElement ele=(MobileElement) getElement(ObjectRepository.fndtrnsfr_amnt);
		ele.setValue(amnt);
		test.log(Status.INFO, "Amount entered");
		Thread.sleep(2000);

		scrollToElement(1);
		Thread.sleep(2000);
	   		
	   	clickElement(ObjectRepository.trnsfrfnds_btn);	
	   	test.log(Status.INFO, "Fund Transfer button clicked");
		Thread.sleep(4000);
		
		verifyElementPresent(ObjectRepository.mtm_clsbtn);
		test.log(Status.INFO, "Close button appearing");
		Thread.sleep(4000);
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
			test.log(Status.PASS, "Verify One Time Fund Transfer Fields scenario working fine");
		}
	}
	
	@AfterTest
	public void tearDown(){
		driver.quit();
		stopAppium();
		extent.flush();
		
	}
}
