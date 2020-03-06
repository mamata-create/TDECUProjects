package JointOwnersBeneficiaries;

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

public class C28345_VerifyThatInformationTabIsHighLightedWhenUserOnLookupBeneficiariesPage extends GenericKeywords {

	ExtentReports extent;
	ExtentTest test;
	/*
	 *  As an existing member, I expect the Information step to be highlighted when I am on the Lookup Beneficiaries page.
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
	public void C28345_VerifyThatInformationTabIsHighLightedWhenUserOnLookupBeneficiariesPage() throws InterruptedException, MessagingException, IOException
	{
		
		if(continuetestcase==true)
		{
			sheetName = "ProdData";
			int totalRowCount = excl.getRowCount(sheetName);
			for(startIter=1;startIter<=totalRowCount;startIter++) //It is mandatory to have this for loop in every test case
			 {	
				if(this.getClass().getSimpleName().equals(excl.getCellData(sheetName, 0, startIter))){
					
					
					String SSN= excl.getCellData(sheetName, 28, startIter);
					String DOB= excl.getCellData(sheetName, 29, startIter);
					//Start as a Member
					scrollToElement(ObjectRepository.mmbrstrt_btn);
					getElement(ObjectRepository.mmbrstrt_btn).click();
					test.log(Status.INFO, "Members Start Here button clicked");
					
					
					//select Classic Credit Card option
					//Select Products
					getElement(ObjectRepository.checkingExpand).click();
					getElement(ObjectRepository.mnyMrktCheckBox).click();
					getElement(ObjectRepository.productPageNext).click();
					test.log(Status.INFO, "Money Market account selected");
					
					getElement(ObjectRepository.mmbrVerifySSN).sendKeys(SSN);
					getElement(ObjectRepository.mmbrVerifyDOB).sendKeys(DOB);
					getElement(ObjectRepository.mmbrVerifyNext).click();
					test.log(Status.INFO, "Member Verified");
					
					//Delivery Method page
					
					verifyText(ObjectRepository.delivery_method_page_header,"Select a Delivery Method");
					test.log(Status.INFO, "user on Delivery Method page");
					
					enter_otp_to_the_field_and_procced();
					
					//Applicant Info
					verifyElementPresent(ObjectRepository.fname);
					verifyElementPresent(ObjectRepository.lname);
					verifyElementPresent(ObjectRepository.stAddr);
					verifyElementPresent(ObjectRepository.cityStZip);
					selectDropdownOpt(ObjectRepository.commDdown,"Email");
//				
					
					test.log(Status.INFO, "Applicant Information entered");
					
					getElement(ObjectRepository.addBeneCheckBox).click();
					getElement(ObjectRepository.productPageNext).click();
					test.log(Status.INFO, "Beneficiary checkbox selected");
					//Joint Owner
					verifyElementPresent(ObjectRepository.addBeneTtl);
					
					//Existing member Lookup
					verifyElementPresent(ObjectRepository.add_existing_member_lookup_link);
					getElement(ObjectRepository.add_existing_member_lookup_link).click();
					verifyText(ObjectRepository.additional_account_beneficiary_header,"Additional Account Beneficiaries");
					
					//Return all elements on progressbar
					
					int index=1;
					for(WebElement eachOption :returnElements(ObjectRepository.progressBarOptions)){
						
						String text_from_option = eachOption.getText();
						String class_prop = eachOption.findElement(By.xpath("(//span[@id='progBar']//td)["+index+"]")).getAttribute("class");
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
				
	}

	@AfterMethod
	public void afterMethod(ITestResult result) throws Throwable {
		if (result.getStatus() == ITestResult.FAILURE) {
			test.log(Status.FAIL, "Test Failed-" + result.getThrowable());

			takescreenshot(this.getClass().getSimpleName(), test);
		} else {
			test.log(Status.PASS, "As an existing member, I expect the Information step to be highlighted when I am on the Beneficiaries page.");
		}
	}

	@AfterTest
	public void tearDown() {
		extent.flush();
		driver.quit();
	}

}
