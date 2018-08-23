package sword_offer;

import java.util.Stack;

/**
 * ����һ����������������е�����k����㡣
 * @author darlingliu
 *
 */

public class Problem14 {
	
	public ListNode FindKthToTail(ListNode head,int k) {
		if(k <= 0 || head == null)
			return null;
		ListNode result = null;
		Stack<ListNode> stack = new Stack<>();
		while(head != null) {
			stack.push(head);
			head = head.next;
		}
		for(int i = 1; i <= k; i++) {
			if(stack.isEmpty())
				return null;
			result = stack.pop();
		}		
		return result;
    }

	public ListNode FindKthToTail2(ListNode head,int k) {
		if(k <= 0 || head == null)
			return null;
		ListNode result = head;
		int a = 0;
		int b = 0;
		
		
		Stack<ListNode> stack = new Stack<>();
		while(head != null) {
			if(b < k)
				b++;
			head = head.next;
		}
		for(int i = 1; i <= k; i++) {
			if(stack.isEmpty())
				return null;
			result = stack.pop();
		}		
		return result;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
