package CreditCard;

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

public class C28333_VerifyInformationProgressBarHighlightedOnCreditCardInfoPage extends GenericKeywords {

	ExtentReports extent;
	ExtentTest test;
	/*
	 * As an applicant, I expect the Information step to be highlighted when I am on the Credit Card Information page.
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
	public void C28333_VerifyInformationProgressBarHighlightedOnCreditCardInfoPage() throws InterruptedException, MessagingException, IOException
	{
		
		if(continuetestcase==true)
		{
			sheetName = "Data";
			int totalRowCount = excl.getRowCount(sheetName);
			for(startIter=1;startIter<=totalRowCount;startIter++) //It is mandatory to have this for loop in every test case
			 {	
				
				//Start as a Non Member
				scrollToElement(ObjectRepository.nonmmbrstrt_btn);
				getElement(ObjectRepository.nonmmbrstrt_btn).click();
				
				
				//Dont want to open a checking account option selected	
				scrollToElement(ObjectRepository.dontWantCheckingOption);
				getElement(ObjectRepository.dontWantCheckingOption).click();
				test.log(Status.INFO, "Dont want to open a checking account option selected");
			
				jsclick(getElement(ObjectRepository.selectRadioOption("Yes")));
				test.log(Status.INFO, "Yes option selected");
				
				//select Classic Credit Card option
				expandProductsAndValidateEachOptions("Credit Cards","CreditCard");
				creditCardCheckedUncheckedValidator("Classic",false);
				getElement(ObjectRepository.continue_btn).click();
				//Return all elements on progressbar
				
				int index=1;
				for(WebElement eachOption :retrunElements(ObjectRepository.progressBarOptions)){
					
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
			test.log(Status.PASS, "As an applicant, I expect the Information step to be highlighted when I am on the Credit Card Information page.");
		}
	}

	@AfterTest
	public void tearDown() {
		extent.flush();
		driver.quit();
	}

}
