package VehicleLoans;

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

public class C23884_VerifyVehicleLoanReqFields  extends GenericKeywords{
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
  public void C23884_VerifyVehicleLoanReqFields() throws InterruptedException, MessagingException, IOException {
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
					
					verifyElementPresent(ObjectRepository.app_ttl);
					test.log(Status.INFO, "Instant Open Title appearing");
					
					scrollToElement(ObjectRepository.nonmmbrstrt_btn);
					getElement(ObjectRepository.nonmmbrstrt_btn).click();
					test.log(Status.INFO, "Non Members Start Here button clicked");
				
				//Dont want to open a checking account option selected	
					scrollToElement(ObjectRepository.dontWantCheckingOption);
					getElement(ObjectRepository.dontWantCheckingOption).click();
					test.log(Status.INFO, "Dont want to open a checking account option selected");
				
					getElement(ObjectRepository.loancnfrm_yes).click();
					test.log(Status.INFO, "Yes option selected");
					
					
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
					//verifyElementPresent(ObjectRepository.mmbrVerifyTile);
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
			test.log(Status.PASS, "Verify refinance vehicle loan required fields for non member");
		}
	}

  @AfterTest
  public void tearDown() {
	 extent.flush();
	 driver.quit();
  }

}
