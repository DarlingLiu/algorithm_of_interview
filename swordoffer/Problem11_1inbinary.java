package sword_offer;

/**
 * ����һ��������������������Ʊ�ʾ��1�ĸ��������и����ò����ʾ��
 * @author darlingliu
 *
 */

public class Problem11_1inbinary {
	
	public static int NumberOf1(int n) {
	    int count = 0;
	   
	    while(n != 0) {
	    	n = n & (n-1);
	    	count++;
	    }
	    return count;
    }
	
	public static int NumberOf12(int n) {
	    int count = 0;
	    int one = 1;
	    int flag = 32;
	    while(flag > 0) {
	    	if((n & one) != 0) {
	    		count++;	    		
	    	}
	    	one = one << 1;
	    	flag--;
	    }
	    return count;
    }

	public static void main(String[] args) {

		System.out.println(NumberOf12(10));

	}

}
