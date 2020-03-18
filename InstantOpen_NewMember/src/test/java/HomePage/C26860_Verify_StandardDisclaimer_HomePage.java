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

public class C26860_Verify_StandardDisclaimer_HomePage extends GenericKeywords  {
	ExtentReports extent;
	ExtentTest test;
	/*
	 * IO: As an applicant, I would to see a standard disclaimer on the Instant Open landing page.
	 * Creation Date: 03/14/2020
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
	public void C26860_Verify_StandardDisclaimer_HomePage() throws InterruptedException, MessagingException, IOException
	{
		
		if(continuetestcase==true)
		{
					
			sheetName = "HomePage";
			int totalRowCount = excl.getRowCount(sheetName);
			homePageVerification();
			scrollDownPage();
			
			for(startIter=1;startIter<=totalRowCount;startIter++) {
				if(this.getClass().getSimpleName().equals(excl.getCellData(sheetName, 0, startIter))){
					
					String page_desclamer = excl.getCellData(sheetName, 1 , startIter);
					String page_sub_desclamer_1 = excl.getCellData(sheetName, 2, startIter);
					String page_sub_desclamer_2 = excl.getCellData(sheetName, 3, startIter);
					
					verifyElementPresent(ObjectRepository.disclaimer_section);
					test.log(Status.INFO, "A 'Disclaimer' is displayed in a box above the phone number");
					
					
					verifyText(ObjectRepository.pageDisclaimer,page_desclamer);
					test.log(Status.INFO, "Disclaimer header is displayed");
					verifyText(ObjectRepository.sub_disclaimer_text("1"),page_sub_desclamer_1);
					verifyText(ObjectRepository.sub_disclaimer_text("2"),page_sub_desclamer_2);
					test.log(Status.INFO, "Disclaimer content is displayed");
				}
			}
			
					
					
					
					
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
			test.log(Status.PASS, "IO: As an applicant, I would to see a standard disclaimer on the Instant Open landing page.");
		}
	}

	@AfterTest
	public void tearDown() {
		extent.flush();
		driver.quit();
	}

}