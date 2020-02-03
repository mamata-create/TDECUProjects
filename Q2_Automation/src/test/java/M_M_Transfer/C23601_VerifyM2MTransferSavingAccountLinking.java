package M_M_Transfer;

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

public class C23601_VerifyM2MTransferSavingAccountLinking   extends GenericKeywords {

	ExtentReports extent;
	ExtentTest test;
	/*
	 * Verify Savings account Linking for M2M transfer
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
//		try{	
//				//click login button
//				getElement(ObjectRepository.otpemail_btn).click();
//				test.log(Status.INFO, "Send OTP to email button clicked");
//				Thread.sleep(15000);
//				
//				getElement(ObjectRepository.otp_txt).sendKeys(fetchOutlookOTPSravya());
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
				
				//Verify log off link available after login
				verifyElementPresent(ObjectRepository.logoff_lnk);
				test.log(Status.INFO, "User successfully logged in as Logoff link available");
		
	}

	@Test
	public void C23601_VerifyM2MTransferSavingAccountLinking() throws InterruptedException, MessagingException, IOException
	{
		if(continuetestcase==true)
		{
			sheetName = "MemberToMember";
			int totalRowCount = excl.getRowCount(sheetName);
			for(startIter=1;startIter<=totalRowCount;startIter++) //It is mandatory to have this for loop in every test case
			 {	
				if(this.getClass().getSimpleName().equals(excl.getCellData("MemberToMember", 0, startIter)))
				 {
					String acntnumber=excl.getCellData(sheetName, 4, startIter);
					String acnttyp=excl.getCellData(sheetName, 2, startIter);
					String lstname=excl.getCellData(sheetName, 3, startIter);
		
		getElement(ObjectRepository.trnsctn_menu).click();
		test.log(Status.INFO, "transaction menu clicked");
		
		getElement(ObjectRepository.mtmtrnsfr_menu).click();
		test.log(Status.INFO, "Member to Member transfer menu clicked");
		
		Thread.sleep(3000);
		verifyElementPresent(ObjectRepository.sngltrnsfr_btn);
		test.log(Status.INFO, "Single transfer option available");
		
		verifyElementPresent(ObjectRepository.lnkacnt_btn);
		test.log(Status.INFO, "Link Account option available");
		
		getElement(ObjectRepository.lnkacnt_btn).click();
		test.log(Status.INFO, "Link Account option clicked");
		
		verifyElementPresent(ObjectRepository.mtm_lnkacnt_ttl);
		test.log(Status.INFO, "Link an Account page opened");
		
		getElement(ObjectRepository.mtm_toacntnmbr_txt).sendKeys(acntnumber);
		test.log(Status.INFO, "Savings Account Number entered");
		
		selectDropdownOptContain(ObjectRepository.mtm_acnttyp_dropdown, acnttyp);
		test.log(Status.INFO, "Account type as Savings Account selected");
		
		getElement(ObjectRepository.mtm_lstname_txt).sendKeys(lstname);
		test.log(Status.INFO, "Last Name entered");
		
		scrollToElement(ObjectRepository.mtm_sbmt_btn);
		getElement(ObjectRepository.mtm_sbmt_btn).click();
		test.log(Status.INFO, "Submit button clicked");
		
		verifyElementPresent(ObjectRepository.mtm_sccsmsg);
		test.log(Status.INFO, "Success message for account linking appears");
		
		getElement(ObjectRepository.mtm_donebtn).click();
		test.log(Status.INFO, "Done button clicked from account linking success screen");
		
		getElement(ObjectRepository.fndtrnsfr_menu).click();
		test.log(Status.INFO, "Fund Transfers tab is clicked");
		
		WebElement root1 = driver.findElement(By.cssSelector("div[test-id='selTransferTo'] q2-select"));
		WebElement shadowRoot1 = ObjectRepository.expandRootElement(driver,root1);
		WebElement root2 = shadowRoot1.findElement(By.cssSelector("q2-input[label='To Account']"));
		WebElement shadowRoot2 = ObjectRepository.expandRootElement(driver,root2);
		
		WebElement toAccounDropDown = shadowRoot2.findElement(By.cssSelector("button[aria-label=', To Account']"));
		toAccounDropDown.click();
		
		
		List<WebElement> allOptions = driver.findElements(By.xpath("//q2-select[@label='To Account']/q2-option"));
		for(int count=1;count<=allOptions.size();count++){
			String option= driver.findElement(By.xpath("(//q2-select[@label='To Account']/q2-option)["+count+"]")).getAttribute("display");
			System.out.println(option);
			
			if(option.contains(acntnumber)){
				Assert.assertTrue(true, "Provided account number is present in the displayed options");
				return;
			}else if(count >= allOptions.size() && !option.contains(acntnumber) ){
				Assert.assertTrue(false, "Provided account number is not present in the displayed options");
			}
		}
		
		
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
			test.log(Status.PASS, "Savings account Linking for M2M transfer scenario working fine");
		}
	}

	@AfterTest
	public void tearDown() {
		extent.flush();
		driver.quit();
	}

}
