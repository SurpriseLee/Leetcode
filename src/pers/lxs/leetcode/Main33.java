package pers.lxs.leetcode;

import java.util.Arrays;

import org.junit.Test;

public class Main33 {
	
	@Test
	public void test() {
		
		int[] nums = new int[]{8,9,2,3,4};
		int target = 9;
		
		System.out.println(Arrays.toString(nums));
		
		int index = search(nums, target);
		
		System.out.println(index);
	}
	
    public int search(int[] nums, int target) {
        
     	if(nums == null || nums.length <= 0) {
    		return -1;
    	}
    	
    	int index = -1;
    	
    	int left = 0;    int right = nums.length - 1;
    	int mid = (left + right) >> 1;
    	
    	while(left <= right) {
    		
    		if(target == nums[left]) {
        		return left;
        	}
        	
    		if(target == nums[mid]) {
    			return mid;
    		}
    		
        	if(target == nums[right]) {
        		return right;
        	}
    		
    		if(target < nums[left] && target < nums[mid]) {
    			
    			if(nums[mid] > nums[left]) {
    				left = mid + 1;
    				mid = (left + right) >> 1;
    			} else {
    				right = mid - 1;
    				mid = (left + right) >> 1;
    			}
    			
    		} else if(target < nums[left] && target > nums[mid]) {
    			
    			left = mid + 1;
    			mid = (left + right) >> 1;
    			
    		} else if(target > nums[left] && target < nums[mid]) {
    			right = mid - 1;
    			mid = (left + right) >> 1;
    		} else if(target > nums[left] && target > nums[mid]) {
    			
    			if(nums[mid] > nums[left]) {
    				left = mid + 1;
        			mid = (left + right) >> 1;
    			} else {
    				right = mid - 1;
    				mid = (left + right) >> 1;
    			} 
    		}
    	}
    	
    	return index;
    }
}
