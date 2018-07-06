package array.multi;

import java.util.Scanner;

/**
 * 3명의 양궁선수가 맞힌 과녁의 점수를 각각 
 * 차시(9차시까지) 별로 배열로 입력하고
 * 전체 합산 점수가 가장 높은 선수의 인덱스와 점수를 출력
 * @author PC38209
 *
 */
public class ArcheryScore {

	public static void main(String[] args) {

		// 1. 선언
		Scanner scan;
		int[][] score;
		int[] sum;
		int max;
		
		// 2. 초기화
		scan = new Scanner(System.in);
		score = new int[3][9]; 
		sum = new int[3];
		max = 0;
		
		// 3. 사용
		// 각 선수별로 과녁 점수를 입력받아 배열에 저장
		System.out.println("양궁 선수 점수 입력");
		for (int idx = 0; idx < score.length; idx++) {
			System.out.print((idx+1) + "번째 선수 점수 입력 :");
			for (int idx2 = 0; idx2 < score[idx].length; idx2++) {
				score[idx][idx2] = scan.nextInt();
				sum[idx] += score[idx][idx2];

			} // end for idx2	
			
			if (max < sum[idx]) {
				max = sum[idx];
			} // end if
		} // end for idx
		System.out.println("우승 선수");
		
		for (int idx = 0; idx < score.length; idx++) {
			for (int idx2 = 0; idx2 < score[idx].length; idx2++) {
			} // end if idx2
			if (max == sum[idx]) {
			System.out.printf("우승 선수는 %d점의 %d번째 선수입니다.%n", max, idx+1);
			} // end if
			continue;
		} // end if idx
	}

}




// 10 9  8  10 9  9  10 10 10  => 50 27 8 = 85
// 9  10 10 10 9  9  9  10 10  => 50 36   = 86
// 8  7  10 10 10 10 10 10 10  => 70 15   = 85





















