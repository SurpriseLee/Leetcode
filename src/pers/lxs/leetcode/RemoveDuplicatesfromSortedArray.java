package pers.lxs.leetcode;

import org.junit.Test;

public class RemoveDuplicatesfromSortedArray {

	@Test
	public void test() {
		int[] nums = new int[]{1, 1, 2, 3, 5, 6, 6, 6, 7, 9};
		
		displayArray(nums, nums.length);
		
		int len = removeDuplicates(nums);
		
		System.out.println(len);
		
		displayArray(nums, len);
		
	}
	
	public void displayArray(int[] nums, int len) {
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < len; i++) {
			sb.append(nums[i] + "  ");
		}
		
		String result = sb.toString();
		result = result.substring(0, result.length() - 2);
		System.out.println(result);
	}
	
	
    public int removeDuplicates(int[] nums) {
        
    	if(nums.length == 1) {
    		return nums.length;
    	}
    	
    	int p = 0;	int q = 1;
    	int len = 1;
    	while(q < nums.length) {
    		
    		if(nums[q] == nums[p]) {
    			q++;
    		} else {
    			nums[++p] = nums[q++];
    			len++;
    		}
    	}
    	
    	return len;
    }
}
