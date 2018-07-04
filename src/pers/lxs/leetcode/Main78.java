package pers.lxs.leetcode;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class Main78 {
	
	@Test
	public void test() {
		
		int[] nums = new int[]{1,2,3};
		
		List<List<Integer>> lists = subsets(nums);
		
		for(List<Integer> list : lists) {
			System.out.println(list.toString());
		}
		
	}
	
    public List<List<Integer>> subsets(int[] nums) {
        
    	List<List<Integer>> lists = new ArrayList<List<Integer>>();
    	
    	if(nums == null || nums.length <= 0) {
    		return lists;
    	}
    	
    	int n = (int) Math.pow(2, nums.length);
    	
    	for(int i = 0; i < n; i++) {
    		
    		List<Integer> list = new ArrayList<Integer>();
    		
    		char[] chs = Integer.toBinaryString(i).toCharArray();
    		int index = chs.length - 1;
    		while(index >= 0) {
    			
    			if(chs[index] == '1') {
    				list.add(nums[chs.length - 1 - index]);
    			}
    			
    			index--;
    		}
    		
    		lists.add(list);
    	}

    	return lists;
    }

}
