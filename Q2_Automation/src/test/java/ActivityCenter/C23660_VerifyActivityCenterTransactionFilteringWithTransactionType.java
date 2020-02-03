package ActivityCenter;

import java.io.IOException;

import javax.mail.MessagingException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
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

public class C23660_VerifyActivityCenterTransactionFilteringWithTransactionType extends GenericKeywords {

	ExtentReports extent;
	ExtentTest test;
	/*
	 * Verify Activity Center Transaction filtering with transaction type
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
					}
				*/
				//Verify log off link available after login
				verifyElementPresent(ObjectRepository.logoff_lnk);
				test.log(Status.INFO, "User successfully logged in as Logoff link available");
		
	}

	@Test
	public void C23660_VerifyActivityCenterTransactionFilteringWithTransactionType() throws InterruptedException, MessagingException, IOException
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
						test.log(Status.INFO, "Recurring Transaction tab available on Activity Center page");
					}else{
						test.log(Status.INFO, "Recurring Transaction tab is not available on Activity Center page");
					}
					
					
					
										
					getElement(ObjectRepository.fltr_lnk).click();
					test.log(Status.INFO, "Filter link clicked to see filter options");
					Thread.sleep(5000);
					
				//Search filter options
					WebElement trnsctntyp_ele=getElement(ObjectRepository.trnsctntyp_parent);
					Assert.assertTrue(trnsctntyp_ele.isDisplayed());
					test.log(Status.INFO, "Transaction type filter option available");
			//Fund transfer transactions searching		
					Select sel=new Select(trnsctntyp_ele);
					sel.selectByVisibleText("Funds Transfer");
					test.log(Status.INFO, "Transaction type as Funds Transfer selected");
					Thread.sleep(2000);
					
					getElement(ObjectRepository.prcssdt_chkbx).click();
					test.log(Status.INFO, "Process Date check box selected");
					
					getElement(ObjectRepository.aplyfltr_btn).click();
					test.log(Status.INFO, "Apply filter button clicked");
					Thread.sleep(4000);
					
					verifyElementPresent(ObjectRepository.prcssdt_col);
					test.log(Status.INFO, "Procces Date column appearing in grid");
					
					String val=getElement(ObjectRepository.actvty_trnsctntyp_col).getText();
					Assert.assertTrue(val.contains("Funds Transfer"));
					test.log(Status.INFO, "Fund transfer transactions filtered correctly");
					
					getElement(ObjectRepository.resetfltr_btn).click();
					test.log(Status.INFO, "Reset filter button clicked");
					Thread.sleep(4000);
			//Stop Payment transactions searching		
					sel.selectByVisibleText("Stop Payment");
					test.log(Status.INFO, "Transaction type as stop payment selected");
					Thread.sleep(3000);
					
					getElement(ObjectRepository.prcssdt_chkbx).click();
					test.log(Status.INFO, "Process Date check box selected");
					
					getElement(ObjectRepository.aplyfltr_btn).click();
					test.log(Status.INFO, "Apply filter button clicked");
					Thread.sleep(4000);
					
					verifyElementPresent(ObjectRepository.prcssdt_col);
					test.log(Status.INFO, "Process Date column appearing in grid");
					
					
					val=getElement(ObjectRepository.actvty_trnsctntyp_col).getText();
					Assert.assertTrue(val.contains("Stop Payment"));
					test.log(Status.INFO, "Stop Payment transactions filtered correctly");
					
					getElement(ObjectRepository.resetfltr_btn).click();
					test.log(Status.INFO, "Reset filter button clicked");
					Thread.sleep(4000);
					
			//Domestic wire transactions searching
					sel.selectByVisibleText("Domestic Wire");
					test.log(Status.INFO, "Transaction type as Domestic wire selected");
					Thread.sleep(2000);
					
					getElement(ObjectRepository.prcssdt_chkbx).click();
					test.log(Status.INFO, "Process Date check box selected");
					
					
					getElement(ObjectRepository.aplyfltr_btn).click();
					test.log(Status.INFO, "Apply filter button clicked");
					Thread.sleep(4000);
					
					verifyElementPresent(ObjectRepository.prcssdt_col);
					test.log(Status.INFO, "Process Date column appearing in grid");
					
					
					val=getElement(ObjectRepository.actvty_trnsctntyp_col).getText();
					Assert.assertTrue(val.contains("Domestic Wire"));
					test.log(Status.INFO, "Domestic Wire transactions filtered correctly");
					
					getElement(ObjectRepository.resetfltr_btn).click();
					test.log(Status.INFO, "Reset filter button clicked");
					Thread.sleep(4000);
				//External transactions searching	
					
					sel.selectByVisibleText("External Transfer");
					test.log(Status.INFO, "Transaction type as external transfer selected");
					Thread.sleep(2000);
					
					getElement(ObjectRepository.aplyfltr_btn).click();
					test.log(Status.INFO, "Apply filter button clicked");
					Thread.sleep(4000);
				
	}

	@AfterMethod
	public void afterMethod(ITestResult result) throws Throwable {
		if (result.getStatus() == ITestResult.FAILURE) {
			test.log(Status.FAIL, "Test Failed-" + result.getThrowable());

			takescreenshot(this.getClass().getSimpleName(), test);
		} else {
			test.log(Status.PASS, "Verify Activity Center Transaction filtering with transaction type scenario working fine");
		}
	}

	@AfterTest
	public void tearDown() {
		extent.flush();
		driver.quit();
	}

}
