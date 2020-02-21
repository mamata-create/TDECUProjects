package com.FrameworkComponents;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ObjectRepository {

	//login page
	public static String loginid_txt="//input[@id='fldUsername']";
	public static String password_txt="//input[@id='fldPassword']";
	public static String login_btn="//button[@test-id='btnSubmit']";
	public static String logoff_lnk="//div[text()='Log Off']";
	
	public static String otpemail_btn="//div[@test-id='btnTacTarget']";
	public static String otp_txt="//input[@test-id='fldSAC']";
	public static String submit_btn="//button[@test-id='btnSubmit']";
	public static String register_btn="//div[@test-id='btnRegister']";
	public static String donotregister_btn="//div[@test-id='btnDoNotRegister']";
	public static String newlogin_btn="//form[@class='header-login-form']//input[@value='Login']";
	public static String loc_lnk="//span[@test-id='lnkBranches' and contains(text(),'Locations')]";
	public static String prvcyntc_lnk="//a[@test-id='lnkPrivacy' and contains(text(),'Privacy Notice')]";
	public static String locpg_ttl="//h1[@test-id='txtBranchesTitle' and contains(text(),'Locations and ATMs')]";
	public static String prvcyntc_ttl="//h1[contains(text(),'Privacy Notice')]";
	
	public static String loginerr_msg="//div[@class='alert-message_inner']/p[contains(text(),'Authentication has failed. Please re-enter your login')]";
	public static String logout_msg="//h1[contains(text(),'Successfully Logged Out')]";
	
	//transactions page
	public static String trnsctn_menu="//a[contains(@class,'transactions')]//div[text()='Transactions']";
	public static String fndtrnsfr_menu="//a[contains(@class,'transfers-tab')]//div[text()='Funds Transfer']";
	//Fund Transfer page
	public static String fndtrnsfr_ttl="//h1[text()='Funds Transfer']";
	public static String frmacnt_dropdown="//select[@id='inputFrom']";
	public static String toacnt_dropdown="//select[@id='inputTo']";
	public static String amnt_txt="//input[@test-id='fldAmount']";
	public static String rccrng_chkbx="//span[@test-id='cbxRecurring']";
	
	public static String frqncy_dropdown="//select[@test-id='selFrequency']";
	public static String stdt_cal="//div[contains(@class,'start-date')]//input[@test-id='fldCalendar']";
	public static String enddt_cal="//div[contains(@class,'end-date')]//input[@test-id='fldCalendar']";
	public static String noenddt="//div[contains(text(),'No End Date')]";
	public static String rptfrever_chk="//p[@class='pointer']";
	
	public static String clndr_icon="//a[@test-id='btnCalendarToggle']";
	public static String memo_txt="//input[@test-id='fldMemo']";
	public static String trnsfrfnds_btn="//button[@test-id='btnTransferFunds']";
	public static String clr_btn="//button[@test-id='btnClear']";
	public static String trnsfrsccs_msg="//*[text()='Transaction Processed']";
	public static String schdltrnsfrsccs_msg="//*[text()='Transaction Authorized']";
	public static String vwactvtycntr_btn="//div[text()='Activity Center']";
	public static String cls_btn="//button[text()='Close']";
	public static String approve_button = "//button[@test-id='btnApproveFunds']";	
	public static String fndtrnsfrerr="//div[@test-id='ui-modal-dialog']";
	public static String fndtrnsfrerr_msg="//div[@class='ui-modal-header']";
	
	//Make a Payment
	public static String mkpymnt_menu="//div[@class='menu-text' and text()='Make A Payment']";
	public static String mkpymnt_ttl="//h2[@class='mrg-H-lg' and text()='Loan Payments']";
	public static String mkpymnt_frmacnt="//select[@id='fromAccount']";
	public static String mkpymnt_toacnt="//select[@id='toAccount']";
	public static String mkpymnt_amnt="//input[@id='amountEdit']";
	public static String mkpymnt_cntinue="//div[contains(@class,'transfer-submit')]";
	public static String mkpymnt_cnfrmbtn="//div[@id='agreeButton']";
	public static String mkpymnt_memo="//input[@id='description']";
	public static String mkpymnt_rccrngchk="//input[@test-id='cbxRecurring']";
	public static String mkpymnt_frqncy="//select[@id='frequencySelect']";
	public static String mkpymnt_pymnttyp="//select[@id='payment_type']";
	public static String mkpymnt_vwactvty="//button[text()='View In Activity Center']";
	public static String mkpymnt_invldloanmsg="//div[text()='Invalid Loan Payment']";
	
	
	
//Activity Center
	public static String actvtycntr_menu="//div[@class='menu-text' and text()='Activity Center']";
	public static String actvtycntr_ttl="//h1[text()='Activity Center']";
	public static String actvtycntr_amnt="(//table[@id='tblTransactions']//td[@test-id='txtAmount']/span)[1]";
	public static String actvtycntr_memo="//span[@test-id='txtDescription']";
	public static String sngltrnsctn_tab="//span[text()='Single Transactions']";
	public static String rcrngtrnsctn_tab="//span[text()='Recurring Transactions']";
	public static String srchtrnsctn_txt="//div[@class='searchbox']//input[@placeholder='Search transactions']";
	public static String fltr_lnk="//button[@test-id='lnkShowClassic']";
	public static String trnsctntyp_parent="//label[text()='Transaction Type']/following::select[1]";
	public static String trnsctntyp_drop="//select[@test-id='selTranType']";
	public static String stts_parent="//label[text()='Status']/following::select[1]";
	public static String acnt_parent="//label[text()='Account']/following::select[1]";
	public static String crtd_parent="//div[@class='col-xs-12']/div[1]/div[4]//select[@class='ember-view ember-select form-control']";
	public static String amnt_parent="//div[@class='col-xs-12']/div[1]/div[5]//select[@class='ember-view ember-select form-control']";
	public static String trnsctnID_txt="//label[text()='Transaction ID']/following::input[1]";
	public static String srchamnt_txt="//input[contains(@class,'currency') and @test-id='fldAmtRangeFrom']";
	public static String crtd_col_srt="//table[@test-id='txtAccountsTable']//th[@test-id='lblDate']//span[contains(@class,'sort-icon')]";
	public static String stts_col_srt="//table[@test-id='txtAccountsTable']//th[@test-id='lblStatus']//span[contains(@class,'sort-icon')]";
	public static String trnsctntyp_col_srt="//table[@test-id='txtAccountsTable']//th[@test-id='lblTransactionType']//span[contains(@class,'sort-icon')]";
	public static String acnt_col_srt="//table[@test-id='txtAccountsTable']//th[@test-id='lblAccount']//span[contains(@class,'sort-icon')]";
	public static String amnt_col_srt="//table[@test-id='txtAccountsTable']//th[@test-id='lblAmount']//span[contains(@class,'sort-icon')]";
	public static String actns_lnk="(//button[@aria-label='Actions']//span)[1]";
	public static String recactns_lnk="//div[@class='content-wrapper grid-column']//tbody[@class='scrollable']/tr[5]//div[@test-id='drpTransactionActions']";
	public static String fav_drop="//button[@test-id='btnACFavorites']";
	public static String addfav="//a[@test-id='btnAddFavorite']";
	public static String favnickname_txt="//input[@test-id='fldFavoriteNickname']";
	public static String favsave_btn="//button[@test-id='btnSaveFavorite']";
	public static String favcncl_btn="//button[@test-id='btnCloseNewFavoriteModal']";
	public static String resetfltr_btn="//button[@test-id='btnResetFilters']";
	public static String aplyfltr_btn="//button[@test-id='lnkSearch']";
	public static String actn_lnk="//tr[@test-id='txtTransactionSummary']/td[6]/div[@test-id='drpTransactionActions']";
	public static String actn_cncl="//button[@aria-label='Actions']/following::ul[1]//li[2]";
	public static String actn_inqr="//button[@aria-label='Actions']/following::ul[1]//li[3]";
	public static String applyFilterBtn = "//button[@test-id='lnkSearch']";
	public static String trnsfrmnynow_lnk="//div/a[@test-id='btnQuickTransfer']";
	
	public static String fundtransfer_ttl="//h1[text()='Funds Transfer']";
	public static String wlcmmsg="//div[@class='customer-name']";
	public static String timeStamp = "//div[@test-id='lblLastLogin']";
	
	public static String accntgrp_expnd="//div[contains(@class,'account-group')]//a[@aria-label='Expand Group']";
	public static String accn_lbl="//div[@class='account-header-title']//h1";
	public static String dtls_lnk="//*[text()='Details']";
	
	public static String cntctus_menu="//div[@class='menu-text' and text()='Contact Us']";
	public static String cntctus_h1="//h1[text()='Contact Us']";
	public static String cntctus_h2="//h2[text()='We'd love to hear from you']";
	public static String actvtycntr_infmsg="//span[@test-id='textQT' and contains(text(),'View or search transactions')]";
	public static String cncl_cnfmbtn="//button[contains(@class,'btn-primary')]";
	public static String cncl_sccs="//*[text()='Transaction Cancelled']";
	public static String inqr_ttl="//h2[text()='Transaction Inquiry']";
	public static String inqr_msg="//textarea[@test-id='fldMessageContent']";
	public static String inqr_sccs="//div[text()='Message Sent']";
	public static String actvty_trnsctntyp_col="(//tbody[@class='scrollable']//td[@test-id='lnkActivityID'])[1]";
	public static String actvty_stts_col="(//tbody[@class='scrollable']//span[@test-id='txtHeaderStatus'])[1]";
	public static String toacnt_chkbx="//input[@name='toAccount']";
	public static String prcssdt_chkbx="//input[@name='processDate']";
	public static String toacnt_col="//th[@test-id='lblToAccount']";
	public static String prcssdt_col="//th[@test-id='lblProcessDate']";
	public static String created_date_col = "//th[@test-id='lblDate']";
	public static String acnt_col="//tbody[@class='scrollable']//td[4]";
	
	
	//Member to Member Transfer
	public static String mtmtrnsfr_menu="//div[@class='menu-text' and text()='Member to Member Transfer']";
	public static String sngltrnsfr_btn="//div[@id='SingleXFR']";
	public static String lnkacnt_btn="//div[@id='LinkAccount']";
	public static String mtm_back_btn="//div[contains(text(),'Back')]";
	public static String mtm_sbmt_btn="//div[contains(text(),'Submit')]";
	public static String mtm_sngltrnsfr_ttl="//h2[text()='Transfer Funds to Another Member']";
	public static String mtm_lnkacnt_ttl="//h2[text()='Link An Account']";
	public static String mtm_frmacnt_dropdown="//select[@id='fromAccountSelect']";
	public static String mtm_amnt_txt="//label[@for='TransactionAmount']//following::input[1]";
	public static String mtm_desc_txt="//input[@id='Description']";
	public static String mtm_toacntnmbr_txt="//input[@id='ToAccountNumber']";
	public static String mtm_acnttyp_dropdown="//select[@id='ToAccountType']";
	public static String mtm_lstname_txt="//input[@id='MemberLastName']";
	public static String lnkacnt_errmsg="//div[contains(@class,'error-message')]";
	public static String mtm_sccsmsg="//div[contains(@class,'success')]/div[text()='Account Linked']";
	public static String mtm_donebtn="//button[@id='close']";
	public static String mtm_sngltrnsfr_sccsmsg="//div[contains(@class,'success')]/div[text()='Transaction Processing']";
	public static String mtm_vwactvty_btn="//button[@id='view']";
	public static String mtm_actvtycntr_amnt="//tbody[@class='scrollable']/tr[1]/td[@test-id='txtAmount']";
	
	
	//Help
	public static String hlp_menu="//div[@class='menu-text' and contains(text(),'Help')]";
	public static String hlpguide_menu="//div[@class='menu-text' and contains(text(),'Help Guide')]";
	public static String hlpguide_ttl="//span[@id='publication-title' and contains(text(),'TDECU Online Banking eGuide')]";
	
	//Locations
	public static String loc_menu="//div[@class='menu-text' and text()='Locations']";
	public static String atm_tab="//button[@test-id='btnBranchesATMTab']";
	public static String locsrch_txt="//input[@test-id='fldSearch']";
	
	//Settings
		public static String stng_menu="//div[@class='menu-text' and text()='Settings']";
		public static String acntprfrnc_menu="//div[@class='menu-text' and text()='Account Preferences']";
		public static String prfrnc_ttl="//h1[text()='Account Preferences']";
		public static String hidden_lnk="//div[@class='toggle-nub']";
		public static String hide_btn="//button[@test-id='btnModalButton1']";
		public static String nickname_btn="//button[@class='btn btn-default input-sm pad-H-md']";
		public static String nickname_txt="//input[@test-id='fldEditing']";
		public static String nickname_svbtn="//span[@class='icon-ok']";
		public static String nickname_cnclbtn="(//button[@aria-label='Close Tip'])[2]";
		public static String acntsrch_txt="//div[contains(@class,'searchbox')]//input[@test-id='fldSearch']";
		public static String acntsrch_clr="//button[@test-id='iconRemove']//span";
		public static String acntsrch_errmsg="//div[contains(text(),'No available accounts match the search criteria')]";
		public static String nickname_edt="//span[@class='icon-edit link-icon pointer']";
		public static String acntdtl_desc="//ul[@id='historyItems']//div[1]//div[@test-id='historyItemDescription']";
		public static String acntdtl_amnt="(//ul[@id='historyItems']//div)[1]//span[@test-id='lblAmount']";
		public static String trnsctn_err_msg="//p[contains(text(),'There are no transactions that match your filter')]";
		public static String home_menu="//div[@class='menu-text' and contains(text(),'Home')]";
		public static String acntdtl_shwfltr="//button[@test-id='btnShowFilter']";
		public static String acntdtl_aplyfltr="//q2-btn[@test-id='btnApplyFilter']";
		public static String acntdtl_resetfltr="//q2-btn[@test-id='btnClearFilter']";
		public static String acntdtl_timeprd_dropdown="//select[@test-id='selTimePeriod']";
		public static String acntdtl_trnsctntyp_dropdown="//select[@test-id='selTransType']";
		public static String acntdtl_minamnttxt="//input[@test-id='fldMinAmount']";
		public static String acntdtl_maxamnttxt="//input[@test-id='fldMaxAmount']";
		public static String acntdtl_checknofrom="//input[@test-id='fldCheckNoFrom']";
		public static String acntdtl_checknoto="//input[@test-id='fldCheckNoTo']";
		
	//Messages
		public static String msg_menu ="//div[@class='menu-text' and text()='Secure Messages']";
		public static String replyBtn = "//button[@test-id='btnReplyMessage']";
		
	//Alerts
		public static String alrt_menu="//div[@class='menu-text' and text()='Alerts']";
		public static String alrt_ttl="//h1[@test-id='lblAlertsTitle' and text()='Alerts']";
		public static String alrtopts_drop="//button[@test-id='btnUIDropdownToggle']";
		public static String alrtTypes= "//ul[@role='menu']//li";
		public static String alrtBackLink = "//a[text()='Back to Alerts']";
		public static String alrtsel_typ="//q2-select[@test-id='fldDateTypeSelect']";
		public static String alrtEvents = "//q2-select[@label='Event']//q2-option";
		public static String alrtsel_dt="//q2-calendar[@test-id='dateAlertDate']";
		public static String alrtsel_msg="//q2-input[@test-id='fldAlertMessage']";
		public static String alrtsel_dlvryEmail="//div[@class='fieldset-content']//div[contains(text(),'Email')]";
		public static String alrtsel_dlvryVoice="//div[@class='fieldset-content']//div[contains(text(),'Voice')]";
		public static String alrtsel_dlvryText="//div[@class='fieldset-content']//div[contains(text(),'SMS Text Message')]";
		public static String alrtsel_dlvrymsg="//div[@class='fieldset-content']//div[contains(text(),'Secure Message')]";
		public static String alrtTermsLink = "//button[@test-id='lnkTermsAndCond']";
		public static String SMStermsTitle = "//h1[@test-id='lblModalTitle' and text()='SMS Terms and Conditions']";
		
		
		public static String alrtsel_acnt="//q2-select[@test-id='fldAccountSelect']";
		public static String accountList= "//q2-select[@label='Account']//q2-option";
		public static String alrtsel_fld="//div[@test-id='lblAlertSelectedHade']";
		public static String alrtsel_trnsctn="//div[@test-id='lblAlertSelectedPostedType']";
		public static String onlnalrtsel_trnsctn="//q2-select[@test-id='fldSelectAlertTransType']";
		public static String transTypes= "//q2-select[@label='Transaction']//q2-option";
		public static String alrtsel_cmpr="//div[@test-id='lblAlertSelectedOperator']";
		public static String alrtsel_amnt="//q2-input[@test-id='fldAlertAmount']";
		public static String alrtsel_frqncy="//input[@test-id='cbxFrequency']";
		public static String onlnalrtsel_frqncy="//div[@test-id='lblAlertSelectedFreq']";
		public static String alrtStatus = "//q2-select[@test-id='fldOnlineActivityTypeSelect']";
		public static String statusList= "//q2-select[@label='Status']//q2-option";
		
		public static String alrt_backbtn="//button[@test-id='btnGoBack']";
		public static String alrt_svbtn="//button[@test-id='btnSave']";
		public static String acntalrt_svbtn="//span[@class='integerInputButtonText' and text()='Save']";
		public static String alrt_rccryr="//div[@test-id='cbxAnnualAlert']";
		public static String alrt_msg="//q2-input[@test-id='fldAlertMessage']";
		public static String alrt_setbtn="//div[@test-id='btnSet']";
		public static String alrt_dlvrymthd="//select[@test-id='selAlertDelivery']";
		public static String alrt_cntry="//q2-select[@test-id='selAlertTextCountry']";
		public static String countryList= "//q2-select[@label='Country']//q2-option";
		public static String alrtcall_cntry="//select[@test-id='selAlertCallCountry']";
		public static String alrt_phone="//q2-input[@test-id='fldAlertTextNumber']";
		public static String alrtcall_phone="//q2-input[@test-id='fldAlertCallNumber']";
		public static String alrtCheckNumLbl = "//q2-input[@label='Check Number']";
		
		public static String alrt_sndimdt="//input[@test-id='cbxAlertSendImmediately']";
		public static String alrt_acpttrms="//q2-checkbox[@test-id='cbxAcceptTerms']";
		public static String alrt_svsccs="//div[text()='Save Alert']";
		public static String alrt_clsbtn="//button[@test-id='btnClose']";
		public static String alrt_email="//input[@test-id='fldAlertEmail']";
		public static String alrt_desc="//input[@test-id='fldDescription']";
		public static String alrt_edt="//div[@test-id='lblAlertList']//tbody/tr/td[6]/button[@test-id='btnEditAlert']";
		public static String alrt_off="//div[@test-id='lblAlertList']//tbody/tr/td[5]//div[@class='toggle-nub']";
		public static String alrt_delbtn="//button[@test-id='btnDelete']";
		public static String alrt_confirmbtn="//button[@test-id='btnModalButton2']";
		public static String onlntrnsctnalrt_drop="//div[contains(@class,'form-container')]/div[4]//div[@test-id='btnDropDown']";
		public static String dtalrt_drop="//div[contains(@class,'form-container')]/div[1]//div[@test-id='btnDropDown']";
		
	//Services
		public static String service_menu="//div[@class='menu-text' and contains(text(),'Services')]";
		public static String wiretrnsfr_menu="//div[@class='menu-text' and contains(text(),'Wire Transfer')]";
		public static String wiretrnsfr_ttl="//div[@class='payment-content']//h1";
		public static String rcpnt_chkbx="//input[@type='checkbox']";
		public static String wiretrnsfr_amnt="//td[@test-id='txtPrimaryAmount']/input[@test-id='fldAmount']";
		
		public static String addrcpnt_btn="//button[@test-id='btnAddRecipient']";
		public static String addrcpnt_ttl="//h1[contains(text(),'Add Recipient')]";
		public static String addrcpnt_cnclbtn="//button[@test-id='btnCancel']";
		public static String addrcpnt_nxtbtn="//button[@test-id='btnNext']";
		public static String listvw_btn="//button[@test-id='tglList']";
		public static String gridvw_btn="//button[@test-id='tglGrid']";
		public static String gridacnt_col="//th[text()='Account']";
		public static String sort_dropdown="//div[@test-id='btnSortDropdown']";
		public static String sortAtoZ_opt="//div[@test-id='drpSortByType' and text()='A-Z']";
		public static String sortZtoA_opt="//div[@test-id='drpSortByType' and text()='Z-A']";
		public static String wiretrnsfr_dsplynm="//input[@test-id='fldDisplayName']";
		public static String wiretrnsfr_wrnm="//input[@test-id='fldRecipientWireName']";
		public static String wiretrnsfr_email="//input[@test-id='fldRecipientEmail']";
		public static String wiretrnsfr_acntno="//input[@test-id='fldAccountNumber']";
		public static String wiretrnsfr_bnknm="//input[@test-id='fldFiName']";
		public static String wiretrnsfr_rtngnmbr="//input[@test-id='fldFiAba']";
		public static String wiretrnsfr_addrs1="//input[@test-id='fldFiAddress1']";
		public static String wiretrnsfr_city="//input[@test-id='fldFiCity']";
		public static String wiretrnsfr_state="//select[@test-id='selFiState']";
		public static String wiretrnsfr_zip="//input[@test-id='fldFiZip']";
		public static String wiretrnsfr_svrcp="//button[@test-id='btnCreateRecipient']";
		public static String wiretrnsfr_updtrcp="//button[@test-id='btnSaveRecipient']";
		public static String wiretrnsfr_edt="//a[@class='icon-pencil']";
		public static String wiretrnsfr_rcpchk="//input[@type='checkbox']";
		public static String wiretrnsfr_msg="//input[@test-id='fldAddendum']";
		public static String noacnt_msg="//div[contains(text(),'There are no accounts to display')]";
		public static String wiretrnsfr_nxtbtn="//a[@test-id='btnNextStep']";
		public static String purpose_desc="//input[@test-id='fldBeneficiaryMessage']";
		public static String apprv_btn="//button[@test-id='btnTemplateApprove']";
		public static String wiretrnsfr_sccsmsg="//div[text()='Payment Approved']";
		
		//Stop Payments 
		public static String stppaymnt_menu="//div[@class='menu-text' and contains(text(),'Stop Payment')]";
		public static String stppaymnt_ttl="//h1[contains(text(),'Stop Payment')]";
		public static String stppaymnt_sndrqst_btn="//button[@test-id='btnSend']";
		public static String stppaymnt_bckbtn="//div[contains(@class,'cancel') and text()='Back']";
		public static String stppaymnt_snglchk="//div[@test-id='lblSingleChk']";
		public static String stppaymnt_mltchk="//div[@test-id='lblMultiChk']";
		public static String stppaymnt_rqsttyp="//span[text()='Request Type']";
		public static String stppaymnt_acnttyp="//span[@class='stepName' and text()='Account']";
		public static String stppaymnt_slctdrqsttyp="//div[contains(@class,'formSteps')]/div[1]/div[1]/div[@class='stepHeading']";
		public static String acnt_ttl="//span[@test-id='txtCategoryTitle' and text()='Accounts']";
		public static String stppaymnt_acnt="//div[@test-id='lblSelAC']";
		public static String stppaymnt_slctdacnt="//div[@class='stepDetails account']//div[@class='stepDetail']";
		public static String stppaymnt_payeetab="//div[@class='stepName' and text()='Payee']";
		public static String stppaymnt_payeetxt="//input[@test-id='tbxPayee']";
		public static String stppaymnt_setbtn="//div[@test-id='btnSet']";
		public static String stppaymnt_amnttab="//div[@class='stepName' and text()='Amount']";
		public static String stppaymnt_dltbtn="//span[@class='integerInputButtonText' and text()='Delete']";
		public static String stppaymnt_svbtn="//span[@class='integerInputButtonText' and text()='Save']";
		public static String stppaymnt_datetab="//div[@class='stepName' and text()='Date']";
		public static String stppaymnt_notetab="//div[@class='stepName' and text()='Note']";
		public static String stppaymnt_notetxt="//div[@test-id='tbxDesc']/input";
		public static String chknumber_txt="//div[contains(@class,'integer-amt')]/input";
		
		//Access Point
		public static String accsspnt_menu="//div[@class='menu-text' and text()='Access Point']";
		public static String credt_crd="//div[@class='menu-text' and contains(text(),'Credit Cards')]";
		public static String accsspnt_ttl="//div[text()='Please Choose an Account']";
		public static String addcrd_ttl="//span[text()='Add Card']";
		public static String cncl_btn="//span[text()='Cancel']";
		public static String yes_btn="//span[text()='Yes']";
		
		//Rates
		public static String Rates_menu="//div[@class='menu-text' and contains(text(),'Rates')]";
	
	//Footer
		public static String crprt_lnk="//a[text()='Corporate Site']";
		public static String lrnmr_lnk="//a[text()='Learn More']";
		public static String cntctus_lnk="//a[text()='Contact Us']";
		public static String ourblg_lnk="//a[text()='Our Blog']";
		public static String abtus_lnk="//a[text()='About Us']";
		public static String fcbk_lnk="//a[contains(@href,'facebook')]";
		public static String twtr_lnk="//a[contains(@href,'twitter')]";
		public static String plsggl_lnk="//a[contains(@href,'google')]";
		
		//Locators for Template Creation
		
				public static String cancel_btn = "//button[@test-id='btnTemplateList']";
				public static String newTempLateDropdown_btn ="//div[@class='ember-view dropdown pull-right']//following::button[1]/span";
				public static String domesticWireOption ="//div[@test-id='btnNewTemplateDomesticWire']";
				public static String templateNameTxt = "//input[@test-id='fldTemplateName']";
				public static String VisibletemplateName = "//label[contains(text(),'Template Name')]/following::div[1]";
				
		//Address Change Scenario
				
				public static String addressChange_suboption ="//div[contains(text(),'Address Change')]";
				public static String addressChange_header ="//h1[contains(text(),'Address Change')]";
				public static String addressChangeSubmit = "//button[@test-id='btnSubmitAddressChange']";
				public static String activityCenterHeader = "//h1[contains(text(),'Activity Center')]";
				public static String recordOfTable ="(//table[@test-id='txtAccountsTable']//tr)[2]";
				public static String closeButton = "//button[@test-id='btnClose']";
				public static String viewInActivityButton = "//button[text()='View In Activity Center']";
				public static String modalTitle = "//div[@class='ui-modal-header']";
				public static String selectAllButton = "//button[text()='Select All']";
				public static String confirmationMsg = "//div[@class='ui-modal-header']//p";
				public static String firstRecordInTable = "(//table[@test-id='txtAccountsTable']//td[@test-id='txtHeaderAccount'])[1]";
				public static String actionsDropdown = "(//table[@test-id='txtAccountsTable']//div[@test-id='drpTransactionActions'])[1]";
				public static String allOptions ="(//table[@test-id='txtAccountsTable']//div[@test-id='drpTransactionActions'])[1]//li";
				public static String secureMasgPageTitle = "//h1[@test-id='lblMessagesTitle']";
				public static String messageArea = "//textarea[@test-id='fldMessageContent']";
				public static String sendButton = "//button[@test-id='btnSubmit']";
				public static String modalLableTitle = "//*[@test-id='lblModalTitle']";
				public static String modalNoButton = "//button[text()='No']";
				public static String modalConfirmButton ="//button[text()='Confirm']";
				public static String modalTxt = "//*[@test-id='txtModalText']";
				public static String modalCloseButton = "//button[@test-id='btnClose']";
				public static String modalFundTransferPopUpCloseBtn = "//button[@test-id='btnModalButton2']";
				public static String applyButtonToScroll = "//button[text()='Apply']";
				
				//cPFM locators, Added by Sravya
				public static String lnkacnt_sctn="//div[@test-id='btnLinkAcct']//span[text()='Link Account']";
				public static String lnkacnt_clckhere="//div[@test-id='btnLinkAcct']//a[text()='Click here to get started.']";
				public static String cntn_btn="//*[text()='Continue']";
				public static String tnc_chkbx="//div[@class='input-checkbox']//rect";
				public static String getstrtd_btn="//*[text()='Get Started']";
				public static String lnkacnt_ttl="//h3[text()='Link Account']";
				public static String spndng_tab="//button[@test-id='tabSpending']";
				public static String budget_tab="//button[@test-id='tabBudget']";
				public static String trends_tab="//button[@test-id='tabTrends']";
				public static String cashflow_tab="//button[@test-id='tabCash_Flow']";
				public static String netwrth_tab="//button[@test-id='tabNet_Worth']";
				public static String debts_tab="//button[@test-id='tabDebts']";
				
				
				public static String extrnlacnt_lnk="//button[@test-id='tabaddExternalAccount']";
				
				public static String Finacc_txt="//h2[text()='Financial Tools']";
				
				public static String lnksrch_txt="//div[@role='search']//input[@test-id='fldSearch']";
				public static String lnksrch_clr="//button[@test-id='btnClearSearch']//span";
				public static String trnsctn_optmenu="//ul[@id='historyItems']/li[1]//span[contains(@class,'ui-dropdown-icon')]";
				public static String dtls_opt="//a[@test-id='txnDropDownViewDetails']";
				public static String print_opt="//a[@test-id='txnDropDownPrint']";
				public static String ctgrz_opt="//a[@test-id='txnDropDownCategorize']";
				public static String splt_opt="//a[@test-id='txnDropDownSplit']";
				public static String askqstn_opt="//a[@test-id='txnDropDownInquire']";
				public static String splt_inpt="//q2-input[@aria-label='Split amount']";
				public static String sv_chk="//q2-icon[@type='checkmark']";
				public static String notsclctd_ctgry="//section[@id='sidepanel-accordion']/ul/div/li[not(@class)]";
				public static String fltr_icon="//span[contains(@class,'icon-filter')]";
				public static String ctgry_drop="//q2-select[@label='Category']";
				public static String fltr_btn="//q2-btn[@test-id='btnApplyFilter']";
				public static String vwasst_lnk="//button[text()='View Assets & Liabilities']";
				public static String asst_frame="//iframe[@id='overpanelIFrame']";
				public static String trnsctn_row="//ul[@id='historyItems']/li[1]";
				public static String ctgry_edt="//div[@test-id='lblPfmCategory']//span[contains(@class,'icon-edit')]";
				public static String netwrth_ftr="//button[@aria-label='Filter Accounts']";
				public static String netwrth_appyfltr="//button[@aria-label='Apply selected filters to accounts']";
				
				public static String netwrth_6m="//button[@aria-label='Display six month history']";
				public static String netwrth_9m="//button[@aria-label='Display nine month history']";
				public static String netwrth_1y="//button[@aria-label='Display one year history']";
				
				public static String debtacntdtls_tab="//button[@aria-label='DETAILS tab']";
				public static String debtamnt_txt="//input[@name='monthly_payment']";
				public static String Acc_row="//ul[@id='Account']/li[1]";
				
				public static String debtacnt_back="//button[@aria-label='Close Account Details Drawer']";
				
				public static String debtintrate_txt="//input[@name='interest_rate']";
				
				public static String Trends_3m="//button[@aria-label='Trends for the past 3 months']";
				public static String Trends_6m="//button[@aria-label='Trends for the past 6 months']";
				public static String Trends_9m="//button[@aria-label='Trends for the past 9 months']";
				public static String Trends_1y="//button[@aria-label='Trends for the past year']";
				public static String acntactn_menu="//button[contains(@aria-label,'Account Actions Menu')]";
				public static String hideacnt_btn="//button[@data-ui-test='Hide from Debts']";
				public static String showacnt_btn="//button[@data-ui-test='Show in Debts']";
				public static String trndstablevw_btn="//button[contains(@aria-label,'Displays detailed transaction trends by category')]";
				public static String trndctgry_row="//div[contains(@aria-label,'Select to view Income transactions for this period')]";
				public static String trndtrnsctn_row="//button[contains(@aria-label,'Transaction, Date:')]";
				public static String payee_dtls="//label[text()='Payee']";
				public static String date_dtls="//label[text()='Date']";
				public static String ctgry_dtls="//label[text()='Category']";
				public static String tags_dtls="//label[text()='Tags']";
				public static String memo_dtls="//label[text()='Memo']";
				
		//Retrun shadow root element
				
				public static WebElement expandRootElement(WebDriver driver,WebElement element) {
					WebElement ele = (WebElement) ((JavascriptExecutor)driver)
				.executeScript("return arguments[0].shadowRoot", element);
					return ele;
				}
				
	 	//Date option selection
			public static String dateRangeOption(String value){
				String locator = "//div[contains(text(),'"+value+"')]";
				return locator;
				
			}
}
