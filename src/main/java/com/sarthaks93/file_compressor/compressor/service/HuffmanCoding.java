package com.sarthaks93.file_compressor.compressor.service;

import java.util.Comparator;
import java.util.HashMap;
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
		
		HuffmanTreeNode root = buildHuffmanTree(text);
		
		Map<String, String> prefixMap = createPrefixMap(root);
		
		
	}
	
	// build the Huffman Tree
	private HuffmanTreeNode buildHuffmanTree(String text) {
		
		// get frequency map
		Map<String, Integer> frequencyMap = AlgorithmUtils.getFrequencyMap(text);
		
		// create a priority queue (min heap)
		PriorityQueue<HuffmanTreeNode> pq = createPriorityQueue(frequencyMap);
		
		while (pq.size() > 1) {
			// remove the 2 lowest out of the queue
			HuffmanTreeNode firstNode = pq.poll();
			HuffmanTreeNode secondNode = pq.poll();
			
			// create a parent node by summing their frequencies
			HuffmanTreeNode parentNode = new HuffmanTreeNode(firstNode.getFrequency() + secondNode.getFrequency(), null);
			parentNode.setLeft(firstNode);
			parentNode.setRight(secondNode);
			
			// add the parent node back in the queue
			pq.add(parentNode);
		}
		
		return pq.poll();
	}
	
	
	// create a priority queue (min heap) from the frequency map
	private PriorityQueue<HuffmanTreeNode> createPriorityQueue(Map<String, Integer> frequencyMap) {
		PriorityQueue<HuffmanTreeNode> pq = new PriorityQueue<HuffmanTreeNode>();
		
		// put data in min heap
		for (Map.Entry<String, Integer> entry : frequencyMap.entrySet()) {
			pq.add(new HuffmanTreeNode(entry.getValue(), entry.getKey()));
		}
		
		return pq;
	}
	
	Map<String, String> createPrefixMap(HuffmanTreeNode root) {
		Map<String, String> prefixMap = new HashMap<String, String>();
		
		if (root != null) {
			createPrefixMapHelper(root, prefixMap, new StringBuilder());
		}
		
		System.out.println(prefixMap);
		
		return prefixMap;
	}
	
	private void createPrefixMapHelper(HuffmanTreeNode root, Map<String, String> prefixMap, StringBuilder prefix) {
		// check if root is null
		if (root == null) {
			return;
		}
		// for leaf node, put entry in prefix map
		else if (root.isLeftEmpty() && root.isRightEmpty()) {
			prefixMap.put(root.getData(), prefix.toString());	
			return;
		}
		
		// process for left child
		
		// append 0 in prefix string for left child
		prefix.append('0');
		// call for left child
		createPrefixMapHelper(root.getLeft(), prefixMap, prefix);
		// delete last char from prefix string
		prefix.deleteCharAt(prefix.length() - 1);
		
		// append 1 in prefix string for right child
		prefix.append('1');
		// call for right child
		createPrefixMapHelper(root.getRight(), prefixMap, prefix);
		// delete last char from prefix string
		prefix.deleteCharAt(prefix.length() - 1);	
	}


}
