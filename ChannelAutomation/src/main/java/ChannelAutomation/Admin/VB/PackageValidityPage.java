package ChannelAutomation.Admin.VB;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import Configurations.Constants;
import Configurations.GMethods;

public class PackageValidityPage 
{
	@FindBy(id="showCalFrom")
	public static WebElement CalFrom;
		
	@FindBy(id="showCalTo")
	public static WebElement CalTo;
	
	@FindBy(xpath="//table[@id='cal1']//div/a[3]")
	public static WebElement NextArrowForCal;
	
	@FindBy(xpath="//table[@id='calTo']//div/a[3]")
	public static WebElement NextArrowToCal;
	
	@FindBy(name="btnAddDateWise")
	public static WebElement save;
	
	@FindBy(xpath="//table[@id='cal1']//div/a[2]")
	public static WebElement FromCalDateYear;
	
	
	@FindBy(xpath="//table[@id='calTo']//div/a[2]")
	public static WebElement ToCalDateYear;
	
	@FindBy(id="calFromContainer_nav_month")
	public static WebElement FromCalMonth;
		
	
	@FindBy(id="calToContainer_nav_month")
	public static WebElement ToCalMonth;
	
	@FindBy(id="calFromContainer_nav_year")
	public static WebElement FromCalYear;
		
	@FindBy(id="calToContainer_nav_year")
	public static WebElement ToCalYear;
	
	@FindBy(id="calFromContainer_nav_submit")
	public static WebElement FromCalOk;
	
	
	@FindBy(id="calToContainer_nav_submit")
	public static WebElement ToCalOk;
		
	//Switch to New Window
	public void switchNewWindow()
	{
		try {
			GMethods.switchToNewWindow(PackageRate.adminWindowID);	
		} catch (Exception e) {
			System.out.println("Issue in Switch New Window"+e.getMessage());
		}
	}
	
	/**
	 * Save Package Validity
	 */
	public void saveValidity()
	{
		//Click On  Cal: From
		try {
			CalFrom.click();
		} catch (Exception e) {
			System.out.println("Issue in Click on Calendar"+e.getMessage());
		}
		//Select Today Date
		try {
			String calID = "cal1";
			int todayDate = Integer.parseInt(GMethods.getAddedDaysInTodayDate(0));
			int currMonth = Integer.parseInt(GMethods.getCurrentDateMonthYear().substring(0, 2));
			String currYear = GMethods.getCurrentDateMonthYear().substring(6, 10);
			
			//System.out.println("aa");
			
			FromCalDateYear.click();
			Select sel = new Select(FromCalMonth);
			sel.selectByIndex(currMonth-1);
			FromCalYear.sendKeys(currYear);
			FromCalOk.click();
				
			GMethods.selectDateInOpenCal(calID, todayDate);
									
		} catch (Exception e) {
			System.out.println("Issue in Select Today Date | "+e.getMessage());
		}
		
		//Click On To Cal
				
		try {
			CalTo.click();
		} catch (Exception e) {
			System.out.println("Issue in Click on Calendar To"+e.getMessage());
		}
		
		//Select Date in Can To Date
		try {
			String calID = "calTo";
			int nextDate = Integer.parseInt(GMethods.getAddedDaysInTodayDate(Constants.AddDays));
			int currMonth = Integer.parseInt(GMethods.getCurrentDateMonthYear().substring(0, 2));
			String currYear = GMethods.getCurrentDateMonthYear().substring(6, 10);
			
			int newDate;
			System.out.println("aa");
			int LastDate = GMethods.getMonthLastDate(currMonth);
			if (nextDate>LastDate) 
			{
				newDate = nextDate-LastDate;
				currMonth++;
				//nextPrevArrow.click();
				ToCalDateYear.click();
				
				Select sel = new Select(ToCalMonth);
				sel.selectByIndex(currMonth-1);
				ToCalYear.sendKeys(currYear);
				ToCalOk.click();
				
				GMethods.selectDateInOpenCal(calID, newDate);
				
									
			}else
			{
				newDate = nextDate;
				GMethods.selectDateInOpenCal(calID, newDate);
			}
			//String date = Integer.toString(newDate);
			
		} catch (Exception e) {
			System.out.println("Issue in Select "+e.getMessage());
		}
		
		/*
		//Select From Date
		try {
			int nextDate = Integer.parseInt(GMethods.getAddedDaysInTodayDate(10));
			int currMonth = Integer.parseInt(GMethods.getCurrentDateMonthYear().substring(0, 2));
			
			String calID = "calTo";
			GMethods.selectDateInCalender(calID, currMonth, nextDate, NextArrowToCal);
		} catch (Exception e) {
			System.out.println("Issue in Select "+e.getMessage());
		}
		*/ ////////////////////////////////////////////////////////////////////////////////////
		//Click Save
		try {
			save.click();
		} catch (Exception e) {
			System.out.println("Issue in Click Save"+e.getMessage());
		}
		
		
	}
}