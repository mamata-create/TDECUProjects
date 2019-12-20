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

public class C24299_VerifyJointOwnerAndBeneficiary extends GenericKeywords{
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
  public void C24299_VerifyJointOwnerAndBeneficiary() throws InterruptedException, MessagingException, IOException {
	  if(continuetestcase==true)
	  {
			sheetName = "ProdData";
			int totalRowCount = excl.getRowCount(sheetName);
			for(startIter=1;startIter<=totalRowCount;startIter++) //It is mandatory to have this for loop in every test case
			{	
				if(this.getClass().getSimpleName().equals(excl.getCellData("ProdData", 0, startIter)))
				{
					String mmbrNum= excl.getCellData(sheetName, 27, startIter);
					String SSN= excl.getCellData(sheetName, 28, startIter);
					String DOB= excl.getCellData(sheetName, 29, startIter);
					String joFname= excl.getCellData(sheetName, 6, startIter);
					String joLname= excl.getCellData(sheetName, 7, startIter);
					String joDOB= excl.getCellData(sheetName, 8, startIter);
					String joSSN= excl.getCellData(sheetName, 9, startIter);
					String joIdType= excl.getCellData(sheetName, 10, startIter);
					String joIdState= excl.getCellData(sheetName, 11, startIter);
					String joIdNum= excl.getCellData(sheetName, 12, startIter);
					String joIssueDt= excl.getCellData(sheetName, 13, startIter);
					String joExpDt= excl.getCellData(sheetName, 14, startIter);
					String joMaiden= excl.getCellData(sheetName, 15, startIter);
					String joOccupation= excl.getCellData(sheetName, 16, startIter);
					String joPhone= excl.getCellData(sheetName, 17, startIter);
					String joPhoneType= excl.getCellData(sheetName, 18, startIter);
					String joEmail= excl.getCellData(sheetName, 19, startIter);
					String beneFname= excl.getCellData(sheetName, 20, startIter);
					String beneDOB= excl.getCellData(sheetName, 21, startIter);
					String beneSSN= excl.getCellData(sheetName, 22, startIter);
					String beneEmail= excl.getCellData(sheetName, 23, startIter);
					
					scrollToElement(ObjectRepository.mmbrstrt_btn);
					getElement(ObjectRepository.mmbrstrt_btn).click();
					test.log(Status.INFO, "Members Start Here button clicked");
					//Select Products
					getElement(ObjectRepository.checkingExpand).click();
					getElement(ObjectRepository.classicCheckCheckBox).click();
					getElement(ObjectRepository.productPageNext).click();
					test.log(Status.INFO, "Classic Checking account selected");
					//Member Verification
					getElement(ObjectRepository.mmbrVerifyNum).sendKeys(mmbrNum);
					getElement(ObjectRepository.mmbrVerifySSN).sendKeys(SSN);
					getElement(ObjectRepository.mmbrVerifyDOB).sendKeys(DOB);
					getElement(ObjectRepository.mmbrVerifyNext).click();					
					test.log(Status.INFO, "Member Verified");
					String fname = getElement(ObjectRepository.fname).getAttribute("value");
					String lname = getElement(ObjectRepository.lname).getAttribute("value");
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
					selectDropdownOpt(ObjectRepository.stateDropdown,joIdState);
					getElement(ObjectRepository.idNum).sendKeys(joIdNum);
					getElement(ObjectRepository.issueDate).sendKeys(joIssueDt);
					getElement(ObjectRepository.expDate).sendKeys(joExpDt);
					getElement(ObjectRepository.addMaiden).sendKeys(joMaiden);
					getElement(ObjectRepository.addOccupation).sendKeys(joOccupation);
					getElement(ObjectRepository.addPhone).sendKeys(joPhone);
					selectDropdownOpt(ObjectRepository.addPhoneType,joPhoneType);
					getElement(ObjectRepository.addEmail).sendKeys(joEmail);
					test.log(Status.INFO, "Joint Owner information entered");
					getElement(ObjectRepository.addBeneCheckBox).click();
					getElement(ObjectRepository.productPageNext).click();
					test.log(Status.INFO, "Add Beneficiaries selected");
					//Beneficiary
					getElement(ObjectRepository.addFname).sendKeys(beneFname);
					getElement(ObjectRepository.addLname).sendKeys(joLname);
					getElement(ObjectRepository.sameAddrCbox).click();
					getElement(ObjectRepository.mmbrVerifyDOB).sendKeys(beneDOB);
					getElement(ObjectRepository.addSSN).sendKeys(beneSSN);
					getElement(ObjectRepository.addPhone).sendKeys(joPhone);
					selectDropdownOpt(ObjectRepository.addPhoneType,joPhoneType);
					getElement(ObjectRepository.addEmail).sendKeys(beneEmail);
					test.log(Status.INFO, "Beneficiary information entered");
					getElement(ObjectRepository.productPageNext).click();
					//Confirm Accounts
					getElement(ObjectRepository.confirmBtn).click();
					test.log(Status.INFO, "Account selection confirmed");
					//Agreements and Disclosures
					getElement(ObjectRepository.discCheckBox).click();
					getElement(ObjectRepository.agreeCheckBox).click();
					getElement(ObjectRepository.confirmBtn).click();
					test.log(Status.INFO, "Agreements and Disclosures accepted");
					//Identity Questions
					String primaryName = fname+" "+lname;
					verifyText(ObjectRepository.IdentityName,primaryName);
					getElement(ObjectRepository.qstnOneOptnOne).click();
					getElement(ObjectRepository.qstnTwoOptnTwo).click();
					getElement(ObjectRepository.qstnThreeOptnThree).click();
					getElement(ObjectRepository.qstnFourOptnFour).click();
					getElement(ObjectRepository.confirmBtn).click();
					test.log(Status.INFO, "Identity questions answered for primary applicant");
					String joName = joFname+" "+joLname;
					verifyText(ObjectRepository.IdentityName,joName);
					getElement(ObjectRepository.qstnOneOptnOne).click();
					getElement(ObjectRepository.qstnTwoOptnTwo).click();
					getElement(ObjectRepository.qstnThreeOptnThree).click();
					getElement(ObjectRepository.qstnFourOptnFour).click();
					getElement(ObjectRepository.confirmBtn).click();
					test.log(Status.INFO, "Identity questions answered for joint owner");
					verifyElementPresent(ObjectRepository.acctFundTitle);
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
			test.log(Status.PASS, "Verify joint owner and beneficiary added for existing member");
		}
	}

  @AfterTest
  public void tearDown() {
	 extent.flush();
	 driver.quit();
  }

}
