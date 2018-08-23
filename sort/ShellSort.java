package sort;

import java.util.Arrays;

public class ShellSort {

	public static void main(String[] args) {
		int[] array = new int[]{4, 3, 1, 2, 5, 7, 6, 9, 8};
		shellSort(array);
		System.out.println(Arrays.toString(array));
		

	}
	
	public static void shellSort(int[] array) {
		
		int increment = array.length;
		do {
			increment = increment/3 + 1;
			for(int i = increment; i < array.length; i++) {
				int j = i;
				int tmp = array[j];
				while(j >= increment && tmp < array[j-increment]) {
					array[j] = array[j-increment];
					j = j - increment;
				}
				array[j] = tmp;
			}
		} while (increment > 1);
        
    }

}
