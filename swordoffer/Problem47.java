package ldl.swordoffer;

/**
 * ��1+2+3+...+n��Ҫ����ʹ�ó˳�����for��while��if��else��switch��case
 * �ȹؼ��ּ������ж���䣨A?B:C����
 * @author darlingliu
 *
 */

public class Problem47 {
	public int Sum_Solution(int n) {
        int result = n;
        boolean flag = (n > 0) && ((result += Sum_Solution(n-1)) > 0);
        return result;
    }
}
