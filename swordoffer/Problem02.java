package sword_offer;

/**
 * 请实现一个函数，将一个字符串中的空格替换成“%20”。
 * 例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 * @author darlingliu
 *
 */

public class Problem02 {
	
	public String replaceSpace(StringBuffer str) {
		
        String string = str.toString();
        string.replaceAll(" ", "20%");
    	return string;
    }
	
	public String replaceSpace2(StringBuffer str) {
		StringBuffer result = new StringBuffer();
		for(int i = 0; i < str.length(); i++) {
			if(str.charAt(i) != ' ') {
				result.append(str.charAt(i));
			}
			else {
				result.append('%');
				result.append('2');
				result.append('0');
			}
		}
        return result.toString();
    }

	public static void main(String[] args) {
		
		
	}

}
