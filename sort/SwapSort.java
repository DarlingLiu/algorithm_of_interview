package sort;

import java.util.Arrays;

/**
 * ºÚµ•Ωªªª≈≈–Ú
 * @author darlingliu
 *
 */
public class SwapSort {
	
	public static void swapSort(int[] array) {
		for(int i = 0; i < array.length-1; i++) {
			for(int j = i+1; j < array.length; j++) {
				if(array[j] < array[i])
					swap(array, i, j);
			}
		}
	}
	
	public static void swap(int[] array, int a, int b) {
		int tmp = array[a];
		array[a] = array[b];
		array[b] = tmp;
	}

	public static void main(String[] args) {
		int[] array = {9,1,5,8,3,7,4,6,2};
		System.out.println(Arrays.toString(array));
		swapSort(array);
		for(int i: array)
			System.out.println(i);
	}

}
