package ldl.swordoffer;

public class Problem39 {
	
    public boolean IsBalanced_Solution(TreeNode root) {
        if(root == null)
        	return true;
        if(Math.abs(TreeDepth(root.left) - TreeDepth(root.right)) > 1) {
        	return false;
        }
        return IsBalanced_Solution(root.left) && IsBalanced_Solution(root.right);
    }
    public int TreeDepth(TreeNode root) {
        int depth = 0;
        if(root != null) {
        	depth++;
        	depth += Math.max(TreeDepth(root.left), TreeDepth(root.right));
        }
        return depth;
    }
}
