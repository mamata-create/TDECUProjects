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

public class C26858_Verify_Thumbnail_HorizontallyDisplayedHomePage extends GenericKeywords  {
	ExtentReports extent;
	ExtentTest test;
	/*
	 * As TDECU, I would like to redesign the different options on the Instant Open landing page so they appear horizontally.
	 * Creation Date: 03/13/2020
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
	public void C26858_Verify_Thumbnail_HorizontallyDisplayedHomePage() throws InterruptedException, MessagingException, IOException
	{
		
		if(continuetestcase==true)
		{
					homePageVerification();
					
					
					getElement(ObjectRepository.newToTDECU_StartHere).click();
					verifyText(ObjectRepository.header_ExisitngMemberandNonMember_Subpages, "Let’s open your new account!");
					test.log(Status.INFO, "The applicant is redirected to the New Member workflow");
					navigateBack();
					
					
					getElement(ObjectRepository.alreadyMember_StartHere).click();
					verifyText(ObjectRepository.header_ExisitngMemberandNonMember_Subpages, "Let’s get started!");
					test.log(Status.INFO, "The member is redirected to the Existing Member workflow.");
					navigateBack();
					
					getElement(ObjectRepository.pendingApplication_StartHere).click();
					verifyText(ObjectRepository.header_PendingApplication_Subpage, "Welcome to the Application Status Center");
					test.log(Status.INFO, "The user is redirected to the Application Center.");
					navigateBack();
					
					
					
					
					
			}
		
				
			
					
				 
			 
		
				
	}
		public void homePageVerification()
		{
					verifyElementPresent(ObjectRepository.progressBar);
					test.log(Status.INFO, "Progressbar Status");
					for(int progressbarindex=0;progressbarindex<6;progressbarindex++)
					{
						String [] progressBarText = {"Start","Products","Information","Verification","Disclosures","Funding"};
						verifyText(ObjectRepository.progressBarText(progressbarindex+1),progressBarText[progressbarindex]);
						test.log(Status.INFO, "Progress Bar Text displayed");
				
					}
					
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
		}
			
	
	@AfterMethod
	public void afterMethod(ITestResult result) throws Throwable {
		if (result.getStatus() == ITestResult.FAILURE) {
			test.log(Status.FAIL, "Test Failed-" + result.getThrowable());

			takescreenshot(this.getClass().getSimpleName(), test);
		} else {
			test.log(Status.PASS, "As TDECU, I would like to redesign the different options on the Instant Open landing page so they appear horizontally.");
		}
	}

	@AfterTest
	public void tearDown() {
		extent.flush();
		driver.quit();
	}

}