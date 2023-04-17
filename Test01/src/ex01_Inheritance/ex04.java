package ex01_Inheritance;

import java.util.Random;
import java.util.Scanner;

public class ex04 {

	
	public static void main(String[] args) {
		
	      Scanner sc = new Scanner(System.in);
	      Random rnd = new Random();
	      
	      int com, me, cnt;
	      
	      com = rnd.nextInt(100) + 1;
	      cnt = 0;
	      
	      while(true) {      
	         me = inputMe(sc); 
	         cnt++; 
	         
	         String result = "";
	         if (com > me)
	            result = "UP";
	         else if(com < me)
	            result = "DOWN";
	         else
	         {
	            result = "정답";
	            break;   
	         }
	         System.out.printf("결과: %s\n", result); 
	      }
	      
	      System.out.printf("%d번만에 정답(%d)을 맞추셨습니다.", cnt, com);
	      System.out.println();
	      System.out.println("게임을 다시 하시겠습니까?");   
	      
	      sc.close();
	      
	   }
	   
	   public static int inputMe(Scanner sc)
	   {      
	      int me = 0;
	      
	      while(true) 
	      {
	         System.out.print("숫자 입력(1~100): "); 
	         String temp = sc.nextLine();
	         
	         if (isNumeric(temp))
	         {
	            me = Integer.parseInt(temp);
	            if (me < 1 || me > 100)
	               System.out.println("숫자(1~100)를 입력하세요.");
	            else
	               break;
	         }
	         else
	            System.out.println("숫자(1~100)를 입력하세요.");
	      }   
	      return me;
	   }   
	      
	   public static boolean isNumeric(String str)
	   {
	      if (str != null && str.matches("[0-9]+")) //정규표현식
	      {
	         return true;
	      }
	      else
	      {
	         return false;
	      }
	   }
	
		

	}


