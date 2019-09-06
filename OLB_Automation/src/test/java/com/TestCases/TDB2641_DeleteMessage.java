package com.TestCases;

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

public class TDB2641_DeleteMessage extends GenericKeywords {
	
	ExtentReports extent;
	ExtentTest test;
	/*
	 * TDB2641-Verify Delete Message
	 */
	
	@BeforeTest
	public void setUp(){
		extent=ExtentManager.GetExtent();
		test=extent.createTest(this.getClass().getSimpleName());
		BaseClass iDriver = new BaseClass();
	    iDriver.myTestCaseName = this.getClass().getSimpleName();
		executeDriverScript();
		test.log(Status.INFO, "Application url navigated" );
		getElement(ObjectRepository.username_txt).sendKeys(username);
		getElement(ObjectRepository.password_txt).sendKeys(password);
		test.log(Status.INFO, "Username and Password entered" );
		getElement(ObjectRepository.login_btn).click();
		Assert.assertTrue(getElement(ObjectRepository.acnt_dshbrd).isDisplayed());
		test.log(Status.INFO, "User logged in successfully as account dashboard displayed" );
	}
		
		@Test
		public void TDB2641_DeleteMessage() throws InterruptedException
				{
					if(continuetestcase==true)
					{
						sheetName = "Messages";
						int totalRowCount = excl.getRowCount(sheetName);
						for(startIter=1;startIter<=totalRowCount;startIter++) //It is mandatory to have this for loop in every test case
						 {	
							if(this.getClass().getSimpleName().equals(excl.getCellData("Messages", 0, startIter)))
							 {
								String msgCat=excl.getCellData("Messages", 1, startIter);
								String msgSbjct=excl.getCellData("Messages", 2, startIter);
								String msgDesc=excl.getCellData("Messages", 3, startIter);
								
					Thread.sleep(4000);
					getElement(ObjectRepository.menuImg).click();
					test.log(Status.INFO, "menu item image clicked" );
					Thread.sleep(4000);
					getElement(ObjectRepository.accntCollapse).click();
					test.log(Status.INFO, "Accounts options collapsed" );
					getElement(ObjectRepository.msgCollapse).click();
					test.log(Status.INFO, "Messages options expanded" );
					Thread.sleep(4000);
					
					//scrollToElement(ObjectRepository.newMsgLnk);
					test.log(Status.INFO, "Scroll to My message link" );
					Thread.sleep(4000);
					getElement(ObjectRepository.myMsgLnk).click();
					test.log(Status.INFO, "My message link clicked" );
					Thread.sleep(4000);
					
					verifyElementPresent(ObjectRepository.myMsgLbl);
					test.log(Status.INFO, "My message label is available" );
					getElement(ObjectRepository.searchtxt).sendKeys(msgSbjct);
					getElement(ObjectRepository.searchImg).click();
					test.log(Status.INFO, "My message label is available" );
					String searchRslt=getElement(ObjectRepository.msg).getText();
					if(searchRslt.contains(msgSbjct)){
						Assert.assertTrue(true);
					}else{
						Assert.assertTrue(false);
					}
					Thread.sleep(4000);
					getElement(ObjectRepository.dltbtn).click();
					Thread.sleep(4000);
					getElement(ObjectRepository.yesMsgPop).click();
					Thread.sleep(4000);
					getElement(ObjectRepository.searchtxt).sendKeys(msgSbjct);
					getElement(ObjectRepository.searchImg).click();
					test.log(Status.INFO, "My message label is available" );
					 searchRslt=getElement(ObjectRepository.msg).getText();
					if(!searchRslt.contains(msgSbjct)){
						Assert.assertTrue(true);
					}else{
						Assert.assertTrue(false);
					}
					
							 }
						 }
					}
					
				 }
	
					@AfterMethod
					public void afterMethod(ITestResult result) throws Throwable{
						if(result.getStatus()==ITestResult.FAILURE){
							test.log(Status.FAIL, "Test Failed"+result.getThrowable());	
							takescreenshot(this.getClass().getSimpleName(),test);
						}else
						{
							test.log(Status.PASS, "Delete Message scenario working fine");
						}
					}
	
						@AfterTest
						public void tearDown()
						{
							extent.flush();
							driver.quit();
						}
						
						
					}


