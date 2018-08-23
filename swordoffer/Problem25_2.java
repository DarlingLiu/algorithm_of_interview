package sword_offer;

import java.util.HashMap;

/**
 * 输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针指向任意一个节点），
 * 返回结果为复制后复杂链表的head。（注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
 * @author darlingliu
 * 讲解：https://www.cnblogs.com/AndyJee/p/4654545.html
 *
 */

public class Problem25_2 {
	
	public static RandomListNode copy(RandomListNode pHead) {
		if(pHead == null)
			return null;
		
		//复制每个结点，链接在该结点之后
		RandomListNode p1 = pHead;
		RandomListNode tmp;
		while(p1 != null) {
			tmp = new RandomListNode(p1.label);
			tmp.next = p1.next;
			p1.next = tmp;
			p1 = tmp.next;
		}
				
		//设置复制结点的random指针
		RandomListNode p2 = pHead;
		while(p2 != null) {
			if(p2.random != null)
				p2.next.random = p2.random.next;			
			p2 = p2.next.next;
		}
				
		//将复制的结点与原始的结点分开
		RandomListNode cHead = pHead.next;
		RandomListNode cNode = cHead;
		pHead = cNode.next;
		while(pHead != null) {
			cNode.next = pHead.next;
			cNode = cNode.next;
			pHead = cNode.next;
		}
		
		return cHead;
	}
	
	public static void main(String[] args) {
		RandomListNode node1 = new RandomListNode(1);
		RandomListNode node2 = new RandomListNode(2);
		RandomListNode node3 = new RandomListNode(3);
		node1.next = node2;
		node2.next = node3;
		node1.random = node3;
		node2.random = node1;
		
		RandomListNode node = copy(node1);
		while(node != null) {
			System.out.println(node.label);
			node = node.next;
		}
	}

}
