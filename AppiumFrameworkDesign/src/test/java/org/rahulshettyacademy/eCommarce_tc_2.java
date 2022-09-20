package org.rahulshettyacademy;

import org.rahulshettyacademy.TestUtils.AndroidBaseTest;

import org.rahulshettyacademy.pageObjects.android.FormPage;
import org.rahulshettyacademy.pageObjects.android.ProductCatalogue;
import org.rahulshettyacademy.pageObjects.android.cartPage;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.beust.jcommander.Parameter;

import org.openqa.selenium.support.PageFactory;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;


public class eCommarce_tc_2 extends  AndroidBaseTest{

	@Test(dataProvider="getData" , groups = {"AllTest"})
	public void FillForm(String name, String gender) throws InterruptedException 
	{

		FormPage formPage = new FormPage(driver); //declear in baseTest
		formPage.setNameFiled(name);
		formPage.setGender(gender);
		formPage.setCountrySelection();
		formPage.submitForm();

		ProductCatalogue productCatalogue = new ProductCatalogue(driver);
        productCatalogue.addItemToCartByIndex(0);
        productCatalogue.addItemToCartByIndex(0); 
        productCatalogue.goToCartPage();
       
        cartPage cartpage = new cartPage(driver);
        double totalSum = cartpage.getProductSum();
        double displayFormattedSum = cartpage.getTotalAmountDisplay();
        Assert.assertEquals(totalSum, displayFormattedSum);
        cartpage.acceptTermsConditions();
        cartpage.submitOrder();
	 }
	
//	 @BeforeMethod
//	 public void preSetup()
//	 {
//		//formPage.setActivity();
//		 Activity activity= new Activity("com.androidsample.generalstore ","com.androidsample.generalstore.MainActivity ");//- GeneralStore
//		 driver.startActivity(activity);//screen to homepage 
//	 }
	
	 //dataprovider returns two dymentional array
	 @DataProvider

	 public Object[][] getData() {
		 for (int i=0; i>2; i++) 
		 {
			 System.out.println("get data");
		 }
		 return new Object[][] { {"MOU","female"},{"Alam","male"}};
	 }

}








//System.out.println("Mou running");
//try {
//	FormPage formPage = new FormPage(driver);
//	formPage.setNameFiled("Mou");
//	formPage.setGender("female");
//	formPage.setCountrySelection();
//	formPage.submitForm();
//    } catch (Exception e) {
//	// TODO Auto-generated catch block
//	System.out.println("Error = "+e.getMessage());
//}

