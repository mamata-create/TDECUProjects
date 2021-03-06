package SelectAccounts;

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

public class C24309_VerifyMoneyMarketSelection extends GenericKeywords{
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
  public void C24309_VerifyMoneyMarketSelection() throws InterruptedException, MessagingException, IOException {
	  if(continuetestcase==true)
	  {
			sheetName = "ProdData";
			int totalRowCount = excl.getRowCount(sheetName);
			for(startIter=1;startIter<=totalRowCount;startIter++) //It is mandatory to have this for loop in every test case
			{	
				if(this.getClass().getSimpleName().equals(excl.getCellData("ProdData", 0, startIter)))
				{
					String loanAmount= excl.getCellData(sheetName, 11, startIter);
					String mmbrNum= excl.getCellData(sheetName, 27, startIter);
					String SSN= excl.getCellData(sheetName, 28, startIter);
					String DOB= excl.getCellData(sheetName, 29, startIter);
					String idTypeDD= excl.getCellData(sheetName, 16, startIter);
					String idNumber= excl.getCellData(sheetName, 17, startIter);
					String issueDt= excl.getCellData(sheetName, 18, startIter);
					String expireDt= excl.getCellData(sheetName, 19, startIter);
					String housePymt= excl.getCellData(sheetName, 20, startIter);
					String addrYears= excl.getCellData(sheetName, 21, startIter);
					String addrMonths= excl.getCellData(sheetName, 22, startIter);
					String currentEmp= excl.getCellData(sheetName, 23, startIter);
					String curIncome= excl.getCellData(sheetName, 24, startIter);
					String empYears= excl.getCellData(sheetName, 25, startIter);
					String empMonths= excl.getCellData(sheetName, 26, startIter);
					String confirmProd1= excl.getCellData(sheetName, 1, startIter);
					String confirmProd2= excl.getCellData(sheetName, 2, startIter);
					String errorMsg1= excl.getCellData(sheetName, 30, startIter);
					String promocode = excl.getCellData(sheetName, 44, startIter);
					scrollToElement(ObjectRepository.mmbrstrt_btn);
					getElement(ObjectRepository.mmbrstrt_btn).click();
					test.log(Status.INFO, "Members Start Here button clicked");
					//Select Products
					getElement(ObjectRepository.checkingExpand).click();
					getElement(ObjectRepository.mnyMrktCheckBox).click();
					test.log(Status.INFO, "Money Market account selected");
					//Back button navigation
					getElement(ObjectRepository.productPageNext).click();
					test.log(Status.INFO, "Continue button clicked");
					getElement(ObjectRepository.mmbrVerifyBack).click();
					test.log(Status.INFO, "Back button clicked");
					verifyElementPresent(ObjectRepository.mnyMrktChecked);
					getElement(ObjectRepository.personalLoanExpand).click();
					getElement(ObjectRepository.cash$tashCheckBox).click();
					test.log(Status.INFO, "Personal Loan selected");
					getElement(ObjectRepository.productPageNext).click();
					test.log(Status.INFO, "Continue button clicked");
					getElement(ObjectRepository.prodLimitTextbox).sendKeys(loanAmount);
					getElement(ObjectRepository.prodInfoNextButton).click();
					test.log(Status.INFO, "Loan amount entered");
					//Member Verification
					
					getElement(ObjectRepository.mmbrVerifySSN).sendKeys(SSN);
					getElement(ObjectRepository.mmbrVerifyDOB).sendKeys(DOB);
					getElement(ObjectRepository.mmbrVerifyNext).click();
					test.log(Status.INFO, "Member Verified");
					
					verifyText(ObjectRepository.delivery_method_page_header,"Select a Delivery Method");
					enter_otp_to_the_field_and_procced();
					test.log(Status.PASS, "OTP Verified Successfully");
					
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
					
					verifyElementPresent(ObjectRepository.cnfrmacnt_ttl);
					test.log(Status.INFO, "User into Promo Code page");
					enterPromocode(promocode);
					//Confirm Accounts
					verifyText(ObjectRepository.prodOne,confirmProd1);
					verifyText(ObjectRepository.prodTwo,confirmProd2);
					getElement(ObjectRepository.confirmBtn).click();
					test.log(Status.INFO, "Account selections confirmed");
					//Agreements and Disclosures
					getElement(ObjectRepository.termsAndCondCheckBox).click();
					getElement(ObjectRepository.agreeAndSignCheckBox).click();
					getElement(ObjectRepository.confirmBtn).click();
					test.log(Status.INFO, "Terms and conditions accepted");
					//Identity Verification
					String arrayOfOptions[] = new String[]{"Fairfax, VA","None of the above","None of the above","None of the above"};
					idenficationOptions(arrayOfOptions);
					
					getElement(ObjectRepository.confirmBtn).click();
					
					idenficationOptions(arrayOfOptions);
					
					getElement(ObjectRepository.confirmBtn).click();
					test.log(Status.PASS, "Identity questions answered for primary applicant");
					//Account Funding
					verifyElementPresent(ObjectRepository.acctFundTitle);
					getElement(ObjectRepository.submitBtn).click();
					verifyText(ObjectRepository.errorMsg1,errorMsg1);
					test.log(Status.INFO, "Select funding method message displayed");
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
			test.log(Status.PASS, "Verify money market selection for existing member");
		}
	}

  @AfterTest
  public void tearDown() {
	 extent.flush();
	 driver.quit();
  }

}
