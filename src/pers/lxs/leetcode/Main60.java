package pers.lxs.leetcode;

import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

public class Main60 {
	
	@Test
	public void test() {
		
		int n = 3;
		int k = 2;
		
		String result = getPermutation(n, k);
		System.out.println(result);
	}
	
    public String getPermutation(int n, int k) {
        
    	StringBuilder sb = new StringBuilder("");
    	int num = getPermutationNum(n);
    	
    	if(n <= 0 || n > 9 || k < 1 || k > num) {
    		return sb.toString();
    	}
    	
    	List<Integer> list = new LinkedList<Integer>();
    	for(int i = 0; i < n; i++) {
    		list.add(i + 1);
    	}
    	
    	while(!list.isEmpty()) {
    		num /= list.size();
    		int index = (k - 1) / num;
    		k -= num * index;
    		sb.append(list.remove(index));
    		System.out.println("index: " + index + " sb: " + sb.toString() + " list: " + list.toString());
    	}
    	
    	return sb.toString();
    }
    
    private int getPermutationNum(int n) {
    	
    	int result = 1;
    	while(n > 0) {
    		result *= n--;
    	}
    	
    	return result;
    }
    
}
