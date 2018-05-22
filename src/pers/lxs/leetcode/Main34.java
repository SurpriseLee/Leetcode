package pers.lxs.leetcode;

import java.util.Arrays;

import org.junit.Test;

public class Main34 {

	@Test
	public void test() {
		
		int[] nums = new int[]{5,7,7,8,8,10};
		int target = 6;
		
		int[] result = searchRange(nums, target);
		
		System.out.println(Arrays.toString(result));
	}

	public int[] searchRange(int[] nums, int target) {
		
		int[] result = new int[2];
		result[0] = -1;
		result[1] = -1;
		
		if(nums == null || nums.length <= 0) {
			return result;
		}
		
		if(nums.length == 1 && nums[0] == target) {
			result[0] = 0;
			result[1] = 0;
			return result;
		}
		
		int left = 0;    int right = nums.length - 1;
		int mid = (left + right) >> 1;
		
		while(left <= right && nums[mid] != target) {
			
			if(target > nums[mid]) {
				left = mid + 1;
				mid = (left + right) >> 1;
			} else {
				right = mid - 1;
				mid = (left + right) >> 1;
			}
		}
		
		if(left > right || nums[mid] != target) {
			return result;
		}
		
		int start = mid;    int end = mid;
		
		while(start > 0 && nums[start - 1] == target) {
			start -= 1;
		}
		while(end < nums.length - 1 && nums[end + 1] == target) {
			end += 1;
		}
		
		result[0] = start;
		result[1] = end;
		
		return result;
	}

}
