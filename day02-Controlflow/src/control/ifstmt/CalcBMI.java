package control.ifstmt;

import java.util.Scanner;

public class CalcBMI {

	public static void main(String[] args) {

		// 1. 선언
		double weight;
		double height;
		
		Scanner scan;
		
		double bmi;
		String pan;
		
		// 2. 초기화
		scan = new Scanner(System.in);
		
		System.out.println("키(cm)와 몸무게(kg)를 입력해주세요. 예) 180 70");
		height = scan.nextDouble() / 100;
		weight = scan.nextDouble();
		
		bmi = weight / (height*height);
		
		// 3. 사용
		if (bmi < 15.0) {
			pan = "병적인 저체중";
		} else if (bmi >= 15.0 && bmi < 18.5) {
			pan = "저체중";
		} else if (bmi >= 18.5 && bmi < 23.0) {
			pan = "정상";
		} else if (bmi >= 23.0 && bmi <= 27.5) {
			pan = "과체중";
		} else if (bmi > 27.5 && bmi <= 40.0) {
			pan = "비만";
		} else {
			pan = "병적인 비만";
		} // end if-else
		
		// 출력
		System.out.printf("당신의 BMI는 %f이며, 비만도는 %s 판정입니다.%n", bmi, pan);
	}

}
