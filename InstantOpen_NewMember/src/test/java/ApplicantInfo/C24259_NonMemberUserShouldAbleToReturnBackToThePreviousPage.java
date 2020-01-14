package ApplicantInfo;

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

public class C24259_NonMemberUserShouldAbleToReturnBackToThePreviousPage extends GenericKeywords  {
	ExtentReports extent;
	ExtentTest test;
	/*
	 * Verify Non member user can return back to the previous page if they want to make changes
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
	public void C24259_NonMemberUserShouldAbleToReturnBackToThePreviousPage() throws InterruptedException, MessagingException, IOException
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
					String productOptionsForAllOptions =  "Credit Cards; Vehicle Loans and Refinance Options (Auto, Boat, Motorcycle, RV/Camper); Personal Loans;Certificates of Deposit (CDs);Money Market Accounts;Savings Account;Additional Services and Features";
					String bottomMsg = excl.getCellData(sheetName, 26, startIter);
					String serviceOption = " Debit Card, Mobile Check Deposit, Overdraft Protection Plan, Opt into Courtesy Pay";
					
					verifyElementPresent(ObjectRepository.app_ttl);
					test.log(Status.INFO, "Instant Open Title appearing");
					
					scrollToElement(ObjectRepository.nonmmbrstrt_btn);
					getElement(ObjectRepository.nonmmbrstrt_btn).click();
					test.log(Status.INFO, "Non Member Start here button clicked");
					
					Thread.sleep(3000);
					
					verifyText(ObjectRepository.inforMsgHeader,informationHeader);
					verifyText(ObjectRepository.inforMsgContent,informationContent);
					verifyText(ObjectRepository.checkingAccountOptionHeader,checkingAccountOptionHeader);
					
					
					
//					getElement(ObjectRepository.selectRadioOption("Yes")).click();
//					getElement(ObjectRepository.continue_btn).click();
//					verifyText(ObjectRepository.primaryApplicantInfoPageTitle,"Primary Applicant Information");
//					verifyText(ObjectRepository.pageSection("Applicant Information"),"Applicant Information");
//					verifyText(ObjectRepository.pageSection("Identification Information"),"Identification Information");
//					verifyText(ObjectRepository.pageSection("Contact Information"),"Contact Information");
//					scrollToElement(ObjectRepository.addJointOwners_CheckBox);
//					verifyElementPresent(ObjectRepository.addJointOwners_CheckBox);
//					verifyElementPresent(ObjectRepository.addBeneficiaries_CheckBox);
//					verifyText(ObjectRepository.footerString,bottomMsg.trim());
//					getElement(ObjectRepository.backButton).click();
//					
					//Check the account and select
					verifyElementPresent(ObjectRepository.Highyieldchking_opt);
					getElement(ObjectRepository.Highyieldchking_opt).click();
					getElement(ObjectRepository.selectRadioOption("Yes")).click();
					productOptions(productOptionsForAllOptions);
					expandProductsAndValidateEachOptions("Credit Cards","CreditCard");
					creditCardCheckedUncheckedValidator("Classic",false);
					getElement(ObjectRepository.continue_btn).click();
					verifyText(ObjectRepository.creditCardInfoPage,"Credit Card Info");
					verifyElementPresent(ObjectRepository.cardType_dropdown);
					verifyElementPresent(ObjectRepository.creditcardLimitTxt);
					getElement(ObjectRepository.creditcardLimitTxt).sendKeys("1000");
					getElement(ObjectRepository.edt_btn).click();
					verifyText(ObjectRepository.primaryApplicantInfoPageTitle,"Primary Applicant Information");
					getElement(ObjectRepository.backButton).click();
					
					//Expand Vehicle Loans section and proceed with further steps
					
					getElement(ObjectRepository.carLoanExpand).click();
					getElement(ObjectRepository.autoLoanTitle).click();
					getElement(ObjectRepository.continue_btn).click();
					verifyText(ObjectRepository.creditCardInfoPage,"Credit Card Info");
					verifyElementPresent(ObjectRepository.cardType_dropdown);
					verifyElementPresent(ObjectRepository.creditcardLimitTxt);
					getElement(ObjectRepository.edt_btn).click();
					verifyText(ObjectRepository.vehicleLoanPage,"Vehicle Loan Info");
					getElement(ObjectRepository.backButtonFurther).click();
					verifyText(ObjectRepository.creditCardInfoPage,"Credit Card Info");
					getElement(ObjectRepository.backButtonFurther).click();
//					verifyText(ObjectRepository.primaryApplicantInfoPageTitle,"Primary Applicant Information");
//					getElement(ObjectRepository.backButton).click();
//					verifyText(ObjectRepository.creditCardInfoPage,"Credit Card Info");
					verifyText(ObjectRepository.inforMsgHeader,informationHeader);
					verifyText(ObjectRepository.inforMsgContent,informationContent);
					verifyText(ObjectRepository.checkingAccountOptionHeader,checkingAccountOptionHeader);
					
					//Exapnad Personal Loan and procced with further steps
					getElement(ObjectRepository.personalLoanExpand).click();
					getElement(ObjectRepository.myWay4000Title).click();
					getElement(ObjectRepository.continue_btn).click();
					verifyText(ObjectRepository.creditCardInfoPage,"Credit Card Info");
					verifyElementPresent(ObjectRepository.cardType_dropdown);
					verifyElementPresent(ObjectRepository.creditcardLimitTxt);
					getElement(ObjectRepository.edt_btn).click();
					verifyText(ObjectRepository.vehicleLoanPage,"Vehicle Loan Info");
					getElement(ObjectRepository.prodLimitTextbox).sendKeys("1000");
					getElement(ObjectRepository.carPurchPrice).sendKeys("1000");
					getElement(ObjectRepository.edt_btn).click();
					verifyText(ObjectRepository.psnlLoanInfTtl,"Personal Loan Info");
					getElement(ObjectRepository.backButtonFurther).click();
					verifyText(ObjectRepository.vehicleLoanPage,"Vehicle Loan Info");
					getElement(ObjectRepository.backButtonFurther).click();
					verifyText(ObjectRepository.creditCardInfoPage,"Credit Card Info");
					getElement(ObjectRepository.backButtonFurther).click();
					
					
					verifyText(ObjectRepository.inforMsgHeader,informationHeader);
					verifyText(ObjectRepository.inforMsgContent,informationContent);
					verifyText(ObjectRepository.checkingAccountOptionHeader,checkingAccountOptionHeader);
					
				
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
			test.log(Status.PASS, "Verify Non member user can return back to the previous page if they want to make changes");
		}
	}

	@AfterTest
	public void tearDown() {
		extent.flush();
		driver.quit();
	}

}
