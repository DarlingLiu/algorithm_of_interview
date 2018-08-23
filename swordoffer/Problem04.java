package sword_offer;

/**
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
 * @author darlingliu
 * 
 * 思路：求出代表左右子树的序列，递归的构建左右子树
 */

class TreeNode{
	int val;
	TreeNode left;
	TreeNode right;
	public TreeNode(int val) {
		this.val = val;
	}
}

public class Problem04 {
	
	public static TreeNode reConstructBinaryTree(int [] pre,int [] in) {
		if(pre == null || in == null || pre.length < 0) {
			return null;
		}
		TreeNode root = new TreeNode(pre[0]);
		
		//前序遍历的第一个元素即为根节点，找出当前根节点在中序遍历中位置
		int root_index_in = 0;
		for(int i = 0; i < in.length; i++) {
			if(in[i] == pre[0]) {
				root_index_in = i;
				break;
			}				
		}
		
		//根据根节点位置，删选出左子树的前序和中序遍历序列，递归构建树，if为递归判断终止条件
		if(root_index_in > 0) {
			int[] pre_left = new int[root_index_in];
			int[] in_left = new int[root_index_in];
			for(int i = 0; i < root_index_in; i++) {
				pre_left[i] = pre[i+1];
				in_left[i] = in[i];
			}
			root.left = reConstructBinaryTree(pre_left, in_left);
		}
		
		//根据根节点位置，删选出左子树的前序和中序遍历序列，递归构建树，if为递归判断终止条件
		if(root_index_in < in.length - 1) {
			int r_length = in.length-1-root_index_in;
			int[] pre_right = new int[r_length];
			int[] in_right = new int[r_length];
			for(int j = 0; j < r_length; j++) {
				pre_right[j] = pre[j+root_index_in+1];
				in_right[j] = in[j+root_index_in+1];
			}
			root.right = reConstructBinaryTree(pre_right, in_right);
		}
		System.out.println(root.val);
		return root;
	}

	public static void main(String[] args) {
		int[] pre = new int[] {1,2,4,7,3,5,6,8};
		int[] in = new int[] {4,7,2,1,5,3,8,6};
		
//		int[] pre = new int[] {1,2,3,4,5,6,7};
//		int[] in = new int[] {3,2,4,1,6,5,7};
		
		TreeNode tree = reConstructBinaryTree(pre, in);

	}

}
