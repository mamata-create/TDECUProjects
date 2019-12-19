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

public class C24111_VerifyProdSelectButtons extends GenericKeywords{
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
	  public void C24111_VerifyProdSelectButtons() throws InterruptedException, MessagingException, IOException {
		  if(continuetestcase==true)
		  {
				sheetName = "ProdData";
				int totalRowCount = excl.getRowCount(sheetName);
				for(startIter=1;startIter<=totalRowCount;startIter++) //It is mandatory to have this for loop in every test case
				{	
					if(this.getClass().getSimpleName().equals(excl.getCellData("ProdData", 0, startIter)))
					{						
						scrollToElement(ObjectRepository.mmbrstrt_btn);
						getElement(ObjectRepository.mmbrstrt_btn).click();
						test.log(Status.INFO, "Members Start Here button clicked");
						
						scrollToElement(ObjectRepository.productPageBack);
						getElement(ObjectRepository.productPageBack).click();
						test.log(Status.INFO, "Back button clicked");
						getElement(ObjectRepository.mmbrstrt_btn).click();
						test.log(Status.INFO, "Members Start Here button clicked");
						getElement(ObjectRepository.creditCardExpand).click();
						getElement(ObjectRepository.buceesCheckBox).click();
						test.log(Status.INFO, "Credit Card selected");
						getElement(ObjectRepository.productPageBack).click();
						test.log(Status.INFO, "Back button clicked");
						getElement(ObjectRepository.mmbrstrt_btn).click();
						test.log(Status.INFO, "Members Start Here button clicked");
						getElement(ObjectRepository.creditCardExpand).click();
						verifyElementPresent(ObjectRepository.buceesCheckBox);
						getElement(ObjectRepository.personalLoanExpand).click();
						getElement(ObjectRepository.myWay7000CheckBox).click();
						test.log(Status.INFO, "Personal Loan selected");
						getElement(ObjectRepository.productPageNext).click();
						test.log(Status.INFO, "Continue button clicked");
						verifyElementPresent(ObjectRepository.psnlLoanInfTtl);
						getElement(ObjectRepository.prodInfoBackButton).click();
						test.log(Status.INFO, "Back button clicked");
						verifyElementPresent(ObjectRepository.myWay7000CheckedBox);
						getElement(ObjectRepository.checkingExpand).click();
						getElement(ObjectRepository.mnyMrktCheckBox).click();
						verifyElementPresent(ObjectRepository.mnyMrktChecked);
						test.log(Status.INFO, "Money Marked selected");
						getElement(ObjectRepository.productPageNext).click();
						test.log(Status.INFO, "Continue button clicked");
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
				test.log(Status.PASS, "Verify buttons on Product Selection page for existing member");
			}
		}

	  @AfterTest
	  public void tearDown() {
		 extent.flush();
		 driver.quit();
	  }
	  
}

