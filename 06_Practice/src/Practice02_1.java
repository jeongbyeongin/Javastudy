
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Practice02_1 {

	// 문제1. 통장(balance)에 최초 5000원이 있다.
	// 1원부터 통장 잔고 사이의 난수를 발생시켜서 해당 난수만큼 출금 처리하시오.
	// 더 이상 출금이 불가능한 상황이면 출금을 멈추시오.
	// 예시)
	// 출금 전 5000원, 1회 출금액 2917원, 출금 후 2083원
	// 출금 전 2083원, 2회 출금액 1961원, 출금 후 122원
	// 출금 전 122원, 3회 출금액 102원, 출금 후 20원
	// 출금 전 20원, 4회 출금액 2원, 출금 후 18원
	// 출금 전 18원, 5회 출금액 17원, 출금 후 1원
	// 출금 전 1원, 6회 출금액 1원, 출금 후 0원
	public static void ex01() {
	      int balance = 5000;  // 통장
	      int count = 0;
	     
	      while(balance > 0) {
	         count++;
	         int withdraw = (int)(Math.random() * balance) + 1;
	         System.out.println("출금 전 " + balance + "원, " + count + "회 출금액 " + withdraw + "원, 출금 후 " + (balance -= withdraw) + "원");
	      }
	   }


	// 문제2. UpDown 게임
	// 1 ~ 10000 사이의 난수를 발생시키고 해당 난수를 사용자가 맞히는 게임이다.
	// 입력마다 "Up!", "Down!" 메시지를 출력하시오.
	// 예시)
	// 입력 >>> 5000
	// Down!
	// 입력 >>> 2500
	// Up!
	// ...
	// 입력 >>> 4500
	// 정답. 총 5번만에 성공.
	public static void ex02() {

		Scanner sc = new Scanner(System.in);

		int count = 0;

		int answer = (int)(Math.random()*10000) + 1;
		System.out.println(answer);
		while(true) {
			System.out.print("입력 >>> ");
			int input = sc.nextInt();
			count++;

			if(input > answer) {
				System.out.println("Down!!");
			}
			else if(input < answer) {
				System.out.println("Up!!");
			}
			else {
				System.out.println("정답!! " + count + "번만에 성공."); return;
			}

		}

	}

	// 문제3. 자동으로 진행되는 윷 던지기를 구현하시오. 윷이나 모가 나오면 추가로 던지시오.
	// 예시)
	// "도", 1칸 이동한다.
	// "개", 2칸 이동한다.
	// "걸", 3칸 이동한다.
	// "윷", "도", 5칸 이동한다.
	// "모", "윷", "도", 10칸 이동한다.
	public static void ex03() {

		String[] method = {"도", "개", "걸", "윷", "모"};

		List<String> trace = new ArrayList<>();

		int move; // 결과에 따라 움직이는 
		int total = 0; // 총 움직인 칸

		while(true) { 

			int play = (int)(Math.random()*5);
			String result = method[play];
			trace.add(result);
			move = play + 1;
			total += move;

			System.out.println(result + ", " + move + "칸 이동한다.");

			if(!(result.equals("윷") || result.equals("모"))) {
				for(String s : trace) {
					System.out.print(s + ", ");
				}
				System.out.println(total + "칸 이동한다.");
				return;
			}

		}



	}

	// 문제4. 0~9 사이 난수를 100개 생성하시오.
	// 발생한 0~9 사이의 각 난수들이 생성된 횟수(빈도수)를 그래프화 하여 출력하시오.
	// 예시)
	// 0 : #### 4
	// 1 : ############ 12
	// 2 : ############ 12
	// 3 : ##### 5
	// 4 : ######## 8
	// 5 : ########### 11
	// 6 : ############ 12
	// 7 : ################## 18
	// 8 : ####### 7
	// 9 : ########### 11
	public static void ex04() {

		int[] arr = new int[10];

		// 배열에 0~9까지 나온 횟수 입력
		for(int i=0; i<100; i++) {
			int random = (int)(Math.random()*10);
			arr[random]++;
		}

		// 출력
		for(int i=0; i<arr.length; i++) {
			System.out.print(i + " : ");
			for(int j=0; j<arr[i]; j++) {
				System.out.print("#");
			}
			System.out.println(" " + arr[i]);
		}



	}

	// 문제5. 간단한 성적 관리 프로그램을 구현하시오.
	// 학생은 3명, 과목은 3과목으로 가정한다.
	// 학생 이름 : "정숙", "미희", "상철"
	// 과목 이름 : "국어", "영어", "수학"
	// 입력 받은 성적과 각 성적의 합계를 함께 출력하시오.
	// 예시)
	// 정숙의 국어 점수 >>> 50
	// 정숙의 영어 점수 >>> 51
	// 정숙의 수학 점수 >>> 53
	// 미희의 국어 점수 >>> 60
	// 미희의 영어 점수 >>> 61
	// 미희의 수학 점수 >>> 63
	// 상철의 국어 점수 >>> 70
	// 상철의 영어 점수 >>> 71
	// 상철의 수학 점수 >>> 73
	//
	// 	    국어 영어 수학 총점	
	// 정숙 50   51   53   154	
	// 미희 60   61   63   184	
	// 상철 70   71   73   214	
	// 합계 180  183  189  552	
	public static void ex05() {

		// 강사님 방법 (2차원 배열 사용)
		Scanner sc = new Scanner(System.in);
		String[] name = {"정숙", "미희", "상철", "합계"};
		String[] subject = {"국어", "영어", "수학", "총점"};
		int[][] score = new int[name.length][subject.length];

		// 점수(총점포함) 2차원 배열에 담기
		for(int i=0; i < name.length-1; i++) {
			for(int j=0; j < subject.length-1; j++) {
				System.out.print(name[i] + "의 " + subject[j] + " 점수 >>> ");
				score[i][j] = sc.nextInt();
				score[i][subject.length-1] += score[i][j];
				score[name.length-1][j] += score[i][j];
				score[name.length-1][subject.length-1] += score[i][j];
			}
		}

		System.out.print("\t");

		for(int i=0; i<subject.length; i++) {
			System.out.print(subject[i] + "\t");
		}
		System.out.println();
		for(int i=0; i<name.length; i++) {
			System.out.print(name[i]);
			for(int j=0; j<subject.length; j++) {
				System.out.print("\t" + score[i][j]);
			}
			System.out.println();
		}


		/* 조우민 방법
		Scanner sc = new Scanner(System.in);
		String[] student = {"우민", "정숙", "미희"};
		String[] subject = {"국어", "영어"	, "수학"};
		int[][] studentScore = new int[student.length][subject.length];

		int[] subjectTotal = new int[subject.length];
		int subjectTotalSum = 0;

		for(int i=0; i < student.length; i++) {
			for(int j=0; j < subject.length; j++) {
				System.out.print(student[i] + "의 " + subject[j] +" 점수 >>> ");
				String score = sc.next();
				studentScore[i][j] = Integer.parseInt(score);
			}
		}

		System.out.println("\t국어\t" + "영어\t" + "수학\t" + "총점");
		for(int i=0; i < studentScore.length; i++) {

			int total =0; // 학생 별 합계
			int subTotal =0; // 과목별 합계
			System.out.print(student[i]+ "\t"); // 학생 이름 출력

			for(int j=0; j < studentScore[i].length; j++) {
				System.out.print(studentScore[i][j] + "\t");
				total += studentScore[i][j];
				subTotal += studentScore[j][i];
			}
			subjectTotal[i] = subTotal;
			System.out.println(total);

		}

		System.out.print("합계\t");

		for(int i=0; i < student.length; i++) {
			subjectTotalSum += subjectTotal[i];
			System.out.print(subjectTotal[i] + "\t");
		}
		System.out.println(subjectTotalSum);
		 */


	}

	// 문제6. 4계절이 저장되어 있는 영한 사전(2차원 배열)을 이용하여 문제를 해결하시오.
	// 예시)
	// 봄을 영어로 하면? >>> spring
	// 정답
	// 여름을 영어로 하면? >>> sumer
	// 오답
	// 가을을 영어로 하면? >>> fall
	// 정답
	// 겨울을 영어로 하면? >>> win
	// 오답
	public static void ex06() {

		Scanner sc = new Scanner(System.in);

		String[][] season = {
				{"봄", "spring"},
				{"여름", "summer"},
				{"가을", "fall"},
				{"겨울", "winter"}
		};

		for(int i=0; i < season.length; i++ ) {

			System.out.print(season[i][0] + "을 영어로 하면? >>> ");
			String answer = sc.next();

			if(answer.equals(season[i][1])) {
				System.out.println("정답!!");
			} else {
				System.out.println("오답!!");
			}

		}



	}

	// 문제7. 다음 순서에 따라서 5 x 5 형태의 숫자 빙고판을 자동으로 생성하시오.
	// 지시사항)
	//   1. 1 ~ 25 사이 정수를 2차원 배열 bingo 에 순차적으로 넣는다.
	//   2. 섞는다.
	//        총 25번의 교환이 랜덤하게 발생된다.
	//        교환 예시)
	//        순서대로    <-> 임의로
	//        bingo[0][0] <-> bingo[1][4]
	//        bingo[0][1] <-> bingo[0][2]
	//        bingo[0][2] <-> bingo[2][1]
	//        ...
	//        bingo[4][4] <-> bingo[3][1]
	// 예시)
	//  10  9  4 25  2
	//  15  3 13 21  1
	//  14 20 11 19  6
	//   8 17  5 12  7
	//  16 22 18 24 23

	public static void ex07() {

		int[][] bingo = new int[5][5]; // 빙고판
		int tmp = 0; // 섞을 때 필요한 빈 변수
		int n = 1; 

		// 빙고판 생성
		for(int i = 0; i < bingo.length; i++) {
			for(int j = 0; j < bingo[i].length; j++) {
				bingo[i][j] = n++;
			}
		}

		// 섞는 메소드
		for(int i = 0; i < bingo.length; i++) {
			for(int j = 0; j < bingo[i].length; j++) {
				int r1 = (int)(Math.random()*5);
				int r2 = (int)(Math.random()*5);
				tmp = bingo[i][j];
				bingo[i][j] = bingo[r1][r2];
				bingo[r1][r2] = tmp;
			}
		}

		// 빙고판 출력 (섞는 동시에 출력하면 중복 값이 나옴)
		for(int i = 0; i < bingo.length; i++) {
			for(int j = 0; j < bingo[i].length; j++) {
				System.out.print(bingo[i][j] + "\t");
			}
			System.out.println();
		}



	}

	// 문제8. 대문자와 소문자와 숫자로 구성된 인증번호를 만드시오.
	// 사용자로부터 몇 자리의 인증번호를 만들것인지 입력 받아서 처리하시오.
	// 대문자와 소문자와 숫자는 임의로 섞으시오.
	// 예시)
	// 몇 자리의 인증번호를 생성할까요? >>> 6
	// 생성된 6자리 인증번호는 Fa013b입니다.
	public static void ex08() {
		// 대소문자, 숫자를 넣을 배열
		char[] arr = new char[62];
		// 아스키 코드를 이용해 배열에 대소문자, 숫자만 넣기위해
		char ch = 48;
		// 배열에 대소문자, 숫자 삽입
		for(int i = 0; i < arr.length; i++) {

			if(ch == 58) ch = 65;
			if(ch == 91) ch = 97;

			arr[i] = ch++; 
		}

		Scanner sc = new Scanner(System.in);
		System.out.print("몇 자리의 인증번호를 생성할까요? >>> ");

		int len = sc.nextInt();
		StringBuilder sb = new StringBuilder();

		// 인증코드 생성
		for(int i = 0; i < len; i++) {
			int r = (int)(Math.random()*62); // 랜덤한 인증코드를 위한 난수
			sb.append(arr[r]);
		}

		System.out.println("생성된 " + len + "자리 인증번호는 \"" + sb + "\"입니다.");



		//		sc.close();
	}

	// 문제9. 다음 지시시항에 따라 요일을 계산하는 프로그램을 구현하시오.
	// 지시사항)
	//   1. AD 1년 1월 1일은 월요일이다.
	//   2. 평년은 1년이 365일이다.(2월 28일까지 있다.)
	//   3. 윤년은 1년이 366일이다.(2월 29일까지 있다.)
	//   4. 윤년이란?
	//      1) 4로 나눠 나머지가 0인 년도는 윤년이다.
	//      2) 이 중 100으로 나눠 나머지가 0인 년도는 평년이다.
	//      3) 이 중 400으로 나눠 나머지가 0인 년도는 윤년이다.
	// 힌트)
	//   1년 1월 1일부터 입력한 날짜까지 며칠이 지났는지 계산한다.
	//   계산된 일수와 요일의 관계는 다음과 같다.
	//     일 : 계산된 일수를 7로 나눈 나머지가 0이다.
	//     월 : 계산된 일수를 7로 나눈 나머지가 1이다.
	//     화 : 계산된 일수를 7로 나눈 나머지가 2이다.
	//     수 : 계산된 일수를 7로 나눈 나머지가 3이다.
	//     목 : 계산된 일수를 7로 나눈 나머지가 4이다.
	//     금 : 계산된 일수를 7로 나눈 나머지가 5이다.
	//     토 : 계산된 일수를 7로 나눈 나머지가 6이다.
	// 예시)
	// 년-월-일 입력(2000-01-01) >>> 2023-01-19
	// 입력된 2023-01-19는 목요일입니다.
	public static void ex09() {

		Scanner sc = new Scanner(System.in);

		System.out.print("년-월-일 입력(2000-01-01) >>> ");
		String date = sc.next();

		int year = Integer.parseInt(date.substring(0, 4)) - 1900;
		int month = Integer.parseInt(date.substring(5, 7)) - 1;
		int dayOfMonth = Integer.parseInt(date.substring(8));

		Date input = new Date(year,month,dayOfMonth);

		SimpleDateFormat sdf = new SimpleDateFormat("입력된 " + "yyy-MM-dd" + "는 " + "E" + "요일입니다.");

		String result = sdf.format(input);

		System.out.println(result);

		sc.close();
	}

	// 문제10. 사용자가 입력한 금액만큼 로또를 구매한다고 가정하고, 완성된 로또 용지를 출력하시오.
	// 금액은 1000원 단위로 입력하고 100원 이하 단위 입력은 무시하시오.
	// 로또 용지 1개에는 최대 5개의 로또 게임 기록이 가능하다.
	// 예시)
	// 얼마나 구입하시겠습니까? >>> 16000
	// 01 :   24  20  15  39  41  35
	// 02 :   14  43  23  26   4  38
	// 03 :   21  13  38   1  34  42
	// 04 :    1   2  41  33  43  14
	// 05 :   28  24  27  21  23  37
	// ------------------------------
	// 01 :   12  23  42  30  41  43
	// 02 :   38  37  42  31  13  19
	// 03 :   44  18  35  26   3  41
	// 04 :   30  40   5   2  10  22
	// 05 :   45  13   6  39  30  19
	// ------------------------------
	// 01 :   12  15  29  45  28  39
	// 02 :   25  39  20  43  34  27
	// 03 :   30   4  38   9   2  22
	// 04 :    9  39  22  20  21  35
	// 05 :    6  43  40   4  14  31
	// ------------------------------
	// 01 :   13  10  42  34  32  21
	// ------------------------------
	public static void ex10() {
		
		Scanner sc = new Scanner(System.in);
		int money = sc.nextInt()/1000;
		
		for(int i=0; i<6; i++) {
			int r = (int)(Math.random()*45) +1;
			System.out.println(r);
		}


//		Scanner sc = new Scanner(System.in);
//
//		int[] lotto = new int[6];
//		int money = sc.nextInt()/1000;
//		int number =1; // 로또 횟수 1 ~ 5
//
//		for(int m = 0; m < money; m++) {
//
//			// 로또 번호 배열에 저장
//			for(int i = 0; i < lotto.length; i++) {
//
//				lotto[i] = (int)(Math.random()*45) + 1;
//
//				// 중복될 경우 다시 저장
//				for(int j = 0; j < i; j++) {
//					if(lotto[i] == lotto[j]) {
//						i--;
//						break;
//					}
//				}
//			}
//
//			// 로또 횟수 번호 출력
//			if(number < 6) {
//				System.out.printf("%02d", number);	
//				System.out.print(" : ");
//			} else if(number%5 == 0) {
//				System.out.printf("%02d", 5);	
//				System.out.print(" : ");
//			} else {
//				System.out.printf("%02d", (number%5));	
//				System.out.print(" : ");
//			}
//
//			// 회차별 로또 번호 출력
//			for(int i = 0; i < lotto.length; i++) {
//				System.out.printf("%2d", lotto[i]);
//				System.out.print(" ");
//			}
//			System.out.println();
//
//			// 5번째마다 선 출력
//			if(number%5 == 0 && number!=1) {
//				System.out.println("------------------------------");
//			}
//			number++;
//			// 마지막에 선 출력
//			if(m == money-1) {
//				System.out.println("------------------------------");
//			}
//		}
//		sc.close();

		/* 중복을 막아주는 부분은 한번 출력된 인덱스에 마지막 인덱스를 넣고 마지막 인덱스가 나오지 않게 ballCount를 줄여준다.
		Scanner sc = new Scanner(System.in);
		System.out.print("얼마나 구입하시겠습니까? >>> ");
		int money = sc.nextInt();
		while(money > 0) {
			int row = (money >= 5000) ? 5 : money / 1000;
			int[][] lotto = new int[row][6];
			for (int i = 0; i < lotto.length; i++) {
				// 45개 숫자에서 랜덤하게 빼서 lotto[i][j]에 저장
				int ballCount = 45;
				int[] ball = new int[ballCount];
				// 1~45 순차적으로 생성
				for (int j = 0; j < ball.length; j++) {
					ball[j] = j + 1;
				}
				// ball 배열에서 6개를 lotto[i][j] 보내기
				for (int j = 0; j < lotto[i].length; j++) {
					int rnd = (int)(Math.random() * ballCount);  // ball 배열의 인덱스(0~ballCount-1) 랜덤 생성
					lotto[i][j] = ball[rnd];
					int lastIdx = 44 - j;	
					if (rnd != lastIdx) {	 // 
						ball[rnd] = ball[lastIdx];
					//	
					}
					ballCount--;
				}
			}
			// 출력
			for (int i = 0; i < lotto.length; i++) {
				System.out.print("0" + (i + 1) + " : ");
				for (int j = 0; j < lotto[i].length; j++) {
					System.out.print( String.format("%4d", lotto[i][j]) );
				}
				System.out.println();
			}
			System.out.println("———————————————");
			money -= 5000;
		}
		sc.close();
		 */

	}

	public static void main(String[] args) {
		ex01();
	}


}

