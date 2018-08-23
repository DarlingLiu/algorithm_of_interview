package sword_offer;

/**
 * ����һ���������飬ʵ��һ�����������������������ֵ�˳��ʹ�����е�����λ�������ǰ�벿�֣�
 * ���е�ż��λ��λ������ĺ�벿�֣�����֤������������ż����ż��֮������λ�ò��䡣
 * @author darlingliu
 *
 */

public class Problem13 {
	
	public static int[] reOrderArray(int [] array) {
		
		int i = 0;
		int flag = 0;
        while(flag < array.length) {
        	if((array[i] & 1) == 0) {
        		for(int j = i+1; j < array.length; j++) {
        			int temp = array[j-1];
        			array[j-1] = array[j];
        			array[j] = temp;
        		}
        		i--;
        	}
        	flag++;
        	i++;
        }
        return array;
    }

	public static void main(String[] args) {
		int[] array = {1,2,3,4,5,6,7};
		int[] result = reOrderArray(array);
		for(int a: result)
			System.out.println(a);

	}

}
