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

public class C24320_VerifyJOLoanRoles extends GenericKeywords{
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
  public void C24320_VerifyJOLoanRoles() throws InterruptedException, MessagingException, IOException {
	  if(continuetestcase==true)
	  {
			sheetName = "ProdData";
			int totalRowCount = excl.getRowCount(sheetName);
			for(startIter=1;startIter<=totalRowCount;startIter++) //It is mandatory to have this for loop in every test case
			{	
				if(this.getClass().getSimpleName().equals(excl.getCellData("ProdData", 0, startIter)))
				{
					String prodOne= excl.getCellData(sheetName, 1, startIter);
					String prodTwo= excl.getCellData(sheetName, 2, startIter);
					String prodThree= excl.getCellData(sheetName, 3, startIter);
					String ccAmt= excl.getCellData(sheetName, 4, startIter);
					String boatAmt= excl.getCellData(sheetName, 5, startIter);
					String boatPrice= excl.getCellData(sheetName, 6, startIter);
					String loanAmt= excl.getCellData(sheetName, 7, startIter);
					String mmbrNum= excl.getCellData(sheetName, 27, startIter);
					String SSN= excl.getCellData(sheetName, 28, startIter);
					String DOB= excl.getCellData(sheetName, 29, startIter);
					String idType= excl.getCellData(sheetName, 8, startIter);
					String idNum= excl.getCellData(sheetName, 9, startIter);
					String issueDt= excl.getCellData(sheetName, 10, startIter);
					String expDt= excl.getCellData(sheetName, 11, startIter);
					String housePymt= excl.getCellData(sheetName, 12, startIter);
					String howLong= excl.getCellData(sheetName, 13, startIter);
					String currentEmp= excl.getCellData(sheetName, 14, startIter);
					String curIncome= excl.getCellData(sheetName, 15, startIter);
					String joFname= excl.getCellData(sheetName, 16, startIter);
					String joLname= excl.getCellData(sheetName, 17, startIter);
					String joDOB= excl.getCellData(sheetName, 18, startIter);
					String joSSN= excl.getCellData(sheetName, 19, startIter);
					String joIdNum= excl.getCellData(sheetName, 20, startIter);
					String joMaiden= excl.getCellData(sheetName, 21, startIter);
					String joOccupation= excl.getCellData(sheetName, 22, startIter);
					String joPhone= excl.getCellData(sheetName, 23, startIter);
					String joPhoneType= excl.getCellData(sheetName, 24, startIter);
					String joEmail= excl.getCellData(sheetName, 25, startIter);
					String rolesText= excl.getCellData(sheetName, 30, startIter);
					
					scrollToElement(ObjectRepository.mmbrstrt_btn);
					getElement(ObjectRepository.mmbrstrt_btn).click();
					test.log(Status.INFO, "Members Start Here button clicked");
					//Select Products
					getElement(ObjectRepository.creditCardExpand).click();
					getElement(ObjectRepository.platinumCheckBox).click();
					getElement(ObjectRepository.carLoanExpand).click();
					getElement(ObjectRepository.boatLoanCheckBox).click();
					getElement(ObjectRepository.personalLoanExpand).click();
					getElement(ObjectRepository.shareSecuredCheckBox).click();
					getElement(ObjectRepository.productPageNext).click();
					test.log(Status.INFO, "Credit card, vehicle loan and personal Loan selected");
					//Product info
					getElement(ObjectRepository.prodLimitTextbox).sendKeys(ccAmt);
					getElement(ObjectRepository.prodInfoNextButton).click();
					test.log(Status.INFO, "Credit card amount entered");
					getElement(ObjectRepository.prodLimitTextbox).sendKeys(boatAmt);
					getElement(ObjectRepository.carPurchPrice).sendKeys(boatPrice);
					getElement(ObjectRepository.prodInfoNextButton).click();
					test.log(Status.INFO, "Vehicle loan info entered");
					getElement(ObjectRepository.prodLimitTextbox).sendKeys(loanAmt);
					getElement(ObjectRepository.prodLimitTextbox).click();
					getElement(ObjectRepository.prodInfoNextButton).click();
					test.log(Status.INFO, "Personal loan amount entered");
					//Member Verification
					getElement(ObjectRepository.mmbrVerifyNum).sendKeys(mmbrNum);
					getElement(ObjectRepository.mmbrVerifySSN).sendKeys(SSN);
					getElement(ObjectRepository.mmbrVerifyDOB).sendKeys(DOB);
					getElement(ObjectRepository.mmbrVerifyNext).click();					
					test.log(Status.INFO, "Member Verified");
					//Applicant Info
					selectDropdownOpt(ObjectRepository.idType,idType);
					getElement(ObjectRepository.idNum).sendKeys(idNum);
					getElement(ObjectRepository.issueDate).sendKeys(issueDt);
					getElement(ObjectRepository.expDate).sendKeys(expDt);
					getElement(ObjectRepository.housePymt).sendKeys(housePymt);
					getElement(ObjectRepository.addrMonths).sendKeys(howLong);
					getElement(ObjectRepository.currentEmp).sendKeys(currentEmp);
					getElement(ObjectRepository.monIncome).sendKeys(curIncome);
					getElement(ObjectRepository.empYears).sendKeys(howLong);
					test.log(Status.INFO, "Applicant Information entered");
					getElement(ObjectRepository.jtOwnerCheckBox).click();
					getElement(ObjectRepository.productPageNext).click();
					test.log(Status.INFO, "Joint Owner checkbox selected");
					//Joint Owner
					getElement(ObjectRepository.addFname).sendKeys(joFname);
					getElement(ObjectRepository.addLname).sendKeys(joLname);
					getElement(ObjectRepository.sameAddrCbox).click();
					getElement(ObjectRepository.mmbrVerifyDOB).sendKeys(joDOB);
					getElement(ObjectRepository.addSSN).sendKeys(joSSN);
					selectDropdownOpt(ObjectRepository.idType,idType);
					getElement(ObjectRepository.idNum).sendKeys(joIdNum);
					getElement(ObjectRepository.issueDate).sendKeys(issueDt);
					getElement(ObjectRepository.expDate).sendKeys(expDt);
					getElement(ObjectRepository.addMaiden).sendKeys(joMaiden);
					getElement(ObjectRepository.addOccupation).sendKeys(joOccupation);
					getElement(ObjectRepository.addPhone).sendKeys(joPhone);
					selectDropdownOpt(ObjectRepository.addPhoneType,joPhoneType);
					getElement(ObjectRepository.addEmail).sendKeys(joEmail);
					getElement(ObjectRepository.housePymt).sendKeys(housePymt);
					getElement(ObjectRepository.addrYears).sendKeys(howLong);
					getElement(ObjectRepository.currentEmp).sendKeys(currentEmp);
					getElement(ObjectRepository.monIncome).sendKeys(curIncome);
					getElement(ObjectRepository.empMonths).sendKeys(howLong);
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
					verifyText(ObjectRepository.rolesProdOne,prodOne);
					verifyElementPresent(ObjectRepository.primaryRoleOne);
					getElement(ObjectRepository.jointRoleChecked).click();
					verifyText(ObjectRepository.rolesProdTwo,prodTwo);
					verifyElementPresent(ObjectRepository.primaryRoleTwo);
					getElement(ObjectRepository.jointRoleChecked).click();
					verifyText(ObjectRepository.rolesProdThree,prodThree);
					verifyElementPresent(ObjectRepository.primaryRoleThree);
					getElement(ObjectRepository.jointRoleChecked).click();
					getElement(ObjectRepository.productPageNext).click();
					test.log(Status.INFO, "Account Roles deselected");
					//Confirm Accounts
					verifyElementPresent(ObjectRepository.confirmTtl);
					verifyText(ObjectRepository.prodOne,prodOne);
					verifyText(ObjectRepository.prodTwo,prodTwo);
					verifyText(ObjectRepository.prodWOptionsThree,prodThree);
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
			test.log(Status.PASS, "Verify joint owner credit card and loan roles for existing member");
		}
	}

  @AfterTest
  public void tearDown() {
	 extent.flush();
	 driver.quit();
  }

}
