package JointOwser_Beneficiaries;

import java.io.IOException;
import java.util.List;

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

public class C23947_VerifyTheRequiredFieldsArePopulatedForJointOwnerApplicantForm extends GenericKeywords {

	ExtentReports extent;
	ExtentTest test;
	/*
	 * Verify that Non member user can verify the required fields are populated correctly for Joint owner form
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
	public void C23947_VerifyTheRequiredFieldsArePopulatedForJointOwnerApplicantForm() throws InterruptedException, MessagingException, IOException
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
					checkingOptionValidation("High Yield Checking");
					serviceOptionValidation("High Yield Checking",serviceOption);
					
					getElement(ObjectRepository.selectRadioOption("No")).click();
					test.log(Status.INFO, "Other option selected as No");
					
					getElement(ObjectRepository.continue_btn).click();
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
					
					
					scrollToElement(ObjectRepository.addJointOwners_CheckBox);
					getElement(ObjectRepository.addJointOwners_CheckBox).click();
					getElement(ObjectRepository.continue_btn).click();
					
					//Additional Accounts Owner Page
					verifyText(ObjectRepository.additionaliAccountOwnerPageTitle,"Additional Account Owners");
					getElement(ObjectRepository.fname_txt).sendKeys(fname);
					test.log(Status.INFO, "First name entered");
										
					getElement(ObjectRepository.lname_txt).sendKeys(lname);
					test.log(Status.INFO, "Last name entered");
					
					getElement(ObjectRepository.continue_btn).click();
					
					//Error message validation
					String[]arrayOfMessgaes = new String[]{"Please Enter a valid Address","Please enter the date of birth","Please enter some text",
							"Please select an ID Type","Please enter an ID Number","Please enter an Issue Date",
							"Please enter an Expiration Date","Please enter your mothers maiden name","Please enter some text"
							,"Please Enter a Phone Number","The email address cannot be verified. Please check and retry.","You can not join without a current ID"};
					
					List<WebElement>allErrorMsgs = retrunElements(ObjectRepository.errorSummary);
					for(int index=1;index<=allErrorMsgs.size();index++){
						System.out.println(getElement("(//span[contains(@id,'ErrorSummary')]//li)["+index+"]").getText());
						String ExpectedeachMsgFrom = arrayOfMessgaes[index-1];
						verifyText("(//span[contains(@id,'ErrorSummary')]//li)["+index+"]",ExpectedeachMsgFrom);
						
					}
					
					//Click on Add another joint account and check error summary
					getElement(ObjectRepository.addAnotherJointOwner).click();
					for(int index=1;index<=allErrorMsgs.size();index++){
						System.out.println(getElement("(//span[contains(@id,'ErrorSummary')]//li)["+index+"]").getText());
						String ExpectedeachMsgFrom = arrayOfMessgaes[index-1];
						verifyText("(//span[contains(@id,'ErrorSummary')]//li)["+index+"]",ExpectedeachMsgFrom);
						
					}
					
					//Click on add Beneficiary and check error summar
					getElement(ObjectRepository.addBeneficiaries_CheckBox).click();
					getElement(ObjectRepository.continue_btn).click();
					for(int index=1;index<=allErrorMsgs.size();index++){
						System.out.println(getElement("(//span[contains(@id,'ErrorSummary')]//li)["+index+"]").getText());
						String ExpectedeachMsgFrom = arrayOfMessgaes[index-1];
						verifyText("(//span[contains(@id,'ErrorSummary')]//li)["+index+"]",ExpectedeachMsgFrom);
						
					}
					
//					
					
				
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
			test.log(Status.PASS, "Verify that Non member user can verify the required fields are populated correctly for Joint owner form");
		}
	}

	@AfterTest
	public void tearDown() {
		extent.flush();
		driver.quit();
	}

}
