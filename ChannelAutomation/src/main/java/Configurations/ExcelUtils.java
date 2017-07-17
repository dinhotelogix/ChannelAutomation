package Configurations;

import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils 
{
	private static XSSFSheet ExcelWSheet;
    private static XSSFWorkbook ExcelWBook;
    private static org.apache.poi.ss.usermodel.Cell Cell;
    private static XSSFRow Row;
    public static String data;
    
    	public static void setExcelFile(String Path) throws Exception {
		try {
            FileInputStream ExcelFile = new FileInputStream(Path);
            ExcelWBook = new XSSFWorkbook(ExcelFile);
    		} catch (Exception e){
    		
    		}
    	}
    
    	public static String getExcelCellData(int rowNum,int colNum,String sheetName)
    	{
		try 
			{
			ExcelWSheet=ExcelWBook.getSheet(sheetName);
			Cell=ExcelWSheet.getRow(rowNum).getCell(colNum);
			Cell.setCellType(Cell.CELL_TYPE_STRING);
			data=Cell.getStringCellValue();
			//System.out.println(data);
			
			}
			catch(Exception e)
			{
				System.out.println("Issue in Getting Excel Data |"+e.getMessage());
	             return"";
			}
			return data;
		}
    	public static int getSheetRowCount(String SheetName)
        {
    		int iNumber=0;
    		try {
    			ExcelWSheet = ExcelWBook.getSheet(SheetName);
    			iNumber=ExcelWSheet.getLastRowNum()+1;
    		} catch (Exception e){
    			
    		}
    		return iNumber;
    	}
}