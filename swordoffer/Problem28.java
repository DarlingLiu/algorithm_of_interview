package ldl.swordoffer;

/**
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 * 例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。
 * 如果不存在则输出0。
 * @author darlingliu
 * 思路：剑指offer p208
 */

public class Problem28 {
	
	public static int MoreThanHalfNum_Solution(int [] array) {
        if(array == null || array.length == 0)
        	return 0;
        int times = 1;
        int target = array[0];
        for(int i = 1; i < array.length; i++) {
        	if(times == 0) {
        		target = array[i];
        		times = 1;
        	}else if(array[i] == target) {
        		times++;	
        	}else {
				times--;
			}
        }
        
        int num = 0;
        for(int i = 0; i < array.length; i++) {
        	if(target == array[i])
        		num++;
        }
        return num > array.length/2? target: 0;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
