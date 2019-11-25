package Services;

import java.io.IOException;

import javax.mail.MessagingException;

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

public class C23654_VerifyWireTransferRecipientCreation   extends GenericKeywords {

	ExtentReports extent;
	ExtentTest test;
	
	@BeforeTest
	public void setUp() throws InterruptedException, MessagingException, IOException{
		extent=ExtentManager.GetExtent();
		test=extent.createTest(this.getClass().getSimpleName());
		BaseClass iDriver = new BaseClass();
	    iDriver.myTestCaseName = this.getClass().getSimpleName();
		startAppium();
		executeMobileDriver();
		test.log(Status.INFO, " Q2 Mobile application launched");
		getElement(ObjectRepository.username_txt).sendKeys(username);
		getElement(ObjectRepository.password_txt).sendKeys(password);
		getElement(ObjectRepository.login_btn).click();
		test.log(Status.INFO, "Login button clicked after entering username and password");
			
		
	}
	

	@Test
	public void C23654_VerifyWireTransferRecipientCreation() throws InterruptedException
	{
		if(continuetestcase==true)
		{
			sheetName = "WireTransfer";
			int totalRowCount = excl.getRowCount(sheetName);
			for(startIter=1;startIter<=totalRowCount;startIter++) //It is mandatory to have this for loop in every test case
			 {	
				if(this.getClass().getSimpleName().equals(excl.getCellData(sheetName, 0, startIter)))
				 {
					
					String rndomnumber=getRandom();
					String displayname="Aut"+rndomnumber;
					String wirename="Wire"+rndomnumber;
					String acntno=excl.getCellData(sheetName, 1, startIter);
					String rtngno=excl.getCellData(sheetName, 2, startIter);
					String bank=excl.getCellData(sheetName, 3, startIter);
					String addrs1=excl.getCellData(sheetName, 4, startIter);
					String city=excl.getCellData(sheetName, 5, startIter);
					String state=excl.getCellData(sheetName, 6, startIter);
					String zip=excl.getCellData(sheetName, 7, startIter);
					String abanumber=excl.getCellData(sheetName, 8, startIter);
		
		Thread.sleep(30000);
	//Verify menu item option
		verifyElementPresent(ObjectRepository.menu_btn);
		test.log(Status.INFO, "Menu link appearing");
	
		getElement(ObjectRepository.menu_btn).click();
		test.log(Status.INFO, "Menu link clicked");
		Thread.sleep(4000);	
			
		getElement(ObjectRepository.service_menu).click();
		test.log(Status.INFO, "Services menu clicked");
		Thread.sleep(2000);
		
		getElement(ObjectRepository.wiretrnsfr_menu).click();
		test.log(Status.INFO, "Wire Transfer Menu link clicked");
		Thread.sleep(2000);
		
		verifyElementPresent(ObjectRepository.wiretrnsfr_ttl);
		test.log(Status.INFO, "Wire Transfer page opened");
		
		getElement(ObjectRepository.rcpnt_srchtxt).click();
		test.log(Status.INFO, "Clicked inside Search Recipient text box");
		Thread.sleep(2000);
		
		getElement(ObjectRepository.newrcpnt_btn).click();
		test.log(Status.INFO, "New Recipient button clicked");
		Thread.sleep(2000);
		
		verifyElementPresent(ObjectRepository.dsplyname_txt);
		//verifyElementPresent(ObjectRepository.wirename_txt);
		verifyElementPresent(ObjectRepository.emailadrs_txt);
//		verifyElementPresent(ObjectRepository.cntry_dropdown);
//		verifyElementPresent(ObjectRepository.city_txt);
//		verifyElementPresent(ObjectRepository.state_dropdown);
//		verifyElementPresent(ObjectRepository.zip_txt);
		test.log(Status.INFO, "Display Name, wire name,email address, country , state, city and zip fields appearing");

		getElement(ObjectRepository.dsplyname_txt).sendKeys(displayname);
		test.log(Status.INFO, "Display Name entered");
		Thread.sleep(2000);
		getElement(ObjectRepository.emailadrs_txt).sendKeys("sravy.vagalaboina@eaglecrk.com");
		test.log(Status.INFO, "Email entered");
		Thread.sleep(2000);	
		
		
/*
 * Bank Information		
 */
		getElement(ObjectRepository.acnt_txt).sendKeys(acntno);
		test.log(Status.INFO, "Account number entered");
		Thread.sleep(2000);
		
		getElement(ObjectRepository.bankname_txt).sendKeys(bank);
		test.log(Status.INFO, "Bank Name entered");
		Thread.sleep(2000);
		
		getElement(ObjectRepository.ABANumber_txt).sendKeys(abanumber);
		test.log(Status.INFO, "FI ABA Number entered");
		Thread.sleep(2000);
		
		getElement(ObjectRepository.bankaddress1_txt).sendKeys(addrs1);
		test.log(Status.INFO, "Address1 entered");
		Thread.sleep(2000);
		
		clickElement(ObjectRepository.bankcity_txt);
		getElement(ObjectRepository.bankcity_txt).sendKeys(city);
		test.log(Status.INFO, "City name entered");
		Thread.sleep(2000);
		
		clickElement(ObjectRepository.bankstate_dropdown);
		//getElement(ObjectRepository.bankstate_dropdown).click();
		test.log(Status.INFO, "Bank State dropdown opened");
		Thread.sleep(2000);
		
		getElement("//android.widget.CheckedTextView[@text='"+state+"']").click();
		test.log(Status.INFO, "Bank State selected");
		Thread.sleep(2000);
		
		clickElement(ObjectRepository.bankzip_txt);
		getElement(ObjectRepository.bankzip_txt).sendKeys(zip);
		test.log(Status.INFO, "Bank zip code entered");
		Thread.sleep(2000);


		
//		clickElement(ObjectRepository.cncl_btn);
//		test.log(Status.INFO, "Cancel button clicked");
//		Thread.sleep(2000);
//		
//		verifyElementPresent(ObjectRepository.wiretrnsfr_ttl);
//		test.log(Status.INFO, "Wire Transfer page opened");
//		
//		getElement(ObjectRepository.newrcpnt_btn).click();
//		test.log(Status.INFO, "New Recipient button clicked again");
//		Thread.sleep(2000);
		
//Immediary Info
		clickElement(ObjectRepository.rtngnmbr_txt);
		getElement(ObjectRepository.rtngnmbr_txt).sendKeys(rtngno);
		test.log(Status.INFO, "Routing Number entered");
		Thread.sleep(2000);
		
		clickElement(ObjectRepository.ok_btn);
		test.log(Status.INFO, "Done button clicked");
		Thread.sleep(5000);
		
		
//Recipient Details		
		clickElement(ObjectRepository.wirename_txt);
		getElement(ObjectRepository.wirename_txt).sendKeys(wirename);
		test.log(Status.INFO, "Wire Name entered");
		Thread.sleep(2000);
		
		String defcountry=getElement(ObjectRepository.cntry_dropdown).getAttribute("name");
		Assert.assertTrue(defcountry.contains("United States"));
		test.log(Status.INFO, "Default selected country is - United States");
		Thread.sleep(2000);

		getElement(ObjectRepository.adrs1_txt).sendKeys(addrs1);
		test.log(Status.INFO, "Address 1 entered");
		Thread.sleep(2000);
		
//		
//		getElement(ObjectRepository.emailntfctn_chk).click();
//		test.log(Status.INFO, "Send email notification check box clicked");
//		Thread.sleep(2000);

		clickElement(ObjectRepository.city_txt);
		getElement(ObjectRepository.city_txt).sendKeys(city);
		test.log(Status.INFO, "City Name entered");
		Thread.sleep(2000);
		
		clickElement(ObjectRepository.state_dropdown);
		//getElement(ObjectRepository.state_dropdown).click();
		test.log(Status.INFO, "State dropdown opened");
		Thread.sleep(2000);
		
		getElement("//android.widget.CheckedTextView[@text='"+state+"']").click();
		test.log(Status.INFO, "State selected");
		Thread.sleep(4000);
		
		//scrollToElement(1);
		clickElement(ObjectRepository.zip_txt);
		getElement(ObjectRepository.zip_txt).sendKeys(zip);
		test.log(Status.INFO, "Zip code entered");
		Thread.sleep(2000);
		
//Account New tab values entered
		
//		clickElement(ObjectRepository.acntnew_tab);
//		test.log(Status.INFO, "Account - New tab selected");
//		Thread.sleep(2000);
		
//		getElement(ObjectRepository.acnt_txt).sendKeys(acntno);
//		test.log(Status.INFO, "Account number entered");
//		Thread.sleep(2000);
//		
//		getElement(ObjectRepository.bankname_txt).sendKeys(bank);
//		test.log(Status.INFO, "Bank Name entered");
//		Thread.sleep(2000);
//		
//		scrollToElement(2);
//		Thread.sleep(2000);
//		getElement(ObjectRepository.rtngnmbr_txt).sendKeys(rtngno);
//		test.log(Status.INFO, "Routing Number entered");
//		Thread.sleep(2000);
//		
//		getElement(ObjectRepository.bankaddress1_txt).sendKeys(addrs1);
//		test.log(Status.INFO, "Address1 entered");
//		Thread.sleep(2000);
//		
//		clickElement(ObjectRepository.bankcity_txt);
//		getElement(ObjectRepository.bankcity_txt).sendKeys(city);
//		test.log(Status.INFO, "City name entered");
//		Thread.sleep(2000);
//		
//		clickElement(ObjectRepository.bankstate_dropdown);
//		//getElement(ObjectRepository.bankstate_dropdown).click();
//		test.log(Status.INFO, "Bank State dropdown opened");
//		Thread.sleep(2000);
//		
//		getElement("//android.widget.CheckedTextView[@text='"+state+"']").click();
//		test.log(Status.INFO, "Bank State selected");
//		Thread.sleep(2000);
//		
//		clickElement(ObjectRepository.bankzip_txt);
//		getElement(ObjectRepository.bankzip_txt).sendKeys(zip);
//		test.log(Status.INFO, "Bank zip code entered");
//		Thread.sleep(2000);
//		
		//scrollToElement(3);
		clickElement(ObjectRepository.ok_btn);
		test.log(Status.INFO, "Ok button clicked");
		Thread.sleep(5000);
		
				 }
			 }
		}
	}
	
	@AfterMethod
	public void afterMethod(ITestResult result) throws Throwable{
		if(result.getStatus()==ITestResult.FAILURE){
			test.log(Status.FAIL, "Test Failed - "+result.getThrowable());	
			GenericKeywords.takescreenshot(myTestCaseName,test);
		}else
		{
			test.log(Status.PASS, "Verify Wire Transfer recipient creation scenario working fine");
		}
	}
	
	@AfterTest
	public void tearDown(){
		driver.quit();
		stopAppium();
		extent.flush();
		
	}
}
