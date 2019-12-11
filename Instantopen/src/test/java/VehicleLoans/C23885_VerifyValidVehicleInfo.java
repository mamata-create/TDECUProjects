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

public class C23885_VerifyValidVehicleInfo extends GenericKeywords{
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
  public void C23885_VerifyValidVehicleInfo() throws InterruptedException, MessagingException, IOException {
	  if(continuetestcase==true)
	  {
			sheetName = "ProdData";
			int totalRowCount = excl.getRowCount(sheetName);
			for(startIter=1;startIter<=totalRowCount;startIter++) //It is mandatory to have this for loop in every test case
			{	
				if(this.getClass().getSimpleName().equals(excl.getCellData("ProdData", 0, startIter)))
				 {
					String selectRefAuto=excl.getCellData(sheetName, 1, startIter);
					String belowMinAmt=excl.getCellData(sheetName, 6, startIter);
					String popupMsg=excl.getCellData(sheetName, 23, startIter);
					String aboveMaxAmt=excl.getCellData(sheetName, 7, startIter);
					String popupMsg2=excl.getCellData(sheetName, 24, startIter);
					String minAmount=excl.getCellData(sheetName, 8, startIter);
					String minAmtFormat=excl.getCellData(sheetName, 9, startIter);
					String letters=excl.getCellData(sheetName, 10, startIter);
					String errorMsg1=excl.getCellData(sheetName, 25, startIter);
					String specialChar=excl.getCellData(sheetName, 11, startIter);
					String zeroPrice=excl.getCellData(sheetName, 12, startIter);
					String purchPrice=excl.getCellData(sheetName, 13, startIter);
					String priceFormat=excl.getCellData(sheetName, 14, startIter);
					String make=excl.getCellData(sheetName, 16, startIter);
					String model=excl.getCellData(sheetName, 17, startIter);
					String longYr=excl.getCellData(sheetName, 18, startIter);
					String trimYr=excl.getCellData(sheetName, 19, startIter);
					String shortYr=excl.getCellData(sheetName, 20, startIter);
					String vin=excl.getCellData(sheetName, 21, startIter);
					String errorMsg2=excl.getCellData(sheetName, 26, startIter);
					String year1=excl.getCellData(sheetName, 30, startIter);
					String year2=excl.getCellData(sheetName, 31, startIter);
					String year3=excl.getCellData(sheetName, 32, startIter);
					String errorMsg3=excl.getCellData(sheetName, 33, startIter);
					String decimal=excl.getCellData(sheetName, 34, startIter);
					String miles=excl.getCellData(sheetName, 35, startIter);
					
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
				
					
					//Select loan
					scrollToElement(ObjectRepository.carLoanExpand);
					getElement(ObjectRepository.carLoanExpand).click();
					getElement(ObjectRepository.atvLoanCheckBox).click();
					getElement(ObjectRepository.productPageNext).click();
					test.log(Status.INFO, "ATV Loan selected");
					//Enter below min
					getElement(ObjectRepository.prodLimitTextbox).sendKeys(belowMinAmt);
					verifyElementPresent(ObjectRepository.prodLimIncorrect);
					verifyText(ObjectRepository.prodLimPopup,popupMsg);
					test.log(Status.INFO, "Invalid amount not accepted");
					getElement(ObjectRepository.prodLimitTextbox).clear();					
					//Select different loan and enter above max
					selectDropdownOpt(ObjectRepository.prodTypeDropdown,selectRefAuto);
					getElement(ObjectRepository.prodLimitTextbox).sendKeys(aboveMaxAmt);
					verifyElementPresent(ObjectRepository.prodLimIncorrect);
					verifyText(ObjectRepository.prodLimPopup,popupMsg2);
					test.log(Status.INFO, "Invalid amount not accepted");
					getElement(ObjectRepository.prodLimitTextbox).clear();
					//Enter the min
					getElement(ObjectRepository.prodLimitTextbox).sendKeys(minAmount);
					getElement(ObjectRepository.prodLimitTextbox).sendKeys(Keys.TAB);
					verifyElementPresent(ObjectRepository.prodLimCorrect);
					verifyTxtFieldValue(ObjectRepository.prodLimitTextbox,minAmtFormat);
					test.log(Status.INFO, "Valid amount displayed in correct format");
					//Enter letters in the purchase price
					getElement(ObjectRepository.carPurchPrice).sendKeys(letters);
					getElement(ObjectRepository.prodInfoNextButton).click();
					verifyText(ObjectRepository.errorMsg1,errorMsg1);
					verifyElementPresent(ObjectRepository.errorPrice);
					verifyElementPresent(ObjectRepository.priceAsterisk);
					test.log(Status.INFO, "Letters not accepted in purchase price");
					getElement(ObjectRepository.carPurchPrice).clear();
					//Enter special characters in the purchase price
					getElement(ObjectRepository.carPurchPrice).sendKeys(specialChar);
					getElement(ObjectRepository.carPurchPrice).sendKeys(Keys.TAB);
					verifyTxtFieldValue(ObjectRepository.carPurchPrice,zeroPrice);
					test.log(Status.INFO, "Special characters not saved in purchase price");
					//Enter valid purchase price
					getElement(ObjectRepository.carPurchPrice).clear();
					getElement(ObjectRepository.carPurchPrice).sendKeys(purchPrice);
					getElement(ObjectRepository.carPurchPrice).sendKeys(Keys.TAB);
					verifyTxtFieldValue(ObjectRepository.carPurchPrice,priceFormat);
					test.log(Status.INFO, "Valid price displayed in correct format");
					//Enter vehicle info
					getElement(ObjectRepository.carMake).sendKeys(make);
					getElement(ObjectRepository.carModel).sendKeys(model);
					getElement(ObjectRepository.carVIN).sendKeys(vin);
					test.log(Status.INFO, "Vehicle make, model and vin entered");
					//Enter year
					getElement(ObjectRepository.carYear).sendKeys(letters);
					getElement(ObjectRepository.carYear).sendKeys(specialChar);
					getElement(ObjectRepository.carYear).sendKeys(Keys.TAB);
					verifyTxtFieldValue(ObjectRepository.carYear,"");
					getElement(ObjectRepository.carYear).sendKeys(longYr);
					verifyTxtFieldValue(ObjectRepository.carYear,trimYr);
					getElement(ObjectRepository.carYear).clear();
					getElement(ObjectRepository.carYear).sendKeys(shortYr);
					getElement(ObjectRepository.prodInfoNextButton).click();
					verifyText(ObjectRepository.errorMsg1,errorMsg2);
					getElement(ObjectRepository.carYear).clear();
					getElement(ObjectRepository.carYear).sendKeys(year1);
					getElement(ObjectRepository.prodInfoNextButton).click();
					verifyText(ObjectRepository.errorMsg1,errorMsg2);
					verifyElementPresent(ObjectRepository.errorYear);
					verifyElementPresent(ObjectRepository.yearAsterisk);
					getElement(ObjectRepository.carYear).clear();
					getElement(ObjectRepository.carYear).sendKeys(year2);
					getElement(ObjectRepository.prodInfoNextButton).click();
					verifyText(ObjectRepository.errorMsg1,errorMsg2);
					verifyElementPresent(ObjectRepository.errorYear);
					verifyElementPresent(ObjectRepository.yearAsterisk);
					getElement(ObjectRepository.carYear).clear();
					getElement(ObjectRepository.carYear).sendKeys(year3);
					test.log(Status.INFO, "Vehicle year field validated");
					//Enter Mileage
					getElement(ObjectRepository.carMiles).clear();
					getElement(ObjectRepository.carMiles).sendKeys(letters);
					getElement(ObjectRepository.prodInfoNextButton).click();
					verifyText(ObjectRepository.errorMsg1,errorMsg3);
					verifyElementPresent(ObjectRepository.errorMiles);
					verifyElementPresent(ObjectRepository.milesAsterisk);
					getElement(ObjectRepository.carMiles).clear();
					getElement(ObjectRepository.carMiles).sendKeys(specialChar);
					getElement(ObjectRepository.prodInfoNextButton).click();
					verifyText(ObjectRepository.errorMsg1,errorMsg3);
					getElement(ObjectRepository.carMiles).clear();
					getElement(ObjectRepository.carMiles).sendKeys(decimal);
					getElement(ObjectRepository.prodInfoNextButton).click();
					verifyText(ObjectRepository.errorMsg1,errorMsg3);
					getElement(ObjectRepository.carMiles).clear();
					getElement(ObjectRepository.carMiles).sendKeys(miles);
					test.log(Status.INFO, "Vehicle mileage field validated");
					getElement(ObjectRepository.prodInfoNextButton).click();
					test.log(Status.INFO, "continue button clicked");
					
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
			test.log(Status.PASS, "Verify vehicle loan field data for non member");
		}
	}

  @AfterTest
  public void tearDown() {
	 extent.flush();
	 driver.quit();
  }

}
