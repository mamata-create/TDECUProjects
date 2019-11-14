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
	
	public static String address_Verification="//label[text()='None of the above']";

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
	
}
