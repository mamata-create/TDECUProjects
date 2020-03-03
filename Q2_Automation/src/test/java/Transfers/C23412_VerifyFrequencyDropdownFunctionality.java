package Transfers;

import java.io.IOException;
import java.util.List;

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

public class C23412_VerifyFrequencyDropdownFunctionality extends GenericKeywords {

	ExtentReports extent;
	ExtentTest test;
	/*
	 * Verify Frequency dropdown functionality
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
	public void C23412_VerifyFrequencyDropdownFunctionality() throws InterruptedException, MessagingException, IOException
	{
		if(continuetestcase==true)
		{
			sheetName = "Data";
			int totalRowCount = excl.getRowCount(sheetName);
			for(startIter=1;startIter<=totalRowCount;startIter++) //It is mandatory to have this for loop in every test case
			 {	
				if(this.getClass().getSimpleName().equals(excl.getCellData("Data", 0, startIter)))
				 {
					String frmacnts=excl.getCellData(sheetName, 1, startIter);
					String toacnt=excl.getCellData(sheetName, 2, startIter);
					String amnt=excl.getCellData(sheetName, 3, startIter);
					String frqncy=excl.getCellData(sheetName, 6, startIter);
					
					
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
						
						if(option.contains(frmacnts)){
							String frmAccountLocator = "//q2-select[@label='From Account']/q2-option[contains(@display,'"+frmacnts+"')]";
							getElement(frmAccountLocator).click();
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
					Thread.sleep(2000);
					
		//Amount  entered 			
					WebElement amountroot = driver.findElement(By.cssSelector("q2-input[test-id='fldAmount']"));
					WebElement amountshadowRoot = ObjectRepository.expandRootElement(driver,amountroot);
					WebElement amountField = amountshadowRoot.findElement(By.cssSelector("input[test-id='inputField']"));
					
					amountField.click();
					amountField.sendKeys(amnt);
				
					test.log(Status.INFO, "Amount entered");
				
			//	Verify frequency list
					WebElement frqncyroot = driver.findElement(By.cssSelector("q2-select[test-id='selFrequency']"));
					WebElement frqncyshadowRoot = ObjectRepository.expandRootElement(driver,frqncyroot);
					WebElement frqncyroot1 = frqncyshadowRoot.findElement(By.cssSelector("q2-input[label='Frequency']"));
					WebElement frqncyshadowRoot1 = ObjectRepository.expandRootElement(driver,frqncyroot1);
					
					WebElement frqncyDropDown = frqncyshadowRoot1.findElement(By.cssSelector("button[aria-label='One time transfer, Frequency']"));
					frqncyDropDown.click();
					
					String[] frqncyArr=frqncy.split(",");
					for(int i=0;i<frqncyArr.length;i++){
						String frqncyOpt=frqncyArr[i];
					List<WebElement> allFrqncyOptions = driver.findElements(By.xpath("//q2-select[@label='Frequency']/q2-option"));
					for(int count=1;count<=allFrqncyOptions.size();count++){
						String option= driver.findElement(By.xpath("(//q2-select[@label='Frequency']/q2-option)["+count+"]")).getAttribute("display");
						
						
						if(option.contains(frqncyOpt)){
							String frqncyLocator = "//q2-select[@label='Frequency']/q2-option[contains(@display,'"+frqncyOpt+"')]";
							getElement(frqncyLocator).click();
							
							System.out.println("Frequency option-"+frqncyOpt+" is availble inside the frequency dropdown");
							Assert.assertTrue(true);
							test.log(Status.INFO, "Frequency option-"+frqncyOpt+" is availble inside the frequency dropdown");
						}else{
							if(i+1==count){
								System.out.println("Frequency option-"+frqncyOpt+" is not availble inside the frequency dropdown");
								test.log(Status.INFO, "Frequency option-"+frqncyOpt+" is not availble inside the frequency dropdown");
								Assert.assertTrue(false);
							}
						}
						
						}
						
					}
					
				//Select frequency and verify
					
					
					
					
					
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
			test.log(Status.PASS, "Verify frequency dropodwn functionality scenario working fine");
		}
	}

	@AfterTest
	public void tearDown() {
		extent.flush();
		driver.quit();
	}

}
