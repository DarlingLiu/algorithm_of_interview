package ldl.dp;

/**
 * ����һ�������LIS(�������������)���⣬�����һ�������ŵĽⷨ������е�����������еĳ��ȡ�
 * ����һ������A�����ĳ���n(����С�ڵ���500)���뷵��LIS�ĳ��ȡ�
 * [1,4,2,5,3],5
 * ���� 3
 * @author darlingliu
 * ˼·��dp[i]��ʾ��iλ��Ϊ��βʱ�������������
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
