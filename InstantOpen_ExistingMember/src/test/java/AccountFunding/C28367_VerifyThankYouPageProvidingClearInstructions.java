package AccountFunding;

import java.io.IOException;

import javax.mail.MessagingException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
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

public class C28367_VerifyThankYouPageProvidingClearInstructions extends GenericKeywords{
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
  public void C28367_VerifyThankYouPageProvidingClearInstructions() throws InterruptedException, MessagingException, IOException {
	  if(continuetestcase==true)
	  {
			sheetName = "ProdData";
			int totalRowCount = excl.getRowCount(sheetName);
			for(startIter=1;startIter<=totalRowCount;startIter++) //It is mandatory to have this for loop in every test case
			{	
				if(this.getClass().getSimpleName().equals(excl.getCellData("ProdData", 0, startIter)))
				{
					String loanAmt= excl.getCellData(sheetName, 6, startIter);
					String mmbrNum= excl.getCellData(sheetName, 27, startIter);
					String SSN= excl.getCellData(sheetName, 28, startIter);
					String DOB= excl.getCellData(sheetName, 29, startIter);
					String idType= excl.getCellData(sheetName, 16, startIter);
					String idNum= excl.getCellData(sheetName, 17, startIter);
					String issueDt= excl.getCellData(sheetName, 18, startIter);
					String expDt= excl.getCellData(sheetName, 19, startIter);
					String housePymt= excl.getCellData(sheetName, 20, startIter);
					String addrYears= excl.getCellData(sheetName, 21, startIter);
					String addrMonths= excl.getCellData(sheetName, 22, startIter);
					String currentEmp= excl.getCellData(sheetName, 23, startIter);
					String curIncome= excl.getCellData(sheetName, 24, startIter);
					String empYears= excl.getCellData(sheetName, 25, startIter);
					String empMonths= excl.getCellData(sheetName, 26, startIter);
					String confirmProd1= excl.getCellData(sheetName, 1, startIter);
					String promocode = excl.getCellData(sheetName, 44, startIter);
					String sub_header_text = excl.getCellData(sheetName, 45, startIter);
					String sub_header_underDocument = excl.getCellData(sheetName, 46, startIter);
					scrollToElement(ObjectRepository.mmbrstrt_btn);
					getElement(ObjectRepository.mmbrstrt_btn).click();
					test.log(Status.INFO, "Members Start Here button clicked");
					//Select Products
					getElement(ObjectRepository.personalLoanExpand).click();
					getElement(ObjectRepository.personalCheckBox).click();
					getElement(ObjectRepository.productPageNext).click();
					test.log(Status.INFO, "Personal loan selected");
					//Loan info
					getElement(ObjectRepository.prodLimitTextbox).sendKeys(loanAmt);
					getElement(ObjectRepository.prodInfoNextButton).click();
					test.log(Status.INFO, "Loan amount entered");	
					//Member Verification
					
					getElement(ObjectRepository.mmbrVerifySSN).sendKeys(SSN);
					getElement(ObjectRepository.mmbrVerifyDOB).sendKeys(DOB);
					getElement(ObjectRepository.mmbrVerifyNext).click();					
					test.log(Status.INFO, "Member Verified");
					
					//Delivery Method page
					
					verifyText(ObjectRepository.delivery_method_page_header,"Select a Delivery Method");
					test.log(Status.INFO, "user on Delivery Method page");
					//Enter OTP from Email
					enter_otp_to_the_field_and_procced();
					
					//Applicant Info
					selectDropdownOpt(ObjectRepository.idType,idType);
					getElement(ObjectRepository.idNum).sendKeys(idNum);
					getElement(ObjectRepository.issueDate).sendKeys(issueDt);
					getElement(ObjectRepository.expDate).sendKeys(expDt);
					getElement(ObjectRepository.housePymt).sendKeys(housePymt);
					getElement(ObjectRepository.addrYears).sendKeys(addrYears);
					getElement(ObjectRepository.addrMonths).sendKeys(addrMonths);
					getElement(ObjectRepository.currentEmp).sendKeys(currentEmp);
					getElement(ObjectRepository.monIncome).sendKeys(curIncome);
					getElement(ObjectRepository.empYears).sendKeys(empYears);
					getElement(ObjectRepository.empMonths).sendKeys(empMonths);
					getElement(ObjectRepository.productPageNext).click();
					test.log(Status.INFO, "Applicant Information entered");
					
					//Enter PromoCode
					enterPromocode(promocode);
					//Confirm Accounts
					
					getElement(ObjectRepository.discCheckBox).click();
					getElement(ObjectRepository.agreeCheckBox).click();
					getElement(ObjectRepository.confirmBtn).click();
					
					test.log(Status.INFO, "Accept button clicked");
					verifyElementPresent(ObjectRepository.IdentityTtl);
					
					test.log(Status.INFO, "Identity verification page opened");
					
					String[]options = new String[]{"Loudon, MD","Foo Bar, Inc","Roanoke","123 W 14th Street"};
					for(String eachOption : options){
						
						
						String locator = "//label[text()='"+eachOption+"']";
						scrollToElement(locator);
						getElement(locator).click();
						test.log(Status.INFO, eachOption+" verification question answered");
					}
					

					getElement(ObjectRepository.cnfrm_btn).click();
					test.log(Status.INFO, "Confirm button clicked");
					
					getElement(ObjectRepository.cnfrm_btn).click();
					test.log(Status.INFO, "Submit Application button clicked");
					
//					getElement(ObjectRepository.shareamnt_txt).sendKeys("5");
//					test.log(Status.INFO, "Amount entered");
//					
//					getElement(ObjectRepository.elctrnc_opt).click();
//					test.log(Status.INFO, "Electronic option selected");
//					
//					getElement(ObjectRepository.rtngnmbr_txt).sendKeys("234567876");
//					test.log(Status.INFO, "Routing number entered");
//					
//					getElement(ObjectRepository.acntnmbr_txt).sendKeys("2345678987");
//					test.log(Status.INFO, "Account number entered");
//					
//					getElement(ObjectRepository.vrfyacnt_btn).click();
//					test.log(Status.INFO, "verify account button clicked");
					
					verifyElementPresent(ObjectRepository.thnku_ttl);
					test.log(Status.INFO, "Thanku page opened");
					
					verifyText(ObjectRepository.sub_text_under_header,sub_header_text);
					verifyText(ObjectRepository.sub_text_under_uploadDocument,sub_header_underDocument);
					
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
			test.log(Status.PASS, "Verify credit card funding method for existing member");
		}
	}

  @AfterTest
  public void tearDown() {
	 extent.flush();
	 driver.quit();
  }

}
