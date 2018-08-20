package ldl.swordoffer;

/**
 * 给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],
 * 其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。不能使用除法。
 * @author darlingliu
 *
 */

public class Problem51 {
	
    public int[] multiply(int[] A) {
    	int[] result = new int[A.length];
    	for(int i = 0; i < result.length; i++) {
    		result[i] = 1;
    		for(int j = 0; j < A.length; j++) {
    			if(i != j) {
    				result[i] *= A[j];
    			}
    		}
    	}
    	return result;
    }
    
//  B[i]的值可以看作下图的矩阵中每行的乘积。
//  下三角用连乘可以很容求得，上三角，从下向上也是连乘。
//  因此我们的思路就很清晰了，先算下三角中的连乘，即我们先算出B[i]中的一部分，然后倒过来按上三角中的分布规律，把另一部分也乘进去。
    public int[] multiply2(int[] A) {
    	int[] result = new int[A.length];
    	if(A.length > 0) {
    		result[0] = 1;
    		for(int i = 1; i < A.length; i++) {
    			result[i] = result[i-1] * A[i-1];
    		}
    		int tmp = 1;
    		for(int j = A.length-2; j >= 0; j--) {
    			tmp = tmp * A[j+1];
    			result[j] = result[j] * tmp;
    		}
    	}
    	return result;
    }
    

	public static void main(String[] args) {
		

	}

}
