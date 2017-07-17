package ChannelAutomation.Admin.VB;

import java.util.List;

import javax.xml.xpath.XPath;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import ChannelAutomation.Admin.Base.AdminHomePage;
import Configurations.Constants;
import Configurations.GMethods;

public class ManageAllotmentsPage 
{
	@FindBy(xpath="//td[@class='container_box']//tr[2]/td")
	public static WebElement HeaderAllotmentMatrix;
	
	@FindBy(id="chkRoomType")
	public static WebElement SelectAllCheckBox;
	
	@FindBy(id="btnAddEditAllotment")
	public static WebElement BtnAddEditAllotments;
	
	@FindBy(xpath="//td[@class='error']")
	public static WebElement msg;
	
	@FindBy(xpath="//tr[@class='alt']/td[3]")
	public static WebElement allotCell;
	
	@FindBy(xpath="//img[@id='imgRefreshAllotData']")
	public static WebElement refresh;
	
	@FindBy(xpath="//div[@id='header-contenar2']//div[2]//a")
	public static WebElement home;
	
	@FindBy(id="Allotment Matrix")
	public static WebElement selectChannelDropDown;
	
	@FindBy(id="selRates")
	public static WebElement selectRates;
	
	@FindBy(id="selChannels")
	public static WebElement selectChannel;
	
	@FindBy(id="btn-addrestrictions")
	public static WebElement BtnAddEditRestrictions;
	
	@FindBy(id="restrictionType")
	public static WebElement DrpDwnSelectRestriction;
	
	@FindBy(id="btnRestSave")
	public static WebElement BtnSaveRestriction;
	
	@FindBy(xpath="//div[@id='dvAllotmentMatrix']//table[@class='matrixTbl los']//tr/td[2]/span")
	public static WebElement ruleCell;
	
	@FindBy(xpath="//div[@id='dvAllotmentMatrix']//tr[4]//table/tbody/tr/th")
	public static List<WebElement> allotmentDates;
	
	@FindBy(xpath="//div[@id='dvAllotmentMatrix']//tr[4]//table[2]/tbody/tr/td")
	public static List<WebElement> allotmentValuesSRMRoomType;
	
	@FindBy(xpath="//div[@id='dvAllotmentMatrix']//tr[4]//table[6]/tbody/tr/td")
	public static List<WebElement> allotmentValuesSTDRoomType;
	
	
	public static String AllotmentValue;
	
	//Verify  Allotment Matrix Page
	public void verifyManageAllotmentsPage()
	{
		try {
			String expHeader = "Allotment Matrix";
			String actHeader = HeaderAllotmentMatrix.getText();
			if (actHeader.contains(expHeader)) 
			{
				Assert.assertTrue(true);
			}else{
				Assert.assertTrue(false);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	//Select All Check Box and Click on Add/Edit Allotment, save Allotments
	public String saveAllotments()
	{
		String AdminWindowID = GMethods.driver.getWindowHandle();
		//Click Select All Check Box
		try {
			SelectAllCheckBox.click();
		} catch (Exception e) {
			Assert.assertTrue(false);
			System.out.println("Issue in Select All Check Box"+" | "+e.getMessage());
		}
		//Click Add/Edit Allotment Button
		try {
			BtnAddEditAllotments.click();
		} catch (Exception e) {
			System.out.println("Issue in Click Add/Edit Allotment Button"+" | "+e.getMessage());
		}
		PageFactory.initElements(GMethods.driver, SaveAllotmentPage.class);
		//Switch in New Window
		try {
			String CurrWinID = GMethods.driver.getWindowHandle();
			GMethods.switchToNewWindow(CurrWinID);
		} catch (Exception e) {
			System.out.println("Issue in Switching to New Window"+e.getMessage());
		}
		return AdminWindowID;		
	}
	
	//Verify Allotment After Save Allotmnet
	public void verifyAftrSaveAllotment(String AdminWindowID)
	{
		//Back To Admin  Console
		try {
		GMethods.switchToWindow(AdminWindowID);	
		} catch (Exception e) {
			// TODO: handle exception
		}
		try {
			System.out.println("aa");
			String expMsg = "- Allotment(s) updated for selected dates";
			String actMsg = msg.getText();
			if (actMsg.contains(expMsg)) 
			{
				String BGColor = allotCell.getCssValue("background-color").toString();
				//System.out.println("First Time Color |"+BGColor);
						
				if (BGColor.equalsIgnoreCase(Constants.BackgroundColor_Success)) 
				{
					Assert.assertTrue(true);
				}else if (BGColor.equalsIgnoreCase(Constants.BackgroundColor_InProgress)) 
				{
					Thread.sleep(20000);
					refresh.click();
					
					Thread.sleep(7000);
					String BGColor1 = allotCell.getCssValue("background-color").toString();
					//System.out.println("Second Time Color |"+BGColor1);
					
					if (BGColor1.equalsIgnoreCase(Constants.BackgroundColor_Success)) 
					{
						Assert.assertTrue(true);
					}else if (BGColor1.equalsIgnoreCase(Constants.BackgroundColor_InProgress)) 
					{
						Thread.sleep(60000);
						refresh.click();
						Thread.sleep(7000);
						String BGColor2 = allotCell.getCssValue("background-color").toString();
						System.out.println("Third Time BG Color |"+BGColor2);
						if (BGColor2.equalsIgnoreCase(Constants.BackgroundColor_Success)) 
						{
							Assert.assertTrue(true);
						}else if (BGColor2.equalsIgnoreCase(Constants.BackgroundColor_InProgress)) 
						{
							Thread.sleep(240000);
							refresh.click();
							Thread.sleep(7000);
							String BGColor3 = allotCell.getCssValue("background-color").toString();
							System.out.println("Third Time BG Color"+BGColor3);
							if (BGColor3.equalsIgnoreCase(Constants.BackgroundColor_Success)) 
							{
								Assert.assertTrue(true);
							}else if (BGColor.equalsIgnoreCase(Constants.BackgroundColor_InProgress)) 
							{
								Assert.assertTrue(false);
							}else 
							{
								Assert.assertTrue(false);
							}
										
						}else 
						{
							Assert.assertTrue(false);
						}
						
					}else 
					{
						Assert.assertTrue(false);
					}
				}else
				Assert.assertTrue(false);
			} 
		}
		catch (Exception e) 
		{
			System.out.println("Issue In Verify Allotment"+e.getMessage());
			Assert.assertTrue(false);
		}
		
	}
	/**
	 * Click On Home link to Land On Admin Home
	 */
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
	
	/**
	 * Select All Check Box, Select Channel, Select rates and Click on Add/Edit restrictions
	 * @throws InterruptedException 
	 */
	public void sendRestrictions() throws InterruptedException
	{
		
		String AdminWindowID = GMethods.driver.getWindowHandle();
		//System.out.println("aa");		
		//Select Channel
		try {
			Select sel = new Select(selectChannel);
			sel.selectByIndex(1);
			
		} catch (Exception e) {
			System.out.println("Issue in Select Channel"+e.getMessage());
			Assert.assertTrue(false);
		}
		//Select Rate
		try {
			/*
			WebDriverWait wait = new WebDriverWait(GMethods.driver, 30);
			WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("selRates")));
			
				Select sel1 = new Select(element);
				sel1.selectByIndex(1);	
			*/
			
			Thread.sleep(5000);
			Select sel = new Select(selectRates);
			sel.selectByIndex(1);
						
		} catch (Exception e) {
			System.out.println("Issue in Select Rate"+e.getMessage());
			Assert.assertTrue(false);
		}
		
		//Click Select All Check Box
		try {
				SelectAllCheckBox.click();
			} catch (Exception e) {
				Assert.assertTrue(false);
				System.out.println("Issue in Select All Check Box"+" | "+e.getMessage());
			}
		
		//Click Add/Edit restriction
		try {
			BtnAddEditRestrictions.click();
		} catch (Exception e) 
		{
			Assert.assertTrue(false);
			System.out.println("Issue in Click Add/Edit Restriction"+e.getMessage());
		}
		//Select Restriction
		try {
			Select sel = new Select(DrpDwnSelectRestriction);
			sel.selectByIndex(1);
		} catch (Exception e) {
			System.out.println("Issue in Select restriction"+e.getMessage());
			Assert.assertTrue(false);
		}
		//Click Save on On Restrictions Page
		try {
			BtnSaveRestriction.click();
		} catch (Exception e) {
			System.out.println("Issue in Click Save Restrictions"+e.getMessage());
			Assert.assertTrue(false);
		}
		
		//Accept Alert
		try {
			GMethods.acceptAlert();
		} catch (Exception e) {
			System.out.println("Issue in Accept Alert"+e.getMessage());
			Assert.assertTrue(false);
		}
		
		Thread.sleep(9000);

		//System.out.println("aa");
		//Verify Rule Cell Color
		try {
			//String BGColor = ruleCell.getCssValue("background-color").toString();
			String BGColor = ruleCell.getCssValue("background-color");
			//System.out.println("First Time Color |"+BGColor);
					
			if (BGColor.equalsIgnoreCase(Constants.BackgroundColor_RuleSuccess)) 
			{
				Assert.assertTrue(true);
			}
			else if (BGColor.equalsIgnoreCase(Constants.BackgroundColor_InProgress)) 
			//else if (BGColor.equalsIgnoreCase("rgba(0, 0, 0, 1)"))
			{
				Thread.sleep(20000);
				refresh.click();
				
				Thread.sleep(9000);
				String BGColor1 = ruleCell.getCssValue("background-color");
				//System.out.println("Second Time Color |"+BGColor1);
				
				if (BGColor1.equalsIgnoreCase(Constants.BackgroundColor_RuleSuccess)) 
				{
					Assert.assertTrue(true);
				}
				else if (BGColor1.equalsIgnoreCase(Constants.BackgroundColor_InProgress)) 
				{
					Thread.sleep(60000);
					refresh.click();
					Thread.sleep(9000);
					String BGColor2 = ruleCell.getCssValue("background-color");
					//System.out.println("Third Time BG Color |"+BGColor2);
					if (BGColor2.equalsIgnoreCase(Constants.BackgroundColor_RuleSuccess)) 
					{
						Assert.assertTrue(true);
					}
					else if (BGColor2.equalsIgnoreCase(Constants.BackgroundColor_InProgress)) 
					//else if (BGColor2.equalsIgnoreCase("transparent"))
					{
						Thread.sleep(240000);
						refresh.click();
						Thread.sleep(9000);
						String BGColor3 = ruleCell.getCssValue("background-color");
						System.out.println("Third Time BG Color"+BGColor3);
						if (BGColor3.equalsIgnoreCase(Constants.BackgroundColor_RuleSuccess)) 
						{
							Assert.assertTrue(true);
						}else if (BGColor.equalsIgnoreCase(Constants.BackgroundColor_InProgress)) 
						{
							Assert.assertTrue(false);
						}else 
						{
							Assert.assertTrue(false);
						}
									
					}else 
					{
						Assert.assertTrue(false);
					}
					
				}else 
				{
					Assert.assertTrue(false);
				}
			}else
			{
				Assert.assertTrue(false);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	
	public void landOnHome() {
		LandAdminHome();
	}
	
	//Capture Allotment
	public void getAllotmentForADay()
	{
		try {
			String fromDate = GMethods.getAddedCurrentYearMonthDate(Constants.fromDate_ResAddDays);
			String dat = fromDate.substring(8,10);
			int size = allotmentDates.size();
			for(int i = 2; i<=size;i++)
			{
				String date = allotmentDates.get(i).getText();
				if(date.contains(dat))
				{
					String roomType = Constants.PushResInRoomType;
					if(roomType=="SRM")
					{
						AllotmentValue = allotmentValuesSRMRoomType.get(i).getText().trim();
						//System.out.println("Allotment:"+AllotmentValue);
					}else {
						AllotmentValue = allotmentValuesSTDRoomType.get(i).getText().trim();
						//System.out.println("Allotment:"+AllotmentValue);
					}
				}
			}
		} catch (Exception e) {
			System.out.println("Issue in Getting Allotment in Admin Console"+e.getMessage());
		}
	}
	
	//Verify Allotment Update
	public void verifyAllotmentUpdate(String oldAllotment)
	{
		try {
			int actAllotment = Integer.parseInt(AllotmentValue);
			int expAllotment = Integer.parseInt(oldAllotment);
			if(expAllotment==actAllotment-1)
			{
				Assert.assertTrue(true);
			}else
			{
				System.out.println("Old Allotment:"+expAllotment+", and Current Allotment:"+actAllotment);
				Assert.assertTrue(false);
			}
						
		} catch (Exception e) {
			System.out.println("Issue in Verify Allotmnt "+e.getMessage());
			Assert.assertTrue(false);
		}
	}
	
}