package control.switchstmt;

import java.util.Scanner;

/**
 * switch 구문을 사용하여 다음의 기준으로
 * 90점 이상 A
 * 80 ~ 89 B
 * 60 ~ 79 C
 * 40 ~ 59 D
 * 나머지 F
 * 
 * 입력된 점수에 대해 학점을 계산하는 클래스를 작성
 * 입력 int 타입 변수명 score
 * 학점 char 타입 변수명 grade 을 사용할 것
 * @author PC38209
 *
 */
public class ReportGrade {

	public static void main(String[] args) {

		// 1. 선언
		int score;
		char grade;
		
		Scanner scan;
		
		// 2. 초기화
		scan = new Scanner(System.in);
		
		System.out.println("점수를 입력해주세요.(0 ~ 100 사이의 정수)");
		score = scan.nextInt();
		
		// 3. 사용
		switch ((score/10)*10) {
		case 100:
		case 90:
			grade = 'A';
			break;
			
		case 80:
			grade = 'B';
			break;
			
		case 70:
		case 60:
			grade = 'C';
			break;
			
		case 50:
		case 40:
			grade = 'D';
			break;
			
		default:
			grade = 'F';
			break;
		} // end swith
		
		// 출력
		System.out.printf("입력하신 점수 %d에 해당하는 등급은 %c입니다. %n", score, grade);
	} // end main

} // end class
