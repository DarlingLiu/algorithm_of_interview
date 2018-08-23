package sword_offer;

/**
 * 输入一个链表，从尾到头打印链表每个节点的值。
 */

import java.util.ArrayList;
import java.util.Stack;

class ListNode{
	int val;
	ListNode next = null;
	public ListNode(int val) {
		this.val = val;
	}
}

public class Problem03 {
	public static ArrayList<Integer> list = new ArrayList<Integer>();
	
	//利用递归输出
	public static ArrayList<Integer> printListFromTailToHead(ListNode listNode) {       
        if(listNode != null){
            if(listNode.next != null){
                printListFromTailToHead(listNode.next);
            }
            list.add(listNode.val);
            System.out.println(listNode.val);
        }
        return list;
    }
	
	//利用栈进行输出
	public static ArrayList<Integer> printListFromTailToHead2(ListNode listNode) {
		Stack<Integer> stack = new Stack<>();
        if(listNode != null){
        	stack.push(listNode.val);
            while(listNode.next != null){
            	listNode = listNode.next;
            	stack.push(listNode.val);
            }
            while(!stack.isEmpty())
            	list.add(stack.pop());
        }
        return list;
    }

	public static void main(String[] args) {
		ListNode node1 = new ListNode(58);
		ListNode node2 = new ListNode(24);
		ListNode node3 = new ListNode(0);
		ListNode node4 = new ListNode(67);
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		
		//printListFromTailToHead(node1);
		System.out.println(printListFromTailToHead(node1));
		
		
	}

}
