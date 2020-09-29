package com.qa.CRMPRO.test;



import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.qa.CRMPRO.Base.BasePage;
import com.qa.CROMPRO.Pages.ContactsPage;
import com.qa.CROMPRO.Pages.Credentials;
import com.qa.CROMPRO.Pages.LoginPage;
import com.qa.CRMPRO.Utils.AppConstants;

public class LoginPageTest {
	BasePage basepage;
	WebDriver driver;
	LoginPage loginpage;
	Properties prop;
	ContactsPage contactspage;
	Credentials userCred;

	@BeforeMethod
	//@Parameters(value= {"browser"})
	public void setUp()
	{
		
		basepage = new BasePage();
		prop = basepage.init_properties();
		basepage = new BasePage();
		prop = basepage.init_properties();
		String browser = prop.getProperty("browser");
		driver = basepage.init_driver(browser);
		driver.get(prop.getProperty("url"));
		loginpage = new LoginPage(driver);
		contactspage = new ContactsPage(driver);
		contactspage = loginpage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		
		
	}
	


	@Test(priority=1)
	public void verifyPageTitle()
	{
		String title = loginpage.getTitle();
		System.out.println("Login Page Title is:"+ title);
		Assert.assertEquals(title, AppConstants.Login_Page_Title);
	}
	@Test(priority=2)
	public ContactsPage verifyLogin() throws InterruptedException
	{
		loginpage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		Thread.sleep(1000);
		String title = contactspage.getContactsPagetitle();
		System.out.println("Get homepage title:"+ title);

		Assert.assertEquals(title,AppConstants.Home_Page_Title);

		return new ContactsPage(driver);


	}
//	@DataProvider
//	public void getusernamepassword()
//	{
//		Object data[][] = {{"test","test@12312"},{"test44","tet444"},{"",""}};
//	}

//	@Test(priority=4,dataProvider="getusernamepassword")
//	public void verifyusernamepassword(String username,String pwd)
//	{    
//		userCred.SetAppusername(username);
//		userCred.setApppassword(pwd);
//		contactspage = loginpage.doLogin(username, pwd);
//	}

	@AfterMethod
	public void teardown()
	{
		driver.quit();
	}
}

