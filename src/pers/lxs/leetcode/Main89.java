package pers.lxs.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

public class Main89 {
	
	@Test
	public void test() {
		
		int n = 3;
		List<Integer> list = grayCode(n);
		
		System.out.println(list.toString());
		
	}

    public List<Integer> grayCode(int n) {
        
    	List<Integer> list = new ArrayList<Integer>();
    	
    	if(n < 0) {
    		return list; 
    	}
    	
    	if(n == 0) {
    		list.add(0);
    		return list; 
    	}
    	
    	char[] chs = new char[n];
    	for(int i = 0; i < chs.length; i++) {
    		chs[i] = '0';
    	}
    	
    	list.add(charArrayToInt(chs));
    	Map<String, Integer> map = new HashMap<String, Integer>();
    	map.put(Arrays.toString(chs), 1);
    	
    	int num = (int) Math.pow(2, n);
    	
    	while(num > 1) {
    		
    		for(int i = 0; i < chs.length; i++) {
    			chs[i] = (char) ((chs[i] - '0' + 1) % 2 + '0');
    			String key = Arrays.toString(chs);
    			if(!map.containsKey(key)) {
    				list.add(charArrayToInt(chs));
    				map.put(key, 1);
    				break;
    			}
    			
    			chs[i] = (char) ((chs[i] - '0' + 1) % 2 + '0');
    		}
    		
    		num--;
    	}
    	
    	for(String key : map.keySet()) {
    		System.out.println(key);
    	}
    	
    	return list;
    }
    
    private int charArrayToInt(char[] chs) {
    	
    	if(chs == null || chs.length <= 0) {
    		return -1;
    	}
    	
    	int value = 0;
    	int temp = 1;
    	for(int i = chs.length - 1; i >= 0; i--) {
    		value += (chs[i] - '0') * temp;
    		temp *= 2;
    	}
    	
    	return value;
    }
}
