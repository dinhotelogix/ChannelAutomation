package ChannelAutomation.Reservations;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;

import Configurations.Constants;
import Configurations.GMethods;

public class BusyRoomsPushReservation 
{
	public static String ResID;
	public static String fromDate; 
	public static String toDate;
	public static String ResInRoomType;
	//Mehtod for Push Booking through XML
	public void pushBooking()
	{
		try {
			//String fromDate = "2017-06-17";
			fromDate = GMethods.getAddedCurrentYearMonthDate(Constants.fromDate_ResAddDays);
			//String toDate = "2017-06-18";
			toDate = GMethods.getAddedCurrentYearMonthDate(Constants.toDate_ResAddDays);
			ResInRoomType = Constants.PushResInRoomType;
			
			ResID = Constants.ChannelManagerCode+GMethods.getUniqueNumber();
			
			HttpResponse<String> response = Unirest.post(""+Constants.MiddleManServer+"push/reservation/ch_type/"+Constants.ChannelManagerCode+"")
					  .header("content-type", "application/xml")
					  .header("cache-control", "no-cache")
					  .header("postman-token", "f8e4007a-24d9-8f13-72b4-78508a81086a")
					  .body("<?xml version=\"1.0\" encoding=\"utf-8\" ?>\r\n<OTA_HotelResNotifRQ\r\n    xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\"\r\n    xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" ResStatus=\"commit\" TimeStamp=\"2015-10-31T15:35:19.9636812Z\" EchoToken=\"10056f70-c5a7-4851-b01b-4288db44825d\" Version=\"1.003\">\r\n    <POS\r\n        xmlns=\"http://www.opentravel.org/OTA/2003/05\">\r\n        <Source>\r\n            <RequestorID ID=\"FabHotels\" Type=\"22\" />\r\n            <BookingChannel Primary=\"true\" Type=\"5\">\r\n                <CompanyName Code=\"TravelGuru\">TravelGuru</CompanyName>\r\n            </BookingChannel>\r\n        </Source>\r\n    </POS>\r\n    <HotelReservations\r\n        xmlns=\"http://www.opentravel.org/OTA/2003/05\">\r\n        <HotelReservation CreatorID=\"MakeMyTrip\" CreateDateTime=\"2015-12-09T14:20:23\">\r\n            <UniqueID ID=\""+ResID+"\" Type=\"14\" />\r\n            <RoomStays>\r\n                <RoomStay SourceOfBusiness=\"MakeMyTrip\">\r\n                    <RoomRates>\r\n                        <RoomRate RatePlanCode=\"TRR\" NumberOfUnits=\"1\" RoomTypeCode=\""+ResInRoomType+"\">\r\n                            <Rates>\r\n                                <Rate RateTimeUnit=\"Day\" UnitMultiplier=\"1\" EffectiveDate=\""+fromDate+"\" ExpireDate=\""+toDate+"\">\r\n                                    <Base AmountAfterTax=\"1006.40\" CurrencyCode=\"INR\" />\r\n                                </Rate>\r\n                            </Rates>\r\n                        </RoomRate>\r\n                    </RoomRates>\r\n                    <GuestCounts IsPerRoom=\"true\">\r\n                        <GuestCount AgeQualifyingCode=\"10\" Count=\"1\" />\r\n                        <GuestCount AgeQualifyingCode=\"8\" Count=\"0\" />\r\n                    </GuestCounts>\r\n                    <TimeSpan End=\""+toDate+"\" Start=\""+fromDate+"\" />\r\n                    <DepositPayments>\r\n                        <GuaranteePayment>\r\n                            <AmountPercent CurrencyCode=\"INR\" Amount=\"903.41\" />\r\n                        </GuaranteePayment>\r\n                    </DepositPayments>\r\n                    <Total AmountAfterTax=\"1004.59\" CurrencyCode=\"INR\" />\r\n                    <BasicPropertyInfo HotelCode=\"9317\" />\r\n                    <ResGuestRPHs>\r\n                        <ResGuestRPH RPH=\"0\" />\r\n                    </ResGuestRPHs>\r\n                    <Comments>\r\n                        <Comment Name=\"Tax_on_Net\">\r\n                            <Text>75.89</Text>\r\n                        </Comment>\r\n                    </Comments>\r\n                </RoomStay>\r\n            </RoomStays>\r\n            <ResGuests>\r\n                <ResGuest ResGuestRPH=\"0\">\r\n                    <Profiles>\r\n                        <ProfileInfo>\r\n                            <Profile ProfileType=\"1\">\r\n                                <Customer>\r\n                                    <PersonName>\r\n                                        <GivenName>One</GivenName>\r\n                                        <Surname>Test</Surname>\r\n                                    </PersonName>\r\n                                </Customer>\r\n                            </Profile>\r\n                        </ProfileInfo>\r\n                    </Profiles>\r\n                </ResGuest>\r\n            </ResGuests>\r\n            <ResGlobalInfo>\r\n                <HotelReservationIDs>\r\n                    <HotelReservationID ResID_Type=\"24\" ResID_Value=\""+ResID+"\" />\r\n                </HotelReservationIDs>\r\n            </ResGlobalInfo>\r\n        </HotelReservation>\r\n    </HotelReservations>\r\n</OTA_HotelResNotifRQ>")
					  .asString();
			
			System.out.println("Booking ID | "+ResID+" | Status Message | "+response.getStatus());
						
		} catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
}