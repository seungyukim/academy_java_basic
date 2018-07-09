package practice.methods;

public class DefineMethodsTest {

	public static void main(String[] args) {

		// 1. 선언
		DefineMethods methods;
		
		// 2. 초기화
		methods = new DefineMethods();
		
		// 3. 사용
		methods.printTenTimes(7);
		System.out.println("============================");

		methods.printSomebodysMessage("너 자신을 알라", "소크라테스");
		System.out.println("============================");

		methods.printMessage("너 자신을 알거라");
		System.out.println("============================");

		String message = methods.returnOriginalMessage("너 자신을 알았느냐");
		System.out.printf("%s%n", message);
		System.out.println("============================");

		int result = methods.addTen(7);
		System.out.printf("%d%n", result);
		System.out.println("============================");

		result = methods.substractTen(7);
		System.out.printf("%d%n", result);		
		System.out.println("============================");

		double dResult = methods.makeDouble(7.0);
		System.out.printf("%5.2f%n", dResult);		
		System.out.println("============================");

		dResult = methods.substractFivePointFive(7.0);
		System.out.printf("%5.2f%n", dResult);		
		System.out.println("============================");

		String fullName = methods.makeFullName("그리즈만", "앙트완");
		System.out.printf("%s%n", fullName);		
		System.out.println("============================");

		result = methods.add(7, 10);
		System.out.printf("%d%n", result);		
		System.out.println("============================");

		dResult = methods.add(7.0, 10.0);
		System.out.printf("%5.2f%n", dResult);		
		System.out.println("============================");

		methods.printMsgManyTimes("가즈아", 7);
		System.out.println("============================");

		methods.arithmetic("+", 7, 10);
		System.out.println("============================");

		dResult = methods.arithmetic2("+", 7, 10);
		System.out.println("============================");

		Boolean bResult = methods.isEven(7);
		System.out.printf("%b%n", bResult);		
		System.out.println("============================");

		result = methods.absolute(7);
		System.out.println("============================");

		methods.findMultiple(76);;
		System.out.println("============================");

		String sResult = methods.decideSign(7);
		System.out.printf("%s%n", sResult);				
		System.out.println("============================");

		methods.repeatedMessage("가즈앗", 7);;
		System.out.println("============================");

		dResult = methods.calcCircleArea(7);
		System.out.printf("%5.2f%n", dResult);	
		System.out.println("============================");

		/*methods.makeMultipleNumes(88);*/
		
	}

}
