package sword_offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * �������´�ӡ����������ÿ���ڵ㣬ͬ��ڵ�������Ҵ�ӡ��
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
    
    //��α��������д�ӡ���������ؼ���֪����ʱ�û��С���������������last��¼��ǰ��ӡ�е����ҽڵ㣬nlast��¼������е����½ڵ�
    public static void PrintFromTopToBottom2(TreeNode root) {
    	
    	Queue<TreeNode> queue = new LinkedList<>();
    	
    	if(root == null)
    		return;
    	
    	queue.offer(root);
    	int last = root.val;//��¼��ǰ��ӡ�е����ҽڵ㣬��һ��ֻ�и��ڵ㣬���Գ�ʼ��Ϊ���ڵ㡣
    	int nlast = 0;//��¼���뵽�����е����½ڵ㣬����ǰ���ʽڵ�Ϊ���ҽڵ�lastʱ������ͬʱ�����µ�lastΪnlast,��Ϊ��ʱnlastΪ���ҽڵ�����Һ��ӣ���Ϊ��һ�е����ҽڵ㡣
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
    		
    		if(node.val == last) {//����ǰ���ʽڵ�Ϊ���ҽڵ�lastʱ
    			System.out.println();//����
    			last = nlast;//�����µ�lastΪnlast
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
