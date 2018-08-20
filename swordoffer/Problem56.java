package ldl.swordoffer;

/**
 * ��һ������������У������ظ��Ľ�㣬��ɾ�����������ظ��Ľ�㣬�ظ��Ľ�㲻��������������ͷָ�롣
 *  ���磬����1->2->3->3->4->4->5 �����Ϊ 1->2->5
 * @author darlingliu
 *
 */
public class Problem56 {
	
    public ListNode deleteDuplication(ListNode pHead){
    	if(pHead == null)
    		return null;
    	ListNode pNode = new ListNode(0);
    	ListNode p = pNode;
    	while(pHead != null) {
    		
    		if(pHead.val != pHead.next.val) {
    			pNode.next = new ListNode(pHead.val);
    			pNode = pNode.next;
    			pHead = pHead.next;
    		}else {
    			while(pHead.next != null && pHead.val == pHead.next.val)
    				pHead = pHead.next;
    			pHead = pHead.next;
    		}
    	}
    	return p.next;
    	
    }
    
    public static void main(String[] args) {
		Problem56 test = new Problem56();
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(3);
		ListNode n5 = new ListNode(4);
		ListNode n6 = new ListNode(4);
		ListNode n7 = new ListNode(5);
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = n6;
		n6.next = n7;
		test.deleteDuplication(n1);
		
	}

}
