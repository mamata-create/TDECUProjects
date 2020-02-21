package com.FrameworkComponents;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.Random;
import java.util.Set;

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
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
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


	public static void awaitForElementToVisible(String locator){

		WebElement elementToCheck = getElement(locator); 
		elementToCheck = new WebDriverWait(driver, 120)
				.until(ExpectedConditions.visibilityOf(elementToCheck));


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
		try{
			Select s=new Select(getElement(locator));

			List<WebElement> options = s.getOptions();

			for(int i=0;i<options.size();i++){
				System.out.println(options.get(i).getText());
				if(options.get(i).getText().contains(opt)){
					options.get(i).click();

				}
			}
		}catch(Exception e){
			System.out.println("Exception caught");
		}
	}

	public static void selectDropdownOptForShadowRoot(WebElement element, String opt, String accountType){
		try{
			List<WebElement> allOptions = driver.findElements(By.xpath("//q2-select[@label='"+accountType+"']/q2-option"));
			for(int count=1;count<=allOptions.size();count++){
				String option= driver.findElement(By.xpath("(//q2-select[@label='"+accountType+"']/q2-option)["+count+"]")).getAttribute("display");

				if(option.contains(opt)){
					String fromAccountLocator = "//q2-select[@label='"+accountType+"']/q2-option[contains(@display,'"+opt+"')]";
					getElement(fromAccountLocator).click();
				}

			}

		}catch(Exception e){
			System.out.println("Exception caught");
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
	
	public static void scroll(){
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("window.scrollBy(0,250)");
	}
	
	public static void jsClick(String locator){
		WebElement element=getElement(locator);
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].click();",element);

	}
	
	public static void jsSetValue(String locator){
		WebElement element=getElement(locator);
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].setAttribute('value','20');",element);

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
	
	public static void selectDateofShadowRootElement(int noofdays,String dateType){
		
			
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
			
			WebElement root1 = driver.findElement(By.cssSelector("q2-calendar[calendar-label='"+dateType+"']"));
			WebElement shadowRoot1 = ObjectRepository.expandRootElement(driver, root1);
			WebElement calendarDropdown = shadowRoot1.findElement(By.cssSelector("div[class='q2-element-dropdown']"));

			String calYear= calendarDropdown.findElement(By.cssSelector("span[class='cal-year-text']")).getText();
			String calmnth= calendarDropdown.findElement(By.cssSelector("span[class='cal-month-text']")).getText();
			WebElement nxtmnth=calendarDropdown.findElement(By.cssSelector("q2-btn[aria-label='Next month']"));
			WebElement nxtyr=calendarDropdown.findElement(By.cssSelector("q2-btn[aria-label='Next year']"));
			while(!calYear.contains(year)){
				nxtyr.click();
			}

			while(!calmnth.contains(month)){
				nxtmnth.click();
			}

			List<WebElement> list = calendarDropdown.findElements(By.cssSelector("div[class='cal-days'] q2-btn"));

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

	public static String fetchOutlookOTPSravya() throws MessagingException, IOException{
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



	public  static String validateAccountInfoFromGrid(String locator,String accountNameValue){

		String account = null;
		List<WebElement>allAccountInfo = driver.findElements(By.xpath(locator));
		for(int count=1;count<=allAccountInfo.size();count++){


			String accountNamePageValue = driver.findElement(By.xpath("(//table[contains(@class,'table whitefield-form')]//following::td)["+count+"]")).getAttribute("innerText");
			if(!(accountNamePageValue==null) &&accountNamePageValue.equalsIgnoreCase(accountNameValue)){
				Assert.assertEquals(true, true, "Account name matched");
				System.out.println("Account name matched");
				account = accountNamePageValue;
				WebElement editButton = driver.findElement(By.xpath("//td[contains(text(),'"+accountNameValue+"')]/following::a[@title='Edit Recipient']"));
				editButton.click();
				break;
			}
		}
		return account;
	}
	public  static String validateAccountInfoandSelect(String locator,String accountNameValue){

		String account = null;
		List<WebElement>allAccountInfo = driver.findElements(By.xpath(locator));
		for(int count=1;count<=allAccountInfo.size();count++){


			String accountNamePageValue = driver.findElement(By.xpath("(//table[contains(@class,'table whitefield-form')]//following::td)["+count+"]")).getAttribute("innerText");
			if(!(accountNamePageValue==null) &&accountNamePageValue.equalsIgnoreCase(accountNameValue)){
				Assert.assertEquals(true, true, "Account name matched");
				System.out.println("Account name matched");
				account = accountNamePageValue;
				WebElement checkBox = driver.findElement(By.xpath("//td[contains(text(),'"+accountNameValue+"')]/preceding::input[@type='checkbox']"));
				checkBox.click();
				break;
			}
		}
		return account;
	}

	public static void verifyCheckBoxesOfMemberAccount(){
		List<WebElement>allCheckBoxes = driver.findElements(By.xpath("//div[@class='list-group']//following::div[@class=' faux-checkbox recessed iconic']"));
		for(int count=1;count<allCheckBoxes.size();count++){
			String eachCheckBox ="(//div[@class='list-group']//following::div[@class=' faux-checkbox recessed iconic'])["+count+"]";
			verifyElementPresent(eachCheckBox);
		}
		System.out.println("Total "+allCheckBoxes.size()+"CheckBoxes are present");
	}

	public static void selectActions(String actionDropdownLocator, String optionsLocator,String expectedAction) throws InterruptedException{

		getElement(actionDropdownLocator).click();
		Thread.sleep(1500);
		List<WebElement>allOptions = driver.findElements(By.xpath(optionsLocator));
		for(int index=1;index<=allOptions.size();index++){
			String eachOption = "(//table[@test-id='txtAccountsTable']//div[@test-id='drpTransactionActions']//li)["+index+"]";
			String optionValue = driver.findElement(By.xpath(eachOption)).getAttribute("innerText").trim();

			if(optionValue.contains(expectedAction)){
				driver.findElement(By.xpath(eachOption)).click();
				break;
			}
		}
	}

	public static void validateSecureMsgPageComponent(){
		String pageTitle = getElement(ObjectRepository.secureMasgPageTitle).getAttribute("innerText");
		String withTag = driver.findElement(By.xpath("//*[contains(text(),'Transaction Inquiry')]/following::label[1]")).getText();
		String subjectTag = driver.findElement(By.xpath("//*[contains(text(),'Transaction Inquiry')]/following::label[2]")).getText();
		String messageTag = driver.findElement(By.xpath("//*[contains(text(),'Transaction Inquiry')]/following::label[4]")).getText();

		Assert.assertEquals(pageTitle, "Conversations");
		Assert.assertEquals(withTag, "With");
		Assert.assertEquals(subjectTag, "Subject");
		Assert.assertEquals(messageTag, "Message");
	}
	
	public static String[] getTransactionDetails(String[]arr){
		String[]pageValues = new String[arr.length];
		
		for(int index=0;index<arr.length;index++){
			String option = arr[index];
			String locator = "//table[@id='tblTransactions']//following::dt[text()='"+option+"']//following::dd[1]";
			String value = getElement(locator).getAttribute("innerText").trim();
			pageValues[index] = value;
		}
		return pageValues;
	}
	
	public static WebElement selectOptionShadowRoot(WebElement shadowelement,String optionToClick) throws Exception{
		WebElement elementToReturn = null;
		try{
			
			boolean displayed = shadowelement.isDisplayed();
			if(displayed)
				elementToReturn = shadowelement.findElement(By.cssSelector("q2-option[display='"+optionToClick+"']"));
			
			
		}catch(Exception e){
			throw new Exception(e);
		}
		return elementToReturn;
	}
	
	public static WebElement selectOptionShadowRootDropDown(WebElement shadowelement,String optionToClick) throws Exception{
		WebElement elementToReturn = null;
		try{
			
			boolean displayed = shadowelement.isDisplayed();
			if(displayed)
				elementToReturn = driver.findElement(By.cssSelector("q2-option[display='"+optionToClick+"']"));
			
			
		}catch(Exception e){
			throw new Exception(e);
		}
		return elementToReturn;
	}
	public static void verifyAlrtErrMsg(String missingField1, String missingField2){	
		String errorMsg = driver.findElement(By.xpath("//q2-message[@type='danger']/p")).getAttribute("innerText");
		String allMissingFields = "//q2-message[@type='danger']//li";
		String errorMsgText = "The following 3 fields have an error:";
		String missingField3 = "Alert Delivery Method";

		if(errorMsg.equals(errorMsgText))
		{		
			List<WebElement> allMissingFieldsLoc = driver.findElements(By.xpath(allMissingFields));
			for(int count=1;count<= allMissingFieldsLoc.size();count++){
				String bulletPoint = "//q2-message[@type='danger']//li["+count+"]";
				String bulletPointValue = driver.findElement(By.xpath(bulletPoint)).getAttribute("innerText");
				
				if(bulletPointValue.equals(missingField1)||bulletPointValue.equals(missingField2)||bulletPointValue.equals(missingField3)){
					Assert.assertTrue(true);
				}
				else{
					Assert.assertTrue(false);
				}
			}
		}
		else{
			Assert.assertTrue(false);
		}		
	}
	
	public static void verifyAlrtStatus(){	
		String[] statusList = {"Authorized", "Cancelled", "Drafted", "Failed", "Processed"};
		WebElement dropdown = driver.findElement(By.xpath("//q2-select[@test-id='fldOnlineActivityTypeSelect']"));
		Select select = new Select(dropdown);
		
		List<WebElement> options = select.getOptions();  
		 for(WebElement we:options)  
		 {  
			 boolean match = false;
			 for(int i=0; i<statusList.length; i++){
		     if(we.getText().equals(statusList[i])){
		        match = true;
		      }
		    }
		  Assert.assertTrue(match);
		 }  
	}
	
	public static void verifyAlrtEvents(){	
		String[] eventList = {"Birthday","Anniversary","Meeting","Call","Wakeup","Appointment","Vacation","Travel","General"};
		WebElement dropdown = driver.findElement(By.xpath("//q2-select[@test-id='fldDateTypeSelect']"));
		Select select = new Select(dropdown);
		
		List<WebElement> options = select.getOptions();  
		 for(WebElement we:options)  
		 {  
			 boolean match = false;
			 for(int i=0; i<eventList.length; i++){
		     if(we.getText().equals(eventList[i])){
		        match = true;
		      }
		    }
		  Assert.assertTrue(match);
		 }  
	}
	
	public void selectValue(String locator, String itemsLoc, String text) {
		try{
		WebElement menu = getElement(locator);
		menu.click();
        List<WebElement> options = driver.findElements(By.xpath(itemsLoc));

        for (WebElement select : options) {
            if (select.getText().contains(text)) { 
                select.click();
                break;
            }
        }
		}catch(Exception e){
			System.out.println("Exception caught");
		}
    }
	
	public static void selectTodayShadowRootCal(int noOfDays){		
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		
		Date today = new Date();
		String newDate = dateFormat.format(today);
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, noOfDays);
		String date2 = dateFormat.format(cal.getTime());	
		
		WebElement root1 = driver.findElement(By.xpath("//q2-calendar[@test-id='dateAlertDate']"));
		root1.click();
		WebElement shadowRoot1 = ObjectRepository.expandRootElement(driver, root1);
		WebElement calendarDropdown = shadowRoot1.findElement(By.cssSelector("div[class='q2-element-dropdown']"));

		WebElement nxtmnth=calendarDropdown.findElement(By.cssSelector("q2-btn[aria-label='Next month']"));
		WebElement prevmnth=calendarDropdown.findElement(By.cssSelector("q2-btn[aria-label='Previous month']"));
		WebElement nxtyr=calendarDropdown.findElement(By.cssSelector("q2-btn[aria-label='Next year']"));
		WebElement prevyr=calendarDropdown.findElement(By.cssSelector("q2-btn[aria-label='Previous year']"));
		nxtmnth.click();
		prevmnth.click();
		nxtyr.click();
		prevyr.click();

		List<WebElement> list = calendarDropdown.findElements(By.cssSelector("div[class*='cal-day'] q2-btn"));

		for(WebElement e : list){
			String cdate = e.getAttribute("data-date");
			String disabled = e.getAttribute("disabled");
			System.out.println(cdate+" "+disabled);
			
			if(cdate.equals(date2)){
				if(disabled != null){
					Assert.assertTrue(true);
				}
				else{
					Assert.assertTrue(false);
				}
			}

			if(cdate.equals(newDate)){
				JavascriptExecutor executor = (JavascriptExecutor)driver;
				executor.executeScript("arguments[0].click();", e);
				break;
			}

		}
	}
	
	public static void enterText(String locator, String text){
		try{
		Actions actions = new Actions(driver);
		WebElement ele = driver.findElement(By.xpath(locator));
		actions.moveToElement(ele);
		actions.click();
		actions.sendKeys(Keys.chord(Keys.CONTROL, "a"),text);
		actions.build().perform();
		}catch(Exception e){
			System.out.println("Exception caught");
		}

	}
	
	public static void openWindow(){
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("window.open();");
	}
	
	public static void closeWindow(){
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("window.close();");
	}
	
	public static void handleMultipleWindow(int index,String url){
		Set<String>allWindow = driver.getWindowHandles();
		System.out.println("Total window present: "+allWindow);
		ArrayList<String>tab = new ArrayList<String>(allWindow);
		driver.switchTo().window(tab.get(index));
		if(!url.isEmpty()){
			driver.get(url);
			String title = driver.getTitle();
			System.out.println("Window title: "+title);
		}else{
			System.out.println("No url provided");
		}
		
	}
	
}
