package sword_offer;

import java.util.ArrayList;

/**
 * ����һ�����󣬰��մ���������˳ʱ���˳�����δ�ӡ��ÿһ�����֣����磬����������¾��� 
 * 1  2  3  4 
 * 5  6  7  8 
 * 9  10 11 12 
 * 13 14 15 16 �����δ�ӡ������1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
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
    	
    	//�ж������ж��ٲ�
    	int layer = (Math.min(col,row)+1)/2;
    	for(int i = 0; i < layer; i++) {
    		for(int j = i; j < col-i; j++)
    			result.add(matrix[i][j]);//���ϵ�����
    		for(int j = i+1; j < row-i; j++)
    			result.add(matrix[j][col-1-i]);//���ϵ�����
    		for(int j = col-1-i-1; (j >= i) && (i != row-1-i); j--)
    			result.add(matrix[row-1-i][j]);//���µ�����,�ж�������i!=row-1-i��Ϊ���ж�ֻ��һ�е�����������ظ���ȡ
    		for(int j = row-1-i-1; (j >= i+1) && (i != col-1-i); j--)
    			result.add(matrix[j][i]);//���µ����ϣ����������Ϊ���ж�ֻ��һ�е����
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
