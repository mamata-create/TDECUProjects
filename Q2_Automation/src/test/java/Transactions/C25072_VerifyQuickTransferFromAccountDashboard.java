package Transactions;

import java.io.IOException;

import javax.mail.MessagingException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
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

public class C25072_VerifyQuickTransferFromAccountDashboard  extends GenericKeywords {

	ExtentReports extent;
	ExtentTest test;
	/*
	 * Verify quick transfer from account dashboard
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
	public void C25072_VerifyQuickTransferFromAccountDashboard() throws InterruptedException, MessagingException, IOException
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
			
				WebElement account_root1 = getElement(ObjectRepository.acntgroup);
				WebElement shadow_accountroot = ObjectRepository.expandRootElement(driver, account_root1);
				shadow_accountroot.findElement(By.xpath("//span[@class='account-nbr' and text()='*00824']/parent::*/parent::*/parent::*/parent::*/parent::*//button[@test-id='btnUIDropdownToggle']")).click();
				
				
				getElement(ObjectRepository.quicktrnsfr_menu).click();
			test.log(Status.INFO, "Quick Transfer option clicked");
			
			verifyElementPresent(ObjectRepository.quicktrnsfr_ttl);
			test.log(Status.INFO, "Quick Transfer popup opened");
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
			test.log(Status.PASS, "Verify quick transfer from account dashboard scenario working fine");
		}
	}

	@AfterTest
	public void tearDown() {
		extent.flush();
		driver.quit();
	}

}
