package sword_offer;

/**
 * ����һ�ö��������������ö���������ת����һ�������˫������
 * Ҫ���ܴ����κ��µĽ�㣬ֻ�ܵ������н��ָ���ָ��
 * @author darlingliu
 *
 */

public class Problem26 {
	TreeNode head = null;//��¼ת�����˫�������ͷ
	TreeNode pHead = null;//�����ƶ��ĵ�˫������ͷ���
    public TreeNode Convert(TreeNode pRootOfTree) {
    	ConvertNode(pRootOfTree);
    	return head;  	
    }
    
    public void ConvertNode(TreeNode pRootOfTree) {
    	if(pRootOfTree == null)
    		return;
    	
    	if(pRootOfTree.left != null)
    		Convert(pRootOfTree.left);
    	
    	if(pHead == null) {//������������ص㣬��һ�λ���ʵ����������㣬������������Ϊͷ���
    		head = pRootOfTree;
    		pHead = pRootOfTree;
    	}else {//��ͷ��㲻Ϊ��ʱ���򽫵�ǰ���ʵĽ�����ӵ�ͷ�����ƶ�ͷ���
    		pHead.right = pRootOfTree;
    		pRootOfTree.left = pHead;
    		pHead = pRootOfTree;
    	}
    	
    	if(pRootOfTree.right != null)
    		Convert(pRootOfTree.right);
    }

	public static void main(String[] args) {
		

	}

}
