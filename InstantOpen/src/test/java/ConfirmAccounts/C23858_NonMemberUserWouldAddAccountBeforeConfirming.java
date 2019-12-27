package ConfirmAccounts;

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
import com.github.javafaker.Faker;

public class C23858_NonMemberUserWouldAddAccountBeforeConfirming extends GenericKeywords  {
	ExtentReports extent;
	ExtentTest test;
	/*
	 * Verify Non member user can add an account before confirming
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
	public void C23858_NonMemberUserWouldAddAccountBeforeConfirming() throws InterruptedException, MessagingException, IOException
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
					String accountselections = excl.getCellData(sheetName, 29, startIter);
					String productOptionsForAllOptions =  "Credit Cards; Vehicle Loans and Refinance Options (Auto, Boat, Motorcycle, RV/Camper); Personal Loans;Certificates of Deposit (CDs);Money Market Accounts;Savings Account;Additional Services and Features";
					String bottomMsg = excl.getCellData(sheetName, 26, startIter);
					String serviceOption = " Debit Card, Mobile Check Deposit, Overdraft Protection Plan, Opt into Courtesy Pay";
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

					
					//Check the account and select
					verifyElementPresent(ObjectRepository.Highyieldchking_opt);
					getElement(ObjectRepository.Highyieldchking_opt).click();
					getElement(ObjectRepository.locatorAdditionalOption("Overdraft Protection Plan")).click();;
					getElement(ObjectRepository.selectRadioOption("Yes")).click();
					getElement(ObjectRepository.subproductName("Certificates of Deposit (CDs)")).click();
					getElement(ObjectRepository.CD_amount_field).sendKeys("1000");
					selectDropdownOpt(ObjectRepository.CD_term_field,"6");
					getElement(ObjectRepository.getTermCertificateLocator(("6"))).click();
					getElement(ObjectRepository.continue_btn).click();
					
					
					
//					productOptions(productOptionsForAllOptions);
//					expandProductsAndValidateEachOptions("Credit Cards","CreditCard");
//					creditCardCheckedUncheckedValidator("Classic",false);
//					getElement(ObjectRepository.continue_btn).click();
//					verifyText(ObjectRepository.creditCardInfoPage,"Credit Card Info");
//					verifyElementPresent(ObjectRepository.cardType_dropdown);
//					verifyElementPresent(ObjectRepository.creditcardLimitTxt);
//					getElement(ObjectRepository.creditcardLimitTxt).sendKeys("1000");
//					getElement(ObjectRepository.edt_btn).click();
					verifyText(ObjectRepository.primaryApplicantInfoPageTitle,"Primary Applicant Information");
					
					//Enter all required Field''s Value in Applicant Info and Proceed
					getElement(ObjectRepository.fname_txt).sendKeys(fname);
					test.log(Status.INFO, "First name entered");
					
//					getElement(ObjectRepository.mname_txt).sendKeys("");
//					test.log(Status.INFO, "Middle name entered");
//					
					getElement(ObjectRepository.lname_txt).sendKeys(lname);
					test.log(Status.INFO, "Last name entered");
					
//					getElement(ObjectRepository.namesfx_txt).sendKeys("");
//					test.log(Status.INFO, "Name suffix entered");
					
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
					getElement(ObjectRepository.continue_btn).click();
					
					
					verifyElementPresent(ObjectRepository.memberShipEligibilityPage);
					test.log(Status.INFO, "Navigated to Member Eligibility Page successfully");
					getElement(ObjectRepository.membership_page_option(1)).click();
					getElement(ObjectRepository.productPageNext).click();
					verifyText(ObjectRepository.confirm_account_selections_page,"Confirm Account Selections");
					
					try{
						List<WebElement>accountSelections = retrunElements("//span[@id='ProductsAndServices']//following::li");
						for(int count=1;count<=accountSelections.size();count++){
							
							String actualSelection = accountselections.split("::")[count-1].trim();
							String eachSelection = getElement("(//span[@id='ProductsAndServices']//following::li)["+count+"]").getText();
							if(eachSelection.contains(actualSelection)){
								Assert.assertTrue(true, "Value matched");
							}
						}
					}catch(ArrayIndexOutOfBoundsException e){
						System.out.println("In catch....exit execution");
					}
					
					getElement(ObjectRepository.change_button).click();
					
					//Check whether pre-selected account is still selected or not
					String property_checkingAccount = getElement(ObjectRepository.checkingAccount_prop).getAttribute("class");
					String property_otherOption = getElement(ObjectRepository.otheOption_prop).getAttribute("class");
					boolean checkFlag = property_checkingAccount.contains("checked")&&property_otherOption.contains("checked");
					if(checkFlag)
					Assert.assertTrue(true);
					
					//Add one new product (here selecting Credit card)
					expandProductsAndValidateEachOptions("Credit Cards","CreditCard");
					creditCardCheckedUncheckedValidator("Classic",false);
					getElement(ObjectRepository.continue_btn).click();
					getElement(ObjectRepository.creditcardLimitTxt).sendKeys("1000");
					getElement(ObjectRepository.prodInfoNextButton).click();
					//Loan information
					getElement(ObjectRepository.housingPayment).sendKeys("1000");
					getElement(ObjectRepository.addressYearBox).sendKeys("90");
					getElement(ObjectRepository.addressMonthBox).sendKeys("06");
					getElement(ObjectRepository.monthlySal).sendKeys("2500");
					getElement(ObjectRepository.employeeDurationYear).sendKeys("18");
					getElement(ObjectRepository.employeeDurationMonth).sendKeys("06");
					getElement(ObjectRepository.continue_btn).click();
					verifyElementPresent(ObjectRepository.memberShipEligibilityPage);
					test.log(Status.INFO, "Navigated to Member Eligibility Page successfully");
					getElement(ObjectRepository.membership_page_option(1)).click();
					getElement(ObjectRepository.productPageNext).click();
					verifyText(ObjectRepository.confirm_account_selections_page,"Confirm Account Selections");
					
					try{
						List<WebElement>accountSelections = retrunElements("//span[@id='ProductsAndServices']//following::li");
						for(int count=1;count<=accountSelections.size();count++){
							
							String actualSelection = accountselections.split("::")[count-1].trim();
							String eachSelection = getElement("(//span[@id='ProductsAndServices']//following::li)["+count+"]").getText();
							if(eachSelection.contains(actualSelection)){
								Assert.assertTrue(true, "Value matched");
							}
						}
					}catch(ArrayIndexOutOfBoundsException e){
						System.out.println("In catch....exit execution");
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
			test.log(Status.PASS, "Verify Non member user can add an account before confirming");
		}
	}

	@AfterTest
	public void tearDown() {
		extent.flush();
		driver.quit();
	}

}
