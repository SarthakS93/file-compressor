package com.sarthaks93.file_compressor.common;

public class HuffmanTreeNode implements Comparable<HuffmanTreeNode> {
	
	private Integer frequency;
	
	private String data;
	
	private HuffmanTreeNode left;
	
	private HuffmanTreeNode right;
	
	
	// Constructor
	
	public HuffmanTreeNode() {}
	
	public HuffmanTreeNode(Integer frequency, String data) {
		this.frequency = frequency;
		this.data = data;
	}
	
	
	// Getter, Setter methods

	public Integer getFrequency() {
		return frequency;
	}

	public void setFrequency(Integer frequency) {
		this.frequency = frequency;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public HuffmanTreeNode getLeft() {
		return left;
	}

	public void setLeft(HuffmanTreeNode left) {
		this.left = left;
	}

	public HuffmanTreeNode getRight() {
		return right;
	}

	public void setRight(HuffmanTreeNode right) {
		this.right = right;
	}
	
	
	// method for comparison of 2 nodes, its used to put in the priority queue

	@Override
	public int compareTo(HuffmanTreeNode node) {
		return this.frequency - node.getFrequency();
	}

}
