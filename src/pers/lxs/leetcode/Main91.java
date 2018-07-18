package pers.lxs.leetcode;

import java.util.Arrays;

import org.junit.Test;

public class Main91 {

	@Test
	public void test() {

		String s = "101";

		int result = numDecodings(s);

		System.out.println(result);

	}

	public int numDecodings(String s) {

		if (s == null || s.length() <= 0 || s.startsWith("0")) {
			return 0;
		}

		int[] nums = new int[s.length() + 1];
		nums[nums.length - 1] = 1;
		
		if(isLeagal(s.charAt(s.length() - 1))) {
			nums[nums.length - 2] = 1;
		}


		int index = nums.length - 3;
		while (index >= 0) {

			if(isLeagal(s.charAt(index))) {
				nums[index] += nums[index + 1];
			} else {
				nums[index] = 0;
				index--;
				continue;
			}
			
			if(isLeagal(s.charAt(index), s.charAt(index + 1))) {
				nums[index] += nums[index + 2];
			}
			
			index--;
		}

		System.out.println(Arrays.toString(nums));
		
		return nums[0];
	}
	
	private boolean isLeagal(char ch1, char ch2) {
		
		int value = charToInt(ch1, ch2);
		
		return value >= 1 && value <= 26;		
	}
	
	private boolean isLeagal(char ch) {
		
		int value = charToInt(ch);
		
		return value >= 1 && value <= 26;		
	}

	private int charToInt(char ch1, char ch2) {

		return (ch1 - '0') * 10 + (ch2) - '0';

	}
	
	private int charToInt(char ch) {

		return ch - '0';

	}

}
