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

public class C24251_VerifyAddServiceSelection extends GenericKeywords{
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
  public void C24251_VerifyAddServiceSelection() throws InterruptedException, MessagingException, IOException {
	  if(continuetestcase==true)
	  {
			sheetName = "ProdData";
			int totalRowCount = excl.getRowCount(sheetName);
			for(startIter=1;startIter<=totalRowCount;startIter++) //It is mandatory to have this for loop in every test case
			{	
				if(this.getClass().getSimpleName().equals(excl.getCellData("ProdData", 0, startIter)))
				{
					String eDocsTitle= excl.getCellData(sheetName, 1, startIter);
					String eDocsDesc= excl.getCellData(sheetName, 16, startIter);
					
					scrollToElement(ObjectRepository.mmbrstrt_btn);
					getElement(ObjectRepository.mmbrstrt_btn).click();
					test.log(Status.INFO, "Members Start Here button clicked");
					
					scrollToElement(ObjectRepository.addtionalExpand);
					getElement(ObjectRepository.addtionalExpand).click();
					test.log(Status.INFO, "Additional Services section expanded");
					
					verifyElementPresent(ObjectRepository.eDocsChecked);
					verifyText(ObjectRepository.eDocsTitle, eDocsTitle);
					//Question Mark Popup
					getElement(ObjectRepository.eDocsQstion).click();
					verifyText(ObjectRepository.eDocsInfoTtl, eDocsTitle);
					verifyText(ObjectRepository.eDocsInfo, eDocsDesc);					
					getElement(ObjectRepository.eDocsClose).click();
					Thread.sleep(1000);
					//Deselect eDocs
					getElement(ObjectRepository.eDocsChecked).click();
					//verifyElementPresent(ObjectRepository.eDocsCheckBox);
	
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
			test.log(Status.PASS, "Verify Additional Service and Features section for existing member");
		}
	}

  @AfterTest
  public void tearDown() {
	 extent.flush();
	 driver.quit();
  }

}

