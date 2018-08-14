package ldl.swordoffer;

/**
 * ��ֻ����������2��3��5��������������Ugly Number��������6��8���ǳ�������14���ǣ���Ϊ������������7�� 
 * ϰ�������ǰ�1�����ǵ�һ���������󰴴�С�����˳��ĵ�N��������
 * @author darlingliu
 *
 */

public class Problem43 {
	
    public int GetUglyNumber_Solution(int index) {
    	if(index <= 0)
    		return 0;
    	int[] choushu = new int[index];
    	choushu[0] = 1;
    	int id2 = 0;
    	int id3 = 0;
    	int id5 = 0;
    	int count = 1;
    	while(count < index) {
    		int tmp = Math.min(choushu[id2]*2, Math.min(choushu[id3]*3, choushu[id5]*5));
    		if(tmp == choushu[id2]*2)
    			id2++;
    		if(tmp == choushu[id3]*3)
    			id3++;
    		if(tmp == choushu[id5]*5)
    			id5++;
    		choushu[count++] = tmp;
    	}
    	return choushu[index-1];
    }

	public static void main(String[] args) {
		Problem43 test = new Problem43();
		int a = test.GetUglyNumber_Solution(7);
		System.out.println(a);

	}

}
