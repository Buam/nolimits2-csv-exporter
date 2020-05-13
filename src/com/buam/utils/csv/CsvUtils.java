package com.buam.utils.csv;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CsvUtils {

	public static List<List<String>> load(CsvConfiguration config, String path) {
		List<List<String>> finalData = new ArrayList<>();
		
		BufferedReader reader;
		
		try {
			reader = new BufferedReader(new FileReader(path));

			String line;
			if(reader.readLine() == null) return finalData;
			while((line = reader.readLine()) != null) {
				String[] data = line.split(String.copyValueOf(new char[] {config.getSeperator()}));
				List<String> dat = new ArrayList<>();
				for(String s : data) {
					dat.add(s.trim());
				}
				finalData.add(dat);
			}
			
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return finalData;
	}
	
	public static void write(CsvConfiguration config, List<List<String>> data, String path) {
		BufferedWriter writer;
		try {
			writer = new BufferedWriter(new FileWriter(path));
			for(int i = 0; i<config.getKeys().length-1; i++) {
				writer.write(config.getKeys()[i] + config.getSeperator());
			}
			writer.write(config.getKeys()[config.getKeys().length-1]);
			writer.newLine();
			for(List<String> ls : data) {
				for(int i = 0; i<ls.size()-1; i++) {
					writer.write(ls.get(i) + config.getSeperator());
				}
				writer.write(ls.get(ls.size()-1));
				
				writer.newLine();
			}
			writer.close();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
}
