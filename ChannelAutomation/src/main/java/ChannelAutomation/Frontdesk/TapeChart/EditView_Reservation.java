package ChannelAutomation.Frontdesk.TapeChart;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ChannelAutomation.Admin.Base.AdminHomePage;
import Configurations.GMethods;

public class EditView_Reservation 
{
	@FindBy(name="btnSngResPayment")
	public static WebElement btn_Payment;
	
	public PaymentPage click_PaymentBtn()
	{
		try {
			btn_Payment.click();
			
			
		} catch (Exception e) {
			System.out.println("Issue in Click Payment Btn"+e.getMessage());
		}
		PaymentPage PP = PageFactory.initElements(GMethods.driver, PaymentPage.class);
		return PP;
	}

}
