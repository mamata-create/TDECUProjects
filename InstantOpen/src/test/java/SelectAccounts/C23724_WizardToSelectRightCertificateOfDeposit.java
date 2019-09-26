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

public class C23724_WizardToSelectRightCertificateOfDeposit extends GenericKeywords {

	ExtentReports extent;
	ExtentTest test;
	/*
	 * To check right certificate for Deposit
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
	public void C23724_WizardToSelectRightCertificateOfDeposit() throws InterruptedException, MessagingException, IOException
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
					String loanAmount =excl.getCellData(sheetName, 27, startIter);
					String loanTerm =excl.getCellData(sheetName, 28, startIter);
					String serviceOption = " Debit Card, Mobile Check Deposit, Overdraft Protection Plan, Opt into Courtesy Pay";
					String bodyPanelOptions ="A safe, fixed-term investment with great;$1,000 minimum deposit required;https://www.tdecu.org/rates/";
					String wizardOptions ="Search for a CD;Complete the fields below to find a CD that fits your needs!";
					String feeScheduleOptions ="See fee schedule for details on early withdrawal penalties.;https://www.tdecu.org/rates/";
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
						
						
					verifyElementPresent(ObjectRepository.app_ttl);
					test.log(Status.INFO, "Instant Open Title appearing");
					
					scrollToElement(ObjectRepository.nonmmbrstrt_btn);
					getElement(ObjectRepository.nonmmbrstrt_btn).click();
					test.log(Status.INFO, "Non Member Start here button clicked");
					
					Thread.sleep(3000);
					
					
					verifyText(ObjectRepository.inforMsgHeader,informationHeader);
					verifyText(ObjectRepository.inforMsgContent,informationContent);
					verifyText(ObjectRepository.checkingAccountOptionHeader,checkingAccountOptionHeader);
					checkingOptionValidation("Classic Checking");
					serviceOptionValidation("Classic Checking",serviceOption);
					
					getElement(ObjectRepository.selectRadioOption("Yes")).click();
					test.log(Status.INFO, "Other option selected as Yes");
					
					
					getElement(ObjectRepository.subproductName("Certificates of Deposit (CDs)")).click();
					validateVariousOptionFromPage("PanelBody",bodyPanelOptions);
					validateVariousOptionFromPage("Wizard",wizardOptions);
					validateVariousOptionFromPage("feeSchedule",feeScheduleOptions);
					
					getElement(ObjectRepository.loanAmountTxt).sendKeys(loanAmount);
					selectDropdownOpt(ObjectRepository.loanTerm,loanTerm);
					getElement(ObjectRepository.getTermCertificateLocator(loanTerm)).click();
					getElement(ObjectRepository.continue_btn).click();
				    getElement(ObjectRepository.backButton).click();
				   String checkBox = ObjectRepository.getTermCertificateLocator(loanTerm);
				   String checkBoxPropLocator = checkBox+"/../div[1]";
				   if(getElement(checkBoxPropLocator).getAttribute("class").contains("checked")){
					   Assert.assertTrue(true, "Option is checked");
				   }
				   getElement(ObjectRepository.subproductName("Credit Cards")).click();
				  
				   getElement(ObjectRepository.creditCardProduct).click();
				   getElement(ObjectRepository.continue_btn).click();
				   getElement(ObjectRepository.creditcardLimitTxt).sendKeys("1000");
				   getElement(ObjectRepository.edt_btn).click();
				 
				//Application form
					
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
					
					
					getElement(ObjectRepository.phonenmbr_txt).sendKeys(phonenmbr);
					test.log(Status.INFO, "Phone number entered");
					
					selectDropdownOptContain(ObjectRepository.phonetyp_drop, phonetyp);
					test.log(Status.INFO, "Phone type selected");
					
					
					getElement(ObjectRepository.primaryemail_txt).sendKeys(primary_email);
					test.log(Status.INFO, "Primary email entered");
					
					getElement(ObjectRepository.housingPayment).sendKeys("1000");
					getElement(ObjectRepository.addressYearBox).sendKeys("90");
					getElement(ObjectRepository.addressMonthBox).sendKeys("2");
					
					getElement(ObjectRepository.monthlySal).sendKeys("4000");
					getElement(ObjectRepository.employeeDurationYear).sendKeys("99");
					getElement(ObjectRepository.employeeDurationMonth).sendKeys("3");

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
					test.log(Status.INFO, "Confirm Account selections page opened");
					
					getElement(ObjectRepository.cnfrm_btn).click();
					test.log(Status.INFO, "Confirm button clicked");
					
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
					
					getElement(ObjectRepository.getLocatorBasedOnOption("Fairfax, VA")).click();
					test.log(Status.INFO, "corporation verification question answered");
					Thread.sleep(1000);
					
					getElement(ObjectRepository.getLocatorBasedOnOption("None of the above")).click();
					test.log(Status.INFO, "Address verification question answered");
					Thread.sleep(1000);
					
					scrollToElement(ObjectRepository.getLocatorBasedOnOption("None of the above"));

					getElement(ObjectRepository.getLocatorBasedOnOption("Roanoke")).click();
					test.log(Status.INFO, "Background verification question answered");
					Thread.sleep(1000);
					
					

					getElement(ObjectRepository.getLocatorBasedOnOption("800 Gallows Rd")).click();
					test.log(Status.INFO, "Counties verification question answered");
					Thread.sleep(1000);
					

					getElement(ObjectRepository.cnfrm_btn).click();
					test.log(Status.INFO, "Confirm button clicked");
					Thread.sleep(3000);
					
					verifyText(ObjectRepository.accountFundingPage,"Account Funding");
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
			test.log(Status.PASS, "To check right certificate for Deposit");
		}
	}

	@AfterTest
	public void tearDown() {
		extent.flush();
		driver.quit();
	}

}
