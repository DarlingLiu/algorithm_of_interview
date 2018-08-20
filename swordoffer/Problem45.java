package ldl.swordoffer;

import java.util.Arrays;

public class Problem45 {
	
    public boolean isContinuous(int [] numbers) {
    	if(numbers == null || numbers.length == 0)
    		return false;
    	Arrays.sort(numbers);
    	int blank = 0;
    	int zero = 0;
    	for(int i = numbers.length-1; i > 0; i--) {
    		if(numbers[i] == 0) {
    			zero += (i+1);
    			break;
    		}
    		if(numbers[i-1] != 0 && numbers[i] - numbers[i-1] == 0) {
    			return false;
    		}
    		if(numbers[i-1] != 0 && numbers[i] - numbers[i-1] > 0){
    			blank += (numbers[i] - numbers[i-1]-1);
			}
    	}
    	zero += (numbers[0] == 0? 1: 0);
    	return zero >= blank? true: false;
    }
    
    public static void main(String[] args) {
		Problem45 test = new Problem45();
		int[] numbers = {1,3,2,5,4};
		System.out.println(test.isContinuous(numbers));
	}
}
