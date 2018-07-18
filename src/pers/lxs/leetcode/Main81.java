package pers.lxs.leetcode;

import org.junit.Test;

public class Main81 {
	
	@Test
	public void test() {
		
		int[] nums = new int[]{2,2,2,0,0,1};
		int target = 0;
		
		System.out.println(search(nums, target));
		
	}
	
    public boolean search(int[] nums, int target) {
        
    	if(nums == null || nums.length <= 0) {
    		return false;
    	}
    	
    	int left = 0;    int right = nums.length - 1;
    	while(left <= right) {
    		
    		int mid = (left + right) / 2;
    		
    		if(nums[left] == target || nums[mid] == target || nums[right] == target) {
    			return true;
    		}
    		
    		if(nums[left] == nums[mid]) {
    			
    			if(nums[right] == nums[mid]) {
    				left++;
    				right--;
    			} else {
    				left = mid + 1;
        			right--;
    			}
    			
    		} else if(nums[left] < nums[mid]) {
    			
    			if(target > nums[left] && target < nums[mid]) {
    				left++;
    				right = mid - 1;
    			} else {
    				left = mid + 1;
    				right--;
    			}
    			
    		} else {
    			
    			if(target > nums[mid] && target < nums[right]) {
    				left = mid + 1;
    				right--;
    			} else {
    				left++;
    				right = mid -1;
    			}
    		}
    	}
    	
    	return false;
    }
    
}
