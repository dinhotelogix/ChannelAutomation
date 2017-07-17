package ChannelAutomation.Frontdesk.Login;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ChannelAutomation.Frontdesk.TapeChart.FrontdeskHomePage;
import Configurations.GMethods;

public class FrontdeskCashCounter {
	@FindBy(xpath="//select[@id='counter']")
	public static WebElement SelectCounter;
	
	@FindBy(name="submit")
	public static WebElement Continue;
	
	public FrontdeskHomePage selectCounter()
	{
		try {
			GMethods.selectByIndex(SelectCounter, 1);
		} catch (Exception e) {
			System.out.println("Issue in Select Counter |"+e.getMessage());
		}
		
		try {
			Continue.click();
		} catch (Exception e) {
			System.out.println("Issue in Click Continue |"+e.getMessage());
		}
		FrontdeskHomePage FHP = PageFactory.initElements(GMethods.driver, FrontdeskHomePage.class);
		return FHP;
	}

}
