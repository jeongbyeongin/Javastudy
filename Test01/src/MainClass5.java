
public class MainClass5 {

	public static void main(String[] args) {
		
		System.out.println(0x1A);
		System.out.printf("%.2f",10.0/3);  //소수점 둘째짜리까지만 출력
		
		System.out.printf("%d", 0x1A); // 정수를 10진수로
		System.out.printf("%X", 0x1A); // 16진수로 출력
		
		
		/*	%b = boolean형식으로 출력
		 	%d = 10진(decimal)정수의 형식으로 출력
		 	%o = 8진(octal)정수의 형식으로 출력
		 	%x,%X = 16진(hexa-decimal)정수의 형식으로 출력 -------------- 정수
		 	%f = 부동 소수점(floating - point)의 형식으로 출력
		 	%e,%E = 지수(exponent)표현식의 형식으로 출력    --------------실수
		 	%c = 문자(character)로 출력
		 	%s = 문자열(String)로 출력 -----------------------------------문자

		 */
		
		System.out.printf("age:%d year:%d\n" , 14, 2017);  // \n 개행문자 줄바꿈
	}

}
