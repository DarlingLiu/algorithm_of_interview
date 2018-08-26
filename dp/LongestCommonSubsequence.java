package ldl.dp;

/**
 * ���������ַ���A��B�����������ַ���������������еĳ��ȡ�
 * ���磬A="1A2C3D4B56����B="B1D23CA45B6A������123456"����"12C4B6"��������������С�
 * ���������ַ���A��B��ͬʱ�����������ĳ���n��m���뷵������������еĳ��ȡ���֤�������Ⱦ�С�ڵ���300��
 * @author darlingliu
 * ˼·��dp[i][j]��ʾstr1[0-i]��str2[0-j]��������Ӵ�
 */

public class LongestCommonSubsequence {
	
	public int findLCS(String A, int n, String B, int m) {
        if(n <= 0 || m <= 0)
        	return 0;
        char[] charA = A.toCharArray();
        char[] charB = B.toCharArray();
        int[][] dp = new int[n][m];
        //��ʼ����һ��
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
        //��ʼ����һ��
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
        //��ʼ���ڲ�ֵ��dp[i][j] = max(dp[i-1][j], dp[i][j-1], dp[i-1][j-1]+1)
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
