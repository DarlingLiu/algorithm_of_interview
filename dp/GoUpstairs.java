package ldl.dp;

/**
 * ��n��̨�ף�һ����ÿ����һ���������������ж���������n��̨�׵ķ�����Ϊ�˷�ֹ������뽫���Mod 1000000007
 * ����һ��������n���뷵��һ������������¥�ķ�ʽ������֤nС�ڵ���100000��
 * @author darlingliu
 *
 */

public class GoUpstairs {
	
	public int countWays(int n) {
        int[] ways = new int[n+1];
        ways[1] = 1;
        ways[2] = 2;
        for(int i = 3; i < ways.length; i++) {
        	ways[i] = ways[i-1] + ways[i-2];
        	if(ways[i] >= 1000000007) {
        		ways[i] %= 1000000007;
        	}
        }
        return ways[n];
    }

}
