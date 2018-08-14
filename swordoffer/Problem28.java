package ldl.swordoffer;

/**
 * ��������һ�����ֳ��ֵĴ����������鳤�ȵ�һ�룬���ҳ�������֡�
 * ��������һ������Ϊ9������{1,2,3,2,2,2,5,4,2}����������2�������г�����5�Σ��������鳤�ȵ�һ�룬������2��
 * ��������������0��
 * @author darlingliu
 * ˼·����ָoffer p208
 */

public class Problem28 {
	
	public static int MoreThanHalfNum_Solution(int [] array) {
        if(array == null || array.length == 0)
        	return 0;
        int times = 1;
        int target = array[0];
        for(int i = 1; i < array.length; i++) {
        	if(times == 0) {
        		target = array[i];
        		times = 1;
        	}else if(array[i] == target) {
        		times++;	
        	}else {
				times--;
			}
        }
        
        int num = 0;
        for(int i = 0; i < array.length; i++) {
        	if(target == array[i])
        		num++;
        }
        return num > array.length/2? target: 0;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
