package org.rahulshettyacademy.pageObjects.android;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import org.rahulshettyacademy.Utils.AndroidActions;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class FormPage extends AndroidActions{

    AndroidDriver driver;
    
    public FormPage(AndroidDriver driver){
    	 super(driver);
    	 this.driver = driver;
    	 PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }
    
    @AndroidFindBy(id = "com.androidsample.generalstore:id/nameField")
	private WebElement nameField;
    //driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/nameField")).sendKeys("Mou");
    
    @AndroidFindBy(xpath = "//android.widget.RadioButton[@text='Female']")
    private WebElement femaleOptions;
    //driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/radioFemale")).click();
    @AndroidFindBy(id = "com.androidsample.generalstore:id/radioMale")
    private WebElement maleOptions;
   
    @AndroidFindBy(id = "android:id/text1")
    private WebElement countryOptions;
    //driver.findElement(AppiumBy.id("android:id/text1")).click();

    @AndroidFindBy(id = "com.androidsample.generalstore:id/btnLetsShop")
    private WebElement shopButton;
    //driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/btnLetsShop")).click();
    
    
    public void setNameFiled(String name)
    {
    	nameField.sendKeys(name);
    	driver.hideKeyboard();
    }

//    public void setActivity()
//    {
//    Activity activity= new Activity("com.androidsample.generalstore" , "com.androidsample.generalstore.MainActivity");
//    driver.startActivity(activity);//screen to homepage
//    }
    
    public void setGender(String gender)
    {
    	if (gender.contains("female"))
    		femaleOptions.click();
    	else
    		maleOptions.click();
    }

    public void setCountrySelection() //String countryName
    {
    	countryOptions.click();
    	//scrollToText(countryName);
    	driver.findElement(AppiumBy.xpath("(//android.widget.TextView)[3]")).click();
    	//driver.findElement(AppiumBy.xpath("(//android.widget.TextView[@text='"+countryName+"']")).click();
    }
    
    public void submitForm()
    {
    	shopButton.click();
    }

}







//driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/spinnerCountry")).click();
//driver.findElement(AppiumBy.className("android.widget.ListView"));
//driver.findElement(AppiumBy.xpath("(//android.widget.TextView)[8]")).click();
//driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/nameField")).sendKeys("Mou");
//driver).hideKeyboard();
//driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/radioFemale")).click();
//driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/btnLetsShop")).click();