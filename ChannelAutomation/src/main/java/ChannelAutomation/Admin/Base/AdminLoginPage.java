package ChannelAutomation.Admin.Base;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Configurations.Constants;
import Configurations.ExcelUtils;
import Configurations.GMethods;

public class AdminLoginPage
{
	//@FindBy(how = How.ID, using="hotelCodeId") 
	@FindBy(id="hotelCodeId")
	public static WebElement hotelID;
	
	//@FindBy(how = How.ID, using="userNameId") 
	@FindBy(id="userNameId")
	public static WebElement userName;
	
	//@FindBy(how = How.ID, using="passwordId") 
	@FindBy(id="passwordId")
	public static WebElement password;
	
	//@FindBy(how = How.NAME, using="Submit52")
	@FindBy(name="Submit52")
	public static WebElement loginButton;
	
	
	/*public AdminLoginPage launchBrowserandServer()
	{
		try {
			GMethods.lounchBrowserAndUrl(Constants.Browser, Constants.ServerURL);	
		} catch (Exception e) {
			e.getMessage();
		}
		AdminLoginPage ALP = PageFactory.initElements(GMethods.driver, AdminLoginPage.class);
		return ALP;
	}*/
	public AdminHomePage login()
	{
		try {
			//System.out.println("Test");
			//String ID = ExcelUtils.getExcelCellData(1, Constants.FirstColumn, Constants.Sheet_Credentials);
			//System.out.println("Test");
			//hotelID.sendKeys(ID);
			//hotelID.sendKeys(ExcelUtils.getExcelCellData(1, Constants.FirstColumn, Constants.Sheet_Credentials));
			//userName.sendKeys(ExcelUtils.getExcelCellData(1, Constants.SecondColumn, Constants.Sheet_Credentials));
			//password.sendKeys(ExcelUtils.getExcelCellData(1, Constants.ThirdColumn, Constants.Sheet_Credentials));
			hotelID.sendKeys(Constants.HotelID);
			userName.sendKeys(Constants.EmailID);
			password.sendKeys(Constants.Pass);
			Thread.sleep(Constants.WaitForCaptcha);
			
			loginButton.click();
			
		} catch (Exception e) {
			System.out.println("Issue in Login"+e.getMessage());
		}		
		AdminHomePage AHP = PageFactory.initElements(GMethods.driver, AdminHomePage.class);
		return AHP;
				
	}
}
