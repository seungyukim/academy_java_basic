package shoes.list;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import shoes.list.Shoe;


public class ShoeTest {

	public static void main(String[] args) {

		// 1. 선언, 2. 초기화
		Shoe nike = new Shoe("SH001", "마지스타 오브라 2 프로 ", 260, 125940, "축구화", 8);
		Shoe lacoste = new Shoe("SH002", "유로파 TCL SPM", 250, 121500, "운동화", 25);
		Shoe chubasco = new Shoe("SH003", "아즈텍", 240, 80100, "샌들", 30);
		Shoe adidas = new Shoe("SH004", "듀라모 슬라이드 K", 270, 29900, "슬리퍼", 4);

		// (1) Shoe 타입을 저장할 수 있는 List<Shoe> shoes 를 선언하여 리스트에 add(shoe) 로 추가 
		List<Shoe> shoes = new ArrayList<Shoe>();
		
		shoes.add(nike);
		shoes.add(lacoste);
		shoes.add(chubasco);
		shoes.add(adidas);
		
		// 3. 사용
		// 각 자료구조별 shoes 를 foreach 로 출력
		for (Shoe shoe: shoes) {
			System.out.println(shoe);
		}
		
		// SH003 번 코드로 등록된 신발의 정보 1개를 출력
		for (Shoe shoe: shoes) {
			if (shoe.getShoeCode().equals("SH003")) {
				System.out.println(shoe);
			}
		}
		
		// SH003 번 코드로 등록된 신발의 정보에서 재고를 0으로 조정 
		Shoe chubasco2 = new Shoe("SH003", "아즈텍", 240, 80100, "샌들", 0);
		shoes.set(2, chubasco2);
		
		// 재고가 조정된 내용 출력
		for (Shoe shoe: shoes) {
			if (shoe.getShoeCode().equals("SH003")) {
				System.out.println(shoe);
			}
		}
		
		// SH003 번 코드로 등록된 신발 정보를 삭제
		shoes.remove(new Shoe("SH003", null, 0, 0, null, 0));
		
		// 삭제된 신발의 정보가 shoes 에 없는 것을 출력(전체 출력)
		for (Shoe shoe: shoes) {
			shoe.print();
		}
	}

}
