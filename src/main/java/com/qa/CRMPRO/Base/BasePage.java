package com.qa.CRMPRO.Base;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

	public class BasePage {
		//need to distribute the driver equally and we use thread local and the threadlocal is for parallel execution.
		//thread local  is from java
		//WebDriver driver;
		Properties prop;
		OptionsManager optionsManager;
		

		public static ThreadLocal<WebDriver> tldriver = new ThreadLocal<WebDriver>();


		public static synchronized WebDriver getDriver()
		{
			return tldriver.get();
			//whenever we use the Threadlocal we need to use get and set method

			//whenever we use threadlocal it will use local copy of driver

		}





		public WebDriver init_driver(String browserName) {
			//highlighElement = prop.getProperty("highlight").equals("yes") ? true : false;
			System.out.println("browser name is: " + browserName);
			optionsManager = new OptionsManager(prop);

			if (browserName.equals("chrome")) {
				WebDriverManager.chromedriver().setup();
				// driver = new ChromeDriver(optionsManager.getChromeOptions());
				tldriver.set(new ChromeDriver(optionsManager.getChromeOptions()));
			}

//			else if (browserName.equals("firefox")) {
//				WebDriverManager.firefoxdriver().setup();
//				// driver = new FirefoxDriver(optionsManager.getFirefoxOptions());
//				tldriver.set(new FirefoxDriver(optionsManager.getFirefoxOptions()));
	//
//			} else if (browserName.equals("safari")) {
//				WebDriverManager.getInstance(SafariDriver.class).setup();
//				// driver = new SafariDriver();
//				tldriver.set(new SafariDriver());
//			}

			else {
				System.out.println("browser Name " + browserName + " is not found, please pass the correct browser");
			}

			getDriver().manage().deleteAllCookies();
			getDriver().manage().window().maximize();

			return getDriver();
		}

		public Properties init_properties() {
			prop = new Properties();
			String path = null;
			String env = null;
			try
			{
				env = System.getenv("env");
				if(env.equalsIgnoreCase("qaconfig"))
				{
					path = "C:\\Selenium\\Selenium_Workspace\\FreeCRMPRO\\src\\main\\java\\com\\qa\\FreeCRMPRO\\Config\\QAConfig.properties";
				}
				else if(env.equalsIgnoreCase("stageconfig"))
				{
					path = "C:\\Selenium\\Selenium_Workspace\\FreeCRMPRO\\src\\main\\java\\com\\qa\\FreeCRMPRO\\Config\\StageConfig.properties";
				}
			}
			catch(Exception e)
			{
				path = "C:\\Selenium\\Selenium_Workspace\\FreeCRMPRO\\src\\main\\java\\com\\qa\\FreeCRMPRO\\Config\\Config.properties";
			}

			try {
				FileInputStream ip = new FileInputStream(path);
				prop.load(ip);
			} catch (FileNotFoundException e) {
				System.out.println("some issue with config properties....Please correct your config...");
			} catch (IOException e) {
				e.printStackTrace();
			}

			return prop;
		}


		public String getScreenshot()
		{
			File src = 	((TakesScreenshot)getDriver()).getScreenshotAs(OutputType.FILE);
			String path = System.getProperty("user.dir")+"/Screenshots/"+System.currentTimeMillis()+".png";
			File destination = new File(path);

			try
			{
				FileUtils.copyFile(src, destination);

			}catch(Exception e)
			{
				System.out.println("screenshot captured failed");
			}

			return path;


		}
	}



