package ldl.dp;

/**
 * ������penny��penny�����е�ֵ��Ϊ�����Ҳ��ظ���ÿ��ֵ����һ����ֵ�Ļ��ң�
 * ÿ����ֵ�Ļ��ҿ���ʹ�������ţ��ٸ���һ������aim(С�ڵ���1000)����Ҫ�ҵ�Ǯ������Ǯ�ж����ַ�����
 * @author darlingliu
 * dp[i][j]��ʾ����penny[0-i]�Ļ������Ŀ��j�ķ�����
 * ��dp[i][j] = dp[i-1][j-penny[i]*k]���(k=0,1...k)
 */

public class Exchange {
	
	public int countWays(int[] penny, int n, int aim) {
        if(n <= 0 || aim < 0)
        	return -1;
        int[][] dp = new int[n][aim+1];
        //��ʼ����һ��dp[0][j]
        for(int j = 0; j < aim+1; j++) {
        	dp[0][j] = j % penny[0] == 0? 1: 0;
        }
        //��ʼ����һ��dp[i][0]
        for(int i = 0; i < n; i++) {
        	dp[i][0] = 1;
        }
        
        //��ʼ���ڲ�dp
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
