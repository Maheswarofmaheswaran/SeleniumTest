package com.aspire.testCases;

import java.time.Duration;
import java.util.List;

import javax.crypto.KeyAgreementSpi;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aspire.pageObjects.HomePage;
import com.aspire.pageObjects.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;

public class AspireTest extends BaseClass{
	
	@Test(priority=0)
	public void loginTest() throws InterruptedException {
	

		lp.login(username, password);
		Thread.sleep(3000);
		Assert.assertTrue(hp.verifyHomePageURL("home"));
	}
	@Test(priority=1)
	public void navigateToInventory() {
		
		hp.clickInventoryButton();
		hp.verifyInventoryOverViewText("Inventory Overview");

	}
	
	@Test(priority=2)
	public void selectingProducts() throws InterruptedException {
		
		hp.navigateToProductsPage();
		hp.verifyProductsText("Products");
		
	}
	
	@Test(priority=3)
	public void creatingProduct() throws InterruptedException {
		
		hp.createProduct(productname);
		hp.verifyCreatedProductText(productname);
		
	}
	@Test(priority=4)
	public void updatingProductQty() throws InterruptedException {
	
		hp.updateProductQty("Partner Locations/HN", "15", "15");
		hp.verifyUpdatedQty("15.00");

	}
	@Test(priority=5)
	public void navigatingToApplications() throws InterruptedException {
	
		hp.navigateToApplicationsPage();
		Assert.assertTrue(hp.verifyHomePageURL("home"));	
	}

	@Test(priority=6)
	public void navigatingToManufacturing() throws InterruptedException {
		
		hp.navigateToManufacturingPage();
		hp.verifyManufacturingText("Manufacturing Orders");
	}
	
	@Test(priority=7)
	public void creatingManufacturingOrder() throws InterruptedException {
		
		mp.createManufacturingOrder(productname);
		mp.verifyStatusOfOrder("Done");
	}
	
	@Test(priority=8)
	public void verifyingManufacturingOrder() throws InterruptedException {
		
		mp.verifyCreatedOrder(productname, "1.00");
	}

}
