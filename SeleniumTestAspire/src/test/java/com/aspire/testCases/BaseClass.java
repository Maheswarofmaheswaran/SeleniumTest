package com.aspire.testCases;



import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.aspire.pageObjects.HomePage;
import com.aspire.pageObjects.LoginPage;
import com.aspire.pageObjects.ManufacturingOrderPage;
import com.aspire.utilities.ReadConfig;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public static WebDriver driver;
	public static LoginPage lp;
	public static HomePage hp;
	public static ManufacturingOrderPage mp;
	ReadConfig readconfig= new ReadConfig();
	public String baseURL=readconfig.getApplicationURL();
	public String username=readconfig.getUserName();
	public String password=readconfig.getPassword();
	public String productname=readconfig.getProductName();
	

	
	@BeforeClass
	public void setup() {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options= new ChromeOptions();
		options.addArguments("--disable-notifications");
	
		driver= new ChromeDriver(options);
		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get(baseURL);
		lp=new LoginPage(driver);
		hp=new HomePage(driver);
		mp= new ManufacturingOrderPage(driver);
	}
	

	@AfterClass
	public void teardown() {
		driver.quit();
	}
	
}