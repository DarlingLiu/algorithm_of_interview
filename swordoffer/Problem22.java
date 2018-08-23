package sword_offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 从上往下打印出二叉树的每个节点，同层节点从左至右打印。
 * @author darlingliu
 *
 */

public class Problem22 {
	
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
    	ArrayList<Integer> result = new ArrayList<>();
    	Queue<TreeNode> queue = new LinkedList<>();
    	
    	if(root == null)
    		return result;
    	queue.offer(root);
    	while(!queue.isEmpty()) {
    		TreeNode node = queue.poll();
    		result.add(node.val);
    		if(node.left != null) queue.offer(node.left);
    		if(node.right != null) queue.offer(node.right);
    	}
        return result;
    }
    
    //层次遍历，按行打印二叉树，关键是知道何时该换行。引入两个变量，last记录当前打印行的最右节点，nlast记录存入队列的最新节点
    public static void PrintFromTopToBottom2(TreeNode root) {
    	
    	Queue<TreeNode> queue = new LinkedList<>();
    	
    	if(root == null)
    		return;
    	
    	queue.offer(root);
    	int last = root.val;//记录当前打印行的最右节点，第一行只有根节点，所以初始化为根节点。
    	int nlast = 0;//记录存入到队列中的最新节点，当当前访问节点为最右节点last时，换行同时更新新的last为nlast,因为此时nlast为最右节点的最右孩子，即为下一行的最右节点。
    	while(!queue.isEmpty()) {
    		TreeNode node = queue.poll();
    		System.out.print(node.val+" ");
    		if(node.left != null) {
    			queue.offer(node.left);
    			nlast = node.left.val;
    		}
    		if(node.right != null) {
    			queue.offer(node.right);
    			nlast = node.right.val;
    		}
    		
    		if(node.val == last) {//当当前访问节点为最右节点last时
    			System.out.println();//换行
    			last = nlast;//更新新的last为nlast
    		}   			
    	}
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode node1 = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(3);
		TreeNode node4 = new TreeNode(6);
		node1.left = node2;
		node1.right =node3;
		node3.left = node4;
		
		PrintFromTopToBottom2(node1);

	}

}
