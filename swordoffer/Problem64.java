package ldl.swordoffer;

import java.util.ArrayList;

/**
 * 给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。
 * 例如，如果输入数组{2,3,4,2,6,2,5,1}及滑动窗口的大小3，
 * 那么一共存在6个滑动窗口，他们的最大值分别为{4,4,6,6,6,5}；
 * @author darlingliu
 *
 */

public class Problem64 {
	
    public ArrayList<Integer> maxInWindows(int [] num, int size){
        ArrayList<Integer> list = new ArrayList<>();
        if(num == null || num.length < 1 || size > num.length || size < 1)
        	return list;
        int begin = 0;
        int end = size-1;
        for(; end < num.length; begin++, end++) {
        	list.add(getMax(num, begin, end));
        }
        return list;
    }
    
    public int getMax(int[] num, int begin, int end) {
    	int max_index = begin;
    	for(int i = begin+1; i <= end; i++) {
    		if(num[i] > num[max_index])
    			max_index = i;
    	}
    	return num[max_index];
    }

}
