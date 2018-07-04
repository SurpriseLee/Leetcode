package pers.lxs.leetcode;

import org.junit.Test;

public class Main61 {
	
	@Test
	public void test() {
		
		int[] nums = new int[]{0,1,2};
		
		ListNode head = buildList(nums);
		
		int k = 4;
		
		ListNode resultList = rotateRight(head, k);
		
		while(resultList != null) {
			System.out.print(resultList.val + "->");
			resultList = resultList.next;
			
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
	
    public ListNode rotateRight(ListNode head, int k) {
        
    	if(head == null) {
    		return null;
    	}
    	
    	ListNode tailParent = new ListNode(0);
    	int len = getLen(head, tailParent);
    	
    	ListNode curr = head;
    	
    	int target = len - 1 - (k % len);
    	while(target > 0) {
    		curr = curr.next;
    		target--;
    	}
    	
    	tailParent.next.next = head;
    	head = curr.next;
    	curr.next = null;
    	
    	return head;
    }
    
    public int getLen(ListNode head, ListNode tailParent) {
    	
    	if(head == null) {
    		return 0;
    	}
    	
    	ListNode curr = head;
    	int len = 1;
    	while(curr.next != null) {
    		len++;
    		curr = curr.next;
    	}
    	
    	tailParent.next = curr;
    	
    	return len;
    }
    
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

}
