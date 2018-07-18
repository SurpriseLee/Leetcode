package pers.lxs.leetcode;

import org.junit.Test;

public class Main79 {

	@Test
	public void test() {

		char[][] board = new char[][] { { 'A', 'B', 'C', 'E' }, { 'S', 'F', 'C', 'S' }, { 'A', 'D', 'E', 'E' } };
		String word = "ABCB";

		System.out.println(exist(board, word));

	}

	public boolean exist(char[][] board, String word) {

		if (board == null || word == null || word.length() <= 0) {
			return false;
		}

		boolean[][] isVisited = new boolean[board.length][board[0].length];

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {

				if (board[i][j] == word.charAt(0)) {
					if(exist(i, j, 0, board, word, isVisited)){
						return true;
					}
				}
			}
		}

		return false;
	}

	private boolean exist(int i, int j, int index, char[][] board, String word, boolean[][] isVisited) {

		if (index >= word.length()) {
			return true;
		}

		if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || isVisited[i][j]
				|| board[i][j] != word.charAt(index)) {
			return false;
		}

		isVisited[i][j] = true;

		boolean flag = exist(i - 1, j, index + 1, board, word, isVisited)
				|| exist(i + 1, j, index + 1, board, word, isVisited)
				|| exist(i, j - 1, index + 1, board, word, isVisited)
				|| exist(i, j + 1, index + 1, board, word, isVisited);

		isVisited[i][j] = false;
		
		return flag;
	}

}
