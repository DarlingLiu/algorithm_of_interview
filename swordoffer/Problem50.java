package ldl.swordoffer;

public class Problem50 {
	
    public boolean duplicate(int numbers[],int length,int [] duplication) {
        int[] tmp = new int[length];
        for(int i = 0; i < length; i++) {
        	if(tmp[numbers[i]] != 0) {
        		duplication[0] = numbers[i];
        		return true;
        	}
        	tmp[numbers[i]] = 1;
        }
        return false;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
