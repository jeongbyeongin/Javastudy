package ex02_random;
import java.security.SecureRandom;

public class Ex03_SecureRandom {

	public static void main(String[] args) {  // 보안이 필요한 랜덤
		
		// java.security.SecureRandom
		
		SecureRandom secureRandom = new SecureRandom();
		
		// 정수 난수
		int dice = secureRandom.nextInt(6) + 1;  // 주사위 1 ~ 6
		System.out.println(dice);

	}

}
