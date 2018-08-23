package sort;

import java.util.Arrays;

public class SelectSort {
	
	//min��¼ÿ��ѭ������Сֵ���±꣬���ڴ�ѭ��������һ�ν������������ڲ�ѭ����Ƶ������
	public static void selectsort(int[] array) {
		int min = 0;
		for(int i = 0; i < array.length-1; i++) {
			min = i;
			for(int j = i+1; j < array.length; j++) {
				if(array[j] < array[min])
					min = j;
			}
			if(i != min)
				swap(array, i, min);
		}
	}
	
	public static void swap(int[] array, int a, int b) {
		int tmp = array[a];
		array[a] = array[b];
		array[b] = tmp;
	}

	public static void main(String[] args) {
		int[] array = {9,1,5,8,3,7,4,6,2};
		selectsort(array);
		System.out.println(Arrays.toString(array));

	}

}
