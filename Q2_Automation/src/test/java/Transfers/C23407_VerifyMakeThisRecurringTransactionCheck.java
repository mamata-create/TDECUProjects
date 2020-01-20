package Transfers;

import java.io.IOException;
import java.util.List;

import javax.mail.MessagingException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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

public class C23407_VerifyMakeThisRecurringTransactionCheck extends GenericKeywords {

	ExtentReports extent;
	ExtentTest test;
	/*
	 * Verify make this recurring transaction check box
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
	public void C23407_VerifyMakeThisRecurringTransactionCheck() throws InterruptedException, MessagingException, IOException
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
					String amnt=randomAmount();
					String frqncy="Weekly";
					String memo=excl.getCellData(sheetName, 4, startIter);
					String dayOfWeek = "Sunday,Monday,Tuesday,Wednesday,Thursday,Friday,Saturday";
					getElement(ObjectRepository.trnsctn_menu).click();
					test.log(Status.INFO, "Transaction menu clicked");
					
					getElement(ObjectRepository.fndtrnsfr_menu).click();
					test.log(Status.INFO, "Fund Transfer menu clicked");
					
					verifyElementPresent(ObjectRepository.fndtrnsfr_ttl);
					test.log(Status.INFO, "Fund Transfer page opened");
					
					Thread.sleep(6500);
					/*
					 * Update: Locator updation of From account, To account and Ammount
					 */
					
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
					
					
					
				//	WebElement freqroot1 = driver.findElement(By.cssSelector("q2-select[test-id='selFrequency']"));
				//	WebElement freqShadowRoot1 = ObjectRepository
					
				//	verifyElementPresent(ObjectRepository.frqncy_dropdown);
				//	test.log(Status.INFO, "Frequency dropdown appeared");
				//	Thread.sleep(2000);
				//	scrollToElement(ObjectRepository.fndtrnsfr_ttl);
				//	Thread.sleep(2000);
//					String[] opts=frqncy.split(",");
//					for(int i=0;i<opts.length;i++){
//						Select s=new Select(getElement(ObjectRepository.frqncy_dropdown));
//						
//						List<WebElement> options = s.getOptions();
//
//						for(int j=0;j<options.size();j++){
//							System.out.println(options.get(j).getText());
//							if(options.get(j).getText().contains("Weekly")){
//								s.selectByVisibleText("Weekly");
//							}
//		
//							if(options.get(j).getText().contains(opts[i])){
//								Assert.assertTrue(true);
//								
//							}
//						}
//					}
					
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
					
					
					verifyElementPresent(ObjectRepository.dateRangeOption("Until"));
					test.log(Status.INFO, "Until date option is selected");
					scrollToElement(ObjectRepository.dateRangeOption("Until date"));
					getElement(ObjectRepository.dateRangeOption("Until date")).click();
					
					WebElement TransferEndDateRoot = driver.findElement(By.cssSelector("q2-calendar[test-id='fldEndDate']"));
					WebElement endDateshadowRoot = ObjectRepository.expandRootElement(driver,TransferEndDateRoot);
					WebElement TransferEndDateRoot2 = endDateshadowRoot.findElement(By.cssSelector("q2-input[test-id='inputAndCalendarToggle']"));
					WebElement transEndferDateShadow2 = ObjectRepository.expandRootElement(driver,TransferEndDateRoot2);
					WebElement TransferEndDate = transEndferDateShadow2.findElement(By.cssSelector("button[test-id='inputField']"));
					
					
					if(TransferEndDate.isDisplayed()){
						test.log(Status.INFO, "Start Date field appeared");
					}
					
					verifyElementPresent(ObjectRepository.dateRangeOption("Forever"));
					test.log(Status.INFO, "Forever option is selected");
					getElement(ObjectRepository.dateRangeOption("Forever")).click();
					
					try{
						if(TransferEndDate.isDisplayed()==false){
							test.log(Status.INFO, "Ended Date field disappeared");
						}
					}catch(Exception e){
						test.log(Status.INFO, "Ended Date field disappeared");
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
			test.log(Status.PASS, "Verify make this recurring transaction scenario working fine");
		}
	}

	@AfterTest
	public void tearDown() {
		extent.flush();
		driver.quit();
	}

}
