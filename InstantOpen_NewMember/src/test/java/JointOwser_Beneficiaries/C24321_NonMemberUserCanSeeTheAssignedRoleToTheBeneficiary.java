package JointOwser_Beneficiaries;

import java.io.IOException;
import java.util.List;

import javax.mail.MessagingException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
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
import com.github.javafaker.Faker;

public class C24321_NonMemberUserCanSeeTheAssignedRoleToTheBeneficiary extends GenericKeywords {

	ExtentReports extent;
	ExtentTest test;

	/*
	   As a non member applicant, I would like to see the roles assigned to the
	   products selected for a Beneficiary added to my application. 
	   Created  Date: 03-19-2020 Created By : Ashish
	   
	 */ 

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
	public void C24321_NonMemberUserCanSeeTheAssignedRoleToTheBeneficiary()
			throws InterruptedException, MessagingException, IOException {

		if (continuetestcase == true) {
			sheetName = "Data";
			int totalRowCount = excl.getRowCount(sheetName);
			for (startIter = 1; startIter <= totalRowCount; startIter++) {
				if (this.getClass().getSimpleName().equals(excl.getCellData("Data", 0, startIter))) {

					String informationHeader = excl.getCellData(sheetName, 23, startIter);
					String informationContent = excl.getCellData(sheetName, 24, startIter);
					String checkingAccountOptionHeader = excl.getCellData(sheetName, 25, startIter);
					String serviceOption = " Debit Card, Mobile Check Deposit, Overdraft Protection Plan, Opt into Courtesy Pay";
					String productOptionsForAllOptions = "Credit Cards; Vehicle Loans and Refinance Options (Auto, Boat, Motorcycle, RV/Camper); Personal Loans;Certificates of Deposit (CDs);Money Market Accounts;Savings Account;Additional Services and Features";
					Faker fk = new Faker();
					String num = getRandom();
					String fname = fk.name().firstName();

					String lname = fk.name().lastName();

					String strtaddress = excl.getCellData(sheetName, 5, startIter);
					String zipcode = excl.getCellData(sheetName, 6, startIter);
					String ssn = excl.getCellData(sheetName, 7, startIter);
					ssn = ssn + num;
					String dob = excl.getCellData(sheetName, 8, startIter);
					dob = dob + num;
					String idtyp = excl.getCellData(sheetName, 9, startIter);
					String idnumber = excl.getCellData(sheetName, 10, startIter);
					String issue_dt = excl.getCellData(sheetName, 11, startIter);
					String expr_dt = excl.getCellData(sheetName, 12, startIter);
					String mothername = excl.getCellData(sheetName, 13, startIter);
					String crrnt_emplyr = excl.getCellData(sheetName, 14, startIter);
					String occupation = excl.getCellData(sheetName, 15, startIter);
					String phonenmbr = excl.getCellData(sheetName, 16, startIter);
					String phonetyp = excl.getCellData(sheetName, 17, startIter);
					String primary_email = excl.getCellData(sheetName, 18, startIter);
					String hear_opt = excl.getCellData(sheetName, 19, startIter);

					verifyElementPresent(ObjectRepository.app_ttl);
					test.log(Status.INFO, "Instant Open Title appearing");

					scrollToElement(ObjectRepository.nonmmbrstrt_btn);
					getElement(ObjectRepository.nonmmbrstrt_btn).click();
					test.log(Status.INFO, "Non Member Start here button clicked");

					Thread.sleep(3000);

					verifyText(ObjectRepository.inforMsgHeader, informationHeader);
					verifyText(ObjectRepository.inforMsgContent, informationContent);
					verifyText(ObjectRepository.checkingAccountOptionHeader, checkingAccountOptionHeader);
					checkingOptionValidation("High Yield Checking");
					serviceOptionValidation("High Yield Checking", serviceOption);

					getElement(ObjectRepository.selectRadioOption("Yes")).click();
					test.log(Status.INFO, "Other option selected as Yes");

					productOptions(productOptionsForAllOptions);
					expandProductsAndValidateEachOptions("Credit Cards", "CreditCard");
					creditCardCheckedUncheckedValidator("Classic", false);

					scrollToElement(ObjectRepository.carLoanExpand);
					getElement(ObjectRepository.carLoanExpand).click();
					getElement(ObjectRepository.autoLoanTitle).click();

					scrollToElement(ObjectRepository.personalLoanExpand);
					getElement(ObjectRepository.personalLoanExpand).click();
					getElement(ObjectRepository.myWay4000Title).click();

					scrollToElement(ObjectRepository.personalLoanExpand);
					getElement(ObjectRepository.crtfctdpst_opt).click();
					getElement(ObjectRepository.crtfctdpst_amnttxt).sendKeys("1000");
					selectDropdownOpt(ObjectRepository.crtfctdpst_term, "3");

					scrollToElement(ObjectRepository.mrktmnydpst_opt);
					getElement(ObjectRepository.mrktmnydpst_opt).click();
					getElement(ObjectRepository.moneyMarket_chk).click();

					scrollToElement(ObjectRepository.svngacnt_exp);
					getElement(ObjectRepository.svngacnt_exp).click();
					getElement(ObjectRepository.club_opt).click();

					getElement(ObjectRepository.continue_btn).click();

					// Credit Card Information page page
					verifyElementPresent(ObjectRepository.crdtcrdinf_ttl);
					test.log(Status.INFO, "Credit Card Information page displayed");
					getElement(ObjectRepository.crdtlimit_txt).sendKeys("500");
					click_using_Js(ObjectRepository.edt_btn);

					// vehical loan information page
					verifyElementPresent(ObjectRepository.carLoanInfoTtl);
					test.log(Status.INFO, "Vehicle Loan Info page displayed");
					getElement(ObjectRepository.crdtlimit_txt).sendKeys("1000");
					getElement(ObjectRepository.carPurchPrice).sendKeys("5500");
					getElement(ObjectRepository.carMake).sendKeys("BMW");
					getElement(ObjectRepository.carModel).sendKeys("Test");
					getElement(ObjectRepository.carYear).sendKeys("2020");
					getElement(ObjectRepository.carMiles).sendKeys("10");
					getElement(ObjectRepository.carVIN).sendKeys("Test");
					click_using_Js(ObjectRepository.edt_btn);

					// Personal loan information page

					verifyElementPresent(ObjectRepository.psnlLoanInfTtl);
					test.log(Status.INFO, "Personal Loan Info page displayed");
					getElement(ObjectRepository.prodLimitTextbox).sendKeys("4000");
					click_using_Js(ObjectRepository.edt_btn);

					verifyText(ObjectRepository.primaryApplicantInfoPageTitle, "Primary Applicant Information");

					getElement(ObjectRepository.fname_txt).sendKeys(fname);
					getElement(ObjectRepository.lname_txt).sendKeys(lname);
					getElement(ObjectRepository.strtaddrs_txt).sendKeys(strtaddress);
					getElement(ObjectRepository.zip_txt).sendKeys(zipcode);
					getElement(ObjectRepository.ssn_txt).sendKeys(ssn);
					getElement(ObjectRepository.dob_cal).sendKeys(dob);
					selectDropdownOptContain(ObjectRepository.idtyp_drop, idtyp);
					getElement(ObjectRepository.idnmbr_txt).sendKeys(idnumber);
					getElement(ObjectRepository.issuedt_cal).sendKeys(issue_dt);
					getElement(ObjectRepository.expdt_cal).sendKeys(expr_dt);
					selectDropdownOptContain(ObjectRepository.hrabttdecu_drop, hear_opt);
					getElement(ObjectRepository.mothername_txt).sendKeys(mothername);
					getElement(ObjectRepository.crrntemplyr_txt).sendKeys(crrnt_emplyr);
					getElement(ObjectRepository.occptn_txt).sendKeys(occupation);
					getElement(ObjectRepository.phonenmbr_txt).sendKeys(phonenmbr);
					selectDropdownOptContain(ObjectRepository.phonetyp_drop, phonetyp);
					getElement(ObjectRepository.primaryemail_txt).sendKeys(primary_email);
					getElement(ObjectRepository.housingPayment).sendKeys("1000");
					getElement(ObjectRepository.addressYearBox).sendKeys("90");
					getElement(ObjectRepository.addressMonthBox).sendKeys("2");
					getElement(ObjectRepository.monthlySal).sendKeys("4000");
					getElement(ObjectRepository.employeeDurationYear).sendKeys("99");
					getElement(ObjectRepository.employeeDurationMonth).sendKeys("3");

					scrollToElement(ObjectRepository.addBeneficiaries_CheckBox);
					getElement(ObjectRepository.addBeneficiaries_CheckBox).click();
					test.log(Status.INFO, "Bemeficiaries Checkbox Selected");

					getElement(ObjectRepository.continue_btn).click();

					verifyElementPresent(ObjectRepository.additional_beneficiaryPageTitle);
					test.log(Status.PASS, "Your Beneficiary Information page displayed");

					//code to add beneficiary detail
					
					String beneficiary_fname = fk.name().firstName();
					  getElement(ObjectRepository.fname_txt).sendKeys(beneficiary_fname);
					 
					  
					   getElement(ObjectRepository.lname_txt).sendKeys(lname);
					  
					   
					   getElement(ObjectRepository.strtaddrs_txt).sendKeys(strtaddress);
					   
					   getElement(ObjectRepository.zip_txt).sendKeys(zipcode);
					    String Newssn = excl.getCellData(sheetName, 20, startIter); 
					    Newssn =  Newssn + num;
					   getElement(ObjectRepository.ssn_txt).sendKeys(Newssn);
					  
					   
					   getElement(ObjectRepository.dob_cal).sendKeys(dob);
					  
					   
					   selectDropdownOptContain(ObjectRepository.idtyp_drop,idtyp); 
					   
					   getElement(ObjectRepository.idnmbr_txt).sendKeys(idnumber); 
					   
					   getElement(ObjectRepository.issuedt_cal).sendKeys(issue_dt); 
					   
					   getElement(ObjectRepository.expdt_cal).sendKeys(expr_dt);
					   
					   
					   getElement(ObjectRepository.phonenmbr_txt).sendKeys(
					   phonenmbr);
					   selectDropdownOptContain(ObjectRepository.phonetyp_drop,
					   phonetyp);
					   getElement(ObjectRepository.primaryemail_txt).sendKeys(primary_email);
					   
					   getElement(ObjectRepository.continue_btn).click();
					   
					   verifyElementPresent(ObjectRepository.confirmAccountRole_title);
					   test.log(Status.PASS,"Confirm Account Roles Page Displayed");
					   System.out.println(excl.getCellData(sheetName, 31, startIter));
					   driver.getPageSource().contains(excl.getCellData(sheetName, 31, startIter));
					   test.log(Status.INFO,"Confirm Account Roles Page, Content is Displayed");
					   
					   //Verification of Beneficiary table
					   
					  
						   
							   verifyText(ObjectRepository.confirmAccountRoleF_Name(2), fname);							   
							   verifyText(ObjectRepository.confirmAccountRoleF_Name(3), beneficiary_fname);
							   System.out.println("First Name and Beneficiary name matched");
							   test.log(Status.INFO,"Beneficiary Name Matched");
							   
							   boolean status=verifyProductSelectionConfirmAccountRole();
							   if(status==true)
							   {
								   test.log(Status.PASS,"Product selection verification Passed");   
							   }
							   else
							   {
								   test.log(Status.FAIL,"Product selection verification Failed");
							   }
							   
					  
				}
			}
		}

	}

	public boolean verifyProductSelectionConfirmAccountRole() throws InterruptedException {
		// TODO Auto-generated method stub
		boolean status = true;
		 for (int index=2;index<=8;index++)
		   {
			   String expectedProducts[] = new String[] { "","","Classic MasterCard ®","Auto Loan (New or Used)","My Way Loan: $4,000","Money Market","Club Account","High Yield Checking", "Share" };
			   
			   verifyText(ObjectRepository.confirmAccountProduct_Name(index),expectedProducts[index]);
			   test.log(Status.INFO,"Product name "+ expectedProducts[index] + " Matched");
			   
			   String productcheckedStatusmember=getAttribute(ObjectRepository.productcheckedStatusmember(index),"class");
			   if(productcheckedStatusmember.contains("checked") && productcheckedStatusmember.contains("disabled") )
			   {
				  
				   System.out.println("Member Product Check status:"+expectedProducts[index]+ " Prod Status : Disabled");
				  
			   }
			   else
			   {
				   status=false;
				   System.out.println("Member Product Check status:"+expectedProducts[index]+ " Prod Status : Disabled");
				  
			   }
			   
			   
			   if(index>4)
			   {
				   String productcheckedstatusBefsmember=getAttribute(ObjectRepository.productcheckedstatusBefsmember(index),"class");
				   
				   if(productcheckedstatusBefsmember.contains("checked"))
				   {
					  
					   System.out.println("Beneficiary Product Check status:"+expectedProducts[index]+ " Prod Status: Checked");
					  
				   }
				   else
				   {
					   status=false;
					   System.out.println("Failed Beneficiary Prodcut Name: " + expectedProducts[index] + "Product Status: Disbaled");
				   }
			   }else
			   {
				   String productuncheckedStatusBef=getAttribute(ObjectRepository.productuncheckedStatuBefsmember(index),"class");
				   
				   if(productuncheckedStatusBef.contains("disabled") )
				   {
					  
					   System.out.println("Beneficiary Product Name: "+expectedProducts[index]+ " Prod Status: Disabled");
					   
				   }
				   else
				   {
					   status=false;
					   System.out.println("Failed Beneficiary Prodcut Name: " + expectedProducts[index] + "Product Status: Checked ");
				   }
				   
			   }
		   }
		 
		 return status;
	}

	@AfterMethod
	public void afterMethod(ITestResult result) throws Throwable {
		if (result.getStatus() == ITestResult.FAILURE) {
			test.log(Status.FAIL, "Test Failed-" + result.getThrowable());

			takescreenshot(this.getClass().getSimpleName(), test);
		} else {
			test.log(Status.PASS, "As a non member applicant, I would like to see the roles assigned to the products selected for a Beneficiary added to my application.");
		}
	}

	@AfterTest
	public void tearDown() {
		extent.flush();
		// driver.quit();
	}

}
