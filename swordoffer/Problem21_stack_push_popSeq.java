package sword_offer;

import java.util.Stack;

/**
 * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序。
 * 假设压入栈的所有数字均不相等。例如序列1,2,3,4,5是某栈的压入顺序，序列4,5,3,2,1是该压栈序列对应的一个弹出序列，
 * 但4,3,5,1,2就不可能是该压栈序列的弹出序列。（注意：这两个序列的长度是相等的）
 * @author darlingliu
 *
 */

public class Problem21_stack_push_popSeq {
	
    public static boolean IsPopOrder(int [] pushA,int [] popA) {
    	Stack<Integer> stack = new Stack<>();
        if(pushA == null || pushA.length == 0)
        	return false;
        int index = 0;
        for(int i = 0; i < pushA.length; i++) {
        	stack.push(pushA[i]);
        	if(pushA[i] == popA[index]) {//从这往下三行代码和while功能重复，可以删掉
        		stack.pop();
        		index++;
        		while(!stack.isEmpty() && stack.peek() == popA[index]) {
        			stack.pop();
        			index++;
        		}      			
        	}
        }
        return index == popA.length;   	
    }

	public static void main(String[] args) {
		int[] pushA = {1,2,3,4,5};
		int[] popA = {3,4,5,2,1};
		System.out.println(IsPopOrder(pushA, popA));

	}

}
