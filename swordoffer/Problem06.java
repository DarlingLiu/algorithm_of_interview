package sword_offer;

/**
 * ��һ�������ʼ�����ɸ�Ԫ�ذᵽ�����ĩβ�����ǳ�֮Ϊ�������ת�� 
 * ����һ���ǵݼ�����������һ����ת�������ת�������СԪ�ء� 
 * ��������{3,4,5,1,2}Ϊ{1,2,3,4,5}��һ����ת�����������СֵΪ1�� 
 * NOTE������������Ԫ�ض�����0���������СΪ0���뷵��0��
 * @author darlingliu
 *
 *
 */

public class Problem06 {
	
	public static int minNumberInRotateArray(int [] array) {
		if(array.length == 0)
			return 0;
		int left = 0;
		int right = array.length - 1;
		
		if(array[left] < array[right])
			return array[left];
		while((right - left) > 1) {
			int mid = (left + right)/2;
			if(array[mid] >= array[left]) {
				left = mid;
			}else if(array[mid] <= array[right]){
				right = mid;
			}		
		}	      
		return array[right];
    }

	public static void main(String[] args) {
		

	}

}
