package sword_offer;

import java.util.ArrayList;

/**
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，例如，如果输入如下矩阵： 
 * 1  2  3  4 
 * 5  6  7  8 
 * 9  10 11 12 
 * 13 14 15 16 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 * @author darlingliu
 *
 */

public class Problem19 {
	
    public static ArrayList<Integer> printMatrix(int [][] matrix) {
    	if(matrix == null || matrix.length == 0 || matrix[0].length == 0)
    		return null;
    	ArrayList<Integer> result = new ArrayList<>();
    	int col = matrix[0].length;
    	int row = matrix.length;
    	
    	//判读矩阵有多少层
    	int layer = (Math.min(col,row)+1)/2;
    	for(int i = 0; i < layer; i++) {
    		for(int j = i; j < col-i; j++)
    			result.add(matrix[i][j]);//左上到右上
    		for(int j = i+1; j < row-i; j++)
    			result.add(matrix[j][col-1-i]);//右上到右下
    		for(int j = col-1-i-1; (j >= i) && (i != row-1-i); j--)
    			result.add(matrix[row-1-i][j]);//右下到左下,判断条件中i!=row-1-i是为了判断只有一行的情况，避免重复读取
    		for(int j = row-1-i-1; (j >= i+1) && (i != col-1-i); j--)
    			result.add(matrix[j][i]);//左下到左上，多的条件是为了判断只有一列的情况
    	}
    	
    	return result;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
		int[][] matrix = {{1},{2},{3},{4},{5}};
		ArrayList<Integer> list = printMatrix(matrix);
		System.out.println(list);
	}

}
