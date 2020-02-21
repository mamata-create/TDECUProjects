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

public class C28363_VerifyFAQregradingPromoCode extends GenericKeywords  {
	ExtentReports extent;
	ExtentTest test;
	/*
	 * As TDECU, I would like to add a new question to the FAQ section on the landing page so applicants know where to enter their promo code during the application process.
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
	public void C28363_VerifyFAQregradingPromoCode() throws InterruptedException, MessagingException, IOException
	{
		
		if(continuetestcase==true)
		{
		
			
		 String faq_text_val= "As long as the promotional offer is valid for online applications, you can enter your promo code using this process. Once you reach the Confirm Selected Products and Services page, you will see a field to enter your promo code.";
					
					
					verifyElementPresent(ObjectRepository.app_ttl);
					test.log(Status.INFO, "Instant Open Title appearing");
					
					//Click on new FAQ and validate the text
					scrollToElement(ObjectRepository.faq_based_on_number("5"));
					
					verifyText(ObjectRepository.faq_based_on_number("5"),"I received a promo code. Can I use the code when applying online?");
					getElement(ObjectRepository.faq_based_on_number("5")).click();
					Thread.sleep(1500);
					verifyText(ObjectRepository.faq_text("5"),faq_text_val.trim());
					
						
					
				 
			 }
		
				
	}
	@AfterMethod
	public void afterMethod(ITestResult result) throws Throwable {
		if (result.getStatus() == ITestResult.FAILURE) {
			test.log(Status.FAIL, "Test Failed-" + result.getThrowable());

			takescreenshot(this.getClass().getSimpleName(), test);
		} else {
			test.log(Status.PASS, "As TDECU, I would like to add a new question to the FAQ section on the landing page so applicants know where to enter their promo code during the application process.");
		}
	}

	@AfterTest
	public void tearDown() {
		extent.flush();
		driver.quit();
	}

}
