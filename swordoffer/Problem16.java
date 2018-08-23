package sword_offer;

/**
 * 输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
 * @author darlingliu
 *
 */

public class Problem16 {
	
	public ListNode Merge(ListNode list1,ListNode list2) {
		if(list1 == null)
			return list2;
		if(list2 == null)
			return list1;
		ListNode result = null;
		
		if(list1.val <= list2.val) {
			result = list1;
			result.next = Merge(list1.next, list2);
		}else {
			result = list2;
			result.next = Merge(list1, list2.next);
		}
		
		return result;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
