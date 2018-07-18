package pers.lxs.leetcode;

import org.junit.Test;

public class Main92 {

	@Test
	public void test() {

		int m = 2;
		int n = 4;
		
		int[] nums = new int[]{1,2,3,4,5};
		
		ListNode head = buildList(nums);
		
		ListNode result = reverseBetween(head, m, n);
		
		while(result != null) {
			System.out.print(result.val + "->");
			result = result.next;
		}
		System.out.println("NULL");
	}
	
	
	public ListNode buildList(int[] nums) {
		
		if(nums == null || nums.length <= 0) {
			return null;
		}
		
		ListNode head = new ListNode(nums[0]);
		
		ListNode curr = head;
		int index = 1;
		while(index < nums.length) {
			curr.next = new ListNode(nums[index++]);
			curr = curr.next;
		}
		
		return head;
	}
	
    public ListNode reverseBetween(ListNode head, int m, int n) {
        
    	if(head == null) {
    		return head;
    	}
    	
    	ListNode node = new ListNode(0);
    	node.next = head;
    	head = node;
    	
    	ListNode curr = head;
    	int index = 0;
    	while(index < m - 1 && curr.next != null) {
    		curr = curr.next;
    		index++;
    	}
    	
    	ListNode p = curr;
    	curr = curr.next;
    	index++;
    	
    	ListNode tempHead = curr;
    	ListNode tempTail = curr;
    	curr = curr.next;
    	index++;
    	while(index <= n && curr != null) {
    		ListNode temp = curr;
    		curr = curr.next;
    		temp.next = tempHead;
    		tempHead = temp;
    		index++;
    	}
    	
    	p.next = tempHead;
    	tempTail.next = curr;
    	
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
