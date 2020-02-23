package SelectAccounts;

import java.io.IOException;

import javax.mail.MessagingException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
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
import com.github.javafaker.Faker;

public class C23721_VerifyVehicleLoansAndRefinanceOptions extends GenericKeywords {

	ExtentReports extent;
	ExtentTest test;
	/*
	 * Verify User is able to view Vehicle loans and Refinance details
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
	public void C23721_VerifyVehicleLoansAndRefinanceOptions() throws InterruptedException, MessagingException, IOException
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
					String productOptionsForAllOptions =  "Credit Cards; Vehicle Loans and Refinance Options (Auto, Boat, Motorcycle, RV/Camper); Personal Loans;Certificates of Deposit (CDs);Money Market Accounts;Savings Account;Additional Services and Features";
					
					String serviceOption = " Debit Card, Mobile Check Deposit, Overdraft Protection Plan, Opt into Courtesy Pay";
					String toolTipHeaderID = "modalDepositLabel,modalOverdraftLabel,modalCourtesyLabel";
					Faker fk=new Faker();
					String num=getRandom();
					String fname=fk.name().firstName();
					
					String lname=fk.name().lastName();
					
					String strtaddress=excl.getCellData(sheetName, 5, startIter);
					String zipcode=excl.getCellData(sheetName, 6, startIter);
					String ssn=excl.getCellData(sheetName, 7, startIter);
					ssn=ssn+num;
					String dob=excl.getCellData(sheetName, 8, startIter);
					dob=dob+num;
					String idtyp=excl.getCellData(sheetName, 9, startIter);
					String idnumber=excl.getCellData(sheetName, 10, startIter);
					String issue_dt=excl.getCellData(sheetName, 11, startIter);
					String expr_dt=excl.getCellData(sheetName, 12, startIter);
					String mothername=excl.getCellData(sheetName, 13, startIter);
					String crrnt_emplyr=excl.getCellData(sheetName, 14, startIter);
					String occupation=excl.getCellData(sheetName, 15, startIter);
					String phonenmbr=excl.getCellData(sheetName, 16, startIter);
					String phonetyp=excl.getCellData(sheetName, 17, startIter);
					String primary_email=excl.getCellData(sheetName, 18, startIter);
					String hear_opt=excl.getCellData(sheetName, 19, startIter);
					
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
					expandProductsAndValidateEachOptions("Vehicle Loans and Refinance Options ","Vehicle");
					getElement(ObjectRepository.continue_btn).click();
					getElement(ObjectRepository.productPageBackBtn).click();
					expandProductsAndValidateEachOptions("Personal Loans","PersonalLoan");
					getElement(ObjectRepository.continue_btn).click();
					verifyText(ObjectRepository.vehicleLoanPage,"Vehicle Loan Info");
					getElement(ObjectRepository.vehicleLoanAmt).sendKeys("1000");
					getElement(ObjectRepository.vehiclePurchesPrice).sendKeys("3500");
					getElement(ObjectRepository.edt_btn).click();
					verifyText(ObjectRepository.personalLoanPage,"Personal Loan Info");
					getElement(ObjectRepository.creditcardLimitTxt).sendKeys("1000");
					getElement(ObjectRepository.edt_btn).click();
					verifyText(ObjectRepository.primaryApplicantInfoPageTitle,"Primary Applicant Information");
					
					getElement(ObjectRepository.fname_txt).sendKeys(fname);
					test.log(Status.INFO, "First name entered");
										
					getElement(ObjectRepository.lname_txt).sendKeys(lname);
					test.log(Status.INFO, "Last name entered");
										
					getElement(ObjectRepository.strtaddrs_txt).sendKeys(strtaddress);
					test.log(Status.INFO, "Street Address entered");
					
					getElement(ObjectRepository.zip_txt).sendKeys(zipcode);
					test.log(Status.INFO, "Zip code entered");
					
					getElement(ObjectRepository.ssn_txt).sendKeys(ssn);
					test.log(Status.INFO, "SSN entered");
					
					
					getElement(ObjectRepository.dob_cal).sendKeys(dob);
					test.log(Status.INFO, "Date of Birth entered");
					
					selectDropdownOptContain(ObjectRepository.idtyp_drop, idtyp);
					test.log(Status.INFO, "ID type selected");
					
					getElement(ObjectRepository.idnmbr_txt).sendKeys(idnumber);
					test.log(Status.INFO, "ID number entered");
					
					getElement(ObjectRepository.issuedt_cal).sendKeys(issue_dt);
					test.log(Status.INFO, "Issue date entered");
					
					getElement(ObjectRepository.expdt_cal).sendKeys(expr_dt);
					test.log(Status.INFO, "Expiry date entered");
					
					selectDropdownOptContain(ObjectRepository.hrabttdecu_drop, hear_opt);
					test.log(Status.INFO, "How did you hear about TDECU option selected");
					
					getElement(ObjectRepository.mothername_txt).sendKeys(mothername);
					test.log(Status.INFO, "Mother name entered");
					
					getElement(ObjectRepository.crrntemplyr_txt).sendKeys(crrnt_emplyr);
					test.log(Status.INFO, "Current Employer name entered");
					
					getElement(ObjectRepository.occptn_txt).sendKeys(occupation);
					test.log(Status.INFO, "Occupation name entered");
					getElement(ObjectRepository.phonenmbr_txt).sendKeys(phonenmbr);
					selectDropdownOptContain(ObjectRepository.phonetyp_drop, phonetyp);
					getElement(ObjectRepository.primaryemail_txt).sendKeys(primary_email);
					
					getElement(ObjectRepository.housingPayment).sendKeys("1000");
					getElement(ObjectRepository.addressYearBox).sendKeys("90");
					getElement(ObjectRepository.addressMonthBox).sendKeys("2");
					
					getElement(ObjectRepository.monthlySal).sendKeys("4000");
					getElement(ObjectRepository.employeeDurationYear).sendKeys("99");
					getElement(ObjectRepository.employeeDurationMonth).sendKeys("3");
					getElement(ObjectRepository.continue_btn).click();
					verifyElementPresent(ObjectRepository.memberShipEligibilityPage);
					test.log(Status.INFO, "Navigated to Member Eligibility Page successfully");
					getElement(ObjectRepository.membership_page_option(1)).click();
					getElement(ObjectRepository.productPageNext).click();
					verifyText(ObjectRepository.cnfrmacnt_ttl,"Confirm Selected Products and Services");
					
				
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
			test.log(Status.PASS, "Verify User is able to view vehicle loans and refinance options");
		}
	}

	@AfterTest
	public void tearDown() {
		extent.flush();
		driver.quit();
	}

}
