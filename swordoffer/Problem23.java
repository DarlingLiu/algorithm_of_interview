package sword_offer;

import java.util.Arrays;

/**
 * ����һ���������飬�жϸ������ǲ���ĳ������������������С�ڸ��ڵ㣬���������ڸ��ڵ㣩�ĺ�������Ľ����
 * ����������Yes,�������No���������������������������ֶ�������ͬ��
 * @author darlingliu
 *
 */

public class Problem23 {
	
    public static boolean VerifySquenceOfBST(int [] sequence) {
    	if(sequence == null || sequence.length == 0)
    		return false;
    	if(sequence.length == 1)
    		return true;
    	int index = 0;
    	for(int i = 0; i < sequence.length; i++) {
    		if(sequence[i] >= sequence[sequence.length-1]) {
    			index = i;
    			break;
    		}
    	}
    	for(int j = index; j < sequence.length-1; j++) {
    		if(sequence[j] < sequence[sequence.length-1])
    			return false;
    	}
    	if(index - 0 == 0)
    		return VerifySquenceOfBST(Arrays.copyOfRange(sequence, index, sequence.length-1));
    	if(sequence.length-1-index == 0)
    		return VerifySquenceOfBST(Arrays.copyOfRange(sequence, 0, index));
    	return VerifySquenceOfBST(Arrays.copyOfRange(sequence, 0, index)) && VerifySquenceOfBST(Arrays.copyOfRange(sequence, index, sequence.length-1));
        
    }

	public static void main(String[] args) {
		int[] sequence = {4,10};
		System.out.println(VerifySquenceOfBST(sequence));

	}

}
