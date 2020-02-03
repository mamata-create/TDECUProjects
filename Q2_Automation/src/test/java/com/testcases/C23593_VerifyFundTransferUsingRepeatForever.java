package com.testcases;

import java.io.IOException;
import java.util.List;

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

public class C23593_VerifyFundTransferUsingRepeatForever extends GenericKeywords {

	ExtentReports extent;
	ExtentTest test;
	/*
	 * Verify Fund Transfer using Repeat Forever
	 */

	@BeforeTest
	public void setUp() throws InterruptedException, MessagingException, IOException {
		extent = ExtentManager.GetExtent();
		test = extent.createTest(this.getClass().getSimpleName());
		BaseClass iDriver = new BaseClass();
		iDriver.myTestCaseName = this.getClass().getSimpleName();
		executeDriverScript();
		test.log(Status.INFO, "Application url navigated");
		//enter loginId
				getElement(ObjectRepository.loginid_txt).sendKeys(username);
				test.log(Status.INFO, "Login ID entered");
				
				//enter password
				getElement(ObjectRepository.password_txt).sendKeys(password);
				test.log(Status.INFO, "Password entered");
				
				//click login button
				getElement(ObjectRepository.login_btn).click();
				test.log(Status.INFO, "Login button clicked");
				
				//click login button
//				getElement(ObjectRepository.otpemail_btn).click();
//				test.log(Status.INFO, "Send OTP to email button clicked");
//				Thread.sleep(15000);
//				
//				getElement(ObjectRepository.otp_txt).sendKeys(fetchOutlookOTP());
//				test.log(Status.INFO, "Login ID entered");
//				
//				
//				getElement(ObjectRepository.submit_btn).click();
//				test.log(Status.INFO, "Send OTP to email button clicked");
//				Thread.sleep(7000);
//				
//				try{
//					if(getElement(ObjectRepository.register_btn).isDisplayed()){
//						getElement(ObjectRepository.register_btn).click();
//						test.log(Status.INFO, "Register device button clicked");
//						Thread.sleep(7000);
//					}
//					}catch(Exception e){
//						test.log(Status.INFO, "Register device button not available to be clicked");
//					}
				
				//Verify log off link available after login
				verifyElementPresent(ObjectRepository.logoff_lnk);
				test.log(Status.INFO, "User successfully logged in as Logoff link available");
		
	}

	@Test
	public void C23593_VerifyFundTransferUsingRepeatForever() throws InterruptedException, MessagingException, IOException
	{
		
		if(continuetestcase==true)
		{
			sheetName = "Data";
			int totalRowCount = excl.getRowCount(sheetName);
			for(startIter=1;startIter<=totalRowCount;startIter++) //It is mandatory to have this for loop in every test case
			 {	
				if(this.getClass().getSimpleName().equals(excl.getCellData("Data", 0, startIter)))
				 {
					String frmacnt=excl.getCellData(sheetName, 1, startIter);
					String toacnt=excl.getCellData(sheetName, 2, startIter);
					String amnt=excl.getCellData(sheetName, 3, startIter);
					String frqncy=excl.getCellData(sheetName, 6, startIter);
					String memo=excl.getCellData(sheetName, 4, startIter);
					
					getElement(ObjectRepository.trnsctn_menu).click();
					test.log(Status.INFO, "Transaction menu clicked");
					
					getElement(ObjectRepository.fndtrnsfr_menu).click();
					test.log(Status.INFO, "Fund Transfer menu clicked");
					
					verifyElementPresent(ObjectRepository.fndtrnsfr_ttl);
					test.log(Status.INFO, "Fund Transfer page opened");
					
					WebElement root1 = driver.findElement(By.cssSelector("div[test-id='selTransferFrom'] q2-select"));
					WebElement shadowRoot1 = ObjectRepository.expandRootElement(driver,root1);
					WebElement root2 = shadowRoot1.findElement(By.cssSelector("q2-input[label='From Account']"));
					WebElement shadowRoot2 = ObjectRepository.expandRootElement(driver,root2);
					
					WebElement fromAccounDropDown = shadowRoot2.findElement(By.cssSelector("button[aria-label=', From Account']"));
					fromAccounDropDown.click();
					List<WebElement> allOptions = driver.findElements(By.xpath("//q2-select[@label='From Account']/q2-option"));
					for(int count=1;count<=allOptions.size();count++){
						String option= driver.findElement(By.xpath("(//q2-select[@label='From Account']/q2-option)["+count+"]")).getAttribute("display");
						
						if(option.contains(frmacnt)){
							String fromAccountLocator = "//q2-select[@label='From Account']/q2-option[contains(@display,'"+frmacnt+"')]";
							getElement(fromAccountLocator).click();
						}
						
					}
					test.log(Status.INFO, "From Account selected");
					Thread.sleep(2000);
					
					WebElement root = driver.findElement(By.cssSelector("div[test-id='selTransferTo'] q2-select"));
					WebElement shadowRoot = ObjectRepository.expandRootElement(driver,root);
					WebElement root3 = shadowRoot.findElement(By.cssSelector("q2-input[label='To Account']"));
					WebElement shadowRoot3 = ObjectRepository.expandRootElement(driver,root3);
					
					WebElement toAccounDropDown = shadowRoot3.findElement(By.cssSelector("button[aria-label=', To Account']"));
					toAccounDropDown.click();
					
					
					List<WebElement> allToOptions = driver.findElements(By.xpath("//q2-select[@label='To Account']/q2-option"));
					for(int count=1;count<=allToOptions.size();count++){
						String option= driver.findElement(By.xpath("(//q2-select[@label='To Account']/q2-option)["+count+"]")).getAttribute("display");
						
						if(option.contains(toacnt)){
							String toAccountLocator = "//q2-select[@label='To Account']/q2-option[contains(@display,'"+toacnt+"')]";
							getElement(toAccountLocator).click();
						}
						
					}
		
					
					test.log(Status.INFO, "To Account selected");
					
					WebElement amountroot = driver.findElement(By.cssSelector("q2-input[test-id='fldAmount']"));
					WebElement amountshadowRoot = ObjectRepository.expandRootElement(driver,amountroot);
					WebElement amountField = amountshadowRoot.findElement(By.cssSelector("input[test-id='inputField']"));
					
					amountField.click();
					amountField.sendKeys(amnt);
					test.log(Status.INFO, "Amount entered");
					
					WebElement freqRoot1 = driver.findElement(By.cssSelector("q2-select[test-id='selFrequency']"));
					WebElement freqshadowRoot1 = ObjectRepository.expandRootElement(driver,freqRoot1);
					WebElement freqRoot2 = freqshadowRoot1.findElement(By.cssSelector("q2-input[label='Frequency']"));
					WebElement freqshadowRoot2 = ObjectRepository.expandRootElement(driver,freqRoot2);
					WebElement frequencyDropDown_OneTime = freqshadowRoot2.findElement(By.cssSelector("button[value='One time transfer']"));
					frequencyDropDown_OneTime.click();
					
					List<WebElement> frequencyValues = driver.findElements(By.xpath("//q2-select[@label='Frequency']/q2-option"));
					for(int count=1;count<=frequencyValues.size();count++){
						String option= driver.findElement(By.xpath("(//q2-select[@label='Frequency']/q2-option)["+count+"]")).getAttribute("display");
						
						if(option.contains(frqncy)){
							String frequency = "//q2-select[@label='Frequency']/q2-option[contains(@display,'"+frqncy+"')]";
							JavascriptExecutor js = ((JavascriptExecutor) driver);
							js.executeScript("arguments[0].scrollIntoView(true);",getElement(frequency));
							jsClick(frequency);
							//getElement(frequency).click();
						}
						
					}
					
					WebElement TransferstrtDateRoot = driver.findElement(By.cssSelector("q2-calendar[test-id='fldStartDate']"));
					WebElement strtDateshadowRoot = ObjectRepository.expandRootElement(driver,TransferstrtDateRoot);
					WebElement TransferstrtDateRoot2 = strtDateshadowRoot.findElement(By.cssSelector("q2-input[test-id='inputAndCalendarToggle']"));
					WebElement transferDateShadow2 = ObjectRepository.expandRootElement(driver,TransferstrtDateRoot2);
					WebElement TransferDate = transferDateShadow2.findElement(By.cssSelector("button[test-id='inputField']"));
					
					
					JavascriptExecutor js = ((JavascriptExecutor) driver);
					js.executeScript("arguments[0].scrollIntoView(true);",TransferDate);
					
					if(TransferDate.isDisplayed()){
						test.log(Status.INFO, "Start Date field appeared");
					}
					
					

					
					verifyElementPresent(ObjectRepository.dateRangeOption("Forever"));
					test.log(Status.INFO, "Forever option is selected");
					getElement(ObjectRepository.dateRangeOption("Forever")).click();
					
					
					
					
					WebElement Memoroot = driver.findElement(By.cssSelector("q2-input[test-id='fldMemo']"));
					WebElement MemoshadowRoot = ObjectRepository.expandRootElement(driver,Memoroot);
					WebElement MemoField = MemoshadowRoot.findElement(By.cssSelector("input[test-id='inputField']"));
					MemoField.sendKeys(memo);
					
					test.log(Status.INFO, "Memo entered");
					
					getElement(ObjectRepository.approve_button).click();
					test.log(Status.INFO, "Approve button clicked");
					
					verifyElementPresent(ObjectRepository.schdltrnsfrsccs_msg);
					test.log(Status.INFO, "Transfer success message appeared");
					
					
					getElement(ObjectRepository.modalFundTransferPopUpCloseBtn).click();
					test.log(Status.INFO, "Transfer success message disappeared");
					Thread.sleep(2500);
					

					
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
			test.log(Status.PASS, "Verify Fund Transfer using Repeat Forever scenario working fine");
		}
	}

	@AfterTest
	public void tearDown() {
		extent.flush();
		driver.quit();
	}

}
