package ldl.dp;

/**
 * ��̬�滮����һ���ַ�����������Ӵ�����
 * @author darlingliu
 * dp[i][j]��ʾ��i��ʼ����j��β���ַ����Ƿ�Ϊ�����ַ���
 */

public class LongestPalindrome {
	
	public int getLongestPalindromeLen(String str) {
		if(str == null || str.length() == 0)
			return 0;
		
		//��ʼ���߽�ֵ��dp[i][i] = 1, dp[i][i+1] = str[i] == str[i+1]? 1: 0;
		int result = 1;
		int[][] dp = new int[str.length()][str.length()];
		for(int i = 0; i < str.length(); i++) {
			dp[i][i] = 1;
			if(i+1 < str.length()) {
				if(str.charAt(i) == str.charAt(i+1)) {
					dp[i][i+1] = 1;
					result = 2;
				}
			}
		}
				
		/**
		 * �߽�ֵ���жϳ�����Ϊ1��2���������ʼ���ڲ����Գ��������������ʼ��Ϊ3
		 * 1.��str[i] != str[j] ��dp[i][j]���ǻ����Ӵ�
		 * 2.��str[i] == str[j] ��dp[i][j] = dp[i+1][j-1]
		 */
		for(int L = 3; L <= str.length(); L++) {
			for(int i = 0; i+L-1 < str.length(); i++) {
				int j = i+L-1;
				if(str.charAt(i) == str.charAt(j) && dp[i+1][j-1] == 1) {
					dp[i][j] = 1;
					result = L;
				}
			}
		}
		
		return result;
	}

	public static void main(String[] args) {
		LongestPalindrome test = new LongestPalindrome();
		System.out.println(test.getLongestPalindromeLen("aerefggferadeedaffw"));
	}
}
