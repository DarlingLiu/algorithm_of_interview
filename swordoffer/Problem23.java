package sword_offer;

import java.util.Arrays;

/**
 * 输入一个整数数组，判断该数组是不是某二叉搜索树（左子树小于根节点，右子树大于根节点）的后序遍历的结果。
 * 如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
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
