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

public class C28325_VerifyThatUserShouldLandingOnApplicationStatusCenterPage extends GenericKeywords {

	ExtentReports extent;
	ExtentTest test;
	/*
	 * As TDECU, I want to redesign the Application Status Center page so it's easier to navigate by both new and existing members
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
	public void C28325_VerifyThatUserShouldLandingOnApplicationStatusCenterPage() throws InterruptedException, MessagingException, IOException
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
			test.log(Status.PASS, "As TDECU, I want to redesign the Application Status Center page so it's easier to navigate by both new and existing members");
		}
	}

	@AfterTest
	public void tearDown() {
		extent.flush();
		driver.quit();
	}

}
