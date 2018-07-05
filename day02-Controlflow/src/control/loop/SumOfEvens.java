package control.loop;

import java.util.Scanner;

/**
 * 1 ~ 100 사이의 짝수의 합을 계산하는 클래스
 * while 을 활용
 * @author PC38209
 *
 */
public class SumOfEvens {

	public static void main(String[] args) {

		// 1. 선언, 2. 초기화
		int number = 1;
		int sum = 0;
		
		// 3. 사용
		while (number <= 100) {
			if (number % 2 == 0) {
				sum += number;
			}
			number++;
		} // end while
		
		System.out.printf("1 ~ 100 사이의 짝수의 합 : %d%n", sum);
	}

}
