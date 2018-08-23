package sort;

import java.util.Arrays;

public class HeapSort2 {
	
	public static void heapSort(int[] array) {
		
		initMaxHeap(array);
		
		for(int i = array.length - 1; i > 0; i--) {
			swap(array, 0, i);
			buildMaxHeap(array, 0, i);
		}
	}
	
	public static void initMaxHeap(int[] array) {
		int pos = array.length/2 - 1;
		for(; pos >= 0; pos--) {
			buildMaxHeap(array, pos, array.length);
		}		
	}
	
	public static void buildMaxHeap(int[] array, int pos, int len) {
		int left = 2*pos + 1;
		int right = 2*pos + 2;
		int maxIndex = pos;
		if(left < len && array[left] > array[maxIndex])
			maxIndex = left;
		if(right < len && array[right] > array[maxIndex])
			maxIndex = right;
		if(maxIndex != pos) {
			swap(array, pos, maxIndex);
			buildMaxHeap(array, maxIndex, len);
		}
	}
	
	public static void swap(int[] array, int a, int b) {
		int tmp = array[a];
		array[a] = array[b];
		array[b] = tmp;
	}

	public static void main(String[] args) {
		int a[] = { 51, 46, 33, 30, 65, 9, 82, 30, 99};
        heapSort(a);
        System.out.println(Arrays.toString(a));


	}

}
