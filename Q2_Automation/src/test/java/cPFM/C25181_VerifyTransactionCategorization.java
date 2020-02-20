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

public class C25181_VerifyTransactionCategorization extends GenericKeywords {

	ExtentReports extent;
	ExtentTest test;
	/*
	 * Verify transaction categorization 
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
	public void C25181_VerifyTransactionCategorization() throws InterruptedException, MessagingException, IOException
	{
		if(continuetestcase==true)
		{
			sheetName = "cPFM";
			int totalRowCount = excl.getRowCount(sheetName);
			for(startIter=1;startIter<=totalRowCount;startIter++) //It is mandatory to have this for loop in every test case
			 {	
				if(this.getClass().getSimpleName().equals(excl.getCellData(sheetName, 0, startIter)))
				 {
					String options=excl.getCellData(sheetName, 1, startIter);
					String acntnmbr="*"+excl.getCellData(sheetName, 2, startIter);
					
				Thread.sleep(15000);
			verifyElementPresent("//span[@class='account-nbr' and text()='"+acntnmbr+"']");
			test.log(Status.INFO, "Account appearing on the page");
			
			getElement("//span[@class='account-nbr' and text()='"+acntnmbr+"']").click();
			test.log(Status.INFO, "Account selected to view account detail page");
			
			Thread.sleep(5000);
			scroll();
			
			getElement(ObjectRepository.trnsctn_optmenu).click();
			test.log(Status.INFO, "transactions option menu clicked");
			Thread.sleep(2000);

			getElement(ObjectRepository.splt_opt).click();
			test.log(Status.INFO, "Split transactions option menu clicked");
			Thread.sleep(2000);
					
			getElement(ObjectRepository.splt_inpt).sendKeys("20");
			test.log(Status.INFO, "Split amount entered");
			Thread.sleep(2000);
			
			getElement(ObjectRepository.sv_chk).click();
			test.log(Status.INFO, "Save button clicked");
			Thread.sleep(2000);
			
			scrollToElement(ObjectRepository.trnsctn_optmenu);
			getElement(ObjectRepository.trnsctn_optmenu).click();
			test.log(Status.INFO, "transactions option menu clicked");
			Thread.sleep(2000);
			
			getElement(ObjectRepository.ctgrz_opt).click();
			test.log(Status.INFO, "Split transactions option menu clicked");
			Thread.sleep(2000);
			
			getElement(ObjectRepository.notsclctd_ctgry).click();
			test.log(Status.INFO, "Non selected category selected");
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
			test.log(Status.PASS, "Verify transaction categorization scenario working fine");
		}
	}

	@AfterTest
	public void tearDown() {
		extent.flush();
		driver.quit();
	}

}
