package ldl.swordoffer;

import java.util.HashMap;

/**
 * 在一个字符串(0<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,并返回它的位置,
 * 如果没有则返回 -1（需要区分大小写）.
 * @author darlingliu
 *
 */

public class Problem34 {
	
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
