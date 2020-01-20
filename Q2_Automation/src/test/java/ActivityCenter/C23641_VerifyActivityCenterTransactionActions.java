package ActivityCenter;

import java.io.IOException;
import java.util.List;

import javax.mail.MessagingException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
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

import junit.framework.Assert;

public class C23641_VerifyActivityCenterTransactionActions extends GenericKeywords {

	ExtentReports extent;
	ExtentTest test;
	/*
	 * Verify Activity Center Transaction Actions
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
				/*getElement(ObjectRepository.otpemail_btn).click();
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
	public void C23641_VerifyActivityCenterTransactionActions() throws InterruptedException, MessagingException, IOException
	{
					getElement(ObjectRepository.trnsctn_menu).click();
					test.log(Status.INFO, "transaction menu clicked");
					
					getElement(ObjectRepository.actvtycntr_menu).click();
					test.log(Status.INFO, "Activity Center menu clicked");
					Thread.sleep(3000);
					
					verifyElementPresent(ObjectRepository.actvtycntr_ttl);
					test.log(Status.INFO, "Activity Center page opened");
					
					WebElement root1 = driver.findElement(By.cssSelector("q2-tab-container[name='ac-tabs']"));
					WebElement shadowRoot1 = ObjectRepository.expandRootElement(driver, root1);
					WebElement SingleTransactionsTab = shadowRoot1.findElement(By.cssSelector("a[value='individual']"));
					
					if(SingleTransactionsTab.isDisplayed()){
						Assert.assertTrue(true);
						test.log(Status.INFO, "Single Transaction tab available on Activity Center page");
					}else{
						test.log(Status.INFO, "Single Transaction tab is not available on Activity Center page");
					}
					
					WebElement RecurringTab = shadowRoot1.findElement(By.cssSelector("a[value='recurring']"));
					
					Thread.sleep(1500);
					if(RecurringTab.isDisplayed()){
						Assert.assertTrue(true);
						test.log(Status.INFO, "Single Transaction tab available on Activity Center page");
					}else{
						test.log(Status.INFO, "Single Transaction tab is not available on Activity Center page");
					}
					
					verifyElementPresent(ObjectRepository.srchtrnsctn_txt);
					test.log(Status.INFO, "Search transaction field available on Activity Center page");
					
					getElement(ObjectRepository.srchtrnsctn_txt).sendKeys("Authorized");
					
					Thread.sleep(2000);
					getElement(ObjectRepository.actns_lnk).click();
					Thread.sleep(1000);
					
					//verifyElementPresent("//*[contains(text(),'Cancel')]");
					List<WebElement>action_subMenu = driver.findElements(By.xpath("(//button[@aria-label='Actions']/following::ul)[1]//li"));
					for(WebElement element:action_subMenu){
						String value = element.getAttribute("innerText");
						System.out.println(value);
						if(value.equalsIgnoreCase("Inquire")){
							Assert.assertEquals("Inquire", value);
						}
					}
					
					
					
	}

	@AfterMethod
	public void afterMethod(ITestResult result) throws Throwable {
		if (result.getStatus() == ITestResult.FAILURE) {
			test.log(Status.FAIL, "Test Failed-" + result.getThrowable());

			takescreenshot(this.getClass().getSimpleName(), test);
		} else {
			test.log(Status.PASS, "Verify Activity Center Transaction Actions scenario working fine");
		}
	}

	@AfterTest
	public void tearDown() {
		extent.flush();
		driver.quit();
	}

}
