package ChannelAutomation.Frontdesk.Login;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import ChannelAutomation.Admin.Base.AdminHomePage;
import Configurations.GMethods;

public class FrontdeskLoginPage 
{
	public AdminHomePage SwitchBackToAdminWindow()
	{
		try {
			String frontdeskWindowID = GMethods.driver.getWindowHandle();
			GMethods.switchToNewWindow(frontdeskWindowID);
			//System.out.println("Issue in Click On Logout Link on Frontdesk"+e.getMessage());
			Assert.assertTrue(true);
		} catch (Exception e) {
			System.out.println("Issue in Click On Logout Link on Frontdesk"+e.getMessage());
			Assert.assertTrue(false);
		}
	AdminHomePage AHP = PageFactory.initElements(GMethods.driver, AdminHomePage.class);
	return AHP;
	}
}