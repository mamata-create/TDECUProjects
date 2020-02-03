package Home;

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

public class C23452_VerifyAccountDetailTransactionSearchByAmountRange extends GenericKeywords {

	ExtentReports extent;
	ExtentTest test;
	/*
	 * Verify Account Detail transaction search by amount range
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
			/*	getElement(ObjectRepository.otpemail_btn).click();
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
	public void C23452_VerifyAccountDetailTransactionSearchByAmountRange() throws InterruptedException, MessagingException, IOException
	{
		if(continuetestcase==true)
		{
			sheetName = "Accounts";
			int totalRowCount = excl.getRowCount(sheetName);
			for(startIter=1;startIter<=totalRowCount;startIter++) 
			 {	
				if(this.getClass().getSimpleName().equals(excl.getCellData(sheetName, 0, startIter)))
				 {
					String acntNumber=excl.getCellData(sheetName, 1, startIter);
					String minamnt=excl.getCellData(sheetName, 5, startIter);
					String maxamnt=excl.getCellData(sheetName, 6, startIter);
					
					getElement("//span[@class='account-nbr' and contains(text(),'"+acntNumber+"')]").click();
					test.log(Status.INFO, "Account link clicked");
										
					verifyElementPresent(ObjectRepository.dtls_lnk);
					test.log(Status.INFO, "Details link available on account details page");
					
					getElement(ObjectRepository.acntdtl_shwfltr).click();
					test.log(Status.INFO, "Filter icon clicked to show filter options");
					
					WebElement minAmount_root1 = driver.findElement(By.cssSelector("q2-input[label='Min Amount']"));
					WebElement shadow_minAmount_root1 = ObjectRepository.expandRootElement(driver, minAmount_root1);
					WebElement min_amount_field = shadow_minAmount_root1.findElement(By.cssSelector("input[class='input-field']"));
					min_amount_field.sendKeys(minamnt);
					
					test.log(Status.INFO, "Min Amount entered");
					
					getElement(ObjectRepository.acntdtl_aplyfltr).click();
					test.log(Status.INFO, "Apply Filter button clicked");
					Thread.sleep(3000);
					test.log(Status.INFO, "Minimum Amount transactions searched");
					
					getElement(ObjectRepository.acntdtl_resetfltr).click();
					Thread.sleep(3000);
				//Max amount	
					
					WebElement maxAmount_root1 = driver.findElement(By.cssSelector("q2-input[label='Max Amount']"));
					WebElement shadow_maxAmount_root1 = ObjectRepository.expandRootElement(driver, maxAmount_root1);
					WebElement max_amount_field = shadow_maxAmount_root1.findElement(By.cssSelector("input[class='input-field']"));
					max_amount_field.sendKeys(minamnt);
					
					test.log(Status.INFO, "Max Amount entered");
					
					getElement(ObjectRepository.acntdtl_aplyfltr).click();
					test.log(Status.INFO, "Apply Filter button clicked");
					Thread.sleep(3000);
					test.log(Status.INFO, "Maximum Amount transactions searched");
					
					getElement(ObjectRepository.acntdtl_resetfltr).click();
					Thread.sleep(3000);
				//Amount range	
					min_amount_field.sendKeys(minamnt);
					max_amount_field.sendKeys(maxamnt);
					test.log(Status.INFO, "Min-Max range Amount entered");
					
					getElement(ObjectRepository.acntdtl_aplyfltr).click();
					test.log(Status.INFO, "Apply Filter button clicked");
					Thread.sleep(3000);
					test.log(Status.INFO, "Maximum Amount transactions searched");
					
					getElement(ObjectRepository.acntdtl_resetfltr).click();
					Thread.sleep(3000);
						
						
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
			test.log(Status.PASS, "Verify Account Detail transaction search by amount range scenario working fine");
		}
	}

	@AfterTest
	public void tearDown() {
		extent.flush();
		driver.quit();
	}

}
