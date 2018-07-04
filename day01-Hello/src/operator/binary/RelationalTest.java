package operator.binary;

/**
 * 관계연산자 : 대소비교, 등가비교 연산자를 테스트
 * 대소비교 : >, <, >=, <=
 * 등가비교 : == , !=
 * 
 * 관계 연산의 결과는 boolean 타입으로 얻어짐
 * @author PC38209
 *
 */
public class RelationalTest {

	public static void main(String[] args) {

		// 1. 선언, 2. 초기화
		int a = 1;
		int b = -5;
		
		// 3. 사용
		System.out.printf("(%d == %d) : %b%n", a, b, (a == b));		
		System.out.printf("(%d != %d) : %b%n", a, b, (a != b));

		System.out.printf("(%d < %d)  : %b%n", a, b, (a < b));
		System.out.printf("(%d > %d)  : %b%n", a, b, (a > b));
		System.out.printf("(%d <= %d) : %b%n", a, b, (a <= b));
		System.out.printf("(%d >= %d) : %b%n", a, b, (a >= b));
		/* -------------------------------------
		 * printf() 메소드에서 사용하는ㅋ트링의 종류
		 * -------------------------------------
		 * %d : 정수 표기, decimal 의 약자
		 * %f : 실수 표기, float 의 약자
		 * %b : boolean값 표기, boolean 의 약자
		 * %s : 문자열 표기, String 의 약자
		 * %x : 16진수 표기, hexa 의 약사
		 * 
		 * %% : %기호 자체를 출력
		 * %n : new-line, 엔터키 입력과 같은 효과
		 * -------------------------------------
		 */
		
		// 라인 카피 : ctrl + alt + up/down
		// 라인 이동 : alt + up/down
		// 세로 편집 모드 진입 토글 : alt + shift + a
	}

}
