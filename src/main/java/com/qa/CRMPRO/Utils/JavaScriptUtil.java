package com.qa.CRMPRO.Utils;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JavaScriptUtil {
	ElementUtils elementutils;
	public static String getTitleBYJS(WebDriver driver)
	//convert the driver to javascript executor
	{
		JavascriptExecutor js = (( JavascriptExecutor)(driver));
		//excute java script
		String title = js.executeScript("return document.title;").toString();
		return title;

	}


	public static void generateAlert(WebDriver driver,String msg)
	{
		JavascriptExecutor js = ((JavascriptExecutor)driver);
		js.executeScript("alert('"+ msg + "')");
	}

	public static void refreshBrowser(WebDriver driver)
	{
		JavascriptExecutor js = ((JavascriptExecutor)driver);
		js.executeScript("history.go(0)");
	}

	public static String getBrowserInfo(WebDriver driver)
	{
		JavascriptExecutor js = ((JavascriptExecutor)driver);
		String uAgent= js.executeScript("return navigator.userAgent;").toString();
		return uAgent;
	}

	public static void selectdatefromCalender(WebDriver driver,String value)
	{
		JavascriptExecutor js = ((JavascriptExecutor)driver);
		js.executeScript("document.getElementById('checkin').value='value'");
	}
	public static void sendKyesuJSWITHID(WebDriver driver,String id,String value)
	{
		JavascriptExecutor js = ((JavascriptExecutor)driver);
		js.executeScript("document.getElementById('"+id+"').value = '" + value + "'");


	}

	public static void clickElementByJS(WebDriver driver,List<WebElement> dropdownoptions)
	{
		
		JavascriptExecutor js = ((JavascriptExecutor)driver);
		js.executeScript("arguments[0].click();",dropdownoptions);

	}

	
	


	public static void drawaBorder(WebElement element,WebDriver driver)
	{
		JavascriptExecutor js = ((JavascriptExecutor)driver);
		js.executeScript("arguments[0].style.border='3px solid red'",element);


	}

	public static void flash(WebElement element,WebDriver driver)
	{
		JavascriptExecutor js = ((JavascriptExecutor)driver);
		String bgcolor = element.getCssValue("backgroundColor");
		for(int i=0;i<20;i++)
		{
			changecolor("rgb(0,200,0)",element,driver);
			changecolor(bgcolor,element,driver);
		}

	}

	public static String getPageInnertext(WebDriver driver)
	{
		JavascriptExecutor js = ((JavascriptExecutor)driver);
		String pagetext = js.executeScript("return document documentElement.innerText").toString();
		return pagetext;
	}

	public static void scrollPagedown(WebDriver driver)
	{
		JavascriptExecutor js = ((JavascriptExecutor)driver);
		js.executeScript("window.scrollTo(0,document.body.scrollHeight)");

	}

	public static void scrollIntoView(WebElement element,WebDriver driver)//scroll till the specific place
	{
		JavascriptExecutor js = ((JavascriptExecutor)driver);
		js.executeScript("arguments[0].scrollIntoView(true);",element);
	}

	private static void changecolor(String color,WebElement element,WebDriver driver)
	{
		JavascriptExecutor js = ((JavascriptExecutor)driver);
		js.executeScript("arguments[0].style.backgroundColor= '"+color+"'",element);

		try
		{
			Thread.sleep(20);
		}catch(Exception e)
		{
		}


	}

	public static void clickElementByJS(WebDriver driver,By locator,String value)
	{
		WebElement element = driver.findElement(locator);
		JavascriptExecutor js = ((JavascriptExecutor)driver);
		js.executeScript("arguments[0].click();",element);

	}







}



