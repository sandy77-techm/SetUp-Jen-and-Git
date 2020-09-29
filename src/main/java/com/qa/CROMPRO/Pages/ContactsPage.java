package com.qa.CROMPRO.Pages;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.CRMPRO.Base.BasePage;
import com.qa.CRMPRO.Utils.AppConstants;
import com.qa.CRMPRO.Utils.ElementUtils;
import com.qa.CRMPRO.Utils.JavaScriptUtil;

public class ContactsPage extends BasePage {
	WebDriver driver;
	ElementUtils elementutils;
	WebDriverWait wait;
	JavaScriptUtil javascriptutil;
	DealsPage dealspage;
	By headertitle = By.xpath("//span[@class='user-display']");
	By ContactsClick = By.xpath(("//span[contains(text(),'Contacts')]"));
	By NewIconbutton = By.xpath("//button[contains(text(),'New')]");
	By firstname = By.name("first_name");
	By lastname = By.name("last_name");
	By savebtn = By.xpath("//*[@id=\"dashboard-toolbar\"]/div[2]/div/button[2]");
	By middlename = By.name("middle_name");
	By email = By.name("value");
	By secondarymail = By.xpath("//*@id=\"ui\"]/div/div[2]/div[2]/div/div[2]/form/div[4]/div[1]/div/div/div/div[2]/input");
	//By addanotheremail = By.xpath("//*[@id=\"ui\"]/div/div[2]/div[2]/div/div[2]/form/div[4]/div[1]/div/div/div/button/i");
	By categorydropdown = By.xpath("//*[@id=\"ui\"]/div/div[2]/div[2]/div/div[2]/form/div[4]/div[2]/div/div/i");
	String category = "//span[contains(text(),'')]";
	By statusdropdown = By.xpath("//*[@id=\"ui\"]/div/div[2]/div[2]/div/div[2]/form/div[5]/div/div/div/i");
	String Status = "//span[contains(text(),'')]";
	By dontcalltoggle = By.xpath("//*[@id=\"ui\"]/div/div[2]/div[2]/div/div[2]/form/div[13]/div[2]/div/div/input");
	By day = By.name("day");
	By monthdropdown = By.xpath("//*[@id=\"ui\"]/div/div[2]/div[2]/div/div[2]/form/div[15]/div[1]/div/div/div[2]/i");
	String month = "//span[contains(text(),'')]";
	By year = By.name("year");

	public ContactsPage(WebDriver driver)
	{
		this.driver = driver;
		elementutils = new ElementUtils(driver);


	}

	public String getContactsPagetitle()
	{
		elementutils.waitforTitle(AppConstants.Home_Page_Title);
		return elementutils.getHeadertitle(headertitle);
	}

	public void doClickContacts()
	{
		elementutils.waitforElementVisible(ContactsClick);
		elementutils.doclick(ContactsClick);
	}

	public void doClickNewIcon()

	{
		//elementutils.waitforElementVisible(NewIconbutton);
		elementutils.doclick(NewIconbutton);
	}



	public DealsPage enterallfielddetails(String fname,String lname) 
	{
		elementutils.waitforElementPresent(firstname);
		elementutils.doSendKeys(firstname, fname);
		elementutils.waitforElementPresent(lastname);
		elementutils.doSendKeys(lastname, lname);
		elementutils.doclick(savebtn);
//		elementutils.waitforElementPresent(middlename);
//		elementutils.doSendKeys(middlename, midname);
//		elementutils.waitforElementPresent(email);
//		elementutils.doSendKeys(email, mail);
//		elementutils.waitforElementPresent(secondarymail);
//		elementutils.doSendKeys(secondarymail, pemail);
//		elementutils.waitforElementPresent(addanotheremail);
//		elementutils.doclick(addanotheremail);
//		elementutils.waitforElementPresent(email);
//		elementutils.doSendKeys(email, mail);
//		elementutils.waitforElementPresent(personalmail);
//		elementutils.doSendKeys(personalmail, pemail);
		//Thread.sleep(1000);
//		elementutils.doclick(categorydropdown);
//		elementutils.selectvaluefromdropdown(category, cate);
//		elementutils.doclick(statusdropdown);
//		elementutils.selectvaluefromdropdown(Status, stat);
//		javascriptutil.scrollPagedown(driver);
//		elementutils.waitforElementPresent(dontcalltoggle);
//		elementutils.doclick(dontcalltoggle);
//		elementutils.waitforElementPresent(day);
//		elementutils.doSendKeys(day, da);
//		elementutils.waitforElementPresent(monthdropdown);
//		elementutils.doclick(monthdropdown);
//		Thread.sleep(500);
//		elementutils.selectvaluefromdropdown(month, mont);
//		elementutils.waitforElementPresent(year);
//		elementutils.doSendKeys(year, yea);

       return new DealsPage(driver);



	}

	
		
	}






