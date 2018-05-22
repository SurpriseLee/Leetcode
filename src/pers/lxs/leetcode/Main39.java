package pers.lxs.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

public class Main39 {
	
	@Test
	public void test() {
		int[] nums = new int[]{2,3,6,7};
		
		int target = 7;
		
		List<List<Integer>> lists = combinationSum(nums, target);
		
		for(List<Integer> list : lists) {
			System.out.println(list.toString());
		}
	}
	

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        
    	List<List<Integer>> lists = new LinkedList<List<Integer>>();
    	
    	if(candidates == null || candidates.length <= 0) {
    		return lists;
    	}
    	
    	Deque<Integer> queue = new ArrayDeque<Integer>();
    	
    	combinationSum(candidates, target, 0, queue, lists);
    	
    	return lists;
    }
	
    
    public void combinationSum(int[] candidates, int target, int index, Deque<Integer> queue, List<List<Integer>> lists) {
    	
    	if(target < 0) {
    		return;
    	}
    	
    	if(target == 0) {
    		
    		List<Integer> list = new LinkedList<Integer>();
    		
    		Iterator<Integer> it = queue.iterator();
    		while(it.hasNext()) {
    			list.add(it.next());
    		}
    		
    		lists.add(list);
    		
    		return;
    	}
    	
    	for(int i = index; i < candidates.length; i++) {
    		queue.offerLast(candidates[i]);
    		combinationSum(candidates, target - candidates[i], i, queue, lists);
    		queue.pollLast();
    	}
    }
}

