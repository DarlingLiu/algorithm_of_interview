package sword_offer;

/**
 * ���������Ķ�����������任ΪԴ�������ľ���
 * @author darlingliu
 *
 */

public class Problem18 {
	
    public void Mirror(TreeNode root) {
        if(root == null)
        	return;
        if(root.left == null && root.right == null)
        	return;
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        Mirror(root.left);
        Mirror(root.right);
        
    }

	public static void main(String[] args) {
		

	}

}
