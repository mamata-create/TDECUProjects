package com.testcases;

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

public class C24300_VerifyJointOwnerReqFields extends GenericKeywords{
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
  public void C24300_VerifyJointOwnerReqFields() throws InterruptedException, MessagingException, IOException {
	  if(continuetestcase==true)
	  {
			sheetName = "ProdData";
			int totalRowCount = excl.getRowCount(sheetName);
			for(startIter=1;startIter<=totalRowCount;startIter++) //It is mandatory to have this for loop in every test case
			{	
				if(this.getClass().getSimpleName().equals(excl.getCellData("ProdData", 0, startIter)))
				{
					String loanAmt= excl.getCellData(sheetName, 1, startIter);
					String idType= excl.getCellData(sheetName, 2, startIter);
					String idNum= excl.getCellData(sheetName, 3, startIter);
					String issueDt= excl.getCellData(sheetName, 4, startIter);
					String expDt= excl.getCellData(sheetName, 5, startIter);
					String housePymt= excl.getCellData(sheetName, 6, startIter);
					String yrsMonths= excl.getCellData(sheetName, 7, startIter);
					String currentEmp= excl.getCellData(sheetName, 8, startIter);
					String curIncome= excl.getCellData(sheetName, 9, startIter);
					String mmbrNum= excl.getCellData(sheetName, 27, startIter);
					String SSN= excl.getCellData(sheetName, 28, startIter);
					String DOB= excl.getCellData(sheetName, 29, startIter);
					String joFname= excl.getCellData(sheetName, 10, startIter);
					String joLname= excl.getCellData(sheetName, 11, startIter);
					String joDOB= excl.getCellData(sheetName, 12, startIter);
					String joSSN= excl.getCellData(sheetName, 13, startIter);
					String joIdNum= excl.getCellData(sheetName, 14, startIter);
					String joIssueDt= excl.getCellData(sheetName, 15, startIter);
					String joExpDt= excl.getCellData(sheetName, 16, startIter);
					String joMaiden= excl.getCellData(sheetName, 17, startIter);
					String joOccupation= excl.getCellData(sheetName, 18, startIter);
					String joPhone= excl.getCellData(sheetName, 19, startIter);
					String joPhoneType= excl.getCellData(sheetName, 20, startIter);
					String joEmail= excl.getCellData(sheetName, 21, startIter);									
					String textError= excl.getCellData(sheetName, 22, startIter);
					String addrError= excl.getCellData(sheetName, 23, startIter);
					String dobError= excl.getCellData(sheetName, 24, startIter);
					String idTypeError= excl.getCellData(sheetName, 25, startIter);
					String idNumError= excl.getCellData(sheetName, 26, startIter);
					String issueDtError= excl.getCellData(sheetName, 30, startIter);
					String expDtError= excl.getCellData(sheetName, 31, startIter);
					String maidenError= excl.getCellData(sheetName, 32, startIter);
					String phoneError= excl.getCellData(sheetName, 33, startIter);
					String emailError= excl.getCellData(sheetName, 34, startIter);
					String amtError= excl.getCellData(sheetName, 35, startIter);
					String howLongError= excl.getCellData(sheetName, 36, startIter);
					String howLong2Error= excl.getCellData(sheetName, 37, startIter);
					
					scrollToElement(ObjectRepository.mmbrstrt_btn);
					getElement(ObjectRepository.mmbrstrt_btn).click();
					test.log(Status.INFO, "Members Start Here button clicked");
					//Select Products
					getElement(ObjectRepository.personalLoanExpand).click();
					getElement(ObjectRepository.myWay7000CheckBox).click();
					getElement(ObjectRepository.productPageNext).click();
					test.log(Status.INFO, "Personal Loan selected");
					//Loan info
					getElement(ObjectRepository.prodLimitTextbox).sendKeys(loanAmt);
					getElement(ObjectRepository.prodInfoNextButton).click();
					test.log(Status.INFO, "Loan amount entered");
					//Member Verification
					getElement(ObjectRepository.mmbrVerifyNum).sendKeys(mmbrNum);
					getElement(ObjectRepository.mmbrVerifySSN).sendKeys(SSN);
					getElement(ObjectRepository.mmbrVerifyDOB).sendKeys(DOB);
					getElement(ObjectRepository.mmbrVerifyNext).click();					
					test.log(Status.INFO, "Member Verified");
					//Applicant Info
					selectDropdownOpt(ObjectRepository.idType,idType);
					getElement(ObjectRepository.idNum).sendKeys(idNum);
					getElement(ObjectRepository.issueDate).sendKeys(issueDt);
					getElement(ObjectRepository.expDate).sendKeys(expDt);
					getElement(ObjectRepository.housePymt).sendKeys(housePymt);
					getElement(ObjectRepository.addrYears).sendKeys(yrsMonths);
					getElement(ObjectRepository.currentEmp).sendKeys(currentEmp);
					getElement(ObjectRepository.monIncome).sendKeys(curIncome);
					getElement(ObjectRepository.empMonths).sendKeys(yrsMonths);
					test.log(Status.INFO, "Applicant Information entered");
					getElement(ObjectRepository.jtOwnerCheckBox).click();
					getElement(ObjectRepository.productPageNext).click();
					test.log(Status.INFO, "Joint Owner checkbox selected");
					//Joint Owner
					getElement(ObjectRepository.addFname).sendKeys(joFname);
					getElement(ObjectRepository.productPageNext).click();		
					verifyText(ObjectRepository.errorMsg1,textError);
					verifyText(ObjectRepository.errorMsg2,addrError);
					test.log(Status.INFO, "Error messages displayed for Applicant info required fields");
					getElement(ObjectRepository.addLname).sendKeys(joLname);
					getElement(ObjectRepository.sameAddrCbox).click();
					getElement(ObjectRepository.productPageNext).click();
					verifyText(ObjectRepository.errorMsg1,dobError);
					verifyText(ObjectRepository.errorMsg2,textError);
					verifyText(ObjectRepository.errorMsg3,idTypeError);
					verifyText(ObjectRepository.errorMsg4,idNumError);					
					getElement(ObjectRepository.mmbrVerifyDOB).sendKeys(joDOB);
					getElement(ObjectRepository.addSSN).sendKeys(joSSN);
					selectDropdownOpt(ObjectRepository.idType,idType);
					getElement(ObjectRepository.idNum).sendKeys(joIdNum);
					getElement(ObjectRepository.productPageNext).click();
					verifyText(ObjectRepository.errorMsg1,issueDtError);
					verifyText(ObjectRepository.errorMsg2,expDtError);
					verifyText(ObjectRepository.errorMsg3,maidenError);
					verifyText(ObjectRepository.errorMsg4,textError);	
					test.log(Status.INFO, "Error messages displayed for Identification info required fields");				
					getElement(ObjectRepository.issueDate).sendKeys(joIssueDt);
					getElement(ObjectRepository.expDate).sendKeys(joExpDt);
					getElement(ObjectRepository.addMaiden).sendKeys(joMaiden);
					getElement(ObjectRepository.addOccupation).sendKeys(joOccupation);
					getElement(ObjectRepository.productPageNext).click();
					verifyText(ObjectRepository.errorMsg1,phoneError);
					verifyText(ObjectRepository.errorMsg2,emailError);
					verifyText(ObjectRepository.errorMsg3,amtError);
					test.log(Status.INFO, "Error messages displayed for Contact info required fields");
					getElement(ObjectRepository.addPhone).sendKeys(joPhone);
					selectDropdownOpt(ObjectRepository.addPhoneType,joPhoneType);
					getElement(ObjectRepository.addEmail).sendKeys(joEmail);
					getElement(ObjectRepository.housePymt).sendKeys(housePymt);
					getElement(ObjectRepository.addButton).click();
					verifyText(ObjectRepository.errorMsg1,howLongError);
					verifyText(ObjectRepository.errorMsg2,textError);
					verifyText(ObjectRepository.errorMsg3,amtError);
					verifyText(ObjectRepository.errorMsg4,howLong2Error);
					test.log(Status.INFO, "Error messages displayed for Loan info required fields");
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
			test.log(Status.PASS, "Verify joint owner required fields for existing member");
		}
	}

  @AfterTest
  public void tearDown() {
	 extent.flush();
	 driver.quit();
  }

}
