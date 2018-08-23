package sword_offer;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;

class A{
	
}

public class Test {
	
	public static ListNode copy(ListNode head) {
		if(head == null)
			return null;
		HashMap<ListNode, ListNode> map = new HashMap<>();
		//���Ƶ�����׼������ָ��ͷ����ָ�룬��һ�����ڽ�����أ��ڶ�����������next���ʱ����ƶ�
		ListNode pNode = new ListNode(head.val);
		map.put(head, pNode);
		ListNode p = pNode;		
		while(head.next != null) {
			p.next = new ListNode(head.next.val);
			map.put(head.next, p.next);
			p = p.next;
			head = head.next;
		}		
		return pNode;
	}
	
	
	
	public static void main(String[] args) throws IOException {
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		node1.next = node2;
		node2.next = node3;
		
		ListNode node = copy(node1);
		while(node != null) {
			System.out.println(node.val);
			node = node.next;
		}
		
		HashMap<Integer, Integer> map = new HashMap<>();
		
		
	}

}
