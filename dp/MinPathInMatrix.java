package ldl.dp;

/**
 * ��һ������map����ÿ��������һ��Ȩֵ�������Ͻǵĸ��ӿ�ʼÿ��ֻ�����һ��������ߣ�
 * ��󵽴����½ǵ�λ�ã�·�������е������ۼ���������·���ͣ��������е�·������С��·���͡�
 * 1,2,3
 * 1,1,1
 * 1,0,1
 * ���� 4
 * @author darlingliu
 * ˼·��dp[i][j]��СֵΪdp[i-1][j]��dp[i][j-1]����Сֵ�ӵ�ǰֵ
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
