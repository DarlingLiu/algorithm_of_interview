package ldl.swordoffer;

public class Problem58 {
	
    boolean isSymmetrical(TreeNode pRoot){
    	
        return isSymmertircal(pRoot, pRoot);
    }
    
    boolean isSymmertircal(TreeNode pRoot1, TreeNode pRoot2) {
    	if(pRoot1 == null && pRoot2 == null)
    		return true;
    	if(pRoot1 == null || pRoot2 == null)
    		return false;
    	if(pRoot1.val != pRoot2.val)
    		return false;
    	return isSymmertircal(pRoot1.left, pRoot2.right) && isSymmertircal(pRoot1.right, pRoot2.left);
    }
    
}
