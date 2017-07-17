package ChannelAutomation.Admin.VB;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import Configurations.GMethods;

public class ListOfChannelsPage
{
	@FindBy(xpath="//table[@class='list_viewnew']//tr[2]/td[2]/a")
	public static WebElement channelName;
	
	public ListofPackagesPage clickOnChannelName()
	{
		try {
			channelName.click();
			Assert.assertTrue(true);
		} catch (Exception e) {
			e.getMessage();
			Assert.assertTrue(false);
		}
		ListofPackagesPage LOPP = PageFactory.initElements(GMethods.driver, ListofPackagesPage.class);
		return LOPP;
	}
}