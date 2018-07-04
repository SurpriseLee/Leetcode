package pers.lxs.leetcode;

import java.util.Arrays;

import org.junit.Test;

public class Main64 {

	@Test
	public void test() {

		int[][] grid = new int[][] { { 1, 3, 1 }, { 1, 5, 1 }, { 4, 2, 1 } };

		int result = minPathSum(grid);

		System.out.println(result);
	}

	public int minPathSum(int[][] grid) {

		if(grid == null) {
			return -1;
		}
		
		int m = grid.length;
		int n = grid[0].length;
		int[][] values = new int[m + 1][n + 1];
		
		for(int i = m - 1; i >= 0; i--) {
			for(int j = n - 1; j >= 0; j--) {
				
				if(i == m - 1) {
					values[i][j] = grid[i][j] + values[i][j + 1];
				} else if(j == n - 1) {
					values[i][j] = grid[i][j] + values[i + 1][j];
				} else {
					values[i][j] = grid[i][j] + Math.min(values[i + 1][j], values[i][j + 1]); 
				}
			}
		}
		
		for(int i = 0; i < values.length; i++) {
			System.out.println(Arrays.toString(values[i]));
		}
		
		return values[0][0];
	}

}
