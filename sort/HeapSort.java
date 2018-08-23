package sort;

import java.util.Arrays;

public class HeapSort {
	
	public static void heapSort(int[] array) {
        if (array == null || array.length == 1)
            return;

        buildMaxHeap(array); // ��һ�����򣬹������ѣ�ֻ��֤�˶Ѷ�Ԫ��������������

        for (int i = array.length - 1; i >= 1; i--) {
            // �����ʲô��˼�أ������������һЩ�в�����Ŀǰarray[0]�ǵ�ǰ����������Ԫ�أ���Ҫ��ĩβ��Ԫ�ؽ���
            // Ȼ���ó�����Ԫ��
            swap(array, 0, i);

            // ��������´α�����ʱ�򣬾�Ӧ���������һ��Ԫ�أ�Ҳ���������Ǹ�ֵ��Ȼ��ʼ���¹�������
            // �ѵĴ�С�ͼ�ȥ1��Ȼ���0��λ�ÿ�ʼ����
            maxHeap(array, i, 0);
//            minHeap(array, i, 0);
        }
    }

    // ������
    public static void buildMaxHeap(int[] array) {
        if (array == null || array.length == 1)
            return;

        // �ѵĹ�ʽ���� int root = 2*i, int left = 2*i+1, int right = 2*i+2;
        int cursor = array.length / 2 - 1;
        for (int i = cursor; i >= 0; i--) { // ����forѭ���£��Ϳ��Ե�һ���������
            maxHeap(array, array.length, i);
//            minHeap(array, array.length, i);
        }
    }

    // ����
    public static void maxHeap(int[] array, int heapSieze, int index) {
        int left = index * 2 + 1; // ���ӽڵ�
        int right = index * 2 + 2; // ���ӽڵ�
        int maxValue = index; // ��ʱ����Index��λ�þ������ֵ

        // ������ӽڵ��ֵ���ȵ�ǰ����ֵ�󣬾Ͱ����ֵ��λ�û������ӽڵ��λ��
        if (left < heapSieze && array[left] > array[maxValue]) {
            maxValue = left;
        }

        // ������ӽڵ��ֵ���ȵ�ǰ����ֵ�󣬾Ͱ����ֵ��λ�û������ӽڵ��λ��
        if (right < heapSieze && array[right] > array[maxValue]) {
            maxValue = right;
        }

        // �������ȣ�˵����������ӽڵ��ֵ�б��Լ���ģ�λ�÷����˽�����λ��
        if (maxValue != index) {
            swap(array, index, maxValue); // ��Ҫ����λ��Ԫ��

            // ������λ�ú���Ҫ�ж��ӽڵ��Ƿ���������ѵ����ʡ��������ʣ������ӽڵ㶼�ȸ��ڵ�С��
            maxHeap(array, heapSieze, maxValue);
        }
    }

    // ��С��
    public static void minHeap(int[] array, int heapSieze, int index) {
        int left = index * 2 + 1; // ���ӽڵ�
        int right = index * 2 + 2; // ���ӽڵ�
        int maxValue = index; // ��ʱ����Index��λ�þ�����Сֵ

        // ������ӽڵ��ֵ���ȵ�ǰ��С��ֵС���Ͱ���Сֵ��λ�û������ӽڵ��λ��
        if (left < heapSieze && array[left] < array[maxValue]) {
            maxValue = left;
        }

        //  ������ӽڵ��ֵ���ȵ�ǰ��С��ֵС���Ͱ���Сֵ��λ�û������ӽڵ��λ��
        if (right < heapSieze && array[right] < array[maxValue]) {
            maxValue = right;
        }

        // �������ȣ�˵����������ӽڵ��ֵ�б��Լ�С�ģ�λ�÷����˽�����λ��
        if (maxValue != index) {
            swap(array, index, maxValue); // ��Ҫ����λ��Ԫ��

            // ������λ�ú���Ҫ�ж��ӽڵ��Ƿ��������С�ѵ����ʡ���С���ʣ������ӽڵ㶼�ȸ��ڵ��
            minHeap(array, heapSieze, maxValue);
        }
    }

    // ����Ԫ�ؽ���
    public static void swap(int[] array, int index1, int index2) {
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }



	public static void main(String[] args) {
		int a[] = { 51, 46, 33, 30, 65, 9, 82, 30, 77, 50 };
        heapSort(a);
        System.out.println(Arrays.toString(a));

	}

}
