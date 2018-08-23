package sort;

import java.util.Arrays;

public class BinaryInsertSort {
	
	public static int getInsertPos(int[] array, int low, int high, int insertVal) {
		int mid = low;
		while(low <= high) {
			mid = (low + high)/2;
			if(low == high)
				return insertVal >= array[mid]? mid+1: mid;			
			if(insertVal >= array[mid] && insertVal < array[mid+1]) {
				return mid+1;
			}
			else if(insertVal < array[mid]) {
				high = mid;
			}
			else {
				low = mid+1;
			}
		}
		return mid;
		
	}
	
	public static void binaryInsertSort(int[] array) {
		
		for(int i = 1; i < array.length; i++) {
			int tmp = array[i];
			int insertPos = getInsertPos(array, 0, i-1, tmp);
			for(int j = i; j > insertPos; j--) {
				array[j] = array[j-1];
			}
			array[insertPos] = tmp;
		}
	}

	public static void main(String[] args) {
		
		int[] array = {9,1,5,8,3,7,4,6,2};
		binaryInsertSort(array);
		System.out.println(Arrays.toString(array));

	}

}
