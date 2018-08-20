package ldl.swordoffer;

public class Problem44 {
	
	public String ReverseSentence(String str) {
        if(str == null || str.equals(" "))
            return str;
        StringBuffer sb = new StringBuffer();
        String[] strs = str.split(" ");
        for(int i = strs.length-1; i >= 0 ; i--) {
        	sb.append(strs[i] + " ");
        }
        return sb.substring(0, sb.length()-1);
    }
    
    public static void main(String[] args) {
		Problem44 test = new Problem44();
		System.out.println(test.ReverseSentence(" "));
	}

}
