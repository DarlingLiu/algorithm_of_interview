package sword_offer;

/**
 * 在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 * 
 * 自己思路：从右下角开始找，发现小于时不能删除相关区域
 * 正确思路：应从右上角或左下角开始，这样大于该位置时可以直接删除该行和该列，继续后续查找，小于则直接在该行和该列中查找
 * @author darlingliu
 *
 */

public class Problem01 {
	
	public static boolean Find(int target, int [][] array) {
		//判断二维数组是否为空
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
