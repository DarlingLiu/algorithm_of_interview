package ldl.swordoffer;

class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}

public class Problem38 {
	
    public int TreeDepth(TreeNode root) {
        int depth = 0;
        if(root != null) {
        	depth++;
        	depth += Math.max(TreeDepth(root.left), TreeDepth(root.right));
        }
        return depth;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}
