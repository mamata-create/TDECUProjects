package MemberVerification;

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

public class C28371_ValidateDeliveryMethodForOneTimePassWord extends GenericKeywords {

	ExtentReports extent;
	ExtentTest test;
	/*
	 * As an existing Member, I would like to be prompted to select a delivery method for my one-time passcode
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
	public void C28371_ValidateDeliveryMethodForOneTimePassWord() throws InterruptedException, MessagingException, IOException
	{
		
		if(continuetestcase==true)
		{
			sheetName = "MemberVerification";
			int totalRowCount = excl.getRowCount(sheetName);
			for(startIter=1;startIter<=totalRowCount;startIter++) //It is mandatory to have this for loop in every test case
			 {	
				if(this.getClass().getSimpleName().equals(excl.getCellData(sheetName, 0, startIter))){
					String page_header = "Verify Your TDECU Membership";
					String below_info_1 = "Complete the following fields for a faster experience. Since you’re already a Member, we’ll populate part of the application for you.";
					String below_info_2 = "*Indicates a required field";
					String ssn_placeHolder = "Enter your 9-digit Social Security Number";
					String dob_placeHolder = "Enter date as MM/DD/YYYY";
					String ssn = excl.getCellData(sheetName, 1, startIter);
					String dob = excl.getCellData(sheetName, 2, startIter);
					//Start as a Member
					scrollToElement(ObjectRepository.mmbrstrt_btn);
					getElement(ObjectRepository.mmbrstrt_btn).click();
					test.log(Status.INFO, "Members Start Here button clicked");
					
					
					//select Classic Credit Card option
					getElement(ObjectRepository.creditCardExpand).click();
					getElement(ObjectRepository.platinumCheckBox).click();
					test.log(Status.INFO, "Platinum credit card selected");
					getElement(ObjectRepository.productPageNext).click();
					test.log(Status.INFO, "Continue button clicked");
					
					getElement(ObjectRepository.prodLimitTextbox).sendKeys("100000");
					getElement(ObjectRepository.prodInfoNextButton).click();
					test.log(Status.INFO, "Credit card amount entered");
					
					//Return all elements on progressbar
					
					int index=1;
					for(WebElement eachOption :returnElements(ObjectRepository.progressBarOptions)){
						
						String text_from_option = eachOption.getText();
						String class_prop = eachOption.findElement(By.xpath("(//span[@id='progBar']//span/..)["+index+"]")).getAttribute("class");
						if(text_from_option.equalsIgnoreCase("Information") && class_prop.equals("JourneyBarCurrent")){
							Assert.assertTrue(true, "Information icon is currently selected and highlighted on the page");
							break;
						}else if(text_from_option.equalsIgnoreCase("Products") && class_prop.equals("JourneyBarPrevious")){
							Assert.assertTrue(true, "Products icon is currently selected and highlighted in different blue color");
						}
						index++;
					}
					
					//Page header and below header info validation
					
					verifyText(ObjectRepository.member_verification_page_header,page_header);
					verifyText(ObjectRepository.below_header_info(1),below_info_1);
					verifyText(ObjectRepository.below_header_info(2),below_info_2);
					
					//SSN and DOB Placeholder validation
					Assert.assertEquals(getElement(ObjectRepository.mmbrVerifySSN).getAttribute("placeholder"), ssn_placeHolder);
					Assert.assertEquals(getElement(ObjectRepository.mmbrVerifyDOB).getAttribute("placeholder"), dob_placeHolder);
					
					//Click on Back button and again Continue with further steps
					getElement(ObjectRepository.mmbrVerifySSN).sendKeys(ssn);
					getElement(ObjectRepository.mmbrVerifyDOB).sendKeys(dob);
					getElement(ObjectRepository.productPageNext).click();
					
					//OTP page appeare
					
					verifyText(ObjectRepository.otp_page_header,"One Time Passcode");
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
			test.log(Status.PASS, "As an existing Member, I would like to be prompted to select a delivery method for my one-time passcode");
		}
	}

	@AfterTest
	public void tearDown() {
		extent.flush();
		driver.quit();
	}

}
