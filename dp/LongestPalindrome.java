package ldl.dp;

/**
 * 动态规划，求一个字符串的最长回文子串长度
 * @author darlingliu
 * dp[i][j]表示以i开始，以j结尾的字符串是否为回文字符串
 */

public class LongestPalindrome {
	
	public int getLongestPalindromeLen(String str) {
		if(str == null || str.length() == 0)
			return 0;
		
		//初始化边界值，dp[i][i] = 1, dp[i][i+1] = str[i] == str[i+1]? 1: 0;
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
		 * 边界值已判断出长度为1和2的情况，初始化内部，以长度向外递增，初始化为3
		 * 1.若str[i] != str[j] 则dp[i][j]不是回文子串
		 * 2.若str[i] == str[j] 则dp[i][j] = dp[i+1][j-1]
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
