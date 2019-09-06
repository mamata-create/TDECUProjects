package com.FrameworkComponents;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;

public class BaseClass {
	AppiumDriverLocalService service;
	public static AppiumDriver<MobileElement> driver;
	public static ExcelReader excl;
	public static String sheetName;
	public static String myTestCaseName;
	public static String platform;
	public static String username;
	public static String password;
	public static boolean continuetestcase;
	public static int startIter;
	
	//To initialize the appium driver with desired capabilities
	public void executeMobileDriver() throws MalformedURLException, InterruptedException{
		readExcel();
	
		sheetName="General";
		int rowCountGeneralSheet = excl.getRowCount(sheetName);
		System.out.println(rowCountGeneralSheet);
		for(int row=1;row<=rowCountGeneralSheet;row++)
			{
				if(myTestCaseName.equals(excl.getCellData(sheetName, 0,row)))
				{
					 
					if(excl.getCellData(sheetName, 1,row).equals("Yes") && excl.getCellData(sheetName, 2,row).equals("Android"))
					{
						
						continuetestcase=true;
						username=excl.getCellData(sheetName,3,row);
						password=excl.getCellData(sheetName,4,row);
		//Set Desired capabilities
				DesiredCapabilities cap=new DesiredCapabilities();
				cap.setCapability(MobileCapabilityType.DEVICE_NAME, "android");
				cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "android");
				cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "9");
//				cap.setCapability("unicodeKeyboard", true);
//				cap.setCapability("resetKeyboard", true);
				//cap.setCapability(MobileCapabilityType.BROWSER_NAME, "chrome");
				//cap.setCapability(MobileCapabilityType.APP, APP_PATH);
				cap.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.texasdowcreditunion5004.mobile.preproduction.ui.MainActivity");
				
				cap.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.texasdowcreditunion5004.mobile.preproduction");
				URL serverURL = new URL("http://localhost:"+4723+"/wd/hub");
				
				 driver = new AndroidDriver<MobileElement>(serverURL,cap);
				Thread.sleep(10000);
					}
				}
			}
	}
	
	//To start the appium seervice
	public void startAppium(){
		 service=AppiumDriverLocalService.buildDefaultService();
		service.start();
		System.out.println("Appium started");
	}
	
	//To stop the appium service
	public void stopAppium(){
		service.stop();
	}
	
	//read excel data
	public void readExcel(){
		System.out.println(System.getProperty("user.dir")+"\\src\\main\\java\\com\\Resources\\TestData.xlsx");
		excl=new ExcelReader(System.getProperty("user.dir")+"\\src\\main\\java\\com\\Resources\\TestData.xlsx");
	}
}
