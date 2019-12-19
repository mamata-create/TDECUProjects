package SelectAccounts;

import java.io.IOException;

import javax.mail.MessagingException;

import org.openqa.selenium.Keys;
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

public class C24108_VerifyCDSelection extends GenericKeywords{
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
	  public void C24108_VerifyCDSelection() throws InterruptedException, MessagingException, IOException {
		  if(continuetestcase==true)
		  {
				sheetName = "ProdData";
				int totalRowCount = excl.getRowCount(sheetName);
				for(startIter=1;startIter<=totalRowCount;startIter++) //It is mandatory to have this for loop in every test case
				{	
					if(this.getClass().getSimpleName().equals(excl.getCellData("ProdData", 0, startIter)))
					{
						String cdDesc1= excl.getCellData(sheetName, 16, startIter);
						String cdDesc2= excl.getCellData(sheetName, 17, startIter);
						String cdSearchForTitle= excl.getCellData(sheetName, 23, startIter);
						String cdSearchForInfo= excl.getCellData(sheetName, 24, startIter);
						String cdEnterAmount1= excl.getCellData(sheetName, 11, startIter);
						String cdEnterAmount2= excl.getCellData(sheetName, 12, startIter);
						String cdAmountValue= excl.getCellData(sheetName, 13, startIter);
						String cdDropdown1= excl.getCellData(sheetName, 1, startIter);
						String cdDropdown2= excl.getCellData(sheetName, 2, startIter);
						String cdDropdown3= excl.getCellData(sheetName, 3, startIter);
						String cdDropdown4= excl.getCellData(sheetName, 4, startIter);
						String cdDropdown5= excl.getCellData(sheetName, 5, startIter);
						String cdDropdown6= excl.getCellData(sheetName, 6, startIter);
						String cdDropdown7= excl.getCellData(sheetName, 7, startIter);
						String cdDropdown8= excl.getCellData(sheetName, 8, startIter);
						String loanAmount= excl.getCellData(sheetName, 14, startIter);
						String prodAmount= excl.getCellData(sheetName, 15, startIter);
						String mmbrNum= excl.getCellData(sheetName, 27, startIter);
						String SSN= excl.getCellData(sheetName, 28, startIter);
						String DOB= excl.getCellData(sheetName, 29, startIter);
						String idTypeDD= excl.getCellData(sheetName, 18, startIter);
						String idNumber= excl.getCellData(sheetName, 19, startIter);
						String issueDt= excl.getCellData(sheetName, 20, startIter);
						String expireDt= excl.getCellData(sheetName, 21, startIter);
						String housePymt= excl.getCellData(sheetName, 22, startIter);
						String addrYears= excl.getCellData(sheetName, 30, startIter);
						String addrMonths= excl.getCellData(sheetName, 31, startIter);
						String currentEmp= excl.getCellData(sheetName, 32, startIter);
						String curIncome= excl.getCellData(sheetName, 33, startIter);
						String empYears= excl.getCellData(sheetName, 34, startIter);
						String empMonths= excl.getCellData(sheetName, 35, startIter);
						String confirmProd= excl.getCellData(sheetName, 9, startIter);
						String confirmProd2= excl.getCellData(sheetName, 10, startIter);
						String errorMsg= excl.getCellData(sheetName, 36, startIter);
						
						scrollToElement(ObjectRepository.mmbrstrt_btn);
						getElement(ObjectRepository.mmbrstrt_btn).click();
						test.log(Status.INFO, "Members Start Here button clicked");
						
						getElement(ObjectRepository.cdExpand).click();
						test.log(Status.INFO, "Certificate of Deposit section expanded");						
						verifyText(ObjectRepository.cdDescOne,cdDesc1);
						verifyRatesLink(1);
						verifyText(ObjectRepository.cdDescTwo,cdDesc2);
						verifyText(ObjectRepository.cdSearchTitle,cdSearchForTitle);
						verifyText(ObjectRepository.cdSearchInfo,cdSearchForInfo);
						verifyElementPresent(ObjectRepository.showAllLabel);
						verifyFeeScheduleLink();
						
						//Enter 1000
						getElement(ObjectRepository.enterAmountTxtField).sendKeys(cdEnterAmount2);
						verifyAllCdsDisplayed();
						test.log(Status.INFO, "All CDs displayed");
						//Enter 500
						getElement(ObjectRepository.enterAmountTxtField).clear();
						getElement(ObjectRepository.enterAmountTxtField).sendKeys(cdEnterAmount1);
						getElement(ObjectRepository.enterAmountTxtField).sendKeys(Keys.TAB);
						verifyTxtFieldValue(ObjectRepository.enterAmountTxtField,cdAmountValue);
						test.log(Status.INFO, "Amount in correct format");
						verifyAllCdsNotDisplayed();
						getElement(ObjectRepository.enterAmountTxtField).clear();

						//Verify Dropdown						
						selectDropdownOpt(ObjectRepository.selectTermDropdown,cdDropdown1);
						verifyElementPresent(ObjectRepository.visibleCD3);
						selectDropdownOpt(ObjectRepository.selectTermDropdown,cdDropdown2);
						verifyElementPresent(ObjectRepository.visibleCD6);
						selectDropdownOpt(ObjectRepository.selectTermDropdown,cdDropdown3);
						verifyElementPresent(ObjectRepository.visibleCD12);
						selectDropdownOpt(ObjectRepository.selectTermDropdown,cdDropdown4);
						verifyElementPresent(ObjectRepository.visibleCD24);
						selectDropdownOpt(ObjectRepository.selectTermDropdown,cdDropdown5);
						verifyElementPresent(ObjectRepository.visibleCD36);
						selectDropdownOpt(ObjectRepository.selectTermDropdown,cdDropdown6);
						verifyElementPresent(ObjectRepository.visibleCD48);
						selectDropdownOpt(ObjectRepository.selectTermDropdown,cdDropdown7);
						verifyElementPresent(ObjectRepository.visibleCD60);
						selectDropdownOpt(ObjectRepository.selectTermDropdown,cdDropdown8);
						verifyElementPresent(ObjectRepository.visibleCD18);
						test.log(Status.INFO, "Dropdown values correct");
						//Show All
						getElement(ObjectRepository.showAllCheckBox).click();
						verifyAllCdsDisplayed();
						verifyTxtFieldValue(ObjectRepository.enterAmountTxtField,"");
						verifyTxtFieldValue(ObjectRepository.selectTermDropdown,"");
						getElement(ObjectRepository.showAllCheckBox).click();
						verifyAllCdsNotDisplayed();
						test.log(Status.INFO, "Show All functionality working");
						//Select a CD
						selectDropdownOpt(ObjectRepository.selectTermDropdown,cdDropdown3);
						getElement(ObjectRepository.visibleCD12).click();
						test.log(Status.INFO, "12 Month CD selected");
						
						getElement(ObjectRepository.productPageNext).click();
						test.log(Status.INFO, "Continue button clicked");
						verifyElementPresent(ObjectRepository.mmbrVerifyTile);
						getElement(ObjectRepository.productPageBack).click();
						test.log(Status.INFO, "Back button clicked");
						//verify CD is still selected, currently back button goes to wrong page
						verifyElementPresent(ObjectRepository.visibleCD12);
						getElement(ObjectRepository.carLoanExpand).click();
						getElement(ObjectRepository.autoLoanCheckBox).click();
						getElement(ObjectRepository.productPageNext).click();
						test.log(Status.INFO, "Loan and CD account selected");
						//Prod Info
						getElement(ObjectRepository.prodLimitTextbox).sendKeys(loanAmount);
						getElement(ObjectRepository.carPurchPrice).sendKeys(prodAmount);
						getElement(ObjectRepository.prodInfoNextButton).click();
						test.log(Status.INFO, "Loan info entered");
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
						String maturity = cdMaturityDate(12);					
						String concatProd = confirmProd2+" "+maturity+")";
						verifyText(ObjectRepository.prodTwo,concatProd);
						getElement(ObjectRepository.confirmBtn).click();
						test.log(Status.INFO, "Account selections confirmed");
						//Agreements and Disclosures
						getElement(ObjectRepository.termsAndCondCheckBox).click();
						getElement(ObjectRepository.agreeAndSignCheckBox).click();
						getElement(ObjectRepository.confirmBtn).click();
						test.log(Status.INFO, "Terms and conditions accepted");
						//Identity Verification
						getElement(ObjectRepository.questionOne).click();
						getElement(ObjectRepository.questionTwo).click();
						getElement(ObjectRepository.questionThree).click();
						getElement(ObjectRepository.questionFour).click();
						getElement(ObjectRepository.confirmBtn).click();
						test.log(Status.INFO, "Identity Verification questions answered");
						//Account Funding
						verifyElementPresent(ObjectRepository.acctFundTitle);
						getElement(ObjectRepository.submitBtn).click();
						verifyText(ObjectRepository.errorMsg1,errorMsg);
						test.log(Status.INFO, "Enter amount message displayed");
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
				test.log(Status.PASS, "Verify CD product section for existing member");
			}
		}

	  @AfterTest
	  public void tearDown() {
		 extent.flush();
		 driver.quit();
	  }

}
	
