package ChannelAutomation.Admin.VB;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import Configurations.GMethods;

public class ListOfOtherGDSPage 
{
	@FindBy(xpath="//div[@id='heading_new']//td[2]")
	public static WebElement HeaderListOfOtherGDS;
	
	@FindBy(xpath="//a[text()='Manage Allotments']")
	public static WebElement ManageAllotments;
	
	@FindBy(xpath="//table[@class='list_viewnew']//tr[2]/td[3]/a")
	public static WebElement ViewChannels;
	
	//Verify List Of Other GDS Page()
	public void verifyListOfOtherGDSPage()
	{
		try {
			String expHeader = "List of Other(GDS)";
			String actHeader = HeaderListOfOtherGDS.getText();
			Assert.assertEquals(actHeader, expHeader);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	//Click On Manage Allotments Link
	public ManageAllotmentsPage clickManageAllotments()
	{
		try {
			ManageAllotments.click();
		} catch (Exception e) {
			Assert.assertTrue(false);
			System.out.println(e.getMessage());
			
		}
		ManageAllotmentsPage MAP = PageFactory.initElements(GMethods.driver, ManageAllotmentsPage.class);
		return MAP;
	}
	
	/**
	 *Click on View Channels
	*/
	public ListOfChannelsPage clickViewChannels()
	{
		try {
			ViewChannels.click();
			Assert.assertTrue(true);
		} catch (Exception e) {
			System.out.println("Issue in Click on View Channels"+e.getMessage());
			Assert.assertTrue(false);
		}
		ListOfChannelsPage LOCP = PageFactory.initElements(GMethods.driver, ListOfChannelsPage.class);
		return LOCP;
	}
}
