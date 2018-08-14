package ldl.swordoffer;

public class Problem31 {
	
    public int NumberOf1Between1AndN_Solution(int n) {
        int sum = 0;
        for(int i = 1; i <= n; i++) {
        	char[] chars = String.valueOf(i).toCharArray();
        	for(char c: chars) {
        		if(c == '1') {
        			sum++;
        		}
        	}
        }
        return sum;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
