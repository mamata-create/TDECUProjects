package HomePage;

import java.io.IOException;
import java.util.*;
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

public class C26859_ValidateFAQs extends GenericKeywords  {
	ExtentReports extent;
	ExtentTest test;
	public static boolean testStatus=true;
	public static ArrayList<String> faq, faqAnswers, ans1Bullet = new ArrayList<String>();
	public static ArrayList<String> countryListArr = new ArrayList<String>(); 
	public static String q1_hyperlink1_url;
	public static String q1_hyperlink2_url;
	public static String q4_hyperlink1_url;
	/*
	 * IO: As an applicant, I would like to have access to Frequently Asked Questions on the Instant Open landing page
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
	public void C26859_ValidateFAQs() throws InterruptedException, MessagingException, IOException { 		
		if(continuetestcase==true)
		{
			String beforeClickPropValue = "panelArrow fa fa-caret-right fa-lg";
			String afterClickPropValue = "panelArrow fa fa-lg fa-caret-down";
			String collasedQuesAfterClickPValue = "panelArrow fa fa-lg fa-caret-right";
			
			pullExcelData();
				
			verifyElementPresent(ObjectRepository.app_ttl);
			test.log(Status.INFO, "Instant Open Title appearing");
			
			homePageVerification();
		
			verifyElementPresent(ObjectRepository.faqSectionTitle);
			test.log(Status.PASS, "'Frequently Asked Questions' title is visible");
			
			for(int index=0; index<5; index++){
				try{
					scrollToElement(ObjectRepository.faq_questns(faq.get(index)));
					
					verifyElementPresent(ObjectRepository.faq_questns(faq.get(index)));
					test.log(Status.PASS, "'"+faq.get(index) + "' is visible");
					
					scrollToElement(ObjectRepository.faq_collapse(index+1));
					String beforeclick= getAttribute(ObjectRepository.faq_collapse(index+1), "class");
					if (beforeclick.equals(beforeClickPropValue)){
						test.log(Status.PASS, "Question is in collapsed state");
					}else{
						test.log(Status.FAIL, "Unexpected question property value before click:"+beforeclick);
					}
							
					getElement(ObjectRepository.faq_questns(faq.get(index))).click();
					test.log(Status.INFO, "clicked questn '"+faq.get(index)+"'");
					
					String afterclick= getAttribute(ObjectRepository.faq_collapse(index+1), "class");
					if (afterclick.equals(afterClickPropValue)){
						test.log(Status.PASS, "Question expanded after click");
					}else{
						test.log(Status.FAIL, "Unexpected question property value after click:"+afterclick);
					}
					
					validateFAQanswers(faq.get(index), index);	
					
					getElement(ObjectRepository.faq_questns(faq.get(index))).click();
					test.log(Status.INFO, "clicked questn to collapse it'"+faq.get(index)+"'");
					
					String collasedQuesAfterClick= getAttribute(ObjectRepository.faq_collapse(index+1), "class");
					if (collasedQuesAfterClick.equals(collasedQuesAfterClickPValue)){
						test.log(Status.PASS, "Question returned to collapsed state");
					}else{
						test.log(Status.FAIL, "Unexpected question property value:"+collasedQuesAfterClick);
					}
				}catch(Exception e){
					System.out.println("Exception is "+e);
					test.log(Status.FAIL, "validation for '"+faq.get(index)+"' failed");
					testStatus=false;				
				}					
			}	
		}		
	}
	
	public void pullExcelData(){
		sheetName = "HomePage";
		int totalRowCount = excl.getRowCount(sheetName);
		for(startIter=1;startIter<=totalRowCount;startIter++) {
			if(this.getClass().getSimpleName().equals(excl.getCellData(sheetName, 0, startIter))){
				String t_faq = excl.getCellData(sheetName, 4 , startIter);
				String t_faqAns = excl.getCellData(sheetName, 5, startIter);
				String t_faqBullet = excl.getCellData(sheetName, 6, startIter);
				
				q1_hyperlink1_url = excl.getCellData(sheetName, 7 , startIter);
				q1_hyperlink2_url = excl.getCellData(sheetName, 8, startIter);
				q4_hyperlink1_url = excl.getCellData(sheetName, 9, startIter);
				
				String t_countryList = excl.getCellData(sheetName, 10, startIter);
				
				faq = splitString(t_faq, ";");
				faqAnswers = splitString(t_faqAns, ";");
				ans1Bullet = splitString(t_faqBullet, ";");
				countryListArr = splitString(t_countryList, ";");
				
				System.out.println(faq);
				System.out.println(faqAnswers);
				System.out.println(ans1Bullet);
				System.out.println(q1_hyperlink1_url);
				System.out.println(q1_hyperlink2_url);
				System.out.println(q4_hyperlink1_url);
				System.out.println(countryListArr);
			}
		}
	}
	
	public void validateFAQanswers(String faq, int index){
		String q1_hyperlink1_title = "Field of Membership by Company and Organization | TDECU";
		String q1_hyperlink2_title = "Field of Membership by Company and Organization | TDECU";
		String q4_hyperlink1_title = "Rates and Fees | TDECU";
	
		String ans_element = getElement(ObjectRepository.faq_answers(index+1)).getText();
		
		if(ans_element.equals(faqAnswers.get(index))){
			Assert.assertTrue(true);
			test.log(Status.PASS, "Answer matched for '"+faq+"'");
		}
		else{
			Assert.assertTrue(false);
			test.log(Status.FAIL, "Answer didn't matched for '"+faq);
		}
		
		if (index==0){
			for(int count=1;count<=4;count++){	
				String bullet = driver.findElement(By.xpath(ObjectRepository.bulletForAns1(count))).getText();
				
				if(bullet.equals(ans1Bullet.get(count-1))){
					test.log(Status.PASS, "Bullet '"+ans1Bullet.get(count-1)+"' found");
				}
				else{
					Assert.assertTrue(false);
					test.log(Status.FAIL, "Bullet '"+ans1Bullet.get(count-1)+"' not found");
				}
			}
			
			List<WebElement> countryList = retrunElements(ObjectRepository.q1_countryList);
			for(WebElement we : countryList){	
				String eachCountry = we.getText();
				if (!(countryListArr.contains(eachCountry))){
					test.log(Status.FAIL, eachCountry+" not found");
				}
			}
			
			getElement(ObjectRepository.q1_hyperlink1).click();
			test.log(Status.INFO, "clicked q1_hyperlink1 and validating");
			validateHyperlink(1, q1_hyperlink1_url, q1_hyperlink1_title);
			switchToWindow(0);
			
			getElement(ObjectRepository.q1_hyperlink2).click();
			test.log(Status.INFO, "clicked q1_hyperlink2 and validating");
			validateHyperlink(1, q1_hyperlink2_url, q1_hyperlink2_title);
			switchToWindow(0);
			 
		}
		else if(index==3){
			getElement(ObjectRepository.q4_hyperlink1).click();
			test.log(Status.INFO, "clicked q4_hyperlink1 and validating");
			validateHyperlink(1, q4_hyperlink1_url, q4_hyperlink1_title);
			switchToWindow(0);
		}
	}
	
	public void homePageVerification(){
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
		
		
		if(testStatus==false)
		{
			test.log(Status.FAIL, "Test Failed-" + result.getThrowable());
			takescreenshot(this.getClass().getSimpleName(), test);
			Assert.assertTrue(false, "Exception in test case :::IO: As an applicant, I would like to have access to Frequently Asked Questions on the Instant Open landing page");
			
		}
		else
			{
			test.log(Status.PASS, "IO: As an applicant, I would like to have access to Frequently Asked Questions on the Instant Open landing page");
			}
	}

	@AfterTest
	public void tearDown() {
		extent.flush();
		driver.quit();
	}

}
