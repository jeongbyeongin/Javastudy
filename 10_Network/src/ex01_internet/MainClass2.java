package ex01_internet;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class MainClass2 {
	
	/*
		1. 사용자 가위바위보 입력받기
		2. 가위바위보 -> 숫자로 변환하기
		3. 랜덤으로 0~2 숫자 생성하기
		4. 2, 3 숫자 비교해서 승패 결정하기
		5. i) 숫자 -> 가위바위보로 변경해서 출력
		  ii) 승패 출력
	 */


	public static void main (String[] args) {
		ex07();
	}
	
		   // 문제1. 가위바위보
		   // 실행
		   // 가위바위보 >>> 가위
		   // 당신은 가위, 컴퓨터는 보, 이겼습니다.
		   // Hint : 가위는 0, 바위는 1, 보는 2로 처리한다.
	public static void ex01() {
			   
			   String[] player = {"가위", "바위", "보"};
			   
			   // 1번
			   Scanner sc = new Scanner(System.in);
			   System.out.println("가위바위보 >>>");

			   // 2번
			   int idx2;
			   switch (sc.next()) {
			   case "가위" : idx2 = 0; break;
			   case "바위" : idx2 = 1; break;
			   default : idx2 = 2;
			   }
//			   0 - 2 = -2
//			   1 - 0 = 1
//			   2 - 1 = 1
			   // 3번
			   int idx1 = (int)(Math.random()*3);		   
		      
		      // 4번
		      String result = null;
		      switch (idx2 - idx1) {
		      case 0: result = "비겼습니다";
		      break;
		      case -2:
		      case 1 : result = "이겼습니다";break;
		      default : result = "졌습니다";
		      } 
		      
		      // 5번
		     System.out.println("당신은 " + player[idx2] + ", 컴퓨터는 " + player[idx1] + ", " + result);
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
	      int random = (int) ((Math.random() * 10000) + 1);
	      int count = 0;
	      int result = 0;
	      while(true) {
	         
	         System.out.println("입력 >>> ");
	         result = sc.nextInt();
	         count++;
	         
	         if(result < 1 || result > 10000) {
	            count--;
	            System.out.println("다시 입력하시오.");
	         }else if(result > random) {
	            System.out.println("Down!");
	         }else if(result < random){
	            System.out.println("up!");
	         }else if(result == random) {
	            System.out.println("정답. 총 " + count + "번만에 성공.");
	            break;
	         }
	      }
	   }
	
	//문제10. Scanner 클래스의 next() 메소드를 이용해서 사람 이름을 입력 받은 뒤
	// 친구의 이름이면 "반갑다 친구야"를 출력하고, 모르는 사람의 이름이면 "처음 뵙겠습니다"를 출력하시오.
	// 친구의 이름을 String[] friend 배열에 저장한 뒤 작업을 수행하시오.
	// 예시1
	// 이름 입력 >>> 정우성
	// 반갑다 친구야
	// 예시2
	// 이름 입력 >>> 유재석
	// 처음 뵙겠습니다
	public static void ex03() {
	   
	   String[] friends = {"정우성","송강","차은우"};
	   String name = "";
	   
	   Scanner sc = new Scanner(System.in);
	   System.out.println("이름 입력 >>>");
	   name = sc.next();
	   if(friends[0].equals(name) || name.equals(friends[1])) {
	      System.out.println("반갑다 친구야");
	   } else {
	      System.out.println("처음 뵙겠습니다.");
	   }
	   sc.close();
	}
	
	/*
	   문제8. installer의 CodingFonts.zip 파일을 
	   		 storage폴더로 Fonts.zip으로 복사하시오.
	 */
	public static void ex04() {
		
		File from = new File("/Users/woomin/Documents/GDJ61/installer", "CodingFonts.zip");
		File to = new File("/Users/woomin/Documents/storage", "Fonts2.zip");
		
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
		
		
		try {
			bis = new BufferedInputStream(new FileInputStream(from));
			bos = new BufferedOutputStream(new FileOutputStream(to));
			byte[] b = new byte[1024]; // 1키로바이트씩 이동
			
			int readByte = 0;
			
			/*	
			         만약 {1,2,3,4,5,6,7,8,9,10} 을 다 넣어주어야한다고 가정했을 때 7byte씩 들어간다고 하면
			 		 {1,2,3,4,5,6,7}이 들어가면 {8,9,10}이 남는데 여기서 bis.read(b) 이게 있으므로 {4,5,6,7,8,9,10}이
			 		 들어와서 들어왔던 값은 반환되는 코드를 입력하는 것.
			*/
			
			while((readByte = bis.read(b)) != -1) {		
				bos.write(b, 0, readByte);
			}
			
			System.out.println("복사");
			
			
		}catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				if(bos != null && bis != null) {
					bis.close();
					bos.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
				
	}

//문제3. 자동으로 진행되는 윷 던지기를 구현하시오. 윷이나 모가 나오면 추가로 던지시오.
	// 예시)
	// "도", 1칸 이동한다.
	// "개", 2칸 이동한다.
	// "걸", 3칸 이동한다.
	// "윷", "도", 5칸 이동한다.
	// "모", "윷", "도", 10칸 이동한다.
	public static void ex05() {
		boolean run = true;
		String[] yut = {"", "도", "개", "걸", "윷", "모"};
		int move = 0;
		while(true) {
			int num = (int)(Math.random() * 5 + 1);
			switch(num) {
			case 1: case 2: case 3:
				move += num;
				System.out.print("\"" + yut[num] + "\", " + move + "칸 이동한다.");
				return;
			case 4: case 5:
				move += num;
				System.out.print("\"" + yut[num] + "\", ");
				break;
			}
		}
	}
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
		public static void ex06() {
		      int balance = 5000;
		      int count = 0;
		      
		      while(balance > 0) {
		    	  count++;
		    	  int withdraw = (int)(Math.random()* balance) + 1;
		    	  System.out.println("출금 전 " + balance + "원, " + count + "회 출금액" + withdraw + "원, 출금 후" + (balance -= withdraw) + "원");
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
		public static void ex07() {

			Scanner sc = new Scanner(System.in);
			int count = 0;
			
			int answer = (int)(Math.random() * 10000) +1;
			while(true) {
				System.out.println("입력 >>>");
				int input = sc.nextInt();
				count++;
				
				if(answer < input) {
					System.out.println("Down !@#!");
				} else if(answer > input) {
					System.out.println("Up !@#!$");
				} else {
					System.out.println(" 정답. 총" + count + "번만에 성공.");
				}
			}
			
		}
	}

