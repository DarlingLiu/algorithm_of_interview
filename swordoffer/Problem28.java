package sword_offer;

import java.util.Arrays;

public class Problem28 {
	
	public int MoreThanHalfNum_Solution(int [] array) {
        if(array == null || array.length == 0)
        	return 0;
		Arrays.sort(array);
		int begin = array[0];
		int sum = 1;
		for(int i = 1; i < array.length; i++) {
			if(array[i] == begin) {
				sum++;
				if(sum > array.length/2)
					return array[i];
			}else {
				begin = array[i];
				sum = 1;
			}
		}
		return 0;
    }

}
