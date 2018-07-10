package shop;

/**
 * 제품 판매 매장에서 관리하는 대상인
 * 제품을 정의하는 클래스
 * -----------------------------------------
 * 제품번호 : prodCode : String
 * 제품 명   : prodName : String
 * 가격       : price    : int
 * 재고수량 : quantity : int
 * -----------------------------------------
 * 기본생성자, 매개변수를 받는 생성자 각 필드 1개씩 늘려가며
 * 생성자 중복정의로 5개의 생성자를 정의 this, this() 사용
 * -----------------------------------------
 * 메소드
 * print() : void 
 *     ==> 제품의 상태 출력
 * discount(double percentage) : in
 *     ==> 입력된 퍼센트만큼 할인가격 리턴
 * 
 * sell(int amount) : void
 *     ==> 매장에서 판매(출고)되어 재고수량이 줄어듬
 * buy(int amount) : void
 *     ==> 매장에 입고되어 재고수량이 늘어남
 * 
 * set(String prodCode, String prodName, int price, int quantity) : void 
 *     
 * @author PC38209
 *
 */
public class Product {

	// 1. 매개변수 선언부
	/** 제품번호 */
	String prodCode;
	/** 제품 명 */
	String prodName;
	/** 가격 */
	int price;
	/** 재고수량 */
	int quantity;
	
	// 2. 생성자 선언부
	/**
	 * 기본 생성자
	 */
	Product() {
		
	}
	
	/**
	 * prodCode 필드만 초기화하는 생성자
	 * @param prodCode
	 */
	Product(String prodCode) {
		this.prodCode = prodCode;
	}
	
	/**
	 * prodCode, prodName 필드만 초기화하는 생성자
	 * @param prodCode
	 * @param prodName
	 */
	Product(String prodCode, String prodName) {
		this(prodCode);
		this.prodName = prodName;
	}
	
	/**
	 * prodCode, prodName, price 필드를 초기화하는 생성자
	 * @param prodCode
	 * @param prodName
	 * @param price
	 */
	Product(String prodCode, String prodName, int price) {
		this(prodCode, prodName);
		this.price = price;
	}
	
	/**
	 * 모든 필드를 초기화하는 생성자
	 * @param prodCode
	 * @param prodName
	 * @param price
	 * @param quantity
	 */
	Product(String prodCode, String prodName, int price, int quantity) {
		this(prodCode, prodName, price);
		this.quantity = quantity;
	}
	
	// 3. 메소드 선언부
	/** 출력 */
	public void print() {
		System.out.printf("제품 정보 [제품번호 : %s, 제품 명 : %s, 가격 : %d, 재고수량 : %d]%n", prodCode, prodName, price, quantity);
	}
	
	/** 할인가 : 입력된 퍼센트만큼 할인가격 리턴
	 * @param percentage : 할인률
	 * @return
	 */
	public int discount(double percentage) {
		// percentage > 0
		int price = this.price;
			
		if (percentage > 0) {
			price = (int)(this.price * (percentage / 100)); 
		}
		
		return price;
	}
	
	/** 판매 : 매장에서 판매(출고)되어 재고수량이 줄어듬
	 * @param amount : 판매량
	 */
	public void sell(int amount) {
		// 재고 수량이 출고하려는 수량보다 크거나 같을때만
		// 출고함.
		if (this.quantity >= amount) {
			this.quantity -= amount;
		}
	}
	
	/** 입고 : 매장에 입고되어 재고수량이 늘어남
	 * @param amount : 입고량
	 */
	public void buy(int amount) {
		// 입고된 만큼 재고수량 증가 후 저장반영
		this.quantity += amount;
	}
	
	/**
	 * 입력된 값으로 제품 정보를 수정하여 저장
	 * @param prodCode
	 * @param prodName
	 * @param price
	 * @param quantity
	 */
	public void set(String prodCode, String prodName, int price, int quantity) {
		
		if (!this.prodCode.equals(prodCode)) {
			this.prodCode = prodCode;
		}
		
		if (!this.prodName.equals(prodName)) {
			this.prodName = prodName;
		}
		
		if (this.price != price) {
			this.price = price;
		}
		
		if (this.quantity != quantity) {
			this.quantity = quantity;
		}
	}
}
