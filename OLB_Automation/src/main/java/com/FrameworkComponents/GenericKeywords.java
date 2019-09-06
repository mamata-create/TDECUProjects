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
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;

public class GenericKeywords extends BaseClass{
	
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
	
	
	public static void verifyText(String locator, String text){
		WebElement element=getElement(locator);
		String actText=element.getText();
		if(actText.contains(text)){
			Assert.assertTrue(true);
		}else{
			Assert.assertTrue(false);
		}
	}
	
	public static void selectDropdownOpt(String locator,String option){
		WebElement element=getElement(locator);
		Select sel=new Select(element);
		sel.selectByVisibleText(option);
		
	}
	
	public static void verifyDropdownSelection(String locator,String option){
		WebElement element=getElement(locator);
		Select select = new Select(element);
		WebElement selection = select.getFirstSelectedOption();
		String defaultItem = selection.getText();
		Assert.assertTrue(defaultItem.equalsIgnoreCase(option));
	}
	
	public static void scrollToElement(String locator){
		WebElement element=getElement(locator);
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].scrollIntoView(true);",element);
		
	}
	
	public static void selectFutureDate(){
		DateFormat dateFormat = new SimpleDateFormat("MM/d/yyyy");
	    Calendar cal = Calendar.getInstance();
	    cal.setTime(new Date());
	    cal.add(Calendar.DATE, 2);
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
		
		String calYear=getElement("//div[@class='-kony-w-c-table']/div[@class='-kony-w-c-row']/div[2]").getText();
		while(!calYear.contains(month) && !calYear.contains(year)){
			getElement("//div[@class='-kony-w-c-table']/div[@class='-kony-w-c-row']/div[3]").click();
		}
		getElement("//div[contains(@class,'weekday') and text()='"+date+"']").click();
		
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
		
		String calYear=getElement("//div[@class='-kony-w-c-table']/div[@class='-kony-w-c-row']/div[2]").getText();
		System.out.println("Calender title is -"+calYear);
		//&& !calYear.contains(year)
		while(!calYear.contains(month)){
			getElement("//div[@class='-kony-w-c-table']/div[@class='-kony-w-c-row']/div[3]/img").click();
			Thread.sleep(2000);
			calYear=getElement("//div[@class='-kony-w-c-table']/div[@class='-kony-w-c-row']/div[2]").getText();
		}
		getElement("//div[text()='"+date+"']").click();	
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
	
	public static String randomAmount(){
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
