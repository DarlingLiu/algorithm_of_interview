package ldl.swordoffer;

/**
 * дһ������������������֮�ͣ�Ҫ���ں������ڲ���ʹ��+��-��*��/����������š�
 * @author darlingliu
 * ˼·��λ���㣬��Ϊ��������λ���ͽ�λ����λ�벢���ƣ���Ȼ����ݽ�λ�Ƿ�Ϊ�����ѭ��
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
