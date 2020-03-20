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

public class C23861_NonMemberWouldLikeToConfirmAccountSelection extends GenericKeywords  {
	ExtentReports extent;
	ExtentTest test;
	public static String fname,lname,StreetAddress,zipcode,ssn,dob,idType,idNumber,issueDate,expiryDate,mother_name,currentEmployer,occupation,phone_Number,phone_number_val,phone_type,email_add,hearAbout_opt;
	/*
	 * IO: As a non-member applicant, I would like to Confirm my account selections.
	 * @author: apandey
	 * @created: 18March2020
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
	public void C23861_NonMemberWouldLikeToConfirmAccountSelection() throws InterruptedException, MessagingException, IOException
	{
		if(continuetestcase==true)
		{
			//Step 1-2
			verifyElementPresent(ObjectRepository.app_ttl);
			test.log(Status.INFO, "Instant Open Title appearing");
			
			scrollToElement(ObjectRepository.nonmmbrstrt_btn);
			getElement(ObjectRepository.nonmmbrstrt_btn).click();
			test.log(Status.INFO, "Non Member Start here button clicked");

			verifyText(ObjectRepository.header_ExisitngMemberandNonMember_Subpages, "Let’s open your new account!");
			test.log(Status.INFO, "Let's Open Your New Account page displayed");
			
			//Step 3-5
			verifyElementPresent(ObjectRepository.Highyieldchking_opt);
			getElement(ObjectRepository.Highyieldchking_opt).click();
			getElement(ObjectRepository.courtesy_pay).click();
			getElement(ObjectRepository.selectRadioOption("No")).click();
			Thread.sleep(1000);
			getElement(ObjectRepository.continue_btn).click();
			
			verifyText(ObjectRepository.primaryApplicantInfoPageTitle,"Primary Applicant Information");
			test.log(Status.INFO, "Primary Applicant Information page displayed");
			
			//Step 6
			validFormFillup();// This function will add data in all the required fields.
			
			//Step 7
			getElement(ObjectRepository.membership_page_option(1)).click();
			getElement(ObjectRepository.membership_eligiblty_continue_btn).click();
			verifyText(ObjectRepository.cnfrmacnt_ttl,"Confirm Selected Products and Services");
			test.log(Status.INFO,  "Confirm Selected Products and Services is displayed");	
			
			//Step 8	
			scrollToElement(ObjectRepository.confirm_prodt_servc_btn);
			getElement(ObjectRepository.confirm_prodt_servc_btn).click();		
			verifyText(ObjectRepository.agreementTtl,  "Account Agreements and Disclosures");
			test.log(Status.INFO,  "Account Agreements and Disclosures page is displayed");
			
			//Step 9
			scrollToElement(ObjectRepository.back_frm_agreemnt_page);
			getElement(ObjectRepository.back_frm_agreemnt_page).click();
			verifyText(ObjectRepository.header_MembershipEligibility, "Membership Eligibility");
			test.log(Status.INFO, "Membership Eligibility page displayed");
			
			//Step 10
			getElement(ObjectRepository.membership_eligiblty_continue_btn).click();	
			scrollToElement(ObjectRepository.confirm_prodt_servc_btn);
			getElement(ObjectRepository.confirm_prodt_servc_btn).click();
			verifyText(ObjectRepository.agreementTtl,  "Account Agreements and Disclosures");
			test.log(Status.INFO,  "Got back to 'Account Agreements and Disclosures' page");
//			"//*[@id="DisclosuresList01"]/a[1]"
			
//			getElement(ObjectRepository.tnc_chkbx).click();
//			getElement(ObjectRepository.taxpayerIdentificationNumber).click();
//			getElement(ObjectRepository.backupWithholding).click();
//			getElement(ObjectRepository.citizenshipCheckbox).click();
//			getElement(ObjectRepository.agreementAndSignature).click();
//			getElement(ObjectRepository.confirmBtn).click();
//			getElement(ObjectRepository.confirmBtn).click();
//			verifyElementNotPresent(ObjectRepository.mobileRemoteDepositCaptureLink);
//			verifyElementNotPresent(ObjectRepository.courtesyPay);
//			verifyElementNotPresent(ObjectRepository.freqAskQuestions);
			
//			getElement(ObjectRepository.discCheckBox).click();
//			getElement(ObjectRepository.TINchkbx).click();
//			getElement(ObjectRepository.withHldngChkbx).click();
//			
//			getElement(ObjectRepository.citizenChkbx).click();
//			getElement(ObjectRepository.agreeChkbx).click();
//			test.log(Status.INFO, "Agreement and Disclosure options selected");
//			getElement(ObjectRepository.confirmBtn).click();
//			test.log(Status.INFO, "Accept button clicked");
			
			
		}			
	}
	
	public void validFormFillup() throws InterruptedException {
		sheetName = "HomePage_Data";
		int totalRowCount = excl.getRowCount(sheetName);

		for (startIter = 1; startIter <= totalRowCount; startIter++) {
			System.out.println("************* Iteration"+ startIter);
			System.out.println(excl.getCellData(sheetName, 0, startIter));
			if (this.getClass().getSimpleName().equals(excl.getCellData(sheetName, 0, startIter))) {

				String[] sub_section = { excl.getCellData(sheetName, 1, startIter),
						excl.getCellData(sheetName, 2, startIter), excl.getCellData(sheetName, 3, startIter) };

				for (int section = 0; section <= 2; section++) {
					System.out.println(sub_section[section]);
					verifyText(ObjectRepository.header_Section(section + 1), sub_section[section]);
					test.log(Status.INFO, sub_section[section] + " section displayed");

				}

				// validation check
				Faker fk = new Faker();
				String num = getRandom();
				fname = fk.name().firstName();
				System.out.println("Fname " + fname);
				Thread.sleep(5000);
				
				lname = fk.name().lastName();
				System.out.println("Fname " + lname);
	
				StreetAddress = excl.getCellData(sheetName, 8, startIter).toString();
				zipcode =excl.getCellData(sheetName, 9, startIter) ;
				ssn = "121-45-11";
				ssn=ssn+num;
				dob = excl.getCellData(sheetName, 11, startIter);
				
				 idType = excl.getCellData(sheetName, 12, startIter);
				 idNumber = excl.getCellData(sheetName, 13, startIter);
				 issueDate = excl.getCellData(sheetName, 14, startIter);
				 expiryDate = excl.getCellData(sheetName, 15, startIter);
				 mother_name = excl.getCellData(sheetName, 16, startIter);
				 currentEmployer = excl.getCellData(sheetName, 17, startIter);
				 occupation = excl.getCellData(sheetName, 18, startIter);
				 phone_Number = excl.getCellData(sheetName, 19, startIter);
				 phone_number_val="(800) 839-1154";
				 phone_type = excl.getCellData(sheetName, 20, startIter);
				 email_add = excl.getCellData(sheetName, 21, startIter);
				 hearAbout_opt = excl.getCellData(sheetName, 22, startIter);

				System.out.println("dateOfBirth " + dob + " idType " + idType + " idNumber " + idNumber + " issueDate "
						+ issueDate + " expiryDate " + expiryDate + " hearAboutTdecu " + hearAbout_opt);

				getElement(ObjectRepository.fname_txt).sendKeys(fname);
				getElement(ObjectRepository.lname_txt).sendKeys(lname);
				getElement(ObjectRepository.strtaddrs_txt).sendKeys(StreetAddress);
				getElement(ObjectRepository.zip_txt).sendKeys(zipcode);

				getElement(ObjectRepository.ssn_txt).sendKeys(ssn);
				getElement(ObjectRepository.dateofbirth_txt).sendKeys(dob);
				selectDropdownOptContain(ObjectRepository.idtyp_drop, idType);
				test.log(Status.INFO, "ID type selected");

				getElement(ObjectRepository.idnmbr_txt).sendKeys(idNumber);
				test.log(Status.INFO, "ID number entered");

				getElement(ObjectRepository.issuedt_cal).sendKeys(issueDate);
				getElement(ObjectRepository.expdt_cal).sendKeys(expiryDate);

				selectDropdownOptContain(ObjectRepository.hrabttdecu_drop, hearAbout_opt);

				getElement(ObjectRepository.mothername_txt).sendKeys(mother_name);
				getElement(ObjectRepository.crrntemplyr_txt).sendKeys(currentEmployer);
				getElement(ObjectRepository.occptn_txt).sendKeys(occupation);
				getElement(ObjectRepository.phonenmbr_txt).sendKeys(phone_Number);
				selectDropdownOptContain(ObjectRepository.phonetyp_drop, phone_type);
				getElement(ObjectRepository.primaryemail_txt).sendKeys(email_add);

				test.log(Status.INFO, "Form Filled up successfully");
				
				getElement(ObjectRepository.button_Continue).click();
				verifyText(ObjectRepository.header_MembershipEligibility, "Membership Eligibility");
				test.log(Status.INFO, "Membership Eligibility page displayed");
				
				Thread.sleep(8500);			
				
				break;
			}
			
		}
	}
	@AfterMethod
	public void afterMethod(ITestResult result) throws Throwable {
		if (result.getStatus() == ITestResult.FAILURE) {
			test.log(Status.FAIL, "Test Failed-" + result.getThrowable());

			takescreenshot(this.getClass().getSimpleName(), test);
		} else {
			test.log(Status.PASS, "IO: As a non-member applicant, I would like to Confirm my account selections.");
		}
	}

	@AfterTest
	public void tearDown() {
		extent.flush();
//		driver.quit();
	}

}
