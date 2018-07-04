package pers.lxs.leetcode;

import org.junit.Test;

public class Main63 {

	@Test
	public void test() {

		int[][] obstacleGrid = new int[][] { { 0, 0, 0 }, { 0, 1, 0 }, { 0, 0, 0 } };

		int result = uniquePathsWithObstacles(obstacleGrid);

		System.out.println(result);
	}
	
	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
		
		if (obstacleGrid == null || obstacleGrid.length <= 0) {
			return 0;
		}
		
		int m = obstacleGrid.length;
		int n = obstacleGrid[0].length;

		int[][] values = new int[m + 1][n + 1];
		values[m - 1][n] = 1;
		
		for(int i = m - 1; i >= 0; i--) {
			for(int j = n - 1; j >= 0; j--) {
				
				if(obstacleGrid[i][j] == 1) {
					values[i][j] = 0;
				} else {
					values[i][j] = values[i + 1][j] + values[i][j + 1];
				}
			}
		}
		
		return values[0][0];
	}
}
