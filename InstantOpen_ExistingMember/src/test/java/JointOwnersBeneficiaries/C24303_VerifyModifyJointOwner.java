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

public class C24303_VerifyModifyJointOwner extends GenericKeywords{
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
  public void C24303_VerifyModifyJointOwner() throws InterruptedException, MessagingException, IOException {
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
					String joFname= excl.getCellData(sheetName, 6, startIter);
					String joLname= excl.getCellData(sheetName, 7, startIter);
					String joDOB= excl.getCellData(sheetName, 8, startIter);
					String joSSN= excl.getCellData(sheetName, 9, startIter);
					String joIdType= excl.getCellData(sheetName, 10, startIter);
					String joIdNum= excl.getCellData(sheetName, 11, startIter);
					String joIssueDt= excl.getCellData(sheetName, 12, startIter);
					String joExpDt= excl.getCellData(sheetName, 13, startIter);
					String joMaiden= excl.getCellData(sheetName, 14, startIter);
					String joOccupation= excl.getCellData(sheetName, 15, startIter);
					String joPhone= excl.getCellData(sheetName, 16, startIter);
					String joPhoneType= excl.getCellData(sheetName, 17, startIter);
					String joEmail= excl.getCellData(sheetName, 18, startIter);
					String joStreet= excl.getCellData(sheetName, 19, startIter);
					String joZip= excl.getCellData(sheetName, 20, startIter);
					String dobFormat= excl.getCellData(sheetName, 21, startIter);
					String ssnFormat= excl.getCellData(sheetName, 22, startIter);
					String issueDtFormat= excl.getCellData(sheetName, 23, startIter);
					String expDtFormat= excl.getCellData(sheetName, 24, startIter);
					String phoneFormat= excl.getCellData(sheetName, 25, startIter);
					String joMname= excl.getCellData(sheetName, 30, startIter);
					String joIdType2= excl.getCellData(sheetName, 31, startIter);
					String joIdNum2= excl.getCellData(sheetName, 32, startIter);
					String joExpDt2= excl.getCellData(sheetName, 33, startIter);
					String joEmail2= excl.getCellData(sheetName, 34, startIter);
					
					scrollToElement(ObjectRepository.mmbrstrt_btn);
					getElement(ObjectRepository.mmbrstrt_btn).click();
					test.log(Status.INFO, "Members Start Here button clicked");
					//Select Products
					getElement(ObjectRepository.cdExpand).click();
					selectDropdownOpt(ObjectRepository.selectTermDropdown,cdSelection);
					getElement(ObjectRepository.visibleCD36).click();
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
					verifyElementPresent(ObjectRepository.confirmRolesTtl);
					getElement(ObjectRepository.productPageBack).click();
					verifyElementPresent(ObjectRepository.yourInfoTtl);
					getElement(ObjectRepository.productPageNext).click();
					verifyElementPresent(ObjectRepository.addOwnerTtl);
					test.log(Status.INFO, "Navigated back to Additional Account Owners Page");
					//Verify JO info is correct
					verifyTxtFieldValue(ObjectRepository.addFname,joFname);
					verifyTxtFieldValue(ObjectRepository.addLname,joLname);
					verifyTxtFieldValue(ObjectRepository.addStreet,joStreet);
					verifyTxtFieldValue(ObjectRepository.addZip,joZip);
					verifyTxtFieldValue(ObjectRepository.mmbrVerifyDOB,dobFormat);
					verifyTxtFieldValue(ObjectRepository.addSSN,ssnFormat);
					verifyDropdownSelection(ObjectRepository.idType,joIdType);
					verifyTxtFieldValue(ObjectRepository.idNum,joIdNum);
					verifyTxtFieldValue(ObjectRepository.issueDate,issueDtFormat);
					verifyTxtFieldValue(ObjectRepository.expDate,expDtFormat);
					verifyTxtFieldValue(ObjectRepository.addMaiden,joMaiden);
					verifyTxtFieldValue(ObjectRepository.addOccupation,joOccupation);
					verifyTxtFieldValue(ObjectRepository.addPhone,phoneFormat);
					verifyDropdownSelection(ObjectRepository.addPhoneType,joPhoneType);
					verifyTxtFieldValue(ObjectRepository.addEmail,joEmail);
					test.log(Status.INFO, "Joint Owner information is correct");
					//Modify JO Info
					getElement(ObjectRepository.addMname).sendKeys(joMname);
					selectDropdownOpt(ObjectRepository.idType,joIdType2);
					getElement(ObjectRepository.idNum).clear();
					getElement(ObjectRepository.idNum).sendKeys(joIdNum2);
					getElement(ObjectRepository.expDate).clear();
					getElement(ObjectRepository.expDate).sendKeys(joExpDt2);
					getElement(ObjectRepository.addEmail).clear();
					getElement(ObjectRepository.addEmail).sendKeys(joEmail2);
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
			test.log(Status.PASS, "Verify joint owner modified for existing member");
		}
	}

  @AfterTest
  public void tearDown() {
	 extent.flush();
	 driver.quit();
  }

}
