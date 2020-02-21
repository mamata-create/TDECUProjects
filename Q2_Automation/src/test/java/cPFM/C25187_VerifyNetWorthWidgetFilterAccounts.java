package cPFM;

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

public class C25187_VerifyNetWorthWidgetFilterAccounts  extends GenericKeywords {

	ExtentReports extent;
	ExtentTest test;
	/*
	 * Verify Net Worth widget Filter Accounts
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
	public void C25187_VerifyNetWorthWidgetFilterAccounts() throws InterruptedException, MessagingException, IOException
	{
		if(continuetestcase==true)
		{
			sheetName = "cPFM";
			int totalRowCount = excl.getRowCount(sheetName);
			for(startIter=1;startIter<=totalRowCount;startIter++) //It is mandatory to have this for loop in every test case
			 {	
				if(this.getClass().getSimpleName().equals(excl.getCellData(sheetName, 0, startIter)))
				 {
					String widget=excl.getCellData(sheetName, 1, startIter);
					
					
					
				Thread.sleep(4000);
				verifyElementPresent(ObjectRepository.netwrth_tab);
				test.log(Status.INFO, "Net Worth widget tab appeared");
				
			getElement(ObjectRepository.netwrth_tab).click();
			test.log(Status.INFO, "Net Worth widget tab clicked");
			Thread.sleep(5000);

			driver.switchTo().frame(getElement(ObjectRepository.asst_frame));
			
			getElement(ObjectRepository.netwrth_ftr).click();
			test.log(Status.INFO, "Filter Account link clicked");
			Thread.sleep(2000);
					
			getElement("//p[contains(text(),'"+widget+"')]").click();
			test.log(Status.INFO, "Net Worth widget acount deselected ");
			Thread.sleep(2000);
			
			getElement(ObjectRepository.netwrth_appyfltr).click();
			test.log(Status.INFO, "Apply Filter Account link clicked");
			Thread.sleep(2000);
			
			getElement(ObjectRepository.netwrth_ftr).click();
			test.log(Status.INFO, "Filter Account link clicked");
			Thread.sleep(2000);
					
			getElement("//p[contains(text(),'"+widget+"')]").click();
			test.log(Status.INFO, "Net Worth widget acount deselected ");
			Thread.sleep(2000);
			
			getElement(ObjectRepository.netwrth_appyfltr).click();
			test.log(Status.INFO, "Apply Filter Account link clicked");
			Thread.sleep(2000);
			
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
			test.log(Status.PASS, "Verify Net Worth widget Filter Accounts scenario working fine");
		}
	}

	@AfterTest
	public void tearDown() {
		extent.flush();
		driver.quit();
	}

}
