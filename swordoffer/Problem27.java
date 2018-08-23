package sword_offer;

import java.util.ArrayList;
import java.util.Collections;

/**
 * 输入一个字符串,按字典序打印出该字符串中字符的所有排列。
 * 例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
 * @author darlingliu
 *
 */

public class Problem27 {
	
    public ArrayList<String> Permutation(String str) {
    	ArrayList<String> result = new ArrayList<>();
    	if(str == null || str.length() == 0)
    		return result;
    	
        char[] chars = str.toCharArray();

        Permutation(chars, 0, result);
        Collections.sort(result);//按字典顺序对list进行排序
        return result;        
    }
    
    public void Permutation(char[] chars, int begin, ArrayList<String> result) {
    	
    	if(begin == chars.length - 1 && !result.contains(String.valueOf(chars))) {  		 
    		result.add(String.valueOf(chars));
    		return;
    	}
    	
    	for(int i = begin; i < chars.length; i++) {
    		swap(chars, begin, i);
    		Permutation(chars, begin+1, result);
    		swap(chars, begin, i);
    	}
    }
    
    public void swap(char[] chars, int a, int b) {
    	char tmp = chars[a];
    	chars[a] = chars[b];
    	chars[b] = tmp;
    }

}
