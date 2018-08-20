package ldl.swordoffer;

/**
 * �����������һ����λָ�����ѭ�����ƣ�ROL���������и��򵥵����񣬾������ַ���ģ�����ָ�����������
 * ����һ���������ַ�����S���������ѭ������Kλ������������
 * ���磬�ַ�����S=��abcXYZdef��,Ҫ�����ѭ������3λ��Ľ��������XYZdefabc�����ǲ��Ǻܼ򵥣�OK���㶨����
 * @author darlingliu
 *
 */

public class Problem43 {
	
    public String LeftRotateString(String str, int n) {
    	if(str == null || str.equals(""))
    		return str;
        int move = n % str.length();
        if(move == 0)
        	return str;
        return str.substring(move, str.length()) + str.substring(0, move);
    }

}
