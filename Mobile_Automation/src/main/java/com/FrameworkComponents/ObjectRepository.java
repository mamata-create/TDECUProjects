package com.FrameworkComponents;

public class ObjectRepository {
//login page
	public static String username_txt="//android.widget.EditText[@text='Username']";
	public static String password_txt="//android.widget.EditText[@text='Password']";
	public static String login_btn="//android.widget.Button[@text='Login']";
	public static String continue_btn="//android.widget.Button[@text='Continue']";
	public static String CONTINUE_btn="//android.widget.Button[@text='CONTINUE']";
	public static String validationErr="//android.widget.TextView[contains(@text,'Authentication has failed')]";
//dashbaord page	
	public static String myaccount_ttl="//android.widget.TextView[@text='My Accounts']";
	public static String menuitem_lnk="//android.widget.ImageView[@index='0']";
//menu items	
	public static String transfer_lnk="//android.widget.TextView[@text='Transfers']";
	public static String accounts_lnk="//android.widget.TextView[@text='Accounts']";
	public static String logout_lnk="//android.widget.TextView[contains(@text,'Log Out')]";
	
//transfer 	
	public static String maketransfer_lnk="//android.widget.TextView[@text='Make Transfer']";
	public static String transfertype_ttl="//android.widget.TextView[@text='Select Transfer Type']";
	public static String mytdecu_lnk="//android.widget.TextView[@text='My TDECU Accounts']";
	public static String othertdecu_lnk="//android.widget.TextView[@text='Other TDECU Member Accounts']";
	public static String frmaccount_ttl="//android.widget.TextView[@text='From']";
	public static String frmaccount="//android.widget.TextView[contains(@text,'57610')]";
	public static String toaccount_ttl="//android.widget.TextView[@text='To']";
	public static String toaccount="//android.widget.TextView[contains(@text,'37954')]";
	public static String trnsframnt_ttl="//android.widget.TextView[@text='Transfer Amount']";
	public static String trnsframnt_txt="//android.widget.ScrollView[@index='1']//android.view.ViewGroup[@index='1']//android.view.ViewGroup[@index='1']//android.view.ViewGroup[@index='1']//android.widget.TextView[@index='0']";
	
	public static String f_btn="//android.widget.Button[@text='2']";
	public static String t_btn="//android.widget.Button[@text='3']";
	
	public static String current_dt="//android.view.ViewGroup[@index='1']/android.view.ViewGroup[@index='0']/android.view.ViewGroup[@index='0']";
	
	public static String onetime_opt="//android.widget.TextView[@text='One Time']";
	public static String daily_opt="//android.support.v7.widget.RecyclerView[@index='0']/android.view.ViewGroup[@index='2']//android.widget.TextView[@text='Daily']";
	public static String weekly_opt="//android.support.v7.widget.RecyclerView[@index='0']/android.view.ViewGroup[@index='3']//android.widget.TextView[@text='Weekly']";
	public static String evrytwoweek_opt="//android.support.v7.widget.RecyclerView[@index='0']/android.view.ViewGroup[@index='4']//android.widget.TextView[@text='Every Two Weeks']";
	public static String monthly_opt="//android.support.v7.widget.RecyclerView[@index='0']/android.view.ViewGroup[@index='5']//android.widget.TextView[@text='Monthly']";
	public static String quarterly_opt="//android.support.v7.widget.RecyclerView[@index='0']/android.view.ViewGroup[@index='6']//android.widget.TextView[@text='Quarterly']";
	public static String evrysixmonth_opt="//android.support.v7.widget.RecyclerView[@index='0']/android.view.ViewGroup[@index='7']//android.widget.TextView[@text='Every Six Months']";
	public static String yearly_opt="//android.support.v7.widget.RecyclerView[@index='0']/android.view.ViewGroup[@index='8']//android.widget.TextView[@text='Yearly']";
	
	public static String dtrange_opt="//android.widget.TextView[contains(@text,'Date Range')]";
	public static String noOfRecurrences_opt="//android.widget.TextView[@text='Number of Recurrences']";
	public static String UntilYouCancel_opt="//android.widget.TextView[contains(@text,'Until You Cancel')]";
	public static String recurrences_ttl="//android.widget.TextView[@text='Enter number of Recurrences']";
	public static String nxtmonth="//android.widget.ScrollView[@resource-id='com.kone.tdecu:id/SCROLL_LAYOUT']/android.view.ViewGroup/android.view.ViewGroup[@index='1']/android.view.ViewGroup[@index='1']//android.view.ViewGroup[@index='2']/android.widget.ImageView";
	public static String descclr="//android.view.ViewGroup[@resource-id='com.kone.tdecu:id/flxDescription']//android.widget.ImageView[@resource-id='com.kone.tdecu:id/imgCross']";
	
	/*Sravya*/
	
	
	/*end*/
	public static String desc_txt="//android.widget.EditText[@resource-id='com.kone.tdecu:id/txtareaDescription']";
	public static String confirm_btn="//android.widget.Button[@text='Confirm']";
	public static String confirmtrnsfr_ttl="//android.widget.TextView[@text='Confirm Transfer']";
	public static String success_msg="//*[contains(@text,'Your transaction was successfully')]";
	public static String transactiondtls_ttl="//android.widget.TextView[@text='Transaction Details']";
	
	public static String rpttrnsctn_btn="//android.widget.Button[@text='Repeat Transaction']";
	public static String dspttrnsctn_btn="//android.widget.Button[@text='Dispute Transaction']";
	
	public static String dayswarning="//android.widget.TextView[contains(@text,'Please enter a date that is within 45 days')]";
	public static String snddtttl="//android.widget.TextView[@text='Send Date']";
	public static String mnth1="//android.widget.TextView[@resource-id='com.kone.tdecu:id/lblDayOne']";
	public static String mnth2="//android.widget.TextView[@resource-id='com.kone.tdecu:id/lblDayTwo']";
	
	public static String dt1="//android.widget.TextView[@resource-id='com.kone.tdecu:id/lblMonthOne']";
	public static String dt2="//android.widget.TextView[@resource-id='com.kone.tdecu:id/lblMonthTwo']";
	
	public static String yr1="//android.widget.TextView[@resource-id='com.kone.tdecu:id/lblYearOne']";
	public static String yr2="//android.widget.TextView[@resource-id='com.kone.tdecu:id/lblYearTwo']";
	public static String yr3="//android.widget.TextView[@resource-id='com.kone.tdecu:id/lblYearThree']";
	public static String yr4="//android.widget.TextView[@resource-id='com.kone.tdecu:id/lblYearFour']";
	public static String backarrw="//android.widget.ImageView[@resource-id='com.kone.tdecu:id/imgBack']";
	
	
	
	
	//Funding Account
	public static String makeloanpaymnt_lnk="//android.widget.TextView[@text='Make a Loan Payment']";
	public static String addedtacnt_lnk="//android.widget.TextView[@text='Add/Edit Accounts']";
	public static String addfndgacnt_btn="//android.widget.Button[@text='Add Funding Accounts']";
	public static String addfndgacnt_ttl="//android.widget.TextView[@text='Add Funding Account']";
	public static String bnkacnt_opt="//android.widget.TextView[@text='Add External Bank Account']";
	public static String dbtcrd_opt="//android.widget.TextView[@text='Add Debit Card']";
	public static String dbtcrdnmbr_ttl="//android.widget.TextView[@text='Debit Card Number']";
	public static String nameoncard_ttl="//android.widget.TextView[@text='Name on the Card']";
	public static String nameoncard_txt="//android.widget.EditText[@index='2']";
	public static String acntnickname_ttl="//android.widget.TextView[@text='Account Nickname']";
	public static String acntnickname_txt="//android.widget.EditText[@index='2']";
	public static String expdate_ttl="//android.widget.TextView[@text='Expiration Date']";
	public static String cvv_ttl="//android.widget.TextView[@text='Security Value']";
	public static String acntdtls_ttl="//android.widget.TextView[@text='Account Details']";	
	public static String state_arrw="//android.widget.LinearLayout[@index='0']/android.widget.ImageView[@index='1']";
	public static String zip_txt="//android.view.ViewGroup[@index='3']";
	
	public static String cnfmdtls_ttl="//android.widget.TextView[@text='Confirm Debit Card Details']";
	public static String cnfmacntdtls_ttl="//android.widget.TextView[@text='Confirm Account Details']";
	public static String nickname_ttl="//android.widget.ScrollView[@index='1']/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.TextView[@index='1']";
	public static String info_btn="//android.widget.Button[@index='2']";
	public static String edt_btn="//android.widget.Button[@text='Edit']";
	public static String addnickname_txt="//android.widget.EditText[@index='0']";
	public static String save_btn="//android.widget.Button[@text='Save']";
	public static String nicknamCharWarning="//android.widget.TextView[@text='Must contain only alphanumeric characters']";
	
	public static String delete_btn="//android.widget.Button[@text='Delete']";
	public static String yes_btn="//android.widget.Button[@text='YES']";
	
	public static String acnttype_ttl="//android.widget.TextView[@text='Add Account Type']";
	public static String acntnmbr_ttl="//android.widget.TextView[@text='Account Number']";
	public static String rtngnmbr_ttl="//android.widget.TextView[@text='Routing Number']";
	public static String acntholdername_ttl="//android.widget.TextView[@text='Routing Number']";
	public static String acntholdername_txt="//android.widget.EditText[@index='2']";
//e-Documents
	public static String edoc_lnk="//android.widget.TextView[@text='e-Documents']";
	public static String enble_btn="//android.widget.Button[@text='Enable']";
	public static String tnc_ttl="//android.widget.TextView[@text='Terms and Conditions']";
	public static String accpt_btn="//android.widget.Button[@text='Accept']";
	public static String sttmnts_lnk="//android.widget.TextView[@text='Statements']";
	
//e-Documents Disable
	public static String enable_lnk="//android.widget.TextView[@text='Enable e-Documents']";
	public static String clck_lnk="//android.widget.ImageView[@text='']";
	public static String disable_btn="//android.widget.Button[@text='Disable']";
	public static String settings_lnk="//android.widget.TextView[@text='Settings']";
	
//Benficiary
	public static String addacnt_btn="//android.widget.Button[@text='ADD ACCOUNT']";
	public static String rcpnt_ttl="//android.widget.TextView[@text='Enter the recipient account number']";
	public static String rcpntnmbr_txt="//android.widget.TextView[@index='0']";
	public static String rcpnt_err="//android.widget.TextView[@text='This field only allows TDECU member account numbers. Please try again.']";
	
//Messages
	public static String msg_lnk="//android.widget.TextView[@text='Messages']";
	
	public static String addmsg_icn="//android.widget.ScrollView[@index='1']/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[@index='1']/android.widget.ImageView";
	public static String ctgry_ttl="//android.widget.TextView[@text='Pick the category']";
	public static String msgsbjct_txt="//android.widget.EditText[@index='1']";
	public static String msgdesc_txt="//android.widget.EditText[@index='3']";
	public static String msginbx_ttl="//android.widget.TextView[@text='Inbox']";
	public static String msgsrch_txt="//android.widget.EditText[@index='0']";
	public static String msgdlt_icn="//android.widget.ScrollView[@index='1']/android.view.ViewGroup/android.view.ViewGroup[@index='1']//android.widget.ImageView[@index='0']";
	public static String dltmsg_wrng="//android.widget.TextView[@text='Are you sure you want to delete this message?']";
	public static String msgdlt_tab="//android.widget.TextView[@text='Deleted']";
	
	public static String back_arrw="//android.view.ViewGroup[@index='0']/android.widget.ImageView[@index='0']";
	
}
