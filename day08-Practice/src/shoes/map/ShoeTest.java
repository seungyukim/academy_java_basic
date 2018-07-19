package shoes.map;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class ShoeTest {

	public static void main(String[] args) {
		
		// 1. 선언, 2. 초기화
		Shoe nike = new Shoe("SH001", "마지스타 오브라 2 프로 ", 260, 125940, "축구화", 8);
		Shoe lacoste = new Shoe("SH002", "유로파 TCL SPM", 250, 121500, "운동화", 25);
		Shoe chubasco = new Shoe("SH003", "아즈텍", 240, 80100, "샌들", 30);
		Shoe adidas = new Shoe("SH004", "듀라모 슬라이드 K", 270, 29900, "슬리퍼", 4);
		
		// (3) Map<Shoe> shoes 를 선언하여 put(code, shoe)로 추가
		Map<String, Shoe> shoes = new HashMap<>();
		
		shoes.put(nike.getShoeCode(), nike);
		shoes.put(lacoste.getShoeCode(), lacoste);
		shoes.put(chubasco.getShoeCode(), chubasco);
		shoes.put(adidas.getShoeCode(), adidas);
		
		// 3. 사용
		// 각 자료구조별 shoes 를 foreach 로 출력
		// (.1) 맵의 키 전체를 먼저 얻어야 함
		// (.2) 얻어진 키로 get(k) 를 반복수행

		Set<String> shoeKeys = shoes.keySet();

		for (String key: shoeKeys) {
			Shoe shoe = shoes.get(key);
			shoe.print();
		}
		
		// SH003 번 코드로 등록된 신발의 정보 1개를 출력
		Shoe shoe = shoes.get("SH003");
		shoe.print();
		
		// SH003 번 코드로 등록된 신발의 정보에서 재고를 0으로 조정 
		
		
		// 재고가 조정된 내용 출력
		
		
		// SH003 번 코드로 등록된 신발 정보를 삭제
		
		
		// 삭제된 신발의 정보가 shoes 에 없는 것을 출력(전체 출력)
		
	}

}
