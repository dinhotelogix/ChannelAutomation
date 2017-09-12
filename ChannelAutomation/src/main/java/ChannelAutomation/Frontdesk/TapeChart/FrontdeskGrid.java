package ChannelAutomation.Frontdesk.TapeChart;

import java.util.List;

import javax.xml.xpath.XPath;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.testng.remote.strprotocol.GenericMessage;

import ChannelAutomation.Admin.Base.AdminHomePage;
import ChannelAutomation.Frontdesk.Login.FrontdeskLoginPage;
import Configurations.GMethods;

public class FrontdeskGrid 
{
	@FindBy(xpath="//a[text()='Current']")
	public static WebElement currentTab;
	
	@FindBy(xpath="//table[@id='cal1Container_t']//tbody/tr/td/a")
	public static List<WebElement> dates;
	
	@FindBy(xpath="//table[@id='main-menu-tbl']//a[text()='Logout ']")
	public static WebElement logout;
	
	public CreateReservation selectCurrentDateInCalender()
	{
				try {
					String TodayDate = GMethods.getCurrentDateMonthYear();
					String currDate = TodayDate.substring(3,5);
															
					GMethods.driver.manage().window().maximize();
										
					int size = dates.size();
					
					for(int i=0; i<size; i++)
					{
						if(dates.get(i).getText().equals(currDate))
						{
							dates.get(i).click();
							break;
						}
											
					}		
				} catch (Exception e) {
					System.out.println("Issue in Select To Date");
				}
				CreateReservation CR = PageFactory.initElements(GMethods.driver, CreateReservation.class);
				return CR;
	}
	
	public FrontdeskLoginPage logout_Frontdesk()
	{
		try {
			logout.click();
			GMethods.driver.switchTo().window(AdminHomePage.AdminWindowID);
		} catch (Exception e) {
			System.out.println("Issue in Logout"+e.getMessage());
		}
		FrontdeskLoginPage FLP = PageFactory.initElements(GMethods.driver, FrontdeskLoginPage.class);
		return FLP;
	}

}
