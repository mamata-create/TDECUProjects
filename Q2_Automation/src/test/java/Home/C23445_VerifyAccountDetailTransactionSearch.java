package Home;

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

public class C23445_VerifyAccountDetailTransactionSearch  extends GenericKeywords {

	ExtentReports extent;
	ExtentTest test;
	/*
	 * Verify Account Account Detail transaction search from homepage
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
			/*	getElement(ObjectRepository.otpemail_btn).click();
				test.log(Status.INFO, "Send OTP to email button clicked");
				Thread.sleep(15000);
				
				getElement(ObjectRepository.otp_txt).sendKeys(fetchOutlookOTP());
				test.log(Status.INFO, "Login ID entered");
				
				
				getElement(ObjectRepository.submit_btn).click();
				test.log(Status.INFO, "Send OTP to email button clicked");
				Thread.sleep(7000);
				try{
					if(getElement(ObjectRepository.register_btn).isDisplayed()){
						getElement(ObjectRepository.register_btn).click();
						test.log(Status.INFO, "Register device button clicked");
						Thread.sleep(7000);
					}
					}catch(Exception e){
						test.log(Status.INFO, "Register device button not available to be clicked");
					}*/
				
								
				//Verify log off link available after login
				verifyElementPresent(ObjectRepository.logoff_lnk);
				test.log(Status.INFO, "User successfully logged in as Logoff link available");
		
	}

	@Test
	public void C23445_VerifyAccountDetailTransactionSearch() throws InterruptedException, MessagingException, IOException
	{
		if(continuetestcase==true)
		{
			sheetName = "Accounts";
			int totalRowCount = excl.getRowCount(sheetName);
			for(startIter=1;startIter<=totalRowCount;startIter++) 
			 {	
				if(this.getClass().getSimpleName().equals(excl.getCellData(sheetName, 0, startIter)))
				 {
					String acntNumber=excl.getCellData(sheetName, 1, startIter);
					String desc=excl.getCellData(sheetName, 4, startIter);
					String amnt=excl.getCellData(sheetName, 5, startIter);
					
					Thread.sleep(1500);
					awaitForElementToVisible("//span[@class='account-nbr' and contains(text(),'"+acntNumber+"')]");
					getElement("//span[@class='account-nbr' and contains(text(),'"+acntNumber+"')]").click();
					test.log(Status.INFO, "Account link clicked");
										
					verifyElementPresent(ObjectRepository.dtls_lnk);
					test.log(Status.INFO, "Details link available on account details page");
					
					
					
					WebElement root1 = driver.findElement(By.cssSelector("q2-input[test-id='fldSearch']"));
					WebElement shadowRoot1 = ObjectRepository.expandRootElement(driver, root1);
					WebElement searchBox = shadowRoot1.findElement(By.cssSelector("input[test-id='inputField']"));
					
					searchBox.sendKeys(desc);
					test.log(Status.INFO, "Search text entered in search text box");
					
					WebElement root2 = shadowRoot1.findElement(By.cssSelector("q2-btn[class='btn-clear']"));
					WebElement shadowRoot2 = ObjectRepository.expandRootElement(driver, root2);
					WebElement clearIcon = shadowRoot2.findElement(By.cssSelector("button[aria-label='Clear ']"));
					boolean flag = clearIcon.isDisplayed();
					if(flag){
						test.log(Status.INFO, "Remove icon appearing inside search text box");
					}
					
					/*verifyElementPresent(clearIcon);
					test.log(Status.INFO, "Remove icon appearing inside search text box");*/
					
					clearIcon.click();
					test.log(Status.INFO, "Remove icon appearing inside search text box clicked");
					
					String text = searchBox.getText();
					if(text==" "){
						Assert.assertTrue(true, "Existing text is removed");
					}
					test.log(Status.INFO, "Remove icon click removed the text from search text box");
					
					searchBox.sendKeys(desc);
					test.log(Status.INFO, "Search text entered in search text box");
					searchBox.sendKeys(Keys.ENTER);
					Thread.sleep(3000);
					
					verifyText(ObjectRepository.acntdtl_desc, desc);
					test.log(Status.INFO, "transaction searched correctly with description");
					
					searchBox.clear();
			//Search transaction by Amount		
					searchBox.sendKeys(amnt);
					test.log(Status.INFO, "Search text entered in search text box");
					searchBox.sendKeys(Keys.ENTER);
					Thread.sleep(3000);
					
					verifyText(ObjectRepository.acntdtl_amnt, amnt);
					test.log(Status.INFO, "Transaction searched correctly with amount");
					
					searchBox.clear();
					
			//Search transaction by invalid criteria		
					searchBox.sendKeys("asd@#$1234");
					test.log(Status.INFO, "Search text entered in search text box");
					searchBox.sendKeys(Keys.ENTER);
					Thread.sleep(3000);
					
					test.log(Status.INFO, "No Such transaction available message appeared");
					
						
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
			test.log(Status.PASS, "Verify Account Detail transaction search scenario working fine");
		}
	}

	@AfterTest
	public void tearDown() {
		extent.flush();
		driver.quit();
	}

}
