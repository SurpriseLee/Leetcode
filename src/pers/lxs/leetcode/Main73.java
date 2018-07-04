package pers.lxs.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.junit.Test;

public class Main73 {

	@Test
	public void test() {

		int[][] matrix = new int[][] { {1,0} };

		setZeroes(matrix);

		for (int i = 0; i < matrix.length; i++) {
			System.out.println(Arrays.toString(matrix[i]));
		}

	}

	public void setZeroes(int[][] matrix) {

		if (matrix == null || matrix.length <= 0) {
			return;
		}

		Set<Integer> colSet = new HashSet<Integer>();

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				if (matrix[i][j] == 0) {
					colSet.add(j);
					int index = j;
					while(index >= 0) {
						matrix[i][index--] = 0;
					}
					
					index = j + 1;
					while(index < matrix[i].length) {
						if(matrix[i][index] == 0) {
							colSet.add(index);
						}
						matrix[i][index++] = 0;
					}
					
					break;
				}
			}
		}

		Iterator<Integer> it = colSet.iterator();
		while (it.hasNext()) {

			int col = it.next();
			for (int i = 0; i < matrix.length; i++) {
				matrix[i][col] = 0;
			}

		}

	}
}
