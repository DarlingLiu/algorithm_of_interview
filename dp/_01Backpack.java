package ldl.dp;

/**
 * 一个背包有一定的承重cap，有N件物品，每件都有自己的价值，记录在数组v中，也都有自己的重量，
 * 记录在数组w中，每件物品只能选择要装入背包还是不装入背包，要求在不超过背包承重的前提下，选出物品的总价值最大。
 * @author darlingliu
 *
 */

public class _01Backpack {
	
	public int maxValue(int[] w, int[] v, int n, int cap) {
        if(n <= 0 || cap <= 0) 
        	return -1;
        int[][] dp = new int[n][cap+1];
        //初始化第一行，只取第一件物品时，得到的最大价值（一件物品只能取依次）
        for(int j = 0; j < cap+1; j++) {
        	dp[0][j] = j < w[0]? 0: v[0];
        }
        
        //初始化第一列，承重cap=0，所得最大价值都为0
        for(int i = 0; i < n; i++) {
        	dp[i][0] = 0;
        }
        
        //初始化内部dp, dp[i][j] = max(dp[i-1][j], dp[i-1][j-w[i]]+v[i])
        for(int i = 1; i < n; i++) {
        	for(int j = 1; j < cap+1; j++) {
        		//如果w[i] > j,则直接等于dp[i-1][j],否则取较大值
        		dp[i][j] = dp[i-1][j];
        		if(w[i] <= j) {
        			dp[i][j] = Math.max(dp[i][j], dp[i-1][j-w[i]]+v[i]);
        		}
        	}
        }
        return dp[n-1][cap];
    }

}
