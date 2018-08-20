package ldl.swordoffer;

/**
 * 把只包含质因子2、3和5的数称作丑数（Ugly Number）。例如6、8都是丑数，但14不是，因为它包含质因子7。 
 * 习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数。
 * @author darlingliu
 *
 */

public class Problem33 {
	
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
		Problem33 test = new Problem33();
		int a = test.GetUglyNumber_Solution(7);
		System.out.println(a);

	}

}
