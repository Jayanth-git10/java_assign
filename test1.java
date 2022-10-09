package testing;


import java.io.FileInputStream;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;



import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

class Fullcode {
	
   public static void main(String[] args) throws Exception {
    Map<String, String> variableMap = fillMap();
    Path path=Paths.get(".\\files\\x.txt");
    
    Stream<String> lines;
    
    try 
    {
    	
    lines = Files.lines(path);
    
    List<String> replacedLines = lines.map(line -> replaceTag(line, variableMap)).collect(Collectors.toList());
    
    Files.write(path, replacedLines);
    lines.close();
    System.out.println("replace done.");
    
    }
    catch(Exception e) {e.printStackTrace();}
    
  }
  
  
  public static Map<String,String> fillMap() 
  {
	  Map<String,String> map = new HashMap<String,String>();
	  String excelfile=".\\files\\Word Substitutions.xlsx";
	  String[][] s= new String[101][2];
	  int a=0,b=0;
	  
	  try {
	  	
	  FileInputStream inputstream=new FileInputStream(excelfile);

	  XSSFWorkbook workbook=new XSSFWorkbook(inputstream);
	  XSSFSheet sheet = workbook.getSheetAt(0);

	  int rows=sheet.getLastRowNum();
	  int cols=sheet.getRow(1).getLastCellNum();
	  
	  a=rows; b=cols;

	  for(int r=0;r<=rows;r++) 
	  {
	  	XSSFRow row =sheet.getRow(r);
	  	for (int c=0;c<cols;c++) 
	  	{
	  		XSSFCell cell =row.getCell(c);
	  		s[r][c]=cell.getStringCellValue();
	  	} 
	  }
	  
	  }
	  catch(Exception e)  
	  {  
	  e.printStackTrace();  
	  }  
	  for (int i=1; i<=a;i++) 
	  {
		  map.put(s[i][0],s[i][1]);
	  }
	  
	  return map;
  }
  
  
  private static String replaceTag(String str, Map<String,String> map) 
  {
	for (Map.Entry<String,String> entry : map.entrySet()) 
	{
		if (str.contains(entry.getKey())) {
			str = str.replace(entry.getKey(), entry.getValue());
		}
	}
	return str;
  }
  
}



//map.put("on ","off "); map.put(" on"," off"); map.put("on ","off ");
//String s1=s[17][0];
//System.out.println(s1);
//System.out.println(a);System.out.println(b);