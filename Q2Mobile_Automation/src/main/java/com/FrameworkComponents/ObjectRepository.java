package com.FrameworkComponents;

public class ObjectRepository {
//login page
	public static String username_txt="//*[@resource-id='com.texasdowcreditunion5004.mobile.preproduction:id/username']";
	public static String password_txt="//*[@resource-id='com.texasdowcreditunion5004.mobile.preproduction:id/password']";
	public static String login_btn="//*[@resource-id='com.texasdowcreditunion5004.mobile.preproduction:id/btn_sign_in']";
	public static String emailotp_btn="//android.view.View[contains(@text,'mail')]";
	public static String otp_txt="//android.widget.EditText[@index='0']";
	public static String submit_btn="//android.widget.Button[@text='Submit']";
	public static String rgstrdvc_btn="//android.view.View[@text='Register Device']";
	public static String dontrgstrdvc_btn="//android.view.View[@text='Do Not Register Device']";
	public static String lctns_lnk="//android.view.View[@text='Locations']";
	public static String rmbrme_chk="//android.widget.CheckBox[@text='Remember me']";
	
	
//Menu items	
	public static String logoff_menu="//android.webkit.WebView[@text='TDECU']//android.view.View[contains(@text,'Log Off') and @index='8']";
	public static String home_ttl="//android.view.View[@text='Home']";
	public static String menu_btn="//android.view.View[@text='Menu']";
	public static String service_menu="//android.webkit.WebView[@text='TDECU']//android.view.View[@text='Services' and @index='0']";
	public static String trnsctn_menu="//android.webkit.WebView[@text='TDECU']/android.view.View[@index='0']/android.view.View[@index='1']/android.view.View[@index='0']/android.view.View[@index='0']/android.view.View[@index='2']//android.view.View[@text='Transactions']";
	public static String crdtcrd_menu="//android.view.View[@text='Credit Cards']";
	public static String acnt_sel="//android.view.View[contains(@text,'Platinum')]";
	
	public static String loginvldtn_msg="//android.widget.TextView[contains(@text,'Authentication has failed. Please re-enter your login')]";
	public static String addcrd_ttl="//android.webkit.WebView[@text='Add Card']";
	public static String cncl_btn="//*[@text='Cancel']";
	public static String yes_btn="//*[@text='Yes']";
	
	public static String info_msg="//android.view.View[contains(@text,'Click an account to view the details')]";
	public static String info_msg_cls="//android.view.View[@text='']";
	
	public static String wlcm_msg="//android.view.View[contains(@text,'Welcome back')]";
	public static String invalid_msg="//android.view.View[contains(@text,'Secure Access code you entered is invalid')]";

//Alerts section
	public static String alrt_menu="//android.view.View[@text='Alerts']";
	public static String dtalrt_sctn="//android.view.View[contains(@text,'Date Alerts')]";
	public static String acntalrt_sctn="//android.view.View[contains(@text,'Account Alerts')]";
	public static String hstryalrt_sctn="//android.view.View[contains(@text,'History Alerts')]";
	public static String onlntrnsctnalrt_sctn="//android.view.View[contains(@text,'Online Transaction Alerts')]";
	public static String scrtyalrt_sctn="//android.view.View[contains(@text,'Security Alerts')]";
	public static String alrttyp_dropdown="//android.widget.Spinner[contains(@text,'New Alert')]";
	
	
	
//Accounts 
	public static String acnt_lbl="//android.view.View[contains(@text,'Accounts')]";
	
	public static String more_menu="//android.view.View[contains(@text,'More')]";
	public static String trnsfrmoney_lnk="//android.view.View[contains(@text,'Transfer Money Now')]";
	public static String fndtrnsfr_ttl="//android.view.View[contains(@text,'Funds Transfer') and @index='1']";
	
//Transactions
	public static String actvtycntr_menu="//android.view.View[contains(@text,'Activity Center') and @index='0']";
	public static String single_tab="//android.view.View[contains(@text,'Single') and @index='0']";
	public static String rcrrng_tab="//android.view.View[contains(@text,'Recurring') and @index='0']";
	public static String actvtycntr_infomsg="//android.view.View[contains(@text,'View or search transactions') and @index='0']";
	public static String actvtycntr_infomsgcls="//android.view.View[contains(@text,'') and @index='1']";
	
//Help
	public static String hlpguide_menu="//android.view.View[contains(@text,'Help Guide')]";
	public static String hlpvideo_menu="//android.view.View[contains(@text,'Help Videos')]";
	public static String tdecuguide_ttl="//android.view.View[contains(@text,'TDECU Online Banking eGuide')]";
	public static String tdecuguide_cls="//android.widget.ImageView[@NAF='true']";
	public static String tdecuvid_ttl="//android.view.View[contains(@text,'RETAIL ONLINE BANKING')]";

}
