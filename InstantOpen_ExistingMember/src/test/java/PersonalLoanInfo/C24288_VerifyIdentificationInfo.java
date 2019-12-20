package PersonalLoanInfo;

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

public class C24288_VerifyIdentificationInfo extends GenericKeywords{
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
  public void C24288_VerifyIdentificationInfo() throws InterruptedException, MessagingException, IOException {
	  if(continuetestcase==true)
	  {
			sheetName = "ProdData";
			int totalRowCount = excl.getRowCount(sheetName);
			for(startIter=1;startIter<=totalRowCount;startIter++) //It is mandatory to have this for loop in every test case
			{	
				if(this.getClass().getSimpleName().equals(excl.getCellData("ProdData", 0, startIter)))
				 {
					String loanAmt=excl.getCellData(sheetName, 6, startIter);
					String mmbrNum=excl.getCellData(sheetName, 27, startIter);
					String SSN=excl.getCellData(sheetName, 28, startIter);
					String DOB=excl.getCellData(sheetName, 29, startIter);
					String errorMsg1=excl.getCellData(sheetName, 23, startIter);
					String selectLicense=excl.getCellData(sheetName, 7, startIter);
					String stateLabel=excl.getCellData(sheetName, 8, startIter);
					String errorMsg2=excl.getCellData(sheetName, 24, startIter);
					String state=excl.getCellData(sheetName, 9, startIter);
					String errorMsg3=excl.getCellData(sheetName, 25, startIter);
					String selectPassport=excl.getCellData(sheetName, 10, startIter);
					String countryLbl=excl.getCellData(sheetName, 16, startIter);
					String errorMsg4=excl.getCellData(sheetName, 26, startIter);
					String country=excl.getCellData(sheetName, 17, startIter);
					String idNum=excl.getCellData(sheetName, 18, startIter);
					String errorMsg5=excl.getCellData(sheetName, 30, startIter);
					String issueDt=excl.getCellData(sheetName, 19, startIter);
					String errorMsg6=excl.getCellData(sheetName, 31, startIter);
					String expDate=excl.getCellData(sheetName, 20, startIter);
					String errorMsg7=excl.getCellData(sheetName, 32, startIter);
					
					scrollToElement(ObjectRepository.mmbrstrt_btn);
					getElement(ObjectRepository.mmbrstrt_btn).click();
					test.log(Status.INFO, "Members Start Here button clicked");

					//Select loan
					getElement(ObjectRepository.personalLoanExpand).click();
					getElement(ObjectRepository.homeAdvCheckBox).click();
					test.log(Status.INFO, "Personal loan selected");
					getElement(ObjectRepository.productPageNext).click();
					getElement(ObjectRepository.prodLimitTextbox).sendKeys(loanAmt);
					test.log(Status.INFO, "Loan amount entered");
					getElement(ObjectRepository.prodInfoNextButton).click();
					getElement(ObjectRepository.mmbrVerifyNum).sendKeys(mmbrNum);
					getElement(ObjectRepository.mmbrVerifySSN).sendKeys(SSN);
					getElement(ObjectRepository.mmbrVerifyDOB).sendKeys(DOB);
					getElement(ObjectRepository.mmbrVerifyNext).click();
					test.log(Status.INFO, "Member verified");
					//Verify Identification Information fields
					getElement(ObjectRepository.productPageNext).click();
					verifyText(ObjectRepository.errorMsg1,errorMsg1);
					scrollToElement(ObjectRepository.identityHdr);
					verifyElementPresent(ObjectRepository.errorIdType);
					verifyElementPresent(ObjectRepository.IdTypeAsterisk);
					test.log(Status.INFO, "Correct error message displayed");
					//Verify license option
					selectDropdownOpt(ObjectRepository.idType,selectLicense);
					verifyDropdownSelection(ObjectRepository.idType,selectLicense);
					verifyText(ObjectRepository.stateLabel,stateLabel);
					verifyElementPresent(ObjectRepository.stateDropdown);
					getElement(ObjectRepository.productPageNext).click();
					verifyText(ObjectRepository.errorMsg1,errorMsg2);
					scrollToElement(ObjectRepository.identityHdr);
					verifyElementPresent(ObjectRepository.errorState);
					verifyElementPresent(ObjectRepository.stateAsterisk);
					selectDropdownOpt(ObjectRepository.stateDropdown,state);
					getElement(ObjectRepository.productPageNext).click();
					verifyText(ObjectRepository.errorMsg1,errorMsg3);
					test.log(Status.INFO, "Driver's License and state selected");
					scrollToElement(ObjectRepository.identityHdr);
					//Verify passport option
					selectDropdownOpt(ObjectRepository.idType,selectPassport);
					verifyDropdownSelection(ObjectRepository.idType,selectPassport);
					verifyText(ObjectRepository.countryLbl,countryLbl);
					verifyElementPresent(ObjectRepository.countryDdown);
					selectDropdownOpt(ObjectRepository.countryDdown,"");
					getElement(ObjectRepository.productPageNext).click();
					verifyText(ObjectRepository.errorMsg1,errorMsg4);
					scrollToElement(ObjectRepository.identityHdr);
					verifyElementPresent(ObjectRepository.errorCountry);
					verifyElementPresent(ObjectRepository.countryAsterisk);
					selectDropdownOpt(ObjectRepository.countryDdown,country);
					getElement(ObjectRepository.productPageNext).click();
					verifyText(ObjectRepository.errorMsg1,errorMsg3);
					test.log(Status.INFO, "Passport and country selected");
					//Verify ID Number field
					scrollToElement(ObjectRepository.identityHdr);
					verifyElementPresent(ObjectRepository.errorIdNum);
					verifyElementPresent(ObjectRepository.idNumAsterisk);
					getElement(ObjectRepository.idNum).sendKeys(idNum);
					getElement(ObjectRepository.productPageNext).click();
					verifyText(ObjectRepository.errorMsg1,errorMsg5);
					test.log(Status.INFO, "ID Number entered");
					//Verify Issue Date field
					scrollToElement(ObjectRepository.identityHdr);
					verifyElementPresent(ObjectRepository.errorIssDt);
					verifyElementPresent(ObjectRepository.issDtAsterisk);
					getElement(ObjectRepository.issueDate).sendKeys(issueDt);
					getElement(ObjectRepository.productPageNext).click();
					verifyText(ObjectRepository.errorMsg1,errorMsg6);
					test.log(Status.INFO, "Issue Date entered");
					//Verify Expiration Date field
					scrollToElement(ObjectRepository.identityHdr);
					verifyElementPresent(ObjectRepository.errorExpDt);
					verifyElementPresent(ObjectRepository.expDtAsterisk);
					getElement(ObjectRepository.expDate).sendKeys(expDate);
					getElement(ObjectRepository.productPageNext).click();
					verifyText(ObjectRepository.errorMsg1,errorMsg7);
					test.log(Status.INFO, "Expiration Date entered");
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
			test.log(Status.PASS, "Verify identification information fields for existing member");
		}
	}

  @AfterTest
  public void tearDown() {
	 extent.flush();
	 driver.quit();
  }

}
