package com.FrameworkComponents;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.mail.BodyPart;
import javax.mail.Flags;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.internet.MimeMultipart;
import javax.mail.search.FlagTerm;

import org.apache.commons.io.FileUtils;
import org.jsoup.Jsoup;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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
				Assert.assertTrue(false);
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
		boolean match = false;
		for(int i=0;i<options.size();i++){
			//System.out.println(options.get(i).getText());
			if(options.get(i).getText().equals(opt)){
				match = true;
				//options.get(i).click();
			}
		}
		Assert.assertTrue(match);
	}
	
	public static void dDownOptNotPresent(String locator, String opt){
		Select s=new Select(getElement(locator));

		List<WebElement> options = s.getOptions();
		boolean noMatch = true;
		for(int i=0;i<options.size();i++){
			if(options.get(i).getText().contains(opt)){
				noMatch = false;
			}
		}
		Assert.assertTrue(noMatch);
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
			else{
				Assert.assertTrue(false);
			}
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
	
	public static void verifyTxtFieldValue(String locator, String text){
		WebElement element=getElement(locator);
		String actText=element.getAttribute("value");
		if(actText.equals(text)){
			Assert.assertTrue(true);
		}else{
			Assert.assertTrue(false);
		}
	}
	
	public static void verifyEmptyFieldValue(String locator){
		WebElement element=getElement(locator);
		Boolean emptyField=element.getAttribute("value").isEmpty();
		System.out.println(emptyField);
		if(emptyField = true){
			Assert.assertTrue(true);
		}else{
			Assert.assertTrue(false);
		}
	}
	
	public static void autoLoanInfoValidation(){
		
		String allLoanDescLocator = "//div[contains(@id,'MoreInfo_1004_1')]//ul[@class='fa-ul']/li";
		String loanDescOne = "No money down options available";
		String loanDescTwo = "Discounts for recurring direct deposits of $250 or more";
		String loanDescThree = "Terms as long as 72 months";
		String loanDescFour = "No hidden fees, costs or early payoff penalties";
		String loanDescFive = "Check out the latest rates here";
		
		List<WebElement>allLoanDescriptions = driver.findElements(By.xpath(allLoanDescLocator));
		for(int count=1;count<=allLoanDescriptions.size();count++){
			
			String eachDescription = "//div[contains(@id,'MoreInfo_1004_1')]//ul[@class='fa-ul']/li["+count+"]";
			String eachValueFromPage = driver.findElement(By.xpath(eachDescription)).getText();
			
			if(eachValueFromPage.equals(loanDescOne) || eachValueFromPage.equals(loanDescTwo) 
					|| eachValueFromPage.equals(loanDescThree)|| eachValueFromPage.equals(loanDescFour)|| eachValueFromPage.equals(loanDescFive)){
				Assert.assertTrue(true, eachValueFromPage);
			}
			else{
				Assert.assertTrue(false);
			}
		}
	}
	
	public static void autoRefinInfoValidation(){	
		String allLoanDescLocator = "//div[contains(@id,'MoreInfo_1252_1')]//ul[@class='fa-ul']/li";
		String loanDescOne = "Discounts for recurring direct deposits of $250 or more";
		String loanDescTwo = "No hidden fees, costs or early payoff penalties";
		String loanDescThree = "Check out the latest rates here";
		
		List<WebElement>allLoanDescriptions = driver.findElements(By.xpath(allLoanDescLocator));
		for(int count=1;count<=allLoanDescriptions.size();count++){
			
			String eachDescription = "//div[contains(@id,'MoreInfo_1252_1')]//ul[@class='fa-ul']/li["+count+"]";
			String eachValueFromPage = driver.findElement(By.xpath(eachDescription)).getText();
			
			if(eachValueFromPage.equals(loanDescOne) || eachValueFromPage.equals(loanDescTwo) 
					|| eachValueFromPage.equals(loanDescThree)){
				Assert.assertTrue(true, eachValueFromPage);
			}
			else{
				Assert.assertTrue(false);
			}
		}
	}
	
	public static void verifyHereLink(int x){
		String parentWindow = driver.getWindowHandle();
		driver.findElement(By.xpath("(//a[text()='here'])["+x+"]")).click();
		int count = driver.getWindowHandles().size();
		if(count == 2){
			for(String winHandle : driver.getWindowHandles()){
			    driver.switchTo().window(winHandle);
			}
			String title = driver.getTitle();
			driver.close();
			driver.switchTo().window(parentWindow);
			if(x <13)
				if(title.equals("Rates and Fees | TDECU"))
				{
					Assert.assertTrue(true);
				}
				else{
					Assert.assertTrue(false);
				}
			if(x==13)
				if(title.equals("Home Advantage Loan | TDECU"))
				{
					Assert.assertTrue(true);
				}
				else{
					Assert.assertTrue(false);
				}
		}else{
			Assert.assertTrue(false);
		}		
	}
	
	public static void stormLoanInfoValidation(){		
		String allLoanDescLocator = "//div[contains(@id,'MoreInfo_6449_1')]//ul[@class='fa-ul']/li";
		String loanDescOne = "Option for Members impacted by Tropical Storm Imelda";
		String loanDescTwo = "Loan amounts between $500 - $5,000";
		String loanDescThree = "Loan terms between 24 and 36 months (based on loan amount)";
		String loanDescFour = "Direct deposit required";
		String loanDescFive = "Check out the latest rates here";
		
		List<WebElement>allLoanDescriptions = driver.findElements(By.xpath(allLoanDescLocator));
		for(int count=1;count<=allLoanDescriptions.size();count++){
			
			String eachDescription = "//div[contains(@id,'MoreInfo_6449_1')]//ul[@class='fa-ul']/li["+count+"]";
			String eachValueFromPage = driver.findElement(By.xpath(eachDescription)).getText();
			
			if(eachValueFromPage.equals(loanDescOne) || eachValueFromPage.equals(loanDescTwo) 
					|| eachValueFromPage.equals(loanDescThree)|| eachValueFromPage.equals(loanDescFour)|| eachValueFromPage.equals(loanDescFive)){
				Assert.assertTrue(true, eachValueFromPage);
			}
			else{
				Assert.assertTrue(false);
			}
		}
	}
	
	public static void homeAdvLoanInfoValidation(){		
		String allLoanDescLocator = "//div[contains(@id,'MoreInfo_1420_1')]//ul[@class='fa-ul']/li";
		String loanDescOne = "Loan amounts between $1,000 - $35,000";
		String loanDescTwo = "No collateral required";
		String loanDescThree = "9.24% APR3";
		String loanDescFour = "Terms and conditions apply. Please click here for details.";
		
		List<WebElement>allLoanDescriptions = driver.findElements(By.xpath(allLoanDescLocator));
		for(int count=1;count<=allLoanDescriptions.size();count++){
			
			String eachDescription = "//div[contains(@id,'MoreInfo_1420_1')]//ul[@class='fa-ul']/li["+count+"]";
			String eachValueFromPage = driver.findElement(By.xpath(eachDescription)).getText();
			
			if(eachValueFromPage.equals(loanDescOne) || eachValueFromPage.equals(loanDescTwo) 
					|| eachValueFromPage.equals(loanDescThree)|| eachValueFromPage.equals(loanDescFour)){
				Assert.assertTrue(true, eachValueFromPage);
			}
			else{
				Assert.assertTrue(false);
			}
		}
	}
	
	public static void cash$tashLOCInfoValidation(){		
		String allLoanDescLocator = "//div[contains(@id,'MoreInfo_1007_1')]//ul[@class='fa-ul']/li";
		String loanDescOne = "Ideal for Members who prefer an alternative to a credit card";
		String loanDescTwo = "Minimum credit limit of $1,000";
		String loanDescThree = "May be leveraged as overdraft protection on your TDECU checking account";
		String loanDescFour = "Check out the latest rates here";
		
		List<WebElement>allLoanDescriptions = driver.findElements(By.xpath(allLoanDescLocator));
		for(int count=1;count<=allLoanDescriptions.size();count++){
			
			String eachDescription = "//div[contains(@id,'MoreInfo_1007_1')]//ul[@class='fa-ul']/li["+count+"]";
			String eachValueFromPage = driver.findElement(By.xpath(eachDescription)).getText();
			
			if(eachValueFromPage.equals(loanDescOne) || eachValueFromPage.equals(loanDescTwo) 
					|| eachValueFromPage.equals(loanDescThree)|| eachValueFromPage.equals(loanDescFour)){
				Assert.assertTrue(true, eachValueFromPage);
			}
			else{
				Assert.assertTrue(false);
			}
		}
	}
	
	public static void CDsecuredLoanInfoValidation(){		
		String allLoanDescLocator = "//div[contains(@id,'MoreInfo_1256_1')]//ul[@class='fa-ul']/li";
		String loanDescOne = "Borrow 100% of your certificate’s principal balance for a variety of terms";
		String loanDescTwo = "Minimum loan amount of $1,000";
		String loanDescThree = "Term is equal to your Certificate of Deposit maturity";
		String loanDescFour = "Check out the latest rates here";
		
		List<WebElement>allLoanDescriptions = driver.findElements(By.xpath(allLoanDescLocator));
		for(int count=1;count<=allLoanDescriptions.size();count++){
			
			String eachDescription = "//div[contains(@id,'MoreInfo_1256_1')]//ul[@class='fa-ul']/li["+count+"]";
			String eachValueFromPage = driver.findElement(By.xpath(eachDescription)).getText();
			
			if(eachValueFromPage.equals(loanDescOne) || eachValueFromPage.equals(loanDescTwo) 
					|| eachValueFromPage.equals(loanDescThree)|| eachValueFromPage.equals(loanDescFour)){
				Assert.assertTrue(true, eachValueFromPage);
			}
			else{
				Assert.assertTrue(false);
			}
		}
	}
	
	public static void verifyFeeScheduleLink(){
		String feeLinkText = "See fee schedule for details on early withdrawal penalties.";
		String parentWindow = driver.getWindowHandle();
		WebElement feeLink = driver.findElement(By.xpath("//div[contains(@class,'CDfeeSchedule')]//p"));
		String feeLinkPageText = feeLink.getText();
		driver.findElement(By.xpath("//a[text()='fee schedule']")).click();	
		int count = driver.getWindowHandles().size();
		if(feeLinkPageText.equals(feeLinkText))
		{
			if(count == 2){
				for(String winHandle : driver.getWindowHandles()){
					driver.switchTo().window(winHandle);
				}
				String title = driver.getTitle();
				driver.close();
				driver.switchTo().window(parentWindow);
				if(title.equals("Rates and Fees | TDECU"))
				{
					Assert.assertTrue(true);
				}
				else{
					Assert.assertTrue(false);
				}		
			}else{
				Assert.assertTrue(false);
			}
		}
		else{
			Assert.assertTrue(false);
		}
	}
	
	public static void verifyAllCdsDisplayed(){		
		String allCDsLocator = "//div[contains(@id,'CDWizard_ProductPanel') and contains(@style, 'block')]";
		
		List<WebElement>allCDsList = driver.findElements(By.xpath(allCDsLocator));
		int count=allCDsList.size();			
			if(count == 8){
				Assert.assertTrue(true);
			}
			else{
				Assert.assertTrue(false);
			}
	}
	public static void verifyAllCdsNotDisplayed(){		
		String allCDsLocator = "//div[contains(@id,'CDWizard_ProductPanel') and contains(@style, 'none')]";
		
		List<WebElement>allCDsList = driver.findElements(By.xpath(allCDsLocator));
		int count=allCDsList.size();			
			if(count == 8){
				Assert.assertTrue(true);
			}
			else{
				Assert.assertTrue(false);
			}
	}
	
	public static void verifyRatesLink(int x){
		String parentWindow = driver.getWindowHandle();
		driver.findElement(By.xpath("(//a[contains(text(),'rate')])["+x+"]")).click();
		int count = driver.getWindowHandles().size();
		if(count == 2){
			for(String winHandle : driver.getWindowHandles()){
			    driver.switchTo().window(winHandle);
			}
			String title = driver.getTitle();
			driver.close();
			driver.switchTo().window(parentWindow);
			if(title.equals("Rates and Fees | TDECU"))
			{
				Assert.assertTrue(true);
			}
			else{
				Assert.assertTrue(false);
			}
		}else{
			Assert.assertTrue(false);
		}		
	}
	
	public static void highYieldInfoValidation(){		
		String allProdDescLocator = "//div[contains(@id,'MoreInfo_6223_1')]//ul[@class='fa-ul']/li";
		String prodDescOne = "Higher APY1 on your TDECU Savings account";
		String prodDescTwo = "ATM rebates";
		String prodDescThree = "Free ID Theft Recovery services";
		String prodDescFour = "Free monthly FICO® credit score monitoring services";
		String prodDescFive = "Increased Courtesy Pay Limit";
		String prodDescSix = "Terms and conditions apply. Contact TDECU for complete details";
		
		List<WebElement>allProdDescriptions = driver.findElements(By.xpath(allProdDescLocator));
		for(int count=1;count<=allProdDescriptions.size();count++){
			
			String eachDescription = "//div[contains(@id,'MoreInfo_6223_1')]//ul[@class='fa-ul']/li["+count+"]";
			String eachValueFromPage = driver.findElement(By.xpath(eachDescription)).getText();
			
			if(eachValueFromPage.equals(prodDescOne) || eachValueFromPage.equals(prodDescTwo) 
					|| eachValueFromPage.equals(prodDescThree)|| eachValueFromPage.equals(prodDescFour)
					|| eachValueFromPage.equals(prodDescFive)|| eachValueFromPage.equals(prodDescSix)){
				Assert.assertTrue(true, eachValueFromPage);
			}
			else{
				Assert.assertTrue(false);
			}
		}
	}
	
	public static void verifyCourtesyPayPDF(){
		String pdfText = "Courtesy-Pay-Opt-In-Form-English.pdf";
		String parentWindow = driver.getWindowHandle();
		driver.findElement(By.xpath("//*[@id='modalCourtesyMember']/div/div/div[3]/a/button")).click();		
		int count = driver.getWindowHandles().size();
		if(count == 2){
			for(String winHandle : driver.getWindowHandles()){
				driver.switchTo().window(winHandle);
			}
			String actualPDF = driver.getCurrentUrl();
			driver.close();
			driver.switchTo().window(parentWindow);
			if(actualPDF.contains(pdfText))
			{
				Assert.assertTrue(true);
			}
			else{
				Assert.assertTrue(false);
			}		
		}else{
			Assert.assertTrue(false);
		}
	}
	
	public static void verifyeDocsLink(){
		String parentWindow = driver.getWindowHandle();
		driver.findElement(By.xpath("//a[text()='eDocument Consent']")).click();
		int count = driver.getWindowHandles().size();
		if(count == 2){
			for(String winHandle : driver.getWindowHandles()){
			    driver.switchTo().window(winHandle);
			}
			String title = driver.getTitle();
			driver.close();
			driver.switchTo().window(parentWindow);
			if(title.equals("TDECU eDocument Consent"))
			{
				Assert.assertTrue(true);
			}
			else{
				Assert.assertTrue(false);
			}
		}else{
			Assert.assertTrue(false);
		}		
	}
	
	public static void verifyFAQanswer(){	
		String allAnswersEle = "(//div[@id='accordion']//div[@id='collapseQ1']//li)";
		String answer1 = "We will authorize and pay overdrafts for the following types of transactions:";
		String bulletPt1 = "Checks and other transactions made using your checking account number";
		String bulletPt2 = "Automatic bill payments";
		String answer2 = "We will not authorize and pay overdrafts for the following types of transactions unless you ask us to:";
		String bulletPt3 = "ATM transactions";
		String bulletPt4 = "One-time (everyday) debit card transactions";
		String answer3 = "We pay overdrafts at our discretion, which means we do not guarantee we will always authorize "
				+ "and pay any type of transaction. If we do not authorize and pay an overdraft, your transaction will be declined.";
		
		List<WebElement>allAnswers = driver.findElements(By.xpath(allAnswersEle));
		
		for(int count=1;count<=allAnswers.size();count++){			
			String eachAnswer = "(//div[@id='accordion']//div[@id='collapseQ1']//li)["+count+"]";
			String eachAnswerText = driver.findElement(By.xpath(eachAnswer)).getText();
			
			if(eachAnswerText.equals(answer1) || eachAnswerText.equals(bulletPt1) || eachAnswerText.equals(bulletPt2)
					|| eachAnswerText.equals(answer2)|| eachAnswerText.equals(bulletPt3)
					|| eachAnswerText.equals(bulletPt4)|| eachAnswerText.equals(answer3)){
				Assert.assertTrue(true);
			}
			else{
				Assert.assertTrue(false);
			}
		}
				
	}
	
	public static void verifyPrivacyNoticePDF(){
		String pdfText = "TDECU-Account-Information-Brochure-and-Privacy-Notice-07-2019.pdf";
		String parentWindow = driver.getWindowHandle();
		driver.findElement(By.xpath("//span[@id='DisclosuresList01']/a[1]")).click();		
		int count = driver.getWindowHandles().size();
		if(count == 2){
			for(String winHandle : driver.getWindowHandles()){
				driver.switchTo().window(winHandle);
			}
			String actualPDF = driver.getCurrentUrl();
			driver.close();
			driver.switchTo().window(parentWindow);
			if(actualPDF.contains(pdfText))
			{
				Assert.assertTrue(true);
			}
			else{
				Assert.assertTrue(false);
			}		
		}else{
			Assert.assertTrue(false);
		}
	}
	
	public static void verifySaveProgressText(){	
		String saveInfo1 = "You can save your application to finish later. To log back in, you will need your email address, the last four digits of your Social Security Number and a password.";
		String saveInfo2 = "If this is the first time saving your password, just enter the missing information and select either 'Save and Continue', or 'Save and Leave', to come back later.";
		String saveInfo3 = "You can finish your application by visiting the Status Center. You will be prompted for your email address, the last four digits of your Social Security Number and password.";
		String saveInfo4 = "(To help you out, we are also sending an email to you with this information.)";
		
		JavascriptExecutor js = (JavascriptExecutor)driver; 
		Object info4Locator = js.executeScript("var value = document.evaluate(\"//span[@id='ErrorSummary1']//following::p[3]/br/following::text()[1]\",document, null, XPathResult.STRING_TYPE, null); return value.stringValue;");
		String info4Text = info4Locator.toString();
		
		if(info4Text.equals(saveInfo4))
		{
			for(int count=1;count<=3;count++){
			
				String eachTextLocator = "//span[@id='ErrorSummary1']//following::p["+count+"]";
				String eachValueFromPage = driver.findElement(By.xpath(eachTextLocator)).getText();
			
				if(eachValueFromPage.equals(saveInfo1) || eachValueFromPage.equals(saveInfo2) || eachValueFromPage.contains(saveInfo3)){
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
	
	public static void verifySubmitTerms(){	
		String allTextEle = "//div[@id='bottomText']//p";
		String header = "By clicking the Submit Application button below, you:";
		String bullet1 = "Authorize TDECU to charge the account as shown above.";
		String bullet2 = "Certify that all the other information on this form, including information about the account at the financial institution above, is true, correct, and complete.";
		String bullet3 = "Certify that you are authorized to perform transactions for the account at the financial institution shown above.";
		
		List<WebElement>allTerms = driver.findElements(By.xpath(allTextEle));
		for(int count=1;count<=allTerms.size();count++){
			
			String eachTextLocator = "(//div[@id='bottomText']//p)["+count+"]";
			String eachValueFromPage = driver.findElement(By.xpath(eachTextLocator)).getText();
			
			System.out.println(eachValueFromPage);
			
			if(eachValueFromPage.equals(header) || eachValueFromPage.equals(bullet1) || eachValueFromPage.equals(bullet2)|| eachValueFromPage.equals(bullet3)){
					Assert.assertTrue(true);
			}
			else{
				Assert.assertTrue(false);
			}
		}			
	}
	
	public static String cdMaturityDate(int months){
		DateFormat dateFormat = new SimpleDateFormat("M/d/yyyy");
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		cal.add(Calendar.MONTH, months);
		String newDate = dateFormat.format(cal.getTime());
		return newDate;
	}
	
	public static void fundingDropdownContains(String locator, String opt){
		Select s=new Select(getElement(locator));

		List<WebElement> options = s.getOptions();
		boolean match = false;
		for(int i=0;i<options.size();i++){
			if(options.get(i).getText().contains(opt)){
				match = true;
				options.get(i).click();
			}
		}
		Assert.assertTrue(match);
	}
	
	public static void verifyMobileLink(){
		String pdfText = "Mobile-Remote-Deposit-Capture-User-Agreement-Terms-and-Conditions.pdf";
		String parentWindow = driver.getWindowHandle();
		driver.findElement(By.xpath("//a[text()='Mobile Remote Deposit Capture Terms and Conditions']")).click();
		int count = driver.getWindowHandles().size();
		if(count == 2){
			for(String winHandle : driver.getWindowHandles()){
			    driver.switchTo().window(winHandle);
			}
			String actualPDF = driver.getCurrentUrl();
			driver.close();
			driver.switchTo().window(parentWindow);
			if(actualPDF.contains(pdfText))
			{
				Assert.assertTrue(true);
			}
			else{
				Assert.assertTrue(false);
			}
		}else{
			Assert.assertTrue(false);
		}		
	}
	
	public static void verifyYearDropdown(String locator){
		int year = Calendar.getInstance().get(Calendar.YEAR);
		Select s=new Select(getElement(locator));

		List<WebElement> options = s.getOptions();
		boolean match = false;
		for(int i=1;i<options.size();i++){		
			String opt = options.get(i).getText();
			if(year== Integer.parseInt(opt)){
				match = true;
			}
			year++;
		}
		Assert.assertTrue(match);
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
	
	public static List<WebElement> returnElements(String locator){
		List<WebElement> elements = null;
		try{
			elements = driver.findElements(By.xpath(locator));
			  
		}catch(Exception e){
			e.printStackTrace();
		}
		return elements;
	}
	
	public static String fetchOutlookOTP() throws MessagingException, IOException{
		String hostName = "outlook.office365.com";
		String username = "divya.vagalaboina@eaglecrk.com";
		String password = "Saibaba@1234";
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
		
		 Message[] messages = emailInbox.search(new FlagTerm(new Flags(
                 Flags.Flag.SEEN), false));
	      System.out.println("messages.length---" + messages.length);
	     
	      for (int i = 0; i < messages.length; i++) {
	         Message message = messages[i];
	         System.out.println("---------------------------------");
	         System.out.println("Email Number " + (i + 1));
	         System.out.println("Subject: " + message.getSubject());
	         System.out.println("From: " + message.getFrom()[0]);
	         System.out.println("Text: " + message.getContent().toString());
	         try{
	        	 if(  message.getContent() instanceof MimeMultipart ){
		        	 System.out.println("From: " + message.getFrom()[0]);
		        	 MimeMultipart mimeMultipart = (MimeMultipart) message.getContent();
		        	 BodyPart  bp=mimeMultipart.getBodyPart(i);
		        	 System.out.println("BP content type is -"+bp.getContentType());
		        	 
		        	 if(bp.getContent().toString().contains("Your verification code")){
		        	 String htmlpart=(String)bp.getContent(); 
						String otp=Jsoup.parse(htmlpart).text();
						System.out.println("OTP messages are - "+otp);
		        	 }
		         }else{
		        	 System.out.println(message.getContent().toString());
		        	 if(message.getSubject().equalsIgnoreCase("One Time Passcode") && message.getContent().toString().contains("Your verification code")){
		        		 String val = Jsoup.parse(message.getContent().toString()).text();
		        		// System.out.println((val.substring(26, 32)));
		        		 ActOTP = val.substring(26, 32);
		        	 }
		        	 
		         }
	         }catch(Exception e){
	        	e.printStackTrace();
	         }
	      
	      }

	      //close the store and folder objects
	      emailMessage.setFlag(Flags.Flag.SEEN, true);
	      emailInbox.close(false);
	      store.close();
		return ActOTP;	
	}
	
	public static boolean enter_otp_to_the_field_and_procced(){
		boolean flag = false;
		try {
		getElement(ObjectRepository.delivery_method_email_option("Email")).click();
		getElement(ObjectRepository.send_otp_button).click();
		Thread.sleep(20000);
		getElement(ObjectRepository.security_code_textbox).sendKeys(fetchOutlookOTP());
		getElement(ObjectRepository.btn_verify_code).click();
		
		if(getElement(ObjectRepository.your_information_page).getText().contains("Your Information")){
			return flag=true;
		}
		
		}
		 catch (MessagingException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}
	
	public static void enterPromocode(String promocode){
		verifyText(ObjectRepository.cnfrmacnt_ttl,"Confirm Selected Products and Services");
		getElement(ObjectRepository.add_promocode_field).sendKeys(promocode); 
		getElement(ObjectRepository.cnfrm_btn).click();
		
	}
	
	public static void idenficationOptions(String[]option){
		List<WebElement>allOptions = returnElements("//span[@id='IDAuthenticationQuestions']//following::label");
		for(WebElement element : allOptions){
			String optionValue = element.getText();
			
			for(int index=0;index<option.length;index++){
				if(option[index].contains(optionValue)){
					element.click();
				}
			}
		}
	}
}
	


