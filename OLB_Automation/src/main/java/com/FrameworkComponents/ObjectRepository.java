package com.FrameworkComponents;

public class ObjectRepository {

	//login page
	public static String username_txt="//input[@id='frmLogin_main_tbxUserName']";
	public static String password_txt="//input[@id='frmLogin_main_tbxPassword']";
	public static String login_btn="//input[@id='frmLogin_main_btnLogin']";
	public static String logout_lnk="//input[@id='frmAccountsLanding_postLoginHdr_btnLogOut']";
	public static String acnt_dshbrd="//div[@id='frmAccountsLanding_accountList_lblAccountsHeader']";
	public static String login_logout="//input[@id='frmAccountsLanding_postLoginHdr_btnLogOut']";
	public static String username_disabled="//div[@id='frmLogin_main_lblUsernameLabel']";
	public static String password_disabled="//div[@id='frmLogin_main_lblPasswordLabel']";
	public static String password_masked="//input[@id='frmLogin_main_tbxPassword']";
	public static String password_show="//div[@id='frmLogin_main_flxShow']";
	public static String loginerror="//label[@class='lblsknError']";
	
	

//transfer page	
	public static String transferPay="//div[@id='frmAccountsLanding_postLoginHdr_lblTransferAndPay']";
	public static String transferMoney="//div[@id='frmAccountsLanding_postLoginHdr_flxTransferMoney']";
	public static String makeloanpayment="//div[@id='frmAccountsLanding_postLoginHdr_lblLoanPayment']";
	public static String loanscreentitle="//div[@id='frmLoanRemittance_loansmain_lblTransactions']";
	public static String transferscreentitle="//div[contains(text(),'Select a Transfer Type')]";
	public static String continuebtn_MyTDECU="//input[@id='frmTransfers_transfermain_btnToMyKonyBankProceed']";
	public static String continuebtn_OtherTDECU="//input[@id='frmTransfers_transfermain_btnToOtherKonyBankProceed']";
	public static String configuretransfertitle="//div[@id='frmTransfers_transfermain_maketransfer_lblTransferFrom']";
	public static String scheduleddropdownarw="//div[@class='kwt100  flxHoverSkinPointer']//div[@id='flxExternalAccountsTransfersUnselected_lblDropDown' and contains(text(),'0')]";
	
	public static String fromacntdroparw="//span[@id='frmTransfers_transfermain_maketransfer_imgDropdown_span']";
	public static String frmsearchtxt="//input[@id='frmTransfers_transfermain_maketransfer_tbxCustomerName']";
	public static String frmsearchImg="//img[@id='frmTransfers_transfermain_maketransfer_imgSearch']";
	public static String frmsearched="//li[@index='1']//div[@id='flxAccountNicknameAvlBalList_lblAccountNickName']";
	public static String frmclearImg="//img[@id='frmTransfers_transfermain_maketransfer_imgclear']";
	public static String toacntdroparw="//span[@id='frmTransfers_transfermain_maketransfer_imgDropdownTo_span']";
	public static String tosearchtxt="//input[@id='frmTransfers_transfermain_maketransfer_tbxRecipientName']";
	public static String tosearchImg="//img[@id='frmTransfers_transfermain_maketransfer_imgSearchRecipient']";
	public static String tosearched="//div[@id='frmTransfers_transfermain_maketransfer_segRecipientName']//li[@index='1']//div[@id='flxAccountNicknameAvlBalList_lblAccountNickName']";
	public static String toclearImg="//img[@id='frmTransfers_transfermain_maketransfer_imgCrossRecipient']";
	public static String accrualaccount="//div[@id='flxAccountListItem_lblAccountNumber' and contains(text(), 'Account Number: x94601')]";
	public static String dormantaccount="//div[@id='flxAccountListItem_lblAccountName']";
	public static String routingnumber="//div[@id='frmAccountsDetails_accountInfo_lblRoutingNumberValue']";
	public static String accountmenuitem="//div[@id='frmAccountsDetails_postLoginHdr_flxaccounts']";
	public static String viewAccInfolink="//input[@id='frmAccountsDetails_btnViewAccountInfo']";
	public static String cncltrnsctnmsg="//div[text()='Are you sure you want to cancel this transaction?']";
	public static String cnfrmyesbtn="//input[@id='frmConfirm_CustomPopup_btnYes']";
	public static String cnfrmnobtn="//input[@id='frmConfirm_CustomPopup_btnNo']";
	public static String cnfrmcnclbtn="//input[@id='frmConfirm_confirmDialog_confirmButtons_btnCancel']";
	public static String sendoncal="//div[@kwidgetid='frmTransfers_transfermain_maketransfer_calSendOn']/img[@id='calSendOn_img']";
	
	public static String viewAccInfolink1="//input[@aria-label='View Account Information ']";
	public static String checkAccountStatus="//div[@id='frmAccountsDetails_accountInfo_lblSwiftCodeValue']";
	public static String cardnmbr="//div[@id='frmAccountsDetails_accountInfo_lblCardNoValue']";
	public static String checkEncAccoutnNumber="//div[@id='frmAccountsDetails_accountInfo_lblAccountNumberValue']";
	public static String acntnmbr_show="//div[@id='frmAccountsDetails_accountInfo_flxAccountNumber']//input[@id='frmAccountsDetails_accountInfo_btnShowAN']";
	public static String rtngnmbr_show="//div[@id='frmAccountsDetails_accountInfo_flxRoutingNumber']//input[@id='frmAccountsDetails_accountInfo_btnShowRN']";
	public static String frequencydrop="//select[@id='frmTransfers_transfermain_maketransfer_lbxFrequency']";
	public static String howlongdrop="//select[@id='frmTransfers_transfermain_maketransfer_lbxForHowLong']";
	public static String sendOnCal="//input[@id='calSendOn']";
	public static String endOnCal="//input[@id='calEndingOn']";
	public static String noOfRecurrences="//input[@id='frmTransfers_transfermain_maketransfer_tbxNoOfRecurrences']";
	public static String skipNextTransferLink="//input[@id='flxExternalAccountsTransfersSelected_btnEdit']";
	public static String popUpNo="//input[@id='frmTransfers_deletePopup_btnNo']";
	public static String popUpYes="//input[@id='frmTransfers_deletePopup_btnYes']";
	public static String makeanothertrnsfrbtn="//input[@id='frmAcknowledgement_activity_btnMakeTransfer']";
	
	
	public static String amount_txt="//input[@id='frmTransfers_transfermain_maketransfer_tbxAmount']";
	public static String notes_txt="//input[@id='frmTransfers_transfermain_maketransfer_txtNotes']";
	public static String maketransfer_btn="//input[@id='frmTransfers_transfermain_maketransfer_btnConfirm']";
	public static String confirm_header="//div[@id='frmConfirm_confirmDialog_confirmHeaders_lblHeading']";
	public static String confirm_frmAcnt="//div[@id='frmConfirm_confirmDialog_keyValueFrom_lblValue']";
	public static String confirm_toAcnt="//div[@id='frmConfirm_confirmDialog_keyValueTo_lblValue']";
	public static String confirm_amnt="//div[@id='frmConfirm_confirmDialog_keyValueThree_lblValue']";
	public static String confirm_noOfRecurrences="//div[@id='frmConfirm_confirmDialog_keyValueNote_lblValue']";
	public static String confirm_btn="//input[@id='frmConfirm_confirmDialog_confirmButtons_btnConfirm']";
	public static String success_msg="//div[@id='frmAcknowledgement_acknowledgment_lblTransactionMessage']";
	public static String refNumberLabel="//div[@id='frmAcknowledgement_acknowledgmentModify_lblRefrenceNumberValue']";
	public static String schdl_sccessmsg="//div[@id='frmAcknowledgement_acknowledgmentModify_lblTransactionMessage']";
	public static String modify_btn="//input[@id='frmConfirm_confirmDialog_confirmButtons_btnModify']";
	
	public static String refNum="//div[@id='frmAcknowledgement_acknowledgment_lblRefrenceNumberValue']";
	public static String trnsfrActvty="//input[@id='frmAcknowledgement_activity_btnAddAnotherAccount']";
	public static String postedtb_selcted="//div[contains(@class,'EncodeSansSelected')]/input[contains(@aria-label,'Posted')]";
	public static String schdltb_selcted="//div[contains(@class,'EncodeSansSelected')]/input[contains(@aria-label,'Scheduled')]";
	public static String successfulSkipMsg="//div[contains(text(),'You have successfully skipped the next scheduled transaction']";
	
	public static String noaccountmsg="//div[@id='frmTransfers_NoAccounts_txtMessage']";
	public static String scheduledtab="//input[@id='frmTransfers_transfermain_btnScheduled']";
	public static String postedtab="//input[@id='frmTransfers_transfermain_btnRecent']";
	public static String frmaccntwarning="//div[@id='frmTransfers_transfermain_maketransfer_lblWarning']";
	public static String cncltrnsfr="//input[@id='frmTransfers_transfermain_maketransfer_btnModify']";
	public static String cnclNo="//input[@id='frmTransfers_CustomPopup_btnNo']";
	public static String cnclYes="//input[@id='frmTransfers_CustomPopup_btnYes']";
	public static String cnclmsg="//div[text()='Are you sure you want to Cancel?']";
	public static String mdfytrnsctnlnk="//input[@id='flxExternalAccountsTransfersSelected_btnViewActivity']";
	public static String cnclsrslnk="//input[@id='flxExternalAccountsTransfersSelected_btnEdit']";
	
	
//edoc 	
	public static String edoctab="//div[@id='frmAccountsLanding_postLoginHdr_lblEdoc']";
	public static String enableedocmsg="//div[@id='frmEDocuments_lblEnableEDocs']";
	public static String enablebtn="//input[@id='frmEDocuments_btnEnable']";
	public static String cancelbtn="//input[@id='frmEDocuments_btnCancel']";
	public static String settingsimg="//div[@id='frmAccountsLanding_postLoginHdr_flxUserId']";
	public static String accntsettinglnk="//div[@id='flxAccountTypes_lblUsers' and text()='Account Settings']";
	public static String proflsettinglnk="//div[@id='flxAccountTypes_lblUsers' and text()='Profile Settings']";
	public static String profltitle="//*[@id='frmProfileManagement_settings_lblHeading']";
	public static String edoclnk="//div[@id='frmProfileManagement_settings_lblEDocuments']";
	public static String edocpagettl="//div[@id='frmEDocuments_lblHeading']";
	public static String edocTnc="//img[@id='frmEDocuments_imgCheck']";
	public static String savebtn="//input[@id='frmProfileManagement_settings_btnEditAccountsSave']";
	public static String savebtnEDoc="//input[@title='Save']";
	public static String enablesuccess="//div[@id='frmEDocuments_lblConfirmation']";
	public static String viewdocbtn="//input[@id='frmEDocuments_btnEdocView']";
	public static String enableedocchk="//img[@id='frmProfileManagement_settings_imgEnableEDocs']";
	public static String disablepopupttl="//div[text()='Disable e-Documents']";
	public static String yesbtn="//input[@id='frmProfileManagement_btnYes']";
	public static String nobtn="//input[@title='No']";
	public static String disableack="//div[@id='frmProfileManagement_lblConfirmation']";
	
	//Add beneficiary
	public static String addBenfLink="//input[@id='frmTransfers_btnAddExternalAccGateway']";
	public static String benfAcntNumber="//input[@id='frmAddInternalAccount_internalAccount_tbxAccountNumberKA']";
	public static String benfAcntNumberAgain="//input[@id='frmAddInternalAccount_internalAccount_tbxAccountNumberAgainKA']";
	public static String frstthreeChar="//input[@id='frmAddInternalAccount_internalAccount_tbxBeneficiaryNameKA']";
	public static String benfnickname="//input[@id='frmAddInternalAccount_internalAccount_tbxAccountNickNameKA']";
	public static String continuebtn="//input[@id='frmAddInternalAccount_internalAccount_btnAddAccountKA']";
	public static String nextbtn="//input[@id='frmConfirmAccount_confirmDialogAccounts_confirmButtons_btnConfirm']";
	public static String benfsuccess="//div[@id='frmAcknowledgement_acknowledgment_lblTransactionMessage']";
	public static String editlnk="//input[@id='flxAccountRow_btnEdit']";
	public static String clrNickname="//img[@id='frmProfileManagement_settings_imgClearNickName']";
	public static String nicknametxt="//input[@id='frmProfileManagement_settings_tbxAccountNickNameValue']";
	
	public static String acnttab="//div[@title='Accounts']";
	public static String acntlnk="//input[@title='Accounts']";
	public static String nicksuccess="//div[@id='frmProfileManagement_settings_lblTransactionMessage']";
	public static String rcpntdel_btn="//input[@id='flxExternalAccountsTransfersM2MSelected_btnDelete']";
//message	
	public static String menuImg="//span[@id='frmAccountsLanding_postLoginHdr_imgMenu_span']/img[@id='frmAccountsLanding_postLoginHdr_imgMenu']";
	public static String msgCollapse="//img[@id='frmAccountsLanding_postLoginHdr_customhamburger_imgAlertsAndMessagesCollapse']";
	public static String newMsgLnk="//div[@id='frmAccountsLanding_postLoginHdr_customhamburger_lblNewMessage']";
	public static String msgCat="//select[@id='frmNotificationsAndMessages_NotficationsAndMessages_listbxCategory']";
	public static String msgSbjct="//input[@id='frmNotificationsAndMessages_NotficationsAndMessages_tbxSubject']";
	public static String msgDesc="//textarea[@id='frmNotificationsAndMessages_NotficationsAndMessages_textareaDescription']";
	public static String msgSend="//input[@id='frmNotificationsAndMessages_NotficationsAndMessages_btnNewMessageSend']";
	public static String accntCollapse="//img[@id='frmAccountsLanding_postLoginHdr_customhamburger_imgCollapseAccounts']";
	public static String myMsgLbl="//input[@id='frmNotificationsAndMessages_NotficationsAndMessages_btnMyMessages']";
	public static String myMsgLnk="//div[@aria-label='My Messages ']";
	public static String searchtxt="//input[@id='frmNotificationsAndMessages_NotficationsAndMessages_txtSearch']";
	public static String searchImg="//img[@id='frmNotificationsAndMessages_NotficationsAndMessages_imgMsgsSearch']";
	public static String msg="//div[@id='flxNotificationsAndMessages_lblSegHeading']";
	public static String dltbtn="//input[@id='frmNotificationsAndMessages_NotficationsAndMessages_btnDelete']";
	public static String yesMsgPop="//input[@id='frmNotificationsAndMessages_CustomPopup1_btnYes']";
	
	//add funding account
	public static String addfndngacnt="//input[@id='frmLoanRemittance_btnAddFundingAccount']";
	public static String fndngacnttitle="//div[contains(text(),'Add Funding Account')]";
	public static String bnkacntopt="//div[@id='frmLoanRemittance_OneTimePaymentstepOne_lblBankAccount']";
	public static String debitcardopt="//div[@id='frmLoanRemittance_OneTimePaymentstepOne_lblDebitCard']";
	public static String bnkacntradiobtn="//img[@id='frmLoanRemittance_OneTimePaymentstepOne_imgBankAccount']";
	public static String debitcardradiobtn="//img[@id='frmLoanRemittance_OneTimePaymentstepOne_imgDebitCard']";
//bank account - add funding account	
	public static String acnttype="//select[@id='frmLoanRemittance_OneTimePaymentstepOne_lstAccountType']";
	public static String routingnmbr="//input[@id='frmLoanRemittance_OneTimePaymentstepOne_txtRoutingNumber']";
	public static String acntnmbr="//input[@id='frmLoanRemittance_OneTimePaymentstepOne_txtAccountNumber1']";
	public static String acntholder="//input[@id='frmLoanRemittance_OneTimePaymentstepOne_txtAccountNumber2']";
	public static String acntnickname="//input[@id='frmLoanRemittance_OneTimePaymentstepOne_txtAccountNickname']";
	public static String state="//select[@id='frmLoanRemittance_OneTimePaymentstepOne_lstState']";
	public static String zipcode="//input[@id='frmLoanRemittance_OneTimePaymentstepOne_txtZIPcode']";
	public static String loancontinuebtn="//input[@id='frmLoanRemittance_OneTimePaymentstepOne_btnContinue']";
	public static String loanconfirmbtn="//input[@id='frmLoanRemittance_LoanConfirmation_btnConfirm']";
	public static String addfundacntmsg="//div[@id='frmLoanRemittance_Acknowledegement1_lblSuccessMsg']";
	public static String vwfundacnt="//input[@id='frmLoanRemittance_Acknowledgement2_btnConfirm']";
	public static String fndacnt="//div[@id='flxfundingAccountRowTemp_lblAccountNoVal']";
	public static String mngfndacnt="//input[@id='frmLoanRemittance_btnManageFundingAccount']";
	public static String loanYes="//input[@id='frmLoanRemittance_btnYes']";
	
//debit card - add funding account
	public static String debitcardnmbr="//input[@id='frmLoanRemittance_OneTimePaymentstepOne_txtDebitCardNumber']";
	public static String nameoncard="//input[@id='frmLoanRemittance_OneTimePaymentstepOne_txtName']";
	public static String month="//select[@id='frmLoanRemittance_OneTimePaymentstepOne_lstMonth']";
	public static String year="//select[@id='frmLoanRemittance_OneTimePaymentstepOne_lstYear']";
	public static String cvv="//input[@id='frmLoanRemittance_OneTimePaymentstepOne_txtCVV']";
	public static String debitcardstate="//select[@id='frmLoanRemittance_OneTimePaymentstepOne_lstStateDC']";
	public static String debitcardzip="//input[@id='frmLoanRemittance_OneTimePaymentstepOne_txtZIPcodeDC']";
	public static String debitacntnickname="//input[@id='frmLoanRemittance_OneTimePaymentstepOne_txtAccountNicknameDC']";
	
	public static String pymntactvtytab="//input[@id='frmLoanRemittance_loansmain_btnRecent']";
	public static String trnsctndtcol="//div[contains(@aria-label,'Transaction Date')]";
	public static String acntnamecol="//div[@id='frmLoanRemittance_loansmain_flxSortAccountName']//div[contains(@aria-label,'Account Name')]";
	public static String amntcol="//div[@id='frmLoanRemittance_loansmain_flxSortAmountPayment']//div[contains(@aria-label,'Amount')]";
	public static String sttscol="//div[@id='frmLoanRemittance_loansmain_flxSortStatus']//div[contains(@aria-label,'Status')]";
	public static String rwexpand="//div[@id='flxPaymentActivityUnselected_lblDropDown']";
	public static String payername="//div[@id='flxPaymentActivitySelected_flxAccountNumberTitle']//div[contains(text(),'Payer Name')]";
	public static String fndngtyp="//div[@id='flxPaymentActivitySelected_flxAccountTypeTitle']//div[contains(text(),'Funding Type')]";
	public static String cnfrmnmbr="//div[@id='flxPaymentActivitySelected_flxAddedOnTitle']//div[contains(text(),'Confirmation Number')]";
	
	
	public static String rcrngpymnttab="//input[@id='frmLoanRemittance_loansmain_btnScheduled']";
	public static String frmacntttl="//div[@id='flxPaymentActivitySelected_lblAccountNumberTitle']";
	public static String trnsfrfrqncytypttl="//div[@id='flxPaymentActivitySelected_lblAccountTypeTitle']";
	public static String frqncytypttl="//div[@id='flxPaymentActivitySelected_lblAddedOnTitle']";
	public static String nxtschdlpymntttl="//div[@id='flxPaymentActivitySelected_lblKeyRow3col1']";
	public static String edtpymnt="//input[@id='flxPaymentActivitySelected_btnViewActivity']";
	public static String cnclpymnt="//input[@id='flxPaymentActivitySelected_btnEdit']";
	
	public static String crossimg="//span[@id='frmTransfers_transfermain_maketransfer_imgCross_span']/img[@id='frmTransfers_transfermain_maketransfer_imgCross']";
	
	
	
//locate us
	public static String locateuslnk="//input[@id='frmAccountsLanding_postloginftr_btnLocateUS']";
	public static String locateusttl="//div[@id='frmLocateATM_lblLocUs']";
	public static String currentloc="//img[contains(@src,'current_location')]";
	public static String locfiltertxt="//input[@id='frmLocateATM_textFieldFilter']";
	public static String locsearchimg="//img[@id='frmLocateATM_searchimage']";
	public static String locsearched="//div[@id='flexDetails_lblMain']";
	public static String locclrimg="//img[@id='frmLocateATM_imgClearTxt']";
	
//TRansaction Search
	public static String advncsrch="//input[@id='frmAccountsDetails_transactions_btnViewActivity']";
	public static String kywrdsrch="//input[@id='frmAccountsDetails_transactions_txtKeyword']";
	public static String srchbtn="//input[@id='frmAccountsDetails_transactions_btnSearch']";
	public static String dscrptnrow="//div[@id='flxSegTransactionRowSavings_lblDescription']";
	public static String clrsrchbtn="//input[@id='frmAccountsDetails_transactions_btnClearSearch']";
	public static String mdfysrchbtn="//input[@id='frmAccountsDetails_transactions_btnModifySearch']";
	public static String kywrdsrchcriteria="//div[@id='frmAccountsDetails_transactions_lblKeywordValue']";
	
//Transaction Detail
	public static String trnsctnamnt="//div[@id='flxExternalAccountsTransfersSelected_lblRoutingNumberValue']";
	public static String trnsctnfrqncy="//div[@id='flxExternalAccountsTransfersSelected_lblAddedOnValue']";
	public static String trnsctntyp="//div[@id='flxExternalAccountsTransfersSelected_lblValue9']";
	public static String trnsctnnotes="//div[@id='flxExternalAccountsTransfersSelected_lblValue8']";
	public static String trnsctnref="//div[@id='flxExternalAccountsTransfersSelected_lblValue7']";
	public static String schdltrnsctnamnt="//div[@id='flxExternalAccountsTransfersSelected_lblBankAddressValue']";
	public static String trnsctnsrcacnt="//div[@id='flxExternalAccountsTransfersSelected_lblAccountNumberValue']";
	public static String trnsctntrgtacnt="//div[@id='flxExternalAccountsTransfersSelected_lblAccountTypeValue']";
	public static String acntsbold="//div[@id='frmAccountsLanding_postLoginHdr_flxaccounts']/div[contains(@class,'sknlbltxthdrbold')]";
	
	
	
}
