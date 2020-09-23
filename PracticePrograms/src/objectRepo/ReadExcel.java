package objectRepo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class ReadExcel 
{
  @Test
  public void readExcelData() throws IOException 
  {
	  FileInputStream fis=new FileInputStream("C:\\Users\\Vatsa\\Desktop\\DemoDeal.xlsx"); //Location of the file
	  XSSFWorkbook workbook=new XSSFWorkbook(fis); //Read data from passed file
	  int sheetCount=workbook.getNumberOfSheets(); //Get the number of sheets in the workbook
	  
	  for(int i=0;i<sheetCount;i++)
	  {
		  if(workbook.getSheetName(i).equalsIgnoreCase("TestData"))
		  {
			  XSSFSheet sheet=workbook.getSheetAt(i);
			  Iterator<Row> rowIterator=sheet.rowIterator();
			  while(rowIterator.hasNext())
			  {
				  Row row=rowIterator.next();
				  Iterator<Cell> cellIterator=row.cellIterator();
				  while(cellIterator.hasNext())
				  {
					  Cell cell=cellIterator.next();
				  }
			  }
		  }
	  }

	  
	  
	  
	  
  }
}
