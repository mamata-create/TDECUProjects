package JointOwser_Beneficiaries;

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

public class C24334_NonMemberBeneficiaryMMRole extends GenericKeywords{
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
	public void C24334_NonMemberBeneficiaryMMRole() throws InterruptedException, MessagingException, IOException
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
					String beneFname=excl.getCellData(sheetName, 1, startIter);
					String beneLname=excl.getCellData(sheetName, 2, startIter);
					String beneSSN=excl.getCellData(sheetName, 18, startIter);
					
					scrollToElement(ObjectRepository.nonmmbrstrt_btn);
					getElement(ObjectRepository.nonmmbrstrt_btn).click();
					test.log(Status.INFO, "Non Member Start here button clicked");
					//Select Products
					getElement(ObjectRepository.nochkacnt_rdbtn).click();
					getElement(ObjectRepository.otheOption_prop).click();
					getElement(ObjectRepository.chkingmoneymrkt_exp).click();
					getElement(ObjectRepository.moneymarket_opt).click();
					getElement(ObjectRepository.productPageNext).click();
					test.log(Status.INFO, "Money Market Account selected");
					//Applicant Info
					getElement(ObjectRepository.fname_txt).sendKeys(fname);					
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
					test.log(Status.INFO, "Applicant Information entered");
					getElement(ObjectRepository.addBeneficiaries_CheckBox).click();
					getElement(ObjectRepository.continue_btn).click();
					test.log(Status.INFO, "Add Beneficiaries selected");
					//Beneficiary info
					getElement(ObjectRepository.fname_txt).sendKeys(beneFname);					
					getElement(ObjectRepository.lname_txt).sendKeys(beneLname);
					getElement(ObjectRepository.strtaddrs_txt).sendKeys(strtaddress);
					getElement(ObjectRepository.zip_txt).sendKeys(zipcode);
					getElement(ObjectRepository.ssn_txt).sendKeys(beneSSN);
					getElement(ObjectRepository.dob_cal).sendKeys(dob);
					getElement(ObjectRepository.phonenmbr_txt).sendKeys(phonenmbr);
					selectDropdownOpt(ObjectRepository.phonetyp_drop, phonetyp);
					getElement(ObjectRepository.primaryemail_txt).sendKeys(primary_email);
					test.log(Status.INFO, "Beneficiary Information entered");
					getElement(ObjectRepository.productPageNext).click();
					getElement(ObjectRepository.jointRoleChecked(1)).click();
					mouseHoverOver(getElement(ObjectRepository.confirmAccountRole_title));
					verifyElementPresent(ObjectRepository.jointRoleNotChecked(1));
					getElement(ObjectRepository.jointRoleChecked(1)).click();
					mouseHoverOver(getElement(ObjectRepository.confirmAccountRole_title));
					verifyElementPresent(ObjectRepository.jointRoleNotChecked(2));
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
			test.log(Status.PASS, "Verify beneficiary Money Market roles for Non member");
		}
	}

	@AfterTest
	public void tearDown() {
		extent.flush();
		driver.quit();
	}

}
