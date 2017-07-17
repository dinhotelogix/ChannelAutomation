package ChannelAutomation.Frontdesk.Login;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Configurations.GMethods;

public class FrontdeskContinueTrialPage 
{
	@FindBy(xpath="//a[text()='Continue with Trial']")
	//@FindBy(xpath="//td[@id='trialPlanBut']/table/tbody/tr/td/a")
	public static WebElement ContinueWithTrial;
	
	public FrontdeskCashCounter clickContinueWithTrial()
	{
		try {
			GMethods.jsClick(ContinueWithTrial);
			//ContinueWithTrial.click();
		} catch (Exception e) {
			System.out.println("Issue in Clicking Continue with Trail"+e.getMessage());
		}
		FrontdeskCashCounter FCC = PageFactory.initElements(GMethods.driver, FrontdeskCashCounter.class);
		return FCC;
	}

}
