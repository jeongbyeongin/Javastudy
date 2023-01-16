package ex07_abstract;

/*
	추상 메소드
	1. abstract method
	2. 본문이 없는 메소드이다.
	3. 중괄호{}를 없애고, 세모콜론;을 붙이고, abstract 키워드를 메소드앞에 추가한다.
	
 */

/*
	추상 클래스
	1. abstract class
	2. 추상 메소드를 1개 이상 가진 클래스이다.
	3. abstract 키워드를 클래스 앞에 추가한다.
	4. 추상 클래스를 상속 받는 클래스는 "반드시" "모든" "추상 메소드"를 오버라이드 해야 한다.
 	5. 추상 클래스는 객체 생성이 불가능하다.(new Person이 불가능 하다.)
 		(본문이 없는 메소드를 가지고 있기 때문에)
 */


public abstract class Person {  // 밑에 abstract가 생겼기 때문에 클래스에도 생겨야한다.

	public void eat() {
		System.out.println("먹는다.");
	}

	public void sleep() {
		System.out.println("잔다.");
	}
	
	public abstract void study();  // public void study(); = {} 본문이 없는 메소드 = 추상메소드
	
}