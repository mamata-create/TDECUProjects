package ApplicantInfo;

import java.io.IOException;
import java.util.List;

import javax.mail.MessagingException;

import org.openqa.selenium.By;
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

public class C23763_AddressShouldVerifiedForNonMemberUser extends GenericKeywords  {
	ExtentReports extent;
	ExtentTest test;
	/*
	 * Verify the Address field values for Non member user 
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
	public void C23763_AddressShouldVerifiedForNonMemberUser() throws InterruptedException, MessagingException, IOException
	{
		
		if(continuetestcase==true)
		{
			sheetName = "Data";
			int totalRowCount = excl.getRowCount(sheetName);
			for(startIter=1;startIter<=totalRowCount;startIter++) //It is mandatory to have this for loop in every test case
			 {	
				if(this.getClass().getSimpleName().equals(excl.getCellData(sheetName, 0, startIter)))
				 {
					Faker fk=new Faker();
					String num=getRandom();
					String fname=fk.name().firstName();
					String lname=fk.name().lastName();
					String informationHeader=excl.getCellData(sheetName, 23, startIter);
					String informationContent = excl.getCellData(sheetName, 24, startIter);
					String checkingAccountOptionHeader =  excl.getCellData(sheetName, 25, startIter);
					String strtaddress="1001 FM 2004 Rd";
					String zipcode="77566";
					/*
					
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
					String hear_opt=excl.getCellData(sheetName, 19, startIter);*/
					
					
					verifyElementPresent(ObjectRepository.app_ttl);
					test.log(Status.INFO, "Instant Open Title appearing");
					
					scrollToElement(ObjectRepository.nonmmbrstrt_btn);
					getElement(ObjectRepository.nonmmbrstrt_btn).click();
					test.log(Status.INFO, "Non Member Start here button clicked");
					
					Thread.sleep(3000);
					
					verifyText(ObjectRepository.inforMsgHeader,informationHeader);
					verifyText(ObjectRepository.inforMsgContent,informationContent);
					verifyText(ObjectRepository.checkingAccountOptionHeader,checkingAccountOptionHeader);
					
					
					verifyElementPresent(ObjectRepository.dontWantCheckingOption);
					getElement(ObjectRepository.dontWantCheckingOption).click();
					getElement(ObjectRepository.selectRadioOption("No")).click();
					getElement(ObjectRepository.continue_btn).click();
					verifyText(ObjectRepository.primaryApplicantInfoPageTitle,"Primary Applicant Information");
					verifyText(ObjectRepository.pageSection("Applicant Information"),"Applicant Information");
					verifyText(ObjectRepository.pageSection("Identification Information"),"Identification Information");
					verifyText(ObjectRepository.pageSection("Contact Information"),"Contact Information");
					
					getElement(ObjectRepository.fname_txt).sendKeys(fname);
					test.log(Status.INFO, "First name entered");
					
					getElement(ObjectRepository.lname_txt).sendKeys(lname);
					test.log(Status.INFO, "Last name entered");
					
					getElement(ObjectRepository.strtaddrs_txt).sendKeys(strtaddress);
					test.log(Status.INFO,  "Valid Street Address entered");
					
					getElement(ObjectRepository.strtaddrs_txt).sendKeys(Keys.TAB);
					test.log(Status.INFO,  "Tab pressed");
					
					getElement(ObjectRepository.zip_txt).sendKeys(Keys.TAB);
					test.log(Status.INFO, "Tab button pressed without providing any value in Zip code field");
					
					verifyText(ObjectRepository.addressNotVerified_alert,"The address could not be verified. Please check the information and try again.");
					getElement(ObjectRepository.zip_txt).click();
					getElement(ObjectRepository.zip_txt).sendKeys(zipcode);
					getElement(ObjectRepository.zip_txt).sendKeys(Keys.TAB);
					Thread.sleep(1500);
					verifyText(ObjectRepository.addressNotVerified_alert,"We have modified your address. Please check to ensure that it is correct.");
					getElement(ObjectRepository.strtaddrs_txt).clear();
					getElement(ObjectRepository.strtaddrs_txt).sendKeys(strtaddress);
					test.log(Status.INFO,  "Valid Street Address entered");
					getElement(ObjectRepository.strtaddrs_txt).sendKeys(Keys.TAB);
					getElement(ObjectRepository.zip_txt).sendKeys(Keys.TAB);
					Thread.sleep(1500);
					verifyText(ObjectRepository.addressNotVerified_alert,"Verified!");
					getElement(ObjectRepository.zip_txt).clear();
					getElement(ObjectRepository.strtaddrs_txt).clear();
					getElement(ObjectRepository.strtaddrs_txt).sendKeys("423 Winter Show Rd E");
					getElement(ObjectRepository.strtaddrs_txt).sendKeys(Keys.TAB);
					getElement(ObjectRepository.zip_txt).sendKeys("58072");
					getElement(ObjectRepository.zip_txt).sendKeys(Keys.TAB);
					Thread.sleep(1500);
					verifyText(ObjectRepository.addressNotVerified_alert,"Multiple addresses were found. Please enter more information and try again.");
					getElement(ObjectRepository.strtaddrs_txt).clear();
					getElement(ObjectRepository.strtaddrs_txt).sendKeys("423 Winter Show Rd SE");
					getElement(ObjectRepository.strtaddrs_txt).sendKeys(Keys.TAB);
					getElement(ObjectRepository.zip_txt).sendKeys(Keys.TAB);
					Thread.sleep(1500);
					verifyText(ObjectRepository.addressNotVerified_alert,"We have modified your address. Please check to ensure that it is correct.");
					getElement(ObjectRepository.strtaddrs_txt).click();
					getElement(ObjectRepository.strtaddrs_txt).sendKeys(Keys.TAB);
					getElement(ObjectRepository.zip_txt).sendKeys(Keys.TAB);
					Thread.sleep(1500);
					verifyText(ObjectRepository.addressNotVerified_alert,"Verified!");
					
					
					/*validatePopUpAlertForInvalidCharecterEntry("First Name");
					validatePopUpAlertForInvalidCharecterEntry("Middle Name");
					validatePopUpAlertForInvalidCharecterEntry("Last Name");
					
					//Steps to validate functionalities from Name Suffix field
					
					String nameSuffix = "//input[@name='tbNameSuffix_TextBox']";
					String errorSummaryForInvalidData = "//span[@id='ErrorSummary1']//li[1]";
					String numbers = "2563";
					String spclchar = "!@#$";
					getElement(nameSuffix).sendKeys(numbers);
					getElement(ObjectRepository.continue_further).click();
					
					//Steps to validate validation message and if Name suffix field contains invalid data
					
					String fieldBackgroundColor = getElement(nameSuffix).getAttribute("style").trim();
					if(fieldBackgroundColor.contains("lightyellow")){
						test.log(Status.INFO, "The field turned as Yellow now");
						Assert.assertEquals(getElement(errorSummaryForInvalidData).isDisplayed(), true);
						Assert.assertEquals(getElement(errorSummaryForInvalidData).getText().trim(), "The value entered is not valid. Please try again.");
						test.log(Status.INFO, "Invalid error summary is displayed on the page");
						
					}
					
					scrollToElement(nameSuffix);
					getElement(nameSuffix).clear();
					getElement(nameSuffix).sendKeys(spclchar);
					getElement(ObjectRepository.continue_further).click();
					
					if(fieldBackgroundColor.contains("lightyellow")){
						test.log(Status.INFO, "The field turned as Yellow now");
						Assert.assertEquals(getElement(errorSummaryForInvalidData).isDisplayed(), true);
						Assert.assertEquals(getElement(errorSummaryForInvalidData).getText().trim(), "The value entered is not valid. Please try again.");
						test.log(Status.INFO, "Invalid error summary is displayed on the page");
						
					}
					
					getElement(nameSuffix).clear();
					getElement(nameSuffix).sendKeys("Jr");
					getElement(ObjectRepository.strtaddrs_txt).sendKeys(strtaddress);
					test.log(Status.INFO, "Street Address entered");
					
					getElement(ObjectRepository.zip_txt).sendKeys(zipcode);
					test.log(Status.INFO, "Zip code entered");
					
					getElement(ObjectRepository.ssn_txt).sendKeys(ssn);
					test.log(Status.INFO, "SSN entered");
					
					//dt
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
					test.log(Status.INFO, "Phone number entered");
					
					selectDropdownOptContain(ObjectRepository.phonetyp_drop, phonetyp);
					test.log(Status.INFO, "Phone type selected");
					
					
					getElement(ObjectRepository.primaryemail_txt).sendKeys(primary_email);
					test.log(Status.INFO, "Primary email entered");
					getElement(ObjectRepository.continue_further).click();
					verifyElementPresent(ObjectRepository.memberShipEligibilityPage);
					test.log(Status.INFO, "Navigated to Member Eligibility Page successfully");*/
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
			test.log(Status.PASS, "Verify the Address field values for Non member user");
		}
	}

	@AfterTest
	public void tearDown() {
		extent.flush();
		driver.quit();
	}

}
