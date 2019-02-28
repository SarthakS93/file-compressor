package com.sarthaks93.file_compressor.common;

import java.io.Serializable;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Map;

/**
 * 
 * @author sarthak
 *
 * @date 28-Feb-2019
 */

public class HuffmanBytesData implements Serializable {

	/**
	 * serial version id of class
	 */
	private static final long serialVersionUID = -8111513073731235072L;
	
	
//	private byte[] bytes;
	
	private Integer charactersCount;
	
	private Integer huffmanDataLength;
	
	private BitSet huffmanData;
	
	private Map<String, String> prefixMap;
	
	private String fileName;
	
	
	// constructor methods
	
	public HuffmanBytesData() {}
	
	public HuffmanBytesData(Integer charactersCount, Integer huffmanDataLength) {
		this.charactersCount = charactersCount;
		this.huffmanDataLength = huffmanDataLength;
	}
	
	
	// Getter, Setter methods

//	public byte[] getBytes() {
//		return bytes;
//	}
//
//	public void setBytes(byte[] bytes) {
//		this.bytes = new byte[bytes.length];
//		for (int i = 0; i < bytes.length; i++) {
//			this.bytes[i] = bytes[i];
//		}
//	}

	public Integer getCharactersCount() {
		return charactersCount;
	}

	public void setCharactersCount(Integer charactersCount) {
		this.charactersCount = charactersCount;
	}

	public Integer getHuffmanDataLength() {
		return huffmanDataLength;
	}

	public void setHuffmanDataLength(Integer huffmanDataLength) {
		this.huffmanDataLength = huffmanDataLength;
	}

	public BitSet getHuffmanData() {
		return huffmanData;
	}

	public void setHuffmanData(BitSet huffmanData) {
		this.huffmanData = huffmanData;
	}

	public Map<String, String> getPrefixMap() {
		return prefixMap;
	}

	public void setPrefixMap(Map<String, String> prefixMap) {
		this.prefixMap = prefixMap;
	}
	
	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	
	// toString method
	
//	@Override
//	public String toString() {
//		return "HuffmanBytesData [bytes=" + Arrays.toString(bytes) + ", charactersCount=" + charactersCount
//				+ ", huffmanDataLength=" + huffmanDataLength + ", huffmanData=" + huffmanData + ", prefixMap="
//				+ prefixMap + "]";
//	}
	

}
