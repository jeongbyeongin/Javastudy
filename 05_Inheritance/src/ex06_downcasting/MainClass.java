package ex06_downcasting;

public class MainClass {

	public static void ex01() {
		// upcasting
		Person person = new Student();	// 복습 : upcasting
		
		// downcasting
		Student student = (Student)person;  // 강제변환 : (byte)n;
		
		student.eat();
		student.sleep();
		student.study();
		
	}
	
	public static void ex02() {
		// Person
		Person person = new Person();	// 
		
		// 잘못된 캐스팅
		Student student = (Student)person;  
		
		// 잘못된 캐스팅은 컴파일 오류로 걸러지지 않는다.
		student.eat();
		student.sleep();
		student.study(); // 오류 발생 부분
	
	}
	
	public static void ex03() {
		
		// Person
		Person person = new Person();  // Person person(instance화 된다 라고도함. 객체 = 인스턴스) = new Person();
		
		// Student 객체(인스턴스, instance)가 맞다면 Student 타입으로 캐스팅하자.
		if(person instanceof Student) {
			
			Student student = (Student)person;  //  =  ((Student)Person).eat();
			student.eat();		// =  ((Student)Person).eat();
			student.sleep();	// = ((Student)person).sleep();
			student.study();	// = ((Student)person).study();
			
			// person.을했을 때 원래는 study가 뜨면 안되지만  person = if라고 걸어놔서 스터디가 뜨는 것.
			
			
			// 추천 // 위에보다는 아래 방법을
			person.eat();  // sleep 이랑 같은 위치
			person.sleep();
			((Student)person).study();  // (eat, sleep)이랑 다른 위치
			
		}
		
	}
	
	public static void main(String[] args) {
		ex03();
	}

}
