package ldl.swordoffer;

public class Problem53 {
	
    public boolean isNumeric(char[] str) {
        String s = String.valueOf(str);
        return s.matches("[\\+-]?(\\d+)(\\.(\\d+))?([eE][\\+-]?\\d+)?");
    }

}
