package com.sarthaks93.file_compressor.utils;

import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.BitSet;
import java.util.Date;

/**
 * 
 * @author sarthak
 *
 * @date 25-Feb-2019
 */

public class IOUtils {
	
	public static void encodeBitArray(BitSet bitArray, String code, int index) {
		for (int i = 0; i < code.length(); i++) {
			if (code.charAt(i) == '1') {
				bitArray.set(i + index, true);
			}
		}
		
	}
	
	public static BitSet cloneBitArray(BitSet bitArray, int size) {
		BitSet resultArray = new BitSet(size);
		
		for (int i = 0; i < size; i++) {
			if (bitArray.get(i)) {
				resultArray.set(i, true);
			}
		}
		
		return resultArray;
	}
	
	public static String writeBytesToFile(byte[] bytes) {
		String fileName = "";
		try {
			// get random filename
			fileName = generateFileName();
			// get output stream to write to file
			OutputStream os = new FileOutputStream(fileName);
			
			// write bytes to file
			os.write(bytes);
			
			// close the file
			os.close();
			
		} catch (Exception ex) {
			System.out.println(ex.toString());
		}
		
		return fileName;
	}
	
	private static String generateFileName() {
		Date d = new Date();
		String fileName = Long.toString(d.getTime()) + ".sar";
		return fileName;
	}

}
