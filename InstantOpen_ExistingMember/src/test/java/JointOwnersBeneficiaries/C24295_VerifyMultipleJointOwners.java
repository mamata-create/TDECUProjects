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

public class C24295_VerifyMultipleJointOwners extends GenericKeywords{
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
  public void C24295_VerifyMultipleJointOwners() throws InterruptedException, MessagingException, IOException {
	  if(continuetestcase==true)
	  {
			sheetName = "ProdData";
			int totalRowCount = excl.getRowCount(sheetName);
			for(startIter=1;startIter<=totalRowCount;startIter++) //It is mandatory to have this for loop in every test case
			{	
				if(this.getClass().getSimpleName().equals(excl.getCellData("ProdData", 0, startIter)))
				{
					String loanAmt= excl.getCellData(sheetName, 1, startIter);
					String priceAmt= excl.getCellData(sheetName, 2, startIter);
					String vinNum= excl.getCellData(sheetName, 3, startIter);
					String mmbrNum= excl.getCellData(sheetName, 27, startIter);
					String SSN= excl.getCellData(sheetName, 28, startIter);
					String DOB= excl.getCellData(sheetName, 29, startIter);
					String idType= excl.getCellData(sheetName, 4, startIter);
					String idNum= excl.getCellData(sheetName, 5, startIter);
					String issueDt= excl.getCellData(sheetName, 6, startIter);
					String expDt= excl.getCellData(sheetName, 7, startIter);
					String housePymt= excl.getCellData(sheetName, 8, startIter);
					String howLong= excl.getCellData(sheetName, 9, startIter);
					String currentEmp= excl.getCellData(sheetName, 10, startIter);
					String curIncome= excl.getCellData(sheetName, 11, startIter);
					String joFname= excl.getCellData(sheetName, 12, startIter);
					String joLname= excl.getCellData(sheetName, 13, startIter);
					String joDOB= excl.getCellData(sheetName, 14, startIter);
					String joSSN= excl.getCellData(sheetName, 15, startIter);
					String joIdNum= excl.getCellData(sheetName, 16, startIter);
					String joOccupation= excl.getCellData(sheetName, 17, startIter);
					String joPhone= excl.getCellData(sheetName, 18, startIter);
					String joPhoneType= excl.getCellData(sheetName, 19, startIter);
					String joEmail= excl.getCellData(sheetName, 20, startIter);
					String howLong2= excl.getCellData(sheetName, 21, startIter);
					String jo2Fname= excl.getCellData(sheetName, 22, startIter);
					String jo2Mname= excl.getCellData(sheetName, 23, startIter);
					String jo2Street= excl.getCellData(sheetName, 24, startIter);
					String jo2Zip= excl.getCellData(sheetName, 25, startIter);
					String jo2SSN= excl.getCellData(sheetName, 26, startIter);
					String jo2IdNum= excl.getCellData(sheetName, 30, startIter);
					String jo2Email= excl.getCellData(sheetName, 31, startIter);
					String jo2PrevEmp= excl.getCellData(sheetName, 32, startIter);
					String jo2PrevIncome= excl.getCellData(sheetName, 33, startIter);
					
					scrollToElement(ObjectRepository.mmbrstrt_btn);
					getElement(ObjectRepository.mmbrstrt_btn).click();
					test.log(Status.INFO, "Members Start Here button clicked");
					//Select Products
					getElement(ObjectRepository.carLoanExpand).click();
					getElement(ObjectRepository.cycleRefinCheckBox).click();
					getElement(ObjectRepository.productPageNext).click();
					test.log(Status.INFO, "Vehicle Loan selected");
					//Loan info
					getElement(ObjectRepository.prodLimitTextbox).sendKeys(loanAmt);
					getElement(ObjectRepository.carPurchPrice).sendKeys(priceAmt);
					getElement(ObjectRepository.carVIN).sendKeys(vinNum);
					getElement(ObjectRepository.prodInfoNextButton).click();
					test.log(Status.INFO, "Loan info entered");
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
					getElement(ObjectRepository.addrYears).sendKeys(howLong);
					getElement(ObjectRepository.currentEmp).sendKeys(currentEmp);
					getElement(ObjectRepository.monIncome).sendKeys(curIncome);
					getElement(ObjectRepository.empMonths).sendKeys(howLong);
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
					getElement(ObjectRepository.addMaiden).sendKeys(joLname);
					getElement(ObjectRepository.addOccupation).sendKeys(joOccupation);
					getElement(ObjectRepository.addPhone).sendKeys(joPhone);
					selectDropdownOpt(ObjectRepository.addPhoneType,joPhoneType);
					getElement(ObjectRepository.addEmail).sendKeys(joEmail);
					getElement(ObjectRepository.housePymt).sendKeys(housePymt);
					getElement(ObjectRepository.addrMonths).sendKeys(howLong2);
					getElement(ObjectRepository.currentEmp).sendKeys(currentEmp);
					getElement(ObjectRepository.monIncome).sendKeys(curIncome);
					getElement(ObjectRepository.empYears).sendKeys(howLong2);
					test.log(Status.INFO, "Joint Owner information entered");
					getElement(ObjectRepository.addButton).click();
					test.log(Status.INFO, "Add Another Joint Owner button clicked");
					//Second Joint Owner
					getElement(ObjectRepository.addFname).sendKeys(jo2Fname);
					getElement(ObjectRepository.addMname).sendKeys(jo2Mname);
					getElement(ObjectRepository.addLname).sendKeys(joLname);
					getElement(ObjectRepository.addStreet).sendKeys(jo2Street);
					getElement(ObjectRepository.addZip).sendKeys(jo2Zip);
					test.log(Status.INFO, "Applicant Information entered for second Joint Owner");
					getElement(ObjectRepository.mmbrVerifyDOB).sendKeys(joDOB);
					getElement(ObjectRepository.addSSN).sendKeys(jo2SSN);
					selectDropdownOpt(ObjectRepository.idType,idType);
					getElement(ObjectRepository.idNum).sendKeys(jo2IdNum);
					getElement(ObjectRepository.issueDate).sendKeys(issueDt);
					getElement(ObjectRepository.expDate).sendKeys(expDt);
					getElement(ObjectRepository.addMaiden).sendKeys(joLname);
					getElement(ObjectRepository.addOccupation).sendKeys(joOccupation);
					test.log(Status.INFO, "Identification Information entered for second Joint Owner");
					getElement(ObjectRepository.addPhone).sendKeys(joPhone);
					selectDropdownOpt(ObjectRepository.addPhoneType,joPhoneType);
					getElement(ObjectRepository.addEmail).sendKeys(jo2Email);
					test.log(Status.INFO, "Contact Information entered for second Joint Owner");
					getElement(ObjectRepository.housePymt).sendKeys(housePymt);
					getElement(ObjectRepository.addrYears).sendKeys(howLong2);
					getElement(ObjectRepository.addrMonths).sendKeys(howLong);
					getElement(ObjectRepository.currentEmp).sendKeys(currentEmp);
					getElement(ObjectRepository.monIncome).sendKeys(curIncome);
					getElement(ObjectRepository.empYears).sendKeys(howLong);
					getElement(ObjectRepository.empMonths).sendKeys(howLong);
					getElement(ObjectRepository.prevEmp).sendKeys(jo2PrevEmp);
					getElement(ObjectRepository.prevIncome).sendKeys(jo2PrevIncome);
					getElement(ObjectRepository.prevYears).sendKeys(howLong2);
					getElement(ObjectRepository.prevMonths).sendKeys(howLong2);
					test.log(Status.INFO, "Loan Information entered for second Joint Owner");
					getElement(ObjectRepository.productPageNext).click();
					verifyElementPresent(ObjectRepository.confirmTtl);
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
			test.log(Status.PASS, "Verify multiple joint owners added for existing member");
		}
	}

  @AfterTest
  public void tearDown() {
	 extent.flush();
	 driver.quit();
  }

}
