package VehicleLoans;

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

public class C23882_VerifyVehicleLoanLimit extends GenericKeywords{
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
  public void C23882_VerifyVehicleLoanLimit() throws InterruptedException, MessagingException, IOException {
	  if(continuetestcase==true)
	  {
			sheetName = "ProdData";
			int totalRowCount = excl.getRowCount(sheetName);
			for(startIter=1;startIter<=totalRowCount;startIter++) //It is mandatory to have this for loop in every test case
			{	
				if(this.getClass().getSimpleName().equals(excl.getCellData("ProdData", 0, startIter)))
				 {
					String jetski=excl.getCellData(sheetName, 1, startIter);
					String jetskiMin=excl.getCellData(sheetName, 11, startIter);
					String loanAmount=excl.getCellData(sheetName, 6, startIter);
					String amountFormat=excl.getCellData(sheetName, 7, startIter);					
					String jetskiPrice=excl.getCellData(sheetName, 8, startIter);
					String priceFormat=excl.getCellData(sheetName, 9, startIter);
					String oneNum=excl.getCellData(sheetName, 10, startIter);
					String popupMsg1=excl.getCellData(sheetName, 30, startIter);
					String popupMsg2=excl.getCellData(sheetName, 31, startIter);
					
					verifyElementPresent(ObjectRepository.app_ttl);
					test.log(Status.INFO, "Instant Open Title appearing");
					
					scrollToElement(ObjectRepository.nonmmbrstrt_btn);
					getElement(ObjectRepository.nonmmbrstrt_btn).click();
					test.log(Status.INFO, "Non Members Start Here button clicked");
					Thread.sleep(4000);
					
				//Dont want to open a checking account option selected	
					scrollToElement(ObjectRepository.dontWantCheckingOption);
					getElement(ObjectRepository.dontWantCheckingOption).click();
					test.log(Status.INFO, "Dont want to open a checking account option selected");
				
					Thread.sleep(4000);
					
					getElement(ObjectRepository.loancnfrm_yes).click();
					test.log(Status.INFO, "Yes option selected");
					
					Thread.sleep(2000);
				
					
					//select a vehicle loan
					getElement(ObjectRepository.carLoanExpand).click();
					getElement(ObjectRepository.boatLoanCheckBox).click();
					getElement(ObjectRepository.productPageNext).click();
					test.log(Status.INFO, "Boat loan selected");
					getElement(ObjectRepository.prodLimitTextbox).sendKeys(oneNum);
					verifyText(ObjectRepository.prodLimPopup,popupMsg1);
					getElement(ObjectRepository.prodLimitTextbox).clear();
					//select jetski
					selectDropdownOpt(ObjectRepository.prodTypeDropdown,jetski);
					verifyDropdownSelection(ObjectRepository.prodTypeDropdown,jetski);
					verifyPlaceholder(ObjectRepository.prodLimitTextbox,jetskiMin);
					test.log(Status.INFO, "Different loan selected");
					getElement(ObjectRepository.prodLimitTextbox).sendKeys(oneNum);
					verifyText(ObjectRepository.prodLimPopup,popupMsg2);
					getElement(ObjectRepository.prodLimitTextbox).clear();
					getElement(ObjectRepository.prodLimitTextbox).sendKeys(loanAmount);
					getElement(ObjectRepository.prodLimitTextbox).sendKeys(Keys.TAB);
					verifyTxtFieldValue(ObjectRepository.prodLimitTextbox,amountFormat);
					getElement(ObjectRepository.carPurchPrice).sendKeys(jetskiPrice);
					getElement(ObjectRepository.carPurchPrice).sendKeys(Keys.TAB);
					verifyTxtFieldValue(ObjectRepository.carPurchPrice,priceFormat);
					test.log(Status.INFO, "Loan info entered");
					getElement(ObjectRepository.prodInfoNextButton).click();
					test.log(Status.INFO, "Continue button clicked");
					verifyElementPresent(ObjectRepository.primaryApplicantInfoPageTitle);
					test.log(Status.INFO, "Primary Applicant Information page appeared");
					
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
			test.log(Status.PASS, "Verify select different vehicle loan for non member");
		}
	}

  @AfterTest
  public void tearDown() {
	 extent.flush();
	 driver.quit();
  }

}
