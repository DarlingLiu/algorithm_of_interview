package ldl.swordoffer;

public class Problem40 {
	
    public void FindNumsAppearOnce(int[] array, int num1[] , int num2[]) {
        int xor = 0;
        int flag = 1;
        for(int a: array) {
        	xor = xor ^ a;
        }
        while((xor & flag) == 0)
        	flag = flag << 1;
        for(int a: array) {
        	if((a & flag) == 0)
        		num1[0] = num1[0] ^ a;
        	else
        		num2[0] = num2[0] ^ a;
        }
    }

}
