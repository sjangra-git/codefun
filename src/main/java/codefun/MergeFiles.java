package codefun;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class MergeFiles {

	public static void main(String[] args) {
		String[] files = {};
		
		Map<String, String> map1 = getMapFromFile("");
		Map<String, String> map2 = getMapFromFile("");
		Map<String, String> map3 = getMapFromFile("");
		Map<String, String> map4 = getMapFromFile("");
		Map<String, String> map5 = getMapFromFile("");
		
		try {			 			
 
			File file = new File("/tmp/mergeOut");
 
			// if file doesnt exists, then create it
			if (!file.exists()) {
				file.createNewFile();
			}
 
			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);
			
			for(Map.Entry<String, String> entry : map1.entrySet()) {
				
				String key = entry.getKey();
				String line = key + " " + entry.getValue();
				
				if(map2.containsKey(key)) {
					line += " " + map2.get(key);
				}
				
				if(map3.containsKey(key)) {
					line += " " + map3.get(key);
				}
				
				if(map4.containsKey(key)) {
					line += " " + map4.get(key);
				}

				if(map5.containsKey(key)) {
					line += " " + map5.get(key);
				}

				bw.write(line);
				bw.newLine();
			}
			
			bw.close();
 
			System.out.println("Done");
 
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
	
	private static Map<String, String> getMapFromFile(String fileName) {
		BufferedReader br = null;
		Map<String, String> map = new HashMap<String, String>();
		try {
 
			String sCurrentLine;
 
			br = new BufferedReader(new FileReader(fileName));
 
			while ((sCurrentLine = br.readLine()) != null) {
				String[] line = sCurrentLine.split("\\s+");
				map.put(line[0], sCurrentLine.substring(line[0].length() + 1));
			}
			
 
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null)br.close();
				
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		return map;
	}
}
