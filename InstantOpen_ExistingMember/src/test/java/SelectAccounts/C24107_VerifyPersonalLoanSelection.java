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

public class C24107_VerifyPersonalLoanSelection extends GenericKeywords {
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
  public void C24107_VerifyPersonalLoanSelection() throws InterruptedException, MessagingException, IOException {
	  if(continuetestcase==true)
	  {
			sheetName = "ProdData";
			int totalRowCount = excl.getRowCount(sheetName);
			for(startIter=1;startIter<=totalRowCount;startIter++) //It is mandatory to have this for loop in every test case
			{	
				if(this.getClass().getSimpleName().equals(excl.getCellData("ProdData", 0, startIter)))
				{
					String stormTitle = excl.getCellData(sheetName, 9, startIter);
					String my4000Title= excl.getCellData(sheetName, 1, startIter);
					String termNum;
					String monthTerm= excl.getCellData(sheetName, 16, startIter);
					String noCollatReq= excl.getCellData(sheetName, 17, startIter);
					String myWayAPR= excl.getCellData(sheetName, 18, startIter);
					String min4000= excl.getCellData(sheetName, 11, startIter);
					String my6000Title= excl.getCellData(sheetName, 2, startIter);
					String min6000= excl.getCellData(sheetName, 12, startIter);
					String my7000Title= excl.getCellData(sheetName, 3, startIter);
					String min7000= excl.getCellData(sheetName, 13, startIter);
					String personalTitle= excl.getCellData(sheetName, 4, startIter);
					String personalDesc1= excl.getCellData(sheetName, 19, startIter);
					String ratesDesc= excl.getCellData(sheetName, 20, startIter);
					String min1000= excl.getCellData(sheetName, 14, startIter);
					String homeAdvTitle= excl.getCellData(sheetName, 5, startIter);
					String cash$tashLOCTitle= excl.getCellData(sheetName, 6, startIter);
					String cdLoanTitle= excl.getCellData(sheetName, 7, startIter);
					String ssLoanTitle= excl.getCellData(sheetName, 8, startIter);
					String ssLoanDesc1= excl.getCellData(sheetName, 21, startIter);
					String ssLoanDesc2= excl.getCellData(sheetName, 22, startIter);
					String min500= excl.getCellData(sheetName, 15, startIter);
					String ccAmount= excl.getCellData(sheetName, 23, startIter);
					String loanAmount= excl.getCellData(sheetName, 24, startIter);
					String mmbrNum= excl.getCellData(sheetName, 27, startIter);
					String SSN= excl.getCellData(sheetName, 28, startIter);
					String DOB= excl.getCellData(sheetName, 29, startIter);
					String idTypeDD= excl.getCellData(sheetName, 25, startIter);
					String idNumber= excl.getCellData(sheetName, 26, startIter);
					String issueDt= excl.getCellData(sheetName, 30, startIter);
					String expireDt= excl.getCellData(sheetName, 31, startIter);
					String housePymt= excl.getCellData(sheetName, 32, startIter);
					String addrYears= excl.getCellData(sheetName, 33, startIter);
					String addrMonths= excl.getCellData(sheetName, 34, startIter);
					String currentEmp= excl.getCellData(sheetName, 35, startIter);
					String curIncome= excl.getCellData(sheetName, 36, startIter);
					String empYears= excl.getCellData(sheetName, 37, startIter);
					String empMonths= excl.getCellData(sheetName, 38, startIter);
					String confirmProd= excl.getCellData(sheetName, 10, startIter);
					
					scrollToElement(ObjectRepository.mmbrstrt_btn);
					getElement(ObjectRepository.mmbrstrt_btn).click();
					test.log(Status.INFO, "Members Start Here button clicked");
					
					getElement(ObjectRepository.personalLoanExpand).click();
					test.log(Status.INFO, "Personal Loan section expanded");
					
					//Verify Storm Relief section					
					verifyText(ObjectRepository.stormTitle,stormTitle);
					getElement(ObjectRepository.stormCheckBox).click();
					test.log(Status.INFO, "Storm Relief loan selected");
					stormLoanInfoValidation();
					verifyHereLink(11);
					getElement(ObjectRepository.productPageNext).click();
					test.log(Status.INFO, "Continue button clicked");
					//Personal Loan Info page
					verifyDropdownSelection(ObjectRepository.prodTypeDropdown,stormTitle);
					verifyPlaceholder(ObjectRepository.prodLimitTextbox,min500);
					//Back to Product Selection Page
					getElement(ObjectRepository.prodInfoBackButton).click();
					test.log(Status.INFO, "Back Button clicked");
					verifyElementPresent(ObjectRepository.stormCheckedBox);
					
					//Verify My Way Loan:$4,000 section					
					verifyText(ObjectRepository.myWay4000Title,my4000Title);
					getElement(ObjectRepository.myWay4000CheckBox).click();
					test.log(Status.INFO, "My Way Loan:$4,000 selected");
					termNum = "48";
					verifyText(ObjectRepository.myWay48Term,(termNum+" "+monthTerm));
					verifyText(ObjectRepository.myWay4000Collat,noCollatReq);
					verifyText(ObjectRepository.myWay4000APR,myWayAPR);
					getElement(ObjectRepository.productPageNext).click();
					test.log(Status.INFO, "Continue button clicked");
					//Personal Loan Info page
					verifyDropdownSelection(ObjectRepository.prodTypeDropdown,my4000Title);
					verifyPlaceholder(ObjectRepository.prodLimitTextbox,min4000);
					//Back to Product Selection Page
					getElement(ObjectRepository.prodInfoBackButton).click();
					test.log(Status.INFO, "Back Button clicked");
					verifyElementPresent(ObjectRepository.myWay4000CheckedBox);
					
					//Verify My Way Loan:$6,000 section					
					verifyText(ObjectRepository.myWay6000Title,my6000Title);
					getElement(ObjectRepository.myWay6000CheckBox).click();
					test.log(Status.INFO, "My Way Loan:$6,000 selected");
					termNum = "60";
					verifyText(ObjectRepository.myWay60Term,(termNum+" "+monthTerm));
					verifyText(ObjectRepository.myWay6000Collat,noCollatReq);
					verifyText(ObjectRepository.myWay6000APR,myWayAPR);
					getElement(ObjectRepository.productPageNext).click();
					test.log(Status.INFO, "Continue button clicked");
					//Personal Loan Info page
					verifyDropdownSelection(ObjectRepository.prodTypeDropdown,my6000Title);
					verifyPlaceholder(ObjectRepository.prodLimitTextbox,min6000);
					//Back to Product Selection Page
					getElement(ObjectRepository.prodInfoBackButton).click();
					test.log(Status.INFO, "Back Button clicked");
					verifyElementPresent(ObjectRepository.myWay6000CheckedBox);
					
					//Verify My Way Loan:$7,000 section					
					verifyText(ObjectRepository.myWay7000Title,my7000Title);
					getElement(ObjectRepository.myWay7000CheckBox).click();
					test.log(Status.INFO, "My Way Loan:$7,000 selected");
					termNum = "72";
					verifyText(ObjectRepository.myWay72Term,(termNum+" "+monthTerm));
					verifyText(ObjectRepository.myWay7000Collat,noCollatReq);
					verifyText(ObjectRepository.myWay7000APR,myWayAPR);
					getElement(ObjectRepository.productPageNext).click();
					test.log(Status.INFO, "Continue button clicked");
					//Personal Loan Info page
					verifyDropdownSelection(ObjectRepository.prodTypeDropdown,my7000Title);
					verifyPlaceholder(ObjectRepository.prodLimitTextbox,min7000);
					//Back to Product Selection Page
					getElement(ObjectRepository.prodInfoBackButton).click();
					test.log(Status.INFO, "Back Button clicked");
					verifyElementPresent(ObjectRepository.myWay7000CheckedBox);
					
					//Verify Personal Loan section					
					verifyText(ObjectRepository.personalTitle,personalTitle);
					getElement(ObjectRepository.personalCheckBox).click();
					test.log(Status.INFO, "Personal Loan selected");
					verifyText(ObjectRepository.personalDesc1,personalDesc1);
					verifyText(ObjectRepository.personalDesc2,ratesDesc);
					verifyHereLink(12);
					getElement(ObjectRepository.productPageNext).click();
					test.log(Status.INFO, "Continue button clicked");
					//Personal Loan Info page
					verifyDropdownSelection(ObjectRepository.prodTypeDropdown,personalTitle);
					verifyPlaceholder(ObjectRepository.prodLimitTextbox,min1000);
					//Back to Product Selection Page
					getElement(ObjectRepository.prodInfoBackButton).click();
					test.log(Status.INFO, "Back Button clicked");
					verifyElementPresent(ObjectRepository.personalCheckedBox);
					
					//Verify Home Advantage Personal Loan section
					scrollToElement(ObjectRepository.homeAdvTitle);
					verifyText(ObjectRepository.homeAdvTitle,homeAdvTitle);
					getElement(ObjectRepository.homeAdvCheckBox).click();
					test.log(Status.INFO, "Home Advantage Personal Loan selected");
					homeAdvLoanInfoValidation();
					verifyHereLink(13);
					getElement(ObjectRepository.productPageNext).click();
					test.log(Status.INFO, "Continue button clicked");
					//Personal Loan Info page
					verifyDropdownSelection(ObjectRepository.prodTypeDropdown,homeAdvTitle);
					verifyPlaceholder(ObjectRepository.prodLimitTextbox,min1000);
					//Back to Product Selection Page
					getElement(ObjectRepository.prodInfoBackButton).click();
					test.log(Status.INFO, "Back Button clicked");
					verifyElementPresent(ObjectRepository.homeAdvCheckedBox);
					
					//Verify Cash $tash LOC section
					scrollToElement(ObjectRepository.cash$tashTitle);
					verifyText(ObjectRepository.cash$tashTitle,cash$tashLOCTitle);
					getElement(ObjectRepository.cash$tashCheckBox).click();
					test.log(Status.INFO, "Cash $tash Line of Credit selected");
					cash$tashLOCInfoValidation();
					verifyHereLink(14);
					getElement(ObjectRepository.productPageNext).click();
					test.log(Status.INFO, "Continue button clicked");
					//Personal Loan Info page
					verifyDropdownSelection(ObjectRepository.prodTypeDropdown,cash$tashLOCTitle);
					verifyPlaceholder(ObjectRepository.prodLimitTextbox,min1000);
					//Back to Product Selection Page
					getElement(ObjectRepository.prodInfoBackButton).click();
					test.log(Status.INFO, "Back Button clicked");
					verifyElementPresent(ObjectRepository.cash$tashCheckedBox);
					
					//Verify CD Secured Loan section
					scrollToElement(ObjectRepository.cdSecuredTitle);
					verifyText(ObjectRepository.cdSecuredTitle,cdLoanTitle);
					getElement(ObjectRepository.cdSecuredCheckBox).click();
					test.log(Status.INFO, "Certificate of Deposit Secured Loan selected");
					CDsecuredLoanInfoValidation();
					verifyHereLink(15);
					getElement(ObjectRepository.productPageNext).click();
					test.log(Status.INFO, "Continue button clicked");
					//Personal Loan Info page
					verifyDropdownSelection(ObjectRepository.prodTypeDropdown,cdLoanTitle);
					verifyPlaceholder(ObjectRepository.prodLimitTextbox,min1000);
					//Back to Product Selection Page
					getElement(ObjectRepository.prodInfoBackButton).click();
					test.log(Status.INFO, "Back Button clicked");
					verifyElementPresent(ObjectRepository.cdSecuredCheckedBox);
					
					//Verify Share Secured Loan section
					scrollToElement(ObjectRepository.shareSecuredTitle);
					verifyText(ObjectRepository.shareSecuredTitle,ssLoanTitle);
					getElement(ObjectRepository.shareSecuredCheckBox).click();
					test.log(Status.INFO, "Share Secured Loan selected");
					verifyText(ObjectRepository.shareSecuredDesc1,ssLoanDesc1);
					verifyText(ObjectRepository.shareSecuredDesc2,ssLoanDesc2);
					verifyText(ObjectRepository.shareSecuredDesc3,ratesDesc);
					verifyHereLink(16);
					getElement(ObjectRepository.productPageNext).click();
					test.log(Status.INFO, "Continue button clicked");
					//Personal Loan Info page
					verifyDropdownSelection(ObjectRepository.prodTypeDropdown,ssLoanTitle);
					verifyPlaceholder(ObjectRepository.prodLimitTextbox,min500);
					//Back to Product Selection Page
					getElement(ObjectRepository.prodInfoBackButton).click();
					test.log(Status.INFO, "Back Button clicked");
					verifyElementPresent(ObjectRepository.shareSecuredCheckedBox);
					getElement(ObjectRepository.shareSecuredCheckedBox).click();
					//verifyElementPresent(ObjectRepository.shareSecuredCheckBox);
					test.log(Status.INFO, "Share Secured Loan deselected");
					getElement(ObjectRepository.myWay6000CheckBox).click();
					getElement(ObjectRepository.creditCardExpand).click();
					getElement(ObjectRepository.buceesCheckBox).click();
					getElement(ObjectRepository.productPageNext).click();
					test.log(Status.INFO, "Credit card and loan selected");
					//Prod Info
					getElement(ObjectRepository.prodLimitTextbox).sendKeys(ccAmount);
					getElement(ObjectRepository.prodInfoNextButton).click();
					test.log(Status.INFO, "Credit card amount entered");
					//Prod Info
					getElement(ObjectRepository.prodLimitTextbox).sendKeys(loanAmount);
					getElement(ObjectRepository.prodInfoNextButton).click();
					test.log(Status.INFO, "Loan amount entered");
					//Member Verification
					getElement(ObjectRepository.mmbrVerifyNum).sendKeys(mmbrNum);
					getElement(ObjectRepository.mmbrVerifySSN).sendKeys(SSN);
					getElement(ObjectRepository.mmbrVerifyDOB).sendKeys(DOB);
					getElement(ObjectRepository.mmbrVerifyNext).click();
					test.log(Status.INFO, "Member Verified");
					//Your Information
					selectDropdownOpt(ObjectRepository.idType,idTypeDD);
					getElement(ObjectRepository.idNum).sendKeys(idNumber);
					getElement(ObjectRepository.issueDate).sendKeys(issueDt);
					getElement(ObjectRepository.expDate).sendKeys(expireDt);
					getElement(ObjectRepository.housePymt).sendKeys(housePymt);
					getElement(ObjectRepository.addrYears).sendKeys(addrYears);
					getElement(ObjectRepository.addrMonths).sendKeys(addrMonths);
					getElement(ObjectRepository.currentEmp).sendKeys(currentEmp);
					getElement(ObjectRepository.monIncome).sendKeys(curIncome);
					getElement(ObjectRepository.empYears).sendKeys(empYears);
					getElement(ObjectRepository.empMonths).sendKeys(empMonths);
					test.log(Status.INFO, "Applicant information entered");
					getElement(ObjectRepository.productPageNext).click();
					test.log(Status.INFO, "Continue button clicked");
					//Confirm Accounts
					verifyText(ObjectRepository.prodOne,confirmProd);
					verifyText(ObjectRepository.prodTwo,my6000Title);
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
			test.log(Status.PASS, "Verify Personal Loan product section for existing member");
		}
	}

  @AfterTest
  public void tearDown() {
	 extent.flush();
	 driver.quit();
  }

}
