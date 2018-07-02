package pers.lxs.leetcode;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class Main46 {
	
	@Test
	public void test() {
		
		int[] nums = new int[]{1,2,3,4};
		List<List<Integer>> lists = permute(nums);
		
		for(List<Integer> list : lists) {
			
			System.out.println(list.toString());
			
		}
	}
	
    public List<List<Integer>> permute(int[] nums) {
        
    	List<List<Integer>> lists = new ArrayList<List<Integer>>();
    	
    	if(nums == null || nums.length <= 0) {
    		return lists;
    	}
    	
    	permute(nums, 0, lists);
    	
    	return lists;
    }
	
    
    public void permute(int[] nums, int index, List<List<Integer>> lists) {
    	
    	if(index == nums.length - 1) {
    		lists.add(arrayToList(nums));
    		return;
    	}
    	
    	for(int i = index; i < nums.length; i++) {
    		
    		swap(nums, index, i);
    		permute(nums, index + 1, lists);
    		swap(nums, index, i);
    	}
    }
    
    public void swap(int[] nums, int left, int right) {
    	
    	if(nums == null || nums.length <= 1) {
    		return;
    	}
    	
    	if(left >= 0 && left < nums.length && right >= 0 && right < nums.length && left != right) {
    		
    		int temp = nums[left];
    		nums[left] = nums[right];
    		nums[right] = temp;
    		
    	}
    }
    
    public List<Integer> arrayToList(int[] nums) {
    	
    	List<Integer> list = new ArrayList<Integer>();
    	
    	if(nums == null || nums.length <= 0) {
    		return list;
    	}
    	
    	for(int e : nums) {
    		list.add(e);
    	}
    	
    	return list;
    }
    
}
