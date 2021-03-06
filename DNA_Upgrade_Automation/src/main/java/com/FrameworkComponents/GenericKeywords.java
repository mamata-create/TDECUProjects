package com.FrameworkComponents;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
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
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
/*import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;*/
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

	public static void verifyElementNotPresent(String locator){
		try{
			WebElement element=getElement(locator);
			boolean elementpresent=element.isDisplayed();
			if(elementpresent){
				System.out.println(locator +"- element present");
				Assert.assertFalse(false);


			}else{
				System.out.println(locator +"- element not present");
				Assert.assertTrue(true);

			}
		}catch(Exception e){
			System.out.println(locator +"- element not present with exception");
			Assert.assertTrue(true);

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

	public static void selectDropdownOptContain(String locator, String opt){
		Select s=new Select(getElement(locator));

		List<WebElement> options = s.getOptions();

		for(int i=0;i<options.size();i++){
			System.out.println(options.get(i).getText());
			if(options.get(i).getText().contains(opt)){
				options.get(i).click();

			}
		}
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

	public static void robotTab() throws AWTException{
		Robot robot = new Robot();
		System.out.println("Robot is in action");
		//		robot.mousePress(InputEvent.BUTTON1_MASK);
		//	    robot.mouseRelease(InputEvent.BUTTON1_MASK);
		// robot.keyPress(KeyEvent.VK_SHIFT);
		robot.keyPress(KeyEvent.VK_TAB);
		// robot.keyPress(KeyEvent.VK_SHIFT);
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_TAB);
		//	 robot.keyRelease(KeyEvent.VK_SHIFT);
		robot.keyRelease(KeyEvent.VK_ENTER);


	}

	public static void selectFutureDate(int noofdays) throws InterruptedException{
		Thread.sleep(2000);
		DateFormat dateFormat = new SimpleDateFormat("MMMM/d/yyyy");
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		cal.add(Calendar.DATE, noofdays);
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

		String calYear=getElement("//div[@test-id='txtYear']").getText();
		String calmnth=getElement("//div[@test-id='txtMonth']").getText();
		WebElement nxtmnth=getElement("//i[@test-id='iconNextMonth']");
		WebElement nxtyr=getElement("//i[@test-id='iconNextYear']");
		while(!calYear.contains(year)){
			nxtyr.click();
		}

		while(!calmnth.contains(month)){
			nxtmnth.click();
		}

		List<WebElement> list = driver.findElements(By.xpath("//div[@class='calendar-days clearfix']//div[contains(@class,'cal-day is-valid')]"));

		for(WebElement e : list){
			String cdate = e.getText();
			System.out.println("Date values -"+cdate);

			if(cdate.contains(date)){
				JavascriptExecutor executor = (JavascriptExecutor)driver;
				executor.executeScript("arguments[0].click();", e);
				// e.click();
				break;
			}

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

	public static String getRandom(){
		int num=(int)(Math.random()*100);
		return Integer.toString(num);
	}


	public static String fetchOutlookOTP() throws MessagingException, IOException{
		String hostName = "outlook.office365.com";
		String username = "divya.vagalaboina@eaglecrk.com";
		String password = "Srinivas@2";
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
			//System.out.println("Inbox messages are- "+bp.getContent());
		}
		//System.out.println("Inbox messages are- "+emailMessage.getContent().toString());


		// Pattern linkPattern = Pattern.compile("href=\"(.*)\"Q2e"); // here you need to define regex as per you need
		//        Matcher pageMatcher =
		//                linkPattern.matcher(emailMessage.getContent().toString());
		//
		//        while (pageMatcher.find()) {
		//            System.out.println("Found OTP " + pageMatcher.group(1));
		//        }
		//        
		//        Message[] messages=emailInbox.search(new SubjectTerm("Secure Banking: Requested information"), emailInbox.getMessages());
		//        
		//        for(Message msg:messages){
		//        	System.out.println("Messages are - "+msg.getDescription());
		//        }

		emailMessage.setFlag(Flags.Flag.SEEN, true);
		emailInbox.close(true);
		store.close();
		return ActOTP;
	}

	public static void selectCheckboxBasedonTerm(String selectedTerm){
		List<WebElement>terms = driver.findElements(By.xpath(ObjectRepository.termCheckBox));
		String termValue = driver.findElement(By.xpath(ObjectRepository.termCheckBox)).getAttribute("innerText");
		for(int count=1;count<=terms.size();count++){

			if(termValue.contains(selectedTerm)){
				String specificCheckbox = "(//div[contains(@style,'display: block')]//div[contains(@class,'icheckbox')])["+count+"]";
				getElement(specificCheckbox).click();
			}
		}
	}
	public static void jsclick(WebElement element){
		WebElement ele=element;
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", ele);
	}


	/*public static void invokeSikuli(String imageName, String action, String value) throws FindFailed {

		System.out.println("Sikuli invoked!");
		String filePathValue = System.getProperty("user.dir")+"/imageLocator/"+imageName;
		Screen screen = new Screen();
		Pattern imagePath = new Pattern(filePathValue);

		if(action.equalsIgnoreCase("type")){
			screen.type(imagePath, value);


		}else if(action.equalsIgnoreCase("click")){
			screen.click(imagePath);

		}

	}*/
	
	public static void validateStopPayment(){
		String errorMsg = "Stop Payment Failed";
		String successMsg ="Stop Payments Successful";
		By classname = By.className("modal-title");
		By viewInActivity = By.cssSelector("button[class='btn btn-default ']");
		String value = driver.findElement(classname).getText();
		System.out.println(value);
		
		if(value.equalsIgnoreCase(errorMsg)){
			Assert.assertEquals(false, true, "Test failed due to "+errorMsg);
		}
		
		else if(value.equalsIgnoreCase(successMsg)){
			Assert.assertEquals(true, true, "Test is passed with "+successMsg);
			driver.findElement(viewInActivity).click();
		}
		
	}
	
	public static void verifyStopPaymentValuesOnceSuccess(String payeeName, String amount, String checkno){
		
		By valueLocator = By.xpath("//ul[@class='list-unstyled']/li");
		List<WebElement>allValues = driver.findElements(valueLocator);
		
		for(int count=1;count<=allValues.size();count++){
			
			String locator = "//ul[@class='list-unstyled']/li["+count+"]";
			driver.findElement(By.xpath(locator));
		}
	}

}
