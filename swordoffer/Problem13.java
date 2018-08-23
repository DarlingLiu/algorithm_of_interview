package sword_offer;

/**
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，
 * 所有的偶数位于位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
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
