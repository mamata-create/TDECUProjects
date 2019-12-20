package JointOwnersBeneficiaries;

import java.io.IOException;

import javax.mail.MessagingException;

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

public class C24304_VerifyModifyBeneficiary extends GenericKeywords{
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
  public void C24304_VerifyModifyBeneficiary() throws InterruptedException, MessagingException, IOException {
	  if(continuetestcase==true)
	  {
			sheetName = "ProdData";
			int totalRowCount = excl.getRowCount(sheetName);
			for(startIter=1;startIter<=totalRowCount;startIter++) //It is mandatory to have this for loop in every test case
			{	
				if(this.getClass().getSimpleName().equals(excl.getCellData("ProdData", 0, startIter)))
				{
					String cdSelection= excl.getCellData(sheetName, 1, startIter);
					String mmbrNum= excl.getCellData(sheetName, 27, startIter);
					String SSN= excl.getCellData(sheetName, 28, startIter);
					String DOB= excl.getCellData(sheetName, 29, startIter);
					String beneFname= excl.getCellData(sheetName, 11, startIter);
					String beneLname= excl.getCellData(sheetName, 12, startIter);
					String beneDOB= excl.getCellData(sheetName, 13, startIter);
					String beneSSN= excl.getCellData(sheetName, 14, startIter);
					String benePhone= excl.getCellData(sheetName, 15, startIter);
					String benePhoneType= excl.getCellData(sheetName, 16, startIter);
					String beneEmail= excl.getCellData(sheetName, 17, startIter);
					String dobFormat= excl.getCellData(sheetName, 18, startIter);
					String ssnFormat= excl.getCellData(sheetName, 19, startIter);
					String phoneFormat= excl.getCellData(sheetName, 20, startIter);
					String beneStreet2= excl.getCellData(sheetName, 21, startIter);
					String beneZip2= excl.getCellData(sheetName, 22, startIter);
					String beneDOB2= excl.getCellData(sheetName, 23, startIter);
					String benePhone2= excl.getCellData(sheetName, 24, startIter);
					
					scrollToElement(ObjectRepository.mmbrstrt_btn);
					getElement(ObjectRepository.mmbrstrt_btn).click();
					test.log(Status.INFO, "Members Start Here button clicked");
					//Select Products
					getElement(ObjectRepository.cdExpand).click();
					selectDropdownOpt(ObjectRepository.selectTermDropdown,cdSelection);
					getElement(ObjectRepository.visibleCD6).click();
					getElement(ObjectRepository.checkingExpand).click();
					getElement(ObjectRepository.classicCheckCheckBox).click();
					getElement(ObjectRepository.productPageNext).click();
					test.log(Status.INFO, "Classic Checking account and CD selected");
					//Member Verification
					getElement(ObjectRepository.mmbrVerifyNum).sendKeys(mmbrNum);
					getElement(ObjectRepository.mmbrVerifySSN).sendKeys(SSN);
					getElement(ObjectRepository.mmbrVerifyDOB).sendKeys(DOB);
					getElement(ObjectRepository.mmbrVerifyNext).click();					
					test.log(Status.INFO, "Member Verified");
					getElement(ObjectRepository.addBeneCheckBox).click();
					getElement(ObjectRepository.productPageNext).click();
					test.log(Status.INFO, "Add Beneficiaries checkbox selected");
					//Beneficiary
					getElement(ObjectRepository.addFname).sendKeys(beneFname);
					getElement(ObjectRepository.addLname).sendKeys(beneLname);
					getElement(ObjectRepository.sameAddrCbox).click();
					String beneStreet = getElement(ObjectRepository.addStreet).getAttribute("value");
					String beneZip = getElement(ObjectRepository.addZip).getAttribute("value");
					getElement(ObjectRepository.mmbrVerifyDOB).sendKeys(beneDOB);
					getElement(ObjectRepository.addSSN).sendKeys(beneSSN);
					getElement(ObjectRepository.addPhone).sendKeys(benePhone);
					selectDropdownOpt(ObjectRepository.addPhoneType,benePhoneType);
					getElement(ObjectRepository.addEmail).sendKeys(beneEmail);
					test.log(Status.INFO, "Beneficiary information entered");
					getElement(ObjectRepository.productPageNext).click();
					verifyElementPresent(ObjectRepository.confirmRolesTtl);
					getElement(ObjectRepository.productPageBack).click();
					verifyElementPresent(ObjectRepository.yourInfoTtl);
					getElement(ObjectRepository.productPageNext).click();
					verifyElementPresent(ObjectRepository.addBeneTtl);
					test.log(Status.INFO, "Navigated back to Beneficiary Information Page");
					//Verify Beneficiary info is correct
					verifyTxtFieldValue(ObjectRepository.addFname,beneFname);
					verifyTxtFieldValue(ObjectRepository.addLname,beneLname);
					verifyTxtFieldValue(ObjectRepository.addStreet,beneStreet);
					verifyTxtFieldValue(ObjectRepository.addZip,beneZip);
					verifyTxtFieldValue(ObjectRepository.mmbrVerifyDOB,dobFormat);
					verifyTxtFieldValue(ObjectRepository.addSSN,ssnFormat);
					verifyTxtFieldValue(ObjectRepository.addPhone,phoneFormat);
					verifyDropdownSelection(ObjectRepository.addPhoneType,benePhoneType);
					verifyTxtFieldValue(ObjectRepository.addEmail,beneEmail);
					test.log(Status.INFO, "Beneficiary information is correct");
					//Modify beneficiary Info
					getElement(ObjectRepository.sameAddrCbox).click();
					getElement(ObjectRepository.addStreet).sendKeys(beneStreet2);
					getElement(ObjectRepository.addZip).sendKeys(beneZip2);
					getElement(ObjectRepository.mmbrVerifyDOB).clear();
					getElement(ObjectRepository.mmbrVerifyDOB).sendKeys(beneDOB2);
					getElement(ObjectRepository.addPhone).clear();
					getElement(ObjectRepository.addPhone).sendKeys(benePhone2);
					getElement(ObjectRepository.productPageNext).click();
					verifyElementPresent(ObjectRepository.confirmRolesTtl);
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
			test.log(Status.PASS, "Verify beneficiary modified for existing member");
		}
	}

  @AfterTest
  public void tearDown() {
	 extent.flush();
	 driver.quit();
  }

}
