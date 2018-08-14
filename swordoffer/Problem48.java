package ldl.swordoffer;

/**
 * 写一个函数，求两个整数之和，要求在函数体内不得使用+、-、*、/四则运算符号。
 * @author darlingliu
 * 思路：位运算，分为两步，按位异或和进位（按位与并左移），然后根据进位是否为零进行循环
 */

public class Problem48 {
	
    public int Add(int num1,int num2) {
    	int sum = 0;
    	int carry = 0;
        do {
			sum = num1 ^ num2;
			carry = (num1 & num2) << 1;
			num1 = sum;
			num2 = carry;			
		} while (carry != 0);
        return sum;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
