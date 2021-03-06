package M2M_Transfers;

import java.io.IOException;

import javax.mail.MessagingException;

import org.openqa.selenium.Keys;
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

import io.appium.java_client.MobileElement;

public class C23712_VerifyMemberToMemberSingleTransfer  extends GenericKeywords {

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
	public void C23712_VerifyMemberToMemberSingleTransfer() throws InterruptedException
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
					String desc=excl.getCellData(sheetName, 4, startIter);
					String acnttyp=excl.getCellData(sheetName, 7, startIter);
					String lastname=excl.getCellData(sheetName, 6, startIter);
								
		Thread.sleep(20000);	
//		verifyElementPresent(ObjectRepository.home_ttl);
//		test.log(Status.INFO, "Home link appearing");
	//Verify menu item option
		verifyElementPresent(ObjectRepository.menu_btn);
		test.log(Status.INFO, "Menu link appearing");
	
		getElement(ObjectRepository.menu_btn).click();
		test.log(Status.INFO, "Menu link clicked");
		Thread.sleep(4000);	
		
		getElement(ObjectRepository.trnsctn_menu).click();
		test.log(Status.INFO, "Transaction menu clicked");
		Thread.sleep(2000);	
		
		getElement(ObjectRepository.mtm_menu).click();
		test.log(Status.INFO, "Member to Member Transfer menu clicked");
		Thread.sleep(2000);
		
		verifyElementPresent(ObjectRepository.mtm_ttl);
		test.log(Status.INFO, "Member to Member Transfer title appeared");
		
		scrollToElement(1);
		verifyElementPresent(ObjectRepository.sngltrnsfr_btn);
		test.log(Status.INFO, "Single Transfer option appeared");
		
		getElement(ObjectRepository.sngltrnsfr_btn).click();
		test.log(Status.INFO, "Member to Member Transfer menu clicked");
		Thread.sleep(2000);
		
		verifyElementPresent(ObjectRepository.mtm_sngltrnsfrttl);
		test.log(Status.INFO, "Single Transfer Title appeared");
		
	//Navigate back and click Single transfer again
		driver.navigate().back();
		Thread.sleep(2000);
		
		getElement(ObjectRepository.menu_btn).click();
		test.log(Status.INFO, "Menu link clicked");
		Thread.sleep(4000);	
		
		getElement(ObjectRepository.trnsctn_menu).click();
		Thread.sleep(2000);	
		getElement(ObjectRepository.trnsctn_menu).click();
		test.log(Status.INFO, "Transaction menu clicked");
		Thread.sleep(2000);	
		
		getElement(ObjectRepository.mtm_menu).click();
		test.log(Status.INFO, "Member to Member Transfer menu clicked");
		Thread.sleep(4000);
		
		verifyElementPresent(ObjectRepository.mtm_ttl);
		test.log(Status.INFO, "Member to Member Transfer title appeared");
		
		
		scrollToElement(1);
		Thread.sleep(2000);
		getElement(ObjectRepository.sngltrnsfr_btn).click();
		test.log(Status.INFO, "Member to Member Transfer menu clicked");
		Thread.sleep(2000);
		
		verifyElementPresent(ObjectRepository.mtm_frm);
		verifyElementPresent(ObjectRepository.mtm_amnt);
		test.log(Status.INFO, "Single Transfer fields as from account and amount appearing");
		
	//Click Submit button without filling fields
		clickElement(ObjectRepository.mtm_sbmtbtn);
		test.log(Status.INFO, "Submit button clicked");
		Thread.sleep(2000);
		
		scrollUp(1);
		
		
		//Fill mandatory fields
		clickElement(ObjectRepository.mtm_frm);
		test.log(Status.INFO, "From Account dropdown opened");
		
		getElement("//android.widget.CheckedTextView[contains(@text,'"+frmacnt+"')]").click();
		test.log(Status.INFO, "From Account selected");
		Thread.sleep(2000);
		
	//verify only numbers allowed in amount field
		Submitamount("A#$B", ObjectRepository.mtm_amnt);
		
		String amountfielddata=getElement(ObjectRepository.mtm_amnt).getAttribute("name");
		Thread.sleep(2000);
		Assert.assertEquals(amountfielddata, "0.00");
		test.log(Status.INFO, "Amount field doesn't allow characters other than numbers");
		
		Submitamount(amnt, ObjectRepository.mtm_amnt);
		test.log(Status.INFO, "Amount entered");
		Thread.sleep(2000);
		
		amountfielddata=getElement(ObjectRepository.mtm_amnt).getAttribute("name");
		Assert.assertEquals(amountfielddata,amnt);
		test.log(Status.INFO, "Amount field allow numbers only");
		Thread.sleep(2000);
		
		clickElement(ObjectRepository.mtm_desc);
		Thread.sleep(2000);
	
	//verify special characters not allowed in description field
		//Submitamount("#$", ObjectRepository.mtm_desc);
		
	//	String descfielddata=getElement(ObjectRepository.mtm_desc).getAttribute("name");
//		Thread.sleep(2000);
//		Assert.assertEquals(descfielddata, "");
//		test.log(Status.INFO, "Description field doesn't allow special characters");
		
		//Submitamount(desc, ObjectRepository.mtm_desc);
		MobileElement mb1=(MobileElement) getElement(ObjectRepository.mtm_desc);
		mb1.setValue(desc);
		test.log(Status.INFO, "Description entered");
		Thread.sleep(2000);
		
		getElement(ObjectRepository.mtm_desc).sendKeys(Keys.TAB);
		
		String descfielddata=getElement(ObjectRepository.mtm_desc).getAttribute("name");
		Assert.assertEquals(descfielddata,desc);
		test.log(Status.INFO, "Description  field allow chracters other than special characters");
		
		
		
		//scrollToElement(1);
		Thread.sleep(2000);
		clickElement(ObjectRepository.mtm_toacnt);
		Thread.sleep(2000);
		
		MobileElement mb=(MobileElement) getElement(ObjectRepository.mtm_toacnt);
		mb.setValue(toacnt);
		//Submitamount(toacnt,ObjectRepository.mtm_toacnt);
		test.log(Status.INFO, "To Account Number entered");
		Thread.sleep(2000);
	
	//Verify only three characters allowed in first three characters for last name field
		
		clickElement(ObjectRepository.mtm_lstthreechar);
		Thread.sleep(2000);

		MobileElement mbele=(MobileElement) getElement(ObjectRepository.mtm_lstthreechar);
		mbele.setValue(lastname+"A");
		//Submitamount("A"+lastname, ObjectRepository.mtm_lstthreechar);
		
		getElement(ObjectRepository.mtm_lstthreechar).sendKeys(Keys.TAB);
		test.log(Status.INFO, "Last Name three characters entered");
		Thread.sleep(2000);
		
		String lastnamefielddata=getElement(ObjectRepository.mtm_lstthreechar).getAttribute("name");
		Thread.sleep(2000);
		
		Assert.assertEquals(lastnamefielddata, lastname);
		test.log(Status.INFO, "Only three characters allowed in last name field");
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
			test.log(Status.PASS, "Verify Member to Member Single Transfer fields scenario working fine");
		}
	}
	
	@AfterTest
	public void tearDown(){
		driver.quit();
		stopAppium();
		extent.flush();
		
	}
}
