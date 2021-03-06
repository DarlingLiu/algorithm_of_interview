package sword_offer;

/**
 * 输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
 * @author darlingliu
 *
 */

public class Problem17 {
	
	public boolean HasSubtree(TreeNode root1,TreeNode root2) {
        if(root1 == null || root2 == null)
        	return false;
        if(isSubtree(root1, root2))
        	return true;
        return HasSubtree(root1.left, root2) || HasSubtree(root1.right, root2);       
    }
	
	//判断以root2根节点开始的树，是不是root1的子树
	public boolean isSubtree(TreeNode root1, TreeNode root2) {
		if(root2 == null)
			return true;
		if(root1 == null)
			return false;
		if(root1.val == root2.val) {
			return isSubtree(root1.left, root2.left) && isSubtree(root1.right, root2.right);			
		}else {
			return false;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
