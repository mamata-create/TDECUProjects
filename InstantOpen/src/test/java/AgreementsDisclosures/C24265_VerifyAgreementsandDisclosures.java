package AgreementsDisclosures;

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

public class C24265_VerifyAgreementsandDisclosures extends GenericKeywords{
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
	public void C24265_VerifyAgreementsandDisclosures() throws InterruptedException, MessagingException, IOException
	{
		
		if(continuetestcase==true)
		{
			sheetName = "DataTwo";
			int totalRowCount = excl.getRowCount(sheetName);
			for(startIter=1;startIter<=totalRowCount;startIter++) //It is mandatory to have this for loop in every test case
			 {	
				if(this.getClass().getSimpleName().equals(excl.getCellData(sheetName, 0, startIter)))
				{
					Faker fk=new Faker();
					String num=getRandom();
					String fname=fk.name().firstName();					
					String lname=fk.name().lastName();			
					String strtaddress=excl.getCellData(sheetName, 3, startIter);
					String zipcode=excl.getCellData(sheetName, 4, startIter);
					String ssn=excl.getCellData(sheetName, 5, startIter);
					ssn=ssn+num;
					String dob=excl.getCellData(sheetName, 6, startIter);
					dob=dob+num;
					String idtyp=excl.getCellData(sheetName, 7, startIter);
					String idnumber=excl.getCellData(sheetName, 8, startIter);
					String issue_dt=excl.getCellData(sheetName, 9, startIter);
					String expr_dt=excl.getCellData(sheetName, 10, startIter);
					String hear_opt=excl.getCellData(sheetName, 11, startIter);
					String mothername=excl.getCellData(sheetName, 12, startIter);
					String crrnt_emplyr=excl.getCellData(sheetName, 13, startIter);
					String occupation=excl.getCellData(sheetName, 14, startIter);
					String phonenmbr=excl.getCellData(sheetName, 15, startIter);
					String phonetyp=excl.getCellData(sheetName, 16, startIter);
					String primary_email=excl.getCellData(sheetName, 17, startIter);
					String errorMsg1=excl.getCellData(sheetName, 18, startIter);
					String discText=excl.getCellData(sheetName, 19, startIter);
					String errorMsg2=excl.getCellData(sheetName, 20, startIter);
					String TINtext=excl.getCellData(sheetName, 21, startIter);
					String errorMsg3=excl.getCellData(sheetName, 22, startIter);
					String BWtext=excl.getCellData(sheetName, 23, startIter);
					String exemptText=excl.getCellData(sheetName, 24, startIter);
					String errorMsg4=excl.getCellData(sheetName, 25, startIter);
					String citizenTxt=excl.getCellData(sheetName, 26, startIter);
					String alienTxt=excl.getCellData(sheetName, 27, startIter);
					String errorMsg5=excl.getCellData(sheetName, 28, startIter);
					String agreeTxt=excl.getCellData(sheetName, 29, startIter);
					String acceptText=excl.getCellData(sheetName, 30, startIter);
					
					scrollToElement(ObjectRepository.nonmmbrstrt_btn);
					getElement(ObjectRepository.nonmmbrstrt_btn).click();
					test.log(Status.INFO, "Non Member Start here button clicked");
					//Select Products
					getElement(ObjectRepository.classicCheck).click();
					getElement(ObjectRepository.othrprdctno_rdbtn).click();
					getElement(ObjectRepository.continue_btn).click();
					test.log(Status.INFO, "Classic Checking with courtesy pay selected");
					//Applicant Info
					getElement(ObjectRepository.fname_txt).sendKeys(fname);//					
					getElement(ObjectRepository.lname_txt).sendKeys(lname);
					getElement(ObjectRepository.strtaddrs_txt).sendKeys(strtaddress);
					getElement(ObjectRepository.zip_txt).sendKeys(zipcode);
					getElement(ObjectRepository.ssn_txt).sendKeys(ssn);
					getElement(ObjectRepository.dob_cal).sendKeys(dob);
					selectDropdownOpt(ObjectRepository.idtyp_drop, idtyp);
					getElement(ObjectRepository.idnmbr_txt).sendKeys(idnumber);
					getElement(ObjectRepository.issuedt_cal).sendKeys(issue_dt);
					getElement(ObjectRepository.expdt_cal).sendKeys(expr_dt);
					selectDropdownOpt(ObjectRepository.hrabttdecu_drop, hear_opt);
					getElement(ObjectRepository.mothername_txt).sendKeys(mothername);
					getElement(ObjectRepository.crrntemplyr_txt).sendKeys(crrnt_emplyr);
					getElement(ObjectRepository.occptn_txt).sendKeys(occupation);
					getElement(ObjectRepository.phonenmbr_txt).sendKeys(phonenmbr);
					selectDropdownOpt(ObjectRepository.phonetyp_drop, phonetyp);
					getElement(ObjectRepository.primaryemail_txt).sendKeys(primary_email);
					getElement(ObjectRepository.continue_btn).click();
					test.log(Status.INFO, "Applicant Information entered");
					//Membership Eligibility
					getElement(ObjectRepository.membership_page_option(3)).click();
					getElement(ObjectRepository.productPageNext).click();
					test.log(Status.INFO, "Membership eligibility selected");
					getElement(ObjectRepository.cnfrm_btn).click();
					test.log(Status.INFO, "Account selections confirmed");
					//Agreements and disclosures
					verifyElementPresent(ObjectRepository.agreementTtl);
					getElement(ObjectRepository.cnfrm_btn).click();
					verifyText(ObjectRepository.errorMsg1,errorMsg1);
					verifyText(ObjectRepository.disclosuresText,discText);
					getElement(ObjectRepository.discCheckBox).click();
					getElement(ObjectRepository.confirmBtn).click();
					verifyText(ObjectRepository.errorMsg1,errorMsg2);
					test.log(Status.INFO, "Terms and Conditions checkbox verified");
					getElement(ObjectRepository.backupWithQstn).click();
					verifyElementPresent(ObjectRepository.backupWithTtl);
					getElement(ObjectRepository.closeBackupWith).click();
					Thread.sleep(1000);
					verifyText(ObjectRepository.disclosures_page_option(1),TINtext);
					getElement(ObjectRepository.TINchkbx).click();
					getElement(ObjectRepository.confirmBtn).click();
					verifyText(ObjectRepository.errorMsg1,errorMsg3);
					test.log(Status.INFO, "Backup Withholding Certifications checkbox verified");
					verifyText(ObjectRepository.disclosures_page_option(2),BWtext);
					verifyText(ObjectRepository.disclosures_page_option(3),exemptText);
					getElement(ObjectRepository.exemptChkbx).click();
					getElement(ObjectRepository.confirmBtn).click();
					verifyText(ObjectRepository.errorMsg1,errorMsg4);
					test.log(Status.INFO, "Backup Withholding or Exempt option selected");
					verifyText(ObjectRepository.disclosures_page_option(4),citizenTxt);
					verifyText(ObjectRepository.disclosures_page_option(5),alienTxt);
					getElement(ObjectRepository.citizenChkbx).click();
					getElement(ObjectRepository.confirmBtn).click();
					verifyText(ObjectRepository.errorMsg1,errorMsg5);
					test.log(Status.INFO, "Resident option selected");
					verifyText(ObjectRepository.disclosures_page_option(6),agreeTxt);
					verifyText(ObjectRepository.acceptText,acceptText);
					getElement(ObjectRepository.agreeChkbx).click();
					test.log(Status.INFO, "Agreement and Signatures checkbox selected");
					getElement(ObjectRepository.backButtonFurther).click();					
					test.log(Status.INFO, "Back button clicked");
					getElement(ObjectRepository.productPageNext).click();
					verifyElementPresent(ObjectRepository.confirmTtl);
					test.log(Status.INFO, "Continue button clicked");
					getElement(ObjectRepository.confirmBtn).click();					
					test.log(Status.INFO, "Confirm button clicked");
					getElement(ObjectRepository.discCheckBox).click();
					getElement(ObjectRepository.TINchkbx).click();
					getElement(ObjectRepository.exemptChkbx).click();
					getElement(ObjectRepository.alienChkbx).click();
					getElement(ObjectRepository.agreeChkbx).click();
					getElement(ObjectRepository.confirmBtn).click();
					verifyElementPresent(ObjectRepository.idnty_ttl);
					test.log(Status.INFO, "Agreements and Disclosures accepted");
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
			test.log(Status.PASS, "Verify Agreements and Disclosures page for Non member");
		}
	}

	@AfterTest
	public void tearDown() {
		extent.flush();
		driver.quit();
	}

}
