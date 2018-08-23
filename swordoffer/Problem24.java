package sword_offer;

import java.util.ArrayList;

/**
 * 输入一颗二叉树和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
 * 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
 * @author darlingliu
 *
 */

public class Problem24 {
	
    public static ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {
    	ArrayList<ArrayList<Integer>> result = new ArrayList<>();
    	if(root == null)
    		return result;
    	int cur_sum = 0;
    	ArrayList<Integer> list = new ArrayList<>();  	
    	FindPath(root, target, cur_sum, result, list); 
    	return result;
    }
    
    public static void FindPath(TreeNode root, int target, int cur_sum, ArrayList<ArrayList<Integer>> result, ArrayList<Integer> list){   	
    	cur_sum += root.val;
    	list.add(root.val);
    	if(cur_sum == target && (root.left == null && root.right == null)) 
    		result.add(new ArrayList<Integer>(list)); 		
    	if(root.left != null)
    		FindPath(root.left, target, cur_sum, result, list);
    	if(root.right != null)
    		FindPath(root.right, target, cur_sum, result, list);
    	list.remove(list.size()-1);
    }

	public static void main(String[] args) {
		TreeNode root = new TreeNode(8);
		TreeNode node2 = new TreeNode(3);
		TreeNode node3 = new TreeNode(4);
		TreeNode node4 = new TreeNode(1);
		TreeNode node5 = new TreeNode(2);
		root.left = node2;
		root.right = node3;
		node2.left = node4;
		node2.right = node5;
		ArrayList<ArrayList<Integer>> result = new ArrayList<>();
		result = FindPath(root, 12);
		for(ArrayList<Integer> list: result) {
			System.out.println(list);
		}

	}

}
