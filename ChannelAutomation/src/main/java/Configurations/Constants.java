package Configurations;

public class Constants 
{	//Test Commit
	//public static final String Path_OR = "E:\\ChannelAutomation\\ChannelAutomation\\src\\main\\java\\Configurations\\OR.txt";
	public static final String Path_ExcelData ="D:\\DD\\ChannelAutomationRepo\\ChannelAutomation\\OtherFiles\\CMData.xlsx";
	public static final String Sheet_Credentials = "Credentials";
	public static final String Sheet_TestData = "TestData";
		
	//================Room Type Codes=====================
	
	//------------    VB      ---------------
	//public static final String RoomCode1 = "FFS";
	//public static final String RoomCode2 = "GFS";
	
	//------------    BusyRooms    ------------
	public static final String RoomCode1 = "11913";
	public static final String RoomCode2 = "11917";
	
	//public static final String ServerURL ="http://livestable.hx.local/admine/login";
	public static final String Browser = "FF";
	
	public static final String ServerURL = "https://staygrid.com/admine/login/login/redirect/1/rurl/JTJGYWRtaW5l";
	//public static final String ServerURL ="http://hotelogix.stayezee.com/admine/login/login/";

	public static final int WaitForCaptcha = 10; 
	public static final int AddDays = 15;
	public static final int fromDate_ResAddDays = 2;
	public static final int toDate_ResAddDays = 3;
	
	//-------------Login Details----------------------
	public static final String HotelID = "708";
	public static final String EmailID = "din.dayal@hotelogix.com";
	public static final String Pass = "111111";
		
	//-----------Livestable Middle Man server--------------------------
		//public static final String MiddleManServer = "http://middleman.hx.local/";
		//-----------DotNet middle Man Server-----------------------------
		//public static final String MiddleManServer = "http://mmdemo.stayezee.com/";
		//-----------Staygrid Middle Man Server---------------------------
		public static final String MiddleManServer = "https://mmlive.stayezee.com/";
		
		//-----------------Busy Rooms Channel manager Code---------------------------
		public static final String ChannelManagerCode = "BZR";
		
		//----------------Push Booking in Room Type----------------------
		public static final String PushResInRoomType = "11913";
		//public static final String PushResInRoomType = "11917";
		
	
	public static final String BackgroundColor_Success = "rgba(240, 249, 255, 1)";
	public static final String BackgroundColor_Fail = "rgba(255, 93, 93, 1)";
	public static final String BackgroundColor_InProgress = "rgba(252, 215, 65, 1)";
	public static final String BackgroundColor_RuleSuccess ="transparent";
	
	public static final int FirstColumn = 0;
	public static final int SecondColumn = 1;
	public static final int ThirdColumn = 2;
	public static final int FourthColumn = 3;
	public static final int FifthColumn = 4;
	public static final int SixthColumn = 5;
	public static final int SeventhColumn = 6;
	public static final int EighthColumn = 7;
	public static final int NinethColumn = 8;
	public static final int TenthColumn = 9;
	public static final int EleventhColumn = 10;
	
}
