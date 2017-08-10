package ChannelAutomation.Admin.Test;

import org.testng.Assert;
import org.testng.annotations.Test;

import ChannelAutomation.Admin.Base.AdminHomePage;
import ChannelAutomation.Admin.Base.BasePage;
import ChannelAutomation.Admin.VB.ListOfOtherGDSPage;
import ChannelAutomation.Admin.VB.ListofPackagesPage;
import ChannelAutomation.Admin.VB.ManageAllotmentsPage;
import ChannelAutomation.Frontdesk.Login.FrontdeskCashCounter;
import ChannelAutomation.Frontdesk.Login.FrontdeskContinueTrialPage;
import ChannelAutomation.Frontdesk.Login.FrontdeskLoginPage;
import ChannelAutomation.Frontdesk.TapeChart.FrontdeskHomePage;
import ChannelAutomation.Frontdesk.TapeChart.ReservationSearchResultPage;
import ChannelAutomation.Frontdesk.TapeChart.ReservationViewDetailsPage;
import ChannelAutomation.Reservations.BusyRoomsPushReservation;

public class ChannelFunctionalTestCases 
{
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


}
