package ldl.swordoffer;

public class Problem55 {
	
    public ListNode EntryNodeOfLoop(ListNode pHead){
    	ListNode meetingNode = meetingNode(pHead);
        if(meetingNode == null)
        	return null;
        int circuleNodes = 1;
        ListNode m = meetingNode;
        while(m.next != meetingNode) {
        	circuleNodes++;
        	m = m.next;
        }
    	
        ListNode p1 = pHead;
        for(int i = 0; i < circuleNodes; i++)
        	p1 = p1.next;
        ListNode p2 = pHead;
        while(p1 != p2) {
        	p1 = p1.next;
        	p2 = p2.next;
        }        
    	return p1;
    }
    
    public ListNode meetingNode(ListNode pHead) {
    	if(pHead == null) {
    		return null;
    	}
    	ListNode pSlow = pHead.next;
    	if(pSlow == null)
    		return null;
    	ListNode pFast = pSlow.next;
    	while(pSlow != null && pFast != null) {
    		if(pSlow == pFast)
    			return pFast;
    		pSlow = pSlow.next;
    		pFast = pFast.next;
    		if(pFast != null)
    			pFast = pFast.next;
    	}
    	return null;
    }

}
