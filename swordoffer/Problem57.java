package ldl.swordoffer;

class TreeLinkNode {
    int val;
    TreeLinkNode left = null;
    TreeLinkNode right = null;
    TreeLinkNode next = null;

    TreeLinkNode(int val) {
        this.val = val;
    }
}

public class Problem57 {
    public TreeLinkNode GetNext(TreeLinkNode pNode){
        if(pNode == null)
        	return pNode;
        if(pNode.right != null) {
        	pNode = pNode.right;
        	while(pNode.left != null) {
        		pNode = pNode.left;
        	}
        	return pNode;
        }
        while(pNode.next != null) {
        	if(pNode.next.left == pNode)
        		return pNode.next;
        	pNode = pNode.next;
        }
        return null;
    }
}
