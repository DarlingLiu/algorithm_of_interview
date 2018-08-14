package ldl.swordoffer;

import java.util.HashSet;

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}

public class Problem36 {
	
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        ListNode p1 = pHead1;
        ListNode p2 = pHead2;
        while(!p1.equals(p2)) {
        	p1 = (p1 == null? pHead2: p1.next);
        	p2 = (p2 == null? pHead1: p2.next);
        }
        return p1;
    }
    
    public ListNode FindFirstCommonNode2(ListNode pHead1, ListNode pHead2) {
        ListNode p1 = pHead1;
        ListNode p2 = pHead2;
        
        HashSet<ListNode> set = new HashSet<>();
        while(p1 != null) {
        	set.add(p1);
        	p1 = p1.next;
        }
        while(p2 != null) {
        	if(set.contains(p2))
        		return p2;
        	p2 = p2.next;
        }
       
        return null;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
