package study;

public class MainClass {

	public static void main(String[] args) {
		
		// 문제8. 점수에 따라 가져갈 수 있는 모든 사은품을 출력하시오.
		// 점수가 60점 이상인 경우 : "행주"
		// 점수가 70점 이상인 경우 : "행주", "도마"
		// 점수가 80점 이상인 경우 : "행주", "도마", "식칼"
		// 점수가 90점 이상인 경우 : "행주", "도마", "식칼", "냄비"
		// 예시
		// 행주도마
		String[] arr = {"행주","도마","식칼","냄비"};
		int score = 75;
		
		int k = 0;
		if(score >= 90) k=4;
		else if(score >= 80) k=3;
		else if(score >= 70) k=2;
		else if(score >= 60) k=1;
		
		for(int i = 0; i < k; i++) {
			System.out.println(arr[i]);
		}
		
		
		
		if(score >= 90) {
			for(int i = 0; i < 4; i++) {
				System.out.println(arr[i]);
			} 
		}	else if(score >= 80) {
				for(int i = 0; i < 3; i++) {
					System.out.println(arr[i]);
				}
			} else if(score >= 70) {
				for(int i = 0; i < 2; i++) {
					System.out.println(arr[i]);
				}
			} else if(score >= 60) {
				for(int i = 0; i < 1; i++) {
					System.out.println(arr[i]);
				}
			}
		
		

		
		
		
		
	}	
}	
