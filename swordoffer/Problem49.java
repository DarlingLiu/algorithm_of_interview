package ldl.swordoffer;

public class Problem49 {
	
    public int StrToInt(String str) {
        if(str == null || str.length() == 0)
        	return 0;
        char[] chars = str.toCharArray();
        int fuhao = 0;
        int begin = 0;
        if(chars[0] == '-') {
        	fuhao = 1;
        	begin = 1;
        }
        if(chars[0] == '+')
        	begin = 1;
        int sum = 0;
        for(int i = begin; i < chars.length; i++) {
        	if(chars[i] < 48 || chars[i] > 57) {
        		return 0;
        	}
        	sum = sum*10 + (chars[i]-48);
        }
        return (fuhao == 0)? sum: sum * -1;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
