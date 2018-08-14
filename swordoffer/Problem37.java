package ldl.swordoffer;

public class Problem37 {
	
    public int GetNumberOfK(int [] array , int k) {
        int count = 0;
        for(int i = 0; i < array.length; i++) {
        	if(array[i] == k)
        		count++;
        }
        return count;
    }
    
    public int GetNumberOfK2(int [] array , int k) {
        int count = 0;
        int pos = binarySearch(array, 0, array.length-1, k);
        if(pos != -1) {
        	count++;
        	int i = pos;
        	while(pos < array.length-1 && array[++pos] == k)
        		count++;
        	while(i > 0 && array[--i] == k)
        		count++;
        }
        return count;
    }
    
    public int binarySearch(int[] array, int low, int high, int k) {
    	while(low <= high) {
    		int mid = (low + high)/2;
        	if(array[mid] == k) {
        		return mid;
        	}else if(array[mid] > k) {
        		high = mid - 1;
        	}else {
    			low = mid + 1;
    		}
    	}
    	return -1;    	
    }
    
    public int GetNumberOfK3(int [] array , int k) {
        int count = 0;
        int left = binaryLeft(array, 0, array.length-1, k);
        int right = binaryRight(array, 0, array.length-1, k);
        if(left != -1 && right != -1) {
        	count = right-left+1;
        }        
        return count;
    }
    
    public int binaryLeft(int[] array, int low, int high, int k) {
    	int left = -1;
    	while(low <= high) {
    		int mid = (low + high)/2;
        	if(array[mid] == k) {
        		left = mid;
        		high = mid -1;
        	}else if(array[mid] > k) {
        		high = mid - 1;
        	}else {
    			low = mid + 1;
    		}
    	}
    	return left;    	
    }
    
    public int binaryRight(int[] array, int low, int high, int k) {
    	int right = -1;
    	while(low <= high) {
    		int mid = (low + high)/2;
        	if(array[mid] == k) {
        		right = mid;
        		low = mid + 1;
        	}else if(array[mid] > k) {
        		high = mid - 1;
        	}else {
    			low = mid + 1;
    		}
    	}
    	return right;    	
    }
    
    public static void main(String[] args) {
		Problem37 test = new Problem37();
		int[] array = {1,2,3,2,5,6,7,0};
		System.out.println(test.binaryLeft(array, 0, array.length-1, 2));
		System.out.println(test.binaryRight(array, 0, array.length-1, 2));
	}

}
