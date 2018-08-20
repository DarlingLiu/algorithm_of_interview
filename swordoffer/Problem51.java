package ldl.swordoffer;

/**
 * ����һ������A[0,1,...,n-1],�빹��һ������B[0,1,...,n-1],
 * ����B�е�Ԫ��B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]������ʹ�ó�����
 * @author darlingliu
 *
 */

public class Problem51 {
	
    public int[] multiply(int[] A) {
    	int[] result = new int[A.length];
    	for(int i = 0; i < result.length; i++) {
    		result[i] = 1;
    		for(int j = 0; j < A.length; j++) {
    			if(i != j) {
    				result[i] *= A[j];
    			}
    		}
    	}
    	return result;
    }
    
//  B[i]��ֵ���Կ�����ͼ�ľ�����ÿ�еĳ˻���
//  �����������˿��Ժ�����ã������ǣ���������Ҳ�����ˡ�
//  ������ǵ�˼·�ͺ������ˣ������������е����ˣ������������B[i]�е�һ���֣�Ȼ�󵹹������������еķֲ����ɣ�����һ����Ҳ�˽�ȥ��
    public int[] multiply2(int[] A) {
    	int[] result = new int[A.length];
    	if(A.length > 0) {
    		result[0] = 1;
    		for(int i = 1; i < A.length; i++) {
    			result[i] = result[i-1] * A[i-1];
    		}
    		int tmp = 1;
    		for(int j = A.length-2; j >= 0; j--) {
    			tmp = tmp * A[j+1];
    			result[j] = result[j] * tmp;
    		}
    	}
    	return result;
    }
    

	public static void main(String[] args) {
		

	}

}
