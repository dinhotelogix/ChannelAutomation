package ChannelAutomation.Admin.Base;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import ChannelAutomation.Admin.VB.ListOfOtherGDSPage;
import ChannelAutomation.Frontdesk.Login.FrontdeskForceLogoutMessageCounterPage;
import Configurations.GMethods;

public class AdminHomePage 
{
	public static String AdminWindowID;
	public static String FrontdeskWindowID;
	@FindBy(xpath="//td[text()='Administrator Console']")
	public static WebElement HeaderHomePage;
	
	@FindBy(xpath="//td[@class='line-rt-bt']//tr[2]/td/a[12]")
	public static WebElement OtherGDSPackage;
	
	@FindBy(xpath="//div[@class='logo-right-part1']//a[text()='| Frontdesk']")
	public static WebElement Frontdesk;

	
	String expAdminHeader = "Administrator Console";
	//Verify Admin Home Page
	public void verifyAdminPage()
	{
		try {
			String actAdminHeader = HeaderHomePage.getText();
			//System.out.println("Admin Header = "+actAdminHeader);
			Assert.assertEquals(actAdminHeader, expAdminHeader);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	//Land On Other GDS Package Page
	public ListOfOtherGDSPage landOnOtherGDSPackage()
	{
		try {
			OtherGDSPackage.click();
		} catch (Exception e) {
			Assert.assertTrue(false);
			System.out.println(e.getMessage());
		}
		ListOfOtherGDSPage LOGP = PageFactory.initElements(GMethods.driver, ListOfOtherGDSPage.class);
		return LOGP;
		
	}
	
	//Land On Frontdesk
	public FrontdeskForceLogoutMessageCounterPage clickFrontdeskLink()
	{
		try {
			AdminWindowID = GMethods.driver.getWindowHandle();
			Frontdesk.click();
		} catch (Exception e) {
			System.out.println("Issue in Click Frontdesk Link from Admin Console"+e.getMessage());
		}
		
		try {
			GMethods.switchToNewWindow(AdminWindowID);
			FrontdeskWindowID = GMethods.driver.getWindowHandle();
		} catch (Exception e) {
			System.out.println("Issue in Switch To Frontdesk Window"+e.getMessage());
		}
		
		FrontdeskForceLogoutMessageCounterPage FFLMCP = PageFactory.initElements(GMethods.driver, FrontdeskForceLogoutMessageCounterPage.class);
		return FFLMCP;
	}
}
