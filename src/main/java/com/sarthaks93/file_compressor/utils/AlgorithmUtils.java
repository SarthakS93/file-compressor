package com.sarthaks93.file_compressor.utils;

import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;

import com.sarthaks93.file_compressor.common.HuffmanBytesData;

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
	
	public static HuffmanBytesData createBitArray(String text, Map<String, String> prefixMap) {
		// create a bit array
		BitSet bitArray = new BitSet();
		int startIndex = 0, endIndex = 0, bitArrayIndex = 0;

		// loop over text
		while (endIndex < text.length()) {
			
			// get current substring
			String prefix = text.substring(startIndex, endIndex + 1);
			String prefixCode = prefixMap.get(prefix);
			
			// prefix found
			if (prefixCode != null) {
				// append prefix code in code
				IOUtils.encodeBitArray(bitArray, prefixCode, bitArrayIndex);
				bitArrayIndex += prefixCode.length();
				startIndex = endIndex + 1;
			}
			// prefix not found in prefix map
			else {
				System.out.println(prefix + " not found in prefix map");
			}
			
			//  increment loop iterator
			endIndex++;
		}
		
		HuffmanBytesData huffmanData = new HuffmanBytesData();
		huffmanData.setHuffmanData(bitArray);
		huffmanData.setHuffmanDataLength(bitArrayIndex);
		
		return huffmanData;
	}

}
