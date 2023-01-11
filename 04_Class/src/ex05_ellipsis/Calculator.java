package ex05_ellipsis;

public class Calculator {

	/*
		매개변수 생략
		1. 전달 되는 인수의 개수가 정해지지 않은 경우에 사용한다.
		2. 말 줄임표(...)를 활용한다.
		3. 실제로는 배열로 처리된다.
	*/
	
	double addition(double... numbers) {  //  ... 후에 오는거는 배열로 인식하면됨 .(numbers) 는 배열로 처리된다.
		double total = 0.0;
		for(int i = 0; i < numbers.length; i++) {
			total += numbers[i];
		}
		return total;
	}
	
	
	
	
}
