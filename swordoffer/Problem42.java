package ldl.swordoffer;

import java.util.ArrayList;

public class Problem42 {
	
    public ArrayList<Integer> FindNumbersWithSum(int [] array,int sum) {
        ArrayList<Integer> result = new ArrayList<>();
        
        if(array == null || array.length < 2)
        	return result;
        int small = 0;
        int big = array.length-1;
        while(small < big) {
        	if(array[small] + array[big] == sum) {
        		result.add(array[small]);
        		result.add(array[big]);
        		return result;
        	}else if(array[small] + array[big] > sum) {
        		big--;
        	}else {
        		small++;
        	}
        }        
        return result;
    }

}
