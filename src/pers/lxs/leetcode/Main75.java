package pers.lxs.leetcode;

import java.util.Arrays;

import org.junit.Test;

public class Main75 {
	
	@Test
	public void test() {
		
		int[] nums = new int[]{0,0};
		
		System.out.println(Arrays.toString(nums));
		
		sortColors(nums);
		
		System.out.println(Arrays.toString(nums));
	}
	
    public void sortColors(int[] nums) {
        
    	if(nums == null || nums.length <= 0) {
    		return;
    	}
    	
    	int p = 0;    int q = nums.length - 1;
    	int mid = p;
    	
    	while(p < q && mid < q) {
    		
    		while(p < q && nums[p] == 0) {
    			p++;
    		}
    		
    		while(q > p && nums[q] == 2) {
    			q--;
    		}
    		
    		if(nums[p] == 2 || nums[q] == 0) {
    			swap(nums, p, q);
    		} else {
    			mid = mid > p ? mid : p;
    			
    			while(mid < q && nums[mid] == 1) {
    				mid++;
    			}
    			
    			if(mid < q && nums[mid] == 0) {
    				swap(nums, mid, p);
    			} else if(mid < q && nums[mid] == 2) {
    				swap(nums, mid, q);
    			}
    		}
    	}
    }
    
    private void swap(int[] nums, int p, int q) {
    	
    	if(nums == null || nums.length <= 1) {
    		return;
    	}
    	
    	if(p >= 0 && p < nums.length && q >= 0 && q < nums.length && p != q) {
    		int temp = nums[p];
    		nums[p] = nums[q];
    		nums[q] = temp;
    	}
    }

}
