package HomePage;

import java.io.IOException;
import java.util.List;

import javax.mail.MessagingException;

import org.openqa.selenium.By;
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

public class C28369_VerifyMemberNumberInfoRemovedFromHomePage extends GenericKeywords  {
	ExtentReports extent;
	ExtentTest test;
	/*
	 * Remove Member Number Information from the Landing Page
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
	public void C28369_VerifyMemberNumberInfoRemovedFromHomePage() throws InterruptedException, MessagingException, IOException
	{
		
		if(continuetestcase==true)
		{
			sheetName = "HomePage";
			int totalRowCount = excl.getRowCount(sheetName);
			for(startIter=1;startIter<=totalRowCount;startIter++) {
				if(this.getClass().getSimpleName().equals(excl.getCellData(sheetName, 0, startIter))){
					String page_header= "Are You Ready to Experience the TDECU Difference?";
					String [] thumbNailText = {"New to TDECU?","Already a Member?","Pending Application?"};
					String page_desclamer = excl.getCellData(sheetName, 1 , startIter);
					String page_sub_desclamer_1 = excl.getCellData(sheetName, 2, startIter);
					String page_sub_desclamer_2 = excl.getCellData(sheetName, 3, startIter);
					
					verifyElementPresent(ObjectRepository.app_ttl);
					test.log(Status.INFO, "Instant Open Title appearing");
					
					
					verifyText(ObjectRepository.page_header_locator,page_header);
					
					int thubNailIndex = 0;
					for(WebElement eachThumbNail : retrunElements(ObjectRepository.thumbnail_text)){
						
						if(eachThumbNail.getText().equalsIgnoreCase(thumbNailText[thubNailIndex])){
							Assert.assertTrue(true, "thumbnail doesn't match");
							thubNailIndex++;
						}
					}
					
					verifyText(ObjectRepository.pageDisclaimer,page_desclamer);
					verifyText(ObjectRepository.sub_disclaimer_text("1"),page_sub_desclamer_1);
					verifyText(ObjectRepository.sub_disclaimer_text("2"),page_sub_desclamer_2);
					
					String pageContent = driver.getPageSource();
					
					if(!pageContent.contains("Are you already a TDECU Member")){
						Assert.assertTrue(true, "Are you already a TDECU Member is present");
					}
					
					if(!pageContent.contains("Have your Member Number ready before starting your application.")){
						Assert.assertTrue(true, "Have your Member Number ready before starting your application.");
					}
					if(!pageContent.contains("Adding someone as a joint on the account")){
						Assert.assertTrue(true, "Adding someone as a joint on the account");
					}
					if(!pageContent.contains("Here's what you will need to apply:")){
						Assert.assertTrue(true, "Here's what you will need to apply:");
					}
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
			test.log(Status.PASS, "Remove Member Number Information from the Landing Page");
		}
	}

	@AfterTest
	public void tearDown() {
		extent.flush();
		driver.quit();
	}

}
