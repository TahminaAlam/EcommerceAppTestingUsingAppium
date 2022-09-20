package org.rahulshettyacademy.pageObjects.android;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import org.rahulshettyacademy.Utils.AndroidActions;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class cartPage extends AndroidActions {

	    AndroidDriver driver;
	    
	         public cartPage(AndroidDriver driver){
	    	 super(driver);
	    	 this.driver = driver;
	    	 PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	    	
	    }
	   
	    @AndroidFindBy(id ="com.androidsample.generalstore:id/productPrice")
	    private List<WebElement> produtList;
	    //List<WebElement> produtPrices = driver.findElements(AppiumBy.id("com.androidsample.generalstore:id/productPrice"));
	    
	    @AndroidFindBy(id ="com.androidsample.generalstore:id/totalAmountLbl")
	    private WebElement totalAmount;
	    //String displaysum = driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/totalAmountLbl")).getText();
        
	    @AndroidFindBy(id ="com.androidsample.generalstore:id/termsButton")
	    private WebElement terms;
	    //WebElement ele = driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/termsButton"));
	    
	    @AndroidFindBy(id ="android:id/button1")
	    private WebElement acceptButton;
	    //driver.findElement(AppiumBy.id("android:id/button1")).click();
	    
	    @AndroidFindBy(id ="com.androidsample.generalstore:id/btnProceed")
	    private WebElement proceed;
	    //driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/btnProceed")).click();
	    
	    @AndroidFindBy(className ="android.widget.CheckBox")
	    private WebElement checkBox;
	    //driver.findElement(AppiumBy.className("android.widget.CheckBox")).click();
	    
	    public List<WebElement> getProdutList()
	    {
	    	return produtList;
	    }
	    
	    public Double getProductSum()
	    {
	    	int count = produtList.size();
	    	double totalSum = 0;
	    	for(int i=0; i<count; i++)
	    	{
	    		String amountString = produtList.get(i).getText(); 
	    		double price = getFormatedAmount(amountString);
	    		totalSum = totalSum + price;
	    	}
	    	return totalSum;
	    }
	    
	    public Double getTotalAmountDisplay()
	    {
	    	return getFormatedAmount(totalAmount.getText());
	    }
	    
	    public void acceptTermsConditions()
	    {
	    	longPressAction(terms);
	    	acceptButton.click();
	    }
	    
	    public Double getFormatedAmount(String amount)
	    {
	    	Double price = Double.parseDouble(amount.substring(1));
	    	return price;
	    }
	    
	    public void submitOrder() throws InterruptedException
	    {
	    	Thread.sleep(2000);
	    	checkBox.click();
	    	proceed.click();
	    	driver.pressKey(new KeyEvent(AndroidKey.BACK));
	    }
}










//Thread.sleep(6000);
//List<WebElement> produtPrices = driver.findElements(AppiumBy.id("com.androidsample.generalstore:id/productPrice"));
//int count = produtPrices.size();
//double totalSum = 0;
//for(int i=0; i<count; i++)
//{
//	String amountString = produtPrices.get(i).getText(); 
//	double price = getFormatedAmount(amountString);
//	totalSum = totalSum + price;
//	System.out.println("totalSum: " + totalSum);
//}
//
//String displaysum = driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/totalAmountLbl")).getText();
//double displayFormatedsum = getFormatedAmount(displaysum);
//System.out.println("displayFormatedsum: " +displayFormatedsum);
////Assert.assertEquals(totalSum, displayFormatedsum);
//Thread.sleep(5000);
//
//WebElement ele = driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/termsButton"));
//((JavascriptExecutor)driver).executeScript("mobile: longClickGesture", 
//			ImmutableMap.of("elementId",((RemoteWebElement)ele).getId(),"duration",2000 ));
//driver.findElement(AppiumBy.id("android:id/button1")).click();
//
////driver.findElement(AppiumBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.CheckBox")).click();  
//driver.findElement(AppiumBy.className("android.widget.CheckBox")).click();
//driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/btnProceed")).click();