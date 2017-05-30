package codefun;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class StringCompare {

	public static void main(String[] args) {		
		// Read file
		String goodStr = readFile("/Users/sjangra/temp/msg/good.decode");
		String badStr = readFile("/Users/sjangra/temp/msg/bad.decode");
		
		System.out.println("GOOD..........");
		System.out.println(goodStr);
		
		char[] goodArr = goodStr.toCharArray();
		char[] badArr = badStr.toCharArray();
		
		System.out.println(goodArr.length);
		System.out.println(badArr.length);
		
		int[] compare = new int[goodArr.length];
		
		for(int i = 0; i<goodArr.length; i++) {
			if(goodArr[i] == badArr[i]) {
				compare[i] = 0;
			} else {
				compare[i] = 1;
			}
		}
		System.out.println(Arrays.toString(compare));

		for(int i = 0; i<compare.length; i++) {
			if(compare[i] == 1) {
				
			}
		}
	}
	
	private static void writeFile(String input) {
		try {
			 
			File file = new File("/Users/sjangra/temp/msg/compare");
 
			// if file doesnt exists, then create it
			if (!file.exists()) {
				System.out.println("create new");
				file.createNewFile();
			}
 
			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(input);
			bw.close();
 
			System.out.println("Done");
 
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}

	private static String readFile(String fileName) {
		BufferedReader br = null;
		String output = null; 
		try {
 
			String sCurrentLine;
 
			br = new BufferedReader(new FileReader(fileName));
 
			while ((sCurrentLine = br.readLine()) != null) {
				output = sCurrentLine;
				System.out.println(sCurrentLine);
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
		return output;
	}
}
