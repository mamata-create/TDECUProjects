package Miscellaneous;

import java.io.IOException;

import javax.mail.MessagingException;

import org.openqa.selenium.WebElement;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.FrameworkComponents.BaseClass;
import com.FrameworkComponents.ExtentManager;
import com.FrameworkComponents.GenericKeywords;
import com.FrameworkComponents.ObjectRepository;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.github.javafaker.Faker;

import junit.framework.Assert;

public class TC001_ValidateTheAditionalLinkAndShowAllFesturedUnderCDSection   extends GenericKeywords{
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
  public void TC001_ValidateTheAditionalLinkAndShowAllFesturedUnderCDSection() throws InterruptedException, MessagingException, IOException {
	  if(continuetestcase==true)
	  {
			sheetName = "Miscellaneous";
			int totalRowCount = excl.getRowCount(sheetName);
			for(startIter=1;startIter<=totalRowCount;startIter++) //It is mandatory to have this for loop in every test case
			{	
				if(this.getClass().getSimpleName().equals(excl.getCellData(sheetName, 0, startIter)))
				 {
					Faker fk=new Faker();
					String num=getRandomFourDigit();
					
					String ssn=excl.getCellData(sheetName, 7, startIter);
					ssn=ssn+num;
					String dob=excl.getCellData(sheetName, 8, startIter);
					dob=dob+num;
					SoftAssert softassert = new SoftAssert();
					
					verifyElementPresent(ObjectRepository.app_ttl);
					test.log(Status.INFO, "Instant Open Title appearing");
					
					scrollToElement(ObjectRepository.nonmmbrstrt_btn);
					getElement(ObjectRepository.nonmmbrstrt_btn).click();
					test.log(Status.INFO, "Non Members Start Here button clicked");
					Thread.sleep(4000);
					
				//checking account option selected	
					scrollToElement(ObjectRepository.clscchking_opt);
					Thread.sleep(2000);
					getElement(ObjectRepository.clscchking_opt).click();
					test.log(Status.INFO, "Classic checking account option selected");
				
					Thread.sleep(4000);
					
					getElement(ObjectRepository.needloan_yes).click();
					test.log(Status.INFO, "yes option selected");
					
					Thread.sleep(2000);
				//Certificate of Deposit option selected	
					getElement(ObjectRepository.crtfctdpst_opt).click();
					test.log(Status.INFO, "Certificate of Deposit panel expanded");
					Thread.sleep(2000);
					
					//Show All checkbox clicked
					
					getElement(ObjectRepository.showAll_checkBox).click();
					
					//Check whether month wise checkboxes are displyed
					for(WebElement element : retrunElements(ObjectRepository.all_month_options)){
						String elementDisplayType = element.getAttribute("style");
						
						if(elementDisplayType.contains("display: block")){
							softassert.assertTrue(true, "Month with checkboxes not displayed");
						}
					}
					
					
					getElement(ObjectRepository.showAll_checkBox).click();
					
					//Check whether month wise checkboxes are disappeared
					for(WebElement element : retrunElements(ObjectRepository.all_month_options)){
						String elementDisplayType = element.getAttribute("style");
						
						if(elementDisplayType.contains("display: none;")){
							softassert.assertTrue(true, "Month with checkboxes still displayed");
						}
					}
					
					//Fee Schedule link validation
					
					getElement(ObjectRepository.feeSchedule_link).click();
					handleMultipleWindow(1,getElement(ObjectRepository.feeSchedule_link).getAttribute("href"));
					
					//Validate controlles are in Fees and Rate Page
					
					softassert.assertNotEquals(driver.getTitle(), "Rates and Fees | TDECU");
					handleMultipleWindow(0,"");
					
					//Rate link validation
					
					getElement(ObjectRepository.rate_link).click();
					handleMultipleWindow(1,getElement(ObjectRepository.feeSchedule_link).getAttribute("href"));
					
					softassert.assertNotEquals(driver.getTitle(), "Rates and Fees | TDECU");
				
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
			test.log(Status.PASS, "Verify Certificate of Deposit default Funding Amount scenario working fine");
		}
	}

  @AfterTest
  public void tearDown() {
	 extent.flush();
	 driver.quit();
  }

}
