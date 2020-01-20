package Transfers;

import java.io.IOException;
import java.util.List;

import javax.mail.MessagingException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
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

public class C23402_VerifyInSufficientFundTransferValidation extends GenericKeywords {

	ExtentReports extent;
	ExtentTest test;
	/*
	 * Verify InSufficient Fund Transfer Validation
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
//				
				
				//Verify log off link available after login
				verifyElementPresent(ObjectRepository.logoff_lnk);
				test.log(Status.INFO, "User successfully logged in as Logoff link available");
		
	}

	@Test
	public void C23402_VerifyInSufficientFundTransferValidation() throws InterruptedException, MessagingException, IOException
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
					
					
				//	selectDropdownOptContain(ObjectRepository.frmacnt_dropdown, frmacnt);
					test.log(Status.INFO, "From Account selected");
					Thread.sleep(2000);
					
//					WebElement frm=getElement(ObjectRepository.frmacnt_dropdown);					
//					Select slct=new Select(frm);
//					WebElement a=slct.getFirstSelectedOption();
//					System.out.println("FRMFIRS "+a.getText());
//					
//					String frmacnttxt=a.getText();
//					System.out.println("FRM ACCNT - "+frmacnttxt);
//					if(!frmacnttxt.contains("$")){
//						amnt="100";
//					}else{
//					String actfrmamnttxt=frmacnttxt.substring(frmacnttxt.lastIndexOf("$")+1, frmacnttxt.length()-1);
//					System.out.println("ACT AMNT- "+actfrmamnttxt);
//					if(actfrmamnttxt.contains(",")){
//						actfrmamnttxt=actfrmamnttxt.replace(",", "");
//					}
//					Double d=Double.parseDouble(actfrmamnttxt);
//					d=d+100;
//					amnt=Double.toString(d);
//					if(amnt.contains(".0")){
//						amnt=amnt+0;
//					}
//					}
					
					
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
					
					WebElement amountroot = driver.findElement(By.cssSelector("q2-input[test-id='fldAmount']"));
					WebElement amountshadowRoot = ObjectRepository.expandRootElement(driver,amountroot);
					WebElement amountField = amountshadowRoot.findElement(By.cssSelector("input[test-id='inputField']"));
					
					amountField.click();
					amountField.sendKeys(amnt);
					
				//	getElement(ObjectRepository.amnt_txt).sendKeys(amnt);
					test.log(Status.INFO, "Amount entered");
					
					Assert.assertTrue(getElement(ObjectRepository.trnsfrfnds_btn).isEnabled());
					test.log(Status.INFO, "Fund Transfer button enabled even when memo field blank");
					
					WebElement MemoRoot1 = driver.findElement(By.cssSelector("q2-input[label='Memo']"));
					WebElement shadowRootMemo1 = ObjectRepository.expandRootElement(driver, MemoRoot1);
					WebElement memoTxt = shadowRootMemo1.findElement(By.cssSelector("input[test-id='inputField']"));
					memoTxt.sendKeys("Transfer");
					memoTxt.sendKeys(Keys.TAB);
					
					getElement(ObjectRepository.trnsfrfnds_btn).click();
		
					Thread.sleep(4000);
					
					verifyElementPresent(ObjectRepository.fndtrnsfrerr);
					test.log(Status.INFO, "Fund Transfer error page opened");
					
					verifyElementPresent(ObjectRepository.fndtrnsfrerr_msg);
					test.log(Status.INFO, "Fund transfer failure message appeared");					
					
					
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
			test.log(Status.PASS, "Verify InSufficient Fund TRansfer Validation scenario working fine");
		}
	}

	@AfterTest
	public void tearDown() {
		extent.flush();
		driver.quit();
	}

}
