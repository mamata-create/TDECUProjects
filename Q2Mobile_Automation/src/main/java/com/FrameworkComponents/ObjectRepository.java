package com.FrameworkComponents;

public class ObjectRepository {
//login page
	public static String username_txt="//*[@resource-id='com.texasdowcreditunion5004.mobile.preproduction:id/username']";
	public static String password_txt="//*[@resource-id='com.texasdowcreditunion5004.mobile.preproduction:id/password']";
	public static String login_btn="//*[@resource-id='com.texasdowcreditunion5004.mobile.preproduction:id/btn_sign_in']";
	public static String emailotp_btn="//android.view.View[contains(@content-desc,'mail')]";
	public static String otp_txt="//android.widget.EditText[@index='0']";
	public static String submit_btn="//android.widget.Button[@content-desc='Submit']";
	public static String rgstrdvc_btn="//android.view.View[@content-desc='Register Device']";
	public static String dontrgstrdvc_btn="//android.view.View[@content-desc='Do Not Register Device']";
	public static String lctns_lnk="//android.view.View[@content-desc='Locations']";
	public static String rmbrme_chk="//android.widget.CheckBox[@text='Remember me']";	
	
//Location
	public static String alw_btn="//android.widget.Button[@text='ALLOW']";
	public static String loctn_menu="//android.view.View[@content-desc='Locations']";
	public static String loctn_msg="//android.view.View[contains(@content-desc,'Locations include TDECU branches and ATMs')]";
	public static String loctn_list="//android.view.View[@content-desc='List']";
	
	
//Menu items	
	public static String logoff_menu="//android.view.View[contains(@content-desc,'Log Off')]";
	public static String home_ttl="//android.view.View[@content-desc='Home']";
	public static String menu_btn="//android.widget.Button[contains(@content-desc,'Menu')]";
	public static String service_menu="//android.widget.TextView[contains(@text,'Services')]";
	public static String trnsctn_menu="//android.widget.TextView[contains(@text,'Transactions')]";
	public static String crdtcrd_menu="//android.widget.TextView[@text='Credit Cards']";
	public static String acnt_sel="//android.view.View[contains(@content-desc,'Platinum')]";
	
	public static String loginvldtn_msg="//android.widget.TextView[contains(@text,'Authentication has failed. Please re-enter your login.')]";
	public static String addcrd_ttl="//android.webkit.WebView[@content-desc='Add Card']";
	public static String cncl_btn="//*[contains(@content-desc,'Cancel')]";
	public static String yes_btn="//*[contains(@content-desc,'Yes')]";
	
	public static String info_msg="//android.view.View[contains(@content-desc,'Click an account to view the details')]";
	public static String info_msg_cls="//android.widget.Button[@content-desc='Close Tip']";
	
	public static String wlcm_msg ="//android.view.View[contains(@content-desc,'Welcome back')]";
	public static String invalid_msg="//android.view.View[contains(@content-desc,'Secure Access code you entered is invalid')]";

	//Stop Payment
	
	public static String stppymnt_menu="//android.view.View[contains(@content-desc,'Stop Payment')]";	
	public static String stppymnt_ttl="//android.view.View[@content-desc='Place a stop payment on a single check or multiple checks that have not cleared your account.']";
	public static String stppymnt_tnc="//android.view.View[contains(@content-desc,'Complete the fields below to make a stop payment request')]";
	public static String stppymnt_rqsttyp="//android.view.View[contains(@content-desc,'Request type')]";
	public static String stppymnt_acnt="//android.view.View[contains(@content-desc,'Account')]";
	public static String stppymnt_chknmbr="//android.view.View[contains(@content-desc,'Check number')]";
	public static String stppymnt_strtchknmbr="//android.view.View[contains(@content-desc,'STARTING CHECK NUMBER*')]";
	public static String stppymnt_endchknmbr="//android.view.View[contains(@content-desc,'ENDING CHECK NUMBER*')]";
	public static String stppymnt_payee="//android.view.View[contains(@content-desc,'Payee name')]";
	public static String stppymnt_amnt="//android.view.View[contains(@content-desc,'AMOUNT')]";
	public static String stppymnt_date="//android.view.View[contains(@content-desc,'DATE')]";
	public static String stppymnt_strtdate="//android.view.View[contains(@content-desc,'START DATE')]";
	public static String stppymnt_enddate="//android.view.View[contains(@content-desc,'END DATE')]";
	public static String stppymnt_note="//android.view.View[contains(@content-desc,'Note')]";
	public static String sndrqst_btn="//android.widget.Button[contains(@content-desc,'Request stop payment')]";
	public static String slctall_btn="//android.widget.Button[@content-desc='Select All']";
	public static String rqsttyp_msg="//android.view.View[contains(@content-desc,'Are you requesting to stop payment on one or multiple checks')]";
	public static String snglchk_optn="//android.view.View[@content-desc='Single Check']";
	public static String mltplchk_optn="//android.view.View[@content-desc='Multiple Checks']";
	public static String stppymnt_payeename="//android.widget.EditText[@content-desc='Payee Name']";
	public static String stppymnt_set="//android.view.View[@content-desc='Set']";
	public static String stppymnt_dtttl="//android.view.View[@content-desc='Enter the date of the check']";
	public static String stppymnt_notemsg="//android.view.View[@content-desc='Enter a brief note to include with this request']";
	public static String stppymnt_notetxt="//android.widget.EditText[@content-desc='Description']";

//Mobile deposit
	public static String mbldpst_menu="//android.widget.TextView[@text='Mobile Deposit Enrollment']";
	public static String mbldpst_ttl="//android.view.View[@content-desc='REMOTE DEPOSIT CAPTURE ENROLLMENT']";

//Wire Transfer
	public static String wiretrnsfr_menu="//android.widget.TextView[@text='Wire Transfer']";
	public static String wiretrnsfr_ttl="//android.view.View[@content-desc='Domestic Wire']";
	public static String rcpnt_srchtxt="//android.widget.EditText[contains(@content-desc,'Search by name or account')]";
	public static String newrcpnt_btn="//android.widget.Button[contains(@content-desc,'New Recipient')]";
	public static String dsplyname_txt="//android.view.View[@content-desc='Display Name*']/parent::*/following-sibling::android.widget.EditText";
	public static String wirename_txt="//android.view.View[@content-desc='Wire Name']/parent::*/following-sibling::android.widget.EditText";
	public static String emailadrs_txt="//android.view.View[@content-desc='Email Address']/parent::*/following-sibling::android.widget.EditText";
	public static String emailntfctn_chk="//android.view.View[@content-desc='Send email notifications']";
	public static String cntry_dropdown="//android.view.View[contains(@content-desc,'Country')]/parent::*/following-sibling::android.widget.Spinner";
	public static String adrs1_txt="//android.view.View[contains(@content-desc,'Address 1')]/parent::*/following-sibling::android.widget.EditText";
	public static String adrs2_txt="//android.view.View[@content-desc='Address 2']/parent::*/following-sibling::android.widget.EditText";
	public static String city_txt="//android.view.View[contains(@content-desc,'City')]/parent::*/following-sibling::android.widget.EditText";
	public static String state_dropdown="//android.view.View[contains(@content-desc,'State')]/parent::*/following-sibling::android.widget.Spinner";
	public static String zip_txt="//android.view.View[contains(@content-desc,'ZIP')]/parent::*/following-sibling::android.widget.EditText";
	public static String ok_btn="//android.widget.Button[@content-desc='Use Without Save']";
	public static String acntnew_tab="//android.view.View[@content-desc='Account - New']";
	public static String acnt_txt="//android.view.View[@content-desc='Account*']/parent::*/following-sibling::android.widget.EditText";
	public static String bankname_txt="//android.view.View[@content-desc='Name*']/parent::*/following-sibling::android.widget.EditText";
	public static String ABANumber_txt="//android.view.View[contains(@content-desc,'FI ABA Number*')]/parent::*/following-sibling::android.widget.EditText";
	public static String rtngnmbr_txt="//android.view.View[@content-desc='Wire Routing Number']/parent::*/following-sibling::android.widget.EditText";
	public static String bankaddress1_txt="//android.view.View[contains(@content-desc,'Address 1*')]/parent::*/following-sibling::android.widget.EditText";
	public static String bankcity_txt="//android.view.View[contains(@content-desc,'City*')]/parent::*/following-sibling::android.widget.EditText";
	public static String bankstate_dropdown="//android.view.View[contains(@content-desc,'State*')]/parent::*/following-sibling::android.widget.Spinner";
	public static String bankzip_txt="//android.view.View[contains(@content-desc,'Postal Code*')]/parent::*/following-sibling::android.widget.EditText";
	
	
	//Rates
	public static String rates_menu="//android.widget.TextView[@text='Rates']";
	public static String rates_url="//android.widget.TextView[@resource-id='com.texasdowcreditunion5004.mobile.preproduction:id/browsernav_text']";

	
//Alerts section
	public static String alrt_menu="//android.widget.TextView[@text='Alerts']";
	public static String alrt_ttl="//android.view.View[@content-desc='Alerts']";
	public static String dtalrt_sctn="//android.view.View[contains(@content-desc,'REMINDERS')]";
	public static String acntalrt_sctn="//android.view.View[contains(@content-desc,'Account Alerts')]";
	public static String hstryalrt_sctn="//android.view.View[contains(@content-desc,'History Alerts')]";
	public static String onlntrnsctnalrt_sctn="//android.view.View[contains(@content-desc,'Online Transaction Alerts')]";
	public static String scrtyalrt_sctn="//android.view.View[contains(@content-desc,'Security Alerts')]";
	public static String alrttyp_dropdown="//android.widget.Spinner[contains(@content-desc,'New Alert')]";
	public static String acntalrt_ttl="//android.view.View[@content-desc='New Account Alert']";
	public static String datealrt_ttl="//android.view.View[@content-desc='New Reminder']";
	public static String hstryalrt_ttl="//android.view.View[@content-desc='New History Alert']";
	public static String onlntrnstcnalrt_ttl="//android.view.View[@content-desc='New Online Transaction Alert']";
	public static String back_btn="//android.widget.Button[@content-desc='Back']";
	public static String alrt_noacnt="//android.view.View[contains(@content-desc,'No Account Selected')]";
	public static String alrt_notrnsctn="//android.view.View[contains(@content-desc,'No Transaction Selected')]";
	public static String alrt_nofld="//android.view.View[contains(@content-desc,'No Field Selected')]";
	public static String alrt_acnt="//android.view.View[contains(@content-desc,'Account')]/following-sibling::android.widget.Button";
	public static String alrt_type="//android.widget.Button[contains(@content-desc,'Event')]";
	public static String alrt_date="//android.widget.Button[contains(@content-desc,'Select a date')]";
	public static String alrt_fld="//android.view.View[contains(@content-desc,'FIELD')]";
	public static String alrt_trnsctn="//android.view.View[contains(@content-desc,'Transaction')]/following-sibling::android.widget.Button";
	public static String alrt_cmprsn="//android.view.View[contains(@content-desc,'COMPARISON')]";
	public static String alrt_msg="//android.view.View[contains(@content-desc,'Message')]/following-sibling::android.widget.EditText";
	public static String alrt_stts="//android.view.View[contains(@content-desc,'Status')]/following-sibling::android.widget.Button";
	public static String alrt_amnt="//android.view.View[contains(@content-desc,'AMOUNT')]";
	public static String alrt_dlvrymthd="//android.view.View[contains(@content-desc,'DELIVERY METHOD')]";
	public static String alrt_occrnc="//android.widget.CheckBox[contains(@content-desc,'Every Occurrence')]";
	public static String alrt_callimdt="//android.widget.CheckBox[@content-desc='Call Immediately']";
	public static String alrt_amntdlt="//android.view.View[contains(@content-desc,'Delete')]";
	public static String alrt_amntsv="//android.view.View[contains(@content-desc,'Save')]";
	public static String alrt_amntcross="//android.widget.EditText[@index='0']/following-sibling::android.view.View[contains(@content-desc,'')]";
	public static String alrt_amntclr="//android.view.View[@content-desc='' and @index='2']";
	public static String alrt_dlvrymthd_ttl="//android.view.View[@content-desc='Alert Delivery Method']";
	public static String alrt_dlvrymthdtyp="//android.widget.Spinner[@index='0']";
	public static String alrt_acntback="//android.view.View[@content-desc='Back']";
	public static String alrt_msgtxt="//android.widget.EditText[@index='0']";
	public static String alrt_emailtxt="//android.widget.EditText[@content-desc='Email Address']";
	public static String alrt_setbtn="//android.widget.Button[@content-desc='Set']";
	public static String alrt_donebtn="//android.view.View[@content-desc='Done']";
	public static String alrt_svbtn="//android.widget.Button[@content-desc='Create Alert']";
	public static String alrt_dltbtn="//android.widget.Button[@content-desc='Delete']";
	public static String alrt_cnfrmbtn="//android.widget.Button[@content-desc='Confirm']";
	public static String alrt_svsccs="//android.view.View[@content-desc='Your alert has been saved.']";
	public static String msg_menu="//android.widget.TextView[@text='Secure Messages']";
	public static String mtngrmndr="//android.view.View[@content-desc='Meeting Reminder']";
	public static String rply="//android.widget.Button[@content-desc='Reply']";
	public static String rply_notallwd="//android.view.View[@content-desc='You cannot reply to this message.']";
	public static String alrt_phone="//android.widget.EditText[contains(@content-desc,'Phone Number')]";
	public static String alrt_hour="//android.widget.Spinner[@content-desc='HH']";
	public static String alrt_min="//android.widget.Spinner[@content-desc='MM']";
	public static String alrt_ampm="//android.widget.Spinner[contains(@content-desc,'PM')]";
	public static String alrt_tnc="//android.widget.CheckBox[@content-desc='Agree To Terms']";
	public static String alrt_sndimdt="//android.widget.CheckBox[@content-desc='Send Immediately']";
	public static String alrt_off="//android.view.View[@content-desc='Off']";
	public static String alrt_on="//android.view.View[@content-desc='On']";
	public static String alrt_dltwrng="//android.view.View[contains(@content-desc,'Are you sure you want to delete this alert')]";
	public static String alrt_dltsccs="//android.view.View[contains(@content-desc,'alert has been deleted')]";
	public static String alrt_smstxt="//android.widget.EditText[@content-desc='SMS Text Number']";
	public static String alrt_edtbtn="//android.view.View[contains(@content-desc,'REMINDERS')]/android.widget.ListView[@index='0']/android.view.View[@index='0']//android.view.View[contains(@content-desc,'Edit')]";
	
//Settings section
	public static String settings_menu="//android.widget.TextView[@text='Settings']";
	public static String addrschange_ttl="//android.view.View[@content-desc='Address Change']";
	public static String addrschange_menu="//android.widget.TextView[@text='Address Change']";
	public static String homephone_txt="//android.widget.EditText[@content-desc='Home Phone']";
	public static String clrall_btn="//android.widget.Button[@content-desc='Clear All']";
	public static String chngaddrs_sccs="//android.view.View[@content-desc='Change of Address Successful']";
	public static String actvtycntr_ttl="//android.view.View[contains(@content-desc,'Activity Center')]";
	public static String addrschange_sccsmsg="//android.view.View[contains(@content-desc,'Your request was successful')]";
	public static String actvtycntr_addrschng="//android.widget.GridView[@index='7']/android.view.View[@index='0']/android.view.View[contains(@content-desc,'Change of Address')]";
	public static String actns_lnk="//android.view.View[@content-desc='Actions']";
	public static String cncl_lnk="//android.view.View[@content-desc='Cancel']";
	public static String inqr_lnk="//android.view.View[@content-desc='Inquire']";
	public static String snd_btn="//android.widget.Button[contains(@content-desc,'Send')]";
	public static String inqr_msg="//android.view.View[@content-desc='Your message was successfully sent.']";
	public static String cncl_wrngmsg="//android.view.View[@content-desc='Are you sure you want to cancel this transaction?']";
	public static String cncl_sccsmsg="//android.view.View[@content-desc='Transaction Cancelled']";
	
//Accounts 
	public static String acnt_lbl="//android.view.View[contains(@content-desc,'Accounts')]";
	
	public static String more_menu="//android.widget.Button[contains(@content-desc,'More')]";
	public static String trnsfrmoney_lnk="//android.view.View[contains(@content-desc,'Transfer Money Now')]";
	public static String fndtrnsfr_ttl="//android.view.View[contains(@content-desc,'Funds Transfer') and @index='1']";
	
// Loan 
	public static String mkpymnt_menu="//android.widget.TextView[@text='Make A Payment']";
	public static String loanpymnt_ttl="//android.view.View[contains(@content-desc,'LOAN PAYMENTS')]";
	public static String loanpymnt_msg="//android.view.View[contains(@content-desc,'Payments made after 10 PM Central')]";
	public static String loan_frmacnt="//android.widget.Spinner[@resource-id='fromAccount']";
	public static String loan_toacnt="//android.widget.Spinner[@resource-id='toAccount']";
	public static String loan_pymnttyp="//android.widget.Spinner[@resource-id='payment_type']";
	public static String loan_amnttxt="//android.widget.EditText[@resource-id='amountEdit']";
	public static String loan_date="//android.view.View[contains(@content-desc,'Date')]/parent::android.view.View/following-sibling::android.widget.Button";
	public static String loan_rccrngchk="//android.widget.CheckBox[contains(@content-desc,'Make this a recurring transaction')]";
	public static String loan_memotxt="//android.widget.EditText[@resource-id='description']";
	public static String loan_contbtn="//android.view.View[@content-desc='Continue']";
	public static String loan_errmsg="//android.view.View[contains(@content-desc,'required loan payment request information was not provided')]";
	public static String loan_clsbtn="//android.widget.Button[@content-desc='Close']";
	public static String loan_frqncy="//android.widget.Spinner[@resource-id='frequencySelect']";
	public static String loan_strtdate="//android.view.View[contains(@content-desc,'Start Date')]/parent::android.view.View/following-sibling::android.widget.Button";
	public static String loan_enddate="//android.view.View[contains(@content-desc,'End Date')]/parent::android.view.View/following-sibling::android.widget.Button";
	public static String loan_frvrchk="//android.widget.CheckBox[contains(@content-desc,'Forever')]";
	public static String loan_cnfrmbtn="//android.view.View[@resource-id='agreeButton']";
	public static String loan_cnclbtn="//android.view.View[@resource-id='disagreeButton']";
	public static String loan_cnfrmttl="//android.view.View[@content-desc='Please confirm the details of the transfer:']";
	public static String loan_actvtybtn="//android.widget.Button[@content-desc='View In Activity Center']";
	
//Transactions
	public static String actvtycntr_menu="//android.widget.TextView[contains(@text,'Activity Center')]";
	public static String fndtrnsfr_menu="//android.widget.TextView[contains(@text,'Funds Transfer')]";
	public static String fndtrnsfr_info="//android.view.View[contains(@content-desc,'Member to Member')]";
	public static String fndtrnsfr_frm="//android.widget.Button[contains(@content-desc,'From Account')]";
	public static String fndtrnsfr_to="//android.widget.Button[contains(@content-desc,'To Account')]";
	public static String fndtrnsfr_amnt="//android.view.View[contains(@content-desc,'Amount')]/following-sibling::android.widget.EditText[@index='4']";
	//public static String fndtrnsfr_amnt="//android.widget.EditText[@index='4']";
	public static String fndtrnsfr_dt="//android.widget.Button[contains(@content-desc,'Transfer Date')]";
	public static String amnt_txt="//android.view.View[@content-desc='Amount']/android.widget.EditText[@index='1']";
	public static String save_btn="//android.view.View[@content-desc='Save']";
	public static String clr_btn="//android.webkit.WebView[@content-desc='TDECU']/android.view.View[@index='17']/android.view.View[@content-desc='Clear']";
	public static String trnsfrfnds_btn="//android.widget.Button[@content-desc='Transfer Funds']";
	public static String vwactvty_btn="//android.widget.Button[@content-desc='View In Activity Center']";
	public static String recurring_chk="//android.view.View[@content-desc='Make this a recurring transaction']";
	public static String hwoften="//android.view.View[contains(@content-desc,'HOW OFTEN')]";
	public static String frqncy="//android.view.View[contains(@content-desc,'Frequency')]/parent::*/following-sibling::android.view.View/android.widget.Spinner";
	
	public static String weekly="//android.widget.CheckedTextView[contains(@text,'Weekly')]";
	public static String st_dt="//android.widget.Button[contains(@content-desc,'Start Date')]";
	public static String end_dt="//android.widget.Button[contains(@content-desc,'End Date')]";
	public static String insffcntfnd_msg="//android.view.View[@content-desc='You have insufficient funds to perform this transaction.']";;
	public static String close_btn="//android.view.View[@content-desc='Save']";
	public static String rptforever="//android.view.View[contains(@content-desc,'Repeat Forever')]";
	public static String enddt_back="//android.webkit.WebView[@content-desc='TDECU']/android.view.View[@index='6']/android.view.View[@content-desc='']";
	public static String actvty_btn="//android.view.View[@content-desc='Transfer activity']";
	public static String pending_tab="//android.view.View[@index='19']/android.widget.ListView[@index='0']/android.view.View[@content-desc='Pending']";
	public static String pending_trnsctn="//android.widget.ListView[@resource-id='transaction-list-pending']/android.view.View/android.widget.Button";
	public static String search_txtbox="//android.widget.EditText[@content-desc='Search transactions']";
	
	
	public static String single_tab="//android.view.View[contains(@content-desc,'Single') and @index='0']";
	public static String rcrrng_tab="//android.view.View[contains(@content-desc,'Recurring')]";
	public static String actvtycntr_infomsg="//android.view.View[contains(@content-desc,'View or search transactions')]";
	public static String actvtycntr_infomsgcls="//android.widget.Button[contains(@content-desc,'Close Tip')]";
	public static String actvtycntr_srchtxt="//android.widget.EditText[@content-desc='Search transactions']";
	public static String actvtycntr_frstrw="//android.widget.GridView/";
	public static String actvtycntr_srchbtn="//android.view.View[@index='6']/android.view.View[@content-desc='']";
	
	
//Help
	public static String help_menu="//android.widget.TextView[contains(@text,'Help')]";
	public static String hlpguide_menu="//android.widget.TextView[contains(@text,'Help Guide')]";
	public static String hlpvideo_menu="//android.view.View[contains(@content-desc,'Help Videos')]";
	public static String tdecuguide_ttl="//android.view.View[contains(@content-desc,'TDECU Online Banking eGuide')]";
	public static String tdecuguide_cls="//android.widget.ImageView[@NAF='true']";
	public static String tdecuvid_ttl="//android.view.View[contains(@content-desc,'RETAIL ONLINE BANKING')]";
	
//Member to Member transfer
	public static String mtm_menu="//android.view.View[contains(@content-desc,'Member to Member Transfer')]";
	public static String mtm_ttl="//android.view.View[contains(@content-desc,'MEMBER TO MEMBER TRANSFER')]";
	public static String mtm_info="//android.view.View[contains(@content-desc,'You can choose to make a single transfer')]";
	public static String sngltrnsfr_btn="//android.view.View[@content-desc='Single Transfer']";
	public static String lnkacnt_btn="//android.view.View[@content-desc='Link Account']";
	public static String mtm_toacnt="//android.widget.EditText[@resource-id='ToAccountNumber']";
	public static String mtm_acnttyp="//android.widget.Spinner[@resource-id='ToAccountType']";
	public static String mtm_lstthreechar="//android.widget.EditText[@resource-id='MemberLastName']";
	public static String mtm_sbmtbtn="//android.view.View[@content-desc='Submit']";
	public static String rstrctd_msg="//android.view.View[contains(@content-desc,'ToAccountNumber: input contained one or more restricted characters')]";
	public static String lnkacnt_errmsg="//android.view.View[contains(@content-desc,'Please verify the account information and try again')]";
	public static String lnkacnt_again="//android.view.View[contains(@content-desc,'account that you identified is already linked')]";
	public static String lnkacnt_sccs="//android.view.View[contains(@content-desc,'account was successfully linked')]";
	public static String mtm_insfnd="//android.view.View[contains(@content-desc,'An unexpected problem occurred')]";
	public static String mtm_clsbtn="//android.widget.Button[@content-desc='Close']";
	public static String mtm_donebtn="//android.widget.Button[@content-desc='Done']";
	
	public static String mtm_sngltrnsfrttl="//android.view.View[contains(@content-desc,'Complete the following fields to make a one-time transfer to another TDECU member')]";
	public static String mtm_frm="//android.widget.Spinner[@resource-id='fromAccountSelect']";
	public static String mtm_amnt="//android.widget.EditText[@resource-id='TransactionAmount']";
	public static String mtm_desc="//android.widget.EditText[@resource-id='Description']";
	
	
	

}
