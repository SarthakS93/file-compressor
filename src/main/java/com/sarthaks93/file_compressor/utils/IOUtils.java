package com.sarthaks93.file_compressor.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.BitSet;
import java.util.Date;

import com.sarthaks93.file_compressor.common.HuffmanBytesData;

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
		return "abc.sar";
	}
	
	public static byte[] readBytesFromFile(String fileName) {
		File file = new File(fileName);
		// initialize array with file length
		byte[] bytesArray = new byte[(int) file.length()]; 
		
		FileInputStream fis;
		try {
			fis = new FileInputStream(file);
			//read file into bytes[]
			fis.read(bytesArray);
			fis.close();
		} catch (Exception ex) {
			System.out.println(ex.toString());
		}
					
		return bytesArray;
	}
	
	public static void writeHuffmanDataToFile(HuffmanBytesData huffmanData) {
		try {
			FileOutputStream fos = new FileOutputStream("abc.sar");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			// write object to file
			oos.writeObject(huffmanData);
			System.out.println("Done");
			// closing resources
			oos.close();
			fos.close();
		} catch (Exception ex) {
			System.out.println(ex.toString());
		}
	}
	
	public static HuffmanBytesData readHuffmanDataFromFile(String fileName) {
		try {
			FileInputStream is = new FileInputStream(fileName);
			ObjectInputStream ois = new ObjectInputStream(is);
			HuffmanBytesData huffmanData = (HuffmanBytesData) ois.readObject();

			ois.close();
			is.close();
			
			return huffmanData;
		} catch (Exception ex) {
			System.out.println(ex.toString());
		}
		return null;
	}
	
	public static String readStringFromFile(String fileName) {
		String text = "";
		try {
			File file = new File(fileName);
			FileInputStream fis = new FileInputStream(file);
			InputStreamReader isr = new InputStreamReader(fis);
			BufferedReader br = new BufferedReader(isr);

			String line;
			int ctr = 0;
			while((line = br.readLine()) != null){
				
			     //process the line
//			     System.out.println(line);
				text += line + "\n";
			    ctr++;
			}
			System.out.println(ctr);
			if (text.charAt(text.length() - 1) == '\n') {
				text = text.substring(0, text.length() - 1);
			} 
			br.close();
		} catch (Exception ex) {
			System.out.println(ex.toString());
		}
		
		System.out.println(text);
		
		return text;
	}
	

}
