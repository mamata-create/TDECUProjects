package com.testcases;

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

public class C24086_VerifyPrimaryApplicantPage extends GenericKeywords {

	ExtentReports extent;
	ExtentTest test;
	/*
	 * Verify instant open user registration
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
	public void C24086_VerifyPrimaryApplicantPage() throws InterruptedException, MessagingException, IOException
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
					String mname=excl.getCellData(sheetName, 2, startIter);
					String lname=fk.name().lastName();
					String sfxname=excl.getCellData(sheetName, 4, startIter);
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
					String promo_code = excl.getCellData(sheetName, 23, startIter);
					
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
					

					getElement(ObjectRepository.continue_btn).click();
					test.log(Status.INFO, "Continue button clicked");
					Thread.sleep(3000);
					
				// I am a current TDECU member	
					getElement(ObjectRepository.crrnttdecu_opt).click();
					test.log(Status.INFO, "I am a current TDECU member option selected");
					Thread.sleep(1000);
					
					getElement(ObjectRepository.continue_btn).click();
					test.log(Status.INFO, "Continue button clicked");
					Thread.sleep(3000);
				
				//Confirm account selection page
					verifyElementPresent(ObjectRepository.cnfrmacnt_ttl);
					test.log(Status.INFO, "Confirm Selected Products and Services");
					
				//Enter Promo Code
					
					getElement(ObjectRepository.add_promocode_field).sendKeys(promo_code);
					getElement(ObjectRepository.cnfrm_btn).click();
					test.log(Status.INFO, "Confirm button clicked");
					Thread.sleep(3000);
					
					
			// Terms and conditions page	
					scrollToElement(ObjectRepository.tnc_chkbx);
					
					getElement(ObjectRepository.tnc_chkbx).click();
					test.log(Status.INFO, "Term and Conditions check box clicked");
					Thread.sleep(3000);
					
					getElement(ObjectRepository.taxpayerIdentificationNumber).click();
					test.log(Status.INFO, "Tax prayer check box clicked");
					
					getElement(ObjectRepository.backupWithholding).click();
					test.log(Status.INFO, "Backup withholder check box clicked");
					
					getElement(ObjectRepository.citizenshipCheckbox).click();
					test.log(Status.INFO, "Citizenship check box clicked");
					
					scrollToElement(ObjectRepository.agreementAndSignature);
					getElement(ObjectRepository.agreementAndSignature).click();
					test.log(Status.INFO, "Agreement andSignature check box clicked");
					Thread.sleep(3000);
					
					getElement(ObjectRepository.cnfrm_btn).click();
					test.log(Status.INFO, "Confirm button clicked");
					Thread.sleep(3000);
					
				//Identity verification page
					
					verifyElementPresent(ObjectRepository.idnty_ttl);
					test.log(Status.INFO, "Identity verification page opened");
					
					String[]options = new String[]{"Loudon, MD","Foo Bar, Inc","Roanoke","123 W 14th Street"};
					for(String eachOption : options){
						
						
						String locator = "//label[text()='"+eachOption+"']";
						scrollToElement(locator);
						getElement(locator).click();
						test.log(Status.INFO, eachOption+" verification question answered");
					}
					
					
					
				/*	getElement(ObjectRepository.Corporation_Verification).click();
					test.log(Status.INFO, "corporation verification question answered");
					Thread.sleep(1000);
					
					getElement(ObjectRepository.address_Verification).click();
					test.log(Status.INFO, "Address verification question answered");
					Thread.sleep(1000);
					
					scrollToElement(ObjectRepository.background_Verification);

					getElement(ObjectRepository.background_Verification).click();
					test.log(Status.INFO, "Background verification question answered");
					Thread.sleep(1000);
					
					scrollToElement(ObjectRepository.Counties_Verification);

					getElement(ObjectRepository.Counties_Verification).click();
					test.log(Status.INFO, "Counties verification question answered");
					Thread.sleep(1000);*/
					

					getElement(ObjectRepository.cnfrm_btn).click();
					test.log(Status.INFO, "Confirm button clicked");
					Thread.sleep(3000);
					
				//Tax ID Verification
//					getElement(ObjectRepository.uscitizenapply_chkbx).click();
//					test.log(Status.INFO, "us citizen apply check box clicked");
//					
//					getElement(ObjectRepository.backupholding_chkbx).click();
//					test.log(Status.INFO, "Back up holding check box clicked");
//					
//					
//					getElement(ObjectRepository.continue_btn).click();
//					test.log(Status.INFO, "Continue button clicked");
//					Thread.sleep(3000);
					
				//
					getElement(ObjectRepository.shareamnt_txt).sendKeys("5");
					test.log(Status.INFO, "Amount entered");
					
					getElement(ObjectRepository.elctrnc_opt).click();
					test.log(Status.INFO, "Electronic option selected");
					
					getElement(ObjectRepository.rtngnmbr_txt).sendKeys("234567876");
					test.log(Status.INFO, "Routing number entered");
					
					getElement(ObjectRepository.acntnmbr_txt).sendKeys("2345678987");
					test.log(Status.INFO, "Account number entered");
					
					getElement(ObjectRepository.vrfyacnt_btn).click();
					test.log(Status.INFO, "verify account button clicked");
					
					//getElement(ObjectRepository.sbmt_btn).click();
					//test.log(Status.INFO, "Submit button clicked");
					
					verifyElementPresent(ObjectRepository.thnku_ttl);
					test.log(Status.INFO, "Thanku page opened");
					
					getElement(ObjectRepository.sbmtupload_btn).click();
					test.log(Status.INFO, "Submit Upload button clicked");
					
					Thread.sleep(8000);
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
			test.log(Status.PASS, "Verify user registration scenario working fine");
		}
	}

	@AfterTest
	public void tearDown() {
		extent.flush();
		driver.quit();
	}

}
