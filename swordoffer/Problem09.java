package sword_offer;

/**
 * һֻ����һ�ο�������1��̨�ף�Ҳ��������2��������Ҳ��������n���������������һ��n����̨���ܹ��ж�����������
 * @author darlingliu
 *
 */

public class Problem09 {
	
	public int JumpFloorII(int target) {
        if(target <= 0)
        	return 0;
        if(target == 1)
        	return 1;
        int[] result = new int[target+1];
        result[0] = 0;
        result[1] = 1;
        for(int i = 2; i <= target; i++) {
        	for(int j = i - 1; j > 0; j--) {
        		result[i] = result[i] + result[j];
        	}
        	result[i] = result[i] + 1;
        }		
		return result[target];
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
