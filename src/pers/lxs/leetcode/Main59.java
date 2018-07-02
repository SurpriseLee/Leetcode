package pers.lxs.leetcode;

import java.util.Arrays;

import org.junit.Test;

public class Main59 {
	
	@Test
	public void test() {
		
		int n = 0;
		
		int[][] matrix = generateMatrix(n);
		
		for(int i = 0; i < matrix.length; i++) {
			System.out.println(Arrays.toString(matrix[i]));
		}
		
	}
	
    public int[][] generateMatrix(int n) {
        
    	if(n <= 0) {
    		return new int[][]{};
    	}
    	
    	int[][] matrix = new int[n][n];
    	
    	int curr = 1;
    	int up = 0;    int down = n - 1;
    	int left =0;    int right = n - 1;
    	int i = 0;    int j = 0;
    	while(left <= right && up <= down) {
    		
    		if(left <= right && up <= down) {
    			
    			while(j <= right) {
    				matrix[i][j++] = curr++;
    			}
    			up++;
    			i++;
    			j--;
    		}
    		
    		if(left <= right && up <= down) {
    			
    			while(i <= down) {
    				matrix[i++][j] = curr++;
    			}
    			right--;
    			i--;
    			j--;
    		}
    		
    		if(left <= right && up <= down) {
    			
    			while(j >= left) {
    				matrix[i][j--] = curr++;
    			}
    			down--;
    			i--;
    			j++;
    		}
    		
    		if(left <= right && up <= down) {
    			
    			while(i >= up) {
    				matrix[i--][j] = curr++;
    			}
    			left++;
    			i++;
    			j++;
    		}
    	}
    	
    	return matrix;
    }

}
