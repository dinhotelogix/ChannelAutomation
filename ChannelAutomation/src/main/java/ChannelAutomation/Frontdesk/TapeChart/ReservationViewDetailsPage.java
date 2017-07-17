package ChannelAutomation.Frontdesk.TapeChart;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import ChannelAutomation.Reservations.BusyRoomsPushReservation;
import Configurations.GMethods;

public class ReservationViewDetailsPage 
{
	@FindBy(xpath="//tr[@class='gtoolbar1']/td//tbody/tr/td[3]/span")
	public static WebElement WebRefID;
	
	@FindBy(id="btnmainSRClose")
	public static WebElement btnCloseRes;
	//Get Web Ref ID and Match with the Reservation Pushed.
	public FrontdeskHomePage verifyReservation()
	{
		try {
			String actWebRefID = BusyRoomsPushReservation.ResID;
			String expWebRefID = WebRefID.getText().trim();
			
			btnCloseRes.click();			
			
			Assert.assertEquals(actWebRefID, expWebRefID);
		} catch (Exception e) {
			System.out.println("Issue in Matching Web Ref#"+e.getMessage());
			Assert.assertTrue(false);
		}
		FrontdeskHomePage FHP = PageFactory.initElements(GMethods.driver, FrontdeskHomePage.class);
		return FHP;
	}
}
