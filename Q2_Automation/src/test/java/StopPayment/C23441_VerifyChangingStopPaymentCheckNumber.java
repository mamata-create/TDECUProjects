package StopPayment;

import java.io.IOException;

import javax.mail.MessagingException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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

public class C23441_VerifyChangingStopPaymentCheckNumber  extends GenericKeywords {

	ExtentReports extent;
	ExtentTest test;
	/*
	 * Verify changing stop payment check number
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
				
				/*try{
				//click login button
				getElement(ObjectRepository.otpemail_btn).click();
				test.log(Status.INFO, "Send OTP to email button clicked");
				Thread.sleep(15000);
				
				getElement(ObjectRepository.otp_txt).sendKeys(fetchOutlookOTP());
				test.log(Status.INFO, "Login ID entered");
				
				
				getElement(ObjectRepository.submit_btn).click();
				test.log(Status.INFO, "Send OTP to email button clicked");
				Thread.sleep(7000);
				
				
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
	public void C23441_VerifyChangingStopPaymentCheckNumber() throws InterruptedException, MessagingException, IOException
	{
		
		if(continuetestcase==true)
		{
			sheetName = "StopPayment";
			int totalRowCount = excl.getRowCount(sheetName);
			for(startIter=1;startIter<=totalRowCount;startIter++) //It is mandatory to have this for loop in every test case
			 {	
				if(this.getClass().getSimpleName().equals(excl.getCellData(sheetName, 0, startIter)))
				 {
					String chknumber=excl.getCellData(sheetName, 5, startIter);	
					String endchknumber=excl.getCellData(sheetName, 6, startIter);
					
					//Click Services option
					getElement(ObjectRepository.service_menu).click();
					test.log(Status.INFO, "Service menu clicked");
					Thread.sleep(3000);
					
					getElement(ObjectRepository.stppaymnt_menu).click();
					test.log(Status.INFO, "Stop Payment menu clicked");
					Thread.sleep(3000);
				//Verify Stop Payment page title
					verifyElementPresent(ObjectRepository.stppaymnt_ttl);
					test.log(Status.INFO, "Stop Payment page opened and title available");
					
					String sendbtn_class=getElement(ObjectRepository.stppaymnt_sndrqst_btn).getAttribute("class");
					Assert.assertTrue(sendbtn_class.contains("disabled"));
					
					getElement(ObjectRepository.stppaymnt_snglchk).click();
					test.log(Status.INFO, "Single Check link clicked");
					Thread.sleep(3000);
					
					getElement(ObjectRepository.stppaymnt_acnt).click();
					test.log(Status.INFO, "Account selected");
					Thread.sleep(3000);
					
					for(int i=0;i<chknumber.length();i++){
						char chr=chknumber.charAt(i);
						getElement("//span[@class='integerInputButtonText' and text()='"+chr+"']").click();
					}
					
					Thread.sleep(3000);
									
					WebElement ele=getElement(ObjectRepository.stppaymnt_svbtn);
					JavascriptExecutor executor = (JavascriptExecutor)driver;
					executor.executeScript("arguments[0].click();", ele);
					test.log(Status.INFO, "Save button clicked");
					Thread.sleep(3000);
					
				//change the request type to multiple check
					getElement(ObjectRepository.stppaymnt_rqsttyp).click();
					test.log(Status.INFO, "Request type link clicked");
					Thread.sleep(3000);
					
					getElement(ObjectRepository.stppaymnt_mltchk).click();
					test.log(Status.INFO, "Multiple Check link clicked");
					Thread.sleep(3000);
					
					getElement(ObjectRepository.stppaymnt_acnt).click();
					test.log(Status.INFO, "Account selected");
					Thread.sleep(3000);
					
//					WebElement strtchknumber_parent=getElement("//span[text()='Starting Check Number' and @class='stepName']/parent::*/parent::*");
//					String txt=strtchknumber_parent.findElement(By.xpath("//div[@class='stepHeading']")).getText();
//					System.out.println("Text value ");
					
					for(int i=0;i<chknumber.length();i++){
						char chr=chknumber.charAt(i);
						getElement("//span[@class='integerInputButtonText' and text()='"+chr+"']").click();
					}
					test.log(Status.INFO, "Starting check number entered");
					Thread.sleep(3000);
									
					getElement(ObjectRepository.stppaymnt_svbtn).click();
					test.log(Status.INFO, "Save button clicked");
					Thread.sleep(3000);
					
					for(int i=0;i<endchknumber.length();i++){
						char chr=endchknumber.charAt(i);
						getElement("//span[@class='integerInputButtonText' and text()='"+chr+"']").click();
					}
					test.log(Status.INFO, "Ending check number entered");
					Thread.sleep(3000);
					
					
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
			test.log(Status.PASS, "Verify changing stop payment check number scenario working fine");
		}
	}

	@AfterTest
	public void tearDown() {
		extent.flush();
		driver.quit();
	}

}
