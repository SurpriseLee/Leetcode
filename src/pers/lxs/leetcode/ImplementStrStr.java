package pers.lxs.leetcode;

import org.junit.Test;

public class ImplementStrStr {
	
	@Test
	public void test() {

		String haystack = "aaaaa";
		String needle = "bba";
		
		int index = strStr(haystack, needle);
		
		System.out.println(index);
		
	}
	
    public int strStr(String haystack, String needle) {
        
    	int index = 0;
    	
    	while(index <= haystack.length() - needle.length()) {
    		
    		int tempIndex = 0;
    		
    		while(tempIndex < needle.length() && haystack.charAt(index + tempIndex) == needle.charAt(tempIndex)) {
    			tempIndex++;
    		}
    		
    		if(tempIndex == needle.length()) {
    			break;
    		} else {
    			index++;
    		}
    	}
    	
    	System.out.println(index);
    	System.out.println(haystack.length() - needle.length());
    	return (index <= haystack.length() - needle.length()) ? index : -1;
    }
}
