package ex02_two_dim;

public class Ex01_array {
	
	public static void ex01() {
		
		// 2차원 배열 선언
		int[][] arr;
		
		// 2차원 배열 생성
		arr = new int[3][2];  // 3행 2열(길이가 2인 배열이 3개가 있다.)
		
		// 2차원 배열 순회
		for(int i = 0; i < 3; i ++) {  // i : 행 번호
			for(int j = 0; j < 2; j++) {  // j : 열 번호
				System.out.print(arr[i][j] + "\t");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		ex01();

	}

}
