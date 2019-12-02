package CreditCard;

import java.io.IOException;
import java.util.List;

import javax.mail.MessagingException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
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

public class C23890_NonMemberUserMustEnterTypeAndLimit extends GenericKeywords  {
	ExtentReports extent;
	ExtentTest test;
	/*
	 * Verify User is able to know the max and min limit of credit card
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
	public void C23890_NonMemberUserMustEnterTypeAndLimit() throws InterruptedException, MessagingException, IOException
	{
		
		if(continuetestcase==true)
		{
			sheetName = "Data";
			int totalRowCount = excl.getRowCount(sheetName);
			for(startIter=1;startIter<=totalRowCount;startIter++) //It is mandatory to have this for loop in every test case
			 {	
				if(this.getClass().getSimpleName().equals(excl.getCellData(sheetName, 0, startIter)))
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
					getElement(ObjectRepository.dontWantCheckingOption).click();
					
					getElement(ObjectRepository.selectRadioOption("Yes")).click();
					productOptions(productOptionsForAllOptions);
					expandProductsAndValidateEachOptions("Credit Cards","CreditCard");
					creditCardCheckedUncheckedValidator("Classic",false);
					
					getElement(ObjectRepository.continue_btn).click();
					selectDropdownOpt(ObjectRepository.cardType_dropdown,"Please select a product type.");
					Thread.sleep(2000);
					getElement(ObjectRepository.edt_btn).click();
					
					String ActualErrorMsg = "Please select an item from the drop down list.;Please enter an Amount.";
					List<WebElement>element = driver.findElements(By.xpath("//span[@id='ErrorSummary1']//li"));
					for(int index=1;index<=element.size();index++){
						String Eacherr ="(//span[@id='ErrorSummary1']//li)["+index+"]";
						String errMsg = getElement(Eacherr).getText();
						Assert.assertEquals(errMsg, ActualErrorMsg.split(";")[index-1]);
						
						
					}
					enteramountbasedonLimitandValidateBhaviour(500,"500");
					enteramountbasedonLimitandValidateBhaviour(400,"500");
					enteramountbasedonLimitandValidateBhaviour(2000,"500");
					selectDropdownOpt(ObjectRepository.cardType_dropdown,"Buc-ee's MasterCard &reg;");
					Thread.sleep(2000);
					
					enteramountbasedonLimitandValidateBhaviour(400,"2000");
					enteramountbasedonLimitandValidateBhaviour(400,"2000");
					
					
					
					
					
				
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
			test.log(Status.PASS, "Verify User is able to know the max and min limit of credit card");
		}
	}

	@AfterTest
	public void tearDown() {
		extent.flush();
		driver.quit();
	}

}
