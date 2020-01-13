package CreditCard;

import java.io.IOException;

import javax.mail.MessagingException;

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

public class C23843_NonMemberCreditCardtLimit extends GenericKeywords  {
	ExtentReports extent;
	ExtentTest test;
	/*
	 * Verify User is able to view Credit Card details
	 */
	@BeforeTest
	public void setUp() throws InterruptedException, MessagingException, IOException {
		
		extent = ExtentManager.GetExtent();
		test = extent.createTest(this.getClass().getSimpleName());
		BaseClass iDriver = new BaseClass();
		iDriver.myTestCaseName = this.getClass().getSimpleName();
		executeDriverScript();
		test.log(Status.INFO, "Application url navigated");
		
	}
	
	@Test
	public void C23843_VerifyUserCanEnterAmmountToRequestCreditLimit() throws InterruptedException, MessagingException, IOException
	{
		
		if(continuetestcase==true)
		{
			sheetName = "Data";
			int totalRowCount = excl.getRowCount(sheetName);
			for(startIter=1;startIter<=totalRowCount;startIter++) //It is mandatory to have this for loop in every test case
			 {	
				if(this.getClass().getSimpleName().equals(excl.getCellData("Data", 0, startIter)))
				 {
					
					String informationHeader=excl.getCellData(sheetName, 23, startIter);
					String informationContent = excl.getCellData(sheetName, 24, startIter);
					String checkingAccountOptionHeader =  excl.getCellData(sheetName, 25, startIter);
					String creditAmount =  excl.getCellData(sheetName, 21, startIter);
					String productOptionsForAllOptions =  "Credit Cards; Vehicle Loans and Refinance Options (Auto, Boat, Motorcycle, RV/Camper); Personal Loans;Certificates of Deposit (CDs);Money Market Accounts;Savings Account;Additional Services and Features";
					
					String serviceOption = " Debit Card, Mobile Check Deposit, Overdraft Protection Plan, Opt into Courtesy Pay";
					String toolTipHeaderID = "modalDepositLabel,modalOverdraftLabel,modalCourtesyLabel";
					verifyElementPresent(ObjectRepository.app_ttl);
					test.log(Status.INFO, "Instant Open Title appearing");
					
					scrollToElement(ObjectRepository.nonmmbrstrt_btn);
					getElement(ObjectRepository.nonmmbrstrt_btn).click();
					test.log(Status.INFO, "Non Member Start here button clicked");
					
					Thread.sleep(3000);
					
					
					verifyText(ObjectRepository.inforMsgHeader,informationHeader);
					verifyText(ObjectRepository.inforMsgContent,informationContent);
					verifyText(ObjectRepository.checkingAccountOptionHeader,checkingAccountOptionHeader);
					checkingOptionValidation("High Yield Checking");
					serviceOptionValidation("High Yield Checking",serviceOption);
					checkBoxCheckedAndUncheck("checked");
					test.log(Status.INFO, "All options are checked");
					Thread.sleep(2000);
					
					
					getElement(ObjectRepository.selectRadioOption("Yes")).click();
					productOptions(productOptionsForAllOptions);
					expandProductsAndValidateEachOptions("Credit Cards","CreditCard");
					creditCardCheckedUncheckedValidator("Classic",false);
					getElement(ObjectRepository.continue_btn).click();
					getElement(ObjectRepository.creditcardLimitTxt).sendKeys(creditAmount);
					Thread.sleep(2000);
					getElement(ObjectRepository.productPageBackBtn).click();
					Assert.assertTrue(creditCardCheckedUncheckedValidator("Classic",true), "Credit card option still selected");
					
					
					
				
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
			test.log(Status.PASS, "Verify that user can enter ammount based on Credit limit");
		}
	}

	@AfterTest
	public void tearDown() {
		extent.flush();
		driver.quit();
	}

}
