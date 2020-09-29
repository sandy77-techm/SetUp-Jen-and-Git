package com.qa.CROMPRO.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.qa.CRMPRO.Base.BasePage;
import com.qa.CRMPRO.Utils.ElementUtils;

public class LoginPage extends BasePage {

	WebDriver driver;
	ElementUtils elementutils;
	ContactsPage contactspage;
	
	By username = By.name("email");
	By password = By.name( "password");
	By login = By.xpath("//div[text()='Login']");
	

	
	
	
	public LoginPage(WebDriver driver)
	{
		this.driver = driver;
		elementutils = new ElementUtils(driver);
	}
	
	
	public String getTitle()
	{
		return elementutils.doGetPageTitle();
		
	}
	
	
	public ContactsPage doLogin(String name,String pwd)
	{
		elementutils.waitforElementPresent(username);
		elementutils.doSendKeys(username, name);
		elementutils.doSendKeys(password, pwd);
		elementutils.doclick(login);
		return new ContactsPage(driver);
		
	}
}
