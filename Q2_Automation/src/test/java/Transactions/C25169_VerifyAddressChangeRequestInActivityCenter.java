package Transactions;

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

public class C25169_VerifyAddressChangeRequestInActivityCenter  extends GenericKeywords {

	ExtentReports extent;
	ExtentTest test;
	/*
	 * Verify address change request in activity center
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
				
				
				//Verify log off link available after login
				verifyElementPresent(ObjectRepository.logoff_lnk);
				test.log(Status.INFO, "User successfully logged in as Logoff link available");
		
	}

	@Test
	public void C25169_VerifyAddressChangeRequestInActivityCenter() throws InterruptedException, MessagingException, IOException
	{

		if(continuetestcase==true)
		{
			sheetName = "Transactions";
			int totalRowCount = excl.getRowCount(sheetName);
			for(startIter=1;startIter<=totalRowCount;startIter++) //It is mandatory to have this for loop in every test case
			 {	
				if(this.getClass().getSimpleName().equals(excl.getCellData(sheetName, 0, startIter)))
				 {
					String acntnmbr=excl.getCellData(sheetName, 1, startIter);
					String scndacntnmbr=excl.getCellData(sheetName, 2, startIter);
					String workphone=excl.getCellData(sheetName, 3, startIter)+getRandom();
					String cellphone=excl.getCellData(sheetName, 4, startIter)+getRandom();
					
				Thread.sleep(15000);
			
			
//			verifyElementPresent(ObjectRepository.menu_btn);
//			test.log(Status.INFO, "Menu button appearing on the page");
//			
//			getElement(ObjectRepository.menu_btn).click();
//			test.log(Status.INFO, "Menu button clicked");	
//			Thread.sleep(5000);
			
			getElement(ObjectRepository.sttng_menu).click();
			test.log(Status.INFO, "Settings menu clicked");
			
			getElement(ObjectRepository.addrschange_menu).click();
			test.log(Status.INFO, "Address change menu clicked");
			
			verifyElementPresent(ObjectRepository.addrschange_ttl);
			test.log(Status.INFO, "Address change page title appeared");
			
			getElement("//label[contains(text(),'"+acntnmbr+"')]").click();
			test.log(Status.INFO, "First Account Number selected");
			
			getElement("//label[contains(text(),'"+scndacntnmbr+"')]").click();
			test.log(Status.INFO, "Second Account Number selected");
			
			getElement(ObjectRepository.workphone_txt).sendKeys(workphone);
			test.log(Status.INFO, "Work Phone number entered");
			
			getElement(ObjectRepository.cellphone_txt).sendKeys(cellphone);
			test.log(Status.INFO, "Cell Phone number entered");
			
			getElement(ObjectRepository.addrssubmit_btn).click();
			test.log(Status.INFO, "Submit button clicked");
			
			verifyElementPresent(ObjectRepository.addrschange_sccs);
			test.log(Status.INFO, "Address change success message appeared");
			
			getElement(ObjectRepository.viewwactvtycntr_btn).click();
			test.log(Status.INFO, "View in Activity center button clicked");
			
			verifyElementPresent(ObjectRepository.actvtyrow);
			test.log(Status.INFO, "Address change request appeared in activity center");
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
			test.log(Status.PASS, "Verify Debt Account debit transaction scenario working fine");
		}
	}

	@AfterTest
	public void tearDown() {
		extent.flush();
		driver.quit();
	}

}
