package sword_offer;

/**
 * ����ĳ��������ǰ���������������Ľ�������ؽ����ö����������������ǰ���������������Ľ���ж������ظ������֡�
 * ��������ǰ���������{1,2,4,7,3,5,6,8}�������������{4,7,2,1,5,3,8,6}�����ؽ������������ء�
 * @author darlingliu
 * 
 * ˼·����������������������У��ݹ�Ĺ�����������
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
		
		//ǰ������ĵ�һ��Ԫ�ؼ�Ϊ���ڵ㣬�ҳ���ǰ���ڵ������������λ��
		int root_index_in = 0;
		for(int i = 0; i < in.length; i++) {
			if(in[i] == pre[0]) {
				root_index_in = i;
				break;
			}				
		}
		
		//���ݸ��ڵ�λ�ã�ɾѡ����������ǰ�������������У��ݹ鹹������ifΪ�ݹ��ж���ֹ����
		if(root_index_in > 0) {
			int[] pre_left = new int[root_index_in];
			int[] in_left = new int[root_index_in];
			for(int i = 0; i < root_index_in; i++) {
				pre_left[i] = pre[i+1];
				in_left[i] = in[i];
			}
			root.left = reConstructBinaryTree(pre_left, in_left);
		}
		
		//���ݸ��ڵ�λ�ã�ɾѡ����������ǰ�������������У��ݹ鹹������ifΪ�ݹ��ж���ֹ����
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
