package pers.lxs.leetcode;

import java.util.Arrays;

import org.junit.Test;

public class Main48 {

	@Test
	public void test() {

		int[][] matrix = new int[][] {};
		rotate(matrix);

		for (int i = 0; i < matrix.length; i++) {

			System.out.println(Arrays.toString(matrix[i]));

		}

	}

	public void rotate(int[][] matrix) {

		if (matrix == null || matrix.length <= 0) {
			return;
		}

		swapRows(matrix);

		transpose(matrix);
	}

	public void swapRows(int[][] matrix) {

		if (matrix == null || matrix.length <= 0) {
			return;
		}

		for (int i = 0; i < matrix.length / 2; i++) {
			swapRow(matrix, i, matrix.length - 1 - i);
		}

	}

	public void swapRow(int[][] matrix, int up, int down) {

		if (matrix == null || matrix.length <= 1) {
			return;
		}

		if (up >= 0 && up < matrix.length && down >= 0 && down < matrix.length && up != down) {

			for (int i = 0; i < matrix[up].length; i++) {
				int temp = matrix[up][i];
				matrix[up][i] = matrix[down][i];
				matrix[down][i] = temp;
			}

		}

	}

	public void transpose(int[][] matrix) {

		if (matrix == null || matrix.length <= 1) {
			return;
		}

		for (int i = 0; i < matrix.length; i++) {
			for (int j = i; j < matrix[i].length; j++) {
				int temp = matrix[i][j];
				matrix[i][j] = matrix[j][i];
				matrix[j][i] = temp;
			}
		}

	}
}
