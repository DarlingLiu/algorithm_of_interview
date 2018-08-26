package ldl.dp;

/**
 * 对于一个字符串,请设计一个高效算法，找到字符串的最长无重复字符的子串长度。
 * 如"aabcb", 返回3
 * @author darlingliu
 * dp[i]表示以i位置字符结尾时的最长不重复子串长度
 */

public class LongestNorepeatSubstring {
	
	public static int longestSubstring(String A, int n) {
        if(n <= 0)
        	return 0;
        int[] dp = new int[n];
        char[] charA = A.toCharArray();
        dp[0] = 1;
        for(int i = 1; i < n; i++) {
        	int j = i-1;
        	//往左遍历，找到和当前位置相等的第一个元素位置，没有则j=-1
        	for(; j >= 0; j--) {
        		if(charA[i] == charA[j])
        			break;
        	}
        	//判断j和以i-1为结尾最长无重复子串的位置，设置dp[i]的值
        	if(j <= i-dp[i-1]-1) {
        		dp[i] = dp[i-1]+1;
        	}else {
        		dp[i] = i-j;
        	}
        }
        int result = 0;
        for(int i = 0; i < n; i++) {
        	result = Math.max(result, dp[i]);
        }
        return result;
    }
	
	public static void main(String[] args) {
		System.out.println(longestSubstring("abbb", 4));
	}
}
