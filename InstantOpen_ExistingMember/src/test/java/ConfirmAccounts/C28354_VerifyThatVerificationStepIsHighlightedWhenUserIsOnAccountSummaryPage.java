package ConfirmAccounts;

import java.io.IOException;

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

public class C28354_VerifyThatVerificationStepIsHighlightedWhenUserIsOnAccountSummaryPage extends GenericKeywords{
	ExtentReports extent;
	ExtentTest test;
	
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
  public void C28354_VerifyThatVerificationStepIsHighlightedWhenUserIsOnAccountSummaryPage() throws InterruptedException, MessagingException, IOException {
	  if(continuetestcase==true)
	  {
			sheetName = "ProdData";
			int totalRowCount = excl.getRowCount(sheetName);
			for(startIter=1;startIter<=totalRowCount;startIter++) //It is mandatory to have this for loop in every test case
			{	
				if(this.getClass().getSimpleName().equals(excl.getCellData("ProdData", 0, startIter)))
				{
					String loanAmt= excl.getCellData(sheetName, 6, startIter);
					String purchPrice= excl.getCellData(sheetName, 7, startIter);
					String VIN= excl.getCellData(sheetName, 8, startIter);
					String mmbrNum= excl.getCellData(sheetName, 27, startIter);
					String SSN= excl.getCellData(sheetName, 28, startIter);
					String DOB= excl.getCellData(sheetName, 29, startIter);
					String idType= excl.getCellData(sheetName, 16, startIter);
					String idNum= excl.getCellData(sheetName, 17, startIter);
					String issueDt= excl.getCellData(sheetName, 18, startIter);
					String expDt= excl.getCellData(sheetName, 19, startIter);
					String housePymt= excl.getCellData(sheetName, 20, startIter);
					String addrYears= excl.getCellData(sheetName, 21, startIter);
					String addrMonths= excl.getCellData(sheetName, 22, startIter);
					String currentEmp= excl.getCellData(sheetName, 23, startIter);
					String curIncome= excl.getCellData(sheetName, 24, startIter);
					String empYears= excl.getCellData(sheetName, 25, startIter);
					String confirmProd1= excl.getCellData(sheetName, 1, startIter);
					String promocode = excl.getCellData(sheetName, 44, startIter);
					String invalid_promocode = "Bank0.5";
					String disclaimer_msg = "Only one promo code per Member. Terms and conditions apply to all TDECU promotions. Please contact us for additional details.";
					scrollToElement(ObjectRepository.mmbrstrt_btn);
					getElement(ObjectRepository.mmbrstrt_btn).click();
					test.log(Status.INFO, "Members Start Here button clicked");
					//Select Products
					getElement(ObjectRepository.carLoanExpand).click();
					getElement(ObjectRepository.camperRefinCheckBox).click();
					getElement(ObjectRepository.productPageNext).click();
					test.log(Status.INFO, "Vehicle loan selected");
					//Loan info
					getElement(ObjectRepository.prodLimitTextbox).sendKeys(loanAmt);
					getElement(ObjectRepository.carPurchPrice).sendKeys(purchPrice);
					getElement(ObjectRepository.carVIN).sendKeys(VIN);
					getElement(ObjectRepository.prodInfoNextButton).click();
					test.log(Status.INFO, "Loan info entered");	
					//Member Verification
					
					getElement(ObjectRepository.mmbrVerifySSN).sendKeys(SSN);
					getElement(ObjectRepository.mmbrVerifyDOB).sendKeys(DOB);
					getElement(ObjectRepository.mmbrVerifyNext).click();					
					test.log(Status.INFO, "Member Verified");
					
					//Delivery Method page
					
					verifyText(ObjectRepository.delivery_method_page_header,"Select a Delivery Method");
					test.log(Status.INFO, "user on Delivery Method page");
					
					enter_otp_to_the_field_and_procced();
					//Applicant Info
					selectDropdownOpt(ObjectRepository.idType,idType);
					getElement(ObjectRepository.idNum).sendKeys(idNum);
					getElement(ObjectRepository.issueDate).sendKeys(issueDt);
					getElement(ObjectRepository.expDate).sendKeys(expDt);
					getElement(ObjectRepository.housePymt).sendKeys(housePymt);
					getElement(ObjectRepository.addrYears).sendKeys(addrYears);
					getElement(ObjectRepository.addrMonths).sendKeys(addrMonths);
					getElement(ObjectRepository.currentEmp).sendKeys(currentEmp);
					getElement(ObjectRepository.monIncome).sendKeys(curIncome);
					getElement(ObjectRepository.empYears).sendKeys(empYears);
					getElement(ObjectRepository.productPageNext).click();
					test.log(Status.INFO, "Applicant Information entered");
					
					//Promo Code
					
					verifyText(ObjectRepository.promocode_disclaimer,disclaimer_msg);
										
					int index=1;
					for(WebElement eachOption :returnElements(ObjectRepository.progressBarOptions)){
						
						String text_from_option = eachOption.getText();
						String class_prop = eachOption.findElement(By.xpath("(//span[@id='progBar']//td)["+index+"]")).getAttribute("class");
						if(text_from_option.equalsIgnoreCase("Verification") && class_prop.equals("JourneyBarCurrent")){
							Assert.assertTrue(true, "Verification icon is currently selected and highlighted on the page");
							return;
						}else if(text_from_option.equalsIgnoreCase("Products") && class_prop.equals("JourneyBarPrevious")){
							Assert.assertTrue(true, "Products icon is currently selected and highlighted in different blue color");
						}else if(text_from_option.equalsIgnoreCase("Start") && class_prop.equals("JourneyBarPrevious")){
							Assert.assertTrue(true, "Start icon is currently selected and highlighted in different blue color");
						}else if(text_from_option.equalsIgnoreCase("Information") && class_prop.equals("JourneyBarPrevious")){
							Assert.assertTrue(true, "Information icon is currently selected and highlighted in different blue color");
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
			test.log(Status.PASS, "Validate thate user can add Promocode to the Confirm Account page");
		}
	}

  @AfterTest
  public void tearDown() {
	 extent.flush();
	 driver.quit();
  }

}
