package pers.lxs.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

public class Main49 {
	
	@Test
	public void test() {
		
		String[] strs = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
		
		List<List<String>> lists = groupAnagrams(strs);
		
		for(List<String> list : lists) {
			System.out.println(list.toString());
		}
	}
	
    public List<List<String>> groupAnagrams(String[] strs) {
        
    	List<List<String>> lists = new ArrayList<List<String>>();
    	
    	if(strs == null || strs.length <= 0) {
    		return lists;
    	}
    	
    	Map<String, List<String>> map = new HashMap<String, List<String>>();
    	
    	for(String str : strs) {
    		
    		List<String> list = null;
    		
    		String key = getKey(str);
    		
    		if(map.containsKey(key)) {
    			list = map.get(key);
    		} else {
    			list = new ArrayList<String>();
    			map.put(key, list);
    			lists.add(list);
    		}
    		
    		list.add(str);
    	}
    	
    	return lists;
    }
    
    public String getKey(String str) {
    	
    	if(str == null) {
    		return null;
    	}
    	
    	char[] chs = str.toCharArray();
    	Arrays.sort(chs);
    	
    	return new String(chs);
    }

}
