package ldl.swordoffer;

import java.util.ArrayList;

/**
 * С����ϲ����ѧ,��һ����������ѧ��ҵʱ,Ҫ������9~16�ĺ�,�����Ͼ�д������ȷ����100��
 * ���������������ڴ�,�����뾿���ж������������������еĺ�Ϊ100(���ٰ���������)��
 * û���,���͵õ���һ������������Ϊ100������:18,19,20,21,22��
 * ���ڰ����⽻����,���ܲ���Ҳ�ܿ���ҳ����к�ΪS��������������?
 * @author darlingliu
 *
 */

public class Problem41 {
    public ArrayList<ArrayList<Integer> > FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();    	
        int low = 1;
        int high = 2;
        while(high <= (sum+1)/2) {
        	if(getSum(low, high) == sum) {
        		result.add(getList(low, high));
        		high++;
        	}else if(getSum(low, high) < sum) {
        		high++;
        	}else {
        		low++;
        	}
        }    	
    	return result;
    }
    
    public int getSum(int low, int high) {
    	int sum = 0;
    	for(int i = low; i <= high; i++) {
    		sum += i;
    	}
    	return sum;
    }
    
    public ArrayList<Integer> getList(int low, int high){
    	ArrayList<Integer> list = new ArrayList<>();
    	for(int i = low; i <= high; i++) {
    		list.add(i);
    	}
    	return list;
    }
    
    
    
    public ArrayList<ArrayList<Integer>> FindContinuousSequence2(int sum) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        for (int n = (int) Math.sqrt(2 * sum); n >= 2; n--) {
            if ((n & 1) == 1 && sum % n == 0 || (sum % n) * 2 == n) {
                ArrayList<Integer> list = new ArrayList<>();
                for (int j = 0, k = (sum / n) - (n - 1) / 2; j < n; j++, k++) {
                    list.add(k);
                }
                ans.add(list);
            }
        }
        return ans;
    }
}
