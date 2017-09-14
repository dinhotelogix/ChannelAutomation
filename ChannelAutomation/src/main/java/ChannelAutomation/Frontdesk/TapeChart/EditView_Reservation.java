package ChannelAutomation.Frontdesk.TapeChart;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ChannelAutomation.Admin.Base.AdminHomePage;
import Configurations.GMethods;

public class EditView_Reservation 
{
	@FindBy(name="btnSngResPayment")
	public WebElement btn_Payment;
	
	@FindBy(id="btnRsvCanceled")
	public WebElement btn_cancel_Res;
	
	@FindBy(id="txtCnclCharge")
	public WebElement cncl_charges;
	
	@FindBy(id="txtCnclDesc")
	public WebElement cncl_descr;
	
	@FindBy(id="btnResCanSave-button")
	public WebElement btn_cancelReservation;
	
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
	
	public PaymentPage cancel_reservation()
	{
		try {
			btn_cancel_Res.click();
			cncl_charges.clear();
			cncl_charges.sendKeys("100");
			cncl_descr.sendKeys("Cancellation Charges");
			btn_cancelReservation.click();
			GMethods.acceptAlert();
			
		} catch (Exception e) {
			System.out.println("Issue in Cancel Res"+e.getMessage());
		}
		PaymentPage PP = PageFactory.initElements(GMethods.driver, PaymentPage.class);
		return PP;
	}

}
