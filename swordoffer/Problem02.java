package sword_offer;

/**
 * ��ʵ��һ����������һ���ַ����еĿո��滻�ɡ�%20����
 * ���磬���ַ���ΪWe Are Happy.�򾭹��滻֮����ַ���ΪWe%20Are%20Happy��
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
