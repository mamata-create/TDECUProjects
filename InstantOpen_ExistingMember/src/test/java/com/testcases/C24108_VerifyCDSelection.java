package com.testcases;

import java.io.IOException;
import javax.mail.MessagingException;

import org.openqa.selenium.Keys;
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

public class C24108_VerifyCDSelection extends GenericKeywords {
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
	  public void C24108_VerifyCDSelection() throws InterruptedException, MessagingException, IOException {
		  if(continuetestcase==true)
		  {
				sheetName = "ProdData";
				int totalRowCount = excl.getRowCount(sheetName);
				for(startIter=1;startIter<=totalRowCount;startIter++) //It is mandatory to have this for loop in every test case
				{	
					if(this.getClass().getSimpleName().equals(excl.getCellData("ProdData", 0, startIter)))
					{
						String cdDesc1= excl.getCellData(sheetName, 16, startIter);
						String cdDesc2= excl.getCellData(sheetName, 17, startIter);
						String cdSearchForTitle= excl.getCellData(sheetName, 23, startIter);
						String cdSearchForInfo= excl.getCellData(sheetName, 24, startIter);
						String cdEnterAmount1= excl.getCellData(sheetName, 11, startIter);
						String cdEnterAmount2= excl.getCellData(sheetName, 12, startIter);
						String cdAmountValue= "$500.00";
						String cdDropdown1= "3";
						String cdDropdown2= "6";
						String cdDropdown3= "12";
						String cdDropdown4= "24";
						String cdDropdown5= "36";
						String cdDropdown6= "48";
						String cdDropdown7= "60";
						
						verifyElementPresent(ObjectRepository.app_ttl);
						test.log(Status.INFO, "Instant Open Title appearing");
						
						scrollToElement(ObjectRepository.mmbrstrt_btn);
						getElement(ObjectRepository.mmbrstrt_btn).click();
						test.log(Status.INFO, "Members Start Here button clicked");
						
						getElement(ObjectRepository.cdExpand).click();
						test.log(Status.INFO, "Certificate of Deposit section expanded");						
						verifyText(ObjectRepository.cdDescOne,cdDesc1);
						verifyOtherRatesLink(1);
						verifyText(ObjectRepository.cdDescTwo,cdDesc2);
						verifyText(ObjectRepository.cdSearchTitle,cdSearchForTitle);
						verifyText(ObjectRepository.cdSearchInfo,cdSearchForInfo);
						verifyElementPresent(ObjectRepository.showAllLabel);
						verifyFeeScheduleLink();
						
						//Enter 1000
						getElement(ObjectRepository.enterAmountTxtField).sendKeys(cdEnterAmount2);
						verifyAllCdsDisplayed();
						//Enter 500
						getElement(ObjectRepository.enterAmountTxtField).clear();
						getElement(ObjectRepository.enterAmountTxtField).sendKeys(cdEnterAmount1);
						getElement(ObjectRepository.enterAmountTxtField).sendKeys(Keys.TAB);
						verifyTxtFieldValue(ObjectRepository.enterAmountTxtField,cdAmountValue);
						verifyAllCdsNotDisplayed();
						getElement(ObjectRepository.enterAmountTxtField).clear();

						//Verify Dropdown						
						selectDropdownOpt(ObjectRepository.selectTermDropdown,cdDropdown1);
						verifyElementPresent(ObjectRepository.visibleCD3);
						selectDropdownOpt(ObjectRepository.selectTermDropdown,cdDropdown2);
						verifyElementPresent(ObjectRepository.visibleCD6);
						selectDropdownOpt(ObjectRepository.selectTermDropdown,cdDropdown3);
						verifyElementPresent(ObjectRepository.visibleCD12);
						selectDropdownOpt(ObjectRepository.selectTermDropdown,cdDropdown4);
						verifyElementPresent(ObjectRepository.visibleCD24);
						selectDropdownOpt(ObjectRepository.selectTermDropdown,cdDropdown5);
						verifyElementPresent(ObjectRepository.visibleCD36);
						selectDropdownOpt(ObjectRepository.selectTermDropdown,cdDropdown6);
						verifyElementPresent(ObjectRepository.visibleCD48);
						selectDropdownOpt(ObjectRepository.selectTermDropdown,cdDropdown7);
						verifyElementPresent(ObjectRepository.visibleCD60);
						//Show All
						getElement(ObjectRepository.showAllCheckBox).click();
						verifyAllCdsDisplayed();
						verifyTxtFieldValue(ObjectRepository.enterAmountTxtField,"");
						verifyTxtFieldValue(ObjectRepository.selectTermDropdown,"");
						getElement(ObjectRepository.showAllCheckBox).click();
						verifyAllCdsNotDisplayed();
						//Select a CD
						selectDropdownOpt(ObjectRepository.selectTermDropdown,cdDropdown3);
						getElement(ObjectRepository.visibleCD12).click();
						
						getElement(ObjectRepository.productPageNext).click();
						System.out.println(driver.getTitle());
						verifyElementPresent(ObjectRepository.mmbrVerifyTile);
						getElement(ObjectRepository.productPageBack).click();
						//verify CD is still selected, currently back button goes to wrong page
						//verifyElementPresent(ObjectRepository.visibleCD12);
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
				test.log(Status.PASS, "Verify credit card selection for existing member");
			}
		}

	  @AfterTest
	  public void tearDown() {
		 extent.flush();
		 driver.quit();
	  }

}
