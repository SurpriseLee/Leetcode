package pers.lxs.leetcode;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class Main43 {
	
	@Test
	public void test() {
		
		String num1 = "13";
		String num2 = "16";
		
		System.out.println("num1: " + num1 + " num2: " + num2);
		String result = multiply(num1, num2);
		
		System.out.println(result);
	}
	
	
    public String multiply(String num1, String num2) {
        
    	if(num1 == null || num2 == null || num1.length() <= 0
    			|| num1.length() >= 110 || num2.length() <= 0
    			|| num2.length() >= 110) {
    		return "";
    	}
    	
    	if(num1.equals("0") || num2.equals("0")) {
    		return "0";
    	}
    	
    	List<String> list = new ArrayList<String>();
    	StringBuilder sb = new StringBuilder();
    	for(int i = num1.length() - 1; i >= 0; i--) {
    		
    		if(i < num1.length() - 1) {
    			sb.append("0");
    		}
    		
    		list.add(sb.toString() + multiply(num2, num1.charAt(i)));
    	}
        
    	System.out.println(list.toString());
    	
    	return add(list);
    }
    
    public String multiply(String num, char ch) {
    	
    	StringBuilder sb = new StringBuilder();
    	
    	int flag = 0;
    	
    	int n1 = ch - '0';
    	
    	for(int i = num.length() - 1; i >= 0; i--) {
    		
    		int n2 = num.charAt(i) - '0'; 
    		
    		int product = n1 * n2 + flag;
    		
    		flag = product / 10;
    		
    		sb.append(product % 10);
    	}
    	
    	if(flag > 0) {
    		sb.append(flag);
    	}
    	
    	return sb.toString();
    }
    
    public String add(List<String> list) {
    	
    	int max = list.get(list.size() - 1).length();
    	
    	String sum = "";
    	int flag = 0;
    	for(int i = 0; i < max; i++) {
    		int tempSum = 0;
    		for(int j = 0; j < list.size(); j++) {
    			
    			int n = 0;
    			if(list.get(j).length() > i) {
    				n = list.get(j).charAt(i) - '0';
    			} 
    			
    			tempSum += n;
    		}
    		
    		tempSum += flag;
    		
    		System.out.println(tempSum);
    		
    		flag = tempSum / 10;
    		sum = (tempSum % 10) + sum;
    	}
    	
    	if(flag > 0) {
    		sum = flag + sum;
    	}
    	
    	return sum;
    }
	
}
