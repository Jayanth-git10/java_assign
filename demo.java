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

/*
 * public class demo {
 * 
 * public static void main(String[] args) throws IOException { // TODO
 * Auto-generated method stub
 * 
 * String excelfile=".\\files\\Word Substitutions.xlsx";
 * 
 * 
 * FileInputStream inputstream=new FileInputStream(excelfile);
 * 
 * XSSFWorkbook workbook=new XSSFWorkbook(inputstream); XSSFSheet sheet =
 * workbook.getSheetAt(0);
 * 
 * 
 * Map<String, String> map = new HashMap<String, String>();
 * 
 * for (int r = 0; r <= sheet.getLastRowNum(); r++) { String key =
 * sheet.getRow(r).getCell(0).getStringCellValue(); String value =
 * sheet.getRow(r).getCell(1).getStringCellValue(); map.put(key, value); }
 * 
 * Iterator<Entry<String, String> > new_Iterator = map.entrySet().iterator();
 * while (new_Iterator.hasNext()) { Map.Entry<String, String> new_Map =
 * (Map.Entry<String, String>) new_Iterator.next();
 * System.out.println(new_Map.getKey() + "\t|" + new_Map.getValue()); }
 * workbook.close(); inputstream.close();
 * 
 * } }
 */



/*
 * import java.io.FileInputStream; import java.io.IOException; import
 * java.util.HashMap; import java.util.Iterator; import java.util.Map; import
 * java.util.Map.Entry; import org.apache.poi.xssf.usermodel.XSSFSheet; import
 * org.apache.poi.xssf.usermodel.XSSFWorkbook;
 * 
 * 
 * 
 * class exceldata { public void geekforgeeks() throws IOException {
 * 
 * FileInputStream file = new FileInputStream(
 * ".\\files\\Word Substitutions.xlsx"); XSSFWorkbook wb = new
 * XSSFWorkbook(file); XSSFSheet sh = wb.getSheet("Sheet1");
 * 
 * HashMap<String, String> map = new HashMap<String, String>();
 * 
 * for (int r = 0; r <= sh.getLastRowNum(); r++) { String key =
 * sh.getRow(r).getCell(0).getStringCellValue(); String value = sh.getRow(r)
 * .getCell(1) .getStringCellValue(); map.put(key, value); }
 * 
 * // Displaying HashMap Iterator<Entry<String, String> > new_Iterator =
 * map.entrySet().iterator();
 * 
 * while (new_Iterator.hasNext()) { Map.Entry<String, String> new_Map =
 * (Map.Entry<String, String>) new_Iterator.next();
 * 
 * System.out.println(new_Map.getKey() + "|" + new_Map.getValue()); }
 * wb.close(); file.close(); } }
 */




/*public class demo {

public static void main(String[] args) throws IOException {
	// TODO Auto-generated method stub
	
	String excelfile=".\\files\\Word Substitutions.xlsx";
	
	try {
		
	FileInputStream inputstream=new FileInputStream(excelfile);
	
	XSSFWorkbook workbook=new XSSFWorkbook(inputstream);
	XSSFSheet sheet = workbook.getSheetAt(0);
	
	Iterator itr = sheet.iterator(); 
	
	while (itr.hasNext())                 
	{  
	XSSFRow row =(XSSFRow) itr.next();  
	Iterator cellIterator = row.cellIterator();   //iterating over each column  
	
	while (cellIterator.hasNext())   
	{  
	XSSFCell cell =(XSSFCell) cellIterator.next();
	
	switch (cell.getCellType())               
	{  
	case STRING:    //field that represents string cell type  
	System.out.print(cell.getStringCellValue());  
	System.out.print("\t\t");
	break;
	default:  
	}  
	}  
	System.out.println("");  
	}  
	}  
	
	catch(Exception e)  
	{  
	e.printStackTrace();  
	}  
	}  
}
*/



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
