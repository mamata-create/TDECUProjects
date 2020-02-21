package Settings;

import java.io.IOException;

import javax.mail.MessagingException;

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

public class C24236_VerifyChangeAddressForTwoAccount extends GenericKeywords {

	ExtentReports extent;
	ExtentTest test;
	/*
	 * Address Change for Two Accounts
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
	public void C24236_VerifyChangeAddressForTwoAccount() throws InterruptedException, MessagingException, IOException
	{
		
		if(continuetestcase==true)
		{
			sheetName = "Data";
			int totalRowCount = excl.getRowCount(sheetName);
			for(startIter=1;startIter<=totalRowCount;startIter++) //It is mandatory to have this for loop in every test case
			 {	
				if(this.getClass().getSimpleName().equals(excl.getCellData("Data", 0, startIter)))
				 {
					String accountName1=excl.getCellData(sheetName, 9, startIter);
					String accountName2=excl.getCellData(sheetName, 10, startIter);
					String fieldName = excl.getCellData(sheetName, 11, startIter);
					String modifiedValue = excl.getCellData(sheetName, 12, startIter);
					getElement(ObjectRepository.stng_menu).click();
					test.log(Status.INFO, "Settings menu clicked");
					
					verifyElementPresent(ObjectRepository.addressChange_suboption);
					test.log(Status.INFO, "Address Change sub option should display under Settings menu list");
					
					getElement(ObjectRepository.addressChange_suboption).click();
					test.log(Status.INFO, "Address Change sub menu option clicked");
					
					verifyElementPresent(ObjectRepository.addressChange_header);
					test.log(Status.INFO, "Äddress Change page is displayed");
					
					verifyCheckBoxesOfMemberAccount();
					test.log(Status.INFO, "All checkboxes of Member account is verified");
					
					String accountNameSelector1 = "//div[@class='list-group']//preceding::label[contains(text(),'"+accountName1+"')]//../../div[1]";
					getElement(accountNameSelector1).click();
					String accountNameSelector2 = "//div[@class='list-group']//preceding::label[contains(text(),'"+accountName2+"')]//../../div[1]";
					getElement(accountNameSelector2).click();
					Thread.sleep(2000);
					
					String accountNameSelectorAttribute_First = "//label[contains(text(),'"+accountName1+"')]/preceding::div[1]";
					String accountNameSelectorAttribute_Second = "//label[contains(text(),'"+accountName2+"')]/preceding::div[1]";
					String getaccountNameSelectorAttribute_first = getElement(accountNameSelectorAttribute_First).getAttribute("class");
					String getaccountNameSelectorAttribute_second = getElement(accountNameSelectorAttribute_Second).getAttribute("class");
					
					//getElement(accountNameSelectorAttribute_First).click();
				//	getElement(accountNameSelectorAttribute_Second).click();
					Thread.sleep(2000);
					
					if(getaccountNameSelectorAttribute_first.contains("checked") && getaccountNameSelectorAttribute_second.contains("checked")){
						test.log(Status.INFO, "Cehckbox against address is checked");
						Assert.assertTrue(true);
					}else{
						Assert.assertTrue(false);
					}
					
					String WorkPhoneLocator = "//input[@placeholder='"+fieldName.split(";")[0]+"']";
					getElement(WorkPhoneLocator).click();
					getElement(WorkPhoneLocator).clear();
					getElement(WorkPhoneLocator).sendKeys(modifiedValue);
					test.log(Status.INFO, "New Value entered in the filed");
					
					String HomePhoneLocator = "//input[@placeholder='"+fieldName.split(";")[1]+"']";
					getElement(HomePhoneLocator).click();
					getElement(HomePhoneLocator).clear();
					getElement(HomePhoneLocator).sendKeys(modifiedValue);
					
					if(getElement(ObjectRepository.addressChangeSubmit).isEnabled()){
					getElement(ObjectRepository.addressChangeSubmit).click();
					test.log(Status.INFO, "Submit button clicked");
					}
					
					//Steps to be added 
					
					verifyElementPresent(ObjectRepository.modalTitle);
					Thread.sleep(1500);
					getElement(ObjectRepository.closeButton).click();
					driver.navigate().refresh();
					//Call steps again
					
					getElement(ObjectRepository.stng_menu).click();
					test.log(Status.INFO, "Settings menu clicked");
					
					verifyElementPresent(ObjectRepository.addressChange_suboption);
					test.log(Status.INFO, "Address Change sub option should display under Settings menu list");
					
					getElement(ObjectRepository.addressChange_suboption).click();
					test.log(Status.INFO, "Address Change sub menu option clicked");
					
					verifyElementPresent(ObjectRepository.addressChange_header);
					test.log(Status.INFO, "Äddress Change page is displayed");
					
					verifyCheckBoxesOfMemberAccount();
					test.log(Status.INFO, "All checkboxes of Member account is verified");
					
					accountNameSelector1 = "//div[@class='list-group']//preceding::label[contains(text(),'"+accountName1+"')]//../../div[1]";
					getElement(accountNameSelector1).click();
					accountNameSelector2 = "//div[@class='list-group']//preceding::label[contains(text(),'"+accountName2+"')]//../../div[1]";
					getElement(accountNameSelector2).click();
					Thread.sleep(2000);
					
					accountNameSelectorAttribute_First = "//label[contains(text(),'"+accountName1+"')]/preceding::div[1]";
					accountNameSelectorAttribute_Second = "//label[contains(text(),'"+accountName2+"')]/preceding::div[1]";
					getaccountNameSelectorAttribute_first = getElement(accountNameSelectorAttribute_First).getAttribute("class");
					getaccountNameSelectorAttribute_second = getElement(accountNameSelectorAttribute_Second).getAttribute("class");
					
					//getElement(accountNameSelectorAttribute_First).click();
				//	getElement(accountNameSelectorAttribute_Second).click();
					Thread.sleep(2000);
					
					if(getaccountNameSelectorAttribute_first.contains("checked") && getaccountNameSelectorAttribute_second.contains("checked")){
						test.log(Status.INFO, "Cehckbox against address is checked");
						Assert.assertTrue(true);
					}else{
						Assert.assertTrue(false);
					}
					
				//	String WorkPhoneLocator = "//input[@placeholder='"+fieldName.split(";")[0]+"']";
					getElement(WorkPhoneLocator).click();
					getElement(WorkPhoneLocator).clear();
					getElement(WorkPhoneLocator).sendKeys(modifiedValue);
					test.log(Status.INFO, "New Value entered in the filed");
					
				//	String HomePhoneLocator = "//input[@placeholder='"+fieldName.split(";")[1]+"']";
					getElement(HomePhoneLocator).click();
					getElement(HomePhoneLocator).clear();
					getElement(HomePhoneLocator).sendKeys(modifiedValue);
					
					if(getElement(ObjectRepository.addressChangeSubmit).isEnabled()){
					getElement(ObjectRepository.addressChangeSubmit).click();
					test.log(Status.INFO, "Submit button clicked");
					}
					
					//Adding steps to click on View In Activity Center

					
					verifyElementPresent(ObjectRepository.modalTitle);
					
					getElement(ObjectRepository.viewInActivityButton).click();
					Thread.sleep(3000);
					verifyElementPresent(ObjectRepository.recordOfTable);
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
			test.log(Status.PASS, "Address change for Two Accounts working Fine");
		}
	}

	@AfterTest
	public void tearDown() {
		extent.flush();
		driver.quit();
	}

}
