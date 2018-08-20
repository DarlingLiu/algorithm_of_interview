package ldl.swordoffer;

public class Problem66_2 {
	
	int count = 0;
	int result = 0;
    public int movingCount(int threshold, int rows, int cols){
    	if(threshold < 0)
    		return 0;
        int[][] matrix = new int[rows][cols];
        
        maxCount(matrix, 0, 0, threshold);
        
        return result;
    }
    
    public void maxCount(int[][] m, int i, int j, int k) {
    	m[i][j] = 1;
    	count++;
    	if(count > result) {
    		result = count;
    	}
    	if(i-1 >= 0 && m[i-1][j] == 0 && sumij(i-1, j) <= k) {
    		maxCount(m, i-1, j, k);
    	}
    	if(i+1 < m.length && m[i+1][j] == 0 && sumij(i+1, j) <= k) {
    		maxCount(m, i+1, j, k);
    	}
    	if(j-1 >= 0 && m[i][j-1] == 0 && sumij(i, j-1) <= k) {
    		maxCount(m, i, j-1, k);
    	}
    	if(j+1 < m[0].length && m[i][j+1] == 0 && sumij(i, j+1) <= k) {
    		maxCount(m, i, j+1, k);
    	}
    }
    
    public int sumij(int i, int j) {
    	int sum = 0;
    	while(i != 0) {
    		sum = sum + i % 10;
    		i = i / 10;
    	}
    	while(j != 0) {
    		sum = sum + j % 10;
    		j = j / 10;
    	}
    	return sum;
    }
    
    public static void main(String[] args) {
		Problem66_2 test = new Problem66_2();
		System.out.println(test.movingCount(5, 4, 4));
	}

}
