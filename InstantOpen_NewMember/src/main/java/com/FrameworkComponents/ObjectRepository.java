package com.FrameworkComponents;

public class ObjectRepository {

	public static String app_ttl="//h1[contains(text(),'Experience the TDECU Difference')]";
	public static String nonmmbrstrt_btn="//input[@id='btnNonMember']";
	public static String mmbrstrt_btn="//input[@id='btnMember']";
	
	public static String nochkacnt_rdbtn="//*[@id='rbNoChecking']/label/strong";
	public static String othrprdctno_rdbtn="//*[@id='rbOtherProdNo']/label";
	public static String continue_btn="//input[@id='NextButton_SubmitButton']";
	public static String continue_further = "//span[@id='NextButton']/input";
	public static String memberShipEligibilityPage = "//*[contains(text(),'Membership Eligibility')]";
	public static String addressNotVerified_alert = "//span[@id='AddressTextBox_lblVerifying']";
	public static String ssnFiled_alert = "//span[@id='SSNTextBox']//following::div[@role='alert']";
	public static String dobField_alert = "//span[@id='tbBirthDate']//following::div[@role='alert']";
	public static String issueDate_alert = "//div[@id='issueDateDiv']//following::div[@role='alert']";
	public static String expirationdate_alert = "//div[@id='expirationDateDiv']//following::div[@role='alert']";
	public static String phoneNumber_alert = "//span[@id='tbPhone1']//following::div[@role='alert']";
	
	//Homepage_CheckingSavingsAndCds Elements_Ashish
	
	public static String progressBar = "//span[@id='progBar']";
	public static String progressBarText(int index)
	{
		String progressBarText = "//span[@id='progBar']//tbody/tr/td["+index+"]/span";
		return progressBarText;
	}
	
	public static String  for_CheckingSavings_Cds = "//div[@class='sectionIcon'][1]/h4";	
	public static String ssn_CheckingSavings_Cds = "//ul[@class='fa-ul'][1]/li[1]";
	public static String govt_issued_identificaiton_CheckingSavings_Cds = "//ul[@class='fa-ul'][1]/li[2]";
	public static String credit_debit_checkingSavings_Cds = "//ul[@class='fa-ul'][1]/li[3]";
	
	public static String questionMark_modal(int index)
	{
		String questionMark_modal = "//div[@class='col-sm-6 col-xm docSection']/div[@class='sectionIcon']/h4[text()='For checking, savings and CDs']/following::ul["+index+"]/li[2]/button";
		return questionMark_modal;
	}
	
	public static String govt_issued_identificaiton_CheckingSavings_QuestionMark="//div[@class='col-sm-6 col-xm docSection']/div[@class='sectionIcon']/h4[text()='For checking, savings and CDs']/following::ul[1]/li[2]/button";
	public static String questionMark_Modal_heading="/html//h4[@id='modalGovIdLabel']";
	public static String questionMark_Modal_text="//div[@class='modal-body']/p";
	public static String questionMark_Modal_xButton="//div[@class='modal-header']/button";
	public static String questionMark_Modal_closeButton= "//div[@class='modal-footer']/button";
	
	public static String govt_issued_identificaiton_loans_and_Credit_Cards_QuestionMark="//div[@class='col-sm-6 col-xm docSection']/div[@class='sectionIcon']/h4[text()='For checking, savings and CDs']/following::ul[2]/li[2]/button";
	
	
	public static String thumbnail_Set(int index)
	{
		String thumbnail = "//div[@class='col-sm-4 col-xm']["+index+"]/div/div/h3";
		return thumbnail;
	}
	
	
	public static String header_ExisitngMemberandNonMember_Subpages="//div[@class='container']/span[2]/div/div/h3";
	public static String header_MembershipEligibility="//h3/strong";
	public static String header_PendingApplication_Subpage="//div[@class='container']//div/div/h1";
	public static String newToTDECU_StartHere="//input[@name='btnNonMember$btnNonMember']";
	public static String alreadyMember_StartHere="//input[@name='btnMember$btnMember']";
	public static String pendingApplication_StartHere="//input[@id='btnTDECUContinueApp']";
	
	
	
	
	
	
	public static String sub_Header = "//h3[contains(text(),'Apply for your account in minutes')]";
	public static String  for_LoansandCreditCards = "/html//form[@id='fiVISIONWebForm']/span/table//div[@class='MainBorder']/div[@class='ShadowWrap']/div[@class='ContentTable']/div/span/div[@class='container']/div/div[@class='row']/div/div[@class='sectionIcon']/h4[.='For loans and credit cards']";	
	public static String frequentlyAskedQuestions_Section = "//div[@class='row'][3]/div/h3[text()='Frequently Asked Questions']";
	public static String importantAccountOpenningInformation = "//div[@class='col-sm disclaimer']/h4/strong[text()='IMPORTANT ACCOUNT OPENING INFORMATION:']";
	
	
	public static String disclaimer_section="//footer[@class='footerForm']/preceding::div[1]";
	public static String disclaimer_section_header="//footer[@class='footerForm']/preceding::div[1]/h4";
	public static String disclaimer_section_content="//footer[@class='footerForm']/preceding::div[1]/p[1]";
	public static String disclaimer_section_content2="//footer[@class='footerForm']/preceding::div[1]/p[2]";
	
	
	// Products page locators by Ashish
	public static String radioButton_dont_want_to_Open_CheckingAccount="//label[@for='rbNoChecking_RadioButton']";
	public static String radioButton_No_Loans_Creditscards="//label[@for='rbOtherProdNo_RadioButton']";
	public static String button_Continue=	"//input[@name='NextButton$NextButton_SubmitButton']";
	public static String button_Back="//input[@id='BackButton_SubmitButton']";
	public static String errors="//div[@class='errors']";
	
	public static String header_PrimaryApplicantInfo="//h3/strong";
	public static String header_Section(int index)
	{
		String section="//div[@class='form-inline']/div[@class='SectionHeaders']["+index+"]";
		return section;
	}
	
	
	public static String validationPopup="//span[@id='tbFirstName']/div[@role='tooltip']/div[@role='alert']";
	
	
	
	
	//End of locators defined by Ashish
	
	
	public static String membership_page_option(int option){
		String pageOption = "//*[contains(text(),'Membership Eligibility')]/following::div[@class='iradio_square-grey']["+option+"]";
		return pageOption;
	}
	public static String confirm_account_selections_page = "//*[contains(text(),'Confirm Account Selections')]";
	public static String change_button = "//span[@id='btnChange']/input";
	
	public static String fname_txt="//input[@id='tbFirstName_TextBox']";
	public static String mname_txt="//input[@id='tbMiddleName_TextBox']";
	public static String lname_txt="//input[@id='tbLastName_TextBox']";
	public static String namesfx_txt="//input[@id='tbNameSuffix_TextBox']";
	public static String strtaddrs_txt="//input[@id='AddressTextBox_AddressLine1']";
	public static String zip_txt="//input[@id='AddressTextBox_AddressCityStateZip']";
	
	public static String ssn_txt="//input[@id='SSNTextBox_TextBox']";
	public static String dob_cal="//input[@id='tbBirthDate_RadDatePicker']";
	public static String idtyp_drop="//select[@id='IDType_IDType']";
	public static String state_drop="//select[@id='IDType_StateComboBox']";
	public static String country_drop="//select[@id='IDType_CountryComboBox']";
	
	public static String idnmbr_txt="//input[@id='IDType_IDNumber']";
	public static String issuedt_cal="//input[@id='IDType_IssueDate']";
	public static String expdt_cal="//input[@id='IDType_ExpirationDate']";
	public static String hrabttdecu_drop="//select[@id='HowDidYouHear_DropDownList']";
	public static String mothername_txt="//input[@id='MothersMaidenName_TextBox']";
	public static String crrntemplyr_txt="//input[@id='CurrentEmployer2_TextBox']";
	public static String occptn_txt="//input[@id='Occupation_TextBox']";
	
	public static String phonenmbr_txt="//input[@id='tbPhone1_RadMaskedTextBox']";
	public static String phonetyp_drop="//select[@id='tbPhone1_ddPhoneNumberType']";
	public static String addMore_checkBox = "(//div[contains(@class,'icheckbox_square-grey')])[1]";
	public static String addPhone = "//div[@id='AddPhones']";
	public static String primaryemail_txt="//input[@id='tbEmail1_RadTextBox']";
	public static String email_astrick = "//input[@id='tbEmail1_RadTextBox']/following::span[1]";
	
	//
	public static String mstrcrdtcard_exp="//h4[@class='panel-title CursorPointer' and contains(text(),'Credit Cards')]";
	public static String classicmstrcrd_opt="//label[contains(text(),'Classic MasterCard')]";
	public static String chkingmoneymrkt_exp="//h4[@class='panel-title CursorPointer' and contains(text(),'Money Market Accounts')]";
	public static String moneymarket_opt="//label[contains(text(),'Money Market')]";
	public static String clscchking_opt="//*[contains(text(),'Classic Checking')]/..";
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
	public static String cnfrmacnt_ttl="//*[text()='Confirm Selected Products and Services']";
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
	
	public static String checking_amount_2 = "//label[contains(text(),'Share')]/following::input[1]";
	public static String shareamnt_txt="//input[contains(@id,'ProductFunding_FormProductID')]";
	public static String clubamntprnt_txt="//label[contains(@for,'ProductFunding_FormProductID') and contains(text(),'Club')]/parent::*/parent::*";
	public static String fnd_opt="//label[text()='Transfer Funds']";
	public static String elctrnc_opt="//label[text()='Electronic Check']";
	public static String sbmt_btn="//input[@id='NextButton2_SubmitButton']";
	
	public static String rtngnmbr_txt="//input[@id='ACHFundingAccountVerification_tbRoutingNumber_NumericTextBox']";
	public static String acntnmbr_txt="//input[@id='ACHFundingAccountVerification_tbAccountNumber_TextBox']";
	public static String elctrnc_svng_btn = "//label[contains(text(),'Savings')]/preceding::div[1]";
	public static String vrfyacnt_btn="//button[@id='DeferredInputSubmit']";
	
	public static String thnku_ttl="//h1[text()='Thank You for Your Application!']";
	
	public static String sbmtupload_btn="//input[@id='DocumentList02_rbdocuments']";
	
	public static String addAnotherJointOwner = "//input[@value=' Add Another Joint Owner']";
	public static String addAnotherBeneficiary = "//input[@value=' Add Another Beneficiary']";
	
	//Applicant Information
	public static String aplcntinfo_ttl="//div[@class='SectionHeaders' and contains(text(),'Applicant Information')]";
	public static String idntfctninfo_ttl="//div[@class='SectionHeaders' and contains(text(),'Identification Information')]";
	public static String loaninfo_ttl="//div[@class='SectionHeaders' and contains(text(),'Loan Information')]";
	
	//Savings Account
	
	public static String savingsAccountLocator = "//h4[contains(text(),'Savings Account')]/i";
	public static String clubCheckBox = "//input[contains(@id,'RequiredSavings_ProductCheckbox')]/..";
	
	//Certificates of Deposits
	public static String certificateOfDeposit = "//h4[contains(text(),'Certificates of Deposit')]/i";
	public static String enterAmountTxtField = "//label[contains(text(),'Enter an Amount')]/following::input[1]";
	public static String selectTermDropdown = "//label[contains(text(),'Select a term')]/following::select";
	public static String termCheckBox = "//div[contains(@style,'display: block')]//div[contains(@class,'icheckbox')]//following::label[1]";
	
	
	//
	public static String Highyieldchking_opt="//strong[contains(text(),'High Yield Checking')]/.."; 
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
 
	public static String creditCardInfoPage = "//*[text()='Credit Card Info']";
	public static String backButton = "//input[@id='BackButton_SubmitButton']";
	public static String productPageBackBtn = "//input[contains(@id,'Back_SubmitButton')]";
	public static String vehicleLoanPage = "//strong[contains(text(),'Vehicle Loan Info')]";
	public static String personalLoanPage = "//strong[contains(text(),'Personal Loan Info')]";
	public static String errorSummary = "//span[contains(@id,'ErrorSummary')]//li";
	public static String backButtonFurther = "//span[@id='btnBack']//input";
	public static String specificErrorSummary = "//span[contains(@id,'ErrorSummary')]//li[1]";
	public static String errorSummary2="//span[contains(@id,'ErrorSummary')]//li[2]";
	
	public static String estric_ssn="//span[@id='SSNTextBox_TextBox_cvTextBox']";
	public static String estric_dob="//span[@id='tbBirthDate_CustomValidator']";
	public static String estric_idType="//span[@id='ctl38']";
	public static String estric_state="//span[@id='ctl40']";
	public static String estric_country="//span[@id='ctl42']";
	public static String estric_idNumber="//span[@id='ctl44']";
	public static String estric_issuedate="//span[@id='ctl46']";
	public static String estric_expirydate="//span[@id='ctl48']";
	public static String estric_hearAbout_opt="//span[@id='HowDidYouHear_CustomValidator']";
	public static String estric_mothersmaiden="//span[@id='MothersMaidenName_TextBox_cvTextBox']";
	public static String estric_currentEmployer="//span[@id='CurrentEmployer2_TextBox_cvTextBox']";
	public static String estric_occupation="//span[@id='Occupation_TextBox_cvTextBox']";
	
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
	
	public static String CD_amount_field = "//label[contains(text(),'Enter an Amount')]/following::input";
	public static String CD_term_field = "//label[contains(text(),'Select a term (in months)')]/following::select";
	
	public static String modalHelpIcon = "//label[contains(text(),'E-Documents')]/following::div[@class='Service_MoreInfo']//button";
	public static String eDocumentHeader = "//*[@id='modalEdocumentsLabel']";
	public static String eDocumentModalBody = "//*[@id='modalEdocumentsLabel']/following::p";
	public static String eDocumentModalCloseButton = "//*[@id='modalEdocumentsLabel']/following::button[1]";
	
	public static String loanAmountTxt = "//input[contains(@id,'LoanAmount')]";
	public static String loanTerm = "//select[contains(@id,'Term')]";
	public static String eDocumentLink = "//a[text()='eDocument Consent']";
	
	public static String getTermCertificateLocator(String term){
	//	String termLocator = "//div[contains(@style,'display: block')]/label[contains(text(),'"+term+" Month Share Certificate')]";
		String termLocator = "//div[contains(@style,'display: block')]//label[contains(text(),'"+term+"')]";
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
	public static String vehicleLoanAmt = "(//input[contains(@id,'MoneyTextBox')])[1]";
	public static String vehiclePurchesPrice = "(//input[contains(@id,'MoneyTextBox')])[2]";
	
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
		public static String prodInfoBackButton = "//input[contains(@name,'Back_SubmitButton')]";
		public static String appInfoBackButton = "//span[@id='BackButton']/input";
		public static String prodInfoNextButton = "//input[@id='btnEdit']";
		public static String appInfoNextButton = "//input[contains(@class,'NextButton')]";
		
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
		public static String errordiv="//div[@class='errors']";
		public static String errorMsg2 ="//span[@id='ErrorSummary1']//div[@style='color:Red;']//li[2]";
		public static String allErrors = "//span[@id='ErrorSummary1']//li";

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
		public static String mobileRemoteDepositCaptureLink = "//a[text()='Mobile Remote Deposit Capture Terms and Conditions']";
		public static String courtesyPay = "//span[@id='pnlCourtesyPay']//h3";
		public static String freqAskQuestions = "//span[@id='pnlCourtesyPay']//h3";
		
		public static String pageSection(String sectionName){
			String sectionLocator = "//div[contains(text(),'"+sectionName+"')]";
			return sectionLocator;
		}
		public static String informativeMessage_ContactInfo = "//div[@class='SectionHeaders']/following::strong";
		public static String addJointOwners_CheckBox = "//span[@id='cbAddJointOwners']";
		public static String addBeneficiaries_CheckBox = "//span[@id='cbAddBene']";
		public static String footerString = "//span[@id='cbAddJointOwners']/following::p"; 
		public static String applicantInformation_allfields = "//div[@class='SectionHeaders']/following::span[not(contains(@style,'hidden'))]";
		public static String add_existing_member_link="//span[@id='pnlExistingMember']//a";
		
		public static String checkBoxProp(String locator){
			String property = null;
			property = GenericKeywords.getElement(locator).getAttribute("class");
			return property;
		}
		
		public static String checkingAccount_prop = "//span[@id='rbLevelUpChecking']/div";
		public static String otheOption_prop = "//span[@id='rbOtherProdYes']/div";
		
		//Additional Account Owners Page
		public static String additionaliAccountOwnerPageTitle = "//strong[text()='Additional Account Owners']";
		public static String additional_beneficiaryPageTitle = "//strong[text()='Your Beneficiary Information']";
		public static String addedUserName = "//span[contains(@id,'IndividualHyperlinkList')]//a[1]";
		public static String addedUser_removeLink = "//span[contains(@id,'IndividualHyperlinkList')]//a[2]";
		//Confirm Account Role
		public static String confirmAccountRole_title="//strong[text()='Confirm Account Roles']";
		
		//Product Selection
		public static String classicCheck = "//span[@id='rbClassicChecking']";
		public static String optInCrtsyPay = "//span[@id='cbCourtPayOptIn']";
		
		//Account Roles
		public static String rolesProduct(int option){
			String locator = "(//span[@id='ProductRelationships']//td[contains(@id,'Name')])["+option+"]";
			return locator;
		}
		public static String primaryRole(int option){
			String locator = "(//span[@id='ProductRelationships']//div[contains(@class,'checked disabled')])["+option+"]";
			return locator;
		}
		public static String jointRoleChecked(int option){
			String locator = "(//span[@id='ProductRelationships']//div[@class='icheckbox_square-grey checked'])["+option+"]";
			return locator;
		}
		public static String jointRoleNotChecked(int option){
			String locator = "(//span[@id='ProductRelationships']//div[@class='icheckbox_square-grey'])["+option+"]";
			return locator;
		}
		public static String jointRoleDisabled(int option){
			String locator = "(//span[@id='ProductRelationships']//div[@class='icheckbox_square-grey disabled'])["+option+"]";
			return locator;
		}
		
		//Agreements and Disclosures
		public static String agreementTtl = "//h2[text()='Account Agreements and Disclosures']";
		public static String discCheckBox = "//span[@id='cbDisclosures']";
		public static String disclosuresText = "//div[@class='discCopy']//p";
		public static String backupWithQstn = "//i[@class='fas fa-question-circle']";
		public static String backupWithTtl = "//h4[text()='Am I subject to backup withholding?']";
		public static String closeBackupWith = "//button[text()='Close']";
		public static String disclosures_page_option(int option){
			String locator = "(//div[@class='col-sm checkCopy']//p)["+option+"]";
			return locator;
		}
		public static String TINchkbx = "//span[@id='CheckBox01']";
		public static String withHldngChkbx = "//span[@id='CheckBox02']";
		public static String exemptChkbx = "//span[@id='CheckBox03']";
		public static String citizenChkbx = "//span[@id='CheckBox04']";
		public static String alienChkbx = "//span[@id='CheckBox05']";
		public static String agreeChkbx = "//span[@id='Authroization']";
		public static String acceptText= "(//div[@class='row disclaimer']//p)[2]";
		public static String courtesyPayTtl= "//h3[text()='Courtesy Pay']";
		public static String crtsyPayDescOne= "//span[@id='pnlCourtesyPay']/p[1]";
		public static String crtsyPayDescTwo= "//span[@id='pnlCourtesyPay']/p[2]";
		public static String crtsyPayInfoOne= "//span[@id='pnlCourtesyPay']/ol/li[1]";
		public static String crtsyPayInfoTwo= "//span[@id='pnlCourtesyPay']/ol/li[2]";
		public static String crtsyPayInfoThree= "//span[@id='pnlCourtesyPay']/ol/li[3]";
		public static String FAQtitle= "//h4[text()='Frequently Asked Questions']";
		public static String belowFAQ= "//p[text()='Below are frequently asked questions about Courtesy Pay. ']";
		public static String FAQone= "(//div[@id='accordion']//div[contains(@class,'panel-heading')])[1]";
		public static String FAQoneClose= "(//div[@id='accordion']//div[contains(@class,'collapsed')])[1]";
		public static String FAQtwo= "(//div[@id='accordion']//div[contains(@class,'panel-heading')])[2]";
		public static String FAQtwoClose= "(//div[@id='accordion']//div[contains(@class,'collapsed')])[2]";
		public static String FAQtwoInfo= "//div[@id='accordion']//div[@id='collapseQ2']//li";
		public static String crtsyPayNote= "(//div[@class='col-sm']//p)[4]";
		public static String declineBtn= "//span[@id='btnDecline']//input";
		public static String declineTxt= "//strong[text()='We Cannot Process Your Application']";
		
		public static String membershipElegibilityRadioButton = "//strong[contains(text(),'Membership Eligibility')]/following::input[@type='radio']";
		public static String clscchking_rdbtn="//label[@for='rbClassicChecking_RadioButton']";
		public static String loancnfrm_no="//span[@id='rbOtherProdNo']";
		public static String mmbrtdecu_opt="//td[contains(text(),'I am related to a current')]";
		public static String mmbremploy_opt="//td[contains(text(),'I am an employee')]";
		public static String mmbrship_opt="//td[contains(text(),'I am a member of a membership')]";
		public static String livework_opt="//td[contains(text(),'I live')]/preceding::div[1]";
		public static String mmbr_error="//div[@class='errors']";
		public static String communitieslist_lnk="//a[contains(text(),'View list of communities we serve')]";
		public static String cnfrmacntslctn_ttl="//strong[text()='Confirm Account Selections']";
		public static String svcontinue_btn="//span[@id='btnNext']/input";
		public static String acntagrmnt_ttl="//h2[text()='Account Agreements and Disclosures']";
		public static String dsclsr_chkbx="//input[@id='cbDisclosures_CheckBox']";
		public static String backupwithold_hlp="//button[contains(@data-target,'modalBackupWH')]";
		public static String backupwithold_info="//p[contains(text(),'You will not be subject to backup withholding on interest payments')]";
		public static String ok_btn="//button[contains(text(),'Okay')]";
		public static String tin_chkbx="//input[@id='CheckBox01_CheckBox']";
		public static String backupwithold_opt="//strong[contains(text(),'Backup Withholding:')]";
		public static String exmpt_opt="//strong[contains(text(),'Exempt Recipients:')]";
		public static String backupwithold_chkbx="//input[@id='CheckBox02_CheckBox']";
		public static String uscitizen_opt="//h4[contains(text(),'U.S. Citizens')]";
		public static String aliens_opt="//h4[contains(text(),'Non-Resident Aliens Only')]";
		public static String uscitizen_chkbx="//input[@id='CheckBox04_CheckBox']";
		public static String aggrmnt_opt="//p[contains(text(),'I authorize TDECU to investigate my credit and employment history')]";
		public static String aggrmnt_chkbx="//input[@id='Authroization_CheckBox']";
		public static String idntvrf_ttl="//h3[text()='Identity Verification']";
		public static String idntvrf_ans1="//label[contains(text(),'Fairfax')]";
		public static String idntvrf_ans2="//label[contains(text(),'Verid')]";
		public static String idntvrf_ans3="//label[contains(text(),'Reston')]";
		public static String idntvrf_ans4="//label[contains(text(),'Union Street')]";
		public static String acntfnd_ttl="//strong[text()='Account Funding']";
		public static String elctrnchk_opt="//label[text()='Electronic Check']";
		public static String dbtcreditcrd_opt="//label[text()='Debit/Credit Card']";
		public static String crdnmbr_txt = "//input[@name='CreditCard_CardNumber']";
		public static String crdmonth_drop = "//select[@name='CreditCard_Month']";
		public static String crdyr_drop = "//select[@name='CreditCard_Year']";
		public static String crdcvv_txt = "//input[@name='CreditCard_CVV']";
		public static String crdfrstname_txt = "//input[@name='fiVISION_CreditCardV2_FirstNameOnCard']";
		public static String crdlstname_txt = "//input[@name='fiVISION_CreditCardV2_LastNameOnCard']";
		
		public static String sbmtapp_info1="//p[contains(text(),'By clicking the Submit Application button below')]";
		public static String sbmtapp_info2="//p[contains(text(),'Certify that all the other information on this')]";
		public static String crtfctdpst_opt="//h4[contains(text(),'Certificates of Deposit')]";
		public static String crtfctdpst_amnttxt="//input[@id='tbFilterLoanAmount_CDWizard']";
		public static String crtfctdpst_trmopt3="//label[contains(text(),'3 Month Share Certificate')]";
		public static String crtfctdpst_term="//select[@id='ddlFilterTerm_CDWizard']";
		public static String mrktmnydpst_opt="//h4[contains(text(),'Money Market Accounts')]";
		public static String mrktmnydpst_chk="//label[text()=' Money Market']";
		public static String moneyMarket_chk="//label[contains(text(),'Money Market')]";
		
		public static String needloan_yes="//label[@for='rbOtherProdYes_RadioButton']";
		public static String needloan_no="//label[@for='rbOtherProdNo_RadioButton']";
		public static String sbmtapp_btn="//input[@id='NextButton2_SubmitButton']";
		public static String clscchkng_txt="//label[contains(text(),'Classic Checking')]/parent::*/following-sibling::div[contains(@class,'accountAmounts')]/input";
		public static String share_txt="//label[text()='Share']/parent::*/following-sibling::div[contains(@class,'accountAmounts')]/input";
		public static String crtfctdpst_trm="//select[@id='ddlFilterTerm_CDWizard']";
		public static String shrcrtfct_txt="//label[contains(text(),'3 Month Share')]/parent::*/following-sibling::div[contains(@class,'accountAmounts')]/input";
		public static String mmbrtdecu_chk="//span[@id='rbFamily']/div";
		public static String mmbremploy_chk="//span[@id='rbCompany']/div";
		public static String cmpnylist_lnk="//a[text()='View list of companies we serve']";
		public static String cmpnypage_ttl="//h1[text()='Field of Membership by Company and Organization']";
		public static String emplyr_txt="//input[@id='Employer_TextBox']";
		public static String orglist_lnk="//a[text()='View list of membership organizations we support']";
		
		public static String links_on_memberShipPage = "//td//a";
		
		public static String communitiespage_ttl="//h1[text()='Membership']";
		
		public static String svprgrs_emltxt="//input[@id='EmailTextBox_RadTextBox']";
		public static String svprgrs_pswrd="//input[@id='tbASCPassword_TextBox']";
		public static String sttscntr_lnk="//a[text()='Status Center']";
		public static String sttscntr_ttl="//span[contains(text(),'Status Center')]";
		public static String svfinish_btn="//span[@id='SaveButton']/input";
		public static String svprgrs_ttl="//strong[text()='Save Your Progress']";
		public static String svprgrs_info="//p[contains(text(),'You can save your application to finish later')]";
		public static String cancel_btn="//span[@id='btnCancel']/input";
		
		
		public static String showAll_checkBox  = "//label[text()=' Show All']/preceding::div[1]";
		public static String all_month_options = "//div[contains(@id,'CDWizard_ProductPanel')]";
		public static String feeSchedule_link = "//div[@class='CDfeeSchedule']//a";
		public static String rate_link = "//ul[@class='fa-ul']//a[text()='rates']";
		//instantOpen New Scenarios
		
		public static String progressBarOptions = "//span[@id='progBar']//span";
		
		//PromoCode field
		public static String add_promocode_field = "//input[@name='tbPromoCode_TextBox']";
		public static String promo_code_disclaimer = "//div[@class='col-sm disclaimer']//p";
		public static String promo_code_page_header = "//div[@class='col-sm']//h3";
		public static String promo_code_sub_header = "//div[@class='col-sm']//p";
		
		//Pending Application Section
		
		public static String check_status_button = "//div[@class='text-center']//input[@value='Check Status']";
		public static String page_header = "//h1[@class='text-center']";
		public static String email_address_textBox = "//input[@name='tbEmail1_RadTextBox']";
		public static String password_textBox = "//input[@name='tbASCPassword_TextBox']";
		public static String ssn_textBox = "//input[@name='tbSSNLastFour_TextBox']";
		public static String forget_password_button = "//a[@role='button' and text()='Forgot Password?']";
		public static String reset_password_page_header = "//h2[text()='Reset Account Password']";
		public static String forget_email_address_textBox = "//input[@name='EmailTextBox_RadTextBox']";
		public static String submit_button_reset_password = "//span[@id='btnReset']/input";
		public static String note_message_header = "//div[@class='noteMessage']//h4";
		public static String note_paragraph = "//div[@class='noteMessage']//p";
		public static String return_to_login_button = "//a[@role='button' and text()='Return to Login']";
		
		//New FAQ section
		
		public static String faq_based_on_number(String position){
			return "(//div[@id='accordion']//h4)["+position+"]";
		}
		
		public static String faq_text(String pos){
			return "(//div[@id='accordion']//p)["+pos+"]";
		}
		
		//Thank You page components
		
		public static String text_on_thank_you_page(String pos){
			return "(//div[@class='container']//p)["+pos+"]";
		}
		
		//Data Table
		public static String dataTable(String index){
			return "(//div[@class='container']//table)["+index+"]//td";
		}
		
		//HomePage components
		
		public static String page_header_locator = "//h1[@class='text-center']";
		public static String thumbnail_text = "//div[@class='thumbnail']//h3";
		
		public static String pageDisclaimer = "//div[contains(@class,'disclaimer')]//h4";
		
		public static String sub_disclaimer_text(String index){
			return "(//div[contains(@class,'disclaimer')]//p)["+index+"]";
		}
		
		// --- Aditi ----
		public static String loanCreditCard_sectn_locator = "//h4[text()='For loans and credit cards']";
		public static String lcc_criteria(int criteria_no){
			return "//div[@class='col-sm-6 col-xm docSection']/div[@class='sectionIcon']/h4[text()='For loans and credit cards']/following::ul[1]/li["+criteria_no+"]";
		}
		public static String faqSectionTitle = "//h3[text()='Frequently Asked Questions']";
		public static String faq_collapse(int index){
			return "//div[@class='panel panel-default']["+index+"]/div/h4/i";
		}
		public static String faq_questns(String questn){
			return "//text()[contains(.,'"+questn+"')]/ancestor::h4[1]";
		}
		public static String faq_answers (int index){
			return "//*[@id='collapseQ"+index+"']/div/p";
		}
		public static String bulletForAns1(int index){
			return "//*[@id='collapseQ1']/div/ul/li["+index+"]";
		}
		public static String q1_countryList = "//*[@id='collapseQ1']/div/div/table/tbody/tr/td";
		public static String q1_hyperlink1 = "//*[@id='collapseQ1']/div/ul/li[2]/a";
		public static String q1_hyperlink2 = "//*[@id='collapseQ1']/div/ul/li[3]/a";
		public static String q4_hyperlink1 = "//*[@id='collapseQ4']/div/p/a";		
		
		public static String progressBar = "//span[@id='progBar']";
		public static String progressBarText(int index)
	       {
	              String progressBarText = "//span[@id='progBar']//tbody/tr/td["+index+"]/span";
	              return progressBarText;
	       }
       public static String thumbnail_Set(int index)
       {
              String thumbnail = "//div[@class='col-sm-4 col-xm']["+index+"]/div/div/h3";
              return thumbnail;
       }
       public static String sub_Header = "//h3[contains(text(),'Apply for your account in minutes')]";
       public static String  for_CheckingSavings_Cds = "//div[@class='sectionIcon'][1]/h4"; 
       public static String  for_LoansandCreditCards = "/html//form[@id='fiVISIONWebForm']/span/table//div[@class='MainBorder']/div[@class='ShadowWrap']/div[@class='ContentTable']/div/span/div[@class='container']/div/div[@class='row']/div/div[@class='sectionIcon']/h4[.='For loans and credit cards']";
       public static String frequentlyAskedQuestions_Section = "//div[@class='row'][3]/div/h3[text()='Frequently Asked Questions']";
       public static String importantAccountOpenningInformation = "//div[@class='col-sm disclaimer']/h4/strong[text()='IMPORTANT ACCOUNT OPENING INFORMATION:']";
       public static String header_ExisitngMemberandNonMember_Subpages="//div[@class='container']/span[2]/div/div/h3";
       
       //Form fill locators
       public static String header_Section(int index)
   	{
   		String section="//div[@class='form-inline']/div[@class='SectionHeaders']["+index+"]";
   		return section;
   	}
       public static String button_Continue=	"//input[@name='NextButton$NextButton_SubmitButton']";
       public static String header_MembershipEligibility="//h3/strong";
       public static String button_Back="//input[@id='BackButton_SubmitButton']";
       public static String courtesy_pay = "//span[@id='cbCourtPayOptIn']/div[1]";
       public static String membership_eligiblty_continue_btn = "//*[@id='NextButton_SubmitButton']";
       public static String confirm_prodt_servc_btn ="//*[@id='btnNext_SubmitButton']";
       public static String back_frm_agreemnt_page = "//*[@id='btnBack_SubmitButton']";
}
