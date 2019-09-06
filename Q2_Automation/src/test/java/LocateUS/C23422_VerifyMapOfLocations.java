package LocateUS;

import static org.testng.Assert.assertTrue;

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

public class C23422_VerifyMapOfLocations extends GenericKeywords {

	ExtentReports extent;
	ExtentTest test;
	/*
	 * Verify map of locations
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
	public void C23422_VerifyMapOfLocations() throws InterruptedException, MessagingException, IOException
	{
		
		if(continuetestcase==true)
		{
			sheetName = "Location";
			int totalRowCount = excl.getRowCount(sheetName);
			for(startIter=1;startIter<=totalRowCount;startIter++) //It is mandatory to have this for loop in every test case
			 {	
				if(this.getClass().getSimpleName().equals(excl.getCellData("Location", 0, startIter)))
				 {
					String locname=excl.getCellData(sheetName, 1, startIter);
					String locaddress=excl.getCellData(sheetName, 2, startIter);
					String atmname=excl.getCellData(sheetName, 3, startIter);
					String atmaddress=excl.getCellData(sheetName, 4, startIter);
					
					
					getElement(ObjectRepository.loc_menu).click();
					test.log(Status.INFO, "Locations menu clicked");
										
					verifyElementPresent(ObjectRepository.locpg_ttl);
					test.log(Status.INFO, "Locations page opened");
					Thread.sleep(2000);
					
					verifyElementPresent("//div[@test-id='txtBranchesLocationName' and contains(text(),'"+locname+"')]");
					test.log(Status.INFO, "Locations name appearing correctly");
					Thread.sleep(2000);
					WebElement ele=getElement("//div[@test-id='txtBranchesLocationName' and contains(text(),'"+locname+"')]/parent::*");
					String actlocaddress=ele.findElement(By.xpath("//div[@test-id='txtBranchesLocationAddress']")).getText();
					
					Assert.assertTrue(actlocaddress.equals(locaddress));
					test.log(Status.INFO, "Locations name & address appearing correctly");
					
					getElement(ObjectRepository.atm_tab).click();
					test.log(Status.INFO, "ATM tab clicked");
					
					Thread.sleep(2000);
					
					verifyElementPresent("//div[@test-id='txtBranchesLocationName' and contains(text(),'"+atmname+"')]");
					test.log(Status.INFO, "Locations name appearing correctly");
					Thread.sleep(2000);
					WebElement atmele=getElement("//div[@test-id='txtBranchesLocationName' and contains(text(),'"+atmname+"')]/parent::*");
					String actatmaddress=atmele.findElement(By.xpath("//div[@test-id='txtBranchesLocationAddress']")).getText();
					
					Assert.assertTrue(actatmaddress.equals(atmaddress));
					test.log(Status.INFO, "ATM name & address appearing correctly");
					
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
			test.log(Status.PASS, "Verify map of locations scenario working fine");
		}
	}

	@AfterTest
	public void tearDown() {
		extent.flush();
		driver.quit();
	}

}
