package ChannelAutomation.Admin.VB;

import org.apache.bcel.classfile.Constant;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import Configurations.Constants;
import Configurations.GMethods;

public class VerifyRatesOnChannel 
{
	@FindBy(name="roomTypeCode")
	public static WebElement roomCode;
	
	@FindBy(name="Submit22")
	public static WebElement go;
	
	@FindBy(xpath="//tr[@id='row_1']/td[8]")
	public static WebElement syncStatus;
	
	public static String result;
	//verifyRatesOnChannel
	public ListofPackagesPage verifyrates()
	{
		String StatusSuccess = "SUCCESS";
		//Enter first Room Code and Search
		try {
			roomCode.sendKeys(Constants.RoomCode1);
			go.click();
		} catch (Exception e) {
			System.out.println("Issue in Enter first Room Code and Search"+e.getMessage());
		}
		//Verify Success for 1st Room Type
		try {
			result = syncStatus.getText();
			System.out.println("First Time | "+result);
			if (result.equalsIgnoreCase(StatusSuccess)) {
				Assert.assertTrue(true);
			}else
			{
				Thread.sleep(10000);
				go.click();
				result = syncStatus.getText();
				System.out.println("Second Time | "+result);
				if (result.equalsIgnoreCase(StatusSuccess)) {
					Assert.assertTrue(true);
				}else
				{
					Thread.sleep(30000);
					go.click();
					result = syncStatus.getText();
					System.out.println("Third Time | "+result);
					if (result.equalsIgnoreCase(StatusSuccess)) {
						Assert.assertTrue(true);
					}else
					{
						Thread.sleep(120000);
						go.click();
						result = syncStatus.getText();			
						System.out.println("Fourth Time | "+result);
						if (result.equalsIgnoreCase(StatusSuccess)) {
							Assert.assertTrue(true);
						}else
						{
							Assert.assertTrue(false);
						}
						
						//Assert.assertTrue(false);
					}
				}
			}
		} catch (Exception e) {
			Assert.assertTrue(false);
		}
		
		
		//Enter Second Room Code and Search
		try {
			roomCode.clear();
			roomCode.sendKeys(Constants.RoomCode2);
			go.click();
		} catch (Exception e) {
			System.out.println("Issue in Enter Second Room Code and Search"+e.getMessage());
		}
		//Verify Success for 2nd Room Type
		try {
			result = syncStatus.getText();
			System.out.println("First Time | "+result);
			if (result.equalsIgnoreCase(StatusSuccess)) {
				Assert.assertTrue(true);
			}else
			{
				Thread.sleep(10000);
				go.click();
				result = syncStatus.getText();
				System.out.println("Second Time | "+result);
				if (result.equalsIgnoreCase(StatusSuccess)) {
					Assert.assertTrue(true);
				}else
				{
					Thread.sleep(30000);
					go.click();
					result = syncStatus.getText();
					System.out.println("Third Time | "+result);
					if (result.equalsIgnoreCase(StatusSuccess)) {
						Assert.assertTrue(true);
					}else
					{
						Thread.sleep(120000);
						go.click();
						result = syncStatus.getText();			
						System.out.println("Fourth Time | "+result);
						if (result.equalsIgnoreCase(StatusSuccess)) {
							Assert.assertTrue(true);
						}else
						{
							System.out.println("");
							Assert.assertTrue(false);
						}
						
						//Assert.assertTrue(false);
					}
				}
			}
		} catch (Exception e) {
			Assert.assertTrue(false);
		}
		
		ListofPackagesPage LOPP = PageFactory.initElements(GMethods.driver, ListofPackagesPage.class);
		return LOPP;
	}
	
	//Close Window and Back to Admin Home 
	public void backToAdmin()
	{
		//Close Verification Window
		try {
			GMethods.driver.close();
		} catch (Exception e) {
			System.out.println("Issue in Closing Child Window"+e.getMessage());
			Assert.assertTrue(false);
		}
		//Switch to Previous Window
		try {
			GMethods.switchToWindow(PackageRate.adminWindowID);
			Assert.assertTrue(true);
		} catch (Exception e) {
			System.out.println("Switch to Previous Window"+e.getMessage());
			Assert.assertTrue(false);
		}
	}

}
