package pers.lxs.leetcode;

import org.junit.Test;

public class RemoveElement {
	
	@Test
	public void test() {
//		int[] nums = new int[]{1};
//
//		displayArray(nums, nums.length);
//		
//		int len = removeElement(nums, 1);
//		
//		System.out.println(len);
//		
//		displayArray(nums, len);
		
		String str1 = null;
		String str2 = "feda";
		String string = combineString(str1, str2);
		System.out.println(string);
		
		
	}
	
	
	public String combineString(String str1, String str2) {
		
		if(str1 == null || str1.equals("")) {
			return str2;
		}
		
		if(str2 == null || str2.equals("")) {
			return str1;
		}
		
		int index = str1.length() - 1;
		
		String str = str1 + str2;
		
		while(!str.equals("") && index >= 0 && (str.length() - index) >=2 && str.charAt(index) == str.charAt(index + 1)) {
			str = str.substring(0, index) + str.substring(index + 2);
			index--;
		}
		
		return str;
		
	}
	

	
    public int removeElement(int[] nums, int val) {
        
    	if(nums.length < 1) {
    		return nums.length;
    	}
    	
    	int len = 0;
    	int p = 0;	int q = 0;
    	while(q < nums.length) {
    		
    		if(nums[q] == val) {
    			q++;
    		} else {
    			nums[p++] = nums[q++];
    			len++;
    		}
    		
    	}
    	
    	return len;
    }
    
	public void displayArray(int[] nums, int len) {
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < len; i++) {
			sb.append(nums[i] + "  ");
		}
		
		String result = sb.toString();
		
		if(result.length() >= 2) {
			result = result.substring(0, result.length() - 2);
		}
		
		System.out.println(result);
	}
}
