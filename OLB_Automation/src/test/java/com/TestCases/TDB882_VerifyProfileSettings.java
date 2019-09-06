package com.TestCases;

import java.util.List;

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

public class TDB882_VerifyProfileSettings extends GenericKeywords {
	
	ExtentReports extent;
	ExtentTest test;
	/*
	 * TDB882 - Verify profile settings
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
				public void TDB882_VerifyProfileSettings() throws InterruptedException
				{
					Thread.sleep(4000);
					getElement(ObjectRepository.settingsimg).click();
					test.log(Status.INFO, "Settings link clicked" );
					getElement(ObjectRepository.proflsettinglnk).click();
					test.log(Status.INFO, "Profile settings link is clicked" );
//					 final List<WebElement> iframes = driver.findElements(By.tagName("iframe"));
//					    for (WebElement iframe : iframes) {
//					       System.out.println(iframe.getAttribute("src"));
//					    }
					    Thread.sleep(3000);
					//driver.switchTo().frame(iframes.get(1));
					Thread.sleep(3000);
					WebElement ele=driver.findElement(By.xpath("//div[@id='frmProfileManagement_settings_lblHeading' and @aria-label='Profile Settings ']"));
					Assert.assertTrue(ele.isDisplayed());
					test.log(Status.INFO, "Profile settings page is displayed" );
				}
	
					@AfterMethod
					public void afterMethod(ITestResult result) throws Throwable{
						if(result.getStatus()==ITestResult.FAILURE){
							test.log(Status.FAIL, "Test Failed-"+result.getThrowable());

							takescreenshot(this.getClass().getSimpleName(),test);
						}else
						{
							test.log(Status.PASS, "Verify profile settings scenario working fine");
						}
					}
	
						@AfterTest
						public void tearDown()
						{
							extent.flush();
							driver.quit();
						}
						
						
					}


