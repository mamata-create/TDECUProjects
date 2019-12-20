package CreditCardInfo;

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

public class C24154_VerifyCCMinMax extends GenericKeywords{
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
  public void C24154_VerifyCCMinMax() throws InterruptedException, MessagingException, IOException {
	  if(continuetestcase==true)
	  {
			sheetName = "ProdData";
			int totalRowCount = excl.getRowCount(sheetName);
			for(startIter=1;startIter<=totalRowCount;startIter++) //It is mandatory to have this for loop in every test case
			{	
				if(this.getClass().getSimpleName().equals(excl.getCellData("ProdData", 0, startIter)))
				 {
					String errorMsg=excl.getCellData(sheetName, 23, startIter);
					String amount1=excl.getCellData(sheetName, 6, startIter);
					String amt1Format=excl.getCellData(sheetName, 7, startIter);
					String amount2=excl.getCellData(sheetName, 8, startIter);
					String popupMsg=excl.getCellData(sheetName, 24, startIter);
					String selectBucees=excl.getCellData(sheetName, 1, startIter);
					String amount3=excl.getCellData(sheetName, 9, startIter);
					
					scrollToElement(ObjectRepository.mmbrstrt_btn);
					getElement(ObjectRepository.mmbrstrt_btn).click();
					test.log(Status.INFO, "Members Start Here button clicked");
					
					//Select Credit Card
					getElement(ObjectRepository.creditCardExpand).click();
					getElement(ObjectRepository.platinumCheckBox).click();
					getElement(ObjectRepository.productPageNext).click();
					test.log(Status.INFO, "Platinum MasterCard selected");
					getElement(ObjectRepository.prodInfoNextButton).click();
					verifyText(ObjectRepository.errorMsg1,errorMsg);
					test.log(Status.INFO, "Enter an amount message displayed");
					
					//enter below min amount
					getElement(ObjectRepository.prodLimitTextbox).sendKeys(amount2);
					verifyElementPresent(ObjectRepository.prodLimIncorrect);
					verifyText(ObjectRepository.prodLimPopup,popupMsg);
					test.log(Status.INFO, "Amount popup message displayed");					
					//enter valid amount
					getElement(ObjectRepository.prodLimitTextbox).clear();
					getElement(ObjectRepository.prodLimitTextbox).sendKeys(amount1);
					getElement(ObjectRepository.prodLimitTextbox).sendKeys(Keys.TAB);
					verifyTxtFieldValue(ObjectRepository.prodLimitTextbox,amt1Format);
					test.log(Status.INFO, "Amount in correct format");
					getElement(ObjectRepository.prodLimitTextbox).clear();
					//enter above max amount
					selectDropdownOpt(ObjectRepository.prodTypeDropdown,selectBucees);					
					getElement(ObjectRepository.prodLimitTextbox).sendKeys(amount3);					
					verifyElementPresent(ObjectRepository.prodLimIncorrect);
					test.log(Status.INFO, "Amount text box highlighted and outlined");
					getElement(ObjectRepository.prodLimitTextbox).sendKeys(Keys.BACK_SPACE);
					verifyText(ObjectRepository.prodLimPopup,popupMsg);
					test.log(Status.INFO, "Amount popup message displayed");
					
					getElement(ObjectRepository.prodLimitTextbox).sendKeys(Keys.BACK_SPACE);
					getElement(ObjectRepository.prodLimitTextbox).sendKeys(Keys.BACK_SPACE);
					getElement(ObjectRepository.prodLimitTextbox).sendKeys(Keys.BACK_SPACE);
					verifyElementPresent(ObjectRepository.prodLimCorrect);				
					test.log(Status.INFO, "Valid amount entered");
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
			test.log(Status.PASS, "Verify Credit Card maximum and minimum for existing member");
		}
	}

  @AfterTest
  public void tearDown() {
	 extent.flush();
	 driver.quit();
  }

}
