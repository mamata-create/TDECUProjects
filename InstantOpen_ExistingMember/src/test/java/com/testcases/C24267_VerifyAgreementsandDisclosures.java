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

public class C24267_VerifyAgreementsandDisclosures extends GenericKeywords{
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
  public void C24267_VerifyAgreementsandDisclosures() throws InterruptedException, MessagingException, IOException {
	  if(continuetestcase==true)
	  {
			sheetName = "ProdData";
			int totalRowCount = excl.getRowCount(sheetName);
			for(startIter=1;startIter<=totalRowCount;startIter++) //It is mandatory to have this for loop in every test case
			{	
				if(this.getClass().getSimpleName().equals(excl.getCellData("ProdData", 0, startIter)))
				{
					String loanAmt= excl.getCellData(sheetName, 6, startIter);
					String purchPrice= excl.getCellData(sheetName, 7, startIter);
					String VIN= excl.getCellData(sheetName, 8, startIter);
					String mmbrNum= excl.getCellData(sheetName, 27, startIter);
					String SSN= excl.getCellData(sheetName, 28, startIter);
					String DOB= excl.getCellData(sheetName, 29, startIter);
					String idType= excl.getCellData(sheetName, 16, startIter);
					String idNum= excl.getCellData(sheetName, 17, startIter);
					String issueDt= excl.getCellData(sheetName, 18, startIter);
					String expDt= excl.getCellData(sheetName, 19, startIter);
					String housePymt= excl.getCellData(sheetName, 20, startIter);
					String addrYears= excl.getCellData(sheetName, 21, startIter);
					String addrMonths= excl.getCellData(sheetName, 22, startIter);
					String currentEmp= excl.getCellData(sheetName, 23, startIter);
					String curIncome= excl.getCellData(sheetName, 24, startIter);
					String empYears= excl.getCellData(sheetName, 25, startIter);
					String empMonths= excl.getCellData(sheetName, 26, startIter);
					String confirmProd1= excl.getCellData(sheetName, 1, startIter);
					String confirmProd2= excl.getCellData(sheetName, 2, startIter);
					String errorMsg1= excl.getCellData(sheetName, 9, startIter);
					String errorMsg2= excl.getCellData(sheetName, 10, startIter);
					String discText= excl.getCellData(sheetName, 30, startIter);
					String cPayDes= excl.getCellData(sheetName, 11, startIter);
					String overdraft1= excl.getCellData(sheetName, 12, startIter);
					String overdraft2= excl.getCellData(sheetName, 13, startIter);
					String overdraft3= excl.getCellData(sheetName, 14, startIter);
					String cPayInfo= excl.getCellData(sheetName, 15, startIter);
					String FAQone= excl.getCellData(sheetName, 31, startIter);
					String FAQtwo= excl.getCellData(sheetName, 32, startIter);
					String FAQtwoInfo= excl.getCellData(sheetName, 33, startIter);
					String note= excl.getCellData(sheetName, 34, startIter);
					String agreementInfo= excl.getCellData(sheetName, 35, startIter);
					String agreeAndSignNote= excl.getCellData(sheetName, 36, startIter);

					scrollToElement(ObjectRepository.mmbrstrt_btn);
					getElement(ObjectRepository.mmbrstrt_btn).click();
					test.log(Status.INFO, "Members Start Here button clicked");
					//Select Products
					getElement(ObjectRepository.carLoanExpand).click();
					getElement(ObjectRepository.boatRefinCheckBox).click();
					getElement(ObjectRepository.checkingExpand).click();
					getElement(ObjectRepository.classicCheckCheckBox).click();
					getElement(ObjectRepository.ccCourtesyPayCheckBox).click();					
					getElement(ObjectRepository.productPageNext).click();
					test.log(Status.INFO, "Vehicle loan and checking account selected");
					//Loan info
					getElement(ObjectRepository.prodLimitTextbox).sendKeys(loanAmt);
					getElement(ObjectRepository.carPurchPrice).sendKeys(purchPrice);
					getElement(ObjectRepository.carVIN).sendKeys(VIN);
					getElement(ObjectRepository.prodInfoNextButton).click();
					test.log(Status.INFO, "Loan data entered");					
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
					getElement(ObjectRepository.productPageNext).click();
					test.log(Status.INFO, "Applicant Information entered");
					//Confirm Accounts
					verifyText(ObjectRepository.prodOne,confirmProd1);
					verifyText(ObjectRepository.prodTwo,confirmProd2);
					getElement(ObjectRepository.confirmBtn).click();
					test.log(Status.INFO, "Account selections confirmed");
					//Agreements and disclosures
					verifyElementPresent(ObjectRepository.agreementTtl);
					getElement(ObjectRepository.confirmBtn).click();
					verifyText(ObjectRepository.errorMsg1,errorMsg1);
					verifyText(ObjectRepository.disclosuresText,discText);
					getElement(ObjectRepository.discCheckBox).click();
					verifyElementPresent(ObjectRepository.discChecked);
					getElement(ObjectRepository.confirmBtn).click();
					verifyText(ObjectRepository.errorMsg1,errorMsg2);
					test.log(Status.INFO, "Disclosures accepted");
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
					//Agreement and Signatures
					verifyElementPresent(ObjectRepository.agreeAndSignTtl);
					verifyText(ObjectRepository.agreeandSignInfo,agreementInfo);
					getElement(ObjectRepository.agreeCheckBox).click();
					verifyElementPresent(ObjectRepository.agreeChecked);
					verifyText(ObjectRepository.agreementNote,agreeAndSignNote);
					test.log(Status.INFO, "Agreement and Signature info displayed");
					getElement(ObjectRepository.confirmBtn).click();
					test.log(Status.INFO, "Continue button clicked");
					verifyElementPresent(ObjectRepository.IdentityTtl);
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
			test.log(Status.PASS, "Verify agreement and disclosures for existing member");
		}
	}

  @AfterTest
  public void tearDown() {
	 extent.flush();
	 driver.quit();
  }

}
