package pers.lxs.leetcode;

import java.util.Arrays;

import org.junit.Test;

public class Main31 {
	
	@Test
	public void test() {
		
		int[] nums = new int[]{1,2};
		
		System.out.println(Arrays.toString(nums));
		
		nextPermutation(nums);
		
		System.out.println(Arrays.toString(nums));
	}
	
	
    public void nextPermutation(int[] nums) {

    	if(nums == null || nums.length <= 1) {
    		return;
    	}
    	
    	int bestP = -1;    int bestQ = -1;
    	int q = nums.length  - 1;    int p = q - 1;
    	while(q > 0) {
    		
    		while(p >= 0 && nums[p] >= nums[q]) {
    			p -= 1;
    		}
    		
    		if(p > bestP) {
    			bestP = p;
    			bestQ = q;
    		}
    		
    		q -= 1;
    		p = q - 1;
    	}
    	
    	if(bestP >= 0) {
    		
    		int temp = nums[bestP];
    		nums[bestP] = nums[bestQ];
    		nums[bestQ] = temp;
    		
    		Arrays.sort(nums, bestP + 1, nums.length); 
    		return;
    	}
    	
    	Arrays.sort(nums);
    	return;    	
    }
    
}
