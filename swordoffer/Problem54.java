package ldl.swordoffer;

public class Problem54 {
	int[] chars = new int[256];
	int count = 1;
    //Insert one char from stringstream
    public void Insert(char ch)
    {
        if(chars[ch] == 0) {
        	chars[ch] = count++;
        }else {
        	chars[ch] = -1;
        }
    }
  //return the first appearence once char in current stringstream
    public char FirstAppearingOnce()
    {
    	int max = Integer.MAX_VALUE;
    	char ch = '#';
    	for(int i = 0; i < chars.length; i++) {
    		if(chars[i] != 0 && chars[i] != -1 && chars[i] < max) {
    			max = chars[i];
    			ch = (char) i;
    		}
    	}
    	return ch;
    }

}
