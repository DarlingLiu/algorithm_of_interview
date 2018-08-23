package sword_offer;

/**
 * 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
 * @author darlingliu
 *
 */

public class Problem12 {
	
	public double Power(double base, int exponent) {
		double result = 1;
		if(exponent == 0)
			return 1;
		int ex = Math.abs(exponent);
		
		for(int i = 1; i <= ex; i++) {
			result = result * base;
		}		
		if(exponent < 0)
			return 1/result;
		
		return result;
        
	}
	
	public static double Power2(double base, int exponent) {
	
		int ex = Math.abs(exponent);
		double result = pow(base, ex);
		if(exponent < 0)
			return 1/result;	
		return result;     
	}
	
	public static double pow(double base, int ex) {
		double result = 1;
		if(ex == 0)
			return 1;
		if(ex == 1)
			return base;
		
		result = pow(base, ex/2);
		result *= result;		
		if((ex % 2) == 1)			
			result *= base;
				
		return result;
	}
	

	public static void main(String[] args) {
		
		System.out.println(Power2(2.0, -3));

	}

}
