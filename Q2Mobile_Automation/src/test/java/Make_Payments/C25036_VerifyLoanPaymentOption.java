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

public class C25036_VerifyLoanPaymentOption  extends GenericKeywords {

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
	public void C25306_VerifyLoanPaymentOption() throws InterruptedException
	{
		Thread.sleep(30000);
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
		
		clickElement(ObjectRepository.loan_contbtn);
		test.log(Status.INFO, "Continue button clicked");
		Thread.sleep(2000);	
		
		
		verifyElementPresent(ObjectRepository.loan_errmsg);
		test.log(Status.INFO, "Loan Payment validation message appearing");
		
		getElement(ObjectRepository.loan_clsbtn).click();
		test.log(Status.INFO, "Close button clicked");
		Thread.sleep(2000);
		
		
	}
	
	@AfterMethod
	public void afterMethod(ITestResult result) throws Throwable{
		if(result.getStatus()==ITestResult.FAILURE){
			test.log(Status.FAIL, "Test Failed - "+result.getThrowable());	
			GenericKeywords.takescreenshot(myTestCaseName,test);
		}else
		{
			test.log(Status.PASS, "Verify Loan Payment Option scenario working fine");
		}
	}
	
	@AfterTest
	public void tearDown(){
		driver.quit();
		stopAppium();
		extent.flush();
		
	}
}
