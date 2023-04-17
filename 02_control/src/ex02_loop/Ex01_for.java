package ex02_loop;

public class Ex01_for {

	/*
		for문
		1. 연속된 숫자를 생성하는 반복문(배열에서 주로 사용)
		2. 형식
			for(초기문; 조건문; 증감문) {
				실행문
			}
	 */
	public static void ex01() {
		
		// 1 ~ 10
		for(int a = 1; a <= 10; a++) {
			System.out.println(a);
		}
		
	}
		
	public static void ex02 () {
		
		// 횟수 
		int count = 5;
		
		for(int a = 1; a < count; a++) {
			System.out.println("Hello World");
		}
		
	}

	public static void ex03() {  // 연습
		
		// 10 ~ 1
		for(int a = 10; a >= 1; a--) {
			System.out.println(a);
		}
	}
	
	public static void ex04() {  // 연습
		
		// 구구단 2단 출력
		// 2 x 1 = 2
		// 2 x 2 = 4
		// ...
		
		int dan = 2;
		
		for(int a = 1; a <= 9; a++) {
			System.out.println(dan + " x " + a + " = " + (dan * a));
		}
		
	}
	
	public static void ex05() {

// 1 ~ 100까지 짝수 합이랑 홀수 합을 구하시오.
		
		int evenTotal = 0;		// 짝수 합
		int oddTotal = 0;		// 홀수 합

		
		
		
		for(int a = 1; a <= 100; a++) {
			if(a % 2 == 0) {
				evenTotal += a;
			} else if(a % 2 == 1) {
				oddTotal += a;
			}
		}
		System.out.println("짝수합 = " + evenTotal);
		System.out.println("홀수합 = " + oddTotal);
		
		
		
	}
		
// begin부터 end 사이의 모든 정수들의 평균을 출력하시오.
// 단, 항상 begin은 end보다 작거나 같은 상태이다.
// 예시
// 1부터 6사이 모든 정수의 평균은 3.5이다.
		public static void ex06() {
			
			int begin = 1;
			int end = 6;
			int total = 0;
			
			
			for(int i = begin; i <= end; i++) {
				total += i;
			} double avg = (double)total / (end - begin + 1);
			System.out.println(avg);
		}
		
	
	
	public static void main(String[] args) {
		ex06();	

	}

}
