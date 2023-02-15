import java.security.Timestamp;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.Scanner;
public class Practice01_1 {

//	1. 사용자 가위바위보 입력받기
//	2. 가위바위보 -> 숫자로 변환하기
//	3. 랜덤으로 0~2 숫자 생성하기
//	4. 2, 3 숫자 비교해서 승패 결정하기
//	5. i) 숫자 -> 가위바위보로 변경해서 출력
//	ii) 승패 출력
	
	// 문제1. 가위바위보
	// 실행
	// 가위바위보 >>> 가위
	// 당신은 가위, 컴퓨터는 보, 이겼습니다.
	// Hint : 가위는 0, 바위는 1, 보는 2로 처리한다.

	//	0 - > 1 : -1
	//	1 - > 2	: -1
	//	2 - > 0 :  2
	
	
	
	public static void ex01() {
		
		String player[] = {"가위", "바위", "보"};
		
		Scanner sc = new Scanner(System.in);
		
		switch(sc.next()) {
		case "가위" : 
		}
	   }


		
	// 문제2. 친구 3명을 저장할 수 있는 배열을 생성하고 임의의 값으로 초기화하시오.
	// 새로 사귄 친구의 수를 입력 받아서 기존 친구들이 저장된 배열의 길이를 새로 사귄 친구의 수만큼 늘리시오.
	
	public static void ex02() {
		
		int[] frd1 = {1, 2, 3};
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("새로 사귄 친구의 수 >>>");
		int nfrd = sc.nextInt();
		sc.close();
		
		int[] frd2 = new int[frd1.length + nfrd];
		
		for(int i = 0; i < frd1.length; i++) {
			frd2[i] = frd1[i];
		}
		System.out.println(Arrays.toString(frd2));
		
	}
	
		

	// 문제3. Scanner 클래스의 next() 메소드를 이용해서 사용자로부터 문자열을 계속 입력 받는다.
	// 사용자가 "종료" 문자열을 입력하면 더 이상 입력 받지 않는다.
	// 총 몇 번만에 종료되었는지 그 횟수를 마지막에 출력한다.
	
	public static void ex03() {
		
	Scanner sc = new Scanner(System.in);
	int count = 0;
	String input = "";
	
	while(true) {
		System.out.println("문자열을 입력해라 >>>");
		input = sc.next();
		count++;
		if(input.equals("종료"))break;
	}
	System.out.println(count + "번 입력했다.");
	sc.close();
	}

	// 문제4. 퀴즈 정답을 맞힐때까지 계속 퀴즈를 내시오.
	// 질문 : 대한민국의 수도는? >>> 서울
	// 정답입니다.
	// 질문 : 대한민국의 수도는? >>> seoul
	// 정답입니다.
	// 질문 : 대한민국의 수도는? >>> 인천
	// 오답입니다.
	public static void ex04() {	
		
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			System.out.println("질문 : 대한민국의 수도는? ><><>>");
			String answer = sc.next();
			if(answer.equals("서울") || answer.equalsIgnoreCase("seoul")) {
				System.out.println("정답입니다");
				break;
			} else {
				System.out.println("오답입니다.");
			}
		}
		sc.close();
		
			
	}

	// 문제5. 평점 입력 받아서 해당 평점만큼 ★을 출력하시오.
	// 평점은 1 ~ 5 사이 정수로 입력 받는데, 벗어난 범위는 다시 입력 받는다.
	public static void ex05() {

		Scanner sc = new Scanner(System.in);

		System.out.print("평점을 입력하세요 : ");
		int input = sc.nextInt();

		while(!(0 < input && input < 6)) {
			System.out.println("1 ~ 5사이로 입력해주세요.");
			input = sc.nextInt();
		}
		
			System.out.print("당신의 평점은 ");
			for(int i=0; i<input; i++) {
				System.out.print("★");
			}
			System.out.println("점 입니다.");
		sc.close();

	}

	// 문제6. 비밀번호를 "1234"로 가정한다.
	// 사용자로부터 비밀번호를 입력 받아서 "1234"와 같으면 "성공", "1234"가 아니면 다시 비밀번호를 입력 받도록 처리하시오.
	// 비밀번호 입력은 최대 5번으로 제한하고, 5번의 입력이 모두 틀리면 최종적으로 "실패"를 출력하시오.
	public static void ex06() {

		Scanner sc = new Scanner(System.in);
		String pw = "1234";
		int count = 0;
		
		while(true) {
			System.out.println("비밀번호를 입력하시오키키 >>>");
			String input = sc.next();
			count++;
			
			if(input.equals(pw)) {
				System.out.println("성공");
				break;
			}
			if(count == 5) {
				System.out.println("실패!!");
				break;
			}
		}
		sc.close();
		
	}		

	// 문제7. 구구단을 외자.
	// 2~9단 사이의 임의의 구구단이 출력되면 정답을 입력한다.
	// 정답을 입력해서 맞으면 "정답", 틀리면 "땡"을 출력하시오.
	// 예시1)
	// 4x9? >>> 36
	// 정답
	// 예시2)
	// 8x7? >>> 49
	// 땡
	public static void ex07() {

		/*
			기본 값이 double이기 때문에 int로 변환해 주는 작업이 필요하다.
			난수 생성하기
			
		 * 
		//int dan
			Math.random()                    0.0 <= n < 1.0
			Math.random() * 3				 0.0 <= n < 3.0
			(int)(Math.random() * 3)		 0 <= n < 3
			(int)(Math.random() * 8) + 2	 2 <= n < 10
			----------------------------------------------------
			(int)(Math.random() * 개수 ) + 시작값
			
		 * 
		//int n
			Math.random()                    0.0 <= n < 1.0
			Math.random() * 3				 0.0 <= n < 3.0
			(int)(Math.random() * 9)		 0 <= n < 9
			(int)(Math.random() * 9) + 1	 1 <= n < 10
			----------------------------------------------------
			(int)(Math.random() * 개수 ) + 시작값
			
		 */
		
		// Scanner 객체 생성
		Scanner sc = new Scanner(System.in);
		
		// 위쪽 표를 보고 dan ,과 n의 난수를 생성
		int dan = (int)(Math.random()*8) + 2;
		int n = (int)(Math.random()*9) + 1;
		
		// int 입력
		System.out.println(dan + "x" + n +" ? = >>> ");
		int answer = sc.nextInt();
		
		// 삼항 연산
		// dan * n과 answer의 값이 같으면 정답 , 아니면 땡
		System.out.println(dan * n == answer ? "정답" : "땡");
		
		// Scanner 객체 종료
		sc.close();
		
		
		
		

//		double r = (Math.random()*8)+2;// 0 <= r < 1	0<= r < 8	2 <= r < 10
//									 // 0 ~ 0.9999	0 ~ 7.9999		2 ~ 9
//		for(int i=0; i<10; i++) {
//			System.out.println((int)(Math.random()*8)+2);
//		}
		

	}

	// 문제8. 임의의 주민등록번호(personalId)를 분석하여 나이와 성별을 출력하시오.
	// 나이 : 현재년도 - 태어난년도 + 1
	// 성별 : 하이픈(-) 뒤의 글자가 1,3이면 "남자", 2,4이면 "여자"
	// 예시)
	// 28살 여자입니다.
	public static void ex08() {

		Calendar now = Calendar.getInstance();

		int year = now.get(Calendar.YEAR);

		Scanner sc = new Scanner(System.in);

		while(true) {
			System.out.print("-을 포함한 주민등록번호를 입력하세요.");

			String id = sc.next();

			if(id.length()==14 && id.substring(6,7).equals("-")) {

				int age;

				if(id.substring(0, 1).equals("9") || id.substring(0, 1).equals("8")) {
					age = year - (Integer.parseInt(id.substring(0, 2)) + 1900);
				} else {
					age = year - (Integer.parseInt(id.substring(0, 2)) + 2000);

				}

				String gender = id.substring(id.indexOf("-")+1,id.indexOf("-")+2);

				if(gender.equals("1") || gender.equals("3")) {
					System.out.println(age + "세 남자입니다.");
					return;
				}else {
					System.out.println(age + "세 여자입니다.");
					return;
				}
			}else {
				System.out.println("잘못된 주민등록번호 입니다.");
			}
		}
	}

	// 문제9. 다음 기준에 따라서 파일명을 변환하시오.
	// Scanner 클래스의 next() 메소드를 이용해서 파일명을 입력 받은 뒤 파일명을 다음과 같이 수정하시오.
	// 파일명 마지막에 밑줄(_)과 타임스탬프 값을 붙이시오.
	// 예시)
	// 변환 전 파일명 >>> happy.jpg
	// 변환 후 파일명 = happy_1658792128410.jpg
	public static void ex09() {

		long ts = System.currentTimeMillis();
		Scanner sc = new Scanner(System.in);
		System.out.println("파일명을 입력하세요");
		String file = sc.next();
		
		String nfile = file.substring(0, file.indexOf(".")) + "_" + (ts+ "") + file.substring(file.lastIndexOf("."));
		
		System.out.println("변환 전 파일명 : " + file);
		System.out.println("변환 후 파일명 : " + nfile);
		sc.close();
		
		
		
		
		
		//		String newFileName = fileName.su



	}

	// 문제10. Scanner 클래스의 next() 메소드를 이용해서 사람 이름을 입력 받은 뒤
	// 친구의 이름이면 "반갑다 친구야"를 출력하고, 모르는 사람의 이름이면 "처음 뵙겠습니다"를 출력하시오.
	// 친구의 이름을 String[] friend 배열에 저장한 뒤 작업을 수행하시오.
	// 예시1
	// 이름 입력 >>> 정우성
	// 반갑다 친구야
	// 예시2
	// 이름 입력 >>> 유재석
	// 처음 뵙겠습니다
	public static void ex10() {

	Scanner sc = new Scanner(System.in);
	String[] friend = {"이유빈", "장종찬", "박근희"};
	
	System.out.println("이름을 입력하시우히히");
	String input = sc.next();
	sc.close();
	for(int i = 0; i < friend.length; i++) {
		if(input.equals(friend[i])) {
			System.out.println("반갑S");
			return;

		}
	}
	System.out.println("누구세요 ?");
	}
	public static void main(String[] args) {
		ex10();
	}

}
