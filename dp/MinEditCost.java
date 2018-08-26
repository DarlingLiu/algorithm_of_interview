package ldl.dp;

/**
 * ���������ַ���A��B��������Ҫ���в��롢ɾ�����޸Ĳ�����A����ΪB����
 * ����c0��c1��c2�ֱ�Ϊ���ֲ����Ĵ��ۣ������һ����Ч�㷨�������A����ΪB������Ҫ�����ٴ��ۡ�
 * @author darlingliu
 *
 */

public class MinEditCost {
	
	public int findMinCost(String A, int n, String B, int m, int c0, int c1, int c2) {
        if(n < 0 || m < 0)
        	return -1;
        int[][] dp = new int[n+1][m+1];//A��B��ʼ������"",�ʳ���Ϊn+1
        char[] charA = A.toCharArray();
        char[] charB = B.toCharArray();
        //��ʼ����һ�У���A��("")�༭Ϊ��ӦB[0-j],ֱ�Ӳ���
        for(int j = 0; j < m+1; j++) {
        	dp[0][j] = c0 * j;
        }
        
        //��ʼ����һ������A[0-i]�༭Ϊ��ӦB��(""),ֱ��ɾ��
        for(int i = 0; i < n+1; i++) {
        	dp[i][0] = c1 * i;
        }
        
        /*
         * ��ʼ���ڲ�dp��dp[i][j]�����¼������
         * �ܳ���ȥ��dp[i][j] �� dp[i-1][j], dp[i][j-1], dp[i-1][j-1]֮��Ĺ�ϵ
         * 1 dp[i][j] = dp[i-1][j] + delete[i]
         * 2 dp[i][j] = dp[i][j-1] + insert[j]
         * 3 dp[i][j] = dp[i-1][j-1] + replace[i]->[j] (charA[i] != charB[j])
         *   �������������i���j��ֱ���滻��Ҳ����ɾ���ٲ��룬���忴���ִ���С����c2��c0+c1�Ƚ�
         * 4 dp[i][j] = dp[i-1][j-1] (charA[i] = charB[j])
         */
        for(int i = 1; i < n+1; i++) {
        	for(int j = 1; j < m+1; j++) {
        		dp[i][j] = 0;
        		dp[i][j] = Math.min(dp[i-1][j]+c1, dp[i][j-1]+c0);
        		if(charA[i-1] == charB[j-1]) {
        			dp[i][j] = Math.min(dp[i][j], dp[i-1][j-1]);
        		}else {
        			if(c2 <= c0+c1)
        				dp[i][j] = Math.min(dp[i][j], dp[i-1][j-1]+c2);
        			else
        				dp[i][j] = Math.min(dp[i][j], dp[i-1][j-1]+c0+c1);
        		}        		
        	}
        }
        return dp[n][m];
    }

}
