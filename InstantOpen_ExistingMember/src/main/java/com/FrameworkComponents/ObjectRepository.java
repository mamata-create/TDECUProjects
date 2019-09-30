package com.FrameworkComponents;

public class ObjectRepository {
	
	//Home Page
	public static String app_ttl="//h1[contains(text(),'Account, Credit Card and Loan Application')]";
	//public static String nonmmbrstrt_btn="//input[@id='btnNonMember']";
	public static String mmbrstrt_btn="//input[@id='btnMember']";

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
	
	//Credit Cards
	public static String creditCardExpand = "//h4[contains(text(),'Credit Cards')]/i";
	public static String cardCheckBox = "//div[contains(@id,'CreditCard')]//div[contains(@class,'icheckbox')]";
	public static String classicCheckBox = "//div[contains(@id,'Panel_1009')]//div[@class='icheckbox_square-grey']";
	public static String classicCheckedBox = "//div[contains(@id,'Panel_1009')]//div[contains(@class,'checked')]";
	public static String classicTitle="//label[contains(text(),'Classic MasterCard')]";
	public static String classicDesc1 = "(//div[contains(@id,'MoreInfo_1009')]//ul[@class='fa-ul cardDescr']/li)[1]";
	public static String classicFoot2 = "//*[@id='CreditCard_pnlProductMoreInfo_1009_1']/span/ul/li[1]/sup";
	public static String classicDesc2 = "(//div[contains(@id,'MoreInfo_1009')]//ul[@class='fa-ul cardDescr']/li)[2]";
	public static String classicDesc3 = "(//div[contains(@id,'MoreInfo_1009')]//ul[@class='fa-ul cardDescr']/li)[3]";
	public static String classicDesc4 = "(//div[contains(@id,'MoreInfo_1009')]//ul[@class='fa-ul cardDescr']/li)[4]";
	public static String classicFoot3 = "//*[@id='CreditCard_pnlProductMoreInfo_1009_1']/span/ul/li[4]/sup";
	public static String buceesCheckBox = "//div[contains(@id,'Panel_1257')]//div[@class='icheckbox_square-grey']";
	public static String buceesCheckedBox = "//div[contains(@id,'Panel_1257')]//div[contains(@class,'checked')]";
	public static String buceesTitle="//label[contains(text(),'Buc')]";
	public static String buceesDesc1 = "(//div[contains(@id,'MoreInfo_1257')]//ul[@class='fa-ul cardDescr']/li)[1]";
	public static String buceesFoot2 = "//*[@id='CreditCard_pnlProductMoreInfo_1257_1']/span/ul/li[1]/sup";
	public static String buceesDesc2 = "(//div[contains(@id,'MoreInfo_1257')]//ul[@class='fa-ul cardDescr']/li)[2]";
	public static String buceesDesc3 = "(//div[contains(@id,'MoreInfo_1257')]//ul[@class='fa-ul cardDescr']/li)[3]";
	public static String buceesDesc4 = "(//div[contains(@id,'MoreInfo_1257')]//ul[@class='fa-ul cardDescr']/li)[4]";
	public static String bucceesFoot3 = "//*[@id='CreditCard_pnlProductMoreInfo_1257_1']/span/ul/li[4]/sup";
	public static String platinumCheckBox = "//div[contains(@id,'Panel_1259')]//div[@class='icheckbox_square-grey']";
	public static String platinumCheckedBox = "//div[contains(@id,'Panel_1259')]//div[contains(@class,'checked')]";
	public static String platinumTitle="//label[contains(text(),'Platinum')]";
	public static String platinumDesc1 = "(//div[contains(@id,'MoreInfo_1259')]//ul[@class='fa-ul cardDescr']/li)[1]";
	public static String platinumFoot2 = "//*[@id='CreditCard_pnlProductMoreInfo_1259_1']/span/ul/li[1]/sup";
	public static String platinumDesc2 = "(//div[contains(@id,'MoreInfo_1259')]//ul[@class='fa-ul cardDescr']/li)[2]";
	public static String platinumDesc3 = "(//div[contains(@id,'MoreInfo_1259')]//ul[@class='fa-ul cardDescr']/li)[3]";
	public static String platinumDesc4 = "(//div[contains(@id,'MoreInfo_1259')]//ul[@class='fa-ul cardDescr']/li)[4]";
	public static String platinumFoot3 = "//*[@id='CreditCard_pnlProductMoreInfo_1259_1']/span/ul/li[4]/sup";
	public static String OnyxCheckBox = "//div[contains(@id,'Panel_1258')]//div[@class='icheckbox_square-grey']";
	public static String OnyxCheckedBox = "//div[contains(@id,'Panel_1258')]//div[contains(@class,'checked')]";
	public static String OnyxTitle="//label[contains(text(),'Onyx')]";
	public static String OnyxDesc1 = "(//div[contains(@id,'MoreInfo_1258')]//ul[@class='fa-ul cardDescr']/li)[1]";
	public static String OnyxFoot2 = "//*[@id='CreditCard_pnlProductMoreInfo_1258_1']/span/ul/li[1]/sup";
	public static String OnyxDesc2 = "(//div[contains(@id,'MoreInfo_1258')]//ul[@class='fa-ul cardDescr']/li)[2]";
	public static String OnyxDesc3 = "(//div[contains(@id,'MoreInfo_1258')]//ul[@class='fa-ul cardDescr']/li)[3]";
	public static String OnyxDesc4 = "(//div[contains(@id,'MoreInfo_1258')]//ul[@class='fa-ul cardDescr']/li)[4]";
	public static String OnyxFoot3 = "//*[@id='CreditCard_pnlProductMoreInfo_1258_1']/span/ul/li[4]/sup";
	public static String OnyxDesc5 = "(//div[contains(@id,'MoreInfo_1258')]//ul[@class='fa-ul cardDescr']/li)[5]";
	//Credit Card Info page
	public static String crdtcrdinf_ttl="//strong[text()='Credit Card Info']";
	public static String ccInfoContent = "(//span[@id='CollateralHandler01']/div)[1]";
	public static String cardTypeLabel = "//label[@for='ProductDropDownList_DropDownList']";
	public static String cardLimitLabel = "//label[@for='tbLoanAmount_MoneyTextBox']";
	//Product Info fields
	public static String prodInfoBackButton = "//input[@id='btnBack_SubmitButton']";
	public static String prodInfoNextButton = "//input[@id='btnEdit']";
	public static String prodTypeDropdown = "//select[@name='ProductDropDownList_DropDownList']";
	public static String prodLimitTextbox = "//input[@id='tbLoanAmount_MoneyTextBox']";
	
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
	public static String carPurchPrice = "//input[@id='tbPurchasePrice_MoneyTextBox']";
	
	//Personal Loans
	public static String personalLoanExpand = "//h4[contains(text(),'Personal')]/i";
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
	//Personal Loan Info
	public static String psnlLoanInfTtl="//strong[text()='Personal Loan Info']";
	
	//Certificate of Deposits
	public static String cdExpand = "//h4[contains(text(),'Deposit')]/i";
	public static String cdDescOne = "//*[@id='collapseFive']/div/ul/li[1]";
	public static String cdDescTwo = "//*[@id='collapseFive']/div/ul/li[2]";
	public static String cdSearchTitle = "//*[@id='collapseFive']/div/div[2]/h4";
	public static String cdSearchInfo = "//*[@id='collapseFive']/div/div[2]/p";
	public static String enterAmountTxtField = "//label[contains(text(),'Enter an Amount')]/following::input[1]";
	public static String selectTermDropdown = "//label[contains(text(),'Select a term (in months)')]/following::select";
	public static String showAllCheckBox = "//*[@id='CDWizard']/div[1]/div";
	public static String showAllLabel = "//label[contains(text(),'Show All')]";
	public static String visibleCD3 = "//div[contains(@id,'ProductPanel_775')and contains(@style, 'block')]";
	public static String visibleCD6 = "//div[contains(@id,'ProductPanel_781')and contains(@style, 'block')]";
	public static String visibleCD12= "//div[contains(@id,'ProductPanel_723')and contains(@style, 'block')]";
	public static String visibleCD24= "//div[contains(@id,'ProductPanel_767')and contains(@style, 'block')]";
	public static String visibleCD36= "//div[contains(@id,'ProductPanel_772')and contains(@style, 'block')]";
	public static String visibleCD48= "//div[contains(@id,'ProductPanel_777')and contains(@style, 'block')]";
	public static String visibleCD60= "//div[contains(@id,'ProductPanel_779')and contains(@style, 'block')]";
	public static String termCheckBox= "//div[conta]ins(@style,'display: block')]//div[contains(@class,'icheckbox')]//following::label[1]";
	
	//Checking & Money Market Accounts
	public static String checkingExpand = "//h4[contains(text(),'Checking')]/i";
	public static String classicCheckTitle = "//label[@for='Checking_ProductCheckbox_2633_1']";
	public static String classicCheckCheckBox = "(//div[@id='Checking_ProductPanel_2633_1']//div[@class='icheckbox_square-grey'])[1]";
	public static String ccChecked = "(//div[@id='Checking_ProductPanel_2633_1']//div[contains(@class,'checked')])[1]";
	public static String classicCheckDesc1 = "//div[contains(@id,'MoreInfo_2633_1')]//ul[@class='fa-ul']/li[1]";
	public static String classicCheckDesc2 = "//div[contains(@id,'MoreInfo_2633_1')]//ul[@class='fa-ul']/li[2]";
	public static String ccDebitCardChecked= "//div[@id='Checking_Panel26335205_1']//div[contains(@class,'checked')]";
	public static String ccDebitCardCheckBox= "//div[@id='Checking_Panel26335205_1']//div[@class='icheckbox_square-grey']";
	public static String ccOverdraftChecked= "//div[@id='Checking_Panel26335427_1']//div[contains(@class,'checked')]";
	public static String ccOverdraftCheckBox= "//div[@id='Checking_Panel26335427_1']//div[@class='icheckbox_square-grey']";
	public static String ccOverdraftQstion= "//div[contains(@id,'MoreInfo_26335427')]//button";
	public static String ccCourtesyPayCheckBox= "//div[@id='Checking_Panel26335206_1']//div[@class='icheckbox_square-grey']";
	public static String ccCourtesyPayChecked= "//div[@id='Checking_Panel26335206_1']//div[contains(@class,'checked')]";
	public static String ccCourtesyPayQstion= "//div[contains(@id,'MoreInfo_26335206')]//button";
	public static String mnyMrktTitle = "//label[@for='Checking_ProductCheckbox_716_1']";
	public static String mnyMrktCheckBox = "//div[@id='Checking_ProductPanel_716_1']//div[@class='icheckbox_square-grey']";
	public static String mnyMrktChecked = "//div[@id='Checking_ProductPanel_716_1']//div[contains(@class,'checked')]";
	public static String mnyMrktDesc1 = "//div[contains(@id,'MoreInfo_716_1')]//ul[@class='fa-ul']/li[1]";
	public static String mnyMrktDesc2 = "//div[contains(@id,'MoreInfo_716_1')]//ul[@class='fa-ul']/li[2]";
	public static String mnyMrktDesc3 = "//div[contains(@id,'MoreInfo_716_1')]//ul[@class='fa-ul']/li[3]";
	public static String highYieldTitle = "//label[@for='Checking_ProductCheckbox_6223_1']";
	public static String highYieldCheckBox = "(//div[@id='Checking_ProductPanel_6223_1']//div[@class='icheckbox_square-grey'])[1]";
	public static String highYieldChecked = "(//div[@id='Checking_ProductPanel_6223_1']//div[contains(@class,'checked')])[1]";
	public static String hyDebitCardChecked= "//div[@id='Checking_Panel62235205_1']//div[contains(@class,'checked')]";
	public static String hyDebitCardCheckBox= "//div[@id='Checking_Panel62235205_1']//div[@class='icheckbox_square-grey']";
	public static String hyOverdraftChecked= "//div[@id='Checking_Panel62235427_1']//div[contains(@class,'checked')]";
	public static String hyOverdraftCheckBox= "//div[@id='Checking_Panel62235427_1']//div[@class='icheckbox_square-grey']";
	public static String hyOverdraftQstion= "//div[contains(@id,'MoreInfo_62235427')]//button";
	public static String hyCourtesyPayCheckBox= "//div[@id='Checking_Panel62235206_1']//div[@class='icheckbox_square-grey']";
	public static String hyCourtesyPayChecked= "//div[@id='Checking_Panel62235206_1']//div[contains(@class,'checked')]";
	public static String hyCourtesyPayQstion= "//div[contains(@id,'MoreInfo_62235206')]//button";
	public static String overdraftTitle= "//h4[@id='modalOverdraftMemberLabel']";
	public static String overdraftDesc= "//*[@id='modalOverdraftMember']/div/div/div[2]";
	public static String overdraftClose= "//*[@id='modalOverdraftMember']/div/div/div[3]/button";
	public static String courtesyPayTitle= "//h4[@id='modalCourtesyMemberLabel']";
	public static String courtesyPayDesc= "//*[@id='modalCourtesyMember']/div/div/div[2]";
	public static String courtesyPayClose= "//*[@id='modalCourtesyMember']/div/div/div[3]/button";
	
	//Savings Account
	public static String savingsExpand = "//h4[contains(text(),'Savings')]/i";
	public static String clubTitle = "//label[@for='RequiredSavings_ProductCheckbox_715_1']";
	public static String clubCheckBox = "//div[@id='RequiredSavings_ProductPanel_715_1']//div[@class='icheckbox_square-grey']";
	public static String clubChecked = "//div[@id='RequiredSavings_ProductPanel_715_1']//div[contains(@class,'checked')]";
	public static String clubDesc = "//div[contains(@id,'MoreInfo_715_1')]//ul[@class='fa-ul']/li";
	
	//Additional Services			
	public static String addtionalExpand = "//h4[contains(text(),'Additional')]/i";
	public static String eDocsChecked = "//span[@class='ServiceTitle']//div[contains(@class,'checked')]";
	public static String eDocsCheckBox = "//span[@class='ServiceTitle']//div[@class='icheckbox_square-grey']";
	public static String eDocsTitle = "//label[@for='Services_GeneralService5208']";
	public static String eDocsQstion = "//div[contains(@id,'MoreInfoPnl5208')]//button";
	public static String eDocsInfoTtl = "//h4[@id='modalEdocumentsLabel']";
	public static String eDocsInfo = "//*[@id='modalEdocuments']/div/div/div[2]/p";
	public static String eDocsClose = "//*[@id='modalEdocuments']/div/div/div[3]/button";
	
	//Checking and Money Market Account Titles
	public static String titleOne = "(//*[@id='collapseTwo']/div//label[contains(@for,'ProductCheckbox')])[1]";
	public static String titleTwo = "(//*[@id='collapseTwo']/div//label[contains(@for,'ProductCheckbox')])[2]";
	public static String titleThree = "(//*[@id='collapseTwo']/div//label[contains(@for,'ProductCheckbox')])[3]";
	
	//Member Verification
	public static String mmbrVerifyTile = "//strong[text()='Member Verification']";
	public static String mmbrVerifyNext = "//span[@id='NextButton']";
	public static String mmbrVerifyBack = "//span[@id='BackButton']";
	public static String mmbrVerifyNum="//input[@id='tbEMAMMemberNumber_TextBox']";
	public static String mmbrVerifySSN="//input[@id='tbEMAMSSNTextBox_TextBox']";
	public static String mmbrVerifyDOB="//input[@id='tbBirthDate_RadDatePicker']";
	
	//Your Information
	public static String yourInfoTile = "//strong[text()='Your Information']";
	public static String idType="//select[@id='IDType_IDType']";
	public static String idNum="//input[@id='IDType_IDNumber']";
	public static String issueDate="//input[@id='IDType_IssueDate']";
	public static String expDate="//input[@id='IDType_ExpirationDate']";
	public static String housePymt="//input[@id='HousePayment_MoneyTextBox']";
	public static String addrYears="//input[@id='AddresstDuration_YearTextBox']";
	public static String addrMonths="//input[@id='AddresstDuration_MonthTextBox']";
	public static String currentEmp="//input[@id='CurrentEmployer_TextBox']";
	public static String monIncome="//input[@id='MonthlySalary_MoneyTextBox']";
	public static String empYears="//input[@id='EmploymentDuration_YearTextBox']";
	public static String empMonths="//input[@id='EmploymentDuration_MonthTextBox']";
	
	//Confirm Accounts
	public static String prodOne = "(//span[@id='ProductsAndServices']//li[1])[1]";
	public static String prodTwo = "//span[@id='ProductsAndServices']//li[2]";
	public static String prodWOptionsTwo = "(//span[@id='ProductsAndServices']//li[2])[2]";
	public static String confirmBtn="//input[@id='btnNext_SubmitButton']";
	public static String changeBtn="//input[@id='btnChange_SubmitButton']";
	
	//Agreements and Disclosures
	public static String termsAndCondCheckBox = "//span[@id='cbDisclosures']//div[@class='icheckbox_square-grey']";
	public static String agreeAndSignCheckBox = "//span[@id='Authroization']//div[@class='icheckbox_square-grey']";
	
	//ID Verification
	public static String questionOne = "(//span[@id='IDAuthenticationQuestions']//table//tr[4])[1]";
	public static String questionTwo = "(//span[@id='IDAuthenticationQuestions']//table//tr[5])[1]";
	public static String questionThree = "(//span[@id='IDAuthenticationQuestions']//table//tr[5])[2]";
	public static String questionFour = "(//span[@id='IDAuthenticationQuestions']//table//tr[5])[3]";
	
	//Account Funding
	public static String acctFundTile = "//strong[text()='Account Funding']";
	public static String submitBtn="//input[@id='NextButton2_SubmitButton']";
	public static String errorMsg1 ="//span[@id='ErrorSummary1']//li[1]";
	public static String errorMsg2 ="//span[@id='ErrorSummary1']//li[2]";

	//Don't use below elements for IO Existing Member*******************************************************************
	//New Member fields
	public static String nochkacnt_rdbtn="//*[@id='rbNoChecking']/label/strong";
	public static String othrprdctno_rdbtn="//*[@id='rbOtherProdNo']/label";
	
	public static String fname_txt="//input[@id='tbFirstName_TextBox']";
	public static String mname_txt="//input[@id='tbMiddleName_TextBox']";
	public static String lname_txt="//input[@id='tbLastName_TextBox']";
	public static String namesfx_txt="//input[@id='tbNameSuffix_TextBox']";
	public static String strtaddrs_txt="//input[@id='AddressTextBox_AddressLine1']";
	public static String zip_txt="//input[@id='AddressTextBox_AddressCityStateZip']";
	
	public static String ssn_txt="//input[@id='SSNTextBox_TextBox']";
	public static String dob_cal="//input[@id='tbBirthDate_RadDatePicker']";
	
	public static String hrabttdecu_drop="//select[@id='HowDidYouHear_DropDownList']";
	public static String mothername_txt="//input[@id='MothersMaidenName_TextBox']";
	public static String crrntemplyr_txt="//input[@id='CurrentEmployer2_TextBox']";
	public static String occptn_txt="//input[@id='Occupation_TextBox']";
	
	public static String phonenmbr_txt="//input[@id='tbPhone1_RadMaskedTextBox']";
	public static String phonetyp_drop="//select[@id='tbPhone1_ddPhoneNumberType']";
	public static String primaryemail_txt="//input[@id='tbEmail1_RadTextBox']";
	
	//
	public static String mstrcrdtcard_exp="//h4[@class='panel-title CursorPointer' and contains(text(),'MasterCard Credit Card')]";
	public static String chkingmoneymrkt_exp="//h4[@class='panel-title CursorPointer' and contains(text(),'Checking & Money Market Accounts')]";
	public static String clscchking_opt="//label[contains(text(),'Classic Checking')]";
	public static String dbtcrd_opt="//label[contains(text(),'Debit Card')]";
	public static String ovrdrftprtctn_opt="//label[contains(text(),'Overdraft Protection Plan')]";
	public static String svngacnt_exp="//h4[@class='panel-title CursorPointer' and contains(text(),'Savings Account')]";
	public static String club_opt="//label[contains(text(),'Club')]";
	
	public static String crdtlimit_txt="//input[@id='tbLoanAmount_MoneyTextBox']";
	public static String edt_btn="//input[@id='btnEdit']";
	
	public static String crrnttdecu_opt="//*[@id='rbFamily']/div";
	//"//input[@id='rbFamily_RadioButton']";
	public static String cnfrmacnt_ttl="//strong[text()='Confirm Account Selections']";
	public static String tnc_chkbx="//span[@id='cbDisclosures']/div[@class='icheckbox_square-grey']";
	
	//Agreement and Signature
	public static String idnty_ttl="//h3[text()='Identity Verification']";
	
	//Backup withholding Certifications	
	public static String taxpayerIdentificationNumber ="(//*[contains(text(),'Backup Withholding Certifications')]/following::div[@class='icheckbox_square-grey'])[1]";
	public static String backupWithholding = "(//*[contains(text(),'Backup Withholding Certifications')]/following::div[@class='icheckbox_square-grey'])[2]";
	
	//US citizenship
	public static String citizenshipCheckbox ="(//*[contains(text(),'U.S. Citizens')]/following::div[@class='icheckbox_square-grey'])[1]";
	
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
	
	public static String rtngnmbr_txt="//input[@id='ACHFundingAccountVerification_tbRoutingNumber_NumericTextBox']";
	public static String acntnmbr_txt="//input[@id='ACHFundingAccountVerification_tbAccountNumber_TextBox']";
	public static String vrfyacnt_btn="//button[@id='DeferredInputSubmit']";
	
	public static String thnku_ttl="//h1[text()='Thank You for Your Application!']";
	
	public static String sbmtupload_btn="//input[@id='DocumentList02_rbdocuments']";
	
	
	
	//Applicant Information
	public static String aplcntinfo_ttl="//div[@class='SectionHeaders' and contains(text(),'Applicant Information')]";
	
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