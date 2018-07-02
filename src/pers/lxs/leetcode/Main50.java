package pers.lxs.leetcode;

import org.junit.Test;

public class Main50 {
	
	@Test
	public void test() {
		
		double x = 2;
		int n = -2147483648;
		
		double result = myPow(x, n);
		
		System.out.println(result);
	}

    public double myPow(double x, int n) {
        
    	if(n == 0) {
    		return 1.0;
    	}
    	
    	if(n < 0) {
    		x = 1 / x;
    		return (n % 2 == 0) ? myPow(x * x, -(n / 2)) : x * myPow(x * x, -(n / 2));
    	}
    	
    	return (n % 2 == 0) ? myPow(x * x, n / 2) : x * myPow(x * x, n / 2);
    	
    }
}
