package com.sarthaks93.file_compressor.compressor.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sarthaks93.file_compressor.compressor.Compressor;

/**
 * 
 * @author sarthak
 *
 * @date 21-Feb-2019
 */

public class HuffmanCoding implements Compressor {
	
//	Logger log = LoggerFactory.getLogger(HuffmanCoding.class);

	@Override
	public void compress(String text) {
		System.out.println(text);
	}

}
