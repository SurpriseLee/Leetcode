package pers.lxs.leetcode;

import java.util.Arrays;

import org.junit.Test;

public class Main80 {

	@Test
	public void test() {

		int[] nums = new int[] { 0, 0, 1, 1, 1, 1, 2, 3, 3 };

		System.out.println(Arrays.toString(nums));

		int len = removeDuplicates(nums);

		System.out.println(len);

		System.out.println(Arrays.toString(nums));

	}

	public int removeDuplicates(int[] nums) {

		if (nums == null) {
			return -1;
		}

		if (nums.length <= 2) {
			return nums.length;
		}

		int p = 0;
		int curr = nums[p];
		int len = 0;
		while (p < nums.length) {

			if (nums[p] != curr) {
				len = 1;
				curr = nums[p];
			} else if (nums[p] == curr && len < 2) {
				len++;
			} else {
				break;
			}

			p++;
		}

		int q = p + 1;
		while (q < nums.length) {

			if (nums[q] != curr) {
				curr = nums[q];
				nums[p++] = nums[q];
				len = 1;
			} else if (nums[q] == curr && len < 2) {
				nums[p++] = nums[q];
				len++;
			}

			q++;
		}

		return p;
	}

}
