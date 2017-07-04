package pers.lxs.leetcode;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

import org.junit.Test;

public class Solution {
	
	@Test
	public void test() {
		
		int n = 3;
		List<String> list = generateParenthesis(n);
		Iterator<String> iterator = list.iterator();
		while(iterator.hasNext()) {
			String string = iterator.next();
			System.out.println(string);
		}
	}
	
	public List<String> generateParenthesis(int n) {
        
		LinkedList<String> resultList = new LinkedList<String>();
		
		if(n == 0) {
			return resultList;
		}
		
		int left = n - 1;	int right = n - 1;

		String str = "(";
		
		generateParenthesis(str, left, right, resultList);
		
		return resultList;
    }
	
	private void generateParenthesis(String str, int left, int right, LinkedList<String> list) {
		
		if(left > right + 1) {
			return;
		}
		
		if(left <= 0) {
			
			while(right > 0) {
				str += ")";
				right--;
			}
			str += ")";
			
			if(isValid(str)) {
				list.add(str);
			}
			
			return;
		}
		
		if(right <= 0) {
			
			while(left > 0) {
				str += "(";
				left--;
			}
			str += ")";
			
			if(isValid(str)) {
				list.add(str);
			}
			
			return;
		}
		
		generateParenthesis(str + "(", left - 1, right, list);
		generateParenthesis(str + ")", left, right - 1, list);
	}
	
	public boolean isValid(String s) {
        
		Stack<Character> stack = new Stack<Character>();
		for (char c : s.toCharArray()) {
			if (c == '(')
				stack.push(')');
			else if (c == '{')
				stack.push('}');
			else if (c == '[')
				stack.push(']');
			else if (stack.isEmpty() || stack.pop() != c)
				return false;
		}
		
		return stack.isEmpty();
    }
	
	class ListNode {
		 int val;
		 ListNode next;
		 
		 ListNode(int x) { val = x; }
	}
	
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
				
		if(l1 == null) return l2;
		if(l2 == null) return l1;
		
	    ListNode head = null;
	    
	    if(l1.val <= l2.val) {
    		head = l1;
    		l1 = l1.next;
    	} else {
    		head = l2;
    		l2 = l2.next;
    	}
	    
	    ListNode current = head;
	    
	    while(l1 != null && l2 != null) {
	    	if(l1.val < l2.val) {
	    		current.next = l1;
	    		current = current.next;
	    		l1 = l1.next;
	    	} else {
	    		current.next = l2;
	    		current = current.next;
	    		l2 = l2.next;
	    	}
	    }
	    
	    if(l1 == null) {
	    	current.next = l2;
	    } else {
	    	current.next = l1;
	    }
	    
	    
	    return head;
	}
	
	public ListNode removeNthFromEnd(ListNode head, int n) {
        
		if(head == null) {
			return null;
		}
		
		int index = 0;
		ListNode targetParent = head;
		ListNode current = head;
		while(current.next != null) {
			current = current.next;
			index++;
			if(index > n) {
				targetParent = targetParent.next;
			}
		}
		
		if(index < n - 1) {
			head = null;
		} else if(index == n - 1) {
			head = head.next;
		} else {
			targetParent.next = targetParent.next.next;
		}
		
		return head;
    }

}
