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

public class C24305_VerifyDeleteJointOwner extends GenericKeywords{
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
  public void C24305_VerifyDeleteJointOwner() throws InterruptedException, MessagingException, IOException {
	  if(continuetestcase==true)
	  {
			sheetName = "ProdData";
			int totalRowCount = excl.getRowCount(sheetName);
			for(startIter=1;startIter<=totalRowCount;startIter++) //It is mandatory to have this for loop in every test case
			{	
				if(this.getClass().getSimpleName().equals(excl.getCellData("ProdData", 0, startIter)))
				{
					String cdSelection= excl.getCellData(sheetName, 1, startIter);
					
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
					
					scrollToElement(ObjectRepository.mmbrstrt_btn);
					getElement(ObjectRepository.mmbrstrt_btn).click();
					test.log(Status.INFO, "Members Start Here button clicked");
					//Select Products
					getElement(ObjectRepository.cdExpand).click();
					selectDropdownOpt(ObjectRepository.selectTermDropdown,cdSelection);
					getElement(ObjectRepository.visibleCD24).click();
					getElement(ObjectRepository.checkingExpand).click();
					getElement(ObjectRepository.classicCheckCheckBox).click();
					getElement(ObjectRepository.productPageNext).click();
					test.log(Status.INFO, "High Yield Checking account and CD selected");
					//Member Verification
					
					getElement(ObjectRepository.mmbrVerifySSN).sendKeys(SSN);
					getElement(ObjectRepository.mmbrVerifyDOB).sendKeys(DOB);
					getElement(ObjectRepository.mmbrVerifyNext).click();					
					test.log(Status.INFO, "Member Verified");
					verifyText(ObjectRepository.delivery_method_page_header,"Select a Delivery Method");
					test.log(Status.INFO, "user on Delivery Method page");
					enter_otp_to_the_field_and_procced();
					
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
					verifyElementPresent(ObjectRepository.ownersAddTtl);
					String addFullName = joFname+" "+joLname;
					verifyText(ObjectRepository.addOwnersLink,addFullName);
					getElement(ObjectRepository.removeAddOwners).click();
					test.log(Status.INFO, "Joint Owner removed");
					Thread.sleep(1000);
					verifyElementPresent(ObjectRepository.addOwnerTtl);
					verifyEmptyFieldValue(ObjectRepository.addFname);
					verifyEmptyFieldValue(ObjectRepository.addLname);
					verifyEmptyFieldValue(ObjectRepository.addStreet);
					verifyEmptyFieldValue(ObjectRepository.addZip);
					verifyEmptyFieldValue(ObjectRepository.mmbrVerifyDOB);
					verifyEmptyFieldValue(ObjectRepository.addSSN);
					verifyDropdownSelection(ObjectRepository.idType,"");
					verifyEmptyFieldValue(ObjectRepository.idNum);
					verifyEmptyFieldValue(ObjectRepository.issueDate);
					verifyEmptyFieldValue(ObjectRepository.expDate);
					verifyEmptyFieldValue(ObjectRepository.addMaiden);
					verifyEmptyFieldValue(ObjectRepository.addOccupation);
					verifyEmptyFieldValue(ObjectRepository.addPhone);
					verifyDropdownSelection(ObjectRepository.addPhoneType,"Phone Type");
					verifyEmptyFieldValue(ObjectRepository.addEmail);
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
			test.log(Status.PASS, "Verify joint owner removed for existing member");
		}
	}

  @AfterTest
  public void tearDown() {
	 extent.flush();
	 driver.quit();
  }

}
