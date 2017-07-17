package ChannelAutomation.Admin.VB;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import Configurations.GMethods;

public class PackageRate 
{
	@FindBy(xpath="//td[@class='table-head-inside-light']/div/a[2]")
	public static WebElement EditValidity;
	
	@FindBy(xpath="//td[@class='table-head-inside-light']/a")
	public static WebElement ViewHide;
	
	//@FindBy(xpath="//div[@id='ratesContainer_1777']//tr[3]//tr[2]/td[4]/a")
	@FindBy(xpath="//td[@class='table-validity']//tr[3]//tr[2]/td[4]/a")
	public static WebElement LnkPkgPriceRT1;
	
	@FindBy(xpath="//td[@class='table-validity']//tr[3]//tr[2]/td[4]/input")
	public static WebElement TxtbxPkgPriceRT1;
	
	
	@FindBy(xpath="//td[@class='table-validity']//tr[3]//tr[3]/td[4]/a")
	public static WebElement LnkPkgPriceRT2;
	
	@FindBy(xpath="//td[@class='table-validity']//tr[3]//tr[3]/td[4]/input")
	public static WebElement TxtbxPkgPriceRT2;
	
	
	@FindBy(id="btnSubmit")
	public static WebElement SaveSync;
	
	@FindBy(xpath="//div[@id='askMaxSncDt']/img")
	public static WebElement SaveSyncUptoCal;
	
	@FindBy(id="btnDlg-sync")
	public static WebElement SaveSyncUpto;
	
	public static String adminWindowID;
	//Click On Edit Validity
	public PackageValidityPage editValidity()
	{
		adminWindowID = GMethods.driver.getWindowHandle();
		try {
			EditValidity.click();
		} catch (Exception e) {
			System.out.println("Issue In Click Edit Validity");
		}
		PackageValidityPage PVP = PageFactory.initElements(GMethods.driver, PackageValidityPage.class);
		return PVP;
		
	}
	
	//Switch Back To Admin Main Window
	public void switchBackWindowAdminHomePackage()
	{
		try {
			GMethods.switchToWindow(adminWindowID);
		} catch (Exception e) {
			System.out.println("Issue in Switch To Admin Home"+e.getMessage());
		}
	}
	
	//Click Hide rate
	public void clickHideView() {
		try {
			ViewHide.click();
			Thread.sleep(1500);
			ViewHide.click();
		} catch (Exception e) {
			System.out.println("Click Hide rate"+e.getMessage());
		}
	}
	//Change Rate for both Room Types
	public void changeRates()
	{
		int rt1 = 1000;
		int rt2 = 1500;
		//Change Rate for Room Type 1
		try {
			String rt1Rate = Integer.toString(GMethods.getRandomNumber(1, 1000)+rt1);
			//System.out.println(rt1Rate);
			LnkPkgPriceRT1.click();
			TxtbxPkgPriceRT1.clear();
			TxtbxPkgPriceRT1.sendKeys(rt1Rate);
		} catch (Exception e) {
			System.out.println("Issue in Change Rate for Room Type 1"+e.getMessage());
		}
		
		//Change Rate for Room Type 1
		try {
			String rt2Rate = Integer.toString(GMethods.getRandomNumber(1, 1000)+rt2);
			LnkPkgPriceRT2.click();
			TxtbxPkgPriceRT2.clear();
		TxtbxPkgPriceRT2.sendKeys(rt2Rate);
		} catch (Exception e) {
			System.out.println("Issue in Change Rate for Room Type 2"+e.getMessage());
		}
		System.out.println("Test");
	}
	//Save
	public ListofPackagesPage save()
	{
		//Click Save & Sync
		try {
			SaveSync.click();
		} catch (Exception e) {
			System.out.println("Issue in Click Save & Sync"+e.getMessage());
		}
		//Click Sync UpTo
		try {
			SaveSyncUpto.click();
			Assert.assertTrue(true);
		} catch (Exception e) {
			System.out.println("Issue in Click Sync UpTo"+e.getMessage());
			Assert.assertTrue(false);
						
		}
		ListofPackagesPage LOPA = PageFactory.initElements(GMethods.driver, ListofPackagesPage.class);
		return LOPA;
	}
}