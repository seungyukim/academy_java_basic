package shoes.map;

public class Shoe {

	// 1. 멤버 변수 선언부
	/** 신발 제품코드 */
	String shoeCode;
	/** 신발 제품 명 */
	String shoeName;
	/** 신발의 사이즈 */
	int size;
	/** 가격 */
	int price;
	/** 신발의 타입 (운동화, 샌들, 구두, 슬리퍼, 부츠 등) */
	String type;
	/** 재고수량 */
	int quantity;
	
	// 2. 생성자 선언부
	/** 기본 생성자 */
	Shoe() {
		
	}
	
	/** 
	 * shoeCode 필드만을 갖는 생성자 
	 * @param shoeCode
	 */
	Shoe(String shoeCode) {
		 this();
		 this.shoeCode = shoeCode;
	}
	
	/**
	 * shoeCode, shoeName 필드를 갖는 생성자
	 * @param shoeCode
	 * @param shoeName
	 */
	Shoe(String shoeCode, String shoeName) {
		 this(shoeCode);
		 this.shoeName = shoeName;
	}
	
	/**
	 * shoeCode, shoeName, size 필드를 갖는 생성자
	 * @param shoeCode
	 * @param shoeName
	 * @param size
	 */
	Shoe(String shoeCode, String shoeName, int size) {
		 this(shoeCode, shoeName);
		 this.size = size;
	}
	
	/**
	 * shoeCode, shoeName, size, price 필드를 갖는 생성자
	 * @param shoeCode
	 * @param shoeName
	 * @param size
	 * @param price
	 */
	Shoe(String shoeCode, String shoeName, int size, int price) {
		 this(shoeCode, shoeName, size);
		 this.price = price;
	}
	
	/**
	 * shoeCode, shoeName, size, price, type 필드를 갖는 생성자
	 * @param shoeCode
	 * @param shoeName
	 * @param size
	 * @param price
	 * @param type
	 */
	Shoe(String shoeCode, String shoeName, int size, int price, String type) {
		 this(shoeCode, shoeName, size, price);
		 this.type = type;
	}
	
	/**
	 * 모든 필드를 갖는 생성자
	 * @param shoeCode
	 * @param shoeName
	 * @param size
	 * @param price
	 * @param type
	 * @param quantity
	 */
	public Shoe(String shoeCode, String shoeName, int size, int price, String type, int quantity) {
		 this(shoeCode, shoeName, size, price, type);
		 this.quantity = quantity;
	}

	// 각 필드의 접근자 / 수정자 메소드 
	/** 
	 * shoeCode의 접근자
	 * @return
	 */
	public String getShoeCode() {
		return shoeCode;
	}

	/**
	 * shoeCode의 수정자
	 * @param shoeCode
	 */
	public void setShoeCode(String shoeCode) {
		this.shoeCode = shoeCode;
	}

	/**
	 * shoeName의 접근자
	 * @return
	 */
	public String getShoeName() {
		return shoeName;
	}

	/**
	 *shoeName의 수정자
	 * @param shoeName
	 */
	public void setShoeName(String shoeName) {
		this.shoeName = shoeName;
	}

	/**
	 * size의 접근자
	 * @return
	 */
	public int getSize() {
		return size;
	}

	/**
	 * size의 수정자
	 * @param size
	 */
	public void setSize(int size) {
		this.size = size;
	}

	/**
	 * price의 접근자
	 * @return
	 */
	public int getPrice() {
		return price;
	}

	/**
	 * price의 수정자
	 * @param price
	 */
	public void setPrice(int price) {
		this.price = price;
	}

	/**
	 * type의 접근자
	 * @return
	 */
	public String getType() {
		return type;
	}

	/**
	 * type의 수정자
	 * @param type
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * quantity의 접근자
	 * @return
	 */
	public int getQuantity() {
		return quantity;
	}

	/**
	 * quantity의 수정자
	 * @param quantity
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	// 3. 메소드 선언부
	/** 출력 */
	public void print() {
		System.out.printf("신발 정보 [제품코드 : %s, 제품명 : %s, 사이즈 : %d, 가격 : %,, 타입 : %s, 재고수량 : %s,"
		         + shoeCode, shoeName, size, price, type, quantity);
	}
	
	// shoeCode 기준 equals(), hashCode() 재정의
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((shoeCode == null) ? 0 : shoeCode.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Shoe other = (Shoe) obj;
		if (shoeCode == null) {
			if (other.shoeCode != null)
				return false;
		} else if (!shoeCode.equals(other.shoeCode))
			return false;
		return true;
	}
	
	// toString() 재정의
	@Override
	public String toString() {
		String strShoe = String.format(
				"신발 정보 [제품코드 : %s, 제품명 : %s, 사이즈 : %d, 가격 : %,, 타입 : %s, 재고수량 : %s,"
				         + shoeCode, shoeName, size, price, type, quantity);
		return strShoe;
	}

	
	
	

}
