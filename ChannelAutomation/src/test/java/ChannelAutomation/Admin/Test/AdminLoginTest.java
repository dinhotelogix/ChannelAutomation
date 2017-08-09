package ChannelAutomation.Admin.Test;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import ChannelAutomation.Admin.Base.AdminHomePage;
import ChannelAutomation.Admin.Base.AdminLoginPage;
import ChannelAutomation.Admin.Base.BasePage;
import ChannelAutomation.Admin.VB.ListOfChannelsPage;
import ChannelAutomation.Admin.VB.ListOfOtherGDSPage;
import ChannelAutomation.Admin.VB.ListofPackagesPage;
import ChannelAutomation.Admin.VB.ManageAllotmentsPage;
import ChannelAutomation.Admin.VB.PackageRate;
import ChannelAutomation.Admin.VB.PackageValidityPage;
import ChannelAutomation.Admin.VB.SaveAllotmentPage;
import ChannelAutomation.Admin.VB.VerifyRatesOnChannel;
import ChannelAutomation.Frontdesk.Login.FrontdeskCashCounter;
import ChannelAutomation.Frontdesk.Login.FrontdeskContinueTrialPage;
import ChannelAutomation.Frontdesk.Login.FrontdeskLoginPage;
import ChannelAutomation.Frontdesk.TapeChart.FrontdeskHomePage;
import ChannelAutomation.Frontdesk.TapeChart.ReservationSearchResultPage;
import ChannelAutomation.Frontdesk.TapeChart.ReservationViewDetailsPage;
import ChannelAutomation.Reservations.BusyRoomsPushReservation;
import Configurations.Constants;
import Configurations.ExcelUtils;
import Configurations.GMethods;

public class AdminLoginTest 
{
	@BeforeTest()
	public void setExcelPath() throws Exception
	{
		ExcelUtils.setExcelFile(Constants.Path_ExcelData);	
	}
	
	////Login to Admin Console
	//@Test(priority=1, groups = {"testDebug" })
	@Test(priority=1, groups = {"Login","BR", "SendRate","SendRule","SendAllotment","ChannelManager" })
	public void AdminLogin_TC_1()
	{
		try {			
			//Launch Browser and URL
			try {
				GMethods.lounchBrowserAndUrl(Constants.Browser, Constants.ServerURL);	
			} catch (Exception e) {
				e.getMessage();
			}
			PageFactory.initElements(GMethods.driver, AdminLoginPage.class);
			
			//Create Object of Admin Login Page
			AdminLoginPage ALPage = new AdminLoginPage();
			//Login To Admin Console
			AdminHomePage AHP = ALPage.login();
			AHP.verifyAdminPage();
			//Verify Login
			
		} catch (Exception e) {
			e.getMessage();
		}
	}
	//Land on List of Other(GDS) Page
	//@Test(priority=2, groups = {"testDebug" })
	@Test(priority=2, groups = {"BR","SendAllotment","ChannelManager" })
	public void landOnListOfGDSPage_TC_2()
	{
		try {
			AdminHomePage AHP = new AdminHomePage();
			ListOfOtherGDSPage LOGP = AHP.landOnOtherGDSPackage();
			LOGP.verifyListOfOtherGDSPage();
			
		} catch (Exception e) 
		{
			System.out.println("Issue in and on List of Other(GDS) Page | "+e.getMessage());
		}
	}
	
	//Land On Allotment Matrix - Vertical Booking
	//@Test(priority=3, groups = {"testDebug" })
	@Test(priority=3, groups = {"BR","SendAllotment","ChannelManager"})
	public void landOnAllotmentMatrix_TC_3()
	{
		try {
			ListOfOtherGDSPage LOGP = new ListOfOtherGDSPage();
			ManageAllotmentsPage MAP =LOGP.clickManageAllotments();
			MAP.verifyManageAllotmentsPage();

		} catch (Exception e) {
			System.out.println("Issue in Landing On Allotment Matrix"+e.getMessage());
		}
	}
	//Save Allotments
	//@Test(priority=4, groups = {"testDebug" })
	@Test(priority=4 , groups = {"BR","SendAllotment","ChannelManager"})
	public void saveAlotments_TC_4()
	{
		try {
			ManageAllotmentsPage MAP = new ManageAllotmentsPage();
			String adminWindowID = MAP.saveAllotments();
			
			SaveAllotmentPage SAP = new SaveAllotmentPage();
			SAP.saveAllotments();
			MAP.verifyAftrSaveAllotment(adminWindowID);
		} catch (Exception e) {
			System.out.println("Issue In Save Allotment"+e.getMessage());
		}
	}
	//Click Home Link to Land On Admin Home
	//@Test(priority=5, groups = {"testDebug" })
	@Test(priority=5, groups = {"BR","SendAllotment","ChannelManager"})
	public void landOnAdminHome_TC_5()
	{
		try {
			ManageAllotmentsPage MAP = new ManageAllotmentsPage();
			MAP.LandAdminHome();
		} catch (Exception e) {
			System.out.println("Issue oin landing HomePage");
		}
	}
	
	//Land on List of Other(GDS) Page
	//@Test(priority=6, groups = {"testDebug" })
	@Test(priority=6, groups = {"BR","SendAllotment","ChannelManager"})
	public void landOnListOfGDSPage_TC_6()
	{
		try {
			AdminHomePage AHP = new AdminHomePage();
			ListOfOtherGDSPage LOGP = AHP.landOnOtherGDSPackage();
			LOGP.verifyListOfOtherGDSPage();
				
		} catch (Exception e) 
		{
			System.out.println("Issue in and on List of Other(GDS) Page | "+e.getMessage());
		}
	}
	
	
	//Land On Allotment Matrix
	//@Test(priority=7, groups = {"testDebug" })
	@Test(priority=7, groups = {"BR","SendAllotment","ChannelManager"})
	public void landOnAllotmentMatrix_TC_7()
	{
	try {
		ListOfOtherGDSPage LOGP = new ListOfOtherGDSPage();
		ManageAllotmentsPage MAP =LOGP.clickManageAllotments();
		MAP.verifyManageAllotmentsPage();

	} catch (Exception e) {
		System.out.println("Issue in Landing On Allotment Matrix"+e.getMessage());
	}
	}
	
	//Send Rules on Channel
	//@Test(priority=8, groups = {"testDebug" })
	@Test(priority=8, groups = {"BR","SendAllotment","ChannelManager"})
	public void SendRulesonChannel_TC_8()
	{
		try {
			ManageAllotmentsPage MAP = new ManageAllotmentsPage();
			MAP.sendRestrictions();
		} catch (Exception e) {
			
		}
	}
	
	//Land On Admin Home
	//@Test(priority=9, groups = {"testDebug" })
	@Test(priority=9, groups = {"BR","SendAllotment","ChannelManager"})
	public void landOnAdminHome_TC_9()
	{
		try {
			ManageAllotmentsPage MAP = new ManageAllotmentsPage();
			MAP.LandAdminHome();
		} catch (Exception e) {
			System.out.println("Issue oin landing HomePage");
		}
	}
	
	
	//Land on List of Other(GDS) Page
	@Test(priority=10, groups = {"testDebug" })
	//@Test(priority=10, groups = {"BR", "SendRate","ChannelManager"})
	public void landOnListOfGDSPage_TC_10()
	{
		try {
			AdminHomePage AHP = new AdminHomePage();
			ListOfOtherGDSPage LOGP = AHP.landOnOtherGDSPackage();
			LOGP.verifyListOfOtherGDSPage();
				
		} catch (Exception e) 
		{
			System.out.println("Issue in and on List of Other(GDS) Page | "+e.getMessage());
		}
	}
	
	//Land Of List Of Channel Package
	@Test(priority=11, groups = {"testDebug" })
	//@Test(priority=11, groups = {"BR", "SendRate","ChannelManager"})
	public void landOnListofChannels_TC_11()
	{
		try {
			ListOfOtherGDSPage LOOP = new ListOfOtherGDSPage();
			LOOP.clickViewChannels();	
		} catch (Exception e) {
			e.getMessage();
		}
	}
	//Land on "List of Packages" Page
	//@Test(priority=12, groups = {"testDebug" })
	@Test(priority=12, groups = {"BR", "SendRate","ChannelManager"})
	public void clickOnChannel_TC_12()
	{
		try {
			ListOfChannelsPage LOCP = new ListOfChannelsPage();
			LOCP.clickOnChannelName();
		} catch (Exception e) {
			e.getMessage();
		}
	}
	//Edit Package
	//@Test(priority=13, groups = {"testDebug" })
	@Test(priority=13, groups = {"BR", "SendRate","ChannelManager"})
	public void clickOnEditPackage_TC_13()
	{
		try {
			ListofPackagesPage LOPP = new ListofPackagesPage();
			LOPP.clickOnEditPackage();
		} catch (Exception e) {
			e.getMessage();
		}
	}
	//Sync and Send rate On Channel
	//@Test(priority=14, groups = {"testDebug" })
	@Test(priority=14, groups = {"BR", "SendRate","ChannelManager"})
	public void sendRatesOnChannel_TC_14()
	{
		try {
			PackageRate PR = new PackageRate();
			PackageValidityPage PVP = PR.editValidity();
			PVP.switchNewWindow();
			PVP.saveValidity();
			PR.switchBackWindowAdminHomePackage();
			PR.clickHideView();
			PR.changeRates();
			PR.save();
			
			ListofPackagesPage LIPP = new ListofPackagesPage();
			VerifyRatesOnChannel VROC = LIPP.clickOnClickHere();
			VROC.verifyrates();
			
					
		} catch (Exception e) {
			e.getMessage();
		}
	}
	
	//Close Window and Back to Admin Parent Window
	//@Test(priority=15, groups = {"testDebug" })
	@Test(priority=15, groups = {"BR", "SendRate","ChannelManager"})
	public void backToAdminHomePagel_TC_15() {
		try {
			VerifyRatesOnChannel VROC = new VerifyRatesOnChannel();
			VROC.backToAdmin();
		} catch (Exception e) {
			
		}
	}
	//Land On Admin Home
	//@Test(priority=16, groups = {"testDebug" })
	@Test(priority=16, groups = {"BR", "SendRate","ChannelManager"})
	public void landOnAdminHome_TC_16()
	{
		try {
			ListofPackagesPage LOP = new ListofPackagesPage();
			LOP.LandAdminHome();
			Assert.assertTrue(true);
		} catch (Exception e) {
			System.out.println("Issue in landing HomePage "+e.getMessage());
			Assert.assertTrue(false);
		}
	}
	
	//Get Allotment for a particular day
	@Test(priority=17, groups = {"BR", "SendRate","ChannelManager"})
	//@Test(priority=17, groups = {"testDebug"})
	public void CaptureAllotment_TC_17()
	{
		//Land on Other GDS Page
		try {
			AdminHomePage AHP = new AdminHomePage();
			ListOfOtherGDSPage LOGP = AHP.landOnOtherGDSPackage();
			LOGP.verifyListOfOtherGDSPage();
						
		} catch (Exception e) {
			System.out.println("Issue in landing Other GDS Page "+e.getMessage());
			Assert.assertTrue(false);
		}
		//Land on Allotment Page
		try {
			ListOfOtherGDSPage LOGP = new ListOfOtherGDSPage();
			ManageAllotmentsPage MAP =LOGP.clickManageAllotments();
			MAP.verifyManageAllotmentsPage();
		} catch (Exception e) {
			System.out.println("Issue in landing Allotment Page "+e.getMessage());
			Assert.assertTrue(false);
		}
		//Get Allotment
		try {
			ManageAllotmentsPage MAP = new ManageAllotmentsPage();
			//System.out.println("");
			MAP.getAllotmentForADay();
		} catch (Exception e) {
			System.out.println("Issue in Getting Allotment Value "+e.getMessage());
			Assert.assertTrue(false);
		}
	}
	//Land On Admin Home
	//@Test(priority=18, groups = {"testDebug"})
	@Test(priority=18, groups = {"BR", "SendRate","ChannelManager"})
	public void landOnAdminHome_TC_18()
	{
		try {
			ListofPackagesPage LOP = new ListofPackagesPage();
			LOP.LandAdminHome();
			Assert.assertTrue(true);
		} catch (Exception e) {
			System.out.println("Issue in landing HomePage "+e.getMessage());
			Assert.assertTrue(false);
		}
	}
	
	//Push Reservation On Frontdesk
	@Test(priority=19, groups = {"BR","ChannelManager"})
	//@Test(priority=19, groups = {"testDebug"})
	public void pushbooking_TC_19()
	{
		try {
			BusyRoomsPushReservation BRPR = new BusyRoomsPushReservation();
			//System.out.println("Res ID:"+BusyRoomsPushReservation.ResID);
			BRPR.pushBooking();
		} catch (Exception e) {
			System.out.println("Issue in Push Reservation through XML "+e.getMessage());
			Assert.assertTrue(false);
		}
		
	}
	
	//Login on Frontdesk to Verify Reservation
	//@Test(priority=20, groups = {"testDebug"})
	@Test(priority=20, groups = {"BR","ChannelManager"})
	public void LoginOnFrontdeskFromAdminConsole_TC_20()
	{
		//Click On Frontdesk Link in Admin
		try {
			AdminHomePage AHP = new AdminHomePage();
			AHP.clickFrontdeskLink();
			
			BasePage BP = new BasePage();
			BP.verifyPage();
			
			FrontdeskContinueTrialPage FCT = new FrontdeskContinueTrialPage();
			FCT.clickContinueWithTrial();
			
			FrontdeskCashCounter FCC = new FrontdeskCashCounter();
			FCC.selectCounter();
			
			FrontdeskHomePage FHP = new FrontdeskHomePage();
			FHP.clickCancel();
								
		} catch (Exception e) {
			System.out.println("Login on Frontdesk from Admin Console"+e.getMessage());
			Assert.assertTrue(false);
		}
	}
	//Verify Reservation On Frontdesk
	//@Test(priority=21, groups = {"testDebug"})
	@Test(priority=21, groups = {"BR","ChannelManager"})
	public void VerifyResOnFrontdesk_TC_21()
	{
		try {
			FrontdeskHomePage FHP = new FrontdeskHomePage();
			FHP.searchResOnFrontdesk();
			
			ReservationSearchResultPage RSRP = new ReservationSearchResultPage();
			RSRP.openReservation();
			
			ReservationViewDetailsPage RVDP = new ReservationViewDetailsPage();
			RVDP.verifyReservation();
		} catch (Exception e) {
			System.out.println("Issue in Verify Reservation on Frontdesk"+e.getMessage());
			Assert.assertTrue(false);
		}
	}
	
	//Logout Frontdesk and Back to Admin window
	//@Test(priority=22, groups = {"testDebug"})
	@Test(priority=22, groups = {"BR","ChannelManager"})
	public void LogoutFrotdeskBackToAdminWindow_TC_22()
	{
		try {
			FrontdeskHomePage FHP = new FrontdeskHomePage();
			FHP.LogoutFrontdesk();
			
			FrontdeskLoginPage FLP = new FrontdeskLoginPage();
			FLP.SwitchBackToAdminWindow();
		} catch (Exception e) {
			Assert.assertTrue(false);
			System.out.println("Issue in Logout Frontdesk and Switch back to Admin Window"+e.getMessage());
		}
	}
	//Check Allotment Update in Admin

	//@Test(priority=23, groups = {"testDebug"})
	@Test(priority=23, groups = {"BR","ChannelManager"})
	public void VerifyAllotmentUpdateInAdminConsole_TC_23()
	{
		try {
			//Land on Other GDS Page
			try {
				AdminHomePage AHP = new AdminHomePage();
				ListOfOtherGDSPage LOGP = AHP.landOnOtherGDSPackage();
				LOGP.verifyListOfOtherGDSPage();
							
			} catch (Exception e) {
				System.out.println("Issue in landing Other GDS Page "+e.getMessage());
				Assert.assertTrue(false);
			}
			//Land on Allotment Page
			try {
				ListOfOtherGDSPage LOGP = new ListOfOtherGDSPage();
				ManageAllotmentsPage MAP =LOGP.clickManageAllotments();
				MAP.verifyManageAllotmentsPage();
			} catch (Exception e) {
				System.out.println("Issue in landing Allotment Page "+e.getMessage());
				Assert.assertTrue(false);
			}
			//Get Allotment
			try {
				//Get Previous Allotment
				String oldAllotmentValue = ManageAllotmentsPage.AllotmentValue;
				
				ManageAllotmentsPage MAP = new ManageAllotmentsPage();
				System.out.println("");
				MAP.getAllotmentForADay();
				
				MAP.verifyAllotmentUpdate(oldAllotmentValue);
				
			} catch (Exception e) {
				System.out.println("Issue in Getting Allotment Value "+e.getMessage());
				Assert.assertTrue(false);
			}
			
		} catch (Exception e) {
			
		}
	}
	
	//Land On Admin Home
	//@Test(priority=24, groups = {"testDebug"})
	@Test(priority=24, groups = {"BR", "SendRate","ChannelManager"})
	public void landOnAdminHome_TC_24()
	{
		try {
			ListofPackagesPage LOP = new ListofPackagesPage();
			LOP.LandAdminHome();
			Assert.assertTrue(true);
		} catch (Exception e) {
			System.out.println("Issue in landing HomePage "+e.getMessage());
			Assert.assertTrue(false);
		}
	}
	
	//@Test(priority=1, groups = {"testDebug"})
	public void testDebug() 
	{
		//String randomNumber = Constants.ChannelManagerCode+GMethods.getUniqueNumber();
		String addedDaysDate = GMethods.getAddedCurrentYearMonthDate(20);
		System.out.println("New Date | "+addedDaysDate);
	}
}