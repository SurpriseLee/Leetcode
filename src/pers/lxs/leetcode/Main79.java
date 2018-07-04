package pers.lxs.leetcode;

import org.junit.Test;

public class Main79 {
	
	@Test
	public void test() {
		
		char[][] board = new char[][]{};
		String word = "";
		
		System.out.println(exist(board, word));
		
	}
	
    public boolean exist(char[][] board, String word) {
        
    	if(board == null || word == null || word.length() <= 0) {
    		return false;
    	}
    	
    	return false;
    }

}
