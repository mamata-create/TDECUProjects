package com.FrameworkComponents;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;

import io.appium.java_client.TouchAction;

public class GenericKeywords extends BaseClass {

	public static WebElement getElement(String locator){
		WebElement element=null;
		WebDriverWait wait = new WebDriverWait(driver, 30); 
		element = (WebElement) wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator))); 
		return element;
	}
	
	public static void verifyElementPresent(String locator){
		WebElement element=getElement(locator);
		boolean elementpresent=element.isDisplayed();
		if(elementpresent){
			Assert.assertTrue(true);
		}else{
			Assert.assertTrue(false);
		}
	}
	
	public static void selectFutureDateAfter45Days() throws InterruptedException{
		
		DateFormat dateFormat = new SimpleDateFormat("MMMM/d/yyyy");
	    Calendar cal = Calendar.getInstance();
	    cal.setTime(new Date());
	    cal.add(Calendar.DATE, 46);
	    String newDate = dateFormat.format(cal.getTime());

	    
		String date,month,year;
		String caldt,calmonth,calyear;		
		/*
		 * Split the String into String Array
		 */
		String dateArray[]= newDate.split("/");
		date=dateArray[1];
		month=dateArray[0];
		year=dateArray[2];
		System.out.println(date+month+year);
		
		String calYear=getElement("//android.widget.ScrollView[@resource-id='com.kone.tdecu:id/SCROLL_LAYOUT']/android.view.ViewGroup[@index='0']/android.view.ViewGroup[@index='1']/android.view.ViewGroup[@index='1']//android.widget.TextView[@index='1']").getText();
		System.out.println("Calender title is -"+calYear);
		//&& !calYear.contains(year)
		while(!calYear.contains(month)){
			getElement("//android.widget.ScrollView[@resource-id='com.kone.tdecu:id/SCROLL_LAYOUT']/android.view.ViewGroup[@index='0']/android.view.ViewGroup[@index='1']/android.view.ViewGroup[@index='1']//android.view.ViewGroup[@index='2']/android.widget.ImageView").click();
			Thread.sleep(2000);
			calYear=getElement("//android.widget.ScrollView[@resource-id='com.kone.tdecu:id/SCROLL_LAYOUT']/android.view.ViewGroup[@index='0']/android.view.ViewGroup[@index='1']/android.view.ViewGroup[@index='1']//android.widget.TextView[@index='1']").getText();
		}
		getElement("//android.widget.TextView[@text='"+date+"']").click();
		
		
	}
	
	public static void selectFutureDate45Days() throws InterruptedException{
		DateFormat dateFormat = new SimpleDateFormat("MMMM/d/yyyy");
	    Calendar cal = Calendar.getInstance();
	    cal.setTime(new Date());
	    cal.add(Calendar.DATE, 45);
	    String newDate = dateFormat.format(cal.getTime());

	    
		String date,month,year;
		String caldt,calmonth,calyear;		
		/*
		 * Split the String into String Array
		 */
		String dateArray[]= newDate.split("/");
		date=dateArray[1];
		month=dateArray[0];
		year=dateArray[2];
		System.out.println(date+month+year);
		
		String calYear=getElement("//android.widget.ScrollView[@resource-id='com.kone.tdecu:id/SCROLL_LAYOUT']/android.view.ViewGroup[@index='0']/android.view.ViewGroup[@index='1']/android.view.ViewGroup[@index='1']//android.widget.TextView[@index='1']").getText();
		System.out.println("Calender title is -"+calYear);
		//&& !calYear.contains(year)
		while(!calYear.contains(month)){
			getElement("//android.widget.ScrollView[@resource-id='com.kone.tdecu:id/SCROLL_LAYOUT']/android.view.ViewGroup[@index='0']/android.view.ViewGroup[@index='1']/android.view.ViewGroup[@index='1']//android.view.ViewGroup[@index='2']/android.widget.ImageView").click();
			Thread.sleep(2000);
			calYear=getElement("//android.widget.ScrollView[@resource-id='com.kone.tdecu:id/SCROLL_LAYOUT']/android.view.ViewGroup[@index='0']/android.view.ViewGroup[@index='1']/android.view.ViewGroup[@index='1']//android.widget.TextView[@index='1']").getText();
		}
		getElement("//android.widget.TextView[@text='"+date+"']").click();
		
	}
	
	public static void enterAmount(String amnt){
		if(amnt.contains(".")){
			String nwAmt=amnt.replace(".", "");
			char[] varArr = nwAmt.trim().toCharArray();
			for(int i=0;i<varArr.length;i++){
				getElement("//android.widget.Button[@text='"+varArr[i]+"']").click();
			}
			//getElement("//android.widget.Button[@text='0']").click();
		}else{
			char[] varArr = amnt.trim().toCharArray();
			for(int i=0;i<varArr.length;i++){
				getElement("//android.widget.Button[@text='"+varArr[i]+"']").click();
			}
			getElement("//android.widget.Button[@text='0']").click();
			getElement("//android.widget.Button[@text='0']").click();
		}
	}
	
	public static void enterDate(String amnt){
		if(amnt.contains(".")){
			String nwAmt=amnt.replace(".", "");
			char[] varArr = nwAmt.trim().toCharArray();
			for(int i=0;i<varArr.length;i++){
				getElement("//android.widget.Button[@text='"+varArr[i]+"']").click();
			}
			//getElement("//android.widget.Button[@text='0']").click();
		}else{
			char[] varArr = amnt.trim().toCharArray();
			for(int i=0;i<varArr.length;i++){
				getElement("//android.widget.Button[@text='"+varArr[i]+"']").click();
			}
			
		}
	}
	
	public static void takescreenshot(String filename,ExtentTest test) throws IOException{ 
		TakesScreenshot screen = (TakesScreenshot) driver; 
		File src = screen.getScreenshotAs(OutputType.FILE); 	
		String dest =System.getProperty("user.dir")+"//screenshots//"+filename+"_Error.png"; 
		System.out.println(dest); 
	File target = new File(dest); 
	FileUtils.copyFile(src, target);
	test.addScreenCaptureFromPath(dest); 
	}
	
	public static void scrollToElement(String locator,int loopCount){
		
		for(int i=1;i<loopCount;i++)
		{
			
			try{
				WebElement ele=getElement(locator);
				if(ele.isDisplayed())
				{
					break;
				}
			}catch(Exception e){
				Dimension dim = driver.manage().window().getSize();
				int height = dim.getHeight();
				int width = dim.getWidth();
				int x = width/2;
				int top_y = (int)(height*0.80);
				int bottom_y = (int)(height*0.20);
				System.out.println("coordinates :" + x + "  "+ top_y + " "+ bottom_y);
				TouchAction ts = new TouchAction(driver);
				ts.press(x, top_y).moveTo(x, bottom_y).release().perform();
			}
		}
		
	}

	public static String randomNumber(){
		int rangeMin=1;
		int rangeMax=20;
		Random r = new Random();
		double randomValue = rangeMin + (rangeMax - rangeMin) * r.nextFloat();
		   double roundOff = Math.round(randomValue*100.0)/100.0;
		   System.out.println(roundOff);
		   
		String number=Double.toString(roundOff);
		int decind=number.indexOf(".");
		String subnum=number.substring(decind+1, number.length());
		
		System.out.println("Number after decimal-"+subnum);
		if(subnum.length()==1){
			number=number+"0";
			System.out.println("Number till two decimal-"+number);
		}
		return number;
	}
}
