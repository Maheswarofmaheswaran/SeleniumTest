package com.aspire.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import junit.framework.Assert;

public class HomePage {

	WebDriver ldriver;
	public HomePage(WebDriver rdriver){
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(id="result_app_1")
	WebElement inventorybutton;
	
	@FindBy(id="result_app_2")
	WebElement manufacturingbutton;

	@FindBy(xpath="//a[@title='Applications']")
	WebElement applicationsButton;
	
	@FindBy(xpath="//li[@class='breadcrumb-item active']")
	WebElement inventoryoverviewtext;
	
	@FindBy(xpath="//ul[@class='o_menu_sections']//a[contains(text(),'Products')]")
	WebElement productsTab;
	
	@FindBy(xpath="//a[@role='menuitem']//span[contains(text(),'Products')]")
	WebElement productsdropdown;
	
	@FindBy(xpath="//li[@class='breadcrumb-item active']")
	WebElement productstext;
	
	@FindBy(xpath="//li[@class='breadcrumb-item active']")
	WebElement manufacturingtext;
	
	@FindBy(xpath="//button[normalize-space()='Create']")
	WebElement productcreatebutton1;
	
	@FindBy(xpath="//input[@placeholder='Product Name']")
	WebElement productnameinput;
	
	@FindBy(xpath="//button[normalize-space()='Save']")
	WebElement productsavebutton1;
	
	@FindBy(xpath="//span[@placeholder='Product Name']")
	WebElement productnametextcreated;
	
	@FindBy(xpath="//span[normalize-space()='Update Quantity']")
	WebElement updatequantitybutton1;
	
	@FindBy(xpath="//button[normalize-space()='Create']")
	WebElement createqtybutton2;
	
	@FindBy(xpath="//div[@name='location_id']//input[@type='text']")
	WebElement locationNameInput;
	
	@FindBy(xpath="//ul/li[contains(.,'Partner Locations/HN')]")
	WebElement partnerlocation;
	
	@FindBy(xpath="//div[@name='package_id']//input[@type='text']")
	WebElement packagescountInput;
	
	@FindBy(xpath="//span[normalize-space()='Create']")
	WebElement createqtybutton3;
	
	@FindBy(xpath="//input[@name='inventory_quantity']")
	WebElement inventorycountInput;
	
	@FindBy(xpath="//button[normalize-space()='Save']")
	WebElement inventorysavebutton;
	
	@FindBy(xpath="//tbody/tr[1]/td[5]")
	WebElement updatedQtyText1;
	
	//a[@title='Applications']
	
	public void navigateToProductsPage() throws InterruptedException
	{
		productsTab.click();
		Thread.sleep(3000);
		productsdropdown.click();
	}
	
	public void navigateToApplicationsPage() throws InterruptedException
	{
		applicationsButton.click();
	}
	
	public void navigateToManufacturingPage() throws InterruptedException
	{
		manufacturingbutton.click();
	}
	
	public boolean verifyHomePageURL(String value)
	{
		
		boolean isContains=ldriver.getCurrentUrl().contains(value);
		return isContains;
	}
	
	public void clickInventoryButton()
	{
		inventorybutton.click();
	}
	
	public void verifyInventoryOverViewText(String value)
	{
		String txt=inventoryoverviewtext.getText();
		System.out.println("Inventory Text is "+txt);
		Assert.assertEquals(value,txt);
	}
	public void clickCreateButton1ForProd()
	{
		productcreatebutton1.click();
	}
	public void setProductName(String value)
	{
		productnameinput.sendKeys(value);
	}
	public void clickSaveButton1ForProd()
	{
		productsavebutton1.click();
	}
	
	public void verifyProductsText(String value) throws InterruptedException
	{
		Thread.sleep(3000);
		String txt=productstext.getText();
		System.out.println("Products Text is "+txt);
		Assert.assertEquals(value,txt);
	}
	public void verifyManufacturingText(String value) throws InterruptedException
	{
		Thread.sleep(3000);
		String txt=manufacturingtext.getText();
		System.out.println("Manufacturing Text is "+txt);
		Assert.assertEquals(value,txt);
	}
	
	
	public void clickUpdateQtyButton1ForProd()
	{
		updatequantitybutton1.click();
	}
	public void clickCreateButton2Forlocation()
	{
		createqtybutton2.click();
	}
	public void setLocation(String value) throws InterruptedException
	{
		locationNameInput.click();
		Thread.sleep(1000);
		partnerlocation.click();
	}
	public void setPackagesCount(String value)
	{
		packagescountInput.sendKeys(value);
		inventorycountInput.clear();
		createqtybutton3.click();
	}
	
	public void setInventoryCount(String value) throws InterruptedException
	{
		inventorycountInput.sendKeys(value);
		Thread.sleep(1000);
		inventorysavebutton.click();
		Thread.sleep(1000);
	}
	public void createProduct(String name) throws InterruptedException
	{
		clickCreateButton1ForProd();
		Thread.sleep(3000);
		setProductName(name);
		clickSaveButton1ForProd();
	}
	
	
	public void verifyCreatedProductText(String value) throws InterruptedException
	{
		Thread.sleep(3000);
		String txt=productnametextcreated.getText();
		System.out.println("Created Product name is "+txt);
		Assert.assertEquals(value,txt);
	}
	
	public void updateProductQty(String location, String packagescount,String inventorycount) throws InterruptedException
	{
		clickUpdateQtyButton1ForProd();
		Thread.sleep(3000);
		clickCreateButton2Forlocation();
		setLocation(location);
		setPackagesCount(packagescount);
		setInventoryCount(inventorycount);
	}
	
	public void verifyUpdatedQty(String value) throws InterruptedException
	{
		Thread.sleep(3000);
		String txt=updatedQtyText1.getAttribute("title");
		System.out.println("Updated Qty is "+txt);
		Assert.assertEquals(value,txt);
	}
}
