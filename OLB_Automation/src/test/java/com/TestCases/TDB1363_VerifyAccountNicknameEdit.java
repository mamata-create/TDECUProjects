package com.TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
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

public class TDB1363_VerifyAccountNicknameEdit extends GenericKeywords {
	
	ExtentReports extent;
	ExtentTest test;
	/*
	 * TDB1363 - Verify Account Nickname edit scenario
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
		public void TDB1363_VerifyAccountNicknameEdit() throws InterruptedException
			{
					if(continuetestcase==true)
					{
						sheetName = "Beneficiary";
						int totalRowCount = excl.getRowCount(sheetName);
						for(startIter=1;startIter<=totalRowCount;startIter++) //It is mandatory to have this for loop in every test case
						 {	
							if(this.getClass().getSimpleName().equals(excl.getCellData("Beneficiary", 0, startIter)))
							 {
								String acntNumber=excl.getCellData("Beneficiary", 1, startIter);
								String frstThreeChar=excl.getCellData("Beneficiary", 2, startIter);
								String nickname=excl.getCellData("Beneficiary", 3, startIter);
								String newNickname=excl.getCellData("Beneficiary", 4, startIter);
								
						Thread.sleep(4000);
						getElement(ObjectRepository.settingsimg).click();
						test.log(Status.INFO, "Settings link clicked" );	
						getElement(ObjectRepository.accntsettinglnk).click();
						test.log(Status.INFO, "Account Settings link clicked" );
						
						WebElement parentElement=getElement("//div[contains(text(),'"+acntNumber+"')]/parent::*/parent::*/parent::*/parent::*/parent::*/parent::*/parent::*/parent::*/parent::*/parent::*/parent::*");
						System.out.println("ID is -"+parentElement.getAttribute("id"));
						parentElement.findElement(By.xpath(ObjectRepository.editlnk)).click();
						test.log(Status.INFO, "Edit link clicked for account editing" );
						
						getElement(ObjectRepository.clrNickname).click();
						test.log(Status.INFO, "Clear icon clicked to remove existing nickname" );
						
						getElement(ObjectRepository.nicknametxt).sendKeys(newNickname);
						test.log(Status.INFO, "New Nickname entered" );
						Thread.sleep(2000);
						getElement(ObjectRepository.nicknametxt).sendKeys(Keys.TAB);
						Thread.sleep(2000);
						
						
						Actions actions = new Actions(driver);
						actions.keyDown(Keys.CONTROL).sendKeys(Keys.END).perform();
						Thread.sleep(2000);
						
						//getElement(ObjectRepository.savebtn).click();
						JavascriptExecutor executor1 = (JavascriptExecutor)driver;
						executor1.executeScript("arguments[0].click();", getElement(ObjectRepository.savebtn));
						test.log(Status.INFO, "Save icon clicked " );
						
						verifyElementPresent(ObjectRepository.nicksuccess);
						getElement(ObjectRepository.acnttab).click();
						test.log(Status.INFO, "Accounts tab clicked" );						
						
					Thread.sleep(4000);
					WebElement childelement=getElement("//div[@id='flxAccountListItem_lblAccountNumber' and contains(text(),'"+acntNumber+"')]");
					scrollToElement("//div[@id='flxAccountListItem_lblAccountNumber' and contains(text(),'"+acntNumber+"')]");
					JavascriptExecutor executor = (JavascriptExecutor)driver;
					WebElement parentElement1 = (WebElement)executor.executeScript("return arguments[0].parentNode;", childelement);
					WebElement parentElement2 = (WebElement)executor.executeScript("return arguments[0].parentNode;", parentElement1);
					test.log(Status.INFO, "Fetch actual nickname against the account on dashboard" );
					WebElement parentEle=parentElement2.findElement(By.xpath("//div[@id='flxAccountListItem_lblAccountName']"));
					String actNickname=parentEle.getText();
						Assert.assertTrue(actNickname.equals(newNickname));
						test.log(Status.INFO, "Updated nickname appearing on the account dashboard as expected" );
						Thread.sleep(2000);
						getElement(ObjectRepository.settingsimg).click();
						test.log(Status.INFO, "Settings link clicked" );	
						getElement(ObjectRepository.accntsettinglnk).click();
						test.log(Status.INFO, "Account Settings link clicked" );
						
						WebElement parentElement21=getElement("//div[contains(text(),'"+acntNumber+"')]/parent::*/parent::*/parent::*/parent::*/parent::*/parent::*/parent::*/parent::*/parent::*/parent::*/parent::*");
						System.out.println("ID is -"+parentElement21.getAttribute("id"));
						parentElement21.findElement(By.xpath(ObjectRepository.editlnk)).click();
						test.log(Status.INFO, "Edit link clicked for account editing" );
						
						getElement(ObjectRepository.clrNickname).click();
						test.log(Status.INFO, "Clear icon clicked to remove existing nickname" );
						
						getElement(ObjectRepository.nicknametxt).sendKeys(nickname);
						test.log(Status.INFO, "New Nickname entered" );
						Thread.sleep(2000);
						getElement(ObjectRepository.nicknametxt).sendKeys(nickname);
						Thread.sleep(2000);
						getElement(ObjectRepository.nicknametxt).sendKeys(Keys.TAB);
						Thread.sleep(2000);
						Actions actions1 = new Actions(driver);
						actions1.keyDown(Keys.CONTROL).sendKeys(Keys.END).perform();
						Thread.sleep(2000);
						
						JavascriptExecutor executor2 = (JavascriptExecutor)driver;
						executor2.executeScript("arguments[0].click();", getElement(ObjectRepository.savebtn));
						test.log(Status.INFO, "Save button clicked to update the old nickname" );						
									
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
							test.log(Status.PASS, "Verify Account Nickname edit scenario working fine");
						}
					}
	
						@AfterTest
						public void tearDown()
						{
							extent.flush();
							driver.quit();
						}
						
						
					}


