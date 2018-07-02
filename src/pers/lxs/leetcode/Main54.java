package pers.lxs.leetcode;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class Main54 {

	@Test
	public void test() {

		int[][] matrix = new int[][] { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 } };

		List<Integer> list = spiralOrder(matrix);

		System.out.println(list.toString());

	}

	public List<Integer> spiralOrder(int[][] matrix) {

		List<Integer> list = new ArrayList<Integer>();

		if (matrix == null || matrix.length <= 0) {
			return list;
		}

		int up = 0;
		int down = matrix.length - 1;
		int left = 0;
		int right = matrix[0].length - 1;

		int i = 0;
		int j = 0;
		while (left <= right && up <= down) {

			if (left <= right && up <= down) {
				while (j <= right) {
					list.add(matrix[i][j++]);
				}
				up++;
				i++;
				j--;
			}

			if (left <= right && up <= down) {
				while (i <= down) {
					list.add(matrix[i++][j]);
				}
				right--;
				i--;
				j--;
			}

			if (left <= right && up <= down) {
				while (j >= left) {
					list.add(matrix[i][j--]);
				}
				down--;
				i--;
				j++;
			}

			if (left <= right && up <= down) {
				while (i >= up) {
					list.add(matrix[i--][j]);
				}
				left++;
				i++;
				j++;
			}

		}

		return list;
	}

}
