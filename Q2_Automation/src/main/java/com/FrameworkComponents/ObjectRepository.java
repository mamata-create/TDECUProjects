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
	public static String trnsctntyp_parent="//div[@class='col-xs-12']/div[1]/div[1]";
	public static String trnsctntyp_drop="//select[@class='ember-view ember-select form-control']";
	public static String stts_parent="//div[@class='col-xs-12']/div[1]/div[2]//select[@class='ember-view ember-select form-control']";
	public static String acnt_parent="//div[@class='col-xs-12']/div[1]/div[3]//select[@class='ember-view ember-select form-control']";
	public static String crtd_parent="//div[@class='col-xs-12']/div[1]/div[4]//select[@class='ember-view ember-select form-control']";
	public static String amnt_parent="//div[@class='col-xs-12']/div[1]/div[5]//select[@class='ember-view ember-select form-control']";
	public static String trnsctnID_txt="//div[@class='col-xs-12']/div[2]/div[2]//input";
	public static String srchamnt_txt="//input[contains(@class,'currency') and @test-id='fldAmtRangeFrom']";
	public static String crtd_col_srt="//table[@test-id='txtAccountsTable']//th[@test-id='lblDate']//span[contains(@class,'sort-icon')]";
	public static String stts_col_srt="//table[@test-id='txtAccountsTable']//th[@test-id='lblStatus']//span[contains(@class,'sort-icon')]";
	public static String trnsctntyp_col_srt="//table[@test-id='txtAccountsTable']//th[@test-id='lblTransactionType']//span[contains(@class,'sort-icon')]";
	public static String acnt_col_srt="//table[@test-id='txtAccountsTable']//th[@test-id='lblAccount']//span[contains(@class,'sort-icon')]";
	public static String amnt_col_srt="//table[@test-id='txtAccountsTable']//th[@test-id='lblAmount']//span[contains(@class,'sort-icon')]";
	public static String actns_lnk="(//button[@aria-label='Actions']//span)[1]";
	public static String recactns_lnk="//div[@class='content-wrapper grid-column']//tbody[@class='scrollable']/tr[5]//div[@test-id='drpTransactionActions']";
	public static String fav_drop="//a[@test-id='btnACFavorites']";
	public static String addfav="//div[@test-id='btnAddFavorite']";
	public static String favnickname_txt="//input[@test-id='fldFavoriteNickname']";
	public static String favsave_btn="//button[@test-id='btnSaveFavorite']";
	public static String favcncl_btn="//button[@test-id='btnCloseNewFavoriteModal']";
	public static String resetfltr_btn="//button[@test-id='btnResetFilters']";
	public static String aplyfltr_btn="//button[@test-id='lnkSearch']";
	public static String actn_lnk="//tr[@test-id='txtTransactionSummary']/td[6]/div[@test-id='drpTransactionActions']";
	public static String actn_cncl="//button[@aria-label='Actions']/following::ul[1]//li[2]";
	public static String actn_inqr="//button[@aria-label='Actions']/following::ul[1]//li[3]";
	
	public static String trnsfrmnynow_lnk="//div[@test-id='btnQuickTransfer']";
	
	public static String fundtransfer_ttl="//h1[text()='Funds Transfer']";
	public static String wlcmmsg="//span[contains(text(),'Welcome back')]";
	
	public static String accntgrp_expnd="//div[contains(@class,'account-group')]//a[@aria-label='Expand Group']";
	public static String accn_lbl="//span[@class='account-label']";
	public static String dtls_lnk="//*[text()='Details']";
	
	public static String cntctus_menu="//div[@class='menu-text' and text()='Contact Us']";
	public static String cntctus_h1="//h1[text()='Contact Us']";
	public static String cntctus_h2="//h2[text()='We'd love to hear from you']";
	public static String actvtycntr_infmsg="//div[@class='quicktips-text' and contains(text(),'View or search transactions')]";
	public static String cncl_cnfmbtn="//button[contains(@class,'btn-primary')]";
	public static String cncl_sccs="//*[text()='Transaction Cancelled']";
	public static String inqr_ttl="//h2[text()='Transaction Inquiry']";
	public static String inqr_msg="//textarea[@test-id='fldMessageContent']";
	public static String inqr_sccs="//div[text()='Message Sent']";
	public static String actvty_trnsctntyp_col="//div[@class='content-wrapper grid-column']//tbody[@class='scrollable']/tr[1]//td[@test-id='lnkActivityID']";
	public static String actvty_stts_col="//div[@class='content-wrapper grid-column']//tbody[@class='scrollable']/tr[1]//td[@class='status']";
	public static String toacnt_chkbx="//input[@name='toAccount']";
	public static String prcssdt_chkbx="//input[@name='processDate']";
	public static String toacnt_col="//th[@test-id='lblToAccount']";
	public static String prcssdt_col="//th[@test-id='lblProcessDate']";
	public static String acnt_col="//div[@class='content-wrapper grid-column']//tbody[@class='scrollable']/tr[1]//td[@class='account']";
	
	
	//Member to Member Transfer
	public static String mtmtrnsfr_menu="//div[@class='menu-text' and text()='Member to Member Transfer']";
	public static String sngltrnsfr_btn="//div[@id='SingleXFR']";
	public static String lnkacnt_btn="//div[@id='LinkAccount']";
	public static String mtm_back_btn="//div[contains(text(),'Back')]";
	public static String mtm_sbmt_btn="//div[contains(text(),'Submit')]";
	public static String mtm_sngltrnsfr_ttl="//h2[text()='Transfer Funds to Another Member']";
	public static String mtm_lnkacnt_ttl="//h2[text()='Link An Account']";
	public static String mtm_frmacnt_dropdown="//select[@id='fromAccountSelect']";
	public static String mtm_amnt_txt="//input[@id='TransactionAmount']";
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
		public static String nickname_cnclbtn="//span[@class='icon-remove']";
		public static String acntsrch_txt="//div[contains(@class,'searchbox')]//input[@test-id='fldSearch']";
		public static String acntsrch_clr="//button[@test-id='iconRemove']//span";
		public static String acntsrch_errmsg="//div[contains(text(),'No available accounts match the search criteria')]";
		public static String nickname_edt="//span[@class='icon-edit link-icon pointer']";
		public static String acntdtl_desc="//div[@id='historyItems']/div[1]//div[@test-id='historyItemDescription']";
		public static String acntdtl_amnt="//div[@id='historyItems']/div[1]//div[@test-id='lblAmount']";
		public static String trnsctn_err_msg="//p[contains(text(),'There are no transactions that match your filter')]";
		public static String home_menu="//div[@class='menu-text' and contains(text(),'Home')]";
		public static String acntdtl_shwfltr="//a[@test-id='lnkShowFilter']";
		public static String acntdtl_aplyfltr="//span[@test-id='btnApplyFilter']";
		public static String acntdtl_resetfltr="//span[@test-id='btnClearFilter']";
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
		public static String alrtopts_drop="//div[@test-id='openNewAlert']";
		public static String alrtBackLink = "//a[text()='Back to Alerts']";
		public static String alrtsel_typ="//q2-select[@test-id='fldDateTypeSelect']";
		public static String alrtsel_dt="//q2-calendar[@test-id='dateAlertDate']";
		public static String alrtsel_msg="//q2-input[@test-id='fldAlertMessage']";
		public static String alrtsel_dlvryEmail="//div[@class='fieldset-content']//div[contains(text(),'Email')]";
		public static String alrtsel_dlvryVoice="//div[@class='fieldset-content']//div[contains(text(),'Voice')]";
		public static String alrtsel_dlvryText="//div[@class='fieldset-content']//div[contains(text(),'SMS Text Message')]";
		public static String alrtsel_dlvrymsg="//div[@class='fieldset-content']//div[contains(text(),'Secure Message')]";		
		
		public static String alrtsel_acnt="//q2-select[@test-id='fldAccountSelect']";
		public static String alrtsel_fld="//div[@test-id='lblAlertSelectedHade']";
		public static String alrtsel_trnsctn="//div[@test-id='lblAlertSelectedPostedType']";
		public static String onlnalrtsel_trnsctn="//q2-select[@test-id='fldSelectAlertTransType']";
		public static String alrtsel_cmpr="//div[@test-id='lblAlertSelectedOperator']";
		public static String alrtsel_amnt="//q2-input[@test-id='fldAlertAmount']";
		public static String alrtsel_frqncy="//input[@test-id='cbxFrequency']";
		public static String onlnalrtsel_frqncy="//div[@test-id='lblAlertSelectedFreq']";
		public static String alrtStatus = "//q2-select[@test-id='fldOnlineActivityTypeSelect']";
		
		public static String alrt_backbtn="//button[@test-id='btnGoBack']";
		public static String alrt_svbtn="//button[@test-id='btnSave']";
		public static String acntalrt_svbtn="//span[@class='integerInputButtonText' and text()='Save']";
		public static String alrt_rccryr="//div[@test-id='cbxAnnualAlert']";
		public static String alrt_msg="//input[@test-id='fldAlertMessage']";
		public static String alrt_setbtn="//div[@test-id='btnSet']";
		public static String alrt_dlvrymthd="//select[@test-id='selAlertDelivery']";
		public static String alrt_cntry="//select[@test-id='selAlertTextCountry']";
		public static String alrtcall_cntry="//select[@test-id='selAlertCallCountry']";
		public static String alrt_phone="//input[@test-id='fldAlertTextNumber']";
		public static String alrtcall_phone="//q2-input[@test-id='fldAlertCallNumber']";
		public static String alrtCheckNumLbl = "//q2-input[@label='Check Number']";
		
		public static String alrt_sndimdt="//input[@test-id='cbxAlertSendImmediately']";
		public static String alrt_acpttrms="//input[@test-id='cbxAcceptTerms']";
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
		public static String wiretrnsfr_ttl="//div[@class='page-metaheader inner-metaheader']/h1";
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
