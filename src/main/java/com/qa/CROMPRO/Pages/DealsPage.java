package com.qa.CROMPRO.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.CRMPRO.Base.BasePage;
import com.qa.CRMPRO.Utils.ElementUtils;
import com.qa.CRMPRO.Utils.JavaScriptUtil;

public class DealsPage extends BasePage{
	WebDriver driver;
	ElementUtils elementutils;
	JavaScriptUtil javascriptutil;

	By DealsLink = By.xpath("//span[text()='Deals']");

	By NewIcon = By.xpath("//button[text()='New']");

	By title = By.name("title");

	By AssignedTodropdown = By.xpath("//*[@id=\"ui\"]/div/div[2]/div[2]/div/div[2]/form/div[2]/div[1]/div/div/i");

	String AssignedDropdownlistselection ="//*[@id=\"ui\"]/div/div[2]/div[2]/div/div[2]/form/div[2]/div[1]/div/div/div[2]/div/span";

	By description = By.name("description");
	By probability = By.name("probability");
	By amount = By.name("amount");
	By Stagedropdownclick = By.name("stage");
	String Stageselectionvalue = "//div[@role='option']/span[contains(text(),'')]";
	By Closedtoggle = By.xpath("//*[@id=\"ui\"]/div/div[2]/div[2]/div/div[2]/form/div[9]/div[1]/div/div");
	By statusdropdownclick = By.name("status");
	String statusselectionvalue = "//span[contains(text(),'')]";
	By nextstep = By.name("next_step");
	By type = By.name("type");
	String typeselectionvalue = "//span[contains(text(),'')]";
	By sourcedropdown = By.name("source");
	String sourceselectionvalue = "//span[contains(text(),'')]";
	By identifier = By.name("identifier");
	By save = By.xpath("//button[@class='ui linkedin button']");
	By Edit = By.xpath("//*[@id=\"dashboard-toolbar\"]/div[2]/div/a[1]/button/i");
	By showpendingalerts = By.xpath("//i[@class='bell outline icon']");
	By calender = By.className("calendarField");
	By selectdatefromcalender = By.xpath("//div[@class='react-datepicker__week']/div");
	By selecttimefromcalender = By.xpath("//li[@class='react-datepicker__time-list-item ']");
	By Alertviadropdownclick = By.xpath("/html/body/div[3]/div/div[2]/div/div/div[1]/form/div/div[2]/div/i");
	String alertviadropdownvalue = "//span[contains(text(),'')]";
	By note = By.xpath("//input[@name='note']");
	By Createalert = By.xpath("//button[@class='ui green button']");
	By closependingalert = By.xpath("//button[@class='ui left floated button']");

	By AddEventbutton = By.cssSelector("#dashboard-toolbar > div.ui.right.secondary.pointing.menu.toolbar-container > div > a:nth-child(4) > button");

	By eventtitle = By.xpath("//input[@name='title']");
	By Calenderdropdownclick = By.xpath("//div[@name='calendar']");
	String calendervalueselection = "//span[contains(text(),'')]";
	By addnewCalenderName = By.name("calendarName");
	By savecalendername =By.xpath("/html/body/div[3]/div/div[3]/button[2]");
	By Startdateclick = By.xpath("//input[@class='calendarField']");
	By startdatecolumselection = By.xpath("//div[@class='react-datepicker__week']/div");
	By enddateclick = By.xpath("//*[@id=\"ui\"]/div/div[2]/div[2]/div/div[2]/form/div[2]/div[2]/div/div/div/input");
	By enddatecolumnselection= By.xpath("//div[@class='react-datepicker__week']/div");
	By categoryEvent = By.xpath("//div[@name='category']");
	String categoryEventvalue = "//span[contains(text(),'')]";
	By Description = By.name("description");
	By location = By.name("location");
	By alldaytoggle = By.cssSelector("#ui > div > div.ui.fluid.container > div.ui.fluid.container > div > div.ui.fluid.container.main-content > form > div:nth-child(8) > div:nth-child(1) > div > div > input");
	By DealSearchicon = By.xpath("//*[@id=\"ui\"]/div/div[2]/div[2]/div/div[2]/form/div[8]/div[2]/div/div/i");
	String dealsdropdownselection = "//span[contains(text(),'')]";
	By Alertbefore = By.xpath("//*[@id=\"ui\"]/div/div[2]/div[2]/div/div[2]/form/div[10]/div[1]/div/div/div[1]/div/i");
	String Alertbeforevalue = "//span[contains(text(),'')]";
	By Alertviadropdown = By.xpath("//*[@id=\"ui\"]/div/div[2]/div[2]/div/div[2]/form/div[10]/div[1]/div/div/div[2]/div/i");
	String Alertviadropdownvalue = "//span[contains(text(),'')]";
	By remindertime = By.name("//span[contains(text(),'')]");
	By Assignedto = By.xpath("//*[@id=\"ui\"]/div/div[2]/div[2]/div/div[2]/form/div[11]/div[1]/div/div/i");
	String Assignedtovalueselection = "//span[contains(text(),'')]";
	By Recurrenceset = By.xpath("//*[@id=\"ui\"]/div/div[2]/div[2]/div/div[2]/form/div[12]/div[2]/div/div/a");
	By intervaldropdownlick = By.name("freq");
	String intervalvalueselect = "//span[contains(text(),'')]";
	By days = By.name("weekdays");
	String daysvalueselect ="//span[contains(text(),'')]";
	By Endat = By.xpath("/html/body/div[3]/div/div[2]/form/div[4]/div[2]/div/div/input");
	By selectdate = By.xpath("//div[@class='react-datepicker__week']/div");
	By setbutton = By.xpath("/html/body/div[3]/div/div[3]/button[2]");
	By saveevent = By.xpath("//*[@id=\"dashboard-toolbar\"]/div[2]/div/button[2]");

	By AddNoteslink = By.xpath("//*[@id=\"dashboard-toolbar\"]/div[2]/div/button[2]/i");
	By AddinfoinNotes = By.xpath("/html/body/div[3]/div/div[2]/form/textarea");
	By Cancelnotes = By.xpath("//i[@class='remove icon']");
	By SaveNotes = By.xpath("//button[@class='ui green button']");

	By deletedealsbutton = By.xpath("//i[@class='trash icon']");
	By deletemsg = By.xpath("/html/body/div[3]/div/div[2]/div/div");
	By deletedeals= By.xpath("//button[@class='ui red button']");

	By pagination = By.xpath("//div[@class='ui right floated pagination menu custom-pagination']");
	By nextbutton = By.xpath("//i[@class='right chevron icon']");
	By lastvalue = By.xpath("//*[@id=\"ui\"]/div/div[2]/div[2]/div/div[2]/table/tfoot/tr/th[2]/div[2]/a[11]/text()");
	By previousbtn = By.xpath("//*[@id=\"ui\"]/div/div[2]/div[2]/div/div[2]/table/tfoot/tr/th[2]/div[2]/a[1]");

	By managetargets = By.xpath("//*[@id=\"dashboard-toolbar\"]/div[2]/div/a[2]/button");
	By createtargets = By.xpath("//*[@id=\"dashboard-toolbar\"]/div[2]/div/a[2]/button");
	By AssignedToClick =By.xpath("//*[@id=\"ui\"]/div/div[2]/div[2]/div/div[2]/form/div[1]/div[1]/div/i");
	String assingedtoselectvalue = "//span[contains(text(),'')]";
	By typeclick = By.xpath("//*[@id=\"ui\"]/div/div[2]/div[2]/div/div[2]/form/div[1]/div[2]/div/i");
	String typevalueselection = "//span[contains(text(),'')]";
	By periodclick = By.xpath("//*[@id=\"ui\"]/div/div[2]/div[2]/div/div[2]/form/div[2]/div[1]/div/i");
	String periodvalueselect = "//span[contains(text(),'')]";
	By value = By.xpath("//input[@name='value']");
	By Activecheckbox = By.xpath("//input[@name='active']");
	By recurrercheckbox = By.xpath("//input[@name='recurrence']");
	By savetargets = By.xpath("//*[@id=\"dashboard-toolbar\"]/div[2]/div/button[2]");


	By pipeline = By.xpath("//button[contains(text(),'Pipeline')]");
	By Selectfieldsdropdownclick = By.cssSelector("body > div.ui.page.modals.dimmer.transition.visible.active > div > div.content > div > div > div.ten.wide.column > form > div:nth-child(2) > div:nth-child(1) > div > i");
	By selectfieldsvalueselection = By.xpath("//div[@class='visible menu transition']/div/span");
	By addbutton = By.xpath("//button[@class='ui basic button']");
	By selectfieldsdropdownclick1 = By.cssSelector("body > div.ui.page.modals.dimmer.transition.visible.active > div > div.content > div > div > div.ten.wide.column > form > div:nth-child(3) > div:nth-child(1) > div > i");
	By savepipelineas = By.name("pipeline_name");
	By clickcheckbox = By.name("save_filter");
	By createpipeline = By.xpath("/html/body/div[3]/div/div[3]/button[1]");

	By showfilters = By.xpath("//*[@id=\"dashboard-toolbar\"]/div[2]/div/button[2]");
	By selectsearchdropdown = By.xpath("//*[@id=\"ui\"]/div/div[2]/div[2]/div/div[2]/form/div[2]/div/div/div[1]/div/i");
	String selectvalueserachdropdown = "//div[@class='visible menu transition']/div/span";

	public DealsPage(WebDriver driver)
	{
		this.driver = driver;
		elementutils = new ElementUtils(driver);
	}

	public void clickDealslink()
	{
		//elementutils.waitforElementPresent(DealsLink);
		elementutils.doclick(DealsLink);

	}

	public void clickNewIcon()
	{
		elementutils.waitforElementPresent(NewIcon);
		elementutils.doclick(NewIcon);
	}

	//	public void pagenation()
	//	{
	//		elementutils.PageNavigation(pagenation, value);
	//	}

	public void enterallDealsInfo(String tit,String assign,String desc,String prop,String amt,String stgval,String ntstep, String stat,String typ,String src,String id) throws InterruptedException
	{


		elementutils.waitforElementVisible(title);
		elementutils.doSendKeys(title, tit);
		elementutils.waitforElementPresent(AssignedTodropdown);
		elementutils.doclick(AssignedTodropdown);
		elementutils.waitforElementPresent(AssignedTodropdown);

		elementutils.selectvaluefromdropdown(AssignedDropdownlistselection, assign);
		elementutils.waitforElementPresent(description);
		elementutils.doSendKeys(description, desc);
		elementutils.waitforElementPresent(probability);
		elementutils.doSendKeys(probability, prop);
		elementutils.waitforElementPresent(amount);
		elementutils.doSendKeys(amount, amt);
		elementutils.waitforElementPresent(Stagedropdownclick);
		elementutils.doclick(Stagedropdownclick);
		elementutils.selectvaluefromdropdown(Stageselectionvalue, stgval);
		elementutils.waitforElementPresent(Closedtoggle);
		elementutils.doclick(Closedtoggle);
		elementutils.waitforElementPresent(statusdropdownclick);
		elementutils.selectvaluefromdropdown(statusselectionvalue, stat);
		elementutils.waitforElementPresent(nextstep);
		elementutils.doSendKeys(nextstep, ntstep);
		elementutils.waitforElementPresent(type);
		elementutils.selectvaluefromdropdown(typeselectionvalue, typ);
		elementutils.waitforElementPresent(sourcedropdown);
		elementutils.selectvaluefromdropdown(sourceselectionvalue, src);
		elementutils.waitforElementPresent(identifier);
		elementutils.doSendKeys(identifier, id);
		elementutils.waitforElementPresent(save);
		elementutils.doclick(save);



	}
	}