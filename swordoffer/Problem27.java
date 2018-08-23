package sword_offer;

import java.util.ArrayList;
import java.util.Collections;

/**
 * ����һ���ַ���,���ֵ����ӡ�����ַ������ַ����������С�
 * ���������ַ���abc,���ӡ�����ַ�a,b,c�������г����������ַ���abc,acb,bac,bca,cab��cba��
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
        Collections.sort(result);//���ֵ�˳���list��������
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
