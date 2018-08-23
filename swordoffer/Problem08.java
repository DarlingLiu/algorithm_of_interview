package sword_offer;

/**
 * һֻ����һ�ο�������1��̨�ף�Ҳ��������2���������������һ��n����̨���ܹ��ж�����������
 * ˼·����n>=3ʱ��f(n)=f(n-1)+f(n-2),ͬ쳲������������
 * @author darlingliu
 *
 */

public class Problem08 {
	
	public int JumpFloor(int target) {
		
		if(target == 0)
			return 0;
		if(target == 1)
			return 1;
		if(target == 2) 
			return 2;
		int one = 1;
		int two = 2;
		int result = 0;
		for(int i = 3; i <= target; i++) {
			result = one + two;
			one = two;
			two = result;
		}
		
		return result;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
