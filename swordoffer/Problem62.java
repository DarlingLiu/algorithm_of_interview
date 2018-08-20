package ldl.swordoffer;

import java.util.Stack;

public class Problem62 {
	int count = 0;
	/**
	 * 采用中序遍历非递归实现，每遍历到一个值，记录加一，直到k，返回当前值
	 * @param pRoot
	 * @param k
	 * @return
	 */
    TreeNode KthNode(TreeNode pRoot, int k){
    	Stack<TreeNode> stack = new Stack<>();
    	while(pRoot != null || !stack.isEmpty()) {
    		while(pRoot != null) {
    			stack.push(pRoot);
    			pRoot = pRoot.left;
    		}
    		if(!stack.isEmpty()) {
    			pRoot = stack.pop();
    			System.out.println(pRoot.val);
    			count++;
    			if(count == k) {
    				return pRoot;
    			}
    			pRoot = pRoot.right;
    		}
    	}
    	return null;
    }
    
    public static void main(String[] args) {
		Problem62 test = new Problem62();
		TreeNode n1 = new TreeNode(8);
		TreeNode n2 = new TreeNode(6);
		TreeNode n3 = new TreeNode(10);
		TreeNode n4 = new TreeNode(5);
		TreeNode n5 = new TreeNode(7);
		TreeNode n6 = new TreeNode(9);
		TreeNode n7 = new TreeNode(11);
		TreeNode n8 = new TreeNode(8);
		TreeNode n9 = new TreeNode(9);
		
		n1.left = n2;
		n1.right = n3;
		n2.left = n4;
		n2.right = n5;
		n3.left = n6;
		n3.right = n7;
//		n6.left = n8;
//		n6.right = n9;
		
		TreeNode node = test.KthNode(n1, 7);
		System.out.println(node.val);
    }
}
