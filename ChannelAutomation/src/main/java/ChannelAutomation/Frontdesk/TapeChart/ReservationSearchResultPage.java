package ChannelAutomation.Frontdesk.TapeChart;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Configurations.GMethods;

public class ReservationSearchResultPage 
{
	@FindBy(xpath="//table[@id='roomPoTableId']//tr[2]/td[2]")
	public static WebElement clickReservation;
	
	public ReservationViewDetailsPage openReservation()
	{
		try {
			clickReservation.click();
		} catch (Exception e) {
			System.out.println("Issue in Open Searched Reservation"+e.getMessage());
		}
		ReservationViewDetailsPage RVDP = PageFactory.initElements(GMethods.driver, ReservationViewDetailsPage.class);
		return RVDP;
	}
}