package pers.lxs.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

public class Main90 {
	
	@Test
	public void test() {
		
		int[] nums = new int[]{4,4,4,1,4};
		
		List<List<Integer>> lists = subsetsWithDup(nums);
		
		for(List<Integer> list : lists) {
			System.out.println(list.toString());
		}
	}
	
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        
    	List<List<Integer>> lists = new ArrayList<List<Integer>>();
    	
    	if(nums == null || nums.length <= 0) {
    		return lists;
    	}
    	
    	Arrays.sort(nums);
    	
    	Map<String, Integer> map = new HashMap<String, Integer>();
    	int n = (int) Math.pow(2, nums.length);
    	for(int i = 0; i < n; i++) {
    		
    		List<Integer> list = new ArrayList<Integer>();
    		String str = Integer.toBinaryString(i);
    		int len = str.length();
    		for(int j = 0; j < len; j++) {
    			if(str.charAt(len - 1 - j) == '1') {
    				list.add(nums[j]);
    			}
    		}
    		
    		String key = list.toString();
    		if(!map.containsKey(key)) {
    			map.put(key, 1);
    			lists.add(list);
    		}
    	}
    	
    	return lists;
    }
	
}
