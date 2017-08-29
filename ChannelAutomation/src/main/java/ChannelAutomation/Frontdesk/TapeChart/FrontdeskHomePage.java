package ChannelAutomation.Frontdesk.TapeChart;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import ChannelAutomation.Frontdesk.Login.FrontdeskLoginPage;
import ChannelAutomation.Reservations.BusyRoomsPushReservation;
import Configurations.GMethods;

public class FrontdeskHomePage 
{
	@FindBy(xpath="//input[@value='Cancel']")
	public static WebElement cancel;
	
	@FindBy(id="txtResFrndLookup")
	public static WebElement txtbxSearch;
	
	@FindBy(id="txtResFrndLookupAllChk")
	public static WebElement chkbxSearchAll;

	@FindBy(id="txtResFrndLookupAllBtn-button")
	public static WebElement btnSearchAll;
	
	@FindBy(xpath="//a[text()='Logout ']")
	public static WebElement frontdeskLogout;
		
	//Click Cancel On Perform Night Audit window
	public void clickCancel()
	{
		try {
			GMethods.jsClick(cancel);
			
			GMethods.acceptAlert();
			
			Assert.assertTrue(true);
		} catch (Exception e) {
			System.out.println("Issue in Click Cancel on Perform Night Audit window"+e.getMessage());
			Assert.assertTrue(false);
		}
		
	}
	
	//Search Reservation On Frontdesk
	public ReservationSearchResultPage searchResOnFrontdesk()
	{
		//Get Channel Res ID and Put into seach text box 
		try {
			String webRefID = BusyRoomsPushReservation.ResID;
			txtbxSearch.sendKeys(webRefID);
		} catch (Exception e) {
			System.out.println("Issue in Input Channel Res ID"+e.getMessage());
		}
		//Click on Check Box and Click Search All
		try {
			chkbxSearchAll.click();
			Thread.sleep(500);
			btnSearchAll.click();
		} catch (Exception e) {
			System.out.println("Issue in Click On Search All Button"+e.getMessage());
		}
		ReservationSearchResultPage RSRP = PageFactory.initElements(GMethods.driver, ReservationSearchResultPage.class);
		return RSRP;
	}
	
	//Logout Frontdesk
	public FrontdeskLoginPage LogoutFrontdesk()
	{
		try {
			frontdeskLogout.click();
			//Assert.assertTrue(true);
		} catch (Exception e) {
			System.out.println("Issue in Click On Logout Link on Frontdesk"+e.getMessage());
			//Assert.assertTrue(false);
		}
		FrontdeskLoginPage FLP = PageFactory.initElements(GMethods.driver, FrontdeskLoginPage.class);
		return FLP;
	}
	
	
}