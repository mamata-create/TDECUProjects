package HomePage;

import java.io.IOException;
import java.util.List;

import javax.mail.MessagingException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.ClickAction;
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

public class C26856_Verify_HelpModal_HomePage extends GenericKeywords  {
	ExtentReports extent;
	ExtentTest test;
	/*
	 * As an applicant, I would like to have a help modal to understand what qualifies for Government issued identification.
	 * Creation Date: 03/12/2020
	 * Created By: Ashish
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
	public void C26856_Verify_HelpModal_HomePage() throws InterruptedException, MessagingException, IOException
	{
		
		if(continuetestcase==true)
		{
			
					verifyElementPresent(ObjectRepository.progressBar);
					test.log(Status.INFO, "Progressbar Status");
			
					String page_header= "Are You Ready to Experience the TDECU Difference?";
					verifyText(ObjectRepository.page_header_locator,page_header);
					test.log(Status.INFO, page_header);
					
					
					verifyElementPresent(ObjectRepository.sub_Header);
					test.log(Status.INFO, "Apply for your account in minutes!");
					
					
					
					String [] thumbNailText = {"New to TDECU?","Already a Member?","Pending Application?"};
					for(int thumbnail=0;thumbnail<=2;thumbnail++)
					{
						verifyText(ObjectRepository.thumbnail_Set(thumbnail+1), thumbNailText[thumbnail]);
						System.out.println(thumbNailText[thumbnail]+" appearing");
						test.log(Status.INFO, thumbNailText[thumbnail]);
					}
					
					
					verifyElementPresent(ObjectRepository.for_CheckingSavings_Cds);
					test.log(Status.INFO, "For checking, savings and CDs Section Displayed");
					
					
					verifyElementPresent(ObjectRepository.for_LoansandCreditCards);
					test.log(Status.INFO, "For loans and credit cards Displayed");
					
					
					verifyElementPresent(ObjectRepository.frequentlyAskedQuestions_Section);
					test.log(Status.INFO, "frequently Asked Questions Section Displayed");
					
			
					scrollDownPage();
					
					verifyElementPresent(ObjectRepository.importantAccountOpenningInformation);
					test.log(Status.INFO, "IMPORTANT ACCOUNT OPENING INFORMATION Section Displayed");
					
					scrollUpPage();
					
			
					getElement(ObjectRepository.govt_issued_identificaiton_CheckingSavings_QuestionMark).click();
					String modalHeading_CheckingSavings="What Qualifies as a Government ID?";
					
					verifyText(ObjectRepository.govt_issued_identificaiton_CheckingSavings_QuestionMark_Modal, modalHeading_CheckingSavings);
					test.log(Status.INFO, "What Qualifies as a Government ID? Modal Displayed");
					
					getElement(ObjectRepository.govt_issued_identificaiton_CheckingSavings_QuestionMark_Modal_CloseButton).click();
					
					verifyElementNotPresent(ObjectRepository.govt_issued_identificaiton_CheckingSavings_QuestionMark_Modal);
					test.log(Status.INFO, "Modal Closed Successfully");
					
					
					
					
					
					
			}
		
				
			
					
				 
			 
		
				
	}
	@AfterMethod
	public void afterMethod(ITestResult result) throws Throwable {
		if (result.getStatus() == ITestResult.FAILURE) {
			test.log(Status.FAIL, "Test Failed-" + result.getThrowable());

			takescreenshot(this.getClass().getSimpleName(), test);
		} else {
			test.log(Status.PASS, "As an applicant, I would like to have a help modal to understand what qualifies for Government issued identification.");
		}
	}

	@AfterTest
	public void tearDown() {
		extent.flush();
		driver.quit();
	}

}
