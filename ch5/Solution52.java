package ch5.cbc.xuewei.ece.cmu;

public class Solution52 {
	
	public static String binary2string(double num){
		// as required by the problem, the number should be in the range (0, 1)
		if(num >= 1 || num <= 0) {
			return "ERROR";
		}
		
		StringBuilder result = new StringBuilder();
		result.append('.');
		while(num > 0) {
			// as required by the problem, return "ERROR" when the length is greater than 32
			if(result.length() >= 32) {
				return "ERROR";
			}
			
			// by left shifting the number, to see whether it's greater than 1
			// in this way, we could determine in the bsse whether it's 1 or 0.
			num *= 2;
			if(num >= 1){
				result.append(1);
				num -= 1;
			} else {
				result.append(0);
			}
		}
		return result.toString();
	}

	public static void main(String[] args) {
		double num = 0.5;
		System.out.println("num:"+num);
		System.out.println("after:"+Solution52.binary2string(num));
		System.out.println("------------------------------");
		
		// this case may return "ERROR" because the representation of floating number.
		num = 0.72;
		System.out.println("num:"+num);
		System.out.println("after:"+Solution52.binary2string(num));
	}

}
