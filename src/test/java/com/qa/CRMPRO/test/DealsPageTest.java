package com.qa.CRMPRO.test;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.CRMPRO.Base.BasePage;
import com.qa.CROMPRO.Pages.ContactsPage;
import com.qa.CROMPRO.Pages.DealsPage;
import com.qa.CROMPRO.Pages.LoginPage;
import com.qa.CRMPRO.Utils.AppConstants;
import com.qa.CRMPRO.Utils.ExcelUtil;

public class DealsPageTest {
	BasePage basepage;
	WebDriver driver;
	LoginPage loginpage;
	Properties prop;
	ContactsPage contactspage;
	DealsPage dealspage;
	@BeforeTest
	public void setUp()
	{
		basepage = new BasePage();
		prop = basepage.init_properties();
		String browsername = prop.getProperty("browser");
		driver = basepage.init_driver(browsername);
		driver.get(prop.getProperty("url"));

		loginpage = new LoginPage(driver);
		contactspage = new ContactsPage(driver);
		dealspage = new DealsPage(driver);
		contactspage = loginpage.doLogin(prop.getProperty("username"), prop.getProperty("password"));

	}

	@Test(priority=1,enabled=true)
	public void getDealsPage()
	{
		dealspage.clickDealslink();
	}

	@Test(priority=2,enabled=true)
	public void getNewIcon()
	{

		dealspage.clickNewIcon();
	}

	@DataProvider
	public Object[][] getDealsinfo()
	{
		Object data[][] = ExcelUtil.getTestData(AppConstants.Deals_Sheet_Name);
		
		return data;
	}

	@Test(priority=3, dataProvider="getDealsinfo",enabled=true)
	public void getallDealsinfo(String title,String assignedto,String description,String probability,String amount,String stage,String nextsteps,String status,String type,String source,String identifier) throws InterruptedException
	{
		dealspage.enterallDealsInfo(title, assignedto, description, probability, amount, stage, nextsteps,status, type, source, identifier);
	}
}