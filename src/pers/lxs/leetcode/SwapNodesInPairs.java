package pers.lxs.leetcode;

import org.junit.Test;

public class SwapNodesInPairs {

	@Test
	public void test() {
		int[] a = new int[]{1, 2, 3, 4, 5, 6, 7, 8};
		
		ListNode head = generateList(a);
		
		displayList(head);
		
//		head = reverse(head);
//		
//		displayList(head);
		
		head = swapPairs(head, 2);
		
		displayList(head);
	}
	
	public void displayList(ListNode head) {
		
		if(head == null) {
			System.out.println(head);
			return;
		}
		
		ListNode current = head;
		
		StringBuilder sb = new StringBuilder();
		
		while(current != null) {
			sb.append(current.val + "->");
			current = current.next;
		}
		
		String result = sb.toString();
		result = result.substring(0, result.length() - 2);
		
		System.out.println(result);
	}
	
	public ListNode generateList(int[] a) {
		
		if(a.length <= 0) {
			return null;
		}
		
		ListNode head = new ListNode(a[0]);
		ListNode current = head;
		for(int i = 1; i < a.length; i++) {
			current.next = new ListNode(a[i]);
			current = current.next;
		}
		
		return head;
	}
	
	public ListNode swapPairs(ListNode head, int k) {
		
		if(head == null || head.next == null) {
			return head;
		}
		
		ListNode current = head;
		head = new ListNode(0);
				
		ListNode preTail = head;
		preTail.next = current;
		
		ListNode midHead = current;
		ListNode midTail = current;
		ListNode nextHead = current;
		
		while(true) {
			
			midHead = nextHead;
			current = midHead;
			
			int index = 0;
			while(index < k && current != null) {
				midTail = current;
				current = current.next;
				index++;
			}

			if(index < k) {
				break;
			}
			
			
			nextHead = midTail.next;
			midTail.next = null;
			
			ListNode tempTail = midHead;
			preTail.next = reverse(midHead);
			preTail = tempTail;
			preTail.next = nextHead;
		}
		
		return head.next;
	}
	
	public ListNode reverse(ListNode head) {
		
		if(head == null || head.next == null) {
			return head;
		}
		
		ListNode current = head;
		head = null;
		
		while(current != null) {
			ListNode temp = current.next;
			current.next = head;
			head = current;
			current = temp;
		}
		
		return head;
	}

	class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

}
