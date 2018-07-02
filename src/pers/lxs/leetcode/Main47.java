package pers.lxs.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

public class Main47 {
	
	@Test
	public void test() {
		
		int[] nums = new int[]{1,1,2};
		List<List<Integer>> lists = permuteUnique(nums);
		
		for(List<Integer> list : lists) {
			
			System.out.println(list.toString());
			
		}
	}
	
    public List<List<Integer>> permuteUnique(int[] nums) {
        
    	List<List<Integer>> lists = new ArrayList<List<Integer>>();
    	Map<List<Integer>, Integer> map = new HashMap<List<Integer>, Integer>();
    	
    	if(nums == null || nums.length <= 0) {
    		return lists;
    	}
    	
    	permuteUnique(nums, 0, lists, map);
    	
    	return lists;
    }
	
    
    public void permuteUnique(int[] nums, int index, List<List<Integer>> lists, Map<List<Integer>, Integer> map) {
    	
    	if(index == nums.length - 1) {
    		
    		List<Integer> list = arrayToList(nums);
    		
    		if(!map.containsKey(list)) {
    			map.put(list, 1);
    			lists.add(list);
    		}
    		
    		return;
    	}
    	
    	for(int i = index; i < nums.length; i++) {
    		
    		swap(nums, index, i);
    		permuteUnique(nums, index + 1, lists, map);
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
