package demos;

import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class trail {
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
	  map.put(" on "," off ");
	  map.put("on ","off ");
	  map.put(" on"," off");
	  map.put("on ","off ");
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

 