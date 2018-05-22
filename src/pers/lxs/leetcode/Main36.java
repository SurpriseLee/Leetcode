package pers.lxs.leetcode;

import java.util.Arrays;

import org.junit.Test;

public class Main36 {
	
	@Test
	public void test() {
		
		char[][] board = new char[][]{{'5', '3', '.', '.', '7', '.', '.', '.', '.'},
		{'6', '.', '.', '1', '9', '5', '.', '.', '.'},
		{'.', '9', '8', '.', '.', '.', '.', '6', '.'},
		{'8', '.', '.', '.', '6', '.', '.', '.', '3'},
		{'4', '.', '.', '8', '.', '3', '.', '.', '1'},
		{'7', '.', '.', '.', '2', '.', '.', '.', '6'},
		{'.', '6', '.', '.', '.', '.', '2', '8', '.'},
		{'.', '.', '.', '4', '1', '9', '.', '.', '5'},
		{'.', '.', '.', '.', '8', '.', '.', '7', '9'}};
		
    	for(int i = 0; i < board.length; i++) {
    		System.out.println(Arrays.toString(board[i]));
    	}
		
		boolean flag = isValidSudoku(board);
		
		System.out.println(flag);
	}
	
	
    public boolean isValidSudoku(char[][] board) {
        
        boolean[][] row = new boolean[9][9];
        boolean[][] column = new boolean[9][9];
        boolean[][] block = new boolean[9][9];
        
        for(int i = 0;i<9;i++){
            for(int j=0;j<9;j++){
                 int c = board[i][j] - '1';       
                 if(board[i][j]=='.'){
                     continue;
                 }
                 if(row[i][c]||column[j][c]||block[i - i % 3 + j / 3][c]){
                     return false;
                 }
                 row[i][c] = column[j][c] = block[i - i % 3 + j / 3][c] = true;
            }
        }
        return true;
     }
}
