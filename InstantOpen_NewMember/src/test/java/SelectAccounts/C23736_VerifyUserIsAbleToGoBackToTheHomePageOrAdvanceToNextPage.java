package SelectAccounts;

import java.io.IOException;

import javax.mail.MessagingException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
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
import com.github.javafaker.Faker;

public class C23736_VerifyUserIsAbleToGoBackToTheHomePageOrAdvanceToNextPage extends GenericKeywords {

	ExtentReports extent;
	ExtentTest test;
	/*
	 * Verify User is able to got back to Home Page or advance next page
	 */

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
	public void C23736_VerifyUserIsAbleToGoBackToTheHomePageOrAdvanceToNextPage() throws InterruptedException, MessagingException, IOException
	{
		
		if(continuetestcase==true)
		{
			sheetName = "Data";
			int totalRowCount = excl.getRowCount(sheetName);
			for(startIter=1;startIter<=totalRowCount;startIter++) //It is mandatory to have this for loop in every test case
			 {	
				if(this.getClass().getSimpleName().equals(excl.getCellData("Data", 0, startIter)))
				 {
					
					String informationHeader=excl.getCellData(sheetName, 23, startIter);
					String informationContent = excl.getCellData(sheetName, 24, startIter);
					String checkingAccountOptionHeader =  excl.getCellData(sheetName, 25, startIter);
					String serviceOption = " Debit Card, Mobile Check Deposit, Overdraft Protection Plan, Opt into Courtesy Pay";
					
					verifyElementPresent(ObjectRepository.app_ttl);
					test.log(Status.INFO, "Instant Open Title appearing");
					
					scrollToElement(ObjectRepository.nonmmbrstrt_btn);
					getElement(ObjectRepository.nonmmbrstrt_btn).click();
					test.log(Status.INFO, "Non Member Start here button clicked");
					
					Thread.sleep(3000);
					
					
					
					
					verifyText(ObjectRepository.inforMsgHeader,informationHeader);
					verifyText(ObjectRepository.inforMsgContent,informationContent);
					verifyText(ObjectRepository.checkingAccountOptionHeader,checkingAccountOptionHeader);
					checkingOptionValidation("High Yield Checking");
					scrollToElement(ObjectRepository.backButton);
					getElement(ObjectRepository.backButton).click();
					
					scrollToElement(ObjectRepository.nonmmbrstrt_btn);
					getElement(ObjectRepository.nonmmbrstrt_btn).click();
					test.log(Status.INFO, "Non Member Start here button clicked");
					
					Thread.sleep(3000);
					
					serviceOptionValidation("High Yield Checking",serviceOption);
					getElement(ObjectRepository.selectRadioOption("Yes")).click();
					test.log(Status.INFO, "Other option selected as Yes");
					getElement(ObjectRepository.subproductName("Savings Account")).click();
					getElement(ObjectRepository.locatorAdditionalOption("Club Account")).click();
					getElement(ObjectRepository.continue_btn).click();
					if(getElement(ObjectRepository.continue_btn).getAttribute("value").contains("Processing...")){
						Assert.assertTrue(true, "Continue button changed to Processing...");
					}
					scrollToElement(ObjectRepository.backButton);
					getElement(ObjectRepository.backButton).click();
					if(getElement(ObjectRepository.backButton).getAttribute("value").contains("Processing...")){
						Assert.assertTrue(true, "Back button changed to Processing...");
					}
					scrollToElement(ObjectRepository.locatorAdditionalOption("Club Account"));
					if(ObjectRepository.locatorInfo("Club Account").contains("checked")){
						Assert.assertTrue(true, "Club Account checkbox is checked");
					}
					/*getElement(ObjectRepository.selectRadioOption("Yes")).click();
					test.log(Status.INFO, "Other option selected as Yes");
					
					
					getElement(ObjectRepository.subproductName("Additional Services and Features")).click();
					
					if(ObjectRepository.locatorInfo("E-Documents").contains("checked")){
						Assert.assertTrue(true, "E-document checkbox is checked");
					}
					getElement(ObjectRepository.locatorAdditionalOption("E-Documents")).click();
					if(!ObjectRepository.locatorInfo("E-Documents").contains("checked")){
						Assert.assertTrue(true, "E-document checkbox is un-checked");
					}
					
					verifyElementPresent(ObjectRepository.modalHelpIcon);
					getElement(ObjectRepository.modalHelpIcon).click();
					verifyElementPresent(ObjectRepository.eDocumentHeader);
					verifyText(ObjectRepository.eDocumentModalBody,edocumentModalBodyText);
					getElement(ObjectRepository.eDocumentModalCloseButton).click();*/
					
				
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
			test.log(Status.PASS, "Verify User is able to got back to Home Page or advance next page");
		}
	}

	@AfterTest
	public void tearDown() {
		extent.flush();
		driver.quit();
	}

}
