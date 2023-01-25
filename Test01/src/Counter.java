
public class Counter {

	public static void main(String[] args) {
		
		// 오버플로우 : 표현가능한 범위를 넘는 것
		// 최대값 + 1 -> 최소값
		// 최소값 - 1 -> 최대값

		// 1. 문자와 숫자간의 변환
		// 3 -> '3' = 숫자 + 문자0('0') / 반대로 문자에서 숫자 = '3' - '0'
		
		// 2. 문자열로 변환
		// 3 -> "3"  = 3 + "";  '3' + "";
		
		// 문자열을 숫자로 변환
		// "3" ->  3 =  Integer.parseInt("3")
		// "3.4" -> 3.4 = Double.parseDouble("3.4);
		// "3" -> '3' = charAt(0) ; "3".charAt(0); 
		
		String str = "3";
		
		System.out.println("3".charAt(0) - '0');
		System.out.println('3' - '0' + 1);
		System.out.println(Integer.parseInt("3") + 1);
		System.out.println("3" + 1);  
		System.out.println(3 + '0');
		
	}

}
