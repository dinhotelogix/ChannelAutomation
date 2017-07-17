package ChannelAutomation.Frontdesk.Login;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Configurations.GMethods;

public class FrontdeskForceLogoutMessageCounterPage 
{
	@FindBy(xpath="//td[@class='contentarea05']//tr[2]/td/a")
	public static WebElement yes;
	
	@FindBy(xpath="//td[@class='contentarea05']//tr[2]/td/a[2]")
	public static WebElement no;
	
	public FrontdeskContinueTrialPage clickYes()
	{
		try {
			yes.click();
		} catch (Exception e) {
			System.out.println("Issue in Click Yes on Fource Log out page"+e.getMessage());
		}
		FrontdeskContinueTrialPage FCWT = PageFactory.initElements(GMethods.driver, FrontdeskContinueTrialPage.class);
		return FCWT;
	}

}
