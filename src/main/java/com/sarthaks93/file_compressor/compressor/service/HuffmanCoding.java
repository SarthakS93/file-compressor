package com.sarthaks93.file_compressor.compressor.service;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.PriorityQueue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sarthaks93.file_compressor.common.HuffmanTreeNode;
import com.sarthaks93.file_compressor.compressor.Compressor;
import com.sarthaks93.file_compressor.utils.AlgorithmUtils;
import com.sarthaks93.file_compressor.utils.Constants;
import com.sarthaks93.file_compressor.utils.Pair;

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
		
		buildHuffmanTree(text);
		
		
		
		
	}
	
	
	private HuffmanTreeNode buildHuffmanTree(String text) {
		
		// get frequency map
		Map<String, Integer> frequencyMap = AlgorithmUtils.getFrequencyMap(text);
		
		// create a priority queue (min heap)
		PriorityQueue<HuffmanTreeNode> pq = new PriorityQueue<HuffmanTreeNode>();
		
		// put data in min heap
		for (Map.Entry<String, Integer> entry : frequencyMap.entrySet()) {
			pq.add(new HuffmanTreeNode(entry.getValue(), entry.getKey()));
		}
		
		while (pq.size() > 1) {
			HuffmanTreeNode firstNode = pq.poll();
			HuffmanTreeNode secondNode = pq.poll();
			
			HuffmanTreeNode parentNode = new HuffmanTreeNode(firstNode.getFrequency() + secondNode.getFrequency(), null);
			parentNode.setLeft(firstNode);
			parentNode.setRight(secondNode);
			
			pq.add(parentNode);
		}
		
		return pq.poll();
	}


}
