package ldl.dp;

/**
 * 给定两个字符串A和B，返回两个字符串的最长公共子序列的长度。
 * 例如，A="1A2C3D4B56”，B="B1D23CA45B6A”，”123456"或者"12C4B6"都是最长公共子序列。
 * 给定两个字符串A和B，同时给定两个串的长度n和m，请返回最长公共子序列的长度。保证两串长度均小于等于300。
 * @author darlingliu
 * 思路：dp[i][j]表示str1[0-i]和str2[0-j]的最长公共子串
 */

public class LongestCommonSubsequence {
	
	public int findLCS(String A, int n, String B, int m) {
        if(n <= 0 || m <= 0)
        	return 0;
        char[] charA = A.toCharArray();
        char[] charB = B.toCharArray();
        int[][] dp = new int[n][m];
        //初始化第一行
        for(int j = 0; j < m; j++) {
        	if(charB[j] == charA[0]) {
        		dp[0][j] = 1;
        		while(j < m) {
        			dp[0][j++] = 1;
        		}
        		break;
        	}else {
        		dp[0][j] = 0;
        	}
        }
        //初始化第一列
        for(int i = 0; i < n; i++) {
        	if(charA[i] == charB[0]) {
        		dp[i][0] = 1;
        		while(i < n) {
        			dp[i++][0] = 1;
        		}
        		break;
        	}else {
        		dp[i][0] = 0;
        	}
        }
        //初始化内部值，dp[i][j] = max(dp[i-1][j], dp[i][j-1], dp[i-1][j-1]+1)
        for(int i = 1; i < n; i++) {
        	for(int j = 1; j < m; j++) {
        		dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
        		if(charA[i] == charB[j]) {
        			dp[i][j] = Math.max(dp[i][j], dp[i-1][j-1]+1);
        		}
        	}
        }
        return dp[n-1][m-1];
    }
	
	public static void main(String[] args) {
		LongestCommonSubsequence test = new LongestCommonSubsequence();
		System.out.println(test.findLCS("tysoklr", 7, "slvo", 4));
	}

}
