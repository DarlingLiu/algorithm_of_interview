package ldl.swordoffer;

/**
 * ����һ�����������飬����������������ƴ�������ų�һ��������ӡ��ƴ�ӳ���������������С��һ����
 * ������������{3��32��321}�����ӡ���������������ųɵ���С����Ϊ321323��
 * @author darlingliu
 *
 */

public class Problem32 {
	
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
		Problem32 test = new Problem32();
		int[] numbers = {3,32,321};
		System.out.println(test.PrintMinNumber(numbers));

	}

}
