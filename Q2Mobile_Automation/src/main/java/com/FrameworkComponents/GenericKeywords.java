package com.FrameworkComponents;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;
import java.util.Random;

import javax.mail.BodyPart;
import javax.mail.Flags;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.internet.MimeMultipart;

import org.apache.commons.io.FileUtils;
import org.jsoup.Jsoup;
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
	
	public static String getRandom(){
		int num=(int)(Math.random()*100);
		return Integer.toString(num);
	}
	
	public static void selectFutureDate(int days,int index) throws InterruptedException{
		
		DateFormat dateFormat = new SimpleDateFormat("MMMM/d/yyyy");
	    Calendar cal = Calendar.getInstance();
	    cal.setTime(new Date());
	    cal.add(Calendar.DATE, days);
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
		
		String calMonth=getElement("//android.webkit.WebView[@content-desc='TDECU']/android.view.View[@index='"+index+"']/android.view.View[@index='1']").getAttribute("name");
		String calYear=getElement("//android.webkit.WebView[@content-desc='TDECU']/android.view.View[@index='"+index+"']/android.view.View[@index='4']").getAttribute("name");
		System.out.println("Calender title is -"+calMonth);
		//&& !calYear.contains(year)
		while(!calMonth.contains(month)){
			getElement("//android.webkit.WebView[@content-desc='TDECU']/android.view.View[@index='"+index+"']/android.view.View[@index='2']/android.view.View[@content-desc='']").click();
			Thread.sleep(2000);
			 calYear=getElement("//android.webkit.WebView[@content-desc='TDECU']/android.view.View[@index='"+index+"']/android.view.View[@index='4']").getAttribute("name");
		}
		getElement("//android.view.View[@content-desc='"+date+"']").click();
		
		
	}
	
	public static void selectAlertDate(int days){
		DateFormat dateFormat = new SimpleDateFormat("MMMM/d/yyyy");
	    Calendar cal = Calendar.getInstance();
	    cal.setTime(new Date());
	    cal.add(Calendar.DATE, days);
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
		getElement("//android.widget.Button[contains(@content-desc,'"+date+"')]").click();
	}
	
public static void selectStopPaymentFutureDate(int days,int index) throws InterruptedException{
		
		DateFormat dateFormat = new SimpleDateFormat("MMMM/d/yyyy");
	    Calendar cal = Calendar.getInstance();
	    cal.setTime(new Date());
	    cal.add(Calendar.DATE, days);
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
		
		String calMonth=getElement("//android.webkit.WebView[@content-desc='TDECU']/android.view.View[@index='"+index+"']/android.view.View[@index='1']/android.view.View[@index='1']").getAttribute("name");
		String calYear=getElement("//android.webkit.WebView[@content-desc='TDECU']/android.view.View[@index='"+index+"']/android.view.View[@index='1']/android.view.View[@index='4']").getAttribute("name");
		System.out.println("Calender title is -"+calMonth);
		//&& !calYear.contains(year)
		while(!calMonth.contains(month)){
			getElement("//android.webkit.WebView[@content-desc='TDECU']/android.view.View[@index='"+index+"']/android.view.View[@index='1']/android.view.View[@index='2']/android.view.View[@content-desc='']").click();
			Thread.sleep(2000);
			 calYear=getElement("//android.webkit.WebView[@content-desc='TDECU']/android.view.View[@index='"+index+"']/android.view.View[@index='1']/android.view.View[@index='4']").getAttribute("name");
		}
		getElement("//android.view.View[@content-desc='"+date+"']").click();
		
		
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
	
	public static void Submitamount(String amnt,String locator) throws InterruptedException{
		char[] varArr = amnt.trim().toCharArray();
		for(int i=varArr.length-1;i>=0;i--){
			String str=Character.toString(varArr[i]);
			getElement(locator).sendKeys(str);
			Thread.sleep(1000);
		}
		
	}
	
	public static void clickElement(String locator) throws InterruptedException{
		for(int i=1;i<10;i++){
		try{	
		
		int x=getElement(locator).getLocation().getX();
		x=x+10;
   		int y=getElement(locator).getLocation().getY();
   		TouchAction act1=new TouchAction(driver);
   		act1.tap(x,y).perform();
   	
   	
		Thread.sleep(2000);
		break;
		}catch(Exception e){
			scrollToElement(1);
		}
		}
	}
	
	public static void scrollTillElement(String locator) throws InterruptedException{
		for(int i=1;i<10;i++){
		try{	
			WebDriverWait wait = new WebDriverWait(driver, 2); 
			WebElement		element = (WebElement) wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
		Thread.sleep(2000);
		break;
		}catch(Exception e){
			scrollToElement(1);
		}
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
	
	public static void scrollToElement(int loopCount) throws InterruptedException{
		
		for(int i=1;i<=loopCount;i++)
		{
			
				Dimension dim = driver.manage().window().getSize();
				int height = dim.getHeight();
				int width = dim.getWidth();
				int x = width/2;
				int top_y = (int)(height*0.65);
				int bottom_y = (int)(height*0.35);
				System.out.println("coordinates :" + x + "  "+ top_y + " "+ bottom_y);
				TouchAction ts = new TouchAction(driver);
				ts.press(x, top_y).moveTo(x, bottom_y).release().perform();	
				Thread.sleep(2000);
			}	
	}
	
	public static void scrollUp(int loopcount) throws InterruptedException{
		for(int i=1;i<=loopcount;i++)
		{
			
				Dimension dim = driver.manage().window().getSize();
				int height = dim.getHeight();
				int width = dim.getWidth();
				int x = width/2;
				int top_y = (int)(height*0.35);
				int bottom_y = (int)(height*0.65);
				System.out.println("coordinates :" + x + "  "+ top_y + " "+ bottom_y);
				TouchAction ts = new TouchAction(driver);
				ts.press(x, top_y).moveTo(x, bottom_y).release().perform();	
				Thread.sleep(2000);
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
	
	public static String fetchOutlookOTP() throws MessagingException, IOException{
		String hostName = "outlook.office365.com";
		String username = "sravya.vagalaboina@eaglecrk.com";
		String password = "Queen@02";
		int messageCount;
		int unreadMsgCount;
		String emailSubject;
		Message emailMessage;
		String ActOTP=null;
		
		Properties sysProps = System.getProperties();
	    sysProps.setProperty("mail.store.protocol", "imaps");
	    Session session = Session.getInstance(sysProps, null);
        Store store = session.getStore();
        store.connect(hostName, username, password);
        Folder emailInbox = store.getFolder("Inbox");
        emailInbox.open(Folder.READ_WRITE);
        messageCount = emailInbox.getMessageCount();
        System.out.println("Total Message Count: " + messageCount);
        
        unreadMsgCount = emailInbox.getNewMessageCount();
        System.out.println("Unread Emails count:" + unreadMsgCount);
        emailMessage = emailInbox.getMessage(messageCount);
        emailSubject = emailMessage.getSubject();
        
        MimeMultipart mp=(MimeMultipart )emailMessage.getContent(); 
        int count=mp.getCount();
        
        for(int i=0;i<1;i++){
        BodyPart  bp=mp.getBodyPart(i);
        System.out.println("BP content type is -"+bp.getContentType());
       // System.out.println("BP despos type is -"+bp.getDisposition());
        
        if(bp.getContent().toString().contains("secure access code")){
        	 //System.out.println("OTP messages are- "+bp.getContent());
        	String htmlpart=(String)bp.getContent(); 
        	String otp=Jsoup.parse(htmlpart).text();
        	System.out.println("OTP messages are - "+otp);
        	//otp.substring(otp.lastIndexOf("access code is") + 1, otp.indexOf("This mail has been"));
        	 ActOTP=otp.substring(35, 41);
        	System.out.println("Actual OTP messages are - "+ActOTP);
        	 
        	
        }

        }
        
        emailMessage.setFlag(Flags.Flag.SEEN, true);
        emailInbox.close(true);
        store.close();
        return ActOTP;
	}

}
