package ChannelAutomation.Admin.VB;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import Configurations.Constants;
import Configurations.GMethods;

public class SaveAllotmentPage 
{
	@FindBy(id="showCalFrom")
	public static WebElement CalFromDate;
	
	@FindBy(xpath="//div[@id='calToContainer']//table//div//a[3]")
	public static WebElement CalNextArrow;
	
	@FindBy(id="showCalTo")
	public static WebElement CalToDate;
	
	@FindBy(id="noOfRooms")
	public static WebElement AssigAllotment;
	
	@FindBy(id="sbmtSave")
	public static WebElement SaveAllotment;
	
	
	
	//Verify Landing Page
	public void verifySaveAllotmentsPage()
	{
		try {
			String expTitle = "Add/Edit Allotment";
			String actTitle = GMethods.driver.getTitle();
			Assert.assertEquals(expTitle, actTitle);
			
		} catch (Exception e) {
			System.out.println("Issue in Switching to New Window"+e.getMessage());
		}
	}
	
	//Save Allotments
	public ManageAllotmentsPage saveAllotments()
	{
		//Click On From Calender
		try {
			CalFromDate.click();
		} catch (Exception e) {
			System.out.println("Issue In Calender From"+e.getMessage());
		}
		//Select Current Day Date
		try {
			System.out.println("a");
			String CalID = "cal1";
			int addDays = 0;
			String TodayDate = GMethods.getCurrentDateMonthYear();
			String currDate = TodayDate.substring(3,5);
			int datToSelect = addDays+Integer.parseInt(currDate);
			int currMonth = Integer.parseInt(TodayDate.substring(0,2));
			
			
			GMethods.selectDateInCalender(CalID, currMonth, datToSelect,CalNextArrow );
						
		} catch (Exception e) {
			System.out.println("Issue in Select To Date");
		}
		
		//Click On To Calender
		try {
			CalToDate.click();
			} catch (Exception e) {
			System.out.println("Issue In Calender To"+e.getMessage());
			}
		
		//Select To Date
		try {
			String CalID = "calTo";
			int addDays = Constants.AddDays;
			
			String TodayDate = GMethods.getCurrentDateMonthYear();
			String currDate = TodayDate.substring(3,5);
			int datToSelect = addDays+Integer.parseInt(currDate);
			int currMonth = Integer.parseInt(TodayDate.substring(0,2));
			
			
			
			GMethods.selectDateInCalender(CalID, currMonth, datToSelect, CalNextArrow );	
			} catch (Exception e) {
				System.out.println("Issue in Select To Date"+e.getMessage());	
			}
			
		//Select Allotment
		try {
			Select sel = new Select(AssigAllotment);
			String maxValue = Integer.toString(sel.getOptions().size()-1);
			
			sel.selectByValue(maxValue);
		} catch (Exception e) {
			System.out.println("Issue in Select From Drop-Down"+e.getMessage());
		}
		//Save Allotment
		try {
			SaveAllotment.click();
		} catch (Exception e) {
			System.out.println("Issue in Click Save Allotment"+e.getMessage());
		}
		
		ManageAllotmentsPage MAP = PageFactory.initElements(GMethods.driver, ManageAllotmentsPage.class);
		return MAP;
		
	}
	
}
