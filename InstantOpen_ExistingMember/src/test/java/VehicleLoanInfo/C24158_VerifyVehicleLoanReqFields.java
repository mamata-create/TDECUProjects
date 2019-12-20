package VehicleLoanInfo;

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

public class C24158_VerifyVehicleLoanReqFields extends GenericKeywords{
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
  public void C24158_VerifyVehicleLoanReqFields() throws InterruptedException, MessagingException, IOException {
	  if(continuetestcase==true)
	  {
			sheetName = "ProdData";
			int totalRowCount = excl.getRowCount(sheetName);
			for(startIter=1;startIter<=totalRowCount;startIter++) //It is mandatory to have this for loop in every test case
			{	
				if(this.getClass().getSimpleName().equals(excl.getCellData("ProdData", 0, startIter)))
				 {
					String nullDropdown=excl.getCellData(sheetName, 1, startIter);
					String errorMsg1=excl.getCellData(sheetName, 23, startIter);
					String errorMsg2=excl.getCellData(sheetName, 24, startIter);
					String selectRefRV=excl.getCellData(sheetName, 2, startIter);
					String loanAmount=excl.getCellData(sheetName, 6, startIter);
					String purchPrice=excl.getCellData(sheetName, 7, startIter);
					String errorMsg3=excl.getCellData(sheetName, 25, startIter);
					String vinNum=excl.getCellData(sheetName, 8, startIter);
					
					scrollToElement(ObjectRepository.mmbrstrt_btn);
					getElement(ObjectRepository.mmbrstrt_btn).click();
					test.log(Status.INFO, "Members Start Here button clicked");
					
					//Select loan
					scrollToElement(ObjectRepository.carLoanExpand);
					getElement(ObjectRepository.carLoanExpand).click();
					getElement(ObjectRepository.autoLoanCheckBox).click();
					getElement(ObjectRepository.productPageNext).click();
					test.log(Status.INFO, "Loan selected");
					//Select loan error message
					selectDropdownOpt(ObjectRepository.prodTypeDropdown,nullDropdown);
					getElement(ObjectRepository.prodInfoNextButton).click();
					verifyText(ObjectRepository.errorMsg1,errorMsg1);
					verifyElementPresent(ObjectRepository.errorType);
					verifyElementPresent(ObjectRepository.typeAsterisk);
					test.log(Status.INFO, "Select an item message displayed");
					//Enter loan amount error message
					selectDropdownOpt(ObjectRepository.prodTypeDropdown,selectRefRV);
					getElement(ObjectRepository.prodInfoNextButton).click();
					verifyText(ObjectRepository.errorMsg1,errorMsg2);
					verifyElementPresent(ObjectRepository.errorAmount);
					verifyElementPresent(ObjectRepository.amountAsterisk);
					test.log(Status.INFO, "Enter loan amount message displayed");
					//Enter purchase price error message
					getElement(ObjectRepository.prodLimitTextbox).sendKeys(loanAmount);
					getElement(ObjectRepository.prodInfoNextButton).click();
					verifyText(ObjectRepository.errorMsg1,errorMsg2);
					verifyElementPresent(ObjectRepository.errorPrice);
					verifyElementPresent(ObjectRepository.priceAsterisk);
					test.log(Status.INFO, "Enter purchase price message displayed");
					//Enter VIN error message
					getElement(ObjectRepository.carPurchPrice).sendKeys(purchPrice);
					getElement(ObjectRepository.prodInfoNextButton).click();
					verifyText(ObjectRepository.errorMsg1,errorMsg3);
					verifyElementPresent(ObjectRepository.errorVIN);
					verifyElementPresent(ObjectRepository.VINasterisk);
					test.log(Status.INFO, "Enter VIN message displayed");
					//Click Continue
					getElement(ObjectRepository.carVIN).sendKeys(vinNum);
					getElement(ObjectRepository.prodInfoNextButton).click();
					verifyElementPresent(ObjectRepository.mmbrVerifyTile);
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
			test.log(Status.PASS, "Verify refinance vehicle loan required fields for existing member");
		}
	}

  @AfterTest
  public void tearDown() {
	 extent.flush();
	 driver.quit();
  }

}
