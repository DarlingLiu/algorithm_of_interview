package ldl.swordoffer;

import java.util.ArrayList;
import java.util.LinkedList;

public class Problem60 {
	
	ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<>();
		ArrayList<Integer> list = new ArrayList<>();
		if(pRoot == null)
			return result;
		LinkedList<TreeNode> queue = new LinkedList<>();
		TreeNode cur = pRoot;
		TreeNode last = pRoot;//当前行最后节点
		TreeNode nlast = pRoot;//下一行最右节点
		queue.add(pRoot);
		while(!queue.isEmpty()) {
			cur = queue.remove();
			list.add(cur.val);
			System.out.print(cur.val + " ");		
			if(cur.left != null) {
				queue.add(cur.left);
				nlast = cur.left;//下一行最右节点动态调整
			}
				
			if(cur.right != null) {
				queue.add(cur.right);
				nlast = cur.right;
			}
			//如果当前节点为当前行最右节点
			if(cur == last) {
				result.add(list);
				list = new ArrayList<>();
				System.out.println();
				last = nlast;
			}
				
		}
		System.out.println("-----------");
		for(ArrayList<Integer> l: result) {
			System.out.println(l);
		}
		return result;
    }

	public static void main(String[] args) {
		Problem60 test = new Problem60();
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(3);
		TreeNode n4 = new TreeNode(4);
		TreeNode n5 = new TreeNode(5);
		TreeNode n6 = new TreeNode(6);
		TreeNode n7 = new TreeNode(7);
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
		test.Print(n1);
	}
}
