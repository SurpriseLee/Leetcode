package pers.lxs.leetcode;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class Main93 {
	
	@Test
	public void test() {
		String s = "25525511135";
		
		List<String> list = restoreIpAddresses(s);
		
		System.out.println(list.toString());
		
	}
	
    public List<String> restoreIpAddresses(String s) {
        
    	List<String> list = new ArrayList<String>();
    	if(s == null || s.length() < 3) {
    		return list;
    	}
    	
    	restoreIpAddresses(s, 0, 0, 4, list);
    	
    	return list;
    }
    
    public void restoreIpAddresses(String s, int startIndex, int endIndex, int n, List<String> list) {
        
    	int num = strToNum(s, startIndex, endIndex);
    	
		if(num < 0 && num > 255) {
			return;
		} 
    	
    	if(n == 1) {
    		
    		

    		return;
    	}
    	
    	for(int i = 0; i < 3; i++) {
    		restoreIpAddresses(s, startIndex, startIndex + i, n - 1, list);
    	}
    	
    }
    
    private int strToNum(String s, int startIndex, int endIndex) {
    	
    	int value = 0;
    	for(int i = startIndex; i <= endIndex; i++) {
    		value += value * 10 + (s.charAt(i) - '0');
    	}
    	
    	return value;
    }
	

}
