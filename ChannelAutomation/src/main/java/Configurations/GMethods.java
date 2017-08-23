package Configurations;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import net.sourceforge.htmlunit.corejs.javascript.regexp.SubString;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;

public class GMethods 
{
	public static WebDriver driver;
	
	//Launch Browser as per Parameter type
	public static void lounchBrowserAndUrl(String browser, String url)
	{
		try{				
			if(browser.equalsIgnoreCase(browser))
			{
				//System.setProperty("webdriver.gecko.driver", "E:\\Software\\Firefox\\geckodriver-v0.15.0-win64\\geckodriver.exe");
				DesiredCapabilities dc=DesiredCapabilities.firefox();
				//DesiredCapabilities dc = new DesiredCapabilities();
				dc.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.IGNORE);
								
				System.out.println("");
				driver=new FirefoxDriver(dc);
				driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
				driver.get(url);
			}
			else if(browser.equalsIgnoreCase("IE"))
			{				
				driver=new InternetExplorerDriver();
			}
			else if(browser.equalsIgnoreCase("CH"))
			{
				System.setProperty("webdriver.chrome.driver", "E:\\Software\\Chrome\\chromedriver.exe");
				driver=new ChromeDriver();
			}
			
			int implicitWaitTime=(15);
			driver.manage().timeouts().implicitlyWait(implicitWaitTime, TimeUnit.SECONDS);
		}catch (Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
	
	//Object Repository
	/*
	public static Properties OR() throws IOException
	{
		//BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(Constants.Path_OR)));
		FileInputStream fis = new FileInputStream(new File(Constants.Path_OR));
		Properties pro = new Properties();
		pro.load(fis);
		return pro;
	}
*/
	//<<<-------------Alert------------------>>>
	public static void alertHandel()
	{
		Alert alert = driver.switchTo().alert();
		alert.accept();	
	}
		
	//-------------JS Click--------------------
	public static void jsClick(WebElement ele)
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", ele);
	}
		
		//-------------Select By Visible Text--------------
		public static void selectByVisibleText(WebElement ele, String text)
		{
			Select select = new Select(ele);
			select.selectByVisibleText(text);
		}
		
		//-------------Select By Value--------------
		public static void selectByValue(WebElement ele, String value)
		{
			Select select = new Select(ele);
			select.selectByValue(value);
		}
		//-------------Select By Index--------------
		public static void selectByIndex(WebElement ele, int index)
		{
			Select select = new Select(ele);
			select.selectByIndex(index);
		}
		
		/**
		 * Will Switch To New Window, Need to Pass Old Window ID
		 * @param currWindowID
		 */
		public static void switchToNewWindow(String currWindowID)
		{
			Set<String> AllWindowsID  = driver.getWindowHandles();
			//String currentWindowHandle = driver.getWindowHandle();
			for (String WindowID : AllWindowsID) 
			{
				if(WindowID.equalsIgnoreCase(currWindowID))
				{
					continue;
				}else
				{
					driver.switchTo().window(WindowID);
				}
			}
		}
		
		//Switch back to previous Window
		public static void switchToWindow(String currWindowID)
		{
			driver.switchTo().window(currWindowID);
		}
		
		/**
		 * Get Current Month/Date/Year in MM/dd/yyyy 
		 */
		public static String getCurrentDateMonthYear()
		{
			String date;
			try {
				DateFormat DF = new SimpleDateFormat("MM/dd/yyyy ");
				Date date1 = new Date();
				date= DF.format(date1);
				return date;
				} 
			catch (Exception e) 
			{
				System.out.println("Issue in Getting Current Date"+e.getMessage());
				return null;
			}	
		}
		
		/**
		 * Get Added days in current Year-Month-Date(yyyy-MM-dd), 
		 * It will increase month if Added date exceed from Last Date of Curr Month
		 */
		public static String getAddedCurrentYearMonthDate(int days)
		{
			String date;
			
			try {
				DateFormat DF = new SimpleDateFormat("yyyy-MM-dd ");
				Date date2 = new Date();
				String date3= DF.format(date2);
				
				String date4 = date3.substring(8, 10);
				int dateToSelect = Integer.parseInt(date4)+days;
				
				String currMonth = date3.substring(5,7);
				int mon = Integer.parseInt(currMonth);
				int LastDate = getMonthLastDate(mon);
				
				int newDate=0;
				
				if (dateToSelect>LastDate) 
				{
					newDate = dateToSelect-LastDate;
					//CurrMonth++;
					mon++;
														
				}else
				{
					newDate = dateToSelect;
				}
								
				//int date5 = Integer.parseInt(date4)+days;
				//Need to Add 0 if Date is less than 9 to make -MM-dd format
				String date6;
				if(newDate<=9)
				{
					date6 = "0"+Integer.toString(newDate);
				}else {
					date6 = Integer.toString(newDate);
				}
				
				String mon1;
				if(mon<=9)
				{
					mon1 = "0"+Integer.toString(mon);
				}else {
					mon1 = Integer.toString(mon);
				}
				//String mon1 = Integer.toString(mon);
				
				date = date3.substring(0,4)+"-"+mon1+"-"+date6;
				return date;
				
				////////////////////////////////////////////
				/*int newDate;
				//System.out.println("aa");
				int LastDate = getMonthLastDate(CurrMonth);
				if (dateToSelect>LastDate) 
				{
					newDate = dateToSelect-LastDate;
					//CurrMonth++;
					nextPrevArrow.click();
					
										
				}else
				{
					newDate = dateToSelect;
				}*/
				///////////////////////////////////////////
				
				
				} 
			catch (Exception e) 
			{
				System.out.println("Issue in Getting Current Date"+e.getMessage());
				return null;
			}	
		}
		
		/**
		 * You can get Current Date by passing 0 in added days 
		 * If you want a few days later date from current date, pass a number in Added Days as parameter
		 * @param addedDays
		 * @return Date
		 */
		public static String getAddedDaysInTodayDate(int addedDays)
		{
			try {
				String date1= getCurrentDateMonthYear();
				//System.out.println(date1);
				String day = date1.substring(3, 5);
				
				int i = Integer.parseInt(day);
				String nextDay = Integer.toString(i+addedDays);
				
				return nextDay;
								
			} catch (Exception e) {
				System.out.println("Issue in Get Current Dat"+e.getMessage());
				return "";
			}
		}
		
		
		
		/**
		 * Select Calendar Date from Calendar
		 * @param calID : Calendar ID
		 * @param tagName 
		 * @param addDays : How many Days needs to be added
		 */
		
		public static void selectDateInCalender(String calID,int CurrMonth, int dateToSelect, WebElement nextPrevArrow)
		{
			try {
				int newDate;
				//System.out.println("aa");
				int LastDate = getMonthLastDate(CurrMonth);
				if (dateToSelect>LastDate) 
				{
					newDate = dateToSelect-LastDate;
					//CurrMonth++;
					nextPrevArrow.click();
					
										
				}else
				{
					newDate = dateToSelect;
				}
				String date = Integer.toString(newDate);
				
				WebElement ele = driver.findElement(By.id(calID));
				List<WebElement> dates = ele.findElements(By.tagName("a"));
				for(WebElement cell : dates)
				{
					if (cell.getText().equals(date)) 
					{
						cell.click();
						break;
					}
				}
			} catch (Exception e) {
				System.out.println("Issue in Select From Date");
			}
		}
		
		/**
		 * Select Date In Open Canendar
		 * @param calID
		 * @param newDate
		 * @throws InterruptedException 
		 */
		public static void selectDateInOpenCal(String calID, int newDate) throws InterruptedException {
			String date = Integer.toString(newDate);
			
			WebElement ele = driver.findElement(By.id(calID));
			List<WebElement> dates = ele.findElements(By.tagName("a"));
			for(WebElement cell : dates)
			{
				if (cell.getText().equals(date)) 
				{
					Thread.sleep(500);
					cell.click();
					//System.out.println("");
					break;
				}
			}
		}
		
		/**
		 * Get Month Last Date
		 * 
		 * @return will Return Last Date of Month
		 */
		public static int getMonthLastDate(int month)
		{
			int lastDate=0;
			try {
				
				switch(month)
				{
				case 1: lastDate=31;
				break;
				
				case 2: lastDate=28;
				break;
				
				case 3: lastDate=31;
				break;
				
				case 4: lastDate=30;
				break;
				
				case 5: lastDate=31;
				break;
				
				case 6: lastDate=30;
				break;
				
				case 7: lastDate=31;
				break;
				
				case 8: lastDate=31;
				break;
				
				case 9: lastDate=30;
				break;
				
				case 10: lastDate=31;
				break;
				
				case 11: lastDate=30;
				break;
				
				case 12: lastDate=31;
				break;
				
				}
			} catch (Exception e) {
				System.out.println("Issue in Getting Month"+e.getMessage());
			}
			return lastDate;
		}
		
		//Select from Drop-down
		public static void SelectByValue(WebElement ele,String val)
		{
			try {
				Select sel = new Select(ele);
				sel.selectByValue(val);
			} catch (Exception e) {
				System.out.println("Issue in Select from Drop-down"+e.getMessage());
			}			
		}
		
		/**
		 * Accept Alert 
		 */
		public static void acceptAlert()
		{
			try {
				Alert alert = driver.switchTo().alert();
				alert.accept();
			} catch (Exception e) {
				System.out.println("Issue in Accept Alert"+e.getMessage());
				
			}
		}
		/**
		 * Get Random Number between 1 to 1000
		 */
		public static int getRandomNumber(int min, int max)
		{
			try {
			Random rn = new Random();
			int ranNumber = rn.nextInt((max-min)+min);
			return ranNumber;
			} catch (Exception e) {
				return 1;
			}
			//return ranNumber;
		}
		
		/**
		 *To Generate a Random Unique number using Current Year/Month/Date/Hour/Minute/Second 
		 */
		public static String getUniqueNumber()
		{
			String dateTime;
			try {
				Date date = new Date();
				SimpleDateFormat ft = new SimpleDateFormat("yyMMddhhmmss");
				dateTime = ft.format(date);
								
			} catch (Exception e) {
				dateTime = "Null";
				e.getMessage();
			}
			return dateTime;
		}
		 
		
		
}