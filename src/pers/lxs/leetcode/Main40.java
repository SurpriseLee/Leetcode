package pers.lxs.leetcode;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

public class Main40 {
	
	@Test
	public void test() {
		
		int[] nums = new int[]{10,1,2,7,6,1,5};
		int target = 8;
		
		List<List<Integer>> lists = combinationSum2(nums, target);
		
		Iterator<List<Integer>> it = lists.iterator();
		while(it.hasNext()) {
			System.out.println(it.next().toString());
		}
	}
	
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        
    	List<List<Integer>> lists = new LinkedList<List<Integer>>();
    	
    	if(candidates == null || candidates.length <= 0){
    		return lists;
    	}
    	
    	Arrays.sort(candidates);
    	
    	Deque<Integer> queue = new ArrayDeque<Integer>();
    	
    	combinationSum2(candidates, target, 0, queue, lists);
    	
    	return lists;
    }
    
    public void combinationSum2(int[] candidates, int target, int index, Deque<Integer> queue, List<List<Integer>> lists) { 
    	
    	if(target < 0) {
    		return;
    	}
    	
    	if(target == 0) {
    		
    		List<Integer> list = new LinkedList<Integer>();
    		
    		Iterator<Integer> it = queue.iterator();
    		while(it.hasNext()) {
    			list.add(it.next());
    		}
    		
    		if(!lists.contains(list)) {
    			lists.add(list);
    		}
    		
    		return;
    	}
    	
    	for(int i = index; i < candidates.length; i++) {
    		
    		if(i > index && i > 0 && candidates[i] == candidates[i - 1]) {
    			continue;
    		}
    		
    		queue.offerLast(candidates[i]);
    		combinationSum2(candidates, target - candidates[i], i  + 1, queue, lists);
    		queue.pollLast();
    	}
    }
}
