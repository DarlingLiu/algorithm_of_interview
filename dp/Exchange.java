package ldl.dp;

/**
 * 有数组penny，penny中所有的值都为正数且不重复。每个值代表一种面值的货币，
 * 每种面值的货币可以使用任意张，再给定一个整数aim(小于等于1000)代表要找的钱数，求换钱有多少种方法。
 * @author darlingliu
 * dp[i][j]表示：用penny[0-i]的货币组成目标j的方法数
 * 则dp[i][j] = dp[i-1][j-penny[i]*k]求和(k=0,1...k)
 */

public class Exchange {
	
	public int countWays(int[] penny, int n, int aim) {
        if(n <= 0 || aim < 0)
        	return -1;
        int[][] dp = new int[n][aim+1];
        //初始化第一行dp[0][j]
        for(int j = 0; j < aim+1; j++) {
        	dp[0][j] = j % penny[0] == 0? 1: 0;
        }
        //初始化第一列dp[i][0]
        for(int i = 0; i < n; i++) {
        	dp[i][0] = 1;
        }
        
        //初始化内部dp
        for(int i = 1; i < n; i++) {
        	for(int j = 1; j < aim+1; j++) {
        		dp[i][j] = 0;
        		for(int k = 0; penny[i]*k <= j; k++) {
        			dp[i][j] += dp[i-1][j-penny[i]*k];
        		}
        	}
        }
        return dp[n-1][aim];
    }

}
