package pers.lxs.leetcode;

import org.junit.Test;

public class Main82 {

	@Test
	public void test() {
		
		int[] nums = new int[]{1,1};
		
		ListNode head = buildList(nums);
		
		ListNode curr = head;
		
		while(curr != null) {
			System.out.print(curr.val + "->");
			curr = curr.next;
		}
		System.out.println("NULL");
		
		ListNode resultList = deleteDuplicates(head);
		
		curr = resultList;
		while(curr != null) {
			System.out.print(curr.val + "->");
			curr = curr.next;
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
	
    public ListNode deleteDuplicates(ListNode head) {
        
    	if(head == null) {
    		return null;
    	}
    	
    	ListNode curr = new ListNode(Integer.MAX_VALUE);
    	curr.next = head;
    	head = curr;
    	while(curr.next != null && curr.next.next != null) {
    		
    		if(curr.next.val == curr.next.next.val) {
    			while(curr.next.next != null && curr.next.val == curr.next.next.val) {
    				curr.next = curr.next.next;
    			}
    			curr.next = curr.next.next;
    		} else {
    			curr = curr.next;
    		}
    	}
    	
    	return head.next;
    }
    
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
	
}
