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

public class C25038_VerifyRegularCommercialLoanPayment extends GenericKeywords {

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
	public void C25038_VerifyRegularCommercialLoanPayment() throws InterruptedException
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

		scrollToElement(1);
		
// Select Date
		getElement(ObjectRepository.loan_date).click();
		test.log(Status.INFO, "Calender opened");
		Thread.sleep(2000);
		
		selectAlertDate(0);
		

// Enter Memo		
		
		getElement(ObjectRepository.loan_memotxt).sendKeys(memo);
		test.log(Status.INFO, "Memo entered");
		Thread.sleep(2000);
		
		clickElement(ObjectRepository.loan_contbtn);
		test.log(Status.INFO, "Continue button clicked");
		Thread.sleep(4000);
		
		verifyElementPresent(ObjectRepository.loan_cnfrmbtn);
		test.log(Status.INFO, "Confirm loan payment popup appearing");
		
		getElement(ObjectRepository.loan_cnclbtn).click();
		test.log(Status.INFO, "Cancel button clicked from confirm loan payment page");
		Thread.sleep(2000);
		
		clickElement(ObjectRepository.loan_contbtn);
		test.log(Status.INFO, "Continue button clicked again");
		Thread.sleep(4000);
		
		verifyElementPresent(ObjectRepository.loan_cnfrmbtn);
		test.log(Status.INFO, "Confirm loan payment popup appearing");
		
		getElement(ObjectRepository.loan_cnfrmbtn).click();
		test.log(Status.INFO, "Confirm button clicked from confirm loan payment page");
		Thread.sleep(2000);
		
		verifyElementPresent(ObjectRepository.loan_actvtybtn);
		test.log(Status.INFO, "View Activity Center button appearing");
		
		getElement(ObjectRepository.loan_actvtybtn).click();
		test.log(Status.INFO, "View Activity center button clicked");
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
			test.log(Status.PASS, "Verify Regular Commercial Loan Payment scenario working fine");
		}
	}
	
	@AfterTest
	public void tearDown(){
		driver.quit();
		stopAppium();
		extent.flush();
		
	}
}
