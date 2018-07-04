package pers.lxs.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

public class Main76 {
	
	@Test
	public void test() {
		
		int n = 4;
		int k = 2;
		
		List<List<Integer>> lists = combine(n, k);
		
		for(List<Integer> list : lists) {
			System.out.println(list.toString());
		}
		
	}

    public List<List<Integer>> combine(int n, int k) {
        
    	List<List<Integer>> lists = new ArrayList<List<Integer>>();
    	
    	if(k > n) {
    		return lists;
    	}
    	
    	int[] nums = new int[n];
    	for(int i = 0; i < n; i++) {
    		nums[i] = i + 1;
    	}
    	
    	List<Integer> list = new LinkedList<Integer>();
    	combine(0, k, nums, list, lists);
    	
    	return lists;
    }
    
    private void combine(int index, int k, int[] nums, List<Integer> list, List<List<Integer>> lists) {
    	
    	if(list.size() == k) {
    		lists.add(new ArrayList<Integer>(list));
    		return;
    	}
    	
    	for(int i = index; i <= (nums.length - k + list.size()); i++) {
    		list.add(nums[i]);
    		combine(i + 1, k, nums, list, lists);
    		list.remove(list.size() - 1);
    	}
    	
    }
    
    public void swap(int[] nums, int p, int q) {
    	
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
