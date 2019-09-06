package Settings;

import java.io.IOException;

import javax.mail.MessagingException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
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

public class C23470_VerifyAccountNicknameUpdation extends GenericKeywords {

	ExtentReports extent;
	ExtentTest test;
	/*
	 * Verify Account Nickname Updation
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
	public void C23470_VerifyAccountNicknameUpdation() throws InterruptedException, MessagingException, IOException
	{
		
		if(continuetestcase==true)
		{
			sheetName = "Accounts";
			int totalRowCount = excl.getRowCount(sheetName);
			for(startIter=1;startIter<=totalRowCount;startIter++) //It is mandatory to have this for loop in every test case
			 {	
				if(this.getClass().getSimpleName().equals(excl.getCellData("Accounts", 0, startIter)))
				 {
					String acnt=excl.getCellData(sheetName, 1, startIter);
					String oldnick=excl.getCellData(sheetName, 2, startIter);
					String newnick=excl.getCellData(sheetName, 3, startIter);
					
					getElement(ObjectRepository.stng_menu).click();
					test.log(Status.INFO, "Settings menu clicked");
					
					getElement(ObjectRepository.acntprfrnc_menu).click();
					test.log(Status.INFO, "Account preferences menu clicked");
					Thread.sleep(3000);
					
					verifyElementPresent(ObjectRepository.prfrnc_ttl);
					test.log(Status.INFO, "Account preferences page opened");
					
					getElement("//span[@test-id='lblAccountPreferencesAccountNumber' and contains(text(),'"+acnt+"')]").click();
					test.log(Status.INFO, "Account number row clicked");
					
					
//					getElement(ObjectRepository.nickname_btn).click();
//					test.log(Status.INFO, "Nickname field clicked");
					
					getElement(ObjectRepository.nickname_edt).click();
					test.log(Status.INFO, "Nickname edit icon clicked");
					
					getElement(ObjectRepository.nickname_txt).sendKeys("abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyz");
					test.log(Status.INFO, "Nickname 52 chracters entered");
					
					getElement(ObjectRepository.nickname_txt).sendKeys(Keys.TAB);
					System.out.println("Length is - "+getElement(ObjectRepository.nickname_txt).getAttribute("value").length());
					Assert.assertTrue(getElement(ObjectRepository.nickname_txt).getAttribute("value").length()==50);
					test.log(Status.INFO, "Nickname max 50 characters allowed");
					
					getElement(ObjectRepository.nickname_cnclbtn).click();
					test.log(Status.INFO, "Nickname cancel button clicked");
					
					getElement(ObjectRepository.nickname_edt).click();
					test.log(Status.INFO, "Nickname edit icon clicked");
					Thread.sleep(3000);
					getElement(ObjectRepository.nickname_txt).clear();
					
					getElement(ObjectRepository.nickname_txt).sendKeys(newnick);
					test.log(Status.INFO, "New Nickname entered");
					
					getElement(ObjectRepository.nickname_svbtn).click();
					test.log(Status.INFO, "Nickname Save button clicked");
					Thread.sleep(3000);
					
			//Verify updated nickname on homepage		
					Thread.sleep(3000);
					getElement(ObjectRepository.home_menu).click();
					test.log(Status.INFO, "Home menu item clicked");
					Thread.sleep(3000);
					String acntfivedigit=acnt.substring(acnt.length()-5);
					
					WebElement ele=getElement("//span[@class='account-nbr' and contains(text(),'"+acntfivedigit+"')]/parent::*");
					String updatedNick=ele.findElement(By.xpath("//span[@class='account-label']")).getText();
					
					Assert.assertTrue(updatedNick.equals(newnick));
					test.log(Status.INFO, "Updated Nickname appearing correctly");
					
				//updated old nickname again
					getElement(ObjectRepository.stng_menu).click();
					test.log(Status.INFO, "Settings menu clicked");
					
					getElement(ObjectRepository.acntprfrnc_menu).click();
					test.log(Status.INFO, "Account preferences menu clicked");
					Thread.sleep(3000);
					
					verifyElementPresent(ObjectRepository.prfrnc_ttl);
					test.log(Status.INFO, "Account preferences page opened");
					
					getElement("//span[@test-id='lblAccountPreferencesAccountNumber' and contains(text(),'"+acnt+"')]").click();
					test.log(Status.INFO, "Account number row clicked");
					
					getElement(ObjectRepository.nickname_edt).click();
					test.log(Status.INFO, "Nickname edit icon clicked");
					Thread.sleep(3000);
					
					getElement(ObjectRepository.nickname_txt).clear();
					
					getElement(ObjectRepository.nickname_txt).sendKeys(oldnick);
					test.log(Status.INFO, "New Nickname entered");
					
					getElement(ObjectRepository.nickname_svbtn).click();
					test.log(Status.INFO, "Nickname Save button clicked");
					
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
			test.log(Status.PASS, "Verify Account Nickname Updation scenario working fine");
		}
	}

	@AfterTest
	public void tearDown() {
		extent.flush();
		driver.quit();
	}

}
