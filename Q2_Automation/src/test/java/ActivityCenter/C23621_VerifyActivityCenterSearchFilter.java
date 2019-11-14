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

public class C23621_VerifyActivityCenterSearchFilter  extends GenericKeywords {

	ExtentReports extent;
	ExtentTest test;
	/*
	 * Verify Activity Center Search Filter
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
	public void C23621_VerifyActivityCenterSearchFilter() throws InterruptedException, MessagingException, IOException
	{
		
		if(continuetestcase==true)
		{
			sheetName = "Data";
			int totalRowCount = excl.getRowCount(sheetName);
			for(startIter=1;startIter<=totalRowCount;startIter++) //It is mandatory to have this for loop in every test case
			 {	
				if(this.getClass().getSimpleName().equals(excl.getCellData(sheetName, 0, startIter)))
				 {
					String transactionType=excl.getCellData(sheetName, 1, startIter);
					String locaddress=excl.getCellData(sheetName, 2, startIter);
					String atmname=excl.getCellData(sheetName, 3, startIter);
					String atmaddress=excl.getCellData(sheetName, 4, startIter);
					
					
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
					
					verifyText(ObjectRepository.srchtrnsctn_txt, "");
					test.log(Status.INFO, "Search transaction field is empty");
					
					getElement(ObjectRepository.fltr_lnk).click();
					test.log(Status.INFO, "Filter link clicked to see filter options");
					Thread.sleep(5000);
					
				//Search filter options
					//verifyElementPresent("//label[contains(text(),'Transaction Type')]");
					
					String[]filterType = new String[]{"Transaction Type","Status","Account","Created By"};
					String[]options = new String[]{"Funds Transfer","Drafted","PRIMARY CHECKING	70024450	$1,835.10","Äll"};
					for(int index=0;index<filterType.length;index++){
						WebElement element = driver.findElement(By.xpath("//label[contains(text(),'"+filterType[index].toString()+"')]/following::select[@class='form-control q2-select ember-view']"));
						if(element.isDisplayed())
							test.log(Status.INFO, filterType[index].toString()+" filter option available");
					}
					
					for(String count:filterType){
						WebElement element = driver.findElement(By.xpath("//label[contains(text(),'"+filterType[Integer.parseInt(count)].toString()+"')]/following::select[@class='form-control q2-select ember-view']"));
						Select sel=new Select(element);
						sel.selectByVisibleText(options[Integer.parseInt(count)].toString());
						getElement(ObjectRepository.applyFilterBtn).click();;
					}
					
					
				//	verifyElementPresent(ObjectRepository.trnsctntyp_drop);
				//	test.log(Status.INFO, "Transaction type filter option available");
					
					
				/*	WebElement stts_ele=getElement(ObjectRepository.stts_parent).findElement(By.xpath(ObjectRepository.trnsctntyp_drop));
					Assert.assertTrue(stts_ele.isDisplayed());
					test.log(Status.INFO, "Status filter option available");
				
					WebElement acnt_ele=getElement(ObjectRepository.acnt_parent).findElement(By.xpath(ObjectRepository.trnsctntyp_drop));
					Assert.assertTrue(acnt_ele.isDisplayed());
					test.log(Status.INFO, "Account filter option available");
					
					WebElement crtdby_ele=getElement(ObjectRepository.crtd_parent).findElement(By.xpath(ObjectRepository.trnsctntyp_drop));
					Assert.assertTrue(crtdby_ele.isDisplayed());
					test.log(Status.INFO, "Created By filter option available");
					
					WebElement amnt_ele=getElement(ObjectRepository.amnt_parent).findElement(By.xpath(ObjectRepository.srchamnt_txt));
					Assert.assertTrue(amnt_ele.isDisplayed());
					test.log(Status.INFO, "Amount filter option available");*/
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
			test.log(Status.PASS, "Verify Activity Center Search Filter scenario working fine");
		}
	}

	@AfterTest
	public void tearDown() {
		extent.flush();
		driver.quit();
	}

}
