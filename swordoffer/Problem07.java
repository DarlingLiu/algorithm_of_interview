package sword_offer;

/**
 * 大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项。
 * n<=39
 * 		         0        (n=0)
 * f(n) =        1        (n=1)
 *         f(n-1)+f(n-1)  (n>1)
 * 
 */

public class Problem07 {
	
	public int Fibonacci1(int n) {
		if(n <= 0)
			return 0;
		if(n == 1)
			return 1;
		return Fibonacci1(n-1) + Fibonacci1(n-2);
    }
	
	public static int Fibonacci2(int n) {
		if(n <= 0)
			return 0;
		if(n == 1)
			return 1;
		int[] array = new int[n+1];
		array[0] = 0;
		array[1] = 1;
		for(int i = 2; i <= n; i++) {
			array[i] = array[i-1] + array[i-2];
		}
		return array[n];
    }
	
	public static int Fibonacci3(int n) {
		if(n <= 0)
			return 0;
		if(n == 1)
			return 1;
		int one = 0;
		int two = 1;
		int result = 0;
		for(int i = 2; i <= n; i++) {
			result = one + two;
			one = two;
			two = result;
		}
		return result;
    }

	public static void main(String[] args) {
		System.out.println(Fibonacci2(0));

	}

}
