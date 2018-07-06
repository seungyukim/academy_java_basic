package array.multi;

import java.util.Scanner;

/**
 * 야구 구단의 1 ~ 5 선발 선수의 방어율을 입력하고 
 * 그 중 가장 방어률이 낮은 최고의 투수를 찾는 클래스
 * 
 * @author PC38209
 *
 */
public class BestPitcher {

	public static void main(String[] args) {

		// 1. 선언
		Scanner scan;
		double[][] ERA;
		double min;
		
		// 2. 초기화
		scan = new Scanner(System.in);
		ERA = new double[3][5];
		min = 10.0;
		
		// 3. 사용
		// 각 팀별로 각 투수의 방어율 입력받아 배열에 저장한다.
		System.out.println("1선발 2선발 3선발 4선발 5선발 방어율 입력");
		for (int idx = 0; idx < ERA.length; idx++) {
			System.out.print((idx+1) + "번째 팀 1~5선발 투수 방어율 : ");
			for (int idx2 = 0; idx2 < ERA[idx].length; idx2++) {
				ERA[idx][idx2] = scan.nextDouble();	
				if (min > ERA[idx][idx2]) {
					min = ERA[idx][idx2];
				}
			} // end for 내부
		} // end for 외부
		
		System.out.println("최고의 투수는");
		
		for (int idx = 0; idx < ERA.length; idx++) {			
			for (int idx2 = 0; idx2 < ERA[idx].length; idx2++) {
				if (ERA[idx][idx2] == min) {
					System.out.printf("방어율 %5.2f의 %d팀 %d선발 투수입니다. %n", min, idx+1, idx2+1);					
				} // end if
				continue;
			} // end for 내부
		} // end for 외부
	}

}










