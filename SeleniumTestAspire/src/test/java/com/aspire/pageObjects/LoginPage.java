package com.aspire.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.aspire.utilities.ReadConfig;
public class LoginPage {

	
	WebDriver ldriver;
	public LoginPage(WebDriver rdriver){
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(id="login")
	WebElement 	userID;
	
	@FindBy(id="password")
	WebElement password;
	
	@FindBy(xpath="//button[normalize-space()='Log in']")
	WebElement loginbutton;
	
	public void launchLoginURL(String url)
	{
		ldriver.get(url);
	}
	public void setUserName(String uname)
	{
		userID.sendKeys(uname);
	}
	
	public void setPassword(String pwd)
	{
		password.sendKeys(pwd);
	}
	
	public void clickLoginButton()
	{
		loginbutton.click();
	}
	
	public void login(String uname, String pwd)
	{
		this.setUserName(uname);
		this.setPassword(pwd);
		this.clickLoginButton();
	}
	

}
