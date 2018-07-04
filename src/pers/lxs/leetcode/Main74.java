package pers.lxs.leetcode;

import org.junit.Test;

public class Main74 {

	@Test
	public void test() {

		int[][] matrix = new int[][] {{1,3,5,7},{10,11,16,20},{23,30,34,50}};

		int target = 6;

		System.out.println(searchMatrix(matrix, target));

	}

	public boolean searchMatrix(int[][] matrix, int target) {

		if (matrix == null || matrix.length <= 0) {
			return false;
		}

		int up = 0;
		int down = matrix.length;

		int row = (up + down) / 2;
		while (down - up > 1) {

			if (target == matrix[row][0]) {
				return true;
			} else if (target > matrix[row][0]) {
				up = row;
				row = (up + down) / 2;
			} else {
				down = row;
				row = (up + down) / 2;
			}
		}

		if ((row + 1) < matrix.length && target == matrix[row + 1][0]) {
			return true;
		}

		int left = 0;
		int right = matrix[row].length - 1;
		int mid = (left + right) / 2;
		while (left <= right) {

			if (target == matrix[row][mid]) {
				return true;
			} else if (target > matrix[row][mid]) {
				left = mid + 1;
				mid = (left + right) / 2;
			} else {
				right = mid - 1;
				mid = (left + right) / 2;
			}

		}

		return false;
	}

}
