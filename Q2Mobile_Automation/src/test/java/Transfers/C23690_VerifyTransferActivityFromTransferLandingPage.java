package Transfers;

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

public class C23690_VerifyTransferActivityFromTransferLandingPage  extends GenericKeywords {

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
	public void C23690_VerifyTransferActivityFromTransferLandingPage() throws InterruptedException
	{
		if(continuetestcase==true)
		{
			sheetName = "Data";
			int totalRowCount = excl.getRowCount(sheetName);
			for(startIter=1;startIter<=totalRowCount;startIter++) //It is mandatory to have this for loop in every test case
			 {	
				if(this.getClass().getSimpleName().equals(excl.getCellData(sheetName, 0, startIter)))
				 {
					String frmacnt=excl.getCellData(sheetName, 1, startIter);
					String toacnt=excl.getCellData(sheetName, 2, startIter);
					String amnt=excl.getCellData(sheetName, 3, startIter);
					
		Thread.sleep(20000);	
		verifyElementPresent(ObjectRepository.home_ttl);
		test.log(Status.INFO, "Home link appearing");
	//Verify menu item option
		verifyElementPresent(ObjectRepository.menu_btn);
		test.log(Status.INFO, "Menu link appearing");
	
		getElement(ObjectRepository.menu_btn).click();
		test.log(Status.INFO, "Menu link clicked");
		Thread.sleep(4000);	
		
		getElement(ObjectRepository.trnsctn_menu).click();
		test.log(Status.INFO, "Transaction menu clicked");
		Thread.sleep(2000);	
		
		getElement(ObjectRepository.fndtrnsfr_menu).click();
		test.log(Status.INFO, "Fund Transfer menu clicked");
		Thread.sleep(2000);
		
		verifyElementPresent(ObjectRepository.fndtrnsfr_menu);
		test.log(Status.INFO, "Transfer title appeared");
		
		getElement(ObjectRepository.actvty_btn).click();
		test.log(Status.INFO, "Activity button clicked");
		Thread.sleep(15000);	
		
//		verifyElementPresent(ObjectRepository.pending_tab);
//		test.log(Status.INFO, "Pending tab appeared");
//		
		//clickElement(ObjectRepository.pending_tab);
		//getElement(ObjectRepository.pending_tab).click();
		test.log(Status.INFO, "Pending tab clicked");
		Thread.sleep(4000);	
		
		String transaction=getElement(ObjectRepository.pending_trnsctn).getAttribute("name");
		int id_indx=transaction.indexOf("ID");
		id_indx=id_indx+1;
		String searchID=transaction.substring(id_indx, id_indx+8);
		//searchID=searchID.replace(" ", "");
//		
		System.out.println("Search text-"+transaction+","+searchID);
		
		clickElement(ObjectRepository.search_txtbox);
		Thread.sleep(2000);
		
		getElement(ObjectRepository.search_txtbox).sendKeys(searchID);
		Thread.sleep(4000);
//		
		
		
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
			test.log(Status.PASS, "Verify transfer activity from transfer landing page scenario working fine");
		}
	}
	
	@AfterTest
	public void tearDown(){
		driver.quit();
		stopAppium();
		extent.flush();
		
	}
}
