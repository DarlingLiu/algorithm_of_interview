package sword_offer;

/**
 * �������ö�����A��B���ж�B�ǲ���A���ӽṹ����ps������Լ��������������һ�������ӽṹ��
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
	
	//�ж���root2���ڵ㿪ʼ�������ǲ���root1������
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
