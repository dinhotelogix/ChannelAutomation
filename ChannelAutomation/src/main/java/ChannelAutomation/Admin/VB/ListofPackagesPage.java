package ChannelAutomation.Admin.VB;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import ChannelAutomation.Admin.Base.AdminHomePage;
import Configurations.GMethods;

public class ListofPackagesPage 
{
	@FindBy(xpath="//table[@class='list_viewnew']//tr[2]/td[7]/a")
	public static WebElement editPackage;
	
	@FindBy(linkText="click here")
	public static WebElement clickHere;
	
	@FindBy(xpath="//div[@id='header-contenar2']//div[2]//a")
	public static WebElement home;
	
	//Click On Edit Of 1st Package
	public PackageRate clickOnEditPackage()
	{
		try {
			editPackage.click();
			Assert.assertTrue(true);
		} catch (Exception e) {
			System.out.println("Click On Edit Of 1st Package"+e.getMessage());
			Assert.assertTrue(false);
		}
		PackageRate PR = PageFactory.initElements(GMethods.driver, PackageRate.class);
		return PR;
	}
	
	//Click on link "Click Here" to verify Rates Sync
	public VerifyRatesOnChannel clickOnClickHere()
	{
		try {
			clickHere.click();
		} catch (Exception e) {
			System.out.println("Click on link \"Click Here\" to verify Rates Sync"+e.getMessage());
		}
		
		//Switch to New Window
		try {
			GMethods.switchToNewWindow(PackageRate.adminWindowID);
		} catch (Exception e) {
			System.out.println("Switch to New Window after save rate | "+e.getMessage());
		}
		VerifyRatesOnChannel VROC = PageFactory.initElements(GMethods.driver, VerifyRatesOnChannel.class);
		return VROC;
	}
	
	//Land On Admin Home Page
	public AdminHomePage LandAdminHome()
	{
		try {
			home.click();
		} catch (Exception e) {
			Assert.assertTrue(false);
			System.out.println("Issue in Clicking on Home Link"+e.getMessage());
		}
		AdminHomePage AHP = PageFactory.initElements(GMethods.driver, AdminHomePage.class);
		return AHP;
	}
}