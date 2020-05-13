package main.java.ucrypt;

import java.util.Random;

public class UCrypt {
	
	public static String encode(String seed, String str) {
		return encode(seed.hashCode(), str);
	}
	
	public static String decode(String seed, String str) {
		return decode(seed.hashCode(), str);
	}
	
	public static String encode(long seed, String str) {
		Random r = new Random(seed);
		StringBuilder sb = new StringBuilder();
		
		for (char c : str.toCharArray()) {
			int num = (c + r.nextInt(1000)) % 127;
			sb.append((char) num);
		}
		
		return sb.toString();
	}
	
	public static String decode(long seed, String str) {
		Random r = new Random(seed);
		StringBuilder sb = new StringBuilder();
		
		for (char c : str.toCharArray()) {
			int num = (c - r.nextInt(1000)) % 127;
			
			if (num < 0) { //TODO FIX!
				num += 127;
			}
			
			sb.append((char) num);
		}
		
		return sb.toString();
	}
}
