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

public class C23801_ApplicationProvideAlertForInvalidIssueDateEntries extends GenericKeywords  {
	ExtentReports extent;
	ExtentTest test;
	/*
	 * Verify application should alert user for invalid Issue Date entries
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
	public void C237801_ApplicationProvideAlertForInvalidIssueDateEntries() throws InterruptedException, MessagingException, IOException
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
					
					//Entering letters in Issue Date field
					getElement(ObjectRepository.issuedt_cal).click();
					getElement(ObjectRepository.issuedt_cal).clear();
					getElement(ObjectRepository.issuedt_cal).sendKeys("October");
					
					//Entering Special Charecters in the Issue Date field
					getElement(ObjectRepository.issuedt_cal).click();
					getElement(ObjectRepository.issuedt_cal).clear();
					getElement(ObjectRepository.issuedt_cal).sendKeys("@#$%^");
					getElement(ObjectRepository.issuedt_cal).sendKeys(Keys.TAB);
					Thread.sleep(500);
					verifyText(ObjectRepository.issueDate_alert,"Please use a 4-digit year");
					
					
					//Entering month value greater than 12
					getElement(ObjectRepository.issuedt_cal).click();
					getElement(ObjectRepository.issuedt_cal).clear();
					getElement(ObjectRepository.issuedt_cal).sendKeys("13");
					Thread.sleep(500);
					//getElement(ObjectRepository.dob_cal).sendKeys(Keys.TAB);
					verifyText(ObjectRepository.issueDate_alert,"Please enter a valid month");
					
					
					//Entering day in between 32 to 39
					getElement(ObjectRepository.issuedt_cal).click();
					getElement(ObjectRepository.issuedt_cal).clear();
					getElement(ObjectRepository.issuedt_cal).sendKeys("12/33");
					Thread.sleep(500);
					getElement(ObjectRepository.issuedt_cal).sendKeys(Keys.TAB);
					verifyText(ObjectRepository.issueDate_alert,"Please enter a day of 31 or less");
					
					
					//Entering Invalid Year and check
					getElement(ObjectRepository.issuedt_cal).click();
					getElement(ObjectRepository.issuedt_cal).clear();
					getElement(ObjectRepository.issuedt_cal).sendKeys("12/30/19");
					Thread.sleep(500);
					getElement(ObjectRepository.issuedt_cal).sendKeys(Keys.TAB);
					verifyText(ObjectRepository.issueDate_alert,"Please enter a date in the following format: mm/dd/yyyy");
					
					
					//Entering date as 01/01/1889
					getElement(ObjectRepository.issuedt_cal).click();
					getElement(ObjectRepository.issuedt_cal).clear();
					getElement(ObjectRepository.issuedt_cal).sendKeys("01/01/1889");
					getElement(ObjectRepository.issuedt_cal).sendKeys(Keys.TAB);
					verifyText(ObjectRepository.issueDate_alert,"Please enter a valid date between 01/01/1900 and 12/06/2019");
					
					
					//Entering date as 12/06/2020
					getElement(ObjectRepository.issuedt_cal).click();
					getElement(ObjectRepository.issuedt_cal).clear();
					getElement(ObjectRepository.issuedt_cal).sendKeys("12/06/2020");
					getElement(ObjectRepository.issuedt_cal).sendKeys(Keys.TAB);
					verifyText(ObjectRepository.issueDate_alert,"Please enter a valid date between 01/01/1900 and 12/06/2019");
					
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
			test.log(Status.PASS, "Verify application should alert user for invalid Issue Date entries");
		}
	}

	@AfterTest
	public void tearDown() {
		extent.flush();
		driver.quit();
	}

}
