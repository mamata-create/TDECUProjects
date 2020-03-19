package com.FrameworkComponents;

public class ObjectRepository {
	
	//Home Page
	public static String app_ttl="//h1[contains(text(),'Account, Credit Card and Loan Application')]";
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
	
	//Product Info fields
	public static String prodInfoBackButton = "//input[@id='btnBack_SubmitButton']";
	public static String prodInfoNextButton = "//input[@id='btnEdit']";
	public static String prodInfoMsg= "//span[@id='CollateralHandler01']/div";
	public static String prodTypeLabel = "//label[@for='ProductDropDownList_DropDownList']";
	public static String prodTypeDropdown = "//select[@name='ProductDropDownList_DropDownList']";
	public static String prodLimitLabel = "//label[@for='tbLoanAmount_MoneyTextBox']";
	public static String prodLimitTextbox = "//input[@id='tbLoanAmount_MoneyTextBox']";
	public static String prodLimIncorrect= "//input[contains(@style,'border-color: rgb(255, 0, 0)')and contains(@style,'background-color: rgb(255, 255, 224)')]";
	public static String prodLimCorrect= "//input[contains(@style,'border-color: rgb(211, 211, 211)')and contains(@style,'background-color: rgb(255, 255, 255)')]";
	public static String prodLimPopup= "//div[@class='popover fade bottom in']";
	
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
	public static String stormTitle = "//label[@for='PersonalLoan_ProductCheckbox_6449_1']";
	public static String stormCheckBox= "//div[@id='PersonalLoan_ProductPanel_6449_1']//div[@class='icheckbox_square-grey']";
	public static String stormCheckedBox = "//div[@id='PersonalLoan_ProductPanel_6449_1']//div[contains(@class,'checked')]";
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
	public static String visibleCD12= "//div[contains(@id,'ProductPanel_761')and contains(@style, 'block')]";
	public static String visibleCD24= "//div[contains(@id,'ProductPanel_767')and contains(@style, 'block')]";
	public static String visibleCD36= "//div[contains(@id,'ProductPanel_772')and contains(@style, 'block')]";
	public static String visibleCD48= "//div[contains(@id,'ProductPanel_777')and contains(@style, 'block')]";
	public static String visibleCD60= "//div[contains(@id,'ProductPanel_779')and contains(@style, 'block')]";
	public static String visibleCD18= "//div[contains(@id,'ProductPanel_764')and contains(@style, 'block')]";
	public static String visibleCD13= "//div[contains(@id,'ProductPanel_2999')and contains(@style, 'block')]";
	public static String visibleCD27= "//div[contains(@id,'ProductPanel_2458')and contains(@style, 'block')]";
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
	public static String ccMobileChecked= "//div[@id='Checking_Panel26336120_1']//div[contains(@class,'checked')]";
	public static String ccMobileCheckBox= "//div[@id='Checking_Panel26336120_1']//div[@class='icheckbox_square-grey']";
	public static String ccMobileQstion= "//div[contains(@id,'MoreInfo_26336120')]//button";
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
	public static String mnyMrktDesc4 = "//div[contains(@id,'MoreInfo_716_1')]//ul[@class='fa-ul']/li[4]";
	public static String highYieldTitle = "//label[@for='Checking_ProductCheckbox_6223_1']";
	public static String highYieldCheckBox = "(//div[@id='Checking_ProductPanel_6223_1']//div[@class='icheckbox_square-grey'])[1]";
	public static String highYieldChecked = "(//div[@id='Checking_ProductPanel_6223_1']//div[contains(@class,'checked')])[1]";
	public static String hyDebitCardChecked= "//div[@id='Checking_Panel62235205_1']//div[contains(@class,'checked')]";
	public static String hyDebitCardCheckBox= "//div[@id='Checking_Panel62235205_1']//div[@class='icheckbox_square-grey']";
	public static String hyMobileChecked= "//div[@id='Checking_Panel62236120_1']//div[contains(@class,'checked')]";
	public static String hyMobileCheckBox= "//div[@id='Checking_Panel62236120_1']//div[@class='icheckbox_square-grey']";
	public static String hyMobileQstion= "//div[contains(@id,'MoreInfo_62236120')]//button";
	public static String hyOverdraftChecked= "//div[@id='Checking_Panel62235427_1']//div[contains(@class,'checked')]";
	public static String hyOverdraftCheckBox= "//div[@id='Checking_Panel62235427_1']//div[@class='icheckbox_square-grey']";
	public static String hyOverdraftQstion= "//div[contains(@id,'MoreInfo_62235427')]//button";
	public static String hyCourtesyPayCheckBox= "//div[@id='Checking_Panel62235206_1']//div[@class='icheckbox_square-grey']";
	public static String hyCourtesyPayChecked= "//div[@id='Checking_Panel62235206_1']//div[contains(@class,'checked')]";
	public static String hyCourtesyPayQstion= "//div[contains(@id,'MoreInfo_62235206')]//button";
	public static String mobileTitle= "//h4[@id='modalDeposit2Label']";
	public static String mobileDesc= "//*[@id='modalDeposit2']/div/div/div[2]";
	public static String mobileClose= "//*[@id='modalDeposit2']/div/div/div[3]/button";
	public static String overdraftTitle= "//h4[@id='modalOverdraftMemberLabel']";
	public static String overdraftDesc= "//*[@id='modalOverdraftMember']/div/div/div[2]";
	public static String overdraftClose= "//*[@id='modalOverdraftMember']/div/div/div[3]/button";
	public static String courtesyPayTitle= "//h4[@id='modalCourtesyMemberLabel']";
	public static String courtesyPayDesc= "//*[@id='modalCourtesyMember']/div/div/div[2]";
	public static String courtesyPayClose= "//*[@id='modalCourtesyMember']/div/div/div[3]/button";
	//Checking Options Order
	public static String checkingOpt1 = "(//span[@class='ProductServiceTitle'])[1]";
	public static String checkingOpt2 = "(//span[@class='ProductServiceTitle'])[2]";
	public static String checkingOpt3 = "(//span[@class='ProductServiceTitle'])[3]";
	public static String checkingOpt4 = "(//span[@class='ProductServiceTitle'])[4]";
	public static String checkingOpt5 = "(//span[@class='ProductServiceTitle'])[5]";
	public static String checkingOpt6 = "(//span[@class='ProductServiceTitle'])[6]";
	public static String checkingOpt7 = "(//span[@class='ProductServiceTitle'])[7]";
	public static String checkingOpt8 = "(//span[@class='ProductServiceTitle'])[8]";
	
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
	public static String mmbrNumLabel= "//label[text()='*Member Number:']";
	public static String mmbrVerifyNum="//input[@id='tbEMAMMemberNumber_TextBox']";
	public static String mmbrNumRO="//input[@id='tbEMAMMemberNumber_TextBox' and @disabled='disabled']";
	public static String mmbrSSNlabel= "//label[text()='*Social Security Number:']";
	public static String mmbrVerifySSN="//input[@id='tbEMAMSSNTextBox_TextBox']";
	public static String mmbrSSNRO="//input[@id='tbEMAMSSNTextBox_TextBox'and @disabled='disabled']";
	public static String mmbrDOBlabel= "//label[text()='*Date of Birth:']";
	public static String mmbrVerifyDOB="//input[@id='tbBirthDate_RadDatePicker']";
	public static String mmbrDOBRO="//input[@id='tbBirthDate_RadDatePicker'and @disabled='disabled']";
	
	//Your Information
	public static String yourInfoTtl = "//strong[text()='Your Information']";
	public static String applicantHdr= " (//div[@class='SectionHeaders'])[1]";
	public static String identityHdr= " (//div[@class='SectionHeaders'])[2]";
	public static String loanHdr= " (//div[@class='SectionHeaders'])[3]";
	//Applicant Information
	public static String fnameLabel= "//label[text()='*First Name:']";
	public static String fname= "//input[@id='tbFirstName_TextBox'and @disabled='disabled']";
	public static String mnameLabel= "//label[text()='Middle Name:']";
	public static String mname= "//input[@id='tbMiddleName_TextBox'and @disabled='disabled']";
	public static String lnameLabel= "//label[text()='*Last Name:']";
	public static String lname= "//input[@id='tbLastName_TextBox'and @disabled='disabled']";
	public static String nameSffxLabel= "//label[text()='Name Suffix:']";
	public static String nameSuffix= "//input[@id='tbNameSuffix_TextBox'and @disabled='disabled']";
	public static String stAddrLabel= "//label[text()='*Street Address:']";
	public static String stAddr= "//input[contains(@id,'AddressLine1')and @disabled='disabled']";
	public static String cityLabel= "//label[text()='*City, State, ZIP']";
	public static String cityStZip= "//input[contains(@id,'CityStateZip')and @disabled='disabled']";
	public static String commLabel= "//label[text()='Preferred Method of Communication:']";
	public static String commDdown= "//select[contains(@id,'ContactMethod')]";
	//Identification Information
	public static String idType="//select[@id='IDType_IDType']";
	public static String errorIdType = "//select[contains(@name,'IDType')and contains(@style,'LightYellow')]";
	public static String IdTypeAsterisk= "//span[@id='ctl40' and @style='color:Red;']";
	public static String stateLabel= "//label[@for='IDType_StateComboBox']";
	public static String stateDropdown= "//select[@id='IDType_StateComboBox']";
	public static String errorState = "//select[contains(@name,'State')and contains(@style,'LightYellow')]";
	public static String stateAsterisk= "//span[@id='ctl42' and @style='color:Red;']";
	public static String countryLbl= "//label[@for='IDType_CountryComboBox']";
	public static String countryDdown= "//select[@id='IDType_CountryComboBox']";
	public static String errorCountry = "//select[contains(@name,'Country')and contains(@style,'LightYellow')]";
	public static String countryAsterisk= "//span[@id='ctl44' and @style='color:Red;']";
	public static String idNum="//input[@id='IDType_IDNumber']";
	public static String errorIdNum = "//input[contains(@name,'IDNumber')and contains(@style,'LightYellow')]";
	public static String idNumAsterisk= "//span[@id='ctl46' and @style='color:Red;']";
	public static String issueDate="//input[@id='IDType_IssueDate']";
	public static String errorIssDt = "//input[contains(@name,'IssueDate')and contains(@style,'LightYellow')]";
	public static String issDtAsterisk= "//span[@id='ctl48' and @style='color:Red;']";
	public static String expDate="//input[@id='IDType_ExpirationDate']";
	public static String errorExpDt = "//input[contains(@name,'Expiration')and contains(@style,'LightYellow')]";
	public static String expDtAsterisk= "//span[@id='ctl50' and @style='color:Red;']";
	//Loan Information
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
	//Bottom of page
	public static String jtOwnerCheckBox= "//span[@id='cbAddJoint']/div";
	public static String jtOwnerLbl= "//label[@for='cbAddJoint_CheckBox']";
	public static String addBeneCheckBox= "//span[@id='cbAddBene']/div";
	public static String addBeneLbl= "//label[@for='cbAddBene_CheckBox']";
	public static String add_an_existing_member_link = "//span[@id='pnlExistingMember']//a";
	
	//Additional Owners
	public static String addOwnerTtl = "//strong[text()='Additional Account Owners']";
	public static String addBeneTtl = "//strong[text()='Your Beneficiary Information']";
	public static String addFname= "//input[@id='tbFirstName_TextBox']";
	public static String addMname = "//input[@id='tbMiddleName_TextBox']";
	public static String addLname= "//input[@id='tbLastName_TextBox']";	
	public static String sameAddrCbox = "//span[@id='AddressTextBox']/div[contains(@class,'checkbox')]";
	public static String addStreet= "//input[@id='AddressTextBox_AddressLine1']";
	public static String addZip= "//input[@id='AddressTextBox_AddressCityStateZip']";
	public static String addSSN= "//input[@id='SSNTextBox_TextBox']";
	public static String addMaiden= "//input[@id='MothersMaidenName_TextBox']";
	public static String addOccupation= "//input[@id='Occupation_TextBox']";
	public static String addPhone= "//input[@id='tbPhone1_RadMaskedTextBox']";
	public static String addPhoneType= "//select[@id='tbPhone1_ddPhoneNumberType']";
	public static String addEmail= "//input[@id='tbEmail1_RadTextBox']";
	public static String addButton= "//input[@id='btnAdd']";
	public static String ownersAddTtl = "//strong[text()='Joint Owners Added']";
	public static String beneAddTtl = "//strong[contains(text(),'Beneficiaries')]";
	public static String addOwnersLink = "//a[contains(@href,'HyperlinkList')][1]";
	public static String removeAddOwners = "//a[contains(@href,'HyperlinkList')][2]";
	
	//Confirm Account Roles
	public static String confirmRolesTtl = "//strong[text()='Confirm Account Roles']";
	public static String rolesProdOne = "(//span[@id='ProductRelationships']//td[contains(@id,'Name')])[1]";
	public static String primaryRoleOne ="(//span[@id='ProductRelationships']//div[contains(@class,'checked disabled')])[1]";
	public static String jointRoleChecked ="(//span[@id='ProductRelationships']//div[@class='icheckbox_square-grey checked'])[1]";
	public static String jointRoleNotChecked= "(//span[@id='ProductRelationships']//div[@class='icheckbox_square-grey'])[1]";
	public static String roleDisabledOne= "(//span[@id='ProductRelationships']//div[@class='icheckbox_square-grey disabled'])[1]";
	public static String rolesProdTwo = "(//span[@id='ProductRelationships']//td[contains(@id,'Name')])[2]";
	public static String primaryRoleTwo ="(//span[@id='ProductRelationships']//div[contains(@class,'checked disabled')])[2]";
	public static String roleDisabledTwo= "(//span[@id='ProductRelationships']//div[@class='icheckbox_square-grey disabled'])[2]";
	public static String rolesProdThree = "(//span[@id='ProductRelationships']//td[contains(@id,'Name')])[3]";
	public static String primaryRoleThree ="(//span[@id='ProductRelationships']//div[contains(@class,'checked disabled')])[3]";
	public static String roleDisabledThree= "(//span[@id='ProductRelationships']//div[@class='icheckbox_square-grey disabled'])[3]";
	public static String rolesProdFour = "(//span[@id='ProductRelationships']//td[contains(@id,'Name')])[4]";
	public static String primaryRoleFour ="(//span[@id='ProductRelationships']//div[contains(@class,'checked disabled')])[4]";
	public static String rolesProdFive = "(//span[@id='ProductRelationships']//td[contains(@id,'Name')])[5]";
	public static String primaryRoleFive ="(//span[@id='ProductRelationships']//div[contains(@class,'checked disabled')])[5]";
	public static String rolesProdSix = "(//span[@id='ProductRelationships']//td[contains(@id,'Name')])[6]";
	public static String primaryRoleSix ="(//span[@id='ProductRelationships']//div[contains(@class,'checked disabled')])[6]";
	public static String rolesProdSeven = "(//span[@id='ProductRelationships']//td[contains(@id,'Name')])[7]";
	public static String primaryRoleSeven ="(//span[@id='ProductRelationships']//div[contains(@class,'checked disabled')])[7]";
	
	//Confirm Accounts
	public static String confirmTtl = "//strong[text()='Confirm Account Selections']";
	public static String prodOne = "(//span[@id='ProductsAndServices']//li[1])[1]";
	public static String prodTwo = "//span[@id='ProductsAndServices']//li[2]";
	public static String prodWOptions = "(//span[@id='ProductsAndServices']//li[2])[1]";
	public static String prodWOptionsOne = "(//span[@id='ProductsAndServices']//li[1])[2]";
	public static String prodWOptionsTwo = "(//span[@id='ProductsAndServices']//li[2])[2]";
	public static String prodWOptionsThree = "(//span[@id='ProductsAndServices']//li[3])[1]";
	public static String prodFour = "//span[@id='ProductsAndServices']//li[4]";
	public static String confirmBtn="//input[@id='btnNext_SubmitButton']";
	public static String changeBtn="//input[@id='btnChange_SubmitButton']";
	public static String prodFive = "//span[@id='ProductsAndServices']//li[5]";
	public static String prodSix = "//span[@id='ProductsAndServices']//li[6]";
	public static String prodSeven = "//span[@id='ProductsAndServices']//li[7]";
	
	//Agreements and Disclosures
	public static String agreementTtl = "//h2[text()='Account Agreements and Disclosures']";
	public static String termsAndCondCheckBox = "//span[@id='cbDisclosures']//div[@class='icheckbox_square-grey']";
	public static String agreeAndSignCheckBox = "//span[@id='Authroization']//div[@class='icheckbox_square-grey']";
	public static String mobileLink= "//a[text()='Mobile Remote Deposit Capture Terms and Conditions']";
	public static String eDocsLink= "//a[text()='eDocument Consent']";
	public static String discCheckBox= "//span[@id='cbDisclosures']//div[@class='icheckbox_square-grey']";
	public static String discChecked= "//span[@id='cbDisclosures']//div[contains(@class,'checked')]";	
	public static String disclosuresText= "(//div[@class='row disclaimer']//p)[1]";
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
	public static String agreeAndSignTtl= "//h3[text()='Agreement and Signature(s)']";
	public static String agreeandSignInfo= "//div[@class='col-sm checkCopy']";
	public static String agreeCheckBox= "//span[@id='Authroization']//div[@class='icheckbox_square-grey']";
	public static String agreeChecked= "//span[@id='Authroization']//div[contains(@class,'checked')]";
	public static String agreementNote= "(//div[@class='row disclaimer']//p)[2]";
	public static String declineBtn= "//input[@id='btnDecline_SubmitButton']";
	public static String saveBtn= "//input[@id='SaveButton_SubmitButton']";
	//Cannot Process Application
	public static String declineTtl= "//strong[text()='We Cannot Process Your Application']";
	
	//ID Verification
	public static String IdentityTtl= "//h3[text()='Identity Verification']";
	public static String IdentityName = "//span[@id='lblIndividualName_Label']";
	public static String questionOne = "(//span[@id='IDAuthenticationQuestions']//table//tr[4])[1]";
	public static String qstnOneOptnOne= "(//span[contains(text(),'counties')]//following::div[@class='iradio_square-grey'])[1]";
	public static String questionTwo = "(//span[@id='IDAuthenticationQuestions']//table//tr[5])[1]";
	public static String qstnTwoOptnTwo= "(//span[contains(text(),'corporations')]//following::div[@class='iradio_square-grey'])[2]";
	public static String questionThree = "(//span[@id='IDAuthenticationQuestions']//table//tr[5])[2]";
	public static String qstnThreeOptnThree= "(//span[contains(text(),'city')]//following::div[@class='iradio_square-grey'])[3]";
	public static String questionFour = "(//span[@id='IDAuthenticationQuestions']//table//tr[5])[3]";
	public static String qstnFourOptnFour= "(//span[contains(text(),'addresses')]//following::div[@class='iradio_square-grey'])[4]";
	public static String errorMsg ="//span[@id='ErrorSummary1']//div[contains(@style,'color:Red;')]//li[1]";
	
	//Save Your Progress
	public static String saveTitle= "//strong[text()='Save Your Progress']";
	public static String cancelBtn= "//input[@id='btnCancel_SubmitButton']";
	public static String emailAddr = "//input[@id='EmailTextBox_RadTextBox']";
	public static String password = "//input[@id='tbASCPassword_TextBox']";
	public static String statusCenter = "//a[text()='Status Center']";
	public static String statusCenterTtl = "//span[contains(text(),'Application') and contains(text(),'Status Center')]";
	public static String LeaveBtn="//input[@id='btnLeave_SubmitButton']";
	public static String errorPassword = "//input[@type='password' and contains(@style,'LightYellow')]";
	public static String pwAsterisk= "//span[contains(@id,'Password') and @style='color:Red;']";
	
	//Account Funding
	public static String acctFundTitle = "//strong[text()='Account Funding']";
	public static String submitBtn="//input[@id='NextButton2_SubmitButton']";
	public static String fundProdLbl1 = "(//label[contains(@for,'ProductFund')])[1]";
	public static String fundProdInput1 = "(//input[contains(@name,'ProductFund')])[1]";
	public static String fundProdInput2 = "(//input[contains(@name,'ProductFund')])[2]";
	public static String fundProdError = "//input[contains(@name,'ProductFund')and contains(@style,'LightYellow')]";
	public static String fundProdRO = "//input[contains(@name,'ProductFund') and @disabled='disabled']";
	public static String fundAmtPopup = "//div[@class='popover-content']";
	public static String fundTotalAmt = "//div[contains(@id,'FundingTotal')]";
	public static String transferLbl = "//label[@for ='TransFunding_RadioButton']";
	public static String eleCheckLbl = "//label[@for ='ACHFunding_RadioButton']";
	public static String creditLbl = "//label[@for ='CCFunding_RadioButton']";
	public static String transferOptn = "//span[@id='TransFunding']//div[@class='iradio_square-grey']";
	public static String transferSlctd = "//span[@id='TransFunding']//div[contains(@class,'checked')]";
	public static String accountDdownLbl = "//div[@id='transDiv']";
	public static String accountDdownError = "//select[@id='AccountDropDownList_DropDownList'and contains(@style,LightYellow)]";
	public static String accountDdown = "//select[@id='AccountDropDownList_DropDownList']";
	public static String eleCheckOptn = "//span[@id='ACHFunding']//div[@class='iradio_square-grey']";
	public static String debitCreditOptn = "//span[@id='CCFunding']//div[@class='iradio_square-grey']";
	public static String cardNumber = "//input[@id='CreditCard_CardNumber']";
	public static String ccMonth="//select[@id='CreditCard_Month']";
	public static String ccYear="//select[@id='CreditCard_Year']";
	public static String cvvInput="//input[@id='CreditCard_CVV']";
	public static String cvvQuestion= "//span[contains(@class,'question-circle')]";
	public static String cvvTooltip = "//div[@class='tooltip fade bottom in']";
	public static String ccFname = "//input[contains(@id,'FirstNameOnCard')]";
	public static String ccLname = "//input[contains(@id,'LastNameOnCard')]";
	public static String submitApp = "//h1[text()='Thank You for Your Application!']";	
	
	//Error Messages
	public static String errorMsg1 ="//span[@id='ErrorSummary1']//div[@style='color:Red;']//li[1]";
	public static String errorMsg2 ="//span[@id='ErrorSummary1']//div[@style='color:Red;']//li[2]";
	public static String errorMsg3 ="//span[@id='ErrorSummary1']//div[@style='color:Red;']//li[3]";
	public static String errorMsg4 ="//span[@id='ErrorSummary1']//div[@style='color:Red;']//li[4]";
	
	public static String progressBarOptions = "//span[@id='progBar']//td";
	
	
	//Member Verification Page new components
	
	public static String member_verification_page_header = "//div[@class='col-sm']//h3";
	
	public static String below_header_info(int index){
		return "(//div[@class='col-sm']//p)["+index+"]";
	}
	
	//OTP
	public static String otp_page_header = "//span/h1";
	
	//Delevery Method Page
	
	public static String delivery_method_page_header = "//*[contains(text(),'Select a Delivery Method')]";
	public static String delivery_method_email_option(String option){
		return "//label[contains(@for,'OneTimePasscode')]/../label[contains(text(),'"+option+"')]";
	}
	
	
	
	public static String send_otp_button = "//span[@id='btnOTPSendCode']";
	public static String security_code_textbox = "//input[@id='OneTimePasscode_tbOTPCode_TextBox']";
	public static String btn_verify_code = "//span[@id='btnOTPVerifyCode']//input";
	public static String your_information_page = "//*[contains(text(),'Your Information')]";
	public static String resend_otp = "//span[@id='btnResendCode']//input";
	
	//Promo Code
	public static String cnfrmacnt_ttl="//*[text()='Confirm Selected Products and Services']";
	public static String sub_text = "//*[text()='Confirm Selected Products and Services']/following::p[1]";
	public static String add_promocode_field = "//input[@name='tbPromoCode_TextBox']";
	public static String cnfrm_btn="//input[@id='btnNext_SubmitButton']";
	public static String promocode_disclaimer = "//div[@class='col-sm disclaimer']/p";
	public static String invalid_promocode_error = "//span[@id='ErrorSummary1']//li";
	
	//Joint Owner and Beneficiary
	
	public static String preferred_method_for_communication = "//select[@id='ContactMethod_DropDownList']";
	public static String add_existing_member_lookup_link = "//span[@id='pnlExistingMember']//a";
	public static String additional_account_beneficiary_header = "//div[@class='ContentTable']//h3";
	
	public static String shareamnt_txt="//input[contains(@id,'ProductFunding_FormProductID')]";
	public static String elctrnc_opt="//label[text()='Electronic Check']";
	public static String rtngnmbr_txt="//input[@id='ACHFundingAccountVerification_tbRoutingNumber_NumericTextBox']";
	public static String acntnmbr_txt="//input[@id='ACHFundingAccountVerification_tbAccountNumber_TextBox']";
	public static String vrfyacnt_btn="//button[@id='DeferredInputSubmit']";
	public static String thnku_ttl="//h1[text()='Thank You for Your Application!']";
	
	public static String sub_text_under_header = "//*[text()='Thank You for Your Application!']/following::p[1]";
	public static String sub_text_under_uploadDocument = "//*[text()='Thank You for Your Application!']/following::p[2]";
	public static String join_owner_name = "//table[contains(@id,'_GridView')]//tr[2]//td[1]";

}
