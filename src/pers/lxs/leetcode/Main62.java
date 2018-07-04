package pers.lxs.leetcode;

import org.junit.Test;

public class Main62 {

	@Test
	public void test() {

		int m = 7;
		int n = 3;

		int result = uniquePaths(m, n);
		System.out.println(result);
	}

	public int uniquePaths(int m, int n) {

		if (m <= 0 || n <= 0) {
			return 0;
		}

		int[][] values = new int[m + 1][n + 1];
		values[m - 1][n] = 1;
		
		for(int i = m - 1; i >= 0; i--) {
			for(int j = n - 1; j >= 0; j--) {
				values[i][j] = values[i + 1][j] + values[i][j + 1];
			}
		}

		return values[0][0];
	}

	public int uniquePaths2(int m, int n) {

		if (m <= 0 || n <= 0) {
			return 0;
		}

		int[][] values = new int[m][n];
		values[m - 1][n - 1] = 1;

		return uniquePaths(0, 0, m, n, values);
	}

	private int uniquePaths(int x, int y, int m, int n, int[][] values) {

		if (x < 0 || x >= m || y < 0 || y >= n) {
			return 0;
		}

		if (values[x][y] != 0) {
			return values[x][y];
		}

		return values[x][y] = uniquePaths(x + 1, y, m, n, values) + uniquePaths(x, y + 1, m, n, values);
	}

}
