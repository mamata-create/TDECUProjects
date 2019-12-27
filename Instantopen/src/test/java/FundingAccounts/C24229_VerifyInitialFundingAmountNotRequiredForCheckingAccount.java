package FundingAccounts;

import java.io.IOException;

import javax.mail.MessagingException;

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

public class C24229_VerifyInitialFundingAmountNotRequiredForCheckingAccount  extends GenericKeywords{
	ExtentReports extent;
	ExtentTest test;
	
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
  public void C24229_VerifyInitialFundingAmountNotRequiredForCheckingAccount() throws InterruptedException, MessagingException, IOException {
	  if(continuetestcase==true)
	  {
			sheetName = "Data";
			int totalRowCount = excl.getRowCount(sheetName);
			for(startIter=1;startIter<=totalRowCount;startIter++) //It is mandatory to have this for loop in every test case
			{	
				if(this.getClass().getSimpleName().equals(excl.getCellData("Data", 0, startIter)))
				 {
					Faker fk=new Faker();
					String num=getRandomFourDigit();
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
					String informationHeader=excl.getCellData(sheetName, 23, startIter);
					String informationContent = excl.getCellData(sheetName, 24, startIter);
					String checkingAccountOptionHeader =  excl.getCellData(sheetName, 25, startIter);
					
					
					verifyElementPresent(ObjectRepository.app_ttl);
					test.log(Status.INFO, "Instant Open Title appearing");
					
					scrollToElement(ObjectRepository.nonmmbrstrt_btn);
					getElement(ObjectRepository.nonmmbrstrt_btn).click();
					test.log(Status.INFO, "Non Members Start Here button clicked");
					Thread.sleep(4000);
					
				//checking account option selected	
					scrollToElement(ObjectRepository.clscchking_opt);
					Thread.sleep(2000);
					getElement(ObjectRepository.clscchking_opt).click();
					test.log(Status.INFO, "Classic checking account option selected");
				
					Thread.sleep(4000);
					
					getElement(ObjectRepository.needloan_no).click();
					test.log(Status.INFO, "No option selected");
					
					Thread.sleep(2000);
					getElement(ObjectRepository.productPageNext).click();
					test.log(Status.INFO, "Continue button clicked");
				
					//Primary Applicant info page
					verifyElementPresent(ObjectRepository.primaryApplicantInfoPageTitle);
					verifyElementPresent(ObjectRepository.aplcntinfo_ttl);
					verifyElementPresent(ObjectRepository.idntfctninfo_ttl);
					//verifyElementPresent(ObjectRepository.loaninfo_ttl);
					test.log(Status.INFO, "Primary Applicant Information page appeared with all sections");
					
				//Enter applicant information
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
					test.log(Status.INFO, "Phone number entered");
					
					selectDropdownOptContain(ObjectRepository.phonetyp_drop, phonetyp);
					test.log(Status.INFO, "Phone type selected");
					
					getElement(ObjectRepository.primaryemail_txt).sendKeys(primary_email);
					test.log(Status.INFO, "Primary email address entered");
					
					getElement(ObjectRepository.continue_further).click();
					Thread.sleep(5000);
					test.log(Status.INFO, "Continue button clicked from primary applicant page");
			//Membership Eligibility page		
					verifyElementPresent(ObjectRepository.memberShipEligibilityPage);
					test.log(Status.INFO, "Navigated to Member Eligibility Page successfully");
					
					
					verifyElementPresent(ObjectRepository.mmbrtdecu_opt);
					verifyElementPresent(ObjectRepository.mmbremploy_opt);
					verifyElementPresent(ObjectRepository.mmbrship_opt);
					verifyElementPresent(ObjectRepository.livework_opt);
					test.log(Status.INFO, "All four options appear on Membership eligibility page");
					
					scrollToElement(ObjectRepository.livework_opt);
					Thread.sleep(2000);
					getElement(ObjectRepository.livework_opt).click();
					test.log(Status.INFO, "Membership eligibility- Live work option selected");
					
					verifyElementPresent(ObjectRepository.communitieslist_lnk);
					test.log(Status.INFO, "View List of communities link appearing under Live work option");
			
			        getElement(ObjectRepository.productPageNext).click();
					test.log(Status.INFO, "Continue button clicked from membership eligibility page");
						
					verifyElementPresent(ObjectRepository.cnfrmacntslctn_ttl);
					test.log(Status.INFO, "Confirm account selection page title appearing correctly");
			
					getElement(ObjectRepository.svcontinue_btn).click();
					test.log(Status.INFO, "Confirm button clicked from confirm account selection page");
					
				//Agreement and disclosure 
					verifyElementPresent(ObjectRepository.acntagrmnt_ttl);
					test.log(Status.INFO, "Account Agreement page title appearing correctly");
			
					
					//selecting disclosure check box
					getElement(ObjectRepository.dsclsr_chkbx).click();
					test.log(Status.INFO, "Disclosure check box selected");
					
				
						
					getElement(ObjectRepository.tin_chkbx).click();
					test.log(Status.INFO, "TIN Check box selected");
					
				
				//	Please select options
					verifyElementPresent(ObjectRepository.backupwithold_opt);
					test.log(Status.INFO, "Back up withholding option  appearing correctly");
			
					verifyElementPresent(ObjectRepository.exmpt_opt);
					test.log(Status.INFO, "Exempt option appearing correctly");
			
					getElement(ObjectRepository.backupwithold_chkbx).click();
					test.log(Status.INFO, "backup withholding Check box selected");
					
				//Citizen options
					verifyElementPresent(ObjectRepository.uscitizen_opt);
					test.log(Status.INFO, "US Citizen option appearing correctly");
			
					verifyElementPresent(ObjectRepository.aliens_opt);
					test.log(Status.INFO, "Aliens option appearing correctly");
			
					getElement(ObjectRepository.uscitizen_chkbx).click();
					test.log(Status.INFO, "US Citizen Check box selected");
						
				// Agreement option
					getElement(ObjectRepository.aggrmnt_chkbx).click();
					test.log(Status.INFO, "Agreement Check box selected");
					
					getElement(ObjectRepository.svcontinue_btn).click();
					test.log(Status.INFO, "Accept button clicked from agreement and disclosure page");
					
				// Identity Verification
					verifyElementPresent(ObjectRepository.idntvrf_ttl);
					test.log(Status.INFO, "Identity Verification page title appearing correctly");
					
					getElement(ObjectRepository.idntvrf_ans1).click();
					test.log(Status.INFO, "Identity verification question1 answer selected");
					
					getElement(ObjectRepository.idntvrf_ans2).click();
					test.log(Status.INFO, "Identity verification question2 answer selected");
					
					getElement(ObjectRepository.idntvrf_ans3).click();
					test.log(Status.INFO, "Identity verification question3 answer selected");
					
					getElement(ObjectRepository.idntvrf_ans4).click();
					test.log(Status.INFO, "Identity verification question4 answer selected");
					
					getElement(ObjectRepository.svcontinue_btn).click();
					test.log(Status.INFO, "Continue button clicked from Identity Verification page");
					
				//Account Funding
					verifyElementPresent(ObjectRepository.acntfnd_ttl);
					test.log(Status.INFO, "Account Funding page title appearing correctly");
					
					verifyElementPresent(ObjectRepository.elctrnchk_opt);
					verifyElementPresent(ObjectRepository.dbtcreditcrd_opt);
					test.log(Status.INFO, "Electronic check and Debit Card options appearing correctly");
					
					getElement(ObjectRepository.elctrnchk_opt).click();
					test.log(Status.INFO, "Electronic Check option selected");
					
					verifyElementPresent(ObjectRepository.sbmtapp_info1);
					verifyElementPresent(ObjectRepository.sbmtapp_info2);
					test.log(Status.INFO, "Submit Application information appearing correctly");
					
					getElement(ObjectRepository.sbmtapp_btn).click();
					test.log(Status.INFO, "Submit Application button clicked");
					
					
					
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
			test.log(Status.PASS, "Verify initial funding amount not required for checking account scenario working fine");
		}
	}

  @AfterTest
  public void tearDown() {
	 extent.flush();
	 driver.quit();
  }

}
