package Make_A_Payment;

import java.io.IOException;

import javax.mail.MessagingException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
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

public class C23530_VerifyConsumerLoanPaidOffPayment extends GenericKeywords {

	ExtentReports extent;
	ExtentTest test;
	/*
	 * Verify Make Consumer Loan paid off Payment
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
					}
*/
				
				//Verify log off link available after login
				verifyElementPresent(ObjectRepository.logoff_lnk);
				test.log(Status.INFO, "User successfully logged in as Logoff link available");
		
	}

	@Test
	public void C23530_VerifyConsumerLoanPaidOffPayment() throws InterruptedException, MessagingException, IOException
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
					
					getElement(ObjectRepository.mkpymnt_menu).click();
					test.log(Status.INFO, "Make a Payment menu clicked");
					
					verifyElementPresent(ObjectRepository.mkpymnt_ttl);
					test.log(Status.INFO, "Make a Payment page opened");
										
					selectDropdownOptContain(ObjectRepository.mkpymnt_frmacnt, frmacnt);
					test.log(Status.INFO, "From Account selected");
		
					selectDropdownOptContain(ObjectRepository.mkpymnt_toacnt, toacnt);
					test.log(Status.INFO, "To Account selected");
					
					JavascriptExecutor js = (JavascriptExecutor)driver;
					js.executeScript("arguments[0].value='"+amnt+"';", getElement(ObjectRepository.mkpymnt_amnt));
					
					
					WebElement root1 = driver.findElement(By.cssSelector("q2-calendar[calendar-label='Select Date']"));
					WebElement shadowRoot1 = ObjectRepository.expandRootElement(driver, root1);
					WebElement root2 = shadowRoot1.findElement(By.cssSelector("q2-input[icon-right='calendar']"));
					WebElement shadowRoot2 = ObjectRepository.expandRootElement(driver, root2);
					WebElement calStartDate = shadowRoot2.findElement(By.cssSelector("button[test-id='inputField']"));
					calStartDate.click();
					Thread.sleep(3000);
					selectDateofShadowRootElement(1,"Select Date");
					test.log(Status.INFO, "Date selected");
					
					getElement(ObjectRepository.mkpymnt_memo).sendKeys(memo);
					test.log(Status.INFO, "Memo entered");
					getElement(ObjectRepository.mkpymnt_memo).sendKeys(Keys.TAB);
					
					getElement(ObjectRepository.mkpymnt_cntinue).click();
					test.log(Status.INFO, "Continue button clicked");
					
					getElement(ObjectRepository.mkpymnt_cnfrmbtn).click();
					test.log(Status.INFO, "Confirm button clicked");
					
					verifyElementPresent(ObjectRepository.mkpymnt_invldloanmsg);
					test.log(Status.INFO, "Invalid loan message appearing");
					
					
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
			test.log(Status.PASS, "Verify Make Consumer loan paid off payment scenario working fine");
		}
	}

	@AfterTest
	public void tearDown() {
		extent.flush();
		driver.quit();
	}

}
