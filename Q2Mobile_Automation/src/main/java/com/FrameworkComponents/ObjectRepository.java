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
	public static String rmbrme_chk="//android.widget.CheckBox[@content-desc='Remember me']";
	
	
//Menu items	
	public static String logoff_menu="//android.view.View[contains(@content-desc,'Log Off')]";
	public static String home_ttl="//android.view.View[@content-desc='Home']";
	public static String menu_btn="//android.view.View[@content-desc='Menu']";
	public static String service_menu="//android.view.View[contains(@content-desc,'Services')]";
	public static String trnsctn_menu="//android.view.View[contains(@content-desc,'Transactions')]";
	public static String crdtcrd_menu="//android.view.View[@content-desc='Credit Cards']";
	public static String acnt_sel="//android.view.View[contains(@content-desc,'Platinum')]";
	
	public static String loginvldtn_msg="//android.widget.content-descView[contains(@content-desc,'Authentication has failed. Please re-enter your login')]";
	public static String addcrd_ttl="//android.webkit.WebView[@content-desc='Add Card']";
	public static String cncl_btn="//*[contains(@content-desc,'Cancel')]";
	public static String yes_btn="//*[contains(@content-desc,'Yes')]";
	
	public static String info_msg="//android.view.View[contains(@content-desc,'Click an account to view the details')]";
	public static String info_msg_cls="//android.view.View[@content-desc='']";
	
	public static String wlcm_msg="//android.view.View[contains(@content-desc,'Welcome back')]";
	public static String invalid_msg="//android.view.View[contains(@content-desc,'Secure Access code you entered is invalid')]";

//Alerts section
	public static String alrt_menu="//android.view.View[@content-desc='Alerts']";
	public static String dtalrt_sctn="//android.view.View[contains(@content-desc,'Date Alerts')]";
	public static String acntalrt_sctn="//android.view.View[contains(@content-desc,'Account Alerts')]";
	public static String hstryalrt_sctn="//android.view.View[contains(@content-desc,'History Alerts')]";
	public static String onlntrnsctnalrt_sctn="//android.view.View[contains(@content-desc,'Online Transaction Alerts')]";
	public static String scrtyalrt_sctn="//android.view.View[contains(@content-desc,'Security Alerts')]";
	public static String alrttyp_dropdown="//android.widget.Spinner[contains(@content-desc,'New Alert')]";
	public static String acntalrt_ttl="//android.view.View[@content-desc='Account Alert']";
	public static String datealrt_ttl="//android.view.View[@content-desc='Date Alert']";
	public static String hstryalrt_ttl="//android.view.View[@content-desc='History Alert']";
	public static String onlntrnstcnalrt_ttl="//android.view.View[@content-desc='Online Transaction Alert']";
	public static String back_btn="//android.widget.Button[@content-desc='Back']";
	public static String alrt_noacnt="//android.view.View[contains(@content-desc,'No Account Selected')]";
	public static String alrt_notrnsctn="//android.view.View[contains(@content-desc,'No Transaction Selected')]";
	public static String alrt_nofld="//android.view.View[contains(@content-desc,'No Field Selected')]";
	public static String alrt_acnt="//android.view.View[contains(@content-desc,'ACCOUNT')]";
	public static String alrt_type="//android.view.View[contains(@content-desc,'TYPE')]";
	public static String alrt_date="//android.view.View[contains(@content-desc,'DATE')]";
	public static String alrt_fld="//android.view.View[contains(@content-desc,'FIELD')]";
	public static String alrt_trnsctn="//android.view.View[contains(@content-desc,'TRANSACTION')]";
	public static String alrt_cmprsn="//android.view.View[contains(@content-desc,'COMPARISON')]";
	public static String alrt_msg="//android.view.View[contains(@content-desc,'MESSAGE')]";
	public static String alrt_stts="//android.view.View[contains(@content-desc,'STATUS')]";
	public static String alrt_amnt="//android.view.View[contains(@content-desc,'AMOUNT')]";
	public static String alrt_dlvrymthd="//android.view.View[contains(@content-desc,'DELIVERY METHOD')]";
	public static String alrt_occrnc="//android.widget.CheckBox[contains(@content-desc,'Every Occurrence')]";
	public static String alrt_callimdt="//android.widget.CheckBox[@content-desc='Call Immediately']";
	public static String alrt_amntdlt="//android.view.View[contains(@content-desc,'Delete')]";
	public static String alrt_amntsv="//android.view.View[contains(@content-desc,'Save')]";
	public static String alrt_amntclr="//android.view.View[@content-desc='' and @index='2']";
	public static String alrt_dlvrymthd_ttl="//android.view.View[@content-desc='Select a delivery method']";
	public static String alrt_dlvrymthdtyp="//android.widget.Spinner[@index='0']";
	public static String alrt_acntback="//android.view.View[@content-desc='Back']";
	public static String alrt_msgtxt="//android.widget.EditText[@index='0']";
	public static String alrt_setbtn="//android.widget.Button[@content-desc='Set']";
	public static String alrt_donebtn="//android.view.View[@content-desc='Done']";
	public static String alrt_svbtn="//android.widget.Button[@content-desc='Save']";
	public static String alrt_dltbtn="//android.widget.Button[@content-desc='Delete']";
	public static String alrt_cnfrmbtn="//android.widget.Button[@content-desc='Confirm']";
	public static String alrt_svsccs="//android.view.View[@content-desc='Your alert has been saved.']";
	public static String msg_menu="//android.view.View[@content-desc='Messages']";
	public static String mtngrmndr="//android.view.View[@content-desc='Meeting Reminder']";
	public static String rply="//android.view.View[@content-desc='' and @index='0']";
	public static String rply_notallwd="//android.view.View[@content-desc='You cannot reply to this message.']";
	public static String alrt_phone="//android.widget.EditText[@content-desc='Phone Number']";
	public static String alrt_hour="//android.widget.Spinner[@content-desc='HH']";
	public static String alrt_min="//android.widget.Spinner[@content-desc='MM']";
	public static String alrt_ampm="//android.widget.Spinner[contains(@content-desc,'PM')]";
	public static String alrt_tnc="//android.widget.CheckBox[@content-desc='Agree To Terms']";
	public static String alrt_sndimdt="//android.widget.CheckBox[@content-desc='Send Immediately']";
	public static String alrt_off="//android.view.View[@content-desc='Off']";
	public static String alrt_on="//android.view.View[@content-desc='On']";
	public static String alrt_dltwrng="//android.view.View[contains(@content-desc,'Are you sure you want to delete this alert')]";
	public static String alrt_dltsccs="//android.view.View[contains(@content-desc,'alert has been deleted')]";
	
	
//Settings section
	public static String settings_menu="//android.view.View[@content-desc='Settings']";
	public static String addrschange_menu="//android.view.View[@content-desc='Address Change']";
	public static String homephone_txt="//android.widget.EditText[@content-desc='Home Phone']";
	public static String clrall_btn="//android.widget.Button[@content-desc='Clear All']";
	public static String chngaddrs_sccs="//android.view.View[@content-desc='Change of Address Successful']";
	public static String actvtycntr_ttl="//android.view.View[contains(@content-desc,'Activity Center')]";
	
//Accounts 
	public static String acnt_lbl="//android.view.View[contains(@content-desc,'Accounts')]";
	
	public static String more_menu="//android.view.View[contains(@content-desc,'More')]";
	public static String trnsfrmoney_lnk="//android.view.View[contains(@content-desc,'Transfer Money Now')]";
	public static String fndtrnsfr_ttl="//android.view.View[contains(@content-desc,'Funds Transfer') and @index='1']";
	
//Transactions
	public static String actvtycntr_menu="//android.view.View[contains(@content-desc,'Activity Center')]";
	public static String fndtrnsfr_menu="//android.view.View[contains(@content-desc,'Funds Transfer')]";
	public static String fndtrnsfr_info="//android.view.View[contains(@content-desc,'Member to Member')]";
	public static String fndtrnsfr_frm="//android.view.View[contains(@content-desc,'FROM*')]";
	public static String fndtrnsfr_to="//android.view.View[contains(@content-desc,'TO*')]";
	public static String fndtrnsfr_amnt="//android.view.View[contains(@content-desc,'AMOUNT*')]";
	public static String fndtrnsfr_dt="//android.view.View[contains(@content-desc,'DATE*')]";
	public static String amnt_txt="//android.widget.EditText[@index='1']";
	public static String save_btn="//android.view.View[@content-desc='Save']";
	public static String clr_btn="//android.webkit.WebView[@content-desc='TDECU']/android.view.View[@index='17']/android.view.View[@content-desc='Clear']";
	public static String trnsfrfnds_btn="//android.widget.Button[@content-desc='Transfer Funds']";
	public static String vwactvty_btn="//android.widget.Button[@content-desc='View In Activity Center']";
	public static String recurring_chk="//android.view.View[@content-desc='Make this a recurring transaction']";
	public static String hwoften="//android.view.View[contains(@content-desc,'HOW OFTEN')]";
	public static String weekly="//android.view.View[contains(@content-desc,'Weekly')]";
	public static String st_dt="//android.view.View[contains(@content-desc,'START DATE')]";
	public static String end_dt="//android.view.View[contains(@content-desc,'END DATE')]";
	public static String insffcntfnd_msg="//android.view.View[@content-desc='You have insufficient funds to perform this transaction.']";;
	public static String close_btn="//android.view.View[@content-desc='Save']";
	public static String rptforever="//android.view.View[contains(@content-desc,'Repeat Forever')]";
	public static String enddt_back="//android.webkit.WebView[@content-desc='TDECU']/android.view.View[@index='6']/android.view.View[@content-desc='']";
	public static String actvty_btn="//android.view.View[@content-desc='Activity']";
	public static String pending_tab="//android.view.View[@index='19']/android.widget.ListView[@index='0']/android.view.View[@content-desc='Pending']";
	public static String pending_trnsctn="//android.view.View[@index='20']";
	public static String search_txtbox="//android.webkit.WebView[@content-desc='TDECU']//android.widget.EditText[@index='18']";
	
	
	public static String single_tab="//android.view.View[contains(@content-desc,'Single') and @index='0']";
	public static String rcrrng_tab="//android.view.View[contains(@content-desc,'Recurring')]";
	public static String actvtycntr_infomsg="//android.view.View[contains(@content-desc,'View or search transactions')]";
	public static String actvtycntr_infomsgcls="//android.view.View[contains(@content-desc,'')]";
	public static String actvtycntr_srchtxt="//android.widget.EditText[@content-desc='Search transactions']";
	public static String actvtycntr_frstrw="//android.widget.GridView/";
	public static String actvtycntr_srchbtn="//android.view.View[@index='6']/android.view.View[@content-desc='']";
	
	
//Help
	public static String help_menu="//android.view.View[contains(@content-desc,'Help')]";
	public static String hlpguide_menu="//android.view.View[contains(@content-desc,'Help Guide')]";
	public static String hlpvideo_menu="//android.view.View[contains(@content-desc,'Help Videos')]";
	public static String tdecuguide_ttl="//android.view.View[contains(@content-desc,'TDECU Online Banking eGuide')]";
	public static String tdecuguide_cls="//android.widget.ImageView[@NAF='true']";
	public static String tdecuvid_ttl="//android.view.View[contains(@content-desc,'RETAIL ONLINE BANKING')]";
	
//Member to Member transfer
	public static String mtm_menu="//android.view.View[@content-desc='Member to Member Transfer']";
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
