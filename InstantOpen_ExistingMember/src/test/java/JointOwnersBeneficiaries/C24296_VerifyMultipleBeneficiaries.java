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

public class C24296_VerifyMultipleBeneficiaries extends GenericKeywords{
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
  public void C24296_VerifyMultipleBeneficiaries() throws InterruptedException, MessagingException, IOException {
	  if(continuetestcase==true)
	  {
			sheetName = "ProdData";
			int totalRowCount = excl.getRowCount(sheetName);
			for(startIter=1;startIter<=totalRowCount;startIter++) //It is mandatory to have this for loop in every test case
			{	
				if(this.getClass().getSimpleName().equals(excl.getCellData("ProdData", 0, startIter)))
				{
					
					String SSN= excl.getCellData(sheetName, 28, startIter);
					String DOB= excl.getCellData(sheetName, 29, startIter);
					String beneFname= excl.getCellData(sheetName, 6, startIter);
					String beneLname= excl.getCellData(sheetName, 7, startIter);
					String beneDOB= excl.getCellData(sheetName, 8, startIter);
					String beneSSN= excl.getCellData(sheetName, 9, startIter);
					String benePhone= excl.getCellData(sheetName, 10, startIter);
					String benePhoneType= excl.getCellData(sheetName, 11, startIter);
					String beneEmail= excl.getCellData(sheetName, 12, startIter);
					String bene2Fname= excl.getCellData(sheetName, 13, startIter);
					String bene2Mname= excl.getCellData(sheetName, 14, startIter);
					String bene2Street= excl.getCellData(sheetName, 15, startIter);
					String bene2Zip= excl.getCellData(sheetName, 16, startIter);
					String bene2DOB= excl.getCellData(sheetName, 17, startIter);
					String bene2SSN= excl.getCellData(sheetName, 18, startIter);
					String bene2IdType= excl.getCellData(sheetName, 19, startIter);
					String bene2IdNum= excl.getCellData(sheetName, 20, startIter);
					String bene2IssueDt= excl.getCellData(sheetName, 21, startIter);
					String bene2ExpDt= excl.getCellData(sheetName, 22, startIter);
					String bene2Email= excl.getCellData(sheetName, 23, startIter);
					
					scrollToElement(ObjectRepository.mmbrstrt_btn);
					getElement(ObjectRepository.mmbrstrt_btn).click();
					test.log(Status.INFO, "Members Start Here button clicked");
					//Select Products
					getElement(ObjectRepository.savingsExpand).click();
					getElement(ObjectRepository.clubCheckBox).click();
					getElement(ObjectRepository.productPageNext).click();
					test.log(Status.INFO, "Club account selected");
					//Member Verification
					
					getElement(ObjectRepository.mmbrVerifySSN).sendKeys(SSN);
					getElement(ObjectRepository.mmbrVerifyDOB).sendKeys(DOB);
					getElement(ObjectRepository.mmbrVerifyNext).click();					
					test.log(Status.INFO, "Member Verified");
					
					verifyText(ObjectRepository.delivery_method_page_header,"Select a Delivery Method");
					test.log(Status.INFO, "user on Delivery Method page");
					enter_otp_to_the_field_and_procced();
					getElement(ObjectRepository.addBeneCheckBox).click();
					getElement(ObjectRepository.productPageNext).click();
					test.log(Status.INFO, "Add Beneficiaries checkbox selected");
					//Beneficiary
					verifyElementPresent(ObjectRepository.addBeneTtl);
					getElement(ObjectRepository.addFname).sendKeys(beneFname);
					getElement(ObjectRepository.addLname).sendKeys(beneLname);
					getElement(ObjectRepository.sameAddrCbox).click();
					getElement(ObjectRepository.mmbrVerifyDOB).sendKeys(beneDOB);
					getElement(ObjectRepository.addSSN).sendKeys(beneSSN);
					getElement(ObjectRepository.addPhone).sendKeys(benePhone);
					selectDropdownOpt(ObjectRepository.addPhoneType,benePhoneType);
					getElement(ObjectRepository.addEmail).sendKeys(beneEmail);
					test.log(Status.INFO, "Beneficiary information entered");
					getElement(ObjectRepository.addButton).click();
					test.log(Status.INFO, "Add Another Beneficiary button clicked");
					//Second Beneficiary
					getElement(ObjectRepository.addFname).sendKeys(bene2Fname);
					getElement(ObjectRepository.addMname).sendKeys(bene2Mname);
					getElement(ObjectRepository.addLname).sendKeys(beneLname);
					getElement(ObjectRepository.addStreet).sendKeys(bene2Street);
					getElement(ObjectRepository.addZip).sendKeys(bene2Zip);
					test.log(Status.INFO, "Applicant Information entered for second Beneficiary");
					getElement(ObjectRepository.mmbrVerifyDOB).sendKeys(bene2DOB);
					getElement(ObjectRepository.addSSN).sendKeys(bene2SSN);
					selectDropdownOpt(ObjectRepository.idType,bene2IdType);
					getElement(ObjectRepository.idNum).sendKeys(bene2IdNum);
					getElement(ObjectRepository.issueDate).sendKeys(bene2IssueDt);
					getElement(ObjectRepository.expDate).sendKeys(bene2ExpDt);
					test.log(Status.INFO, "Identification Information entered for second Beneficiary");
					getElement(ObjectRepository.addPhone).sendKeys(benePhone);
					selectDropdownOpt(ObjectRepository.addPhoneType,benePhoneType);
					getElement(ObjectRepository.addEmail).sendKeys(bene2Email);
					test.log(Status.INFO, "Contact Information entered for second Beneficiary");
					getElement(ObjectRepository.productPageNext).click();
					verifyElementPresent(ObjectRepository.cnfrmacnt_ttl);
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
			test.log(Status.PASS, "Verify multiple beneficiaries added for existing member");
		}
	}

  @AfterTest
  public void tearDown() {
	 extent.flush();
	 driver.quit();
  }

}
