package sword_offer;

/**
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
 * 思路：当n>=3时，f(n)=f(n-1)+f(n-2),同斐波那契数列求解
 * @author darlingliu
 *
 */

public class Problem08 {
	
	public int JumpFloor(int target) {
		
		if(target == 0)
			return 0;
		if(target == 1)
			return 1;
		if(target == 2) 
			return 2;
		int one = 1;
		int two = 2;
		int result = 0;
		for(int i = 3; i <= target; i++) {
			result = one + two;
			one = two;
			two = result;
		}
		
		return result;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
