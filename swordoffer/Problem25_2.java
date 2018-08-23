package sword_offer;

import java.util.HashMap;

/**
 * ����һ����������ÿ���ڵ����нڵ�ֵ���Լ�����ָ�룬һ��ָ����һ���ڵ㣬��һ������ָ��ָ������һ���ڵ㣩��
 * ���ؽ��Ϊ���ƺ��������head����ע�⣬���������벻Ҫ���ز����еĽڵ����ã�������������ֱ�ӷ��ؿգ�
 * @author darlingliu
 * ���⣺https://www.cnblogs.com/AndyJee/p/4654545.html
 *
 */

public class Problem25_2 {
	
	public static RandomListNode copy(RandomListNode pHead) {
		if(pHead == null)
			return null;
		
		//����ÿ����㣬�����ڸý��֮��
		RandomListNode p1 = pHead;
		RandomListNode tmp;
		while(p1 != null) {
			tmp = new RandomListNode(p1.label);
			tmp.next = p1.next;
			p1.next = tmp;
			p1 = tmp.next;
		}
				
		//���ø��ƽ���randomָ��
		RandomListNode p2 = pHead;
		while(p2 != null) {
			if(p2.random != null)
				p2.next.random = p2.random.next;			
			p2 = p2.next.next;
		}
				
		//�����ƵĽ����ԭʼ�Ľ��ֿ�
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
