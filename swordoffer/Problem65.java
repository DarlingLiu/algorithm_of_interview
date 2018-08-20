package ldl.swordoffer;

/**
 * 请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。
 * 路径可以从矩阵中的任意一个格子开始，每一步可以在矩阵中向左，向右，向上，向下移动一个格子。
 * 如果一条路径经过了矩阵中的某一个格子，则之后不能再次进入这个格子。
 * @author darlingliu
 *
 */

public class Problem65 {
	
	int index = 0;
	boolean result = false;
    public boolean hasPath(char[] matrix, int rows, int cols, char[] str){
    	
    	char[][] m = new char[rows][cols];
    	boolean[][] flag = new boolean[rows][cols];
//    	boolean[][] tmp = new boolean[rows][cols];
    	
    	for(int i = 0; i < rows; i++) {
    		for(int j = 0; j < cols; j++) {
    			m[i][j] = matrix[i*cols+j];
    			flag[i][j] = true;
//    			tmp[i][j] = true;
    		}
    	}
    	
    	for(int i = 0; i < rows; i++) {
    		for(int j = 0; j < cols; j++) {
    			if(m[i][j] == str[index]) {
    				hasPath(m, i, j, str, flag);
    				if(result == true) {
    					return result;
    				}
    				index = 0;
    				//flag = tmp.clone();
                    flag[i][j] = true;
    			}
    		}
    	}    	
    	return false;
    }
    
    public void hasPath(char[][] m, int i, int j, char[] str, boolean[][] flag) {
    	flag[i][j] = false;
    	index++;
    	if(index == str.length) {
    		result = true;
    		return;
    	}
    	if(i-1 >= 0 && flag[i-1][j] && index < str.length && str[index] == m[i-1][j]) {
    		hasPath(m, i-1, j, str, flag);
    		index--;
            flag[i-1][j] = true;
    	}
    	if(i+1 < m.length && flag[i+1][j] && index < str.length && str[index] == m[i+1][j]) {
    		hasPath(m, i+1, j, str, flag);
    		index--;
            flag[i+1][j] = true;
    	}
    	if(j-1 >= 0 && flag[i][j-1] && index < str.length && str[index] == m[i][j-1]) {
    		hasPath(m, i, j-1, str, flag);
    		index--;
            flag[i][j-1] = true;
    	}
    	if(j+1 < m[0].length && flag[i][j+1] && index < str.length && str[index] == m[i][j+1]) {
    		hasPath(m, i, j+1, str, flag);
    		index--;
            flag[i][j+1] = true;
    	}
	}
    
    public static void main(String[] args) {
		Problem65 test = new Problem65();
		char[] matrix = "ABCEHJIGAFCSLOPQADEEMNOEADIDEJFMVCEIFGGS".toCharArray();
		char[] str = "SLHECCEIDEJFGGFIE".toCharArray();
		boolean result = test.hasPath(matrix, 5, 8, str);
		System.out.println(result);
	}

}
