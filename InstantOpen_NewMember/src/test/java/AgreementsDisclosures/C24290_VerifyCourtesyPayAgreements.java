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

public class C24290_VerifyCourtesyPayAgreements extends GenericKeywords{
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
	public void C24290_VerifyCourtesyPayAgreements() throws InterruptedException, MessagingException, IOException
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
					String cPayDes= excl.getCellData(sheetName, 18, startIter);
					String overdraft1= excl.getCellData(sheetName, 19, startIter);
					String overdraft2= excl.getCellData(sheetName, 20, startIter);
					String overdraft3= excl.getCellData(sheetName, 21, startIter);
					String cPayInfo= excl.getCellData(sheetName, 22, startIter);
					String FAQone= excl.getCellData(sheetName, 23, startIter);
					String FAQtwo= excl.getCellData(sheetName, 24, startIter);
					String FAQtwoInfo= excl.getCellData(sheetName, 25, startIter);
					String note= excl.getCellData(sheetName, 26, startIter);
					String promoCode = excl.getCellData(sheetName, 31, startIter);
					
					scrollToElement(ObjectRepository.nonmmbrstrt_btn);
					getElement(ObjectRepository.nonmmbrstrt_btn).click();
					test.log(Status.INFO, "Non Member Start here button clicked");
					//Select Products
					getElement(ObjectRepository.classicCheck).click();
					getElement(ObjectRepository.optInCrtsyPay).click();
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
					getElement(ObjectRepository.add_promocode_field).sendKeys(promoCode);
					getElement(ObjectRepository.cnfrm_btn).click();
					test.log(Status.INFO, "Account selections confirmed");
					//Agreements and disclosures
					//Courtesy Pay
					verifyElementPresent(ObjectRepository.courtesyPayTtl);
					verifyText(ObjectRepository.crtsyPayDescOne,cPayDes);
					verifyText(ObjectRepository.crtsyPayInfoOne,overdraft1);
					verifyText(ObjectRepository.crtsyPayInfoTwo,overdraft2);
					verifyText(ObjectRepository.crtsyPayInfoThree,overdraft3);
					verifyText(ObjectRepository.crtsyPayDescTwo,cPayInfo);
					test.log(Status.INFO, "Courtesty Pay info displayed");
					//FAQ
					verifyElementPresent(ObjectRepository.FAQtitle);
					verifyElementPresent(ObjectRepository.belowFAQ);
					scrollToElement(ObjectRepository.FAQone);
					verifyText(ObjectRepository.FAQone,FAQone);
					getElement(ObjectRepository.FAQone).click();
					verifyFAQanswer();
					verifyText(ObjectRepository.FAQtwo,FAQtwo);
					getElement(ObjectRepository.FAQtwo).click();
					verifyElementPresent(ObjectRepository.FAQoneClose);
					verifyText(ObjectRepository.FAQtwoInfo,FAQtwoInfo);
					getElement(ObjectRepository.FAQtwo).click();
					verifyElementPresent(ObjectRepository.FAQtwoClose);
					verifyText(ObjectRepository.crtsyPayNote,note);
					test.log(Status.INFO, "Courtesty Pay FAQs displayed");
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
			test.log(Status.PASS, "Verify Courtesy Pay info on Disclosures page for Non member");
		}
	}

	@AfterTest
	public void tearDown() {
		extent.flush();
		driver.quit();
	}

}
