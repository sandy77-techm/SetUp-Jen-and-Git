package com.qa.CRMPRO.Base;

import java.util.Properties;

import org.openqa.selenium.chrome.ChromeOptions;


public class OptionsManager {
	public ChromeOptions co;
	public Properties prop;

	public OptionsManager(Properties prop)
	{
		this.prop = prop;
	}

	public ChromeOptions getChromeOptions()
	{
		co = new ChromeOptions();
		

		if (prop.getProperty("incognito").equals("yes")) co.addArguments("--incognito");
		if (prop.getProperty("headless").equals("yes")) co.addArguments("--headless");

		return co;
	}

	}

