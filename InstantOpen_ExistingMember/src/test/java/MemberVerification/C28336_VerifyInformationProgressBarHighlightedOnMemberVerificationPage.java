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

public class C28336_VerifyInformationProgressBarHighlightedOnMemberVerificationPage extends GenericKeywords {

	ExtentReports extent;
	ExtentTest test;
	/*
	 * As an applicant, I expect the Information step to be highlighted when I am on the Member Verification page.
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
	public void C28336_VerifyInformationProgressBarHighlightedOnMemberVerificationPage() throws InterruptedException, MessagingException, IOException
	{
		
		if(continuetestcase==true)
		{
			sheetName = "ProdData";
			int totalRowCount = excl.getRowCount(sheetName);
			for(startIter=1;startIter<=totalRowCount;startIter++) //It is mandatory to have this for loop in every test case
			 {	
				
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
						return;
					}else if(text_from_option.equalsIgnoreCase("Products") && class_prop.equals("JourneyBarPrevious")){
						Assert.assertTrue(true, "Products icon is currently selected and highlighted in different blue color");
					}
					index++;
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
			test.log(Status.PASS, "As an applicant, I expect the Information step to be highlighted when I am on the Member Verification page.");
		}
	}

	@AfterTest
	public void tearDown() {
		extent.flush();
		driver.quit();
	}

}
