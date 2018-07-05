package control.loop;

public class SquareTable {

	public static void main(String[] args) {

		for (int number = 1; number <= 10; number++) {
			System.out.printf("%5d x %5d = %5d%n", number, number, number*number);
		}
	}

}
