package sword_offer;

import java.util.HashMap;

/**
 * ����һ����������ÿ���ڵ����нڵ�ֵ���Լ�����ָ�룬һ��ָ����һ���ڵ㣬��һ������ָ��ָ������һ���ڵ㣩��
 * ���ؽ��Ϊ���ƺ��������head����ע�⣬���������벻Ҫ���ز����еĽڵ����ã�������������ֱ�ӷ��ؿգ�
 * @author darlingliu
 * ���⣺https://www.cnblogs.com/AndyJee/p/4654545.html
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
		//���Ƶ�����׼������ָ��ͷ����ָ�룬��һ�����ڽ�����أ��ڶ�����������next���ʱ����ƶ�
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
