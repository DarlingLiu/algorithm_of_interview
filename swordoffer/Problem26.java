package sword_offer;

/**
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。
 * 要求不能创建任何新的结点，只能调整树中结点指针的指向。
 * @author darlingliu
 *
 */

public class Problem26 {
	TreeNode head = null;//记录转换后的双向链表表头
	TreeNode pHead = null;//用于移动的的双向链表头结点
    public TreeNode Convert(TreeNode pRootOfTree) {
    	ConvertNode(pRootOfTree);
    	return head;  	
    }
    
    public void ConvertNode(TreeNode pRootOfTree) {
    	if(pRootOfTree == null)
    		return;
    	
    	if(pRootOfTree.left != null)
    		Convert(pRootOfTree.left);
    	
    	if(pHead == null) {//根据中序遍历特点，第一次会访问到树的最左结点，将最左结点设置为头结点
    		head = pRootOfTree;
    		pHead = pRootOfTree;
    	}else {//若头结点不为空时，则将当前访问的结点链接到头结点后，移动头结点
    		pHead.right = pRootOfTree;
    		pRootOfTree.left = pHead;
    		pHead = pRootOfTree;
    	}
    	
    	if(pRootOfTree.right != null)
    		Convert(pRootOfTree.right);
    }

	public static void main(String[] args) {
		

	}

}
