package sword_offer;

import java.util.Stack;

/**
 * ���������������У���һ�����б�ʾջ��ѹ��˳�����жϵڶ��������Ƿ�Ϊ��ջ�ĵ���˳��
 * ����ѹ��ջ���������־�����ȡ���������1,2,3,4,5��ĳջ��ѹ��˳������4,5,3,2,1�Ǹ�ѹջ���ж�Ӧ��һ���������У�
 * ��4,3,5,1,2�Ͳ������Ǹ�ѹջ���еĵ������С���ע�⣺���������еĳ�������ȵģ�
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
        	if(pushA[i] == popA[index]) {//�����������д����while�����ظ�������ɾ��
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
