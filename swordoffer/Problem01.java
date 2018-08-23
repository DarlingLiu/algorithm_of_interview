package sword_offer;

/**
 * ��һ����ά�����У�ÿһ�ж����մ����ҵ�����˳������ÿһ�ж����մ��ϵ��µ�����˳������
 * �����һ������������������һ����ά�����һ���������ж��������Ƿ��и�������
 * 
 * �Լ�˼·�������½ǿ�ʼ�ң�����С��ʱ����ɾ���������
 * ��ȷ˼·��Ӧ�����Ͻǻ����½ǿ�ʼ���������ڸ�λ��ʱ����ֱ��ɾ�����к͸��У������������ң�С����ֱ���ڸ��к͸����в���
 * @author darlingliu
 *
 */

public class Problem01 {
	
	public static boolean Find(int target, int [][] array) {
		//�ж϶�ά�����Ƿ�Ϊ��
		if(array == null || array.length == 0 || (array.length == 1 && array[0].length == 0))
			return false;
		
		int row = array.length;
		int colum = array[0].length;
		
		if(target < array[0][0] || target > array[row-1][colum-1])
			return false;
		
		for(int i = 0; i < colum; i++) {
			if(target <= array[row-1][i]) {
				for(int j = row-1; j >= 0; j--) {
					if(array[j][i] == target)
						return true;
				}
			}		
		}
		return false;
    }
	
	public static void main(String[] args) {
		
		int[][] array = {{1,2,8,9},{2,4,9,12},{4,7,10,13},{6,8,11,15}};
		
		
		boolean find = Find(9, array);
		System.out.println(find);
	}

}
