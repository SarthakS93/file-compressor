package com.sarthaks93.file_compressor.decompress.service;

import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;

import com.sarthaks93.file_compressor.common.HuffmanBytesData;
import com.sarthaks93.file_compressor.compressor.service.HuffmanCodingCompressor;
import com.sarthaks93.file_compressor.decompress.Decompressor;
import com.sarthaks93.file_compressor.utils.AlgorithmUtils;
import com.sarthaks93.file_compressor.utils.IOUtils;

public class HuffmanCodingDecompressor implements Decompressor {

	@Override
	public void decompress(String fileName) {
		System.out.println("Decompress " + fileName);
		
		HuffmanBytesData huffmanData = IOUtils.readHuffmanDataFromFile(fileName);
		
		String text = getTextFromBitArray(huffmanData);
		
	}
	
	
	private String getTextFromBitArray(HuffmanBytesData huffmanData) {
		String text = "";
		
		Map<String, String> prefixMapReverse = new HashMap<String, String>();
		for (Map.Entry<String, String> entry : huffmanData.getPrefixMap().entrySet()) {
			prefixMapReverse.put(entry.getValue(), entry.getKey());
		}
		
		System.out.println(huffmanData.getHuffmanData().size());
		
		int n = huffmanData.getHuffmanDataLength();
		
		String code = "";
		
		int startIndex = 0, endIndex = 0;
		
		while (endIndex < n) {
			if (huffmanData.getHuffmanData().get(endIndex)) {
				code += "1";
			}
			else {
				code += "0";
			}
			
			String prefix = prefixMapReverse.get(code); 
			
			if (prefix != null) {
				code = "";
				startIndex = endIndex + 1;
				text += prefix;
			}
			
			endIndex++;
		}
		
		if (code != "") {
			System.out.println("Trailing code not blank");
		}
		
		System.out.println(text);
		
		return text;
	}
	

}
