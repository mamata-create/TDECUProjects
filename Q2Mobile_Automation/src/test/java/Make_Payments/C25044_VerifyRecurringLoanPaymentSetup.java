package Make_Payments;

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

public class C25044_VerifyRecurringLoanPaymentSetup  extends GenericKeywords {

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
	public void C25044_VerifyRecurringLoanPaymentSetup() throws InterruptedException
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
					String memo=excl.getCellData(sheetName, 4, startIter);
					String frqncy=excl.getCellData(sheetName, 5, startIter);
					
		Thread.sleep(35000);
		verifyElementPresent(ObjectRepository.menu_btn);
		test.log(Status.INFO, "Menu link appearing");
	
		getElement(ObjectRepository.menu_btn).click();
		test.log(Status.INFO, "Menu link clicked");
		Thread.sleep(4000);	
		
		getElement(ObjectRepository.trnsctn_menu).click();
		test.log(Status.INFO, "Transaction menu clicked");
		Thread.sleep(2000);	
	
		getElement(ObjectRepository.mkpymnt_menu).click();
		test.log(Status.INFO, "Make a Payment menu clicked");
		Thread.sleep(2000);	
		
		verifyElementPresent(ObjectRepository.loanpymnt_ttl);
		test.log(Status.INFO, "Loan Payment title appearing");
		
		verifyElementPresent(ObjectRepository.loanpymnt_msg);
		test.log(Status.INFO, "Loan Payment Informative message appearing");
		
		verifyElementPresent(ObjectRepository.loan_frmacnt);
		verifyElementPresent(ObjectRepository.loan_toacnt);
		verifyElementPresent(ObjectRepository.loan_pymnttyp);
		verifyElementPresent(ObjectRepository.loan_amnttxt);
		verifyElementPresent(ObjectRepository.loan_memotxt);
		test.log(Status.INFO, "Loan Payment fields appearing");
		
//	From Account
		getElement(ObjectRepository.loan_frmacnt).click();
		test.log(Status.INFO, "From Account dropdown opened");
		Thread.sleep(2000);
		
		getElement("//android.widget.CheckedTextView[contains(@text,'"+frmacnt+"')]").click();
		test.log(Status.INFO, "From Account selected");
		Thread.sleep(4000);
		

// To Account
		getElement(ObjectRepository.loan_toacnt).click();
		test.log(Status.INFO, "To Account dropdown opened");
		Thread.sleep(2000);
		
		getElement("//android.widget.CheckedTextView[contains(@text,'"+toacnt+"')]").click();
		test.log(Status.INFO, "To Account selected");
		Thread.sleep(4000);
		
// Enter Amount
		getElement(ObjectRepository.loan_amnttxt).click();
		Thread.sleep(2000);
		Submitamount(amnt, ObjectRepository.loan_amnttxt);
		test.log(Status.INFO, "Loan Amount entered");
		Thread.sleep(2000);
		
//Select Recurring check box
		getElement(ObjectRepository.loan_rccrngchk).click();
		test.log(Status.INFO, "Recurring check box selected");
		Thread.sleep(3000);
		
		getElement(ObjectRepository.loan_frqncy).click();
		test.log(Status.INFO, "How Often dropdown opened");
		Thread.sleep(3000);
		
		getElement("//android.widget.CheckedTextView[contains(@text,'"+frqncy+"')]").click();
		test.log(Status.INFO, "Frequency selected");
		Thread.sleep(3000);
		
		
		scrollToElement(1);
		
// Select Date
		getElement(ObjectRepository.loan_strtdate).click();
		test.log(Status.INFO, "Start Date Calender opened");
		Thread.sleep(2000);
		
		selectAlertDate(0);
		test.log(Status.INFO, "Start Date selected");
		Thread.sleep(3000);
		
		getElement(ObjectRepository.loan_enddate).click();
		test.log(Status.INFO, "End  Date Calender opened");
		Thread.sleep(2000);
		
		selectAlertDate(8);
		test.log(Status.INFO, "End Date selected");
		Thread.sleep(3000);
		
		

// Enter Memo		
		
		getElement(ObjectRepository.loan_memotxt).sendKeys(memo);
		test.log(Status.INFO, "Memo entered");
		Thread.sleep(2000);
		
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
			test.log(Status.PASS, "Verify Recurring Loan Payment SetUp scenario working fine");
		}
	}
	
	@AfterTest
	public void tearDown(){
		driver.quit();
		stopAppium();
		extent.flush();
		
	}
}
