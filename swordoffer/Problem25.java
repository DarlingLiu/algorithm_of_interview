package sword_offer;

import java.util.HashMap;

/**
 * 输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针指向任意一个节点），
 * 返回结果为复制后复杂链表的head。（注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
 * @author darlingliu
 * 讲解：https://www.cnblogs.com/AndyJee/p/4654545.html
 *
 */

class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label) {
        this.label = label;
    }
}

public class Problem25 {
	
	public static RandomListNode copy(RandomListNode pHead) {
		RandomListNode head = pHead;
		if(pHead == null)
			return null;
		HashMap<RandomListNode, RandomListNode> map = new HashMap<>();
		//复制单链表，准备两个指向头结点的指针，第一个用于结果返回，第二个用于链接next结点时向后移动
		RandomListNode pNode = new RandomListNode(pHead.label);
		map.put(pHead, pNode);
		RandomListNode p = pNode;		
		while(pHead.next != null) {
			p.next = new RandomListNode(pHead.next.label);
			map.put(pHead.next, p.next);
			p = p.next;
			pHead = pHead.next;
		}
		setRandom(head, pNode, map);
		return pNode;
	}
	
	public static void setRandom(RandomListNode head, RandomListNode pNode, HashMap<RandomListNode, RandomListNode> map) {
		while(pNode != null) {
			pNode.random = (head.random == null? null: map.get(head.random));
			pNode = pNode.next;
			head = head.next;
		}
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
