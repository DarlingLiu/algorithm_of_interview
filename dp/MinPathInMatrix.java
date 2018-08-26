package ldl.dp;

/**
 * 有一个矩阵map，它每个格子有一个权值。从左上角的格子开始每次只能向右或者向下走，
 * 最后到达右下角的位置，路径上所有的数字累加起来就是路径和，返回所有的路径中最小的路径和。
 * 1,2,3
 * 1,1,1
 * 1,0,1
 * 返回 4
 * @author darlingliu
 * 思路：dp[i][j]最小值为dp[i-1][j]和dp[i][j-1]中最小值加当前值
 */

public class MinPathInMatrix {
	
	public int getMin(int[][] map, int n, int m) {
        if(n <= 0 || m <= 0)
        	return -1;
        int[][] dp = new int[n][m];
        for(int i = 0; i < n; i++) {
        	for(int j = 0; j < m; j++) {
        		if(i == 0 && j == 0) {
        			dp[i][j] = map[i][j];
        		}else if(i == 0) {
        			dp[i][j] = dp[i][j-1] + map[i][j];
        		}else if(j == 0) {
        			dp[i][j] = dp[i-1][j] + map[i][j];
        		}else {
        			dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1]) + map[i][j];
        		}       		
        	}
        }
        return dp[n-1][m-1];
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
