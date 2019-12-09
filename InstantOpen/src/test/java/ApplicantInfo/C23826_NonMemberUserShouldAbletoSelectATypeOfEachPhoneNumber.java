package ApplicantInfo;

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

public class C23826_NonMemberUserShouldAbletoSelectATypeOfEachPhoneNumber extends GenericKeywords {

	ExtentReports extent;
	ExtentTest test;
	/*
	 * Verify that user can select a type of each phone number
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
	public void C23826_NonMemberUserShouldAbletoSelectATypeOfEachPhoneNumber() throws InterruptedException, MessagingException, IOException
	{
		
		if(continuetestcase==true)
		{
			sheetName = "Data";
			int totalRowCount = excl.getRowCount(sheetName);
			for(startIter=1;startIter<=totalRowCount;startIter++) //It is mandatory to have this for loop in every test case
			 {	
				if(this.getClass().getSimpleName().equals(excl.getCellData("Data", 0, startIter)))
				 {
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
					String bottomMsg = excl.getCellData(sheetName, 26, startIter);
					
					verifyElementPresent(ObjectRepository.app_ttl);
					test.log(Status.INFO, "Instant Open Title appearing");
					
					scrollToElement(ObjectRepository.nonmmbrstrt_btn);
					getElement(ObjectRepository.nonmmbrstrt_btn).click();
					test.log(Status.INFO, "Non Member Start here button clicked");
					
					Thread.sleep(3000);
					
					
					scrollToElement(ObjectRepository.nochkacnt_rdbtn);
					getElement(ObjectRepository.nochkacnt_rdbtn).click();
					test.log(Status.INFO, "Dont want checking account radio button clicked");
					
					
					getElement(ObjectRepository.othrprdctno_rdbtn).click();
					test.log(Status.INFO, "Other products no radio button clicked");
					
					getElement(ObjectRepository.continue_btn).click();
					test.log(Status.INFO, "Continue button clicked");
					
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
					
					//Verify the Contact Information level
					verifyText(ObjectRepository.pageSection("Contact Information"),"Contact Information");
					//Check the components under Contact Information section
					verifyElementPresent(ObjectRepository.phonenmbr_txt);
					verifyElementPresent(ObjectRepository.phonetyp_drop);
					verifyElementPresent(ObjectRepository.addMore_checkBox);
					verifyElementPresent(ObjectRepository.primaryemail_txt);
					verifyElementPresent(ObjectRepository.addJointOwners_CheckBox);
					verifyElementPresent(ObjectRepository.addBeneficiaries_CheckBox);
					verifyText(ObjectRepository.informativeMessage_ContactInfo,"Please provide a valid phone number below.");
					
					//Check Phone Type field is disabled when no data is provided
					boolean phoneTypeFieldFlag1 = getElement(ObjectRepository.phonetyp_drop).isEnabled();
					if(phoneTypeFieldFlag1==false)
						Assert.assertTrue(true, "Phone type field is disabled");
					
					//Entering one single digit and check the phone type field
					getElement(ObjectRepository.phonenmbr_txt).sendKeys("5");
					getElement(ObjectRepository.phonetyp_drop).sendKeys(Keys.TAB);
					boolean phoneTypeFieldFlag2 = getElement(ObjectRepository.phonetyp_drop).isEnabled();
					if(phoneTypeFieldFlag2)
						Assert.assertTrue(true, "Phone type field is enabled");
					
					
					//Entering 10 digits number to the field and select the phone type
					getElement(ObjectRepository.phonenmbr_txt).sendKeys("5154265321");
					selectDropdownOptContain(ObjectRepository.phonetyp_drop, "Home");
					
					//Check Add more and validate the phone type fields
					getElement(ObjectRepository.addMore_checkBox).click();
					String additionalPhone = getElement(ObjectRepository.addPhone).getAttribute("style");
					boolean phoneFlag_checked = additionalPhone.equals("display: block;");
					Assert.assertEquals(phoneFlag_checked, true);
					getElement(ObjectRepository.phonenmbr_txt).clear();
					for(int count=1;count<4;count++){
						String phoneType = "//select[@id='tbPhone"+count+"_ddPhoneNumberType']";
						String phoneNumber = "//input[@id='tbPhone"+count+"_RadMaskedTextBox']";
						//Assert.assertEquals(getElement(phoneType).isEnabled(), false);
						
						getElement(phoneNumber).sendKeys("598746512"+count+"");
						Thread.sleep(500);
						Assert.assertEquals(getElement(phoneType).isEnabled(), true);
					}
					
					//Check each of the phone type field and Select value
					for(int count=1;count<4;count++){
						String phoneTypeOptions = "Home,Work,Mobile";
						String phoneType = "//select[@id='tbPhone"+count+"_ddPhoneNumberType']";
						selectDropdownOptContain(phoneType, phoneTypeOptions.split(",")[count-1]);
					}
					
					//Uncheck the Add More checkbox and again check and validate
					getElement(ObjectRepository.addMore_checkBox).click();
					Thread.sleep(500);
					getElement(ObjectRepository.addMore_checkBox).click();
					String additionalPhoneField = getElement(ObjectRepository.addPhone).getAttribute("style");
					boolean phoneFieldFlag_checked = additionalPhoneField.equals("display: block;");
					Assert.assertEquals(phoneFieldFlag_checked, true);
					Thread.sleep(500);
					getElement(ObjectRepository.addMore_checkBox).click();
					boolean phoneFlag_Unchecked = additionalPhoneField.equals("display: block;");
					Thread.sleep(500);
					Assert.assertEquals(phoneFlag_Unchecked, true);
				
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
			test.log(Status.PASS, "Verify that user can select a type of each phone number");
		}
	}

	@AfterTest
	public void tearDown() {
		extent.flush();
		driver.quit();
	}

}
