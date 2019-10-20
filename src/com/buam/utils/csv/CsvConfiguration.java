package com.buam.utils.csv;

import java.util.List;

public class CsvConfiguration {

	private String[] keys;
	private char seperator;
	
	public CsvConfiguration(List<String> keys, char seperator) {
		this.setKeys((String[]) keys.toArray());
		this.setSeperator(seperator);
	}
	
	public CsvConfiguration(String[] keys, char seperator) {
		this.setKeys(keys);
		this.setSeperator(seperator);
	}

	public String[] getKeys() {
		return keys;
	}
	
	public char getSeperator() {
		return seperator;
	}

	public void setKeys(String[] keys) {
		this.keys = keys;
	}
	
	public void setSeperator(char seperator) {
		this.seperator = seperator;
	}
	
}
