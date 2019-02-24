package com.sarthaks93.file_compressor.utils;

import java.util.HashMap;
import java.util.Map;

public class AlgorithmUtils {
	
	public static Map<String, Integer> getFrequencyMap(String text) {
		Map<String, Integer> frequencyMap = new HashMap<String, Integer>();
		
		for (int i = 0; i < text.length(); i++) {
			String s = text.substring(i, i + 1);
			Integer count = frequencyMap.get(s);
			if (count == null) {
				count = 1;
			}
			else {
				count++;
			}
			frequencyMap.put(s, count);
		}
		
		return frequencyMap;
	}

}
