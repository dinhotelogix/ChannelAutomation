package ChannelAutomation.Admin.Test;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import ChannelAutomation.Admin.Base.AdminHomePage;
import ChannelAutomation.Admin.Base.AdminLoginPage;
import ChannelAutomation.Admin.Base.BasePage;
import ChannelAutomation.Admin.VB.ListOfOtherGDSPage;
import ChannelAutomation.Admin.VB.ListofPackagesPage;
import ChannelAutomation.Admin.VB.ManageAllotmentsPage;
import ChannelAutomation.Frontdesk.Login.FrontdeskCashCounter;
import ChannelAutomation.Frontdesk.Login.FrontdeskContinueTrialPage;
import ChannelAutomation.Frontdesk.Login.FrontdeskLoginPage;
import ChannelAutomation.Frontdesk.TapeChart.CreateReservation;
import ChannelAutomation.Frontdesk.TapeChart.EditView_Reservation;
import ChannelAutomation.Frontdesk.TapeChart.FrontdeskGrid;
import ChannelAutomation.Frontdesk.TapeChart.FrontdeskHomePage;
import ChannelAutomation.Frontdesk.TapeChart.PaymentPage;
import ChannelAutomation.Frontdesk.TapeChart.ReservationSearchResultPage;

import ChannelAutomation.Frontdesk.TapeChart.ReservationViewDetailsPage;
import ChannelAutomation.Reservations.BusyRoomsPushReservation;
import Configurations.Constants;
import Configurations.ExcelUtils;
import Configurations.GMethods;

public class ChannelFunctionalTestCases 
{	
	@BeforeTest()
	public void setExcelPath() throws Exception
	{
		ExcelUtils.setExcelFile(Constants.Path_ExcelData);	
	}
	
	//Login to Admin Console
	
	@Test(priority=1, groups = {"testDebug" })
	//@Test(priority=1, groups = {"Login","BR", "Allotment"})
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
			
			System.out.println("2. Admin Login");
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
	
	//This Test Case will Capture Allotment for a particulate date date in Admin Console first then will 
	//move to Frontdesk and will create a single reservation for the same date
	//and then again go to Admin Console and will check allotment update for the same date
	@Test(priority=2, groups = {"testDebug" })
	public void checkAllotmentUpdateForSingleReservation()
	{
		try {
				
		AdminHomePage AHP = new AdminHomePage();
		
		ListOfOtherGDSPage LOGP = AHP.landOnOtherGDSPackage();
		LOGP.verifyListOfOtherGDSPage();
		ManageAllotmentsPage MAP =LOGP.clickManageAllotments();
		MAP.verifyManageAllotmentsPage();
		MAP.getAllotmentForADay();
		
		AHP.clickFrontdeskLink();
		BasePage BP = new BasePage();
		FrontdeskContinueTrialPage FCT =BP.verifyPage();
		FrontdeskCashCounter FCC = FCT.clickContinueWithTrial();
		FrontdeskHomePage FHP =FCC.selectCounter();
		FrontdeskGrid FG = FHP.clickCancel();
		CreateReservation CR = FG.selectCurrentDateInCalender();
		EditView_Reservation EVR = CR.createSingleNightRes();
		PaymentPage PP = EVR.click_PaymentBtn();
		PP.getReservationID();
		GMethods.switchToWindow(AdminHomePage.AdminWindowID);
		
		//MAP.verifyManageAllotmentsPage();
		
		MAP.verifyAllotmentUpdate();
		
		} catch (Exception e) {
			e.getMessage();
			Assert.assertTrue(false);
		}
		
		
	}
	
	//This test case will cancel the same reservation create in TestCase "checkAllotmentUpdateForSingleReservation" from Frontdesk
	//and then will go to Admin Console and will check allotment update.
	@Test(priority=3, groups = {"testDebug" })
	public void CancelResAndCheckAllotment()
	{
		try {
			GMethods.switchToWindow(AdminHomePage.FrontdeskWindowID);
			
			FrontdeskHomePage FHP = new FrontdeskHomePage();
			ReservationSearchResultPage RSRP = FHP.searchResOnFrontdeskToCancel();
			ReservationViewDetailsPage RVP = RSRP.openReservation();
			EditView_Reservation EVRP = RVP.clickEnableEditing();
			PaymentPage PP =EVRP.cancel_reservation();
			PP.closeReservation();
			
			GMethods.switchToWindow(AdminHomePage.AdminWindowID);
			
			ManageAllotmentsPage MAP = new ManageAllotmentsPage();
			MAP.verifyAllotmentUpdateAfterCancel();
			Assert.assertTrue(true);
			
		} catch (Exception e) {
			System.out.println("Issue In Cancel res and Verify Allotment"+e.getMessage());
			Assert.assertTrue(false);
		}
	}
	
	//This test case will Create a DNR on Frontdesk and then will go to Admin Console and will check allotment update.
	@Test(priority=3, groups = {"testDebug" })
	public void CreateDNRAndCheckAllotment()
	{
		try {
			GMethods.switchToWindow(AdminHomePage.FrontdeskWindowID);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	
		//Get Allotment for a particular day
		//@Test(priority=18, groups = {"BR", "SendRate","ChannelManager"})
		//@Test(priority=17, groups = {"testDebug"})
		public void CaptureAllotment_TC_18()
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
		//@Test(priority=19, groups = {"BR", "SendRate","ChannelManager"})
		public void landOnAdminHome_TC_19()
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
		//@Test(priority=20, groups = {"BR","ChannelManager"})
		//@Test(priority=19, groups = {"testDebug"})
		public void pushbooking_TC_20()
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
		//@Test(priority=21, groups = {"testDebug"})
		//@Test(priority=21, groups = {"BR","ChannelManager"})
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
		//@Test(priority=22, groups = {"testDebug"})
		//@Test(priority=22, groups = {"BR","ChannelManager"})
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
		//@Test(priority=23, groups = {"BR","ChannelManager"})
		public void LogoutFrotdeskBackToAdminWindow_TC_24()
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
		//@Test(priority=23, groups = {"BR","ChannelManager"})
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
					String oldAllotmentValue = ManageAllotmentsPage.OldAllotmentValue;
					
					ManageAllotmentsPage MAP = new ManageAllotmentsPage();
					System.out.println("");
					MAP.getAllotmentForADay();
					
					//MAP.verifyAllotmentUpdate(oldAllotmentValue);
					
				} catch (Exception e) {
					System.out.println("Issue in Getting Allotment Value "+e.getMessage());
					Assert.assertTrue(false);
				}
				
			} catch (Exception e) {
				
			}
		}
		
		//Land On Admin Home
		//@Test(priority=24, groups = {"testDebug"})
		//@Test(priority=24, groups = {"BR", "SendRate","ChannelManager"})
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

		//@Test(priority=18, groups = {"testDebug" })
		public void debugCode()
		{
			try {
				System.out.println("3. Debugging Class : Channel Functional Test cases");
			} catch (Exception e) {
				
			}
		}

}
