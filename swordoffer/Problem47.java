package ldl.swordoffer;

/**
 * 求1+2+3+...+n，要求不能使用乘除法、for、while、if、else、switch、case
 * 等关键字及条件判断语句（A?B:C）。
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
