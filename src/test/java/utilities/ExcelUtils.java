package utilities;

import setup.PropertyUtils;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class ExcelUtils {

    private static XSSFSheet ExcelWSheet;

    private static XSSFWorkbook ExcelWBook;

    private static XSSFCell Cell;
   public static int firstUpdatedRowIndex;
   static PropertyUtils propertyUtils = new PropertyUtils();

    private static XSSFRow Row;
    private static final String sheetName=propertyUtils.getPropertyValue("sheetName");

    //This method is to set the File path. Arguments are ExcelFilePath and SheetName

    public static void setExcelFile(String path,String sheetName) throws Exception {

        try {
            propertyUtils=new PropertyUtils();

            // Open the Excel file

            FileInputStream excelFile = new FileInputStream(path);

            // Access the required test data sheet

            ExcelWBook = new XSSFWorkbook(excelFile);

            ExcelWSheet = ExcelWBook.getSheet(sheetName);

        } catch (Exception e){

            throw (e);

        }

    }
    //This method returns the last column number
    public static int getLastColNumber(int row){
        int LastColumnNumber = ExcelWSheet.getRow(row).getLastCellNum();
        return LastColumnNumber;

    }

    //This method is to read the test data from the Excel cell, in this we are passing parameters as Row number and Col number

    public static String getCellData(String filePath,String sheetName, int RowNum, int ColNum) throws Exception{

        try{
            propertyUtils=new PropertyUtils();

            // Open the Excel file

            FileInputStream excelFile = new FileInputStream(filePath);

            // Access the required test data sheet


            ExcelWBook = new XSSFWorkbook(excelFile);

           ExcelWSheet = ExcelWBook.getSheet(sheetName);

            Cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);

            return Cell.toString();

        }catch (Exception e){
            e.printStackTrace();
            return"";

        }

    }

    //This method is to write in the Excel cell, Row num and Col num are the parameters

    public static void setCellData(String Result,  int RowNum, int ColNum) throws Exception	{

        try{
            propertyUtils=new PropertyUtils();

            // Open the Excel file

            FileInputStream excelFile = new FileInputStream(propertyUtils.getPropertyValue("excelPath"));

            // Access the required test data sheet


            ExcelWBook = new XSSFWorkbook(excelFile);

            ExcelWSheet = ExcelWBook.getSheet(sheetName);

            Row  = ExcelWSheet.getRow(RowNum);

            Cell = Row.getCell(ColNum);

            if (Cell == null) {

                Cell = Row.createCell(ColNum);

                Cell.setCellValue(Result);

            } else {

                Cell.setCellValue(Result);

            }

            // Constant variables Test Data path and Test Data file name

            FileOutputStream fileOut = new FileOutputStream(propertyUtils.getPropertyValue("Path_TestData"));

            ExcelWBook.write(fileOut);

            fileOut.flush();

            fileOut.close();

        }catch(Exception e){

            throw (e);

        }

    }

}
