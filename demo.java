package demos;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;





// using for loop

class demo{
public static void main(String[] args) throws IOException {
	// TODO Auto-generated method stub
	
String excelfile=".\\files\\Word Substitutions.xlsx";

try {
	
FileInputStream inputstream=new FileInputStream(excelfile);

XSSFWorkbook workbook=new XSSFWorkbook(inputstream);
XSSFSheet sheet = workbook.getSheetAt(0);

int rows=sheet.getLastRowNum();
int cols=sheet.getRow(1).getLastCellNum();

for(int r=1;r<=rows;r++) 
{
	XSSFRow row =sheet.getRow(r);
	for (int c=0;c<cols;c++) 
	{
		XSSFCell cell =row.getCell(c);
		
		System.out.print(cell.getStringCellValue());
		System.out.print("\t\t");
		
	} 
System.out.println("");
}
}catch(Exception e)  
{  
e.printStackTrace();  
}  
}
}
