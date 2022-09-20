package org.rahulshettyacademy.TestUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebElement;
import org.rahulshettyacademy.Utils.AppiumUtils;
import org.rahulshettyacademy.pageObjects.android.FormPage;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

    public class AndroidBaseTest extends AppiumUtils{
	public AndroidDriver driver;
//	public ChromeDriver driver1;
	public AppiumDriverLocalService service;

	
//	public AndroidBaseTest(AndroidDriver driver) {
//		super(driver);
//		this.driver=driver;
//	}

	//public FormPage formPage;
	
	@BeforeClass(alwaysRun=true)
	public void ConfigureAppium() throws IOException
	{
//		Properties properties = new Properties();
//		FileInputStream fis = new FileInputStream("C:\\Users\\tahmi\\eclipse-workspace\\AppiumFrameworkDesign\\src\\main\\java\\org\\rahulshettyacademy\\resources\\data.properties");
//		properties.load(fis);
//		String ipAddress = properties.getProperty("ipAddress");
//		String port = properties.getProperty("port");
		
		//code to start the server
//		service = startAppiumServer();
		service = new AppiumServiceBuilder().withAppiumJS(new File("C:\\Users\\tahmi\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js")).withIPAddress("127.0.0.1").usingPort(4723).build();
		service.start();
		
		UiAutomator2Options options = new UiAutomator2Options();
		options.setDeviceName("pixel_3");
		options.setChromedriverExecutable("C:\\Users\\tahmi\\Downloads\\chromedriver");
		options.setApp("C:\\Users\\tahmi\\eclipse-workspace\\AppiumFrameworkDesign\\src\\test\\java\\org\\rahulshettyacademy\\resources\\General-Store.apk");
//		driver1 = new ChromeDriver();
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
		//formPage = new FormPage(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	  }
	
	public Double getFormatedAmount(String amount)
	{
		Double price = Double.parseDouble(amount.substring(1));
		return price;
	}

	  @AfterClass(alwaysRun=true)
      public void tearDown()
      {
	     driver.quit();  //stop driver
	     service.stop(); //code to stop server	
	  }
	
}


















//
//public void longPressAction(WebElement ele)
//{
//	((JavascriptExecutor)driver).executeScript("mobile: longClickGesture",
//			ImmutableMap.of("elementId",((RemoteWebElement)ele).getId(),
//					"duration",2000));
//}
//
//public void scrollToEndAction()
//{
//	boolean canScrollMore;
//	do
//	{
//	canScrollMore = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of(
//		    "left", 100, "top", 100, "width", 200, "height", 200,
//		    "direction", "down",
//		    "percent", 3.0
//		    ));
//	}
//	while (canScrollMore);
// }
//
//public void scrollToText(String text)
//{
//	 driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\""+text+"\"));"));
//}
//
//public void swipeAction(WebElement ele,String direction)
//{
//	((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of(
//				    "elementId",(((RemoteWebElement)ele).getId()),
//				    "direction", direction,
//				    "percent", 0.75
//				));
//}
//     
	

