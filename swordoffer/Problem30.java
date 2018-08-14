package ldl.swordoffer;

public class Problem30 {
	
	public static int FindGreatestSumOfSubArray(int[] array) {
        
		int max = array[0];
		int cur_max = array[0];
		int begin = 0;
		int end = 0;
		
		for(int i = 1; i < array.length; i++) {
			if(cur_max < 0) {
				cur_max = array[i];
				begin = i;
			}else {
				cur_max += array[i];
			}
			
			if(cur_max > max) {
				max = cur_max;
				end = i;
			}
		}
		System.out.println("begin: " + begin + "end: " + end);
		return max;
    }

	public static void main(String[] args) {
		int[] array = {1, -2, 3, 10, -4, 7, 2, -5};
		System.out.println(FindGreatestSumOfSubArray(array));
	}

}
