package ChannelAutomation.Frontdesk.TapeChart;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Configurations.GMethods;

public class PaymentPage 
{
	@FindBy(xpath="//div[@id='PaymentDetail']//table[2]//tr/td//tr/td//tr/td")
	public static WebElement resID;
	
	@FindBy(id="BtnPaymentsClose")
	public static WebElement btn_Close;
	
	String reservationID;
	
	public FrontdeskGrid getReservationID()
	{
		try {
			String resId = resID.getText();
			reservationID = resId.substring(resId.indexOf(":")+1).trim();
			
			btn_Close.click();
			
			System.out.println("Reservation ID: "+reservationID);
		} catch (Exception e) {
			System.out.println("Issue in Get reservation ID and Close Res"+e.getMessage());
		}
		FrontdeskGrid FDG = PageFactory.initElements(GMethods.driver, FrontdeskGrid.class);
		return FDG;
	}

}
