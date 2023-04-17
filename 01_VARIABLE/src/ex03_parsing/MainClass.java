package ex03_parsing;

public class MainClass {

	public static void main(String[] args) {
		
		// 구문 분석 (parsing)
		// 문자열을 기본 타입으로 변환하는 과정을 의미한다.
		
		
		int a = 10;
		int b = 20;
		int c = 0;
		
		c = a;		// 10
		a = b;		// 20 
		b = c;
		
		System.out.println(a);
		System.out.println(b);
		
		
		
		
		
		String strScore = "90"; 
		String strMoney = "10000000000";
		String strEye = "0.2";
		
		// String - > int로 변환
		int score = Integer.parseInt(strScore);
		System.out.println(score);
		
		// String -> long으로 변환
		long money = Long.parseLong(strMoney);
		System.out.println(money);
		
		// String -> double로 변환
		double eye = Double.parseDouble(strEye);
		System.out.println(eye);
		
	}

}
