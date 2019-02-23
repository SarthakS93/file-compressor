package com.sarthaks93.file_compressor.utils;

/**
 * 
 * Pair class to keep character frequency
 * 
 */
public class Pair implements Comparable<Pair> {
	
	private char key;
	
	private long count;
	
	// Constructor
	
	public Pair() {}
	
	public Pair(char key, long count) {
		this.key = key;
		this.count = count;
	}
	
	// Getter, Setter methods
	
	public char getKey() {
		return key;
	}
	public void setKey(char key) {
		this.key = key;
	}
	public long getCount() {
		return count;
	}
	public void setCount(long count) {
		this.count = count;
	}

	// Comparable method
	@Override
	public int compareTo(Pair o) {
		long diff = this.count - o.count;
		if (diff < -1) {
			return -1;
		}
		else if (diff > 1) {
			return 1;
		}
		else {
			return 0;
		}
	}

	// toString method
	@Override
	public String toString() {
		return "Pair [key=" + key + ", count=" + count + "]";
	}
	
}
