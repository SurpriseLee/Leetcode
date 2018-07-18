package pers.lxs.leetcode;

import org.junit.Test;

public class Main86 {

	@Test
	public void test() {

		int[] nums = new int[] { 1, 4, 3, 2, 5, 2 };

		ListNode head = buildList(nums);
		int x = 1;

		ListNode curr = head;
		while (curr != null) {
			System.out.print(curr.val + "->");
			curr = curr.next;
		}
		System.out.println("NULL");

		ListNode resultList = partition(head, x);

		curr = resultList;
		while (curr != null) {
			System.out.print(curr.val + "->");
			curr = curr.next;
		}
		System.out.println("NULL");

	}

	public ListNode buildList(int[] nums) {

		if (nums == null || nums.length <= 0) {
			return null;
		}

		ListNode head = new ListNode(nums[0]);
		ListNode curr = head;
		int index = 1;
		while (index < nums.length) {
			curr.next = new ListNode(nums[index++]);
			curr = curr.next;
		}

		return head;
	}

	public ListNode partition(ListNode head, int x) {

		if(head == null) {
			return null;
		}
		
		ListNode p = new ListNode(Integer.MIN_VALUE);
		p.next = head;
		head = p;
		
		while(p.next != null && p.next.val < x) {
			p = p.next;
		}
		
		ListNode q = p.next;
		while(q != null && q.next != null) {
			if(q.next.val < x) {
				
				ListNode temp = q.next;
				q.next = q.next.next;
				temp.next = p.next;
				p.next = temp;
				p = p.next;
			} else {
				q = q.next;
			}
		}
		
		return head.next;
	}

	class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

}
