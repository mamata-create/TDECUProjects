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

public class C23824_NonMemberUserCanEnterContactInformation extends GenericKeywords {

	ExtentReports extent;
	ExtentTest test;
	/*
	 * Verify that user can enter contact information
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
	public void C23824_NonMemberUserCanEnterContactInformation() throws InterruptedException, MessagingException, IOException
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
					//Entering 10 digit numbers into the field
					getElement(ObjectRepository.phonenmbr_txt).sendKeys(phonenmbr);
					selectDropdownOptContain(ObjectRepository.phonetyp_drop, phonetyp);
					getElement(ObjectRepository.primaryemail_txt).sendKeys(primary_email);
					
					//To check the checkboxes are checked
					getElement(ObjectRepository.addJointOwners_CheckBox).click();
					getElement(ObjectRepository.addBeneficiaries_CheckBox).click();
					boolean flag1 = ObjectRepository.checkBoxProp("//span[@id='cbAddJointOwners']/div").contains("checked");
					boolean flag2 = ObjectRepository.checkBoxProp("//span[@id='cbAddBene']/div").contains("checked");
					if(flag1==flag2==true){
						Assert.assertTrue(true, "Both checkboxes are checked");
					}
					
					//To Check checkboxes are unchecked
					getElement(ObjectRepository.addJointOwners_CheckBox).click();
					getElement(ObjectRepository.addBeneficiaries_CheckBox).click();
					boolean Unflag1 = ObjectRepository.checkBoxProp("//span[@id='cbAddJointOwners']/div").contains("checked");
					boolean Unflag2 = ObjectRepository.checkBoxProp("//span[@id='cbAddBene']/div").contains("checked");
					if(Unflag1==Unflag2==true){
						Assert.assertTrue(true, "Both checkboxes are unchecked");
					}
					
					//Once click on Add More, additional field should displayed
					getElement(ObjectRepository.addMore_checkBox).click();
					String additionalPhone = getElement(ObjectRepository.addPhone).getAttribute("style");
					boolean phoneFlag_checked = additionalPhone.equals("display: block;");
					Assert.assertEquals(phoneFlag_checked, true);
					Thread.sleep(500);
					getElement(ObjectRepository.addMore_checkBox).click();
					boolean phoneFlag_Unchecked = additionalPhone.equals("display: block;");
					Thread.sleep(500);
					Assert.assertEquals(phoneFlag_Unchecked, true);
					verifyText(ObjectRepository.footerString,bottomMsg.trim());
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
			test.log(Status.PASS, "Verify that user can enter contact information");
		}
	}

	@AfterTest
	public void tearDown() {
		extent.flush();
		driver.quit();
	}

}
