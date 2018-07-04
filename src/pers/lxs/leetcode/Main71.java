package pers.lxs.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

import org.junit.Test;

public class Main71 {
	
	@Test
	public void test() {
		
		String str = "/home//foo/";
		String[] strs = str.trim().split("/");
		
		System.out.println("len: " + strs.length);
		for(String s : strs) {
			System.out.println(s);
		}
		
		String path = "/home//foo/";
		String simplifyPath = simplifyPath(path);
		System.out.println(simplifyPath);
	}
	
    public String simplifyPath(String path) {
        
    	if(path == null ||path.length() <= 1) {
    		return path;
    	}
    	
    	String[] paths = path.trim().split("/");
    	Deque<String> stack = new ArrayDeque<String>();
    	for(String p : paths) {
    		
    		if(p.equals("") || p.equals(".")) {
    			continue;
    		} 
    		
    		if(p.equals("..")) {
    			stack.pollFirst();
    		} else {
    			stack.offerFirst("/" + p);
    		}
    	}
    	
    	String simplifyPath = "";
    	while(!stack.isEmpty()) {
    		simplifyPath = stack.pollFirst() + simplifyPath;
    	}
    	
    	return simplifyPath.equals("") ?  "/" : simplifyPath;
    }

}
