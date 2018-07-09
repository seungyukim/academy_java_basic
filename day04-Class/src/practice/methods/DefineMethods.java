package practice.methods;

public class DefineMethods {

		/**
		정수(input) 하나를 메소드 아규먼트로 입력 받아서 
		입력된 정수부터 10씩 증가하는 숫자를 10번 출력하는 메소드를 작성하시오.
		printTenTimes 
		*/

		public void printTenTimes(int input) {
			for (int idx=1; idx <= 10; idx++){
				input += 10;
				System.out.println(input);
			}
		}

		/**
		메시지(message)와 이름(name)을 메소드 아규먼트로 입력받아
		name 의 메시지 message ... 를 출력하는 메소드
		printSomebodysMessage를 작성
		*/

		public void printSomebodysMessage(String message, String name) {
			System.out.printf("%s의 메시지 : %s...%n", name, message);
		}

		/**
		String 타입의 메시지(message)를 메소드 아규먼트로 입력받아서
		그 메시지를 출력하는 메소드
		printMessage를 작성
		*/

		public void printMessage(String message) {
			System.out.println(message);
		}

		/**
		String 타입의 메시지(message)를 메소드 아규먼트로 받아서 
		그 메시지를 그대로 리턴하는 메소드
		returnOriginalMessage를 작성
		*/

		public String returnOriginalMessage(String message) {
			return message;
		}

		/**
		정수(input) 하나를 메소드 아규먼트로 입력 받아서 
		입력된 input + 10 을 계산하여 리턴하는 메소드
		addTen 을 작성
		*/

		public int addTen(int input) {
			input += 10;
			return input;
		}

		/**
		정수(input) 하나를 메소드 아규먼트로 입력 받아서
		입력된 input - 10 을 계산하여 리턴하는 메소드
		substractTen을 작성
		*/
		public int substractTen(int input) {
			input -= 10;
			return input;
		}

		/**
		실수(input) 하나를 메소드 아규먼트로 입력 받아서
		입력된 input*2을 계산하여 리턴하는 메소드
		makeDouble 을 작성
		*/

		public double makeDouble(double input) {
			input = input * 2;
			return input;
		}

		/**
		실수(input) 하나를 메소드 아규먼트로 입력 받아서 
		입력된 input - 5.5 를 계산하여 리턴하는 메소드
		substractFivePointFive를 작성
		*/
		public double substractFivePointFive(double input) {
			input = input - 5.5;
			return input;
		}

		/**
		이름(name), 성(surname) 순서로 메소드 아규먼트로 입력받아
		성 이름 순서로 조합하여 리턴하는 메소드
		makeFullName 이라는 메소드를 작성하시오.
		*/

		public String makeFullName(String name, String surname) {
			String fullName;
			fullName = surname + name;
			return fullName;
		}

		/**
		두 개의 정수(x,y)를 메소드 아규먼트로 입력받아
		두 수를 더한 결과를 리턴하는 메소드 add를 작성하시오.
		*/

		public int add(int x, int y) {
			int result;
			result = x + y;
			return result;
		}

		/**
		두 개의 실수(x,y)를 메소드 아규먼트로 입력받아
		두 수를 더한 결과를 리턴하는 메소드 add를 작성하시오.
		*/

		public double add(double x, double y) {
			double result;
			result = x + y;
			return result;
		}

		/**
		메시지(messae)와 양의 정수(input)를 메소드 아규먼트로 입력받아
		메시지를 출력하되 입력된 input 의 숫자만큼 반복 출력하며
		현재의 반복 횟수를 같이 출력하는 메소드를 작성하시오,
		printMsgManyTimes
		*/

		public void printMsgManyTimes(String message, int input) {
			for (int idx = 1; idx <= input; idx++) {
				System.out.printf("%s, 현재 반복횟수 %d회%n", message, idx);
			}
		}

		/**
		사칙연산의 기호(+,-,*,/)가 입력될 연산자(operator)는 문자열로 
		피연산자(x,y)는 정수로 입력받아 기호에 따라 연산을 달리 수행하고
		연산 결과를 출력하는 메소드
		arithmetic 을 작성하시오.
		*/

		public void arithmetic(String operator, int x, int y) {
			double result = 0.0;
			if (operator == "+") {
				result = (double)x + y;
				System.out.println(result);
			} else if ( operator == "-") {
		 		result = (double)x - y;
				System.out.println(result);
			} else if ( operator == "*") {
		 		result = (double)x * y;
				System.out.println(result);
			} else if ( operator == "/") {
		 		result = (double)x / y;
				System.out.println(result);
			}
		}
				
		/**
		위의 메소드를 연산 결과를 double 타입으로 리턴하는 메소드로 변경하시오
		*/

		public double arithmetic2(String operator, int x, int y) {
			double result = 0.0;
			if (operator == "+") {
				result = (double)x + y;
			} else if (operator == "-") {
				result = (double)x - y;
			} else if (operator == "*") {
				result = (double)x * y;
			} else if (operator == "/") {
				result = (double)x / y;
			}
			
			return result;
		}

		/**
		정수(input) 하나를 메소드 아규먼트로 입력 받아서 
		짝수이면 true 를 홀수이면 false 를 리턴하는 홀짝판별 메소드
		isEven 메소드를 작성하시오
		*/

		public boolean isEven(int input) {
			boolean result = false;
			if (input % 2 == 0) {
				result = true;
			}

			return result;
		}

		public int absolute(int x) {
			if (x<0) {
				x = -x;
			}
			
			return x;
		}

		public void findMultiple(int x) {
			int result = 1;
			if(result == x) {
				System.out.println(result);
			} else {
				if(result <= 100) {
					result *= x;
					System.out.println(result);
				}
			}
		}

		public String decideSign(int x) {
			String result ="";
			if(x < 0) {
				result = "음의 정수";
			} else if(x == 0) {
				result = "정수 0";
			} else if(x > 0) {
				result = "양의 정수";
			} else {
				result = "잘못된 값을 넣으셨습니다.";
			}
			
			return result;
		}
			
		public void repeatedMessage(String message, int repeat) {
			String[] messages;
			messages = new String[repeat];
			for (int idx = 0; idx < repeat; idx++) {
				messages[idx] = message;
			} // 저장
			
			for (String in: messages) {
				System.out.println(in);
			} // 출력
		}
		
		public double calcCircleArea(int r) {
			double result = 0.0;
			result = 3.14 * r * r;
			
			return result;
		}
		
		/*public int[] makeMultipleNumes(int x) {
			
			return ;
		}*/

}
		
