package StatusCenter;

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

public class C28326_VerifyThatUserCanResetPassword extends GenericKeywords {

	ExtentReports extent;
	ExtentTest test;
	/*
	 * As an applicant, I would like to have the option to reset my password
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
	public void C28326_VerifyThatUserCanResetPassword() throws InterruptedException, MessagingException, IOException
	{
		
		if(continuetestcase==true)
		{
			sheetName = "ApplicationStatusCenter";
			int totalRowCount = excl.getRowCount(sheetName);
			for(startIter=1;startIter<=totalRowCount;startIter++) //It is mandatory to have this for loop in every test case
			 {	
				if(this.getClass().getSimpleName().equals(excl.getCellData(sheetName, 0, startIter))){
					String app_url=excl.getCellData(sheetName, 1, startIter);
					String page_header = excl.getCellData(sheetName, 2, startIter);
					String email_address = excl.getCellData(sheetName, 3, startIter);
					String four_digit_ssn = excl.getCellData(sheetName, 4, startIter);
					String note_header = excl.getCellData(sheetName, 5, startIter);
					String paragraph_message = excl.getCellData(sheetName, 6, startIter);
					int iterator = 0;
					//Click on Check Status button on page
					getElement(ObjectRepository.check_status_button).click();
					
					//Validate application url
					Assert.assertEquals(getCurrentUrl(), app_url, "Expected url not found. Application landing on different page");
					
					//Validate page header
					Assert.assertEquals(getElement(ObjectRepository.page_header).getText(), page_header, "Page header found different");
				
					//Validate page fields under Returing User section
					scrollToElement(ObjectRepository.email_address_textBox);
					verifyElementPresent(ObjectRepository.email_address_textBox);
					verifyElementPresent(ObjectRepository.password_textBox);
					verifyElementPresent(ObjectRepository.ssn_textBox);
					
					getElement(ObjectRepository.forget_password_button).click();
					verifyElementPresent(ObjectRepository.reset_password_page_header);
					getElement(ObjectRepository.cancel_btn).click();
					verifyElementPresent(ObjectRepository.page_header);
					
					getElement(ObjectRepository.forget_password_button).click();
					verifyElementPresent(ObjectRepository.reset_password_page_header);
					getElement(ObjectRepository.forget_email_address_textBox).sendKeys(email_address);
					getElement(ObjectRepository.ssn_textBox).sendKeys(four_digit_ssn);
					getElement(ObjectRepository.submit_button_reset_password).click();
					
					for(WebElement eachHeader: retrunElements(ObjectRepository.note_message_header)){
						String note_header_from_page = eachHeader.getText().trim();
						String header_message = note_header.split("::")[iterator].trim();
						
						if(note_header_from_page.contains(header_message)){
							Assert.assertTrue(true, "Header message found but not matched");
							iterator++;
						}
						
					}
					iterator = 0;
					for(WebElement eachPara: retrunElements(ObjectRepository.note_paragraph)){
						
						String note_paragraph_from_page = eachPara.getText().trim();
						String paragraph_message_data = paragraph_message.split(":::")[iterator].trim();
						
						if(note_paragraph_from_page.contains(paragraph_message_data)){
							Assert.assertTrue(true, "Paragraph message found but not matched");
							iterator++;
						}
					}
					
					getElement(ObjectRepository.return_to_login_button).click();
					Assert.assertEquals(getElement(ObjectRepository.page_header).getText(), page_header, "Page header found different");
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
			test.log(Status.PASS, "As an applicant, I would like to have the option to reset my password");
		}
	}

	@AfterTest
	public void tearDown() {
		extent.flush();
		driver.quit();
	}

}
