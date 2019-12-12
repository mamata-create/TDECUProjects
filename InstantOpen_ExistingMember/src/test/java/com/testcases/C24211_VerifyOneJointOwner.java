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

public class C24211_VerifyOneJointOwner extends GenericKeywords{
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
  public void C24211_VerifyOneJointOwner() throws InterruptedException, MessagingException, IOException {
	  if(continuetestcase==true)
	  {
			sheetName = "ProdData";
			int totalRowCount = excl.getRowCount(sheetName);
			for(startIter=1;startIter<=totalRowCount;startIter++) //It is mandatory to have this for loop in every test case
			{	
				if(this.getClass().getSimpleName().equals(excl.getCellData("ProdData", 0, startIter)))
				{
					String loanAmt= excl.getCellData(sheetName, 1, startIter);
					String mmbrNum= excl.getCellData(sheetName, 27, startIter);
					String SSN= excl.getCellData(sheetName, 28, startIter);
					String DOB= excl.getCellData(sheetName, 29, startIter);
					String idType= excl.getCellData(sheetName, 2, startIter);
					String idNum= excl.getCellData(sheetName, 3, startIter);
					String issueDt= excl.getCellData(sheetName, 4, startIter);
					String expDt= excl.getCellData(sheetName, 5, startIter);
					String housePymt= excl.getCellData(sheetName, 6, startIter);
					String addrYears= excl.getCellData(sheetName, 7, startIter);
					String addrMonths= excl.getCellData(sheetName, 8, startIter);
					String currentEmp= excl.getCellData(sheetName, 9, startIter);
					String curIncome= excl.getCellData(sheetName, 10, startIter);
					String empYears= excl.getCellData(sheetName, 11, startIter);
					String empMonths= excl.getCellData(sheetName, 12, startIter);
					String joFname= excl.getCellData(sheetName, 13, startIter);
					String joMname= excl.getCellData(sheetName, 14, startIter);
					String joLname= excl.getCellData(sheetName, 15, startIter);
					String joStreet= excl.getCellData(sheetName, 16, startIter);
					String joZip= excl.getCellData(sheetName, 17, startIter);
					String joDOB= excl.getCellData(sheetName, 18, startIter);
					String joSSN= excl.getCellData(sheetName, 19, startIter);
					String joIdNum= excl.getCellData(sheetName, 20, startIter);
					String joIssueDt= excl.getCellData(sheetName, 21, startIter);
					String joExpDt= excl.getCellData(sheetName, 22, startIter);
					String joMaiden= excl.getCellData(sheetName, 23, startIter);
					String joOccupation= excl.getCellData(sheetName, 24, startIter);
					String joPhone= excl.getCellData(sheetName, 25, startIter);
					String joPhoneType= excl.getCellData(sheetName, 26, startIter);
					String joEmail= excl.getCellData(sheetName, 30, startIter);
					String joHouseType= excl.getCellData(sheetName, 31, startIter);
					String joHousePymt= excl.getCellData(sheetName, 32, startIter);
					String joHouseYrs= excl.getCellData(sheetName, 33, startIter);
					String joHouseMonths= excl.getCellData(sheetName, 34, startIter);
					String joEmpStatus= excl.getCellData(sheetName, 35, startIter);
					String joEmployer= excl.getCellData(sheetName, 36, startIter);
					String joIncome= excl.getCellData(sheetName, 37, startIter);
					String joEmpYrs= excl.getCellData(sheetName, 38, startIter);
					String joEmpMonths= excl.getCellData(sheetName, 39, startIter);
					String joPrevEmp= excl.getCellData(sheetName, 40, startIter);
					String joPrevIncome= excl.getCellData(sheetName, 41, startIter);
					String joPrevYrs= excl.getCellData(sheetName, 42, startIter);
					String joPrevMonths= excl.getCellData(sheetName, 43, startIter);
					
					scrollToElement(ObjectRepository.mmbrstrt_btn);
					getElement(ObjectRepository.mmbrstrt_btn).click();
					test.log(Status.INFO, "Members Start Here button clicked");
					//Select Products
					getElement(ObjectRepository.personalLoanExpand).click();
					getElement(ObjectRepository.cdSecuredCheckBox).click();
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
					getElement(ObjectRepository.addrYears).sendKeys(addrYears);
					getElement(ObjectRepository.addrMonths).sendKeys(addrMonths);
					getElement(ObjectRepository.currentEmp).sendKeys(currentEmp);
					getElement(ObjectRepository.monIncome).sendKeys(curIncome);
					getElement(ObjectRepository.empYears).sendKeys(empYears);
					getElement(ObjectRepository.empMonths).sendKeys(empMonths);
					test.log(Status.INFO, "Applicant Information entered");
					getElement(ObjectRepository.jtOwnerCheckBox).click();
					getElement(ObjectRepository.productPageNext).click();
					test.log(Status.INFO, "Joint Owner checkbox selected");
					//Joint Owner
					verifyElementPresent(ObjectRepository.addOwnerTtl);
					getElement(ObjectRepository.addFname).sendKeys(joFname);
					getElement(ObjectRepository.addMname).sendKeys(joMname);
					getElement(ObjectRepository.addLname).sendKeys(joLname);
					getElement(ObjectRepository.addStreet).sendKeys(joStreet);
					getElement(ObjectRepository.addZip).sendKeys(joZip);
					test.log(Status.INFO, "Applicant Information entered for Joint Owner");
					getElement(ObjectRepository.mmbrVerifyDOB).sendKeys(joDOB);
					getElement(ObjectRepository.addSSN).sendKeys(joSSN);
					selectDropdownOpt(ObjectRepository.idType,idType);
					getElement(ObjectRepository.idNum).sendKeys(joIdNum);
					getElement(ObjectRepository.issueDate).sendKeys(joIssueDt);
					getElement(ObjectRepository.expDate).sendKeys(joExpDt);
					getElement(ObjectRepository.addMaiden).sendKeys(joMaiden);
					getElement(ObjectRepository.addOccupation).sendKeys(joOccupation);
					test.log(Status.INFO, "Identification Information entered for Joint Owner");
					getElement(ObjectRepository.addPhone).sendKeys(joPhone);
					selectDropdownOpt(ObjectRepository.addPhoneType,joPhoneType);
					getElement(ObjectRepository.addEmail).sendKeys(joEmail);
					test.log(Status.INFO, "Contact Information entered for Joint Owner");
					selectDropdownOpt(ObjectRepository.houseType,joHouseType);
					getElement(ObjectRepository.housePymt).sendKeys(joHousePymt);
					getElement(ObjectRepository.addrYears).sendKeys(joHouseYrs);
					getElement(ObjectRepository.addrMonths).sendKeys(joHouseMonths);
					selectDropdownOpt(ObjectRepository.empStatus,joEmpStatus);
					getElement(ObjectRepository.currentEmp).sendKeys(joEmployer);
					getElement(ObjectRepository.monIncome).sendKeys(joIncome);
					getElement(ObjectRepository.empYears).sendKeys(joEmpYrs);
					getElement(ObjectRepository.empMonths).sendKeys(joEmpMonths);
					getElement(ObjectRepository.prevEmp).sendKeys(joPrevEmp);
					getElement(ObjectRepository.prevIncome).sendKeys(joPrevIncome);
					getElement(ObjectRepository.prevYears).sendKeys(joPrevYrs);
					getElement(ObjectRepository.prevMonths).sendKeys(joPrevMonths);
					test.log(Status.INFO, "Loan Information entered for Joint Owner");
					getElement(ObjectRepository.productPageNext).click();
					verifyElementPresent(ObjectRepository.confirmTtl);
					//Confirm Accounts
					getElement(ObjectRepository.confirmBtn).click();
					test.log(Status.INFO, "Account selection confirmed");
					//Agreements and Disclosures
					getElement(ObjectRepository.discCheckBox).click();
					getElement(ObjectRepository.agreeCheckBox).click();
					getElement(ObjectRepository.confirmBtn).click();
					test.log(Status.INFO, "Agreements and Disclosures accepted");
					//Identity Questions
					getElement(ObjectRepository.qstnOneOptnOne).click();
					getElement(ObjectRepository.qstnTwoOptnTwo).click();
					getElement(ObjectRepository.qstnThreeOptnThree).click();
					getElement(ObjectRepository.qstnFourOptnFour).click();
					getElement(ObjectRepository.confirmBtn).click();
					test.log(Status.INFO, "Identity questions answered for primary applicant");
					String joName = joFname+" "+joMname+" "+joLname;
					verifyText(ObjectRepository.IdentityName,joName);
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
			test.log(Status.PASS, "Verify one joint owner added for existing member");
		}
	}

  @AfterTest
  public void tearDown() {
	 extent.flush();
	 driver.quit();
  }

}
