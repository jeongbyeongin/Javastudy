import java.security.Timestamp;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.Scanner;
public class Practice01_1 {

	// 문제1. 가위바위보
	// 실행
	// 가위바위보 >>> 가위
	// 당신은 가위, 컴퓨터는 보, 이겼습니다.
	// Hint : 가위는 0, 바위는 1, 보는 2로 처리한다.

	//	0 - > 1 : -1
	//	1 - > 2	: -1
	//	2 - > 0 :  2

	public static void ex01() {
		
		List<String> list = Arrays.asList("가위","바위","보");
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("가위바위보 >>>");
		
		String input = sc.next();
		
		int user = list.indexOf(input);
		
		int com = (int)(Math.random()*3);
		
		int result = user-com;
		
		switch(result) {
		case 0 :
			System.out.println("비겼습니다."); break;
		case -1 : case 2 :
			System.out.println("컴퓨터가 이겼습니다."); break;
		default :
			System.out.println("사용자가 이겼습니다.");
		}
		sc.close();
		System.out.println("당신은" + input + " 컴퓨터는 " + list.get(com));
		
		
		
	}

		
	// 문제2. 친구 3명을 저장할 수 있는 배열을 생성하고 임의의 값으로 초기화하시오.
	// 새로 사귄 친구의 수를 입력 받아서 기존 친구들이 저장된 배열의 길이를 새로 사귄 친구의 수만큼 늘리시오.
	public static void ex02() {
		
		int[] frd1 = {1,2,3};
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("새로 사귄 친구의 수 >>>");
		
		int nfrd = sc.nextInt();
		sc.close();
		
		int[] frd2 = new int[frd1.length + nfrd];
		
		for(int i = 0; i < frd1.length; i++) {
			frd2[i] = frd1[i];
		}
		
		System.out.println( "주소 변경 전 : " + Arrays.toString(frd1));
		
		frd1 = frd2;
		
		System.out.println("주소 변경 후 : " + Arrays.toString(frd1));
		
	}

		

	// 문제3. Scanner 클래스의 next() 메소드를 이용해서 사용자로부터 문자열을 계속 입력 받는다.
	// 사용자가 "종료" 문자열을 입력하면 더 이상 입력 받지 않는다.
	// 총 몇 번만에 종료되었는지 그 횟수를 마지막에 출력한다.
	public static void ex03() {
		
		Scanner sc = new Scanner(System.in);
		
		int count = 0;
		String input = "";
		
		while(true) {
			System.out.println("문자열을 입력하시오 >>>");
			input = sc.next();
			count++;
			if(input.equals("종료")) break;
		}
		
		System.out.println(count + "번 입력했습니다.");
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
			System.out.println("질문 : 대한민국의 수도는? >>>");
			String answer = sc.next();
			if(answer.equals("서울") || answer.equalsIgnoreCase("seooul")) {
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
			System.out.println("비밀번호를 입력하세요 >>> ");
			String input = sc.next();
			count++;

			if(input.equals(pw)) {
				System.out.println("성공");
				break;
			}
			if(count == 5) {
				System.out.println("실패");
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

		Scanner sc = new Scanner(System.in);

		int a = (int)(Math.random()*8) + 2;
		int b = (int)(Math.random()*9) + 1;

		String answer = a*b + "";

		System.out.print(a +"x"+b+"? >>> ");

		String input = sc.next();

		if(answer.equals(input)) {
			System.out.println("정답~ 짝!짝!짝!");
		} else {
			System.out.println("오답 ㅋㅋ");
		}

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

				if(id.substring(0, 1).equals("9")) {
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
		System.out.print("파일명을 입력하시오 >>>");
		String fileName = sc.next();

		String name = fileName.substring(0, fileName.indexOf(".")) + "_" + (ts+"");
		String newFileName = name +fileName.substring(fileName.indexOf("."), fileName.length());

		System.out.println("변환 전 파일명 : " + fileName);
		System.out.println("변환 후 파일명 : " + newFileName);

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
		String[] friend = {"조우민", "정우성", "유재석"};

		System.out.println("이름을 입력하세요.");
		String input = sc.next();

		for(int i=0; i < friend.length; i++ ) {
			if(input.equals(friend[i])) {
				System.out.println("반갑다 친구야.");
				return;
			}
		}

		System.out.println("저 아세요?");

	}

	public static void main(String[] args) {
		ex04();
	}

}
