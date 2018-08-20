package ldl.swordoffer;

public class Problem52 {

	/*
	 * 要分为几种情况：（状态机） 
	 * （1）当第二个字符不为‘*’时：匹配就是将字符串和模式的指针都下移一个，不匹配就直接返回false
	 * （2）当第二个字符为'*'时：
	 *   匹配：                 
	 *     a.字符串下移一个，模式不动
	 *     b.字符串下移一个，模式下移两个 
	 *     c.字符串不动，模式下移两个
	 *   不匹配：字符串下移不动，模式下移两个 搞清楚这几种状态后，用递归实现即可：
	 */
	public boolean match(char[] str, char[] pattern) {
		if (str == null || pattern == null)
			return false;
		int s = 0;
		int p = 0;
		return match(str, s, pattern, p);

	}

	public boolean match(char[] str, int strIndex, char[] pattern, int patternIndex) {

		//str到尾，pattern到尾，匹配成功
		if(strIndex == str.length && patternIndex == pattern.length) {
			return true;
		}
		//str未到尾，pattern到尾，匹配失败
		if(strIndex != str.length && patternIndex == pattern.length) {
			return false;
		}
		//str到尾，pattern未到尾(不一定匹配失败，因为a*可以匹配0个字符)
		if(strIndex == str.length && patternIndex != pattern.length) {
			// 只有pattern剩下的部分类似a*b*c*的形式，才匹配成功
			if (patternIndex + 1 < pattern.length && pattern[patternIndex + 1] == '*') {
				return match(str, strIndex, pattern, patternIndex + 2);
			}
			return false;
		}

		// str未到尾，pattern未到尾,且pattern第二位为*
		if(patternIndex + 1 < pattern.length && pattern[patternIndex + 1] == '*') {
			if (pattern[patternIndex] == str[strIndex] || (pattern[patternIndex] == '.' && strIndex != str.length)) {
				return match(str, strIndex, pattern, patternIndex + 2)// *匹配0个，跳过
						|| match(str, strIndex + 1, pattern, patternIndex + 2)// *匹配1个，跳过
						|| match(str, strIndex + 1, pattern, patternIndex);// *匹配1个，再匹配str中的下一个
			} else {
				// 直接跳过*（*匹配到0个）
				return match(str, strIndex, pattern, patternIndex + 2);
			}
		}
		// str未到尾，pattern未到尾,且pattern第二位不为*
		if (pattern[patternIndex] == str[strIndex] || (pattern[patternIndex] == '.' && strIndex != str.length)) {
			return match(str, strIndex + 1, pattern, patternIndex + 1);
		}

		return false;
	}

}
