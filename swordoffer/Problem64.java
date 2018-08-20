package ldl.swordoffer;

import java.util.ArrayList;

/**
 * ����һ������ͻ������ڵĴ�С���ҳ����л�����������ֵ�����ֵ��
 * ���磬�����������{2,3,4,2,6,2,5,1}���������ڵĴ�С3��
 * ��ôһ������6���������ڣ����ǵ����ֵ�ֱ�Ϊ{4,4,6,6,6,5}��
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
