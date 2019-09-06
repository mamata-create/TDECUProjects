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

public class C23626_VerifyActivityCenterAdvanceFilters extends GenericKeywords {

	ExtentReports extent;
	ExtentTest test;
	/*
	 * Verify Activity Center Advanced Filter
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
	public void C23626_VerifyActivityCenterAdvanceFilters() throws InterruptedException, MessagingException, IOException
	{			
					
					getElement(ObjectRepository.trnsctn_menu).click();
					test.log(Status.INFO, "transaction menu clicked");
					
					getElement(ObjectRepository.actvtycntr_menu).click();
					test.log(Status.INFO, "Activity Center menu clicked");
					Thread.sleep(3000);
					
					verifyElementPresent(ObjectRepository.actvtycntr_ttl);
					test.log(Status.INFO, "Activity Center page opened");
					
					verifyElementPresent(ObjectRepository.sngltrnsctn_tab);
					test.log(Status.INFO, "Single Transaction tab available on Activity Center page");
					
					verifyElementPresent(ObjectRepository.rcrngtrnsctn_tab);
					test.log(Status.INFO, "Recurring Transaction tab available on Activity Center page");
					
										
					getElement(ObjectRepository.fltr_lnk).click();
					test.log(Status.INFO, "Filter link clicked to see filter options");
					Thread.sleep(5000);
					
				//Search filter options
					//verifyElementPresent("//label[contains(text(),'Transaction Type')]");
					WebElement trnsctntyp_ele=getElement(ObjectRepository.trnsctntyp_parent).findElement(By.xpath(ObjectRepository.trnsctntyp_drop));
					Assert.assertTrue(trnsctntyp_ele.isDisplayed());
					test.log(Status.INFO, "Transaction type filter option available");
					
					WebElement stts_ele=getElement(ObjectRepository.stts_parent).findElement(By.xpath(ObjectRepository.trnsctntyp_drop));
					Assert.assertTrue(stts_ele.isDisplayed());
					test.log(Status.INFO, "Status filter option available");
				
					WebElement acnt_ele=getElement(ObjectRepository.acnt_parent).findElement(By.xpath(ObjectRepository.trnsctntyp_drop));
					Assert.assertTrue(acnt_ele.isDisplayed());
					test.log(Status.INFO, "Account filter option available");
					
					WebElement crtdby_ele=getElement(ObjectRepository.crtd_parent).findElement(By.xpath(ObjectRepository.trnsctntyp_drop));
					Assert.assertTrue(crtdby_ele.isDisplayed());
					test.log(Status.INFO, "Created By filter option available");
					
					WebElement amnt_ele=getElement(ObjectRepository.srchamnt_txt);
					Assert.assertTrue(amnt_ele.isDisplayed());
					test.log(Status.INFO, "Amount filter option available");
					Thread.sleep(2000);
					
					Select sel=new Select(trnsctntyp_ele);
					sel.selectByVisibleText("Funds Transfer");
					test.log(Status.INFO, "Transaction type selected");
					Thread.sleep(2000);
					
					getElement(ObjectRepository.resetfltr_btn).click();
					test.log(Status.INFO, "Reset filter button clicked");
					Thread.sleep(2000);
					
					sel.selectByVisibleText("Funds Transfer");
					test.log(Status.INFO, "Transaction type selected");
					Thread.sleep(2000);
					
					getElement(ObjectRepository.aplyfltr_btn).click();
					test.log(Status.INFO, "Apply filter button clicked");
					Thread.sleep(2000);
					
					
				
	}

	@AfterMethod
	public void afterMethod(ITestResult result) throws Throwable {
		if (result.getStatus() == ITestResult.FAILURE) {
			test.log(Status.FAIL, "Test Failed-" + result.getThrowable());

			takescreenshot(this.getClass().getSimpleName(), test);
		} else {
			test.log(Status.PASS, "Verify Activity Center Advance Filter scenario working fine");
		}
	}

	@AfterTest
	public void tearDown() {
		extent.flush();
		driver.quit();
	}

}
