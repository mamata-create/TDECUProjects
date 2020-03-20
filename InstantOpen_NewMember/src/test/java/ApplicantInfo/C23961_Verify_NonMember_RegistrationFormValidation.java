package ApplicantInfo;

import java.io.IOException;
import java.util.List;

import javax.mail.MessagingException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.ClickAction;
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

public class C23961_Verify_NonMember_RegistrationFormValidation extends GenericKeywords {
	ExtentReports extent;
	ExtentTest test;
	public static String fname, lname, StreetAddress, zipcode, ssn, dob, idType, idNumber, issueDate, expiryDate,
			mother_name, currentEmployer, occupation, phone_Number, phone_number_val, phone_type, email_add,
			hearAbout_opt;

	/*
	 * IO: As a non-member applicant, I must enter data in the required field
	 * for the Identification Information section on the Primary Applicant page.
	 * Creation Date: 03/16/2020 Created By: Ashish Completed Date : 03/18/2020
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
	public void C23961_Verify_NonMember_RegistrationFormValidation()
			throws InterruptedException, MessagingException, IOException {

		if (continuetestcase == true) {

			// homePageVerification();

			sheetName = "HomePage";
			getElement(ObjectRepository.newToTDECU_StartHere).click();

			verifyText(ObjectRepository.header_ExisitngMemberandNonMember_Subpages, "Let’s open your new account!");
			test.log(Status.INFO, "Let's Open Your New Account page displayed");

			// If user clicks on continue button without selecting any account
			// type
			getElement(ObjectRepository.button_Continue).click();
			verifyElementPresent(ObjectRepository.errors);
			test.log(Status.INFO,
					"Error Message displayed if user clicks on continue button without selecting any account type");

			// If user clicks on continue button by selecting
			// dont_want_to_Open_CheckingAccount option
			scrollToElement(ObjectRepository.radioButton_dont_want_to_Open_CheckingAccount);
			mouseHoverOverandClick(ObjectRepository.radioButton_dont_want_to_Open_CheckingAccount);
			scrollToElement(ObjectRepository.radioButton_No_Loans_Creditscards);

			mouseHoverOverandClick(ObjectRepository.radioButton_No_Loans_Creditscards);

			getElement(ObjectRepository.button_Continue).click();

			verifyText(ObjectRepository.header_PrimaryApplicantInfo, "Primary Applicant Information");
			test.log(Status.INFO, "Primary Applicant Information page displayed");

			validFormFillup();// This fuction will add data in all the required
								// fields.

			// step 4-5-6
			validate_txt_Field(ObjectRepository.ssn_txt, ssn, ObjectRepository.estric_ssn, "Please enter some text.");
			test.log(Status.PASS, "SSN Field Verified Successfully");

			// step 7-8-9
			validate_txt_Field(ObjectRepository.dateofbirth_txt, dob, ObjectRepository.estric_dob,
					"Please enter a valid date.", "You must be at least 18 to join.");

			test.log(Status.PASS, "DOB Field Verified Successfully");

			// Step 10-11
			validate_dropdown_Field(ObjectRepository.idtyp_drop, idType, ObjectRepository.estric_idType,
					"Please select an ID Type");

			test.log(Status.PASS, "ID Type Field Verified Successfully");

			// step 12-13-14
			validate_dropdown_dependent_Field(ObjectRepository.idtyp_drop, "Drivers License",
					ObjectRepository.state_drop, "Texas", ObjectRepository.estric_state, "Please select a State");
			test.log(Status.PASS, "State Field Verified Successfully");

			// step 15-16-17
			validate_dropdown_dependent_Field(ObjectRepository.idtyp_drop, "Passport", ObjectRepository.country_drop,
					"UNITED STATES", ObjectRepository.estric_country, "Please select a Country");
			test.log(Status.PASS, "Country Field Verified Successfully");

			// step 18-19-20
			validate_txt_Field(ObjectRepository.idnmbr_txt, idNumber, ObjectRepository.estric_idNumber,
					"Please enter an ID Number");
			test.log(Status.PASS, "ID Number Field Verified Successfully");

			// step 21-22-23
			validate_txt_Field(ObjectRepository.issuedt_cal, issueDate, ObjectRepository.estric_issuedate,
					"Please enter an Issue Date");
			test.log(Status.PASS, "Issue Date Field Verified Successfully");

			// step 24-25-26
			validate_txt_Field(ObjectRepository.expdt_cal, expiryDate, ObjectRepository.estric_expirydate,
					"Please enter an Expiration Date");
			test.log(Status.PASS, "Expiry Date Field Verified Successfully");

			// step 27 -28
			validate_dropdown_Field(ObjectRepository.hrabttdecu_drop, hearAbout_opt,
					ObjectRepository.estric_hearAbout_opt, "Please Tell Us How You Heard About Us");
			test.log(Status.PASS, "How did you hear about TDECU?, Field Verified Successfully");

			// step 29-30-31-32
			// selectDropdownOpt(ObjectRepository.hrabttdecu_drop, "TDECU
			// Employee Referral");

			// step 33-34-35
			validate_txt_Field(ObjectRepository.mothername_txt, mother_name, ObjectRepository.estric_mothersmaiden,
					"Please enter your mothers maiden name.");
			test.log(Status.PASS, "Mothers Maiden Name Field Verified Successfully");

			// step 36-37-38
			validate_txt_Field(ObjectRepository.crrntemplyr_txt, currentEmployer,
					ObjectRepository.estric_currentEmployer, "Please enter some text.");
			test.log(Status.PASS, "Current Employer Field Verified Successfully");

			// step 39-40-41
			validate_txt_Field(ObjectRepository.occptn_txt, occupation, ObjectRepository.estric_occupation,
					"Please enter some text.");
			test.log(Status.PASS, "Occupation Field Verified Successfully");

			field_Data_Verification();
		}

	}

	public void field_Data_Verification() {
		// TODO Auto-generated method stub

		verifyTxtValue(ObjectRepository.fname_txt, fname);
		test.log(Status.INFO, "First Name field data displayed");
		verifyTxtValue(ObjectRepository.lname_txt, lname);
		test.log(Status.INFO, "Last Name field data displayed");

		verifyTxtValue(ObjectRepository.strtaddrs_txt, StreetAddress);
		test.log(Status.INFO, "Street Address field data displayed");

		verifyContainsValue(ObjectRepository.zip_txt, zipcode);
		test.log(Status.INFO, "Zip field data displayed");

		test.log(Status.INFO, "Applicant Information section required fields data displayed");

		System.out.println("SSN " + ssn);

		verifyContainsValue(ObjectRepository.ssn_txt, ssn);
		test.log(Status.INFO, "SSN field data displayed");

		verifyTxtValue(ObjectRepository.dateofbirth_txt, dob);
		test.log(Status.INFO, "DOB field data displayed");
		selectDropdownOptContain(ObjectRepository.idtyp_drop, idType);
		test.log(Status.INFO, "ID Type field data displayed");
		verifyTxtValue(ObjectRepository.idnmbr_txt, idNumber);
		test.log(Status.INFO, "ID Number field data displayed");
		verifyTxtValue(ObjectRepository.issuedt_cal, issueDate);
		test.log(Status.INFO, "ID Number field data displayed");
		verifyTxtValue(ObjectRepository.expdt_cal, expiryDate);
		test.log(Status.INFO, "Expiry date field data displayed");
		selectDropdownOptContain(ObjectRepository.hrabttdecu_drop, hearAbout_opt);
		test.log(Status.INFO, "Hear About option field data displayed");
		verifyTxtValue(ObjectRepository.mothername_txt, mother_name);
		test.log(Status.INFO, "mother name field data displayed");
		verifyTxtValue(ObjectRepository.crrntemplyr_txt, currentEmployer);
		test.log(Status.INFO, "Current Employer field data displayed");
		verifyTxtValue(ObjectRepository.occptn_txt, occupation);
		test.log(Status.INFO, "Occupation field data displayed");

	}

	public void validFormFillup() throws InterruptedException {
		sheetName = "HomePage_Data";
		int totalRowCount = excl.getRowCount(sheetName);

		for (startIter = 1; startIter <= totalRowCount; startIter++) {
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
				zipcode = excl.getCellData(sheetName, 9, startIter);
				ssn = "121-45-11";
				ssn = ssn + num;
				dob = excl.getCellData(sheetName, 11, startIter);

				idType = excl.getCellData(sheetName, 12, startIter);
				idNumber = excl.getCellData(sheetName, 13, startIter);
				issueDate = excl.getCellData(sheetName, 14, startIter);
				expiryDate = excl.getCellData(sheetName, 15, startIter);
				mother_name = excl.getCellData(sheetName, 16, startIter);
				currentEmployer = excl.getCellData(sheetName, 17, startIter);
				occupation = excl.getCellData(sheetName, 18, startIter);
				phone_Number = excl.getCellData(sheetName, 19, startIter);
				phone_number_val = "(800) 839-1154";
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

				click_using_Js(ObjectRepository.button_Back);
				Thread.sleep(8500);

			}
		}
	}

	public void homePageVerification() {
		verifyElementPresent(ObjectRepository.progressBar);
		test.log(Status.INFO, "Progressbar Status");
		for (int progressbarindex = 0; progressbarindex < 6; progressbarindex++) {
			String[] progressBarText = { "Start", "Products", "Information", "Verification", "Disclosures", "Funding" };
			verifyText(ObjectRepository.progressBarText(progressbarindex + 1), progressBarText[progressbarindex]);
			test.log(Status.INFO, "Progress Bar Text displayed");

		}

		String page_header = "Are You Ready to Experience the TDECU Difference?";
		verifyText(ObjectRepository.page_header_locator, page_header);
		test.log(Status.INFO, page_header);

		verifyElementPresent(ObjectRepository.sub_Header);
		test.log(Status.INFO, "Apply for your account in minutes!");

		String[] thumbNailText = { "New to TDECU?", "Already a Member?", "Pending Application?" };
		for (int thumbnail = 0; thumbnail <= 2; thumbnail++) {
			verifyText(ObjectRepository.thumbnail_Set(thumbnail + 1), thumbNailText[thumbnail]);
			System.out.println(thumbNailText[thumbnail] + " appearing");
			test.log(Status.INFO, thumbNailText[thumbnail]);

		}

		verifyElementPresent(ObjectRepository.for_CheckingSavings_Cds);
		test.log(Status.INFO, "For checking, savings and CDs Section Displayed");

		verifyElementPresent(ObjectRepository.for_LoansandCreditCards);
		test.log(Status.INFO, "For loans and credit cards Displayed");

		verifyElementPresent(ObjectRepository.frequentlyAskedQuestions_Section);
		test.log(Status.INFO, "frequently Asked Questions Section Displayed");

		scrollDownPage();

		verifyElementPresent(ObjectRepository.importantAccountOpenningInformation);
		test.log(Status.INFO, "IMPORTANT ACCOUNT OPENING INFORMATION Section Displayed");

		scrollUpPage();
	}

	@AfterMethod
	public void afterMethod(ITestResult result) throws Throwable {
		if (result.getStatus() == ITestResult.FAILURE) {
			test.log(Status.FAIL, "Test Failed-" + result.getThrowable());

			takescreenshot(this.getClass().getSimpleName(), test);
		} else {
			test.log(Status.PASS,
					"IO: As a non-member applicant, I must enter data in the required field for the Identification Information section on the Primary Applicant page.");
		}
	}

	@AfterTest
	public void tearDown() {
		extent.flush();
		driver.quit();
	}

}