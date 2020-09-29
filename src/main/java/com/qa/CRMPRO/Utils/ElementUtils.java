package com.qa.CRMPRO.Utils;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.CRMPRO.Base.BasePage;

public class ElementUtils extends BasePage {

	 WebDriver driver;
	WebDriverWait wait;

	JavaScriptUtil javascriptutil;

	public ElementUtils(WebDriver driver)
	{
		this.driver= driver;
		wait = new WebDriverWait(driver,AppConstants.DEFAULT_TIMEOUT);
	}

	/**
	 * This method is used to create WebElement on the basis of By locator
	 * @param locator
	 * @return element
	 */
	//how to get a Element with BY locator 

	public WebElement getElement(By locator) {
		WebElement element = null;

		{
			try
			{
				//if(waitforElementPresent(locator));
				element = driver.findElement(locator);
				//if(highlightElement)
				//	{
				//javascriptutil.drawaBorder(element);//add it with if and else condition to do this
				//	}	
			}

			catch(Exception e)
			{
				System.out.println("Some Exception occured while creating the WebElement");
			}
			return element;
		}
	}

	public void doclick(By locator)
	{
		try
		{
			getElement(locator).click();
		}catch(Exception e)
		{
			System.out.println("Some Exception occured while returning the WebElement");
		}

	}

	public void doSendKeys(By locator,String value)
	{
		try
		{
			WebElement el = getElement(locator);
			el.clear();
			el.sendKeys(value);
		}catch(Exception e)
		{
			System.out.println("some exception occured while entering the value in the field");
		}
	}

	public void doSendKeyswithint(By locator,int val)
	{
		try
		{
			WebElement el = getElement(locator);
			String value = Integer.toString(val);
			el.clear();
			el.sendKeys(value);
		}catch(Exception e)
		{
			System.out.println("some exception occured while entering the value in the field");
		}
	}
	public String doGettext(By locator)
	{try
	{
		return getElement(locator).getText();
	}catch(Exception e)
	{
		System.out.println("some exception occured while getting a text from a element");
	}
	return null;//if there is a exception then return as null
	}


	public String  doGetPageTitle()
	{
		try
		{
			return driver.getTitle();
		}catch(Exception e)
		{
			System.out.println("Some Exception occured while creating the title");
		}

		return null;
	}

	public List<WebElement> getListofElements(By locator)
	{
		List<WebElement> element = null;
		try
		{
			element = driver.findElements(locator);
		}catch(Exception e)
		{
			System.out.println("Some Exception occured while creating web elements");
		}
		return element;
	}

	public void doclickRadiobutton(By locator)
	{
		String valueofGender="2";
		List<WebElement> element ;
		element = getListofElements(locator);
		System.out.println("Total no of radio buttons for gender field:"+element.size());
		for(int i=0;i<element.size();i++)
		{
			String gender = element.get(i).getAttribute("value");
			if(gender.equalsIgnoreCase(valueofGender))
			{
				element.get(i).click();
				break;
			}
		}

	}

	public void doWaitforElement(By locator)
	{
		WebDriverWait wait = new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
	}

	public void doWaitforElements(String locator)
	{
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
	}


	public boolean waitforElementVisible(By locator)
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		return true;
	}


	public boolean waitforElementPresent(By locator)
	{
		try
		{wait.until(ExpectedConditions.presenceOfElementLocated(locator));


		}catch(Exception e)
		{
			System.out.println("The Element is not present");
		}
		return true;
	}

	public boolean AlertMessage(String msg) {
		Alert alert = driver.switchTo().alert();
		String text = alert.getText();
		System.out.println("Print the Alert Msg:"+ text);
		if(text.equalsIgnoreCase(msg))
		{
			alert.accept();
		}
		return true;
	}

	public String getHeadertitle(By locator)
	{
		return getElement(locator).getText();
	}


	public void selectvaluefromdropdown(String locator,String value)
	{

		List<WebElement> options = driver.findElements(By.xpath(locator));

		System.out.println("Display the No of options in the Category list:"+ options);

		for(int i=0;i<options.size();i++)
		{
			if(options.get(i).getText().equals(value))
			{
				options.get(i).click();
				break;
			}
		}

	}

	public boolean waitforTitle(String title)
	{
		wait.until(ExpectedConditions.titleIs(title));
		return true;

	}

	public void waitforclickingElement(final By locator)
	{
		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(30))
				.pollingEvery(Duration.ofSeconds(5))

				.ignoring(NoSuchElementException.class);

		WebElement opt = wait.until(new Function<WebDriver,WebElement>()
		{
			public WebElement apply(WebDriver driver)
			{
				return driver.findElement(locator);
			}
		});

		opt.click();

	}

	
	public void clickonCalender(By locator,String value)
	{
		//					//Select date
	List<WebElement> columns = driver.findElements(locator);
	columns.clear();
			String[] eledate = value.split("/");
			for(WebElement ele:columns)
			{
				
				String date = ele.getText();
				if(date.equals(eledate))
				{
					ele.click();
					break;
				}
				
//				//time
//				List<WebElement> time = driver.findElements(By.xpath("//li[@class='react-datepicker__time-list-item ']"));
//				
//				for(WebElement el1:time)
//				{
//					String time1 = el1.getText();
//					if(time1.equalsIgnoreCase("01:30"))
//					{
//						el1.click();
//						break;
//					}
//				}
		}
			
		}
	   // String[] vals = value.split("/");
//
//		for(WebElement ele:columns)
//		{
//			String date = ele.getText();
//			if(date.equalsIgnoreCase(value))
//			{
//				ele.click();
//				break;
//			}
//		}
	
	


	//	public void PageNavigation(By locator,String value)
	//	{
	//		List<WebElement> pagenation = driver.findElements(locator);
	//
	//		for(int i=0;i<pagenation.size();i++)
	//		{
	//			String title = pagenation.get(i).getAttribute(value);
	//			if(title.equalsIgnoreCase(value))
	//			{
	//				pagenation.get(i).click();
	//				break;
	//			}
	//		}
	//
	//
	//	}

	public void Validationmsg(By locator,String msg)
	{
		WebElement element =	getElement(locator);

		String text = element.getText();
		//System.out.println("Validation msg :"+ text);
		if(text!=null && text.equalsIgnoreCase(msg))


		{
			System.out.println("Pass Alert message appears correctly");
		}
		else
		{
			System.out.println("Alert message does not appear correctly");
		}
	}


//	public void pagination(By locator)
//	{
//
//		String pagination = driver.findElement(locator).getText();
//		String[] split = pagination.split("\\s");
//		for(int i=0;i<split.length;i++)
//		{
//
//		}
//		System.out.println(split[2]);
//		int intialvalue = Integer.parseInt(split[2]);
//		System.out.println(split[4]);
//		WebElement next = driver.findElement(locator);
//		next.click();
//		String nextbutton = next.getText();
//		String[] splitnext = nextbutton.split("\\s");
//
//		for(int i=0;i<split.length;i++)
//		{
//
//		}
//		System.out.println(splitnext[2]);
//		int nextvalue = Integer.parseInt(split[2]);
//		if((intialvalue+1)==(nextvalue))
//		{
//			System.out.println("Pass next button pagenation");
//		}
//		else
//		{
//			System.out.println("Fail next button pagenation");
//		}
//		//last button
//		WebElement lastbutton = driver.findElement(locator);
//		String last = lastbutton.getText();
//		String [] splitlast = last.split("\\s");
//		for(int i=0;i<split.length;i++)
//		{
//		}
//		System.out.println(splitlast[2]);
//		int lastvalue = Integer.parseInt(splitlast[2]);
//		System.out.println(splitlast[4]);
//		int finalvalue = Integer.parseInt(splitlast[4]);
//
//		if((lastvalue)==(finalvalue))
//		{
//			System.out.println("Pass last button pagenation");
//		}
//		else
//		{
//			System.out.println("Fail last button pagenation");
//		}
//
//		WebElement prevbtn = driver.findElement(locator);
//		String previous = prevbtn.getText();
//		String [] splitprevious = previous.split("\\s");
//		for(int i=0;i<split.length;i++)
//		{
//		}
//		System.out.println(splitprevious[2]);
//		int previousvalue = Integer.parseInt(splitprevious[2]);
//		System.out.println(splitprevious[4]);
//
//		int finalvalue1 = Integer.parseInt(splitprevious[4]);
//
//		if((previousvalue)==(finalvalue-1))
//		{
//			System.out.println("Pass previous button pagenation");
//		}
//		else
//		{
//			System.out.println("Fail previous button pagenation");
//		}
//		//first button
//
//		WebElement firsts = driver.findElement(locator);
//		String first = firsts.getText();
//
//		String [] splitfirst = first.split("\\s");
//		for(int i =0;i<split.length;i++)
//		{
//		}
//		System.out.println(splitfirst[2]);
//		int firstvalue = Integer.parseInt(splitfirst[2]);
//
//		if((firstvalue==1))
//		{
//			System.out.println("Pass first pagenation button");
//		}
//		else
//		{
//			System.out.println("First pagenation button");
//		}
//
//	}


	public void multiselectdropdown(By locator,String value) { 
	    String[] valueTemp = value.split(",");
	    for(int i=0;i<valueTemp.length;i++) { 
	        List<WebElement> dropdownoptions = driver.findElements(locator); 
	        for(int j=0; j<dropdownoptions.size(); j++) {
	            String text = dropdownoptions.get(j).getText();
	            try { 
	                if(!text.isEmpty()) { 
	                    if(text.equalsIgnoreCase(valueTemp[i])) { 
	                        dropdownoptions.get(j).click(); 
	                        break; 
	                    } 
	                } 
	            }catch (Exception e) { }
	        }
	    }
	}

	
	public static void waitforElementnotvisible(By locator,WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver,160);
	    wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
	}

	}
		


	














