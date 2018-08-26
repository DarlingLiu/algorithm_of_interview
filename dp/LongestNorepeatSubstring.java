package ldl.dp;

/**
 * ����һ���ַ���,�����һ����Ч�㷨���ҵ��ַ���������ظ��ַ����Ӵ����ȡ�
 * ��"aabcb", ����3
 * @author darlingliu
 * dp[i]��ʾ��iλ���ַ���βʱ������ظ��Ӵ�����
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
        	//����������ҵ��͵�ǰλ����ȵĵ�һ��Ԫ��λ�ã�û����j=-1
        	for(; j >= 0; j--) {
        		if(charA[i] == charA[j])
        			break;
        	}
        	//�ж�j����i-1Ϊ��β����ظ��Ӵ���λ�ã�����dp[i]��ֵ
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
