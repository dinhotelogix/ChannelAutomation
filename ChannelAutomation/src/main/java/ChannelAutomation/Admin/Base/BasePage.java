package ChannelAutomation.Admin.Base;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ChannelAutomation.Frontdesk.Login.FrontdeskContinueTrialPage;
import ChannelAutomation.Frontdesk.Login.FrontdeskForceLogoutMessageCounterPage;
import Configurations.GMethods;

public class BasePage 
{
	@FindBy(xpath="//div[@id='header-contenar2']//div[2]//a")
	public static WebElement home;
	/**
	 * Click On Logo to Land On Admin Home
	 */
	/*public AdminHomePage LandAdminHome()
	{
		try {
			home.click();
		} catch (Exception e) {
			System.out.println("Issue in Clicking on Home Link"+e.getMessage());
		}
		AdminHomePage AHP = PageFactory.initElements(GMethods.driver, AdminHomePage.class);
		return AHP;
		
	}*/
	public FrontdeskContinueTrialPage verifyPage()
	{
		try {
			String currPageURL = GMethods.driver.getCurrentUrl();
			if(currPageURL.contains("confirmation"))
			{
				FrontdeskForceLogoutMessageCounterPage FFLC = new FrontdeskForceLogoutMessageCounterPage();
				FFLC.clickYes();
			}
			
		} catch (Exception e) {
			System.out.println("Issue in Click Fource Logout in Login Process"+e.getMessage());
		}
		FrontdeskContinueTrialPage FCWTP = PageFactory.initElements(GMethods.driver,FrontdeskContinueTrialPage.class);
		return FCWTP;
	}

}
