package ldl.dp;

/**
 * 有n级台阶，一个人每次上一级或者两级，问有多少种走完n级台阶的方法。为了防止溢出，请将结果Mod 1000000007
 * 给定一个正整数n，请返回一个数，代表上楼的方式数。保证n小于等于100000。
 * @author darlingliu
 *
 */

public class GoUpstairs {
	
	public int countWays(int n) {
        int[] ways = new int[n+1];
        ways[1] = 1;
        ways[2] = 2;
        for(int i = 3; i < ways.length; i++) {
        	ways[i] = ways[i-1] + ways[i-2];
        	if(ways[i] >= 1000000007) {
        		ways[i] %= 1000000007;
        	}
        }
        return ways[n];
    }

}
