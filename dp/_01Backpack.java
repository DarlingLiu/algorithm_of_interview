package ldl.dp;

/**
 * һ��������һ���ĳ���cap����N����Ʒ��ÿ�������Լ��ļ�ֵ����¼������v�У�Ҳ�����Լ���������
 * ��¼������w�У�ÿ����Ʒֻ��ѡ��Ҫװ�뱳�����ǲ�װ�뱳����Ҫ���ڲ������������ص�ǰ���£�ѡ����Ʒ���ܼ�ֵ���
 * @author darlingliu
 *
 */

public class _01Backpack {
	
	public int maxValue(int[] w, int[] v, int n, int cap) {
        if(n <= 0 || cap <= 0) 
        	return -1;
        int[][] dp = new int[n][cap+1];
        //��ʼ����һ�У�ֻȡ��һ����Ʒʱ���õ�������ֵ��һ����Ʒֻ��ȡ���Σ�
        for(int j = 0; j < cap+1; j++) {
        	dp[0][j] = j < w[0]? 0: v[0];
        }
        
        //��ʼ����һ�У�����cap=0����������ֵ��Ϊ0
        for(int i = 0; i < n; i++) {
        	dp[i][0] = 0;
        }
        
        //��ʼ���ڲ�dp, dp[i][j] = max(dp[i-1][j], dp[i-1][j-w[i]]+v[i])
        for(int i = 1; i < n; i++) {
        	for(int j = 1; j < cap+1; j++) {
        		//���w[i] > j,��ֱ�ӵ���dp[i-1][j],����ȡ�ϴ�ֵ
        		dp[i][j] = dp[i-1][j];
        		if(w[i] <= j) {
        			dp[i][j] = Math.max(dp[i][j], dp[i-1][j-w[i]]+v[i]);
        		}
        	}
        }
        return dp[n-1][cap];
    }

}
