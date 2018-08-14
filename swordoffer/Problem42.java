package ldl.swordoffer;

/**
 * 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 * 例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。
 * @author darlingliu
 *
 */

public class Problem42 {
	
    public String PrintMinNumber(int [] numbers) {
    	if(numbers == null || numbers.length == 0)
    		return "";
    	StringBuffer sb = new StringBuffer();
    	for(int i = 0; i < numbers.length-1; i++) {
    		int min_index = i;
    		for(int j = i+1; j < numbers.length; j++) {
    			if(!compareA_B(numbers[min_index], numbers[j]))
    				min_index = j;
    		}
    		sb.append(numbers[min_index]);
    		if(min_index != i) {
    			swap(numbers, min_index, i);
    		}
    	}
    	sb.append(numbers[numbers.length-1]);
    	return sb.toString();
    }
    
    public boolean compareA_B(int a, int b) {
    	String ab = "" + a + b;
    	String ba = "" + b + a;
    	if(ab.compareTo(ba) <= 0)
    		return true;
    	return false;
    }
    public void swap(int[] array, int a, int b) {
    	int tmp = array[a];
    	array[a] = array[b];
    	array[b] = tmp;
    }

	public static void main(String[] args) {
		Problem42 test = new Problem42();
		int[] numbers = {3,32,321};
		System.out.println(test.PrintMinNumber(numbers));

	}

}
