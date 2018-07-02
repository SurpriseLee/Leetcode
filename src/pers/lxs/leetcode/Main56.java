package pers.lxs.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.junit.Test;

public class Main56 {
	
	@Test
	public void test() {
		
		int[][] intervalsArray = new int[][]{{1,3},{2,6},{8,10},{15,18}};
		
		List<Interval> intervals = array2Intervals(intervalsArray);
		
		List<Interval> resultIntervals = merge(intervals);
		
		for(Interval e : resultIntervals) {
			System.out.println("[" + e.start + ", " + e.end + "]");
		}
		
	}
	
	public List<Interval> array2Intervals(int[][] intervalsArray) {
		
		List<Interval> list = new ArrayList<Interval>();
		
		if(intervalsArray == null || intervalsArray.length <= 0) {
			return list;
		}
		
		for(int i = 0; i < intervalsArray.length; i++) {
			
			list.add(new Interval(intervalsArray[i][0], intervalsArray[i][1]));
			
		}
		
		return list;
	}
	
    public List<Interval> merge(List<Interval> intervals) {
        
    	if(intervals == null || intervals.size() <= 1) {
    		return intervals;
    	}
    	
    	List<Interval> resultIntervals = new ArrayList<Interval>();
    	
    	Collections.sort(intervals, new Comparator<Interval>() {

			@Override
			public int compare(Interval o1, Interval o2) {
				// TODO Auto-generated method stub
				return o1.start - o2.start;
			}
		});
    	
    	Interval curr = intervals.remove(0);
    	while(!intervals.isEmpty()) {
    		Interval temp = intervals.remove(0);
    		
    		if(temp.start <= curr.end) {
    			curr.end = Math.max(curr.end, temp.end);
    		} else {
    			resultIntervals.add(curr);
    			curr = temp;
    		}
    	}
    	resultIntervals.add(curr);
    	
    	return resultIntervals;
    }
    
    class Interval {
        int start;
        int end;
        Interval() { start = 0; end = 0; }
        Interval(int s, int e) { start = s; end = e; }
    }

}
