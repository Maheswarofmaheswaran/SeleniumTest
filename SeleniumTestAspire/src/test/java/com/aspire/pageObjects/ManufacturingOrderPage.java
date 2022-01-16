package com.aspire.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aspire.utilities.ReadConfig;

import junit.framework.Assert;

public class ManufacturingOrderPage {
	WebDriver ldriver;
	public ManufacturingOrderPage(WebDriver rdriver){
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
		
	}
	@FindBy(xpath="//button[normalize-space()='Create']")
	WebElement createmobutton1;
	
	@FindBy(xpath="//div[@name='product_id']/div/input")
	WebElement productnameinput;
	
	@FindBy(xpath="//ul/li/a[contains(text(),'Phone131')][1]")
	WebElement productnamedropdown;
	
	@FindBy(xpath="//a[contains(text(),'Add a line')]")
	WebElement addaline;

	@FindBy(xpath="//table[@class='o_list_table table table-sm table-hover table-striped o_list_table_ungrouped']//tbody/tr/td/div/div/input")
	List<WebElement> newlineprods;
	
	@FindBy(xpath="//input[@name='product_uom_qty']")
	WebElement prodqtyorders;
	
	@FindBy(xpath="//span[normalize-space()='Confirm']")
	WebElement confirmbuton;
	
	@FindBy(xpath="//button[normalize-space()='Save']")
	WebElement savebuton;
	
	@FindBy(xpath="//span[normalize-space()='Mark as Done']")
	WebElement markasdonebutton;
	
	@FindBy(xpath="//span[normalize-space()='Apply']")
	WebElement applybutton;
	
	@FindBy(xpath="//ul[@class='o_Message_trackingValues']/li[1]/div/div[4]")
	List<WebElement> messages;
	
	@FindBy(xpath="//span[@placeholder='Manufacturing Reference']")
	WebElement idofmanufact;
	
	@FindBy(xpath="//a[@name='product_id']/span")
	WebElement productname;
	
	@FindBy(xpath="//span[@name='qty_producing']")
	WebElement quantinyofproducing;
	
	public void clickCreateButton1ForCreateMO() 
	{
		createmobutton1.click();
	}
	public void setProductName(String value) throws InterruptedException
	{
		productnameinput.sendKeys(value);
		Thread.sleep(3000);
		productnamedropdown.click();
		addaline.click();

		newlineprods.get(0).sendKeys(value);
		Thread.sleep(3000);
		newlineprods.get(0).sendKeys(Keys.DOWN);
		newlineprods.get(0).sendKeys(Keys.ENTER);
		Thread.sleep(3000);

	}
	
	public void setProductQty(String value) throws InterruptedException
	{
		prodqtyorders.clear();
		prodqtyorders.sendKeys(value);

	}
	public void clickConfirmButton()
	{
		confirmbuton.click();
	}
	
	public void clickMarkAsDoneButton()
	{
		markasdonebutton.click();
	}

	public void clickApplyButton()
	{
		applybutton.click();
	}
	
	public void clickSaveButton()
	{
		savebuton.click();
	}
	public void createManufacturingOrder(String value) throws InterruptedException
	{
		clickCreateButton1ForCreateMO();
		setProductName(value);
		setProductQty("12");
		clickConfirmButton();
		Thread.sleep(3000);
		clickSaveButton();
		clickMarkAsDoneButton();
		clickApplyButton();
		Thread.sleep(3000);
	}
	public void verifyStatusOfOrder(String value) throws InterruptedException
	{
		String txt=messages.get(0).getText();
		System.out.println("Status is "+txt);
		Assert.assertEquals(value,txt);
	}
	
	public void verifyCreatedOrder(String prdname,String qty) throws InterruptedException
	{
		String id=idofmanufact.getText();
		Assert.assertNotNull(id);
		System.out.println("Manufacturing ID is "+id);
		String prodname=productname.getText();
		Assert.assertEquals(prodname,prdname);
		System.out.println("Product name is "+prodname);
		String qtyproducing=quantinyofproducing.getText();
		Assert.assertEquals(qtyproducing, qty);
		System.out.println("Quantity producing is "+qtyproducing);
	}
	
}
