package sort;

import java.util.Arrays;

/**
 * �ȶ� 
 * �ռ临�Ӷ�O(1) 
 * ʱ�临�Ӷ�O(n2) 
 * ��������������Ҫ�ƶ�n*(n-1)/2��Ԫ�� 
 * �����������򣬲���Ҫ�ƶ�Ԫ��
 * ����������������ǡ���������ʱ����������Ч�ʵ�����������ʱ��ΪO(n)��
 * ����������������ʱ���ƽ���������ʱ�䶼ΪO(n2)��
 * ͨ��������������ֳ����������㷨�е�������ܡ�
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
        for (int i = 1; i < array.length; i++) { // ��1��ʼ�����������������У�ֱ����չ����������
            int j = i;//��¼����λ��j����ʼ��Ϊi
            int tmp = array[j];//����������
            while(j >= 1 && tmp < array[j-1]) {
            	array[j] = array[j-1];//�Ӻ�Ƚϣ����С����Ƹ�Ԫ�أ������²���λ��j
            	j = j - 1;
            }
            array[j] = tmp;
        }
    }
	
	public static void insertSort(int[] array){
        for (int i = 1; i < array.length; i++) { // ���������������У�ֱ����չ����������
            for (int j = i; j > 0; j--) {    // �����������в����µ�Ԫ��
                if(array[j]  < array[j-1]){  // ����
                    int temp = array[j];
                    array[j] = array[j-1];
                    array[j-1] = temp;
                }
            }
        }
    }

}
