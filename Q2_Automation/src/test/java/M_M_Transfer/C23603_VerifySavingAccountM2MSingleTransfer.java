package M_M_Transfer;

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

public class C23603_VerifySavingAccountM2MSingleTransfer   extends GenericKeywords {

	ExtentReports extent;
	ExtentTest test;
	/*
	 * Verify M2M Single transfer to Savings account 
	 * 
	 */

	@BeforeTest
	public void setUp() throws InterruptedException, MessagingException, IOException {
		extent = ExtentManager.GetExtent();
		test = extent.createTest(this.getClass().getSimpleName());
		BaseClass iDriver = new BaseClass();
		iDriver.myTestCaseName = this.getClass().getSimpleName();
		executeDriverScript();
		test.log(Status.INFO, "Application url navigated");
		
//		try{	
//				//click login button
//				getElement(ObjectRepository.otpemail_btn).click();
//				test.log(Status.INFO, "Send OTP to email button clicked");
//				Thread.sleep(15000);
//				
//				getElement(ObjectRepository.otp_txt).sendKeys(fetchOutlookOTP());
//				test.log(Status.INFO, "Login ID entered");
//				
//				
//				getElement(ObjectRepository.submit_btn).click();
//				test.log(Status.INFO, "Send OTP to email button clicked");
//				Thread.sleep(7000);
//				
//				
//					if(getElement(ObjectRepository.register_btn).isDisplayed()){
//						getElement(ObjectRepository.register_btn).click();
//						test.log(Status.INFO, "Register device button clicked");
//						Thread.sleep(7000);
//					}
//					}catch(Exception e){
//						test.log(Status.INFO, "Register device button not available to be clicked");
//					}
//				
				
				
	}

	@Test
	public void C23603_VerifySavingAccountM2MSingleTransfer() throws InterruptedException, MessagingException, IOException
	{
		
		if(continuetestcase==true)
		{
			sheetName = "MemberToMember";
			int totalRowCount = excl.getRowCount(sheetName);
			for(startIter=1;startIter<=totalRowCount;startIter++) //It is mandatory to have this for loop in every test case
			 {	
				if(this.getClass().getSimpleName().equals(excl.getCellData("MemberToMember", 0, startIter)))
				 {
										
					String frmacntnumber=excl.getCellData(sheetName, 1, startIter);
					String acnttyp=excl.getCellData(sheetName, 2, startIter);
					String lstname=excl.getCellData(sheetName, 3, startIter);
					String toacntnumber=excl.getCellData(sheetName, 4, startIter);
					String amnt=excl.getCellData(sheetName, 5, startIter);
					username=excl.getCellData(sheetName, 6, startIter);		
					password=excl.getCellData(sheetName, 7, startIter);	
					
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
			
		
		getElement(ObjectRepository.trnsctn_menu).click();
		test.log(Status.INFO, "transaction menu clicked");
		
		getElement(ObjectRepository.mtmtrnsfr_menu).click();
		test.log(Status.INFO, "Member to Member transfer menu clicked");
		
		Thread.sleep(3000);
		verifyElementPresent(ObjectRepository.sngltrnsfr_btn);
		test.log(Status.INFO, "Single transfer option available");
		
		verifyElementPresent(ObjectRepository.lnkacnt_btn);
		test.log(Status.INFO, "Link Account option available");
		
		getElement(ObjectRepository.sngltrnsfr_btn).click();
		test.log(Status.INFO, "Single transfer option clicked");
		
		verifyElementPresent(ObjectRepository.mtm_sngltrnsfr_ttl);
		test.log(Status.INFO, "Single Transfer page opened");
		
		selectDropdownOptContain(ObjectRepository.mtm_frmacnt_dropdown, frmacntnumber);
		test.log(Status.INFO, "From account selected");
		
		getElement(ObjectRepository.mtm_amnt_txt).sendKeys(amnt);
		test.log(Status.INFO, "Amount entered");
		
		getElement(ObjectRepository.mtm_desc_txt).sendKeys("Desc");
		test.log(Status.INFO, "Description entered");
		
		getElement(ObjectRepository.mtm_toacntnmbr_txt).sendKeys(toacntnumber);
		test.log(Status.INFO, "To Account Number entered");
		
		selectDropdownOptContain(ObjectRepository.mtm_acnttyp_dropdown, acnttyp);
		test.log(Status.INFO, "Account type as Savings Account selected");
		
		getElement(ObjectRepository.mtm_lstname_txt).sendKeys(lstname.substring(0, 3));
		test.log(Status.INFO, "First Three characters of Last Name entered");
		
		scrollToElement(ObjectRepository.mtm_sbmt_btn);
		getElement(ObjectRepository.mtm_sbmt_btn).click();
		test.log(Status.INFO, "Submit button clicked");
		
		verifyElementPresent(ObjectRepository.mtm_sngltrnsfr_sccsmsg);
		test.log(Status.INFO, "Success message for member to member transfer appearing");
		
		getElement(ObjectRepository.mtm_vwactvty_btn).click();
		test.log(Status.INFO, "View Activity center button clicked from mtm transfer success screen");
		
		verifyElementPresent(ObjectRepository.actvtycntr_ttl);
		test.log(Status.INFO, "Activity Center page opened");
		
		verifyText(ObjectRepository.mtm_actvtycntr_amnt, amnt);
		test.log(Status.INFO, "Activity Center page contains latest member to member transfer transaction");
		
		getElement(ObjectRepository.logoff_lnk).click();
		test.log(Status.INFO, "Log off link clicked");
		Thread.sleep(7000);
		
		driver.get(url);
		Thread.sleep(2000);
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
			test.log(Status.PASS, "Verify M2M Single transfer to Savings account scenario working fine");
		}
	}

	@AfterTest
	public void tearDown() {
		extent.flush();
		driver.quit();
	}

}
