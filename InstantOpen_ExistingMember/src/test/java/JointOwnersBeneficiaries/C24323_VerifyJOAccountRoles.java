package JointOwnersBeneficiaries;

import java.io.IOException;

import javax.mail.MessagingException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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

public class C24323_VerifyJOAccountRoles extends GenericKeywords{
	ExtentReports extent;
	ExtentTest test;
	
  @BeforeTest
  public void setUp() throws InterruptedException, MessagingException, IOException {
	  extent = ExtentManager.GetExtent();
	  test = extent.createTest(this.getClass().getSimpleName());
      BaseClass iDriver = new BaseClass();
      iDriver.myTestCaseName = this.getClass().getSimpleName();
	  executeDriverScript();
	  test.log(Status.INFO, "Application url navigated");
  }
	
  @Test
  public void C24323_VerifyJOAccountRoles() throws InterruptedException, MessagingException, IOException {
	  if(continuetestcase==true)
	  {
			sheetName = "ProdData";
			int totalRowCount = excl.getRowCount(sheetName);
			for(startIter=1;startIter<=totalRowCount;startIter++) //It is mandatory to have this for loop in every test case
			{	
				if(this.getClass().getSimpleName().equals(excl.getCellData("ProdData", 0, startIter)))
				{
					String cdSelection= excl.getCellData(sheetName, 1, startIter);
					String cdTitle= excl.getCellData(sheetName, 2, startIter);
					String cdConfirm= excl.getCellData(sheetName, 3, startIter);
					String checkingTitle= excl.getCellData(sheetName, 4, startIter);
					String moneyMarketTitle= excl.getCellData(sheetName, 5, startIter);
					String savingsTitle= excl.getCellData(sheetName, 6, startIter);
					String mmbrNum= excl.getCellData(sheetName, 27, startIter);
					String SSN= excl.getCellData(sheetName, 28, startIter);
					String DOB= excl.getCellData(sheetName, 29, startIter);
					String joFname= excl.getCellData(sheetName, 11, startIter);
					String joLname= excl.getCellData(sheetName, 12, startIter);
					String joDOB= excl.getCellData(sheetName, 13, startIter);
					String joSSN= excl.getCellData(sheetName, 14, startIter);
					String joIdType= excl.getCellData(sheetName, 15, startIter);
					String joIdNum= excl.getCellData(sheetName, 16, startIter);
					String joIssueDt= excl.getCellData(sheetName, 17, startIter);
					String joExpDt= excl.getCellData(sheetName, 18, startIter);
					String joMaiden= excl.getCellData(sheetName, 19, startIter);
					String joOccupation= excl.getCellData(sheetName, 20, startIter);
					String joPhone= excl.getCellData(sheetName, 21, startIter);
					String joPhoneType= excl.getCellData(sheetName, 22, startIter);
					String joEmail= excl.getCellData(sheetName, 23, startIter);
					String rolesText= excl.getCellData(sheetName, 30, startIter);
					
					scrollToElement(ObjectRepository.mmbrstrt_btn);
					getElement(ObjectRepository.mmbrstrt_btn).click();
					test.log(Status.INFO, "Members Start Here button clicked");
					//Select Products
					getElement(ObjectRepository.cdExpand).click();
					selectDropdownOpt(ObjectRepository.selectTermDropdown,cdSelection);
					getElement(ObjectRepository.visibleCD12).click();
					getElement(ObjectRepository.checkingExpand).click();
					getElement(ObjectRepository.classicCheckCheckBox).click();
					getElement(ObjectRepository.mnyMrktCheckBox).click();
					getElement(ObjectRepository.savingsExpand).click();
					getElement(ObjectRepository.clubCheckBox).click();
					getElement(ObjectRepository.productPageNext).click();
					test.log(Status.INFO, "CD, checking account and savings account selected");
					//Member Verification
					getElement(ObjectRepository.mmbrVerifyNum).sendKeys(mmbrNum);
					getElement(ObjectRepository.mmbrVerifySSN).sendKeys(SSN);
					getElement(ObjectRepository.mmbrVerifyDOB).sendKeys(DOB);
					getElement(ObjectRepository.mmbrVerifyNext).click();					
					test.log(Status.INFO, "Member Verified");
					getElement(ObjectRepository.jtOwnerCheckBox).click();
					getElement(ObjectRepository.productPageNext).click();
					test.log(Status.INFO, "Joint Owner checkbox selected");
					//Joint Owner
					getElement(ObjectRepository.addFname).sendKeys(joFname);
					getElement(ObjectRepository.addLname).sendKeys(joLname);
					getElement(ObjectRepository.sameAddrCbox).click();
					getElement(ObjectRepository.mmbrVerifyDOB).sendKeys(joDOB);
					getElement(ObjectRepository.addSSN).sendKeys(joSSN);
					selectDropdownOpt(ObjectRepository.idType,joIdType);
					getElement(ObjectRepository.idNum).sendKeys(joIdNum);
					getElement(ObjectRepository.issueDate).sendKeys(joIssueDt);
					getElement(ObjectRepository.expDate).sendKeys(joExpDt);
					getElement(ObjectRepository.addMaiden).sendKeys(joMaiden);
					getElement(ObjectRepository.addOccupation).sendKeys(joOccupation);
					getElement(ObjectRepository.addPhone).sendKeys(joPhone);
					selectDropdownOpt(ObjectRepository.addPhoneType,joPhoneType);
					getElement(ObjectRepository.addEmail).sendKeys(joEmail);
					test.log(Status.INFO, "Joint Owner information entered");
					getElement(ObjectRepository.productPageNext).click();
					//Account Roles	
					WebElement ele=driver.findElement(By.xpath("//span[@id='progBarSmall']//following::span[1]"));
					JavascriptExecutor executor = (JavascriptExecutor)driver;
					Object text = executor.executeScript("var nodes = arguments[0].childNodes;" +
					"var text = '';"+
					"text += nodes[5].textContent;" +
					"return text;"
		            , ele);
					String rolesInfo = text.toString();
					if(rolesInfo.contains(rolesText)){
						Assert.assertTrue(true);
					}
					test.log(Status.INFO, "Confirm Account Roles info displayed");
					verifyText(ObjectRepository.rolesProdOne,cdTitle);
					verifyElementPresent(ObjectRepository.primaryRoleOne);
					getElement(ObjectRepository.jointRoleChecked).click();
					verifyText(ObjectRepository.rolesProdTwo,moneyMarketTitle);
					verifyElementPresent(ObjectRepository.primaryRoleTwo);
					getElement(ObjectRepository.jointRoleChecked).click();
					verifyText(ObjectRepository.rolesProdThree,checkingTitle);
					verifyElementPresent(ObjectRepository.primaryRoleThree);
					getElement(ObjectRepository.jointRoleChecked).click();
					verifyText(ObjectRepository.rolesProdFour,savingsTitle);
					verifyElementPresent(ObjectRepository.primaryRoleFour);
					getElement(ObjectRepository.jointRoleChecked).click();					
					test.log(Status.INFO, "Account Roles deselected");
					getElement(ObjectRepository.jointRoleNotChecked).click();
					getElement(ObjectRepository.jointRoleNotChecked).click();
					getElement(ObjectRepository.jointRoleNotChecked).click();
					getElement(ObjectRepository.jointRoleNotChecked).click();
					getElement(ObjectRepository.productPageNext).click();
					test.log(Status.INFO, "Account Roles selected");
					//Confirm Accounts
					String maturity = cdMaturityDate(12);					
					String concatProd = cdConfirm+" "+maturity+")";
					verifyText(ObjectRepository.prodOne,concatProd);
					verifyText(ObjectRepository.prodTwo,moneyMarketTitle);
					verifyText(ObjectRepository.prodWOptionsThree,checkingTitle);
					verifyText(ObjectRepository.prodFour,savingsTitle);
				}
			}
	  }
  }
  @AfterMethod
  public void afterMethod(ITestResult result) throws Throwable {
	  if (result.getStatus() == ITestResult.FAILURE) {
			test.log(Status.FAIL, "Test Failed-" + result.getThrowable());

			takescreenshot(this.getClass().getSimpleName(), test);
		} else {
			test.log(Status.PASS, "Verify joint owner checking, savings and CD roles for existing member");
		}
	}

  @AfterTest
  public void tearDown() {
	 extent.flush();
	 driver.quit();
  }

}
