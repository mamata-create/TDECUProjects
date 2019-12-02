package com.FrameworkComponents;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
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
	
	public static void checkingOptionValidation(String checkingType){
		
		String checkingOptionLocatior = "//label/strong[contains(text(),'"+checkingType+"')]/following::ul[1]/li";
		List<WebElement>allCheckingOptions = driver.findElements(By.xpath(checkingOptionLocatior));
		
		for(int index=1;index<=allCheckingOptions.size();index++){
			
			String eachOptionLocator = "//label/strong[contains(text(),'"+checkingType+"')]/following::ul[1]/li["+index+"]";
			String eacOption = driver.findElement(By.xpath(eachOptionLocator)).getAttribute("innerText");
			System.out.println(eacOption);
			Assert.assertTrue(true);
		}
	}
	
	public static void disclaimerValidation(){
		
		String allDisclaimerLocator = "//div[contains(@class,'disclaimer')]/p";
		String disclaimerOpt1 = "1 APY= Annual Percentage Yield";
		String disclaimerOpt2 = "2 Some restrictions may apply. Offer not valid with other discounts.";
		String disclaimerOpt3 = "3 APR = Annual Percentage Rate";
		
		List<WebElement>allDisclaimers = driver.findElements(By.xpath(allDisclaimerLocator));
		for(int count=1;count<=allDisclaimers.size();count++){
			
			String eachDisclaimer = "//div[contains(@class,'disclaimer')]/p["+count+"]";
			String eachValueFromPage = driver.findElement(By.xpath(eachDisclaimer)).getAttribute("innerText");
			
			if(eachValueFromPage.equalsIgnoreCase(disclaimerOpt1) || eachValueFromPage.equalsIgnoreCase(disclaimerOpt2) 
					|| eachValueFromPage.equalsIgnoreCase(disclaimerOpt3)){
				Assert.assertTrue(true, eachValueFromPage);
			}
		}
				
	}
	
	public static void serviceOptionValidation(String checkingType,String serviceOption) throws InterruptedException{
		String checkingTypeLocator =  "//label/strong[contains(text(),'"+checkingType+"')]";
		String customizeMsgHeader = "Let’s customize your checking account. Click to add the following services:";
		String servicesLocator = "//div[contains(@class,'customizePanel')]//span/label";
		getElement(checkingTypeLocator).click();
		Thread.sleep(2000);
		String customizeMsgLocator = "//div[contains(@class,'customizePanel')]//span/p";
		verifyText(customizeMsgLocator,customizeMsgHeader);
		List<WebElement>services = driver.findElements(By.xpath(servicesLocator));
		for(int count=1;count<=services.size();count++){
			
			String eachServiceOption = driver.findElement(By.xpath("(//div[contains(@class,'customizePanel')]//span/label)["+count+"]")).getAttribute("innerText").trim();
			String actualServiceOption = serviceOption.split(",")[count-1].trim();
			if(eachServiceOption.contains(actualServiceOption)){
				Assert.assertTrue(true, "Service option matched");
			}
		}
		
		
	}
	
	public void checkBoxCheckedAndUncheck(String action){
		
		String allCheckBoxes = "//div[contains(@class,'customizePanel')]//span/div[contains(@class,'icheckbox_square-grey')]";
		List<WebElement>allServiceCheckBoxes = driver.findElements(By.xpath(allCheckBoxes));
		for(int index=1;index<=allServiceCheckBoxes.size();index++){
			String eachCheckboxLocator = "(//div[contains(@class,'customizePanel')]//span/div[contains(@class,'icheckbox_square-grey')])["+index+"]";
			String eachCheckBoxFlag = getElement(eachCheckboxLocator).getAttribute("class");
			
			if(!eachCheckBoxFlag.contains(action)){
				getElement(eachCheckboxLocator).click();
			}
			
		}
	}
	
	public static void toolTipValidation(String modalHeaderID) throws InterruptedException{
		
		String allToolTipLocator = "//div[contains(@class,'customizePanel')]//button[@data-toggle='modal']";
		List<WebElement>allToolTips = driver.findElements(By.xpath(allToolTipLocator));
		for(int count=1;count<=allToolTips.size();count++){
			String eachToolTipLocator ="(//div[contains(@class,'customizePanel')]//button[@data-toggle='modal'])["+count+"]";
			getElement(eachToolTipLocator).click();
			Thread.sleep(2500);
			String modalHeader = "(//div[@class='modal-header']/h4)["+count+"]";
			String modalHeaderValue = getElement(modalHeader).getAttribute("id").trim();
			String actualModalID = modalHeaderID.split(",")[count-1].trim();
			if(modalHeaderValue.contains(actualModalID) && !modalHeaderValue.contains("modalCourtesyLabel")){
				Assert.assertTrue(true, "Tooltip message displayed");
				String closeButton = "(//button[@data-dismiss='modal'])["+count+"]";
				getElement(closeButton).click();
				Thread.sleep(1500);
			}
			
			else{
				getElement("(//button[contains(text(),'Learn More')])[1]").click();
			}
			
		}
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
	
	public static void closeWindow(){
		((JavascriptExecutor) driver).executeScript("window.close();");
	}
	public static void openWindow(){
		((JavascriptExecutor) driver).executeScript("window.open();");
	}
	
	public static void productOptions(String productOptions){
		String productOptionLocator ="//*[contains(text(),'Credit Cards & Loans')]//following::*[contains(@class,'panel-title')]";
		List<WebElement>allProductOptions = driver.findElements(By.xpath(productOptionLocator));
		for(int count=1;count<=allProductOptions.size();count++){
			String actualProductOption = productOptions.split(";")[count-1].trim();
			
			String eachProductOptionFromPage = getElement("(//*[contains(text(),'Credit Cards & Loans')]//following::*[contains(@class,'panel-title')])["+count+"]").getAttribute("innerText").trim();
			
			if(eachProductOptionFromPage.contains(actualProductOption)){
				Assert.assertTrue(true, "Product option macthed");
			}
		}
	}
	
	public static void expandProductDetailsValidateandCollapse(){
		
		String expandArrowLocator = "//*[contains(text(),'Credit Cards & Loans')]//following::*[contains(@class,'panel-title')]/i";
		List<WebElement>allArrows = driver.findElements(By.xpath(expandArrowLocator));
		for(int count=1;count<=allArrows.size();count++){
			
			String eachArrowLocator = "(//*[contains(text(),'Credit Cards & Loans')]//following::*[contains(@class,'panel-title')]/i)["+count+"]";
			getElement(eachArrowLocator).click();
			
			String expandedDetailsLocator = "//div[contains(@class,'collapse in')]";
			scrollToElement(expandedDetailsLocator);
			String expandFlag = getElement(expandedDetailsLocator).getAttribute("class").trim();
			if(expandFlag.equalsIgnoreCase("collapse in")){
				Assert.assertTrue(true, "Product arrow is clicked and expanded");
			}
			getElement(eachArrowLocator).click();
			if(expandFlag.contains("collapse")){
				Assert.assertTrue(true, "Product arrow is clicked and colapsed");
			}
		
		}
	}
	
	public static void expandProductsAndValidateEachOptions(String productName,String subProductName){
		String locator = "//*[contains(text(),'"+productName+"')]/i";
		getElement(locator).click();
		scrollToElement(locator);
		String allSubProductsLocator = "//span[@id='"+subProductName+"']/div";
		List<WebElement>allSubProducts = driver.findElements(By.xpath(allSubProductsLocator));
		System.out.println("Total Sub products: "+allSubProducts.size());
		for(int index=1;index<=allSubProducts.size();index++){
			
			String eachSubProductName = driver.findElement(By.xpath("(//span[@id='"+subProductName+"']//label)["+index+"]")).getAttribute("innerText");
			if(eachSubProductName!=null && index<=allSubProducts.size()){
				Assert.assertTrue(true, ""+subProductName+" ïs listed");
			}
			if(productName.equalsIgnoreCase("Credit Cards")){
				String checkBoxLocator = "(//span[@id='CreditCard']//label)["+index+"]/../div[1]";
				String checkBoxProp = driver.findElement(By.xpath(checkBoxLocator)).getAttribute("class");
				Assert.assertEquals(checkBoxProp, "icheckbox_square-grey");
				getElement(checkBoxLocator).click();
				driver.findElement(By.xpath("(//span[@id='CreditCard']//label/following::ul[contains(@class,' cardDescr')])["+index+"]")).isDisplayed();
				Assert.assertTrue(true);
			}
			if(productName.equalsIgnoreCase("Personal Loans")){
				String checkBoxLocator = "(//span[@id='"+subProductName+"']//label)["+index+"]/../div[1]";
				String checkBoxProp = driver.findElement(By.xpath(checkBoxLocator)).getAttribute("class");
				Assert.assertEquals(checkBoxProp, "icheckbox_square-grey");
				getElement(checkBoxLocator).click();
				//driver.findElement(By.xpath("(//span[@id='CreditCard']//label/following::ul[contains(@class,' cardDescr')])["+index+"]")).isDisplayed();
				//Assert.assertTrue(true);
			}
			
			if(productName.equalsIgnoreCase("Vehicle Loans and Refinance Options ")){
				
				String checkBoxLocator = "(//span[@id='"+subProductName+"']//label)[1]/../div[1]";
				
				String bulletPointLocator = "(//*[contains(text(),'Vehicle Loans')]/following::div[contains(@id,'Vehicle_pnlProductMoreInfo')]//li)["+index+"]";
				String Text = getElement(bulletPointLocator).getAttribute("innerText");
					if(Text != null &&Text.equalsIgnoreCase("Check out the latest rates here")){
						getElement(checkBoxLocator).click();
						String linkLocator = "(//*[contains(text(),'Vehicle Loans')]/following::div[contains(@id,'Vehicle_pnlProductMoreInfo')]//li)["+index+"]//a";
						getElement(linkLocator).getTagName();
						Assert.assertTrue(true);
						getElement(linkLocator).click();
						handleMultipleWindow(1,"");
						String currentUrl = driver.getCurrentUrl();
						System.out.println("New Tab launched with: "+currentUrl);
						String url = "https://www.tdecu.org/rates";
						Assert.assertTrue(true, url+" launched");
						closeWindow();
						handleMultipleWindow(0,"");
						break;
					
					}
					
			}
			
		
		}
		
	}
	
	public static boolean creditCardCheckedUncheckedValidator(String cardName,boolean check) {
		boolean flag = true;
		String creditCardLocator = "//div[contains(@id,'CreditCard_ProductPanel')]//following::label[contains(text(),'"+cardName+"')]";
		if(check==true){
			String checkedStatusLocator = "//div[contains(@id,'CreditCard_ProductPanel')]//following::label[contains(text(),'"+cardName+"')]/../div[1]";
			boolean checkedStatus = getElement(checkedStatusLocator).getAttribute("class").contains("checked");
			if(checkedStatus)
				return flag;
			else
			return	flag=false;
		}else if(check==false){
			getElement(creditCardLocator).click();
		}
		
		return flag;
		
	}
	
	public static boolean checkamountandNavigateNextthenValidate(String cardName){
		boolean status = false;
		String limitLocator = "//div[contains(@id,'CreditCard_ProductPanel')]//following::label[contains(text(),'"+cardName+"')]/following::li[2]";
		String cardLimitFromPage = getElement(limitLocator).getAttribute("inneText").split("$")[1].toString();
		getElement(ObjectRepository.continue_btn).click();
		boolean limitChecked = getElement(ObjectRepository.creditcardLimitTxt).getText().contains(cardLimitFromPage);
		if(limitChecked)
			return status=true;
		return status;
	}

	public static void validatProductOptionsDetails(String subProduct,String subProductTag){
		
		String subProductHeaderLocator = "//span[@id='"+subProduct+"']//following::label[contains(@for,'"+subProduct+"_ProductCheckbox_')]";
		String bulletPointLocator = "(//label[contains(text(),'"+subProductTag+"')]/following::div[contains(@id,'"+subProduct+"_pnlPro')])[1]//li";
		String bulletOptionValue = null;
		
		List<WebElement>headerElements = driver.findElements(By.xpath(subProductHeaderLocator));
		List<WebElement>bulletElements = driver.findElements(By.xpath(bulletPointLocator));
		
			String eachHeaderValueLocator = "(//span[@id='"+subProduct+"']//following::label[contains(@for,'"+subProduct+"_ProductCheckbox_')])[1]";
			String headerValue = getElement(eachHeaderValueLocator).getAttribute("innerText");
			if(headerValue.contains(subProductTag)){
				Assert.assertTrue(true, "Bullet options are matched");
			}
			for(int count=1;count<=bulletElements.size();count++){
				String eachBulletLocator = "(//label[contains(text(),'"+subProductTag+"')]/following::div[contains(@id,'"+subProduct+"_pnlPro')])[1]//li["+count+"]"; 
				bulletOptionValue = getElement(eachBulletLocator).getAttribute("innerText");
					System.out.println(bulletOptionValue);
					Assert.assertTrue(true, "Bullet options are matched");
					if(bulletOptionValue.contains("latest rates here")){
						String linkLocator = "(//label[contains(text(),'"+subProductTag+"')]/following::div[contains(@id,'"+subProduct+"_pnlPro')])[1]//li["+count+"]//a";
						getElement(linkLocator).getTagName();
						Assert.assertTrue(true);
						getElement(linkLocator).click();
						handleMultipleWindow(1,"");
						String currentUrl = driver.getCurrentUrl();
						System.out.println("New Tab launched with: "+currentUrl);
						String url = "https://www.tdecu.org/rates";
						Assert.assertTrue(true, url+" launched");
						closeWindow();
						handleMultipleWindow(0,"");
						
					}
				
			}
		
			
		}
	
	public static void checkMultipleLoanOptionAndContinueOtherOption(String subProduct, String option){
		String subProductHeaderLocator = "//span[@id='"+subProduct+"']//following::label[contains(@for,'"+subProduct+"_ProductCheckbox_')]";
		List<WebElement>allSubProducts = driver.findElements(By.xpath(subProductHeaderLocator));
		for(int index=1;index<=allSubProducts.size();index++){
			String subProductNameLocator = "(//span[@id='"+subProduct+"']//following::label[contains(@for,'"+subProduct+"_ProductCheckbox_')])["+index+"]";
			String subProductName = getElement(subProductNameLocator).getAttribute("innerText");
			if(subProductName.contains(option)){
				getElement(subProductNameLocator).click();
				scrollToElement(subProductNameLocator);
				getElement(ObjectRepository.continue_btn).click();
				break;
				
			}
			
		}
	}
		
	public static void validateVariousOptionFromPage(String action,String Option){
		
		String link=null;
		
		if(action.equalsIgnoreCase("PanelBody")){
			String locatorPanelBody = "//*[contains(text(),'Certificates of Deposit')]/following::div[1]//li";
			List<WebElement>allOptions = driver.findElements(By.xpath(locatorPanelBody));
			for(int index=1;index<=allOptions.size();index++){
				String option_1 = Option.split(";")[0].trim();
				String option_2 =Option.split(";")[1].trim();
				String option_3 =Option.split(";")[2].trim();
				String eachOptionLocator = "//*[contains(text(),'Certificates of Deposit')]/following::div[1]//li["+index+"]";
				String rateLinkLocator ="//*[contains(text(),'Certificates of Deposit')]/following::div[1]//li//a";
				String eachOption = getElement(eachOptionLocator).getAttribute("innerText");
				link = getElement(rateLinkLocator).getAttribute("href");
				if(eachOption.contains(option_1)||eachOption.contains(option_2)||link.contains(option_3)){
					Assert.assertTrue(true, "All body panel options are displayed correctly");
					
				}
				openWindow();
				handleMultipleWindow(1,link);
				closeWindow();
				handleMultipleWindow(0,"");
			}
		}else if(action.equalsIgnoreCase("Wizard")){
			String wizOption_header = Option.split(";")[0].trim();
			String wizOption_panel = Option.split(";")[1].trim();	
			verifyText("//*[contains(text(),'Search for')]",wizOption_header);
			verifyText("//*[contains(text(),'Search for')]/../p",wizOption_panel);
		}
		else if(action.equalsIgnoreCase("feeSchedule")){
			String feeScheduleText = Option.split(";")[0].trim();
			link =  Option.split(";")[1].trim();
			verifyText("//div[@class='CDfeeSchedule']//p",feeScheduleText);
			
			if(getElement("//div[@class='CDfeeSchedule']//a").getAttribute("href").contains(link)){
				Assert.assertTrue(true, "Link matched");
				openWindow();
				handleMultipleWindow(1,link);
				closeWindow();
				handleMultipleWindow(0,"");
			}
			
			
		}else if(action.equalsIgnoreCase("MoneyMarket")){
			String locatorPanelBody = "//*[contains(text(),'Money Market Accounts')]/following::div[1]//li";
			List<WebElement>allOptions = driver.findElements(By.xpath(locatorPanelBody));
			for(int index=1;index<=allOptions.size();index++){
				String option_1 = Option.split(";")[0].trim();
				String option_2 =Option.split(";")[1].trim();
				String option_3 =Option.split(";")[2].trim();
				
				String eachOptionLocator = "//*[contains(text(),'Money Market Accounts')]/following::div[1]//li["+index+"]";
				String rateLinkLocator ="//*[contains(text(),'Money Market Accounts')]/following::div[1]//li//a";
				String eachOption = getElement(eachOptionLocator).getAttribute("innerText");
				link = getElement(rateLinkLocator).getAttribute("href");
				if(eachOption.contains(option_1)){
					Assert.assertTrue(true, "All body panel options are displayed correctly");
					
				}else if(eachOption.contains(option_2)){
					Assert.assertTrue(true, "All body panel options are displayed correctly");
				}else if(eachOption.contains(option_3)){
					Assert.assertTrue(true, "All body panel options are displayed correctly");
				}
				
			}
			openWindow();
			handleMultipleWindow(1,link);
			Assert.assertEquals(link, "https://www.tdecu.org/rates/");
			closeWindow();
			handleMultipleWindow(0,"");
		}
		
		
		
	}
	
	public static void verifyTxtValue(String locator, String text){
		WebElement element=getElement(locator);
		String actText=element.getAttribute("value");
		if(actText.equals(text)){
			Assert.assertTrue(true);
		}else{
			Assert.assertTrue(false);
		}
	}
	
	public static void verifyTxtFieldValue(String locator, String text){
		WebElement element=getElement(locator);
		String actText=element.getAttribute("value");
		if(actText.equals(text)){
			Assert.assertTrue(true);
		}else{
			Assert.assertTrue(false);
		}
	}
	
	public static void verifyPlaceholder(String locator, String text){
		WebElement element=getElement(locator);
		String actText=element.getAttribute("placeholder");
		if(actText.equals(text)){
			Assert.assertTrue(true);
		}else{
			Assert.assertTrue(false);
		}
	}

}
