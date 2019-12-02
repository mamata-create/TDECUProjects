package com.FrameworkComponents;

public class ObjectRepository {

	public static String app_ttl="//h1[contains(text(),'Experience the TDECU Difference')]";
	public static String nonmmbrstrt_btn="//input[@id='btnNonMember']";
	public static String mmbrstrt_btn="//input[@id='btnMember']";
	
	public static String nochkacnt_rdbtn="//*[@id='rbNoChecking']/label/strong";
	public static String othrprdctno_rdbtn="//*[@id='rbOtherProdNo']/label";
	public static String continue_btn="//input[@id='NextButton_SubmitButton']";
	
	public static String fname_txt="//input[@id='tbFirstName_TextBox']";
	public static String mname_txt="//input[@id='tbMiddleName_TextBox']";
	public static String lname_txt="//input[@id='tbLastName_TextBox']";
	public static String namesfx_txt="//input[@id='tbNameSuffix_TextBox']";
	public static String strtaddrs_txt="//input[@id='AddressTextBox_AddressLine1']";
	public static String zip_txt="//input[@id='AddressTextBox_AddressCityStateZip']";
	
	public static String ssn_txt="//input[@id='SSNTextBox_TextBox']";
	public static String dob_cal="//input[@id='tbBirthDate_RadDatePicker']";
	public static String idtyp_drop="//select[@id='IDType_IDType']";
	public static String idnmbr_txt="//input[@id='IDType_IDNumber']";
	public static String issuedt_cal="//input[@id='IDType_IssueDate']";
	public static String expdt_cal="//input[@id='IDType_ExpirationDate']";
	public static String hrabttdecu_drop="//select[@id='HowDidYouHear_DropDownList']";
	public static String mothername_txt="//input[@id='MothersMaidenName_TextBox']";
	public static String crrntemplyr_txt="//input[@id='CurrentEmployer2_TextBox']";
	public static String occptn_txt="//input[@id='Occupation_TextBox']";
	
	public static String phonenmbr_txt="//input[@id='tbPhone1_RadMaskedTextBox']";
	public static String phonetyp_drop="//select[@id='tbPhone1_ddPhoneNumberType']";
	public static String primaryemail_txt="//input[@id='tbEmail1_RadTextBox']";
	
	//
	public static String mstrcrdtcard_exp="//h4[@class='panel-title CursorPointer' and contains(text(),'MasterCard Credit Card')]";
	public static String classicmstrcrd_opt="//lable[contains(text(),'Classic MasterCard')]";
	public static String chkingmoneymrkt_exp="//h4[@class='panel-title CursorPointer' and contains(text(),'Checking & Money Market Accounts')]";
	public static String clscchking_opt="//label[contains(text(),'Classic Checking')]";
	public static String dbtcrd_opt="//label[contains(text(),'Debit Card')]";
	public static String ovrdrftprtctn_opt="//label[contains(text(),'Overdraft Protection Plan')]";
	public static String svngacnt_exp="//h4[@class='panel-title CursorPointer' and contains(text(),'Savings Account')]";
	public static String club_opt="//label[contains(text(),'Club')]";
	
	public static String crdtcrdinf_ttl="//strong[text()='Credit Card Info']";
	public static String crdtlimit_txt="//input[@id='tbLoanAmount_MoneyTextBox']";
	public static String edt_btn="//input[@id='btnEdit']";
	
	public static String mmbrvrfctn_ttl="//strong[text()='Member Verification']";
	public static String mmbrnmbr_txt="//input[@id='tbEMAMMemberNumber_TextBox']";
	public static String ssnnmbr_txt="//input[@id='tbEMAMSSNTextBox_TextBox']";
	public static String dateofbirth_txt="//input[@id='tbBirthDate_RadDatePicker']";
	
	public static String crrnttdecu_opt="//*[@id='rbFamily']/div";
			//"//input[@id='rbFamily_RadioButton']";
	public static String cnfrmacnt_ttl="//strong[text()='Confirm Account Selections']";
	public static String cnfrm_btn="//input[@id='btnNext_SubmitButton']";
	public static String tnc_chkbx="//span[@id='cbDisclosures']/div[@class='icheckbox_square-grey']";
	//Agreement and Signature
	public static String agreementAndSignature = "(//*[contains(text(),'Agreement and Signature')]/following::div[@class='icheckbox_square-grey'])[1]";
	public static String idnty_ttl="//h3[text()='Identity Verification']";
	
	//Backup withholding Certifications
	
	public static String taxpayerIdentificationNumber ="(//*[contains(text(),'Backup Withholding Certifications')]/following::div[@class='icheckbox_square-grey'])[1]";
	public static String backupWithholding = "(//*[contains(text(),'Backup Withholding Certifications')]/following::div[@class='icheckbox_square-grey'])[2]";
	
	//US citizenship
	public static String citizenshipCheckbox ="(//*[contains(text(),'U.S. Citizens')]/following::div[@class='icheckbox_square-grey'])[1]";
	
//
	public static String Corporation_Verification="//label[text()='None of the above']";
	
	public static String address_Verification="//label[text()='I have never been associated with any of these addresses']";

	public static String background_Verification="//label[text()='I have never been associated with this address']";
	public static String Counties_Verification="//label[text()='I have never lived in any of these counties']";
	
	public static String uscitizenapply_chkbx="//*[@id='CheckBox01']/div";
	public static String backupholding_chkbx="//*[@id='CheckBox02']/div";
	
	public static String shareamnt_txt="//input[contains(@id,'ProductFunding_FormProductID')]";
	public static String clubamntprnt_txt="//label[contains(@for,'ProductFunding_FormProductID') and contains(text(),'Club')]/parent::*/parent::*";
	public static String fnd_opt="//label[text()='Transfer Funds']";
	public static String elctrnc_opt="//label[text()='Electronic Check']";
	public static String sbmt_btn="//input[@id='NextButton2_SubmitButton']";
	
	public static String rtngnmbr_txt="//input[@id='ACHFundingAccountVerification_tbRoutingNumber_NumericTextBox']";
	public static String acntnmbr_txt="//input[@id='ACHFundingAccountVerification_tbAccountNumber_TextBox']";
	public static String vrfyacnt_btn="//button[@id='DeferredInputSubmit']";
	
	public static String thnku_ttl="//h1[text()='Thank You for Your Application!']";
	
	public static String sbmtupload_btn="//input[@id='DocumentList02_rbdocuments']";
	
	
	
	//Applicant Information
	public static String aplcntinfo_ttl="//div[@class='SectionHeaders' and contains(text(),'Applicant Information')]";
	
	//Savings Account
	
	public static String savingsAccountLocator = "//h4[contains(text(),'Savings Account')]/i";
	public static String clubCheckBox = "//input[contains(@id,'RequiredSavings_ProductCheckbox')]/..";
	
	//Certificates of Deposits
	public static String certificateOfDeposit = "//h4[contains(text(),'Certificates of Deposit')]/i";
	public static String enterAmountTxtField = "//label[contains(text(),'Enter an Amount')]/following::input[1]";
	public static String selectTermDropdown = "//label[contains(text(),'Select a term')]/following::select";
	public static String termCheckBox = "//div[contains(@style,'display: block')]//div[contains(@class,'icheckbox')]//following::label[1]";
	
	
	//
	public static String Highyieldchking_opt="//label[contains(text(),'High Yield Checking')]/preceding::div[1]"; 
	public static String debitCardUnderHyield ="//label[contains(text(),'High Yield Checking')]/following::label[1]";
	public static String overDraftUnderHyield = "//label[contains(text(),'High Yield Checking')]/following::label[2]";
	
	//DNA Upgrade started
	
	public static String loginid_txt="//input[@id='fldUsername']";
	public static String password_txt="//input[@id='fldPassword']";
	public static String login_btn="//button[@test-id='btnSubmit']";
	public static String logoff_lnk="//div[text()='Log Off']";
	
	public static String otpemail_btn="//div[@test-id='btnTacTarget']";
	public static String otp_txt="//input[@test-id='fldSAC']";
	public static String submit_btn="//button[@test-id='btnSubmit']";
	public static String register_btn="//div[@test-id='btnRegister']";
	public static String service_menu="//div[@class='menu-text' and contains(text(),'Services')]";
	public static String stppaymnt_menu="//div[@class='menu-text' and contains(text(),'Stop Payment')]";
	public static String stppaymnt_ttl="//h1[contains(text(),'Stop Payment')]";
	public static String stppaymnt_sndrqst_btn="//button[@test-id='btnSend']";
	public static String stppaymnt_snglchk="//div[@test-id='lblSingleChk']";
	public static String stppaymnt_acnt="//div[@test-id='lblSelAC']";
	public static String stppaymnt_svbtn="//span[@class='integerInputButtonText' and text()='Save']";
	
	//Stop payment additional  step of DNA
	
	public static String payeeName ="//input[@test-id='tbxPayee']";
	public static String setBtn = "//div[@test-id='btnSet']";
	public static String note ="//input[@placeholder='Description']";
	public static String successMsg ="//div[contains(text(),'Stop Payments Successful')]";
	public static String viewInActivityBtn ="//button[contains(text(),'View In Activity Center')]";
	public static String activityCenterHeader = "//h1[contains(text(),'Activity Center')]";
	public static String recordOfTable ="(//table[@test-id='txtAccountsTable']//tr)[2]";
	public static String transactionDetails ="(//table[@test-id='txtAccountsTable']//tr[@test-id='txtTransactionDetail'])[1]";
	
	//Multi Check DNA
	
	public static String stppaymnt_mltchk="//div[@test-id='lblMultiChk']";
	public static String stppaymnt_notetxt="//div[@test-id='tbxDesc']/input";
	public static String stppaymnt_setbtn="//div[@test-id='btnSet']";
	
	//My Account information Verification
	
	public static String inforMsgHeader = "(//span[@id='pnlNewMemberMessage']//following::div[@class='col-sm'])[1]/h3";
	public static String inforMsgContent = "(//span[@id='pnlNewMemberMessage']//following::div[@class='col-sm'])[1]/p";
	public static String checkingAccountOptionHeader = "(//span[@id='pnlNewMemberMessage']//following::div[@class='col-sm'])[2]/h4";
	public static String dontWantCheckingOption = "//label/strong[contains(text(),'I don’t want to open a checking account today.')]";
	public static String bottomInfoMsg = "//h4[contains(text(),'looking for loans')]";
	public static String primaryApplicantInfoPageTitle ="//*/strong[contains(text(),'Primary Applicant Information')]";
	public static String selectRadioOption(String radioOption){
		String Option = "//*[contains(text(),'looking for loans')]/following::label[contains(@for,'"+radioOption+"_RadioButton')]";
		return Option;
	}
 
	public static String backButton = "//input[@id='BackButton_SubmitButton']";
	public static String productPageBackBtn = "//input[contains(@id,'Back_SubmitButton')]";
	public static String vehicleLoanPage = "//strong[contains(text(),'Vehicle Loan Info')]";
	public static String personalLoanPage = "//strong[contains(text(),'Personal Loan Info')]";
	public static String errorSummary = "//span[contains(@id,'ErrorSummary')]//li";
	
	public static String subproductName(String productName){
		String locator = "//*[contains(text(),'"+productName+"')]/i";
		return locator;
	}
	
	public static String locatorInfo(String option){
		String locator = "//label[contains(text(),'"+option+"')]/../div";
		String prop = GenericKeywords.getElement(locator).getAttribute("class");
		return prop;
	}
	
	public static String locatorAdditionalOption(String option){
		String locator = "//label[contains(text(),'"+option+"')]/../div";
		return locator;
	}
	
	public static String modalHelpIcon = "//label[contains(text(),'E-Documents')]/following::div[@class='Service_MoreInfo']//button";
	public static String eDocumentHeader = "//*[@id='modalEdocumentsLabel']";
	public static String eDocumentModalBody = "//*[@id='modalEdocumentsLabel']/following::p";
	public static String eDocumentModalCloseButton = "//*[@id='modalEdocumentsLabel']/following::button[1]";
	
	public static String loanAmountTxt = "//input[contains(@id,'LoanAmount')]";
	public static String loanTerm = "//select[contains(@id,'Term')]";
	
	public static String getTermCertificateLocator(String term){
		String termLocator = "//div[contains(@style,'display: block')]/label[contains(text(),'"+term+" Month Share Certificate')]";
		return termLocator;
	}
	public static String creditCardProduct ="(//label[contains(@for,'CreditCard_ProductCheckbox')])[1]";
	public static String creditcardLimitTxt ="//input[contains(@id,'MoneyTextBox')]";
	public static String housingPayment ="//input[@id='HousePayment_MoneyTextBox']";
	public static String addressYearBox = "//input[@id='AddresstDuration_YearTextBox']";
	public static String addressMonthBox ="//input[@id='AddresstDuration_MonthTextBox']";
	public static String monthlySal = "//input[@id='MonthlySalary_MoneyTextBox']";
	public static String employeeDurationYear ="//input[@id='EmploymentDuration_YearTextBox']";
	public static String employeeDurationMonth ="//input[@id='EmploymentDuration_MonthTextBox']";
	public static String cardType_dropdown = "//select[@name='ProductDropDownList_DropDownList']";
	
	public static String getLocatorBasedOnOption(String option){
		String locator = "//*[contains(text(),'"+option+"')]";
		return locator;
	}
	
	public static String accountFundingPage = "//*[contains(text(),'Account Funding')]";
	public static String savingsAccountText = "//*[contains(text(),'Savings Account')]/following::div[1]//li";
	
	//Vehicle Loans
		public static String carLoanExpand = "//h4[contains(text(),'Vehicle')]/i";
		public static String autoLoanTitle = "//label[@for='Vehicle_ProductCheckbox_1004_1']";
		public static String autoLoanCheckBox = "//div[@id='Vehicle_ProductPanel_1004_1']//div[@class='icheckbox_square-grey']";
		public static String autoLoanCheckedBox = "//div[@id='Vehicle_ProductPanel_1004_1']//div[contains(@class,'checked')]";
		public static String autoRefinTitle = "//label[@for='Vehicle_ProductCheckbox_1252_1']";
		public static String autoRefinCheckBox = "//div[@id='Vehicle_ProductPanel_1252_1']//div[@class='icheckbox_square-grey']";
		public static String autoRefinCheckedBox = "//div[@id='Vehicle_ProductPanel_1252_1']//div[contains(@class,'checked')]";
		public static String motorcycleTitle = "//label[@for='Vehicle_ProductCheckbox_1014_1']";
		public static String motorcycleCheckBox = "//div[@id='Vehicle_ProductPanel_1014_1']//div[@class='icheckbox_square-grey']";
		public static String motorcycleCheckedBox = "//div[@id='Vehicle_ProductPanel_1014_1']//div[contains(@class,'checked')]";
		public static String motorcycleRatesInfo = "//div[contains(@id,'MoreInfo_1014_1')]//ul[@class='fa-ul']/li";
		public static String cycleRefinTitle = "//label[@for='Vehicle_ProductCheckbox_1253_1']";
		public static String cycleRefinCheckBox = "//div[@id='Vehicle_ProductPanel_1253_1']//div[@class='icheckbox_square-grey']";
		public static String cycleRefinCheckedBox = "//div[@id='Vehicle_ProductPanel_1253_1']//div[contains(@class,'checked')]";
		public static String cycleRefinRatesInfo = "//div[contains(@id,'MoreInfo_1253_1')]//ul[@class='fa-ul']/li";
		public static String boatLoanTitle = "//label[@for='Vehicle_ProductCheckbox_1010_1']";
		public static String boatLoanCheckBox = "//div[@id='Vehicle_ProductPanel_1010_1']//div[@class='icheckbox_square-grey']";
		public static String boatLoanCheckedBox = "//div[@id='Vehicle_ProductPanel_1010_1']//div[contains(@class,'checked')]";
		public static String boatLoanRatesInfo = "//div[contains(@id,'MoreInfo_1010_1')]//ul[@class='fa-ul']/li";
		public static String boatRefinTitle = "//label[@for='Vehicle_ProductCheckbox_1255_1']";
		public static String boatRefinCheckBox = "//div[@id='Vehicle_ProductPanel_1255_1']//div[@class='icheckbox_square-grey']";
		public static String boatRefinCheckedBox = "//div[@id='Vehicle_ProductPanel_1255_1']//div[contains(@class,'checked')]";
		public static String boatRefinRatesInfo = "//div[contains(@id,'MoreInfo_1255_1')]//ul[@class='fa-ul']/li";
		public static String camperLoanTitle = "//label[@for='Vehicle_ProductCheckbox_1011_1']";
		public static String camperLoanCheckBox = "//div[@id='Vehicle_ProductPanel_1011_1']//div[@class='icheckbox_square-grey']";
		public static String camperLoanCheckedBox = "//div[@id='Vehicle_ProductPanel_1011_1']//div[contains(@class,'checked')]";
		public static String camperRatesInfo = "//div[contains(@id,'MoreInfo_1011_1')]//ul[@class='fa-ul']/li";
		public static String camperRefinTitle = "//label[@for='Vehicle_ProductCheckbox_1254_1']";
		public static String camperRefinCheckBox = "//div[@id='Vehicle_ProductPanel_1254_1']//div[@class='icheckbox_square-grey']";
		public static String camperRefinCheckedBox = "//div[@id='Vehicle_ProductPanel_1254_1']//div[contains(@class,'checked')]";
		public static String camperRefinRatesInfo = "//div[contains(@id,'MoreInfo_1254_1')]//ul[@class='fa-ul']/li";
		public static String watercraftTitle = "//label[@for='Vehicle_ProductCheckbox_1013_1']";
		public static String watercraftCheckBox = "//div[@id='Vehicle_ProductPanel_1013_1']//div[@class='icheckbox_square-grey']";
		public static String watercraftCheckedBox = "//div[@id='Vehicle_ProductPanel_1013_1']//div[contains(@class,'checked')]";
		public static String jetSkiInfo = "//div[contains(@id,'MoreInfo_1013_1')]//ul[@class='fa-ul']/li[1]";
		public static String jetSkiRatesInfo = "//div[contains(@id,'MoreInfo_1013_1')]//ul[@class='fa-ul']/li[2]";
		public static String atvLoanTitle = "//label[@for='Vehicle_ProductCheckbox_6311_1']";
		public static String atvLoanCheckBox = "//div[@id='Vehicle_ProductPanel_6311_1']//div[@class='icheckbox_square-grey']";
		public static String atvLoanCheckedBox = "//div[@id='Vehicle_ProductPanel_6311_1']//div[contains(@class,'checked')]";
		public static String atvRatesInfo = "//div[contains(@id,'MoreInfo_6311_1')]//ul[@class='fa-ul']/li";
		//Vehicle Loan Info
		public static String carLoanInfoTtl="//strong[text()='Vehicle Loan Info']";
		public static String carPriceLbl= "//label[@for='tbPurchasePrice_MoneyTextBox']";
		public static String carPurchPrice = "//input[@id='tbPurchasePrice_MoneyTextBox']";
		public static String carMakeLbl= "//label[@for='tbMake_TextBox']";
		public static String carMake= "//input[@id='tbMake_TextBox']";
		public static String carModelLbl= "//label[@for='tbModel_TextBox']";
		public static String carModel= "//input[@id='tbModel_TextBox']";
		public static String carYearLbl= "//label[@for='tbYear_TextBox']";
		public static String carYear= "//input[@id='tbYear_TextBox']";
		public static String carMilesLbl= "//label[@for='tbMileage_TextBox']";
		public static String carMiles= "//input[@id='tbMileage_TextBox']";
		public static String carVINLbl= "//label[@for='tbVIN_TextBox']";
		public static String carVIN= "//input[@id='tbVIN_TextBox']";
		public static String errorType = "//select[contains(@name,'DropDown')and contains(@style,'LightYellow')]";
		public static String typeAsterisk= "//span[contains(@id,'DropDown')and @style='color:Red;']";
		public static String errorAmount = "//input[contains(@name,'LoanAmount')and contains(@style,'LightYellow')]";
		public static String amountAsterisk= "//span[@id='ctl33' and @style='color:Red;']";
		public static String errorPrice = "//input[contains(@name,'Purchase')and contains(@style,'LightYellow')]";
		public static String priceAsterisk= "//span[@id='ctl36' and @style='color:Red;']";
		public static String errorVIN = "//input[contains(@name,'VIN')and contains(@style,'LightYellow')]";
		public static String VINasterisk= "//span[contains(@id,'VIN')and @style='color:Red;']";
		public static String errorYear = "//input[contains(@name,'Year')and contains(@style,'LightYellow')]";
		public static String yearAsterisk= "//span[contains(@id,'Year')and @style='color:Red;']";
		public static String errorMiles = "//input[contains(@name,'Mileage')and contains(@style,'LightYellow')]";
		public static String milesAsterisk= "//span[contains(@id,'Mileage')and @style='color:Red;']";
		
		//Personal Loans
		public static String personalLoanExpand = "//h4[contains(text(),'Personal')]/i";
		public static String stormCheckBox= "//div[@id='PersonalLoan_ProductPanel_6449_1']//div[@class='icheckbox_square-grey']";
		public static String myWay4000Title = "//label[@for='PersonalLoan_ProductCheckbox_2089_1']";
		public static String myWay4000CheckBox = "//div[@id='PersonalLoan_ProductPanel_2089_1']//div[@class='icheckbox_square-grey']";
		public static String myWay4000CheckedBox = "//div[@id='PersonalLoan_ProductPanel_2089_1']//div[contains(@class,'checked')]";
		public static String myWay48Term = "//div[contains(@id,'MoreInfo_2089_1')]//ul[@class='fa-ul']/li[1]";
		public static String myWay4000Collat = "//div[contains(@id,'MoreInfo_2089_1')]//ul[@class='fa-ul']/li[2]";
		public static String myWay4000APR = "//div[contains(@id,'MoreInfo_2089_1')]//ul[@class='fa-ul']/li[3]";
		public static String myWay6000Title = "//label[@for='PersonalLoan_ProductCheckbox_1261_1']";
		public static String myWay6000CheckBox = "//div[@id='PersonalLoan_ProductPanel_1261_1']//div[@class='icheckbox_square-grey']";
		public static String myWay6000CheckedBox = "//div[@id='PersonalLoan_ProductPanel_1261_1']//div[contains(@class,'checked')]";
		public static String myWay60Term = "//div[contains(@id,'MoreInfo_1261_1')]//ul[@class='fa-ul']/li[1]";
		public static String myWay6000Collat = "//div[contains(@id,'MoreInfo_1261_1')]//ul[@class='fa-ul']/li[2]";
		public static String myWay6000APR = "//div[contains(@id,'MoreInfo_1261_1')]//ul[@class='fa-ul']/li[3]";
		public static String myWay7000Title = "//label[@for='PersonalLoan_ProductCheckbox_2090_1']";
		public static String myWay7000CheckBox = "//div[@id='PersonalLoan_ProductPanel_2090_1']//div[@class='icheckbox_square-grey']";
		public static String myWay7000CheckedBox = "//div[@id='PersonalLoan_ProductPanel_2090_1']//div[contains(@class,'checked')]";
		public static String myWay72Term = "//div[contains(@id,'MoreInfo_2090_1')]//ul[@class='fa-ul']/li[1]";
		public static String myWay7000Collat = "//div[contains(@id,'MoreInfo_2090_1')]//ul[@class='fa-ul']/li[2]";
		public static String myWay7000APR = "//div[contains(@id,'MoreInfo_2090_1')]//ul[@class='fa-ul']/li[3]";
		public static String personalTitle = "//label[@for='PersonalLoan_ProductCheckbox_1262_1']";
		public static String personalCheckBox = "//div[@id='PersonalLoan_ProductPanel_1262_1']//div[@class='icheckbox_square-grey']";
		public static String personalCheckedBox = "//div[@id='PersonalLoan_ProductPanel_1262_1']//div[contains(@class,'checked')]";
		public static String personalDesc1 = "//div[contains(@id,'MoreInfo_1262_1')]//ul[@class='fa-ul']/li[1]";
		public static String personalDesc2 = "//div[contains(@id,'MoreInfo_1262_1')]//ul[@class='fa-ul']/li[2]";
		public static String homeAdvTitle = "//label[@for='PersonalLoan_ProductCheckbox_1420_1']";
		public static String homeAdvCheckBox = "//div[@id='PersonalLoan_ProductPanel_1420_1']//div[@class='icheckbox_square-grey']";
		public static String homeAdvCheckedBox = "//div[@id='PersonalLoan_ProductPanel_1420_1']//div[contains(@class,'checked')]";
		public static String cash$tashTitle = "//label[@for='PersonalLoan_ProductCheckbox_1007_1']";
		public static String cash$tashCheckBox = "//div[@id='PersonalLoan_ProductPanel_1007_1']//div[@class='icheckbox_square-grey']";
		public static String cash$tashCheckedBox = "//div[@id='PersonalLoan_ProductPanel_1007_1']//div[contains(@class,'checked')]";
		public static String cdSecuredTitle = "//label[@for='PersonalLoan_ProductCheckbox_1256_1']";
		public static String cdSecuredCheckBox = "//div[@id='PersonalLoan_ProductPanel_1256_1']//div[@class='icheckbox_square-grey']";
		public static String cdSecuredCheckedBox = "//div[@id='PersonalLoan_ProductPanel_1256_1']//div[contains(@class,'checked')]";
		public static String shareSecuredTitle = "//label[@for='PersonalLoan_ProductCheckbox_1012_1']";
		public static String shareSecuredCheckBox = "//div[@id='PersonalLoan_ProductPanel_1012_1']//div[@class='icheckbox_square-grey']";
		public static String shareSecuredCheckedBox = "//div[@id='PersonalLoan_ProductPanel_1012_1']//div[contains(@class,'checked')]";
		public static String shareSecuredDesc1 = "//div[contains(@id,'MoreInfo_1012_1')]//ul[@class='fa-ul']/li[1]";
		public static String shareSecuredDesc2 = "//div[contains(@id,'MoreInfo_1012_1')]//ul[@class='fa-ul']/li[2]";
		public static String shareSecuredDesc3 = "//div[contains(@id,'MoreInfo_1012_1')]//ul[@class='fa-ul']/li[3]";
		public static String freedomLoan = "//label[contains(text(),'Freedom')]";
		//Personal Loan Info
		public static String psnlLoanInfTtl="//strong[text()='Personal Loan Info']";
		public static String psnlAmtAsterisk= "//span[@style='color:Red;']//following::input[contains(@name,'LoanAmount')]";
		
		//Select Product Page
		public static String msgHeader = "(//span[@id='pnlExistingMemberMessage']//following::div[@class='col-sm'])[1]/h3";
		public static String msgContent = "(//span[@id='pnlExistingMemberMessage']//following::div[@class='col-sm'])[1]/p";
		public static String CCandLoanTitle = "//*[@id=\"accordion\"]/h4[1]";
		public static String ccTitle = "(//div[@id='accordion']//following::div[@class='panel panel-default'])[1]";
		public static String carLoanTitle = "(//div[@id='accordion']//following::div[@class='panel panel-default'])[2]";
		public static String carLoanTitle2 = "//*[@id='accordion']/div[2]/div[1]/h4/span";
		public static String persoalLoanTitle = "(//div[@id='accordion']//following::div[@class='panel panel-default'])[3]";
		public static String addWaystoSaveTitle = "//*[@id='accordion']/h4[2]";
		public static String cdTitle = "(//div[@id='accordion']//following::div[@class='panel panel-default'])[4]";
		public static String checkingTitle = "(//div[@id='accordion']//following::div[@class='panel panel-default'])[5]";
		public static String savingsTitle = "(//div[@id='accordion']//following::div[@class='panel panel-default'])[6]";
		public static String additionalTitle = "(//div[@id='accordion']//following::div[@class='panel panel-default'])[7]";
		public static String productPageBack = "//input[@id='BackButton_SubmitButton']";
		public static String productPageNext = "//input[@id='NextButton_SubmitButton']";
	
		//Product Info fields
		public static String prodInfoBackButton = "//input[@id='btnBack_SubmitButton']";
		public static String prodInfoNextButton = "//input[@id='btnEdit']";
		public static String prodInfoMsg= "//span[@id='CollateralHandler01']/div";
		public static String prodTypeLabel = "//label[@for='ProductDropDownList_DropDownList']";
		public static String prodTypeDropdown = "//select[@name='ProductDropDownList_DropDownList']";
		public static String prodLimitLabel = "//label[@for='tbLoanAmount_MoneyTextBox']";
		public static String prodLimitTextbox = "//input[@id='tbLoanAmount_MoneyTextBox']";
		public static String prodLimIncorrect= "//input[contains(@style,'border-color: rgb(255, 0, 0)')and contains(@style,'background-color: rgb(255, 255, 224)')]";
		public static String prodLimCorrect= "//input[contains(@style,'border-color: rgb(211, 211, 211)')and contains(@style,'background-color: rgb(255, 255, 255)')]";
		public static String prodLimPopup= "//div[@class='popover fade bottom in']";
		
		public static String loancnfrm_yes="//span[@id='rbOtherProdYes']";
		
	//Error Messages
		public static String errorMsg1 ="//span[@id='ErrorSummary1']//div[@style='color:Red;']//li[1]";
		public static String errorMsg2 ="//span[@id='ErrorSummary1']//div[@style='color:Red;']//li[2]";

	//Member Verification
		public static String mmbrVerifyTile = "//strong[text()='Member Verification']";
		public static String mmbrVerifyNext = "//span[@id='NextButton']";
		public static String mmbrVerifyBack = "//span[@id='BackButton']";
		public static String mmbrVerifyNum="//input[@id='tbEMAMMemberNumber_TextBox']";
		public static String mmbrVerifySSN="//input[@id='tbEMAMSSNTextBox_TextBox']";
		public static String mmbrVerifyDOB="//input[@id='tbBirthDate_RadDatePicker']";
		
		//Your Information
		public static String yourInfoTtl = "//strong[text()='Your Information']";
		public static String applicantHdr= " (//div[@class='SectionHeaders'])[1]";
		public static String identityHdr= " (//div[@class='SectionHeaders'])[2]";
		public static String loanHdr= " (//div[@class='SectionHeaders'])[3]";
		public static String idType="//select[@id='IDType_IDType']";
		public static String idNum="//input[@id='IDType_IDNumber']";
		public static String issueDate="//input[@id='IDType_IssueDate']";
		public static String expDate="//input[@id='IDType_ExpirationDate']";
		public static String houseType= "//select[@id='HousingType_DropDownList']";
		public static String housePymt="//input[@id='HousePayment_MoneyTextBox']";
		public static String addrYears="//input[@id='AddresstDuration_YearTextBox']";
		public static String addrMonths="//input[@id='AddresstDuration_MonthTextBox']";
		public static String empStatus= "//select[@id='EmploymentStatus_DropDownList']";
		public static String currentEmp="//input[@id='CurrentEmployer_TextBox']";
		public static String monIncome="//input[@id='MonthlySalary_MoneyTextBox']";
		public static String empYears="//input[@id='EmploymentDuration_YearTextBox']";
		public static String empMonths="//input[@id='EmploymentDuration_MonthTextBox']";
		public static String prevEmp="//input[@id='PrevEmployer_TextBox']";
		public static String prevIncome="//input[@id='PrevMonthlySalary_MoneyTextBox']";
		public static String prevYears="//input[@id='PreviousEmploymentDuration_YearTextBox']";
		public static String prevMonths="//input[@id='PreviousEmploymentDuration_MonthTextBox']";
		public static String appInfoPopup= "//div[@class='popover-content']";
		
		//Confirm Accounts
		public static String confirmTtl = "//strong[text()='Confirm Account Selections']";
		public static String prodOne = "(//span[@id='ProductsAndServices']//li[1])[1]";
		public static String prodTwo = "//span[@id='ProductsAndServices']//li[2]";
		public static String prodWOptionsTwo = "(//span[@id='ProductsAndServices']//li[2])[2]";
		public static String confirmBtn="//input[@id='btnNext_SubmitButton']";
		public static String changeBtn="//input[@id='btnChange_SubmitButton']";
		
		
	}