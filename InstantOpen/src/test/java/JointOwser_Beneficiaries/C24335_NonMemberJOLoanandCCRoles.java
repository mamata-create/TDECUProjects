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

public class C24335_NonMemberJOLoanandCCRoles extends GenericKeywords{
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
	public void C24335_NonMemberJOLoanandCCRoles() throws InterruptedException, MessagingException, IOException
	{
		
		if(continuetestcase==true)
		{
			sheetName = "DataTwo";
			int totalRowCount = excl.getRowCount(sheetName);
			for(startIter=1;startIter<=totalRowCount;startIter++) //It is mandatory to have this for loop in every test case
			 {	
				if(this.getClass().getSimpleName().equals(excl.getCellData(sheetName, 0, startIter)))
				{
					String ccAmt=excl.getCellData(sheetName, 1, startIter);
					String loanAmt=excl.getCellData(sheetName, 2, startIter);
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
					String housingPayment=excl.getCellData(sheetName, 18, startIter);
					String yearsMonths=excl.getCellData(sheetName, 19, startIter);
					String monthlySal=excl.getCellData(sheetName, 20, startIter);
					String joFname=excl.getCellData(sheetName, 21, startIter);
					String joLname=excl.getCellData(sheetName, 22, startIter);
					String joSSN=excl.getCellData(sheetName, 23, startIter);
					String ccTitle=excl.getCellData(sheetName, 24, startIter);
					String loanTitle=excl.getCellData(sheetName, 25, startIter);
					String shareTitle=excl.getCellData(sheetName, 26, startIter);
					
					scrollToElement(ObjectRepository.nonmmbrstrt_btn);
					getElement(ObjectRepository.nonmmbrstrt_btn).click();
					test.log(Status.INFO, "Non Member Start here button clicked");
					//Select Products
					getElement(ObjectRepository.nochkacnt_rdbtn).click();
					getElement(ObjectRepository.otheOption_prop).click();
					getElement(ObjectRepository.mstrcrdtcard_exp).click();
					getElement(ObjectRepository.classicmstrcrd_opt).click();
					getElement(ObjectRepository.personalLoanExpand).click();
					getElement(ObjectRepository.myWay4000CheckBox).click();
					test.log(Status.INFO, "Credit card and personal loan selected");
					getElement(ObjectRepository.productPageNext).click();
					//Product Info
					getElement(ObjectRepository.prodLimitTextbox).sendKeys(ccAmt);
					getElement(ObjectRepository.edt_btn).click();
					getElement(ObjectRepository.prodLimitTextbox).sendKeys(loanAmt);
					getElement(ObjectRepository.edt_btn).click();
					test.log(Status.INFO, "Credit card and personal loan amount entered");
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
					getElement(ObjectRepository.housingPayment).sendKeys(housingPayment);
					getElement(ObjectRepository.addressYearBox).sendKeys(yearsMonths);
					getElement(ObjectRepository.monthlySal).sendKeys(monthlySal);
					getElement(ObjectRepository.employeeDurationYear).sendKeys(yearsMonths);
					test.log(Status.INFO, "Applicant info entered");
					getElement(ObjectRepository.addJointOwners_CheckBox).click();
					test.log(Status.INFO, "Add Joint Owners selected");
					getElement(ObjectRepository.continue_btn).click();
					getElement(ObjectRepository.fname_txt).sendKeys(joFname);					
					getElement(ObjectRepository.lname_txt).sendKeys(joLname);
					getElement(ObjectRepository.strtaddrs_txt).sendKeys(strtaddress);
					getElement(ObjectRepository.zip_txt).sendKeys(zipcode);		
					test.log(Status.INFO, "Joint owner applicant info entered");
					getElement(ObjectRepository.dob_cal).sendKeys(dob);
					getElement(ObjectRepository.ssn_txt).sendKeys(joSSN);
					selectDropdownOpt(ObjectRepository.idtyp_drop, idtyp);
					getElement(ObjectRepository.idnmbr_txt).sendKeys(idnumber);
					getElement(ObjectRepository.issuedt_cal).sendKeys(issue_dt);
					getElement(ObjectRepository.expdt_cal).sendKeys(expr_dt);
					getElement(ObjectRepository.mothername_txt).sendKeys(mothername);
					getElement(ObjectRepository.occptn_txt).sendKeys(occupation);	
					test.log(Status.INFO, "Joint owner identification info entered");
					getElement(ObjectRepository.phonenmbr_txt).sendKeys(phonenmbr);
					selectDropdownOpt(ObjectRepository.phonetyp_drop, phonetyp);
					getElement(ObjectRepository.primaryemail_txt).sendKeys(primary_email);
					test.log(Status.INFO, "Joint owner contact info entered");
					getElement(ObjectRepository.housingPayment).sendKeys(housingPayment);
					getElement(ObjectRepository.addressMonthBox).sendKeys(yearsMonths);
					getElement(ObjectRepository.currentEmp).sendKeys(crrnt_emplyr);
					getElement(ObjectRepository.monthlySal).sendKeys(monthlySal);
					getElement(ObjectRepository.employeeDurationMonth).sendKeys(yearsMonths);
					test.log(Status.INFO, "Joint owner loan info entered");
					getElement(ObjectRepository.productPageNext).click();
					verifyText(ObjectRepository.rolesProduct(1),ccTitle);
					verifyText(ObjectRepository.rolesProduct(2),loanTitle);
					verifyText(ObjectRepository.rolesProduct(3),shareTitle);
					test.log(Status.INFO, "Products displayed in account roles table");
					verifyElementPresent(ObjectRepository.primaryRole(1));
					verifyElementPresent(ObjectRepository.primaryRole(2));
					verifyElementPresent(ObjectRepository.primaryRole(3));
					test.log(Status.INFO, "Roles for primary applicant are checked and read only");
					verifyElementPresent(ObjectRepository.jointRoleChecked(1));
					verifyElementPresent(ObjectRepository.jointRoleChecked(2));
					verifyElementPresent(ObjectRepository.jointRoleChecked(3));
					test.log(Status.INFO, "Roles for joint owner are checked");
					getElement(ObjectRepository.jointRoleChecked(1)).click();
					getElement(ObjectRepository.jointRoleChecked(1)).click();
					getElement(ObjectRepository.jointRoleChecked(1)).click();
					mouseHoverOver(getElement(ObjectRepository.confirmAccountRole_title));
					verifyElementPresent(ObjectRepository.jointRoleNotChecked(1));
					verifyElementPresent(ObjectRepository.jointRoleNotChecked(2));
					verifyElementPresent(ObjectRepository.jointRoleNotChecked(3));
					test.log(Status.INFO, "Roles for joint owner are deselected");
					getElement(ObjectRepository.productPageNext).click();
					verifyElementPresent(ObjectRepository.memberShipEligibilityPage);
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
			test.log(Status.PASS, "Verify joint owner loan and credit card roles for Non member");
		}
	}

	@AfterTest
	public void tearDown() {
		extent.flush();
		driver.quit();
	}

}
