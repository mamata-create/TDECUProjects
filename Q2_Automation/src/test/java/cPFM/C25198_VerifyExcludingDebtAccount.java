package cPFM;

import java.io.IOException;

import javax.mail.MessagingException;

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

public class C25198_VerifyExcludingDebtAccount extends GenericKeywords {

	ExtentReports extent;
	ExtentTest test;
	/*
	 * Verify excluding debt account
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
	public void C25198_VerifyExcludingDebtAccount() throws InterruptedException, MessagingException, IOException
	{
		if(continuetestcase==true)
		{
			sheetName = "cPFM";
			int totalRowCount = excl.getRowCount(sheetName);
			for(startIter=1;startIter<=totalRowCount;startIter++) //It is mandatory to have this for loop in every test case
			 {	
				if(this.getClass().getSimpleName().equals(excl.getCellData(sheetName, 0, startIter)))
				 {
					String acnt=excl.getCellData(sheetName, 1, startIter);
					
	
				Thread.sleep(4000);
				verifyElementPresent(ObjectRepository.debts_tab);
				test.log(Status.INFO, "Debts tab appeared");
				
			getElement(ObjectRepository.debts_tab).click();
			test.log(Status.INFO, "Debts tab clicked");
			Thread.sleep(5000);

			driver.switchTo().frame(getElement(ObjectRepository.asst_frame));
			
			getElement("//div[text()='"+acnt+"']").click();
			test.log(Status.INFO, "Debts account clicked");
			Thread.sleep(3000);
			
			getElement(ObjectRepository.acntactn_menu).click();
			test.log(Status.INFO, "Debts acount action menu clicked");
			Thread.sleep(2000);
			
			getElement(ObjectRepository.hideacnt_btn).click();
			test.log(Status.INFO, "Hide Account option selected");
			
			Thread.sleep(2000);
			getElement(ObjectRepository.debtacnt_back).click();
			test.log(Status.INFO, "Debts acount detail back button clicked");
			Thread.sleep(2000);
			
			String excld="This account is excluded from debts, Account: "+acnt;
			verifyElementPresent("//button[contains(@aria-label,'"+excld+"')]");
			test.log(Status.INFO, "Debt Account excluded");
			
			getElement("//div[text()='"+acnt+"']").click();
			test.log(Status.INFO, "Debts account clicked");
			Thread.sleep(3000);
			
			getElement(ObjectRepository.acntactn_menu).click();
			test.log(Status.INFO, "Debts acount action menu clicked");
			Thread.sleep(2000);
			
			getElement(ObjectRepository.showacnt_btn).click();
			test.log(Status.INFO, "Show Account option selected");
			
			Thread.sleep(2000);
			getElement(ObjectRepository.debtacnt_back).click();
			test.log(Status.INFO, "Debts acount detail back button clicked");
			Thread.sleep(2000);
			
			 excld="More details available, Account: "+acnt;
			verifyElementPresent("//button[contains(@aria-label,'"+excld+"')]");
			test.log(Status.INFO, "Debt Account included");
			
			
			
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
			test.log(Status.PASS, "Verify excluding debt account scenario working fine");
		}
	}

	@AfterTest
	public void tearDown() {
		extent.flush();
		driver.quit();
	}

}
