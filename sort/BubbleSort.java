package sort;

public class BubbleSort {
	
	public static void general_bubblesort(int[] array) {
		for(int i = 0; i < array.length-1; i++) {
			for(int j = array.length-1; j > i; j--) {
				if(array[j] < array[j-1]) {
					swap(array, j, j-1);
				}
			}
		}
	}
	
	//优化后的冒泡排序，设置flag，内层循环开始时设置为false，如果在该内层循环中没有值交换，说明后续的元素都是有序的，则flag为false，外层循环终止。
	public static void optimize_bubblesort(int[] array) {
		boolean flag = true;
		for(int i = 0; i < array.length-1 && flag; i++) {
			flag = false;
			for(int j = array.length-1; j > i; j--) {
				if(array[j] < array[j-1]) {
					swap(array, j, j-1);
					flag = true;
				}
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
		general_bubblesort(array);
		optimize_bubblesort(array);
		for(int i: array)
			System.out.println(i);

	}

}
