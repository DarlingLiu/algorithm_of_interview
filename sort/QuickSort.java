package sort;

import java.util.Arrays;

public class QuickSort {
	
	public static void quickSort(int[] array) {
		quickSort(array, 0, array.length-1);
	}
	
	public static void quickSort(int[] array, int low, int high) {
		if(low < high) {
			int pivot = getPivot(array, low, high);
			quickSort(array, low, pivot-1);
			quickSort(array, pivot+1, high);
		}
	}

	public static int getPivot(int[] array, int low, int high) {
		int pivot = low;
		while(low != high) {
			if(pivot != high) {
				if(array[high] < array[pivot]) {
					swap(array, pivot, high);
					pivot = high;
				}else {
					high--;
				}
			}else {
				if(array[low] > array[pivot]) {
					swap(array, pivot, low);
					pivot = low;
				}else {
					low++;
				}
			}
//			if(low == high)
//				break;
		}
		return pivot;
	}
	
	public static void swap(int[] array, int a, int b) {
		int tmp = array[a];
		array[a] = array[b];
		array[b] = tmp;
	}
	
	public static void main(String[] args) {
		int[] array = {9,1,5,8,3,7,4,6,2};
		quickSort(array);
		System.out.println(Arrays.toString(array));

	}

}
