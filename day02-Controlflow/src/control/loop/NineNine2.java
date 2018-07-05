package control.loop;

public class NineNine2 {

	public static void main(String[] args) {

		for (int stage = 2; stage <= 9; stage+=3) {
			
			if (stage < 7) {
			System.out.printf("%n%d단                     %d단                     %d단%n", stage, stage+1, stage+2);
			} else {
				System.out.printf("%n%d단                     %d단%n", stage, stage+1);				
			}
			
			for (int times = 1; times <= 9; times++) {
			
				if (stage < 7) {
				System.out.printf("%d x %d = %2d   %d x %d = %2d   %d x %d = %2d%n"
						         , stage, times, stage*times
						         , stage+1, times, (stage+1)*times
						         , stage+2, times, (stage+2)*times);
				} else {
					System.out.printf("%d x %d = %2d   %d x %d = %2d%n"
					         , stage, times, stage*times
					         , stage+1, times, (stage+1)*times);
				}
			} //end for 내부
		} // end for 외부
	}

}
