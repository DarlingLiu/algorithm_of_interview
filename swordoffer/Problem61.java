package ldl.swordoffer;

/**
 * 请实现两个函数，分别用来序列化和反序列化二叉树
 * @author darlingliu
 *
 */

public class Problem61 {
	int index = -1;
    String Serialize(TreeNode root) {
        StringBuffer sb = new StringBuffer();
        appendStr(root, sb);
              
        return sb.toString();
    }
    
    void appendStr(TreeNode root, StringBuffer sb) {
    	if(root == null) {
    		sb.append("#!");
    		return;
    	}
    	sb.append(root.val + "!");
    	appendStr(root.left, sb);
    	appendStr(root.right, sb);
    }
    
    TreeNode Deserialize(String str) {
    	String[] nodes = str.split("!");
    	TreeNode root = Deserialize(nodes);  	
    	return root;
    }
    
    TreeNode Deserialize(String[] str) {
    	index++;
    	TreeNode node = null;
    	if(!str[index].equals("#")) {
    		node = new TreeNode(Integer.parseInt(str[index]));
    		node.left = Deserialize(str);
    		node.right = Deserialize(str);
    	}
    	return node;
    }

    public static void main(String[] args) {
		Problem61 test = new Problem61();
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
		n6.left = n8;
		n6.right = n9;
		String str = test.Serialize(n1);
		System.out.println(str);
		TreeNode node = test.Deserialize(str);
		System.out.println();
		
	}
}
