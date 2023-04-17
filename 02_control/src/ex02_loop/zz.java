package ex02_loop;

public class zz {

	public static void main(String[] args) {
		
		int n = 144;
		int answer = 0;
		
		for(long i = 1; i < n; i++) {
			if(i * i == n) {
				answer = 1;
			} else {
				answer = 2;
			}
		}
		System.out.println(answer);

	}

}
