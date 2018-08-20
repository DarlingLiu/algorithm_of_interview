package ldl.swordoffer;

import java.util.ArrayList;

public class Problem46 {

    public int LastRemaining_Solution(int n, int m) {
    	if(m <= 0 || n <= 0)
    		return -1;
    	ArrayList<Integer> list = new ArrayList<>();
    	for(int i = 0; i < n; i++) {
    		list.add(i);
    	}
        int no = 0;       
    	while(list.size() > 1) {
    		no = (no+m-1) % list.size();
    		list.remove(no);
    	}
    	return list.get(0);
    }
    
    public static void main(String[] args) {
		Problem46 test = new Problem46();
		System.out.println(test.LastRemaining_Solution(5, 3));
	}
}
