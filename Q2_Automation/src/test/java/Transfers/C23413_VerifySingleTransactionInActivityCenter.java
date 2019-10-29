package Transfers;

import java.io.IOException;

import javax.mail.MessagingException;

import org.openqa.selenium.By;
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

public class C23413_VerifySingleTransactionInActivityCenter extends GenericKeywords {

	ExtentReports extent;
	ExtentTest test;
	/*
	 * Verify Single Transaction in Activity Center
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
				
//				//click login button
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
	public void C23413_VerifySingleTransactionInActivityCenter() throws InterruptedException, MessagingException, IOException
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
					String memo=excl.getCellData(sheetName, 4, startIter);
					
					getElement(ObjectRepository.trnsctn_menu).click();
					test.log(Status.INFO, "Transaction menu clicked");
					
					getElement(ObjectRepository.fndtrnsfr_menu).click();
					test.log(Status.INFO, "Fund Transfer menu clicked");
					
				    verifyElementPresent(ObjectRepository.fndtrnsfr_ttl);
					test.log(Status.INFO, "Fund Transfer page opened");
					
					Assert.assertFalse(!getElement(ObjectRepository.trnsfrfnds_btn).isEnabled());
					test.log(Status.INFO, "Transfer Funds button disabled");
					
					WebElement root1 = driver.findElement(By.cssSelector("div[test-id='selTransferFrom'] q2-select"));
					WebElement shadowRoot1 = ObjectRepository.expandRootElement(driver,root1);
					WebElement root2 = shadowRoot1.findElement(By.cssSelector("q2-input[label='From Account']"));
					WebElement shadowRoot2 = ObjectRepository.expandRootElement(driver,root2);
					
					WebElement fromAccounDropDown = shadowRoot2.findElement(By.cssSelector("button[aria-label=', From Account']"));
					fromAccounDropDown.click();
					Thread.sleep(1500);
					selectDropdownOptForShadowRoot(fromAccounDropDown,frmacnt,"From Account");
					
					test.log(Status.INFO, "From Account selected");
		
					WebElement root = driver.findElement(By.cssSelector("div[test-id='selTransferTo'] q2-select"));
					WebElement shadowRoot = ObjectRepository.expandRootElement(driver,root);
					WebElement root3 = shadowRoot.findElement(By.cssSelector("q2-input[label='To Account']"));
					WebElement shadowRoot3 = ObjectRepository.expandRootElement(driver,root3);
					
					WebElement toAccounDropDown = shadowRoot3.findElement(By.cssSelector("button[aria-label=', To Account']"));
					toAccounDropDown.click();
					Thread.sleep(1500);
					selectDropdownOptForShadowRoot(toAccounDropDown,toacnt,"To Account");
					
				
					test.log(Status.INFO, "To Account selected");
					
					WebElement amountroot = driver.findElement(By.cssSelector("q2-input[test-id='fldAmount']"));
					WebElement amountshadowRoot = ObjectRepository.expandRootElement(driver,amountroot);
					WebElement amountField = amountshadowRoot.findElement(By.cssSelector("input[test-id='inputField']"));
					amountField.sendKeys(amnt);
					
					
					test.log(Status.INFO, "Amount entered");
					
					WebElement Memoroot = driver.findElement(By.cssSelector("q2-input[test-id='fldMemo']"));
					WebElement MemoshadowRoot = ObjectRepository.expandRootElement(driver,Memoroot);
					WebElement MemoField = MemoshadowRoot.findElement(By.cssSelector("input[test-id='inputField']"));
					MemoField.sendKeys(memo);
					
					test.log(Status.INFO, "Memo entered");
				
					
					getElement(ObjectRepository.trnsfrfnds_btn).click();
					test.log(Status.INFO, "Transfer Funds button clicked");
					
					verifyElementPresent(ObjectRepository.trnsfrsccs_msg);
					test.log(Status.INFO, "Transfer success message appeared");
					
					
					getElement(ObjectRepository.modalFundTransferPopUpCloseBtn).click();
					test.log(Status.INFO, "Transfer success message disappeared");
					
					scrollToElement(ObjectRepository.vwactvtycntr_btn);
					getElement(ObjectRepository.vwactvtycntr_btn).click();
					test.log(Status.INFO, "View Activity Center button clicked from transfer success page");
					
					verifyElementPresent(ObjectRepository.actvtycntr_ttl);
					test.log(Status.INFO, "Activity Center page opened");
					
					
					WebElement singleAccountRoot = driver.findElement(By.cssSelector("q2-tab-container[name='ac-tabs']"));
					WebElement singleAccountShadowRoot = ObjectRepository.expandRootElement(driver,singleAccountRoot);
					WebElement singleAccount = singleAccountShadowRoot.findElement(By.cssSelector("a[value='individual']"));
					
					
					//WebElement ele=getElement("//span[text()='Single Transactions']/parent::*/parent::*");
					
					String sngltrnsctn=singleAccount.getAttribute("aria-selected");
					if(sngltrnsctn.contains("true")){
						Assert.assertTrue(true);
						test.log(Status.INFO, "Single Transaction tab is selected");
					}else{
						test.log(Status.INFO, "Single Transaction tab is not selected");
					}
					
					
					verifyText(ObjectRepository.actvtycntr_amnt, amnt);
					test.log(Status.INFO, "Transfer amount appearing correctly in first selected row");
					getElement(ObjectRepository.actvtycntr_amnt).click();
					
					String transactionDetails = getElement("//*[contains(@class,'selected-detail  transaction-detail')]").getAttribute("class");
					if(transactionDetails.contains("selected-detail")){
						Assert.assertTrue(true);
						test.log(Status.INFO, "Transaction details section  is opened");
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
			test.log(Status.PASS, "Verify Single Transaction in Activity Center scenario working fine");
		}
	}

	@AfterTest
	public void tearDown() {
		extent.flush();
		driver.quit();
	}

}
