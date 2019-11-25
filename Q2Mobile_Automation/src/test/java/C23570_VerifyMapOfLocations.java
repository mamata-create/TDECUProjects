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

public class C23570_VerifyMapOfLocations extends GenericKeywords {

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
	public void C23570_VerifyMapOfLocations() throws InterruptedException
	{
		if(continuetestcase==true)
		{
			sheetName = "Location";
			int totalRowCount = excl.getRowCount(sheetName);
			for(startIter=1;startIter<=totalRowCount;startIter++) //It is mandatory to have this for loop in every test case
			 {	
				if(this.getClass().getSimpleName().equals(excl.getCellData(sheetName, 0, startIter)))
				 {
					String acntno=excl.getCellData(sheetName, 1, startIter);
					String rtngno=excl.getCellData(sheetName, 2, startIter);
					String bank=excl.getCellData(sheetName, 3, startIter);
					String addrs1=excl.getCellData(sheetName, 4, startIter);
					String city=excl.getCellData(sheetName, 5, startIter);
					
		
		Thread.sleep(20000);	
		verifyElementPresent(ObjectRepository.home_ttl);
		test.log(Status.INFO, "Home link appearing");
	//Verify menu item option
		verifyElementPresent(ObjectRepository.menu_btn);
		test.log(Status.INFO, "Menu link appearing");
	
		getElement(ObjectRepository.menu_btn).click();
		test.log(Status.INFO, "Menu link clicked");
		Thread.sleep(4000);	
			
		getElement(ObjectRepository.loctn_menu).click();
		test.log(Status.INFO, "Location Menu link clicked");
		Thread.sleep(4000);
		
		try{
			if(getElement(ObjectRepository.alw_btn).isDisplayed()){
				getElement(ObjectRepository.alw_btn).click();
			}
		}catch(Exception e){
			System.out.println("Allow popup not appearing");
		}
		
		verifyElementPresent(ObjectRepository.loctn_msg);
		test.log(Status.INFO, "Location message link appearing");
		
		
		getElement(ObjectRepository.loctn_list).click();
		test.log(Status.INFO, "List link clicked");
		Thread.sleep(4000);
		
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
			test.log(Status.PASS, "Verify map of locations scenario working fine");
		}
	}
	
	@AfterTest
	public void tearDown(){
		driver.quit();
		stopAppium();
		extent.flush();
		
	}
}
