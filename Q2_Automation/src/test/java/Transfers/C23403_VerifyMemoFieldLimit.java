package Transfers;

import java.io.IOException;

import javax.mail.MessagingException;

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

public class C23403_VerifyMemoFieldLimit extends GenericKeywords {

	ExtentReports extent;
	ExtentTest test;
	/*
	 * Verify Memo Field Limit
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
				
//				//click login button
//				getElement(ObjectRepository.otpemail_btn).click();
//				test.log(Status.INFO, "Send OTP to email button clicked");
//				Thread.sleep(15000);
//				
//				getElement(ObjectRepository.otp_txt).sendKeys(fetchOutlookOTP());
//				test.log(Status.INFO, "Login ID entered");
//				
//				
//				getElement(ObjectRepository.submit_btn).click();
//				test.log(Status.INFO, "Send OTP to email button clicked");
//				Thread.sleep(7000);
//				
//				try{
//					if(getElement(ObjectRepository.register_btn).isDisplayed()){
//						getElement(ObjectRepository.register_btn).click();
//						test.log(Status.INFO, "Register device button clicked");
//						Thread.sleep(7000);
//					}
//					}catch(Exception e){
//						test.log(Status.INFO, "Register device button not available to be clicked");
//					}
				
				//Verify log off link available after login
				verifyElementPresent(ObjectRepository.logoff_lnk);
				test.log(Status.INFO, "User successfully logged in as Logoff link available");
		
	}

	@Test
	public void C23403_VerifyMemoFieldLimit() throws InterruptedException, MessagingException, IOException
	{
		
		if(continuetestcase==true)
		{
			sheetName = "Data";
			int totalRowCount = excl.getRowCount(sheetName);
			for(startIter=1;startIter<=totalRowCount;startIter++) //It is mandatory to have this for loop in every test case
			 {	
				if(this.getClass().getSimpleName().equals(excl.getCellData("Data", 0, startIter)))
				 {
					String frmacnt=excl.getCellData(sheetName, 1, startIter);
					String toacnt=excl.getCellData(sheetName, 2, startIter);
					String amnt=excl.getCellData(sheetName, 3, startIter);
					String memo=excl.getCellData(sheetName, 4, startIter);
					
					getElement(ObjectRepository.trnsctn_menu).click();
					test.log(Status.INFO, "Transaction menu clicked");
					
					getElement(ObjectRepository.fndtrnsfr_menu).click();
					test.log(Status.INFO, "Fund Transfer menu clicked");
					
					verifyElementPresent(ObjectRepository.fndtrnsfr_ttl);
					test.log(Status.INFO, "Fund Transfer page opened");
					
					Assert.assertFalse(getElement(ObjectRepository.trnsfrfnds_btn).isEnabled());
					test.log(Status.INFO, "Transfer Funds button disabled");
					
					selectDropdownOptContain(ObjectRepository.frmacnt_dropdown, frmacnt);
					test.log(Status.INFO, "From Account selected");
		
					selectDropdownOptContain(ObjectRepository.toacnt_dropdown, toacnt);
					test.log(Status.INFO, "To Account selected");
					
					getElement(ObjectRepository.amnt_txt).sendKeys(amnt);
					test.log(Status.INFO, "Amount entered");
					
				//Verify Transfer funds button enabled when memo field is blank
					Assert.assertTrue(getElement(ObjectRepository.trnsfrfnds_btn).isEnabled());
					test.log(Status.INFO, "Fund Transfer button enabled even when memo field blank");
					
				//Verify Special characters not allowed in memo field
					getElement(ObjectRepository.memo_txt).sendKeys("@#$%^&*");
					getElement(ObjectRepository.memo_txt).sendKeys(Keys.TAB);
					
					String memovalue=getElement(ObjectRepository.memo_txt).getText();
					Assert.assertTrue(memovalue.equals(""));
					test.log(Status.INFO, "Special characters not allowed in memo field");
					
					
				//Verify 49 characters allowed in memo field
					getElement(ObjectRepository.memo_txt).sendKeys(memo.substring(0, memo.length()-2));
					getElement(ObjectRepository.memo_txt).sendKeys(Keys.TAB);
					
					 memovalue=getElement(ObjectRepository.memo_txt).getText();
					if(memovalue.length()==49){
						Assert.assertTrue(true);
						test.log(Status.INFO, "49 characters allowed in memo field");
					}else{
						test.log(Status.INFO, "49 characters not allowed in memo field");
					}
					
				//Verify more than 50 characters not allowed in memo field	
					getElement(ObjectRepository.memo_txt).clear();
					getElement(ObjectRepository.memo_txt).sendKeys(memo);
					test.log(Status.INFO, "Memo entered");
					getElement(ObjectRepository.memo_txt).sendKeys(Keys.TAB);
					
					 memovalue=getElement(ObjectRepository.memo_txt).getText();
					if(memovalue.length()==50){
						Assert.assertTrue(true);
						test.log(Status.INFO, "Memo field allowed limit is 50");
					}else{
						test.log(Status.INFO, "Memo field allowed limit is not 50");
					}
					
				//Verify  letters and numbers are allowed in memo field
					getElement(ObjectRepository.memo_txt).clear();
					getElement(ObjectRepository.memo_txt).sendKeys("ABcde123");
					getElement(ObjectRepository.memo_txt).sendKeys(Keys.TAB);
					 memovalue=getElement(ObjectRepository.memo_txt).getText();
						if(memovalue.equals("ABcde123")){
							Assert.assertTrue(true);
							test.log(Status.INFO, "Letters and Numbers allowed in memo field");
						}else{
							test.log(Status.INFO, "Letters and Numbers not allowed in memo field");
						}
	
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
			test.log(Status.PASS, "Verify Memo Field Limit scenario working fine");
		}
	}

	@AfterTest
	public void tearDown() {
		extent.flush();
		driver.quit();
	}

}
