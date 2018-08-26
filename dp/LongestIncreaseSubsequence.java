package ldl.dp;

/**
 * 这是一个经典的LIS(即最长上升子序列)问题，请设计一个尽量优的解法求出序列的最长上升子序列的长度。
 * 给定一个序列A及它的长度n(长度小于等于500)，请返回LIS的长度。
 * [1,4,2,5,3],5
 * 返回 3
 * @author darlingliu
 * 思路：dp[i]表示以i位置为结尾时的最长递增子序列
 */

public class LongestIncreaseSubsequence {
	
	public int getLIS(int[] A, int n) {
		if(n <= 0) 
			return 0;
        int[] dp= new int[n];
        for(int i = 0; i < n; i++) {
        	if(i == 0) {
        		dp[i] = 1;
        	}else {
        		dp[i] = 1;
        		for(int j = i-1; j >= 0; j--) {
        			if(A[i] > A[j]) {
        				dp[i] = Math.max(dp[i], dp[j]+1);
        			}
        		}
        	}
        }
        int result = 0;
        for(int i = 0; i < n; i++)
        	result = Math.max(result, dp[i]);
        return result;
    }

}
