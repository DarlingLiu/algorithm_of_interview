package sword_offer;

import java.util.Stack;

/**
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈最小元素的min函数。
 * @author darlingliu
 *
 */

public class Problem20 {
	
	Stack<Integer> stack = new Stack<>();
	Stack<Integer> assit = new Stack<>();
	
	
	public void push(int node) {
        if(stack.isEmpty()) {
        	stack.push(node);
        	assit.push(node);
        }else {
        	assit.push(Math.min(top(), node));
        	stack.push(node);
        }
    }
    
    public void pop() {
        stack.pop();
        assit.pop();
    }
    
    public int top() {
    	return stack.peek();
    }
    
    public int min() {      
    	return assit.peek();
    }

	public static void main(String[] args) {
		Problem20 test = new Problem20();

	}

}
