package ldl.swordoffer;

import java.util.HashMap;

/**
 * ��һ���ַ���(0<=�ַ�������<=10000��ȫ������ĸ���)���ҵ���һ��ֻ����һ�ε��ַ�,����������λ��,
 * ���û���򷵻� -1����Ҫ���ִ�Сд��.
 * @author darlingliu
 *
 */

public class Problem44 {
	
    public int FirstNotRepeatingChar(String str) {
    	if(str == null || str.length() == 0)
    		return -1;
    	HashMap<Character, Integer> map = new HashMap<>();
    	char[] chars = str.toCharArray();
    	for(int i = 0; i < chars.length; i++) {
    		if(!map.containsKey(chars[i])) {
    			map.put(chars[i], 1);
    		}else {
    			int val = map.get(chars[i]);
    			map.put(chars[i], ++val);
    		}
    	}
    	
    	for(int i = 0; i < chars.length; i++) {
    		if(map.get(chars[i]) == 1)
    			return i;
    	}
        return -1;
    }

	public static void main(String[] args) {
		int a = 'a';
		System.out.println(a);

	}

}
