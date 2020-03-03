package Transfers;

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

public class C23404_VerifyFundTransferAboveBalanceAvailable extends GenericKeywords {

	ExtentReports extent;
	ExtentTest test;
	/*
	 * Verify Fund Transfer above balance available
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
				
				//Verify log off link available after login
				verifyElementPresent(ObjectRepository.logoff_lnk);
				test.log(Status.INFO, "User successfully logged in as Logoff link available");
		
	}

	@Test
	public void C23404_VerifyFundTransferAboveBalanceAvailable() throws InterruptedException, MessagingException, IOException
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
					String amnt="3000.00";
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
		//Amount not entered 			
					WebElement amountroot = driver.findElement(By.cssSelector("q2-input[test-id='fldAmount']"));
					WebElement amountshadowRoot = ObjectRepository.expandRootElement(driver,amountroot);
					WebElement amountField = amountshadowRoot.findElement(By.cssSelector("input[test-id='inputField']"));
					
					//amountField.click();
					//amountField.sendKeys(amnt);
				
					test.log(Status.INFO, "Amount not entered");
					
					Assert.assertTrue(getElement(ObjectRepository.trnsfrfnds_btn).isEnabled());
					test.log(Status.INFO, "Fund Transfer button enabled even when memo field blank");
					
					WebElement MemoRoot1 = driver.findElement(By.cssSelector("q2-input[label='Memo']"));
					WebElement shadowRootMemo1 = ObjectRepository.expandRootElement(driver, MemoRoot1);
					WebElement memoTxt = shadowRootMemo1.findElement(By.cssSelector("input[test-id='inputField']"));
					memoTxt.sendKeys("Transfer");
					memoTxt.sendKeys(Keys.TAB);
					
					getElement(ObjectRepository.trnsfrfnds_btn).click();
					test.log(Status.INFO, "Transfer Funds button clicked");
					Thread.sleep(4000);
					
					verifyElementPresent(ObjectRepository.amnt_errmsg);
					test.log(Status.INFO, "Fund Transfer error message appeared for not providing amount greater than 0.00");
					
		// Amount greater than available balance
					String amnt_txt=getShadowElement(ObjectRepository.frmacnt_drop).getAttribute("value");
					amnt_txt=amnt_txt.substring(amnt_txt.length()-6, amnt_txt.length()-1);
					double frm_amnt=Double.valueOf(amnt_txt);
					frm_amnt=frm_amnt+10;
			
					JavascriptExecutor js = ((JavascriptExecutor) driver);
					js.executeScript("window.scrollBy(0,-250)");
					
					getShadowElement(ObjectRepository.fndamnt_txt).click();
					getShadowElement(ObjectRepository.fndamnt_txt).sendKeys(Double.toString(frm_amnt)+"0");
					
					getElement(ObjectRepository.trnsfrfnds_btn).click();
					test.log(Status.INFO, "Transfer Funds button clicked");
					Thread.sleep(4000);
					
					verifyElementPresent(ObjectRepository.insfcnt_fndmsg);
					test.log(Status.INFO, "Insufficient fund validation message appeared");
					
					getElement(ObjectRepository.alrt_clsbtn).click();
					test.log(Status.INFO, "Insufficient fund popup close button clicked");
					Thread.sleep(4000);
					
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
			test.log(Status.PASS, "Verify Fund Transfer above balance available scenario working fine");
		}
	}

	@AfterTest
	public void tearDown() {
		extent.flush();
		driver.quit();
	}

}
