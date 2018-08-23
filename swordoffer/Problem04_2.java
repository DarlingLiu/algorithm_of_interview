package sword_offer;

import java.util.Arrays;

/**
 * ����ĳ��������ǰ���������������Ľ�������ؽ����ö����������������ǰ���������������Ľ���ж������ظ������֡�
 * ��������ǰ���������{1,2,4,7,3,5,6,8}�������������{4,7,2,1,5,3,8,6}�����ؽ������������ء�
 * @author darlingliu
 * 
 * ˼·��˼�벻�䣬��������������������У��ݹ�Ĺ��������������õ���java Arrays API�������鲿�֣������Լ��������飬��д����
 */

public class Problem04_2 {
	
	public static TreeNode reConstructBinaryTree(int [] pre,int [] in) {
		if(pre == null || in == null || pre.length <= 0 || in.length <=0) {
			return null;
		}
		TreeNode root = new TreeNode(pre[0]);
		
		for(int i = 0; i < in.length; i++) {
			if(in[i] == pre[0]) {
				root.left = reConstructBinaryTree(Arrays.copyOfRange(pre, 1, i+1), Arrays.copyOfRange(in, 0, i));
				root.right = reConstructBinaryTree(Arrays.copyOfRange(pre, i+1, pre.length), Arrays.copyOfRange(in, i+1, in.length));
			}
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
