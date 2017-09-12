package ChannelAutomation.Frontdesk.TapeChart;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Configurations.Constants;
import Configurations.GMethods;

public class CreateReservation 
{
	int i=Constants.fromDate_ResAddDays;
	
	@FindBy(xpath="//div[@id='rt_2109']/div[3]")
	public static WebElement DragFrom;
	
	@FindBy(id="qrTxtFirstName")
	public static WebElement firstName;
	
	@FindBy(id="qrTxtLastName")
	public static WebElement lastName;
	
	@FindBy(id="qrTxtPhone")
	public static WebElement phoneNo;
	
	@FindBy(id="lnkQResFormSingleEnab")
	public static WebElement linkSingle;
	
	public EditView_Reservation createSingleNightRes()
	{
		try {
			Thread.sleep(2500);
			GMethods.dragDropOnFrontdeskTapechart(DragFrom, 1);
			Thread.sleep(2500);
			firstName.sendKeys("Deenu");
			lastName.sendKeys("Singh");
			phoneNo.sendKeys("9876543210");
			
			linkSingle.click();
		} catch (Exception e) {
			System.out.println("Issue In DragandDrop"+e.getMessage());
		}
		
		EditView_Reservation EVR = PageFactory.initElements(GMethods.driver, EditView_Reservation.class);
		return EVR;
	}

}
