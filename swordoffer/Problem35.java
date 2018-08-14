package ldl.swordoffer;

import java.util.Arrays;

public class Problem35 {
	static int count = 0;
	static int[] copy;
    public int InversePairs(int [] array) {
        for(int i = 0; i < array.length-1; i++) {
        	for(int j = i+1; j < array.length; j++) {
        		if(array[i] > array[j]) {
        			count++;
        		}
        	}
        }
        return count%1000000007;
    }
    
    public int InversePairs2(int [] array) {
    	if(array == null || array.length == 0 || array.length == 1)
    		return count;
    	copy = new int[array.length];
        mergeProcess(array, 0, array.length-1);
        return count;
    }
    
    public void mergeProcess(int[] array, int low, int high) {
    	if(low < high) {
    		int mid = (low + high)/2;
    		mergeProcess(array, low, mid);
    		mergeProcess(array, mid+1, high);
    		mergeCount(array, low, mid, high);
    	}
    }
    
    public void mergeCount(int[] array, int low, int mid, int high) {
    	int index1 = mid;
    	int index2 = high;
    	int index = high;
//    	for(int i = mid; i >= low; i--) {
//    		for(int j = high; j >= mid+1; j--) {
//    			if(array[i] > array[j]) {
//    				count += (j-mid);
//    				break;
//    			}
//    		}
//    	}
    	
    	while(index1 >= low && index2 >= mid+1) {
    		if(array[index1] > array[index2]) {
    			count += (index2-mid);
    			if(count >= 1000000007)
    				count %= 1000000007;
    			copy[index--] = array[index1--];
    		}else {
    			copy[index--] = array[index2--];
    		}
    			
    	}
    	while(index1 >= low)
    		copy[index--] = array[index1--];
    	while(index2 >= mid+1)
    		copy[index--] = array[index2--];
    	
    	System.arraycopy(copy, low, array, low, high-low+1);
    	
    	
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Problem35 test = new Problem35();
		int[] array = {1,2,3,4,5,6,7,0};
		test.InversePairs2(array);
		System.out.println(count);
		System.out.println(Arrays.toString(array));
	}

}
