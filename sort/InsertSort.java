package sort;

import java.util.Arrays;

/**
 * 稳定 
 * 空间复杂度O(1) 
 * 时间复杂度O(n2) 
 * 最差情况：反序，需要移动n*(n-1)/2个元素 
 * 最好情况：正序，不需要移动元素
 * 数组在已排序或者是“近似排序”时，插入排序效率的最好情况运行时间为O(n)；
 * 插入排序最坏情况运行时间和平均情况运行时间都为O(n2)。
 * 通常，插入排序呈现出二次排序算法中的最佳性能。
 * @author darlingliu
 *
 */

public class InsertSort {

	public static void main(String[] args) {
		int[] array = new int[]{3, 1, 4, 2};
		insertSort(array);		
		System.out.println(Arrays.toString(array));

	}
	
	public static void insertSort2(int[] array){
        for (int i = 1; i < array.length; i++) { // 从1开始，不断扩大有序序列，直到扩展到整个数组
            int j = i;//记录插入位置j，初始化为i
            int tmp = array[j];//保存插入变量
            while(j >= 1 && tmp < array[j-1]) {
            	array[j] = array[j-1];//从后比较，如果小则后移该元素，并更新插入位置j
            	j = j - 1;
            }
            array[j] = tmp;
        }
    }
	
	public static void insertSort(int[] array){
        for (int i = 1; i < array.length; i++) { // 不断扩大有序序列，直到扩展到整个数组
            for (int j = i; j > 0; j--) {    // 向有序序列中插入新的元素
                if(array[j]  < array[j-1]){  // 交换
                    int temp = array[j];
                    array[j] = array[j-1];
                    array[j-1] = temp;
                }
            }
        }
    }

}
