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

public class C23765_NonMemberUserCanSeeErrorMessageForInvalidDataEntry extends GenericKeywords  {
	ExtentReports extent;
	ExtentTest test;
	/*
	 * Verify that Non member user can see Error message for invalid data entry
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
	public void C23765_NonMemberUserCanSeeErrorMessageForInvalidDataEntry() throws InterruptedException, MessagingException, IOException
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
					
					//Entering Invalid Street address and Valid Zip code in Street and Zip fileds and validate the error message
					
					getElement(ObjectRepository.strtaddrs_txt).sendKeys("123");
					test.log(Status.INFO,  "Invalid  Street Address entered");
					
					getElement(ObjectRepository.strtaddrs_txt).sendKeys(Keys.TAB);
					test.log(Status.INFO,  "Tab pressed");
					
					getElement(ObjectRepository.zip_txt).sendKeys(zipcode);
					getElement(ObjectRepository.strtaddrs_txt).sendKeys(Keys.TAB);
					Thread.sleep(1500);
					verifyText(ObjectRepository.addressNotVerified_alert,"The address could not be verified. Please check the information and try again.");
					
					//Entering only invalid numbers in both of the fields and validate error message
					
					getElement(ObjectRepository.strtaddrs_txt).clear();
					getElement(ObjectRepository.strtaddrs_txt).sendKeys("123");
					
					getElement(ObjectRepository.strtaddrs_txt).sendKeys(Keys.TAB);
					test.log(Status.INFO,  "Tab pressed");
					getElement(ObjectRepository.zip_txt).clear();
					getElement(ObjectRepository.zip_txt).sendKeys("256");
					getElement(ObjectRepository.zip_txt).sendKeys(Keys.TAB);
					Thread.sleep(1500);
					verifyText(ObjectRepository.addressNotVerified_alert,"The address could not be verified. Please check the information and try again.");
					
					//Entering Invalid letters in both of the fields and validate error message
					
					getElement(ObjectRepository.strtaddrs_txt).clear();
					getElement(ObjectRepository.strtaddrs_txt).sendKeys("Street Address");
					
					getElement(ObjectRepository.strtaddrs_txt).sendKeys(Keys.TAB);
					test.log(Status.INFO,  "Tab pressed");
					
					getElement(ObjectRepository.zip_txt).clear();
					getElement(ObjectRepository.zip_txt).sendKeys("Zip code");
					getElement(ObjectRepository.zip_txt).sendKeys(Keys.TAB);
					Thread.sleep(1500);
					verifyText(ObjectRepository.addressNotVerified_alert,"The address could not be verified. Please check the information and try again.");	
					
					//Entering all special characters and validate error message
					getElement(ObjectRepository.strtaddrs_txt).clear();
					getElement(ObjectRepository.strtaddrs_txt).sendKeys("!@#$%");
					
					getElement(ObjectRepository.strtaddrs_txt).sendKeys(Keys.TAB);
					test.log(Status.INFO,  "Tab pressed");
					
					getElement(ObjectRepository.zip_txt).clear();
					getElement(ObjectRepository.zip_txt).sendKeys("%^&*");
					getElement(ObjectRepository.zip_txt).sendKeys(Keys.TAB);
					Thread.sleep(1500);
					verifyText(ObjectRepository.addressNotVerified_alert,"The address could not be verified. Please check the information and try again.");	
					
					//Entering combination of number, letter and  special characters and validate error message
					
					getElement(ObjectRepository.strtaddrs_txt).clear();
					getElement(ObjectRepository.strtaddrs_txt).sendKeys("Street123#$%");
					
					getElement(ObjectRepository.strtaddrs_txt).sendKeys(Keys.TAB);
					test.log(Status.INFO,  "Tab pressed");
					
					getElement(ObjectRepository.zip_txt).clear();
					getElement(ObjectRepository.zip_txt).sendKeys("Zip567&^*");
					getElement(ObjectRepository.zip_txt).sendKeys(Keys.TAB);
					Thread.sleep(1500);
					verifyText(ObjectRepository.addressNotVerified_alert,"The address could not be verified. Please check the information and try again.");	
					
					//Entering valid street address and zip code and validate
					
					getElement(ObjectRepository.strtaddrs_txt).clear();
					getElement(ObjectRepository.strtaddrs_txt).sendKeys(strtaddress);
					getElement(ObjectRepository.zip_txt).clear();
					getElement(ObjectRepository.zip_txt).sendKeys(zipcode);
					getElement(ObjectRepository.zip_txt).sendKeys(Keys.TAB);
					getElement(ObjectRepository.strtaddrs_txt).click();
					getElement(ObjectRepository.strtaddrs_txt).clear();
					getElement(ObjectRepository.strtaddrs_txt).sendKeys(strtaddress);
					getElement(ObjectRepository.zip_txt).sendKeys(Keys.TAB);
					Thread.sleep(1500);
					verifyText(ObjectRepository.addressNotVerified_alert,"Verified!");
					
					//Entering invalid street address but valid zip code and validate error message
					getElement(ObjectRepository.strtaddrs_txt).clear();
					getElement(ObjectRepository.strtaddrs_txt).sendKeys("123");
					test.log(Status.INFO,  "Invalid  Street Address entered");
					
					getElement(ObjectRepository.strtaddrs_txt).sendKeys(Keys.TAB);
					test.log(Status.INFO,  "Tab pressed");
					getElement(ObjectRepository.zip_txt).clear();
					getElement(ObjectRepository.zip_txt).sendKeys(zipcode);
					getElement(ObjectRepository.zip_txt).sendKeys(Keys.TAB);
					Thread.sleep(1500);
					verifyText(ObjectRepository.addressNotVerified_alert,"The address could not be verified. Please check the information and try again.");
					
					//Entering valid street address and zip code and validate
					
					getElement(ObjectRepository.strtaddrs_txt).clear();
					getElement(ObjectRepository.strtaddrs_txt).sendKeys(strtaddress);
					getElement(ObjectRepository.zip_txt).clear();
					getElement(ObjectRepository.zip_txt).sendKeys(zipcode);
					getElement(ObjectRepository.zip_txt).sendKeys(Keys.TAB);
					getElement(ObjectRepository.strtaddrs_txt).click();
					getElement(ObjectRepository.strtaddrs_txt).clear();
					getElement(ObjectRepository.strtaddrs_txt).sendKeys(strtaddress);
					getElement(ObjectRepository.zip_txt).sendKeys(Keys.TAB);
					Thread.sleep(1500);
					verifyText(ObjectRepository.addressNotVerified_alert,"Verified!");	
					
					//Entering valid Street address but invalid zip code
					getElement(ObjectRepository.strtaddrs_txt).clear();
					getElement(ObjectRepository.strtaddrs_txt).sendKeys(strtaddress);
					test.log(Status.INFO,  "Invalid  Street Address entered");
					
					getElement(ObjectRepository.strtaddrs_txt).sendKeys(Keys.TAB);
					test.log(Status.INFO,  "Tab pressed");
					
					getElement(ObjectRepository.zip_txt).clear();
					getElement(ObjectRepository.zip_txt).sendKeys("123");
					getElement(ObjectRepository.zip_txt).sendKeys(Keys.TAB);
					Thread.sleep(1500);
					verifyText(ObjectRepository.addressNotVerified_alert,"The address could not be verified. Please check the information and try again.");
					
					//Entering valid street address and zip code and validate
					
					getElement(ObjectRepository.strtaddrs_txt).clear();
					getElement(ObjectRepository.strtaddrs_txt).sendKeys(strtaddress);
					getElement(ObjectRepository.zip_txt).clear();
					getElement(ObjectRepository.zip_txt).sendKeys(zipcode);
					getElement(ObjectRepository.zip_txt).sendKeys(Keys.TAB);
					getElement(ObjectRepository.strtaddrs_txt).click();
					getElement(ObjectRepository.strtaddrs_txt).clear();
					getElement(ObjectRepository.strtaddrs_txt).sendKeys(strtaddress);
					getElement(ObjectRepository.zip_txt).sendKeys(Keys.TAB);
					Thread.sleep(1500);
					verifyText(ObjectRepository.addressNotVerified_alert,"Verified!");
				
					
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
			test.log(Status.PASS, "Verify that Non member user can see Error message for invalid data entry");
		}
	}

	@AfterTest
	public void tearDown() {
		extent.flush();
		driver.quit();
	}

}
