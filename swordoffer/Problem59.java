package ldl.swordoffer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;



public class Problem59 {
	
	/**
	 * ��ʵ��һ����������֮���δ�ӡ������������һ�а��մ����ҵ�˳���ӡ��
	 * �ڶ��㰴�մ��������˳���ӡ�������а��մ����ҵ�˳���ӡ���������Դ����ơ�
	 */
	public ArrayList<ArrayList<Integer>> PrintZhi(TreeNode pRoot) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<>();
		if(pRoot == null)
			return result;
		Stack<TreeNode> s1 = new Stack<>();
		Stack<TreeNode> s2 = new Stack<>();
		s1.push(pRoot);
		ArrayList<Integer> list;
		while(!s1.isEmpty() || !s2.isEmpty()) {
			list = new ArrayList<>();
			while(!s1.isEmpty()) {
				TreeNode cur = s1.pop();
				list.add(cur.val);
				System.out.print(cur.val + " ");
				if(cur.left != null) {
					s2.push(cur.left);
				}
				if(cur.right != null) {
					s2.push(cur.right);
				}
			}
			result.add(list);
			list = new ArrayList<>();
			System.out.println();
			while(!s2.isEmpty()){				
				TreeNode cur = s2.pop();
				list.add(cur.val);
				System.out.print(cur.val + " ");				
				if(cur.right != null) {
					s1.push(cur.right);
				}
				if(cur.left != null) {
					s1.push(cur.left);
				}
			}
			if(!list.isEmpty()) {
				result.add(list);
				System.out.println();
			}					
		}
		System.out.println("-----------");
		for(ArrayList<Integer> l: result) {
			System.out.println(l);
		}
		return result;
		
    }
	
	//����δ�ӡ�����в�����к�
	public void Print1(TreeNode pRoot) {
		if(pRoot == null)
			return;
		LinkedList<TreeNode> queue = new LinkedList<>();
		TreeNode cur = pRoot;
		TreeNode last = pRoot;//��ǰ�����ڵ�
		TreeNode nlast = pRoot;//��һ�����ҽڵ�
		queue.add(pRoot);
		while(!queue.isEmpty()) {
			cur = queue.remove();			
			System.out.print(cur.val + " ");		
			if(cur.left != null) {
				queue.add(cur.left);
				nlast = cur.left;//��һ�����ҽڵ㶯̬����
			}
				
			if(cur.right != null) {
				queue.add(cur.right);
				nlast = cur.right;
			}
			//�����ǰ�ڵ�Ϊ��ǰ�����ҽڵ�
			if(cur == last) {
				System.out.println();
				last = nlast;
			}
				
		}
    }
	
	//����δ�ӡ��������
	public void Print2(TreeNode pRoot) {
		if(pRoot == null)
			return;
		LinkedList<TreeNode> queue = new LinkedList<>();
		queue.add(pRoot);
		while(!queue.isEmpty()) {
			TreeNode node = queue.remove();
			System.out.print(node.val + " ");
			if(node.left != null)
				queue.add(node.left);
			if(node.right != null)
				queue.add(node.right);
		}
    }
	
	public static void main(String[] args) {
		Problem59 test = new Problem59();
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
		test.PrintZhi(n1);
	}
}
