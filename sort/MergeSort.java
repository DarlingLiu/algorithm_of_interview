package sort;

import java.util.Arrays;

public class MergeSort {
	
	public static int[] mergeSort(int[] array) {
		int[] result = new int[array.length];
		mergeSort(array, 0, array.length-1,result);
		return result;
	}
	
	public static void mergeSort(int[] array, int from, int end, int[] result) {
		if(from < end) {
			int mid = (end+from)/2;
			mergeSort(array, from, mid, result);
			mergeSort(array, mid+1, end, result);
			merge(array, from, mid, end, result);
		}
	}
	
	public static void merge(int[] array, int from, int mid, int end, int[] result) {
		int index1 = from;
		int index2 = mid + 1;
		int index = from;
		while((index1 <= mid) && (index2 <= end)) {
			if(array[index1] <= array[index2])
				result[index++] = array[index1++];
			else
				result[index++] = array[index2++];			
		}
		while(index1 <= mid)
			result[index++] = array[index1++];
		while(index2 <= end)
			result[index++] = array[index2++];
		System.arraycopy(result, from, array, from, end-from+1);
	}

	public static void main(String[] args) {
		int[] array = {9,1,5,8,3,7,4,6,2};
		int[] result = mergeSort(array);
		System.out.println(Arrays.toString(result));

	}

}
